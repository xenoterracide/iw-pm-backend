plugins {
  jacoco
  `java-base`
}

tasks.withType<JacocoReport> {
  dependsOn(project.tasks.withType<Test>())
}

val verification = tasks.withType<JacocoCoverageVerification> {
  dependsOn(project.tasks.withType<JacocoReport>())
  violationRules {
    rule {
      limit {
        minimum = 0.9.toBigDecimal()
      }
    }
  }
}

project.tasks.check.configure {
  dependsOn(verification)
}
