plugins {
  `java-library`
  id("ppm.bom")
  id("ppm.java-compile")
  id("ppm.java-test")
  id("ppm.checkstyle")
  id("ppm.spotless")
}

tasks.withType<Test> {
  enabled = false
}

tasks.withType<JacocoCoverageVerification> {
  enabled = false
}

dependencies {
  testRuntimeOnly(projects.util.test)
  runtimeOnly(libs.spring.boot.starter.security)
  runtimeOnly(libs.spring.boot.starter.web)
  runtimeOnly(libs.spring.boot.starter.oauth2.client)
  testImplementation(libs.bundles.spring.test)
  testImplementation(libs.spring.boot.starter.web)
  testImplementation(libs.spring.boot.starter.webflux)
  testImplementation(libs.spring.security.core)
  testCompileOnly(libs.javax.annotation)
}
