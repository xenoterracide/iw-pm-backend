plugins {
  `java-library`
  id("ppm.bom")
  id("ppm.java-compile")
  id("ppm.java-test")
  id("ppm.checkstyle")
  id("ppm.spotbugs")
  id("ppm.spotless")
}

dependencies {
  runtimeOnly("org.springframework.boot:spring-boot-starter-log4j2")
}
