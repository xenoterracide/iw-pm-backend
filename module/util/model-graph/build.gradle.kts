plugins {
  id("ppm.java-library")
}

dependencies {
  api(projects.util.model)
  implementation(libs.uuid.creator)
  implementation(libs.spring.boot.starter.neo4j)
}
