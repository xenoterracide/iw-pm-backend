plugins {
  jacoco
  `java-base`
}


val verification = tasks.withType<JacocoCoverageVerification> {
  dependsOn(project.tasks.withType<Test>())
  violationRules {}
}

project.tasks.check.configure {
  dependsOn(verification)
}
