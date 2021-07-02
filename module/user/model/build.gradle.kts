plugins {
  id("ppm.java-library")
}

dependencies {
  testRuntimeOnly(projects.util.test)
  implementation(libs.spring.boot.starter.neo4j)
}
