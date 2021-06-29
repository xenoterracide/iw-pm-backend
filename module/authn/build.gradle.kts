plugins {
  id("ppm.java-library")
}

dependencies {
  runtimeOnly("org.springframework.boot:spring-boot-starter-security")
  runtimeOnly("org.springframework.boot:spring-boot-starter-web")
  runtimeOnly("org.springframework.boot:spring-boot-starter-oauth2-client")
  testImplementation("org.springframework:spring-web")
  testImplementation("org.springframework.security:spring-security-core")
  testImplementation("org.springframework.boot:spring-boot-starter-webflux")
}
