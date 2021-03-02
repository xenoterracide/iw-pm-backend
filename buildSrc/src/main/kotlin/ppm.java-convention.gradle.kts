import com.github.spotbugs.snom.Confidence
import com.github.spotbugs.snom.Effort
import com.github.spotbugs.snom.SpotBugsTask
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

group = "com.xenoterracide"
version = "0.1.0-SNAPSHOT"

plugins {
  id("ppm.java-library-compile")
  checkstyle
  // NOTE: external plugin version is specified in implementation dependency artifact of the project's build file
  id("com.github.spotbugs")
  id("com.diffplug.spotless")
}

repositories {
  mavenCentral()
}

dependencyLocking {
  lockAllConfigurations()
}

val sbv = "2.4.+"
dependencies {
  compileOnly(platform("org.springframework.boot:spring-boot-starter-parent:$sbv"))
  compileOnly("org.apache.logging.log4j:log4j-api")
  implementation(platform("org.springframework.boot:spring-boot-starter-parent:$sbv"))
  // Use JUnit Jupiter API for testing.
  testImplementation("org.springframework:spring-test")
  testImplementation("org.springframework.boot:spring-boot-test")
  testImplementation("org.springframework.boot:spring-boot-test-autoconfigure")
  testImplementation("org.junit.jupiter:junit-jupiter-api")
  testImplementation("org.junit.jupiter:junit-jupiter-params")
  testImplementation("org.assertj:assertj-core")
  testImplementation("org.mockito:mockito-core")
  // Use JUnit Jupiter Engine for testing.
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

configurations.all {
  resolutionStrategy.dependencySubstitution.all {
    requested.let {
      if (it is ModuleComponentSelector && it.module == "spring-boot-starter-logging") {
        useTarget("org.springframework.boot:spring-boot-starter-log4j2:${it.version}", "Use Log4j2 instead of Logback")
      }
    }
  }
}

tasks.test {
  // Use junit platform for unit tests.
  useJUnitPlatform()

  testLogging {
    lifecycle {
      showExceptions = true
      showStackTraces = true
      showStandardStreams = true
      exceptionFormat = TestExceptionFormat.FULL
      displayGranularity = 2
      events.addAll(listOf(TestLogEvent.STARTED, TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED))
    }
  }
  reports {
    html.isEnabled = false
    junitXml.isEnabled = true
  }
}

tasks.withType<Checkstyle>().configureEach {
  isShowViolations = true
  reports {
    html.isEnabled = false
    xml.isEnabled = false
  }
}

tasks.named<Checkstyle>("checkstyleMain") {
  configFile = file("config/checkstyle/main.xml")
}

tasks.named<Checkstyle>("checkstyleTest") {
  configFile = file("config/checkstyle/test.xml")
}

spotbugs {
  effort.set(Effort.MAX)
  reportLevel.set(Confidence.LOW)
}

tasks.withType<SpotBugsTask>().configureEach {
  reports.register("html") {
    enabled = true
  }
}

val header = "Copyright © \$YEAR Caleb Cushing. All rights reserved"
spotless {
  ratchetFrom = "HEAD"
  java {
    licenseHeader("/* $header */")
  }
  format("misc") {
    target("*.ts", "*.scss", "*.css")
    licenseHeader("/* $header */", "")
  }
  format("html") {
    target("*.html")
    licenseHeader("<!-- $header -->", "")
  }
  sql {
    target("src/main/resources/**/*.sql")
    licenseHeader("-- $header", "--liquibase formatted sql")
    dbeaver()
  }
}
