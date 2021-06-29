plugins {
  id("ppm.java-library")
}

dependencies {
  runtimeOnly(libs.spring.boot.starter.security)
  runtimeOnly(libs.spring.boot.starter.web)
  runtimeOnly(libs.spring.boot.starter.oauth2.client)
  testImplementation(libs.bundles.spring.test)
  testImplementation(libs.spring.boot.starter.web)
  testImplementation(libs.spring.boot.starter.webflux)
  testImplementation(libs.spring.security.core)
}
