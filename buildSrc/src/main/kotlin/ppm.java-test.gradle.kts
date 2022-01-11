import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.tasks.testing.logging.TestLogEvent
import java.io.FileNotFoundException

plugins {
  `java-library`
  `java-test-fixtures`
}

repositories {
  mavenCentral()
}
val libs = the<LibrariesForLibs>()

dependencies {
  runtimeOnly(libs.spring.boot.starter.log4j2)
  implementation(libs.log4j.api)
  testImplementation(libs.bundles.test)
  testRuntimeOnly(libs.junit.engine)
}

val available = tasks.register("tests available") {
  val ss = sourceSets;
  doLast {
    ss.getByName("test") {
      if (java.isEmpty) throw FileNotFoundException("no tests found")
    }
  }
}

tasks.test.configure {
  useJUnitPlatform()

  testLogging {
    lifecycle {
      showStandardStreams = true
      displayGranularity = 2
      events.addAll(listOf(TestLogEvent.STARTED, TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED))
    }
  }
  reports {
    html.required.set(false)
    junitXml.required.set(false)
  }
  inputs.dir(rootProject.file("buildSrc/src/main"))
  finalizedBy(available)

  afterSuite(
    KotlinClosure2<TestDescriptor, TestResult, Unit>(
      { descriptor, result ->
        if (descriptor.parent == null) {
          logger.lifecycle("Tests run: ${result.testCount}, Failures: ${result.failedTestCount}, Skipped: ${result.skippedTestCount}")
          if (result.testCount == 0L) throw IllegalStateException("You cannot have 0 tests");
        }
        Unit
      })
  )
}
