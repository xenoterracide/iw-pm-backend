
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.tasks.testing.logging.TestLogEvent

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

tasks.test {
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



  afterSuite(
    KotlinClosure2<TestDescriptor, TestResult, Unit>(
      { descriptor, result ->
        if (descriptor.parent == null) {
          logger.lifecycle("Tests run: ${result.testCount}, Failures: ${result.failedTestCount}, Skipped: ${result.skippedTestCount}")
          if ( result.testCount == 0L ) {
            throw IllegalStateException("You cannot have 0 tests");
          }
        }
        Unit
      })
  )
}
