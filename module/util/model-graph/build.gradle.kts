plugins { id("ppm.java-library") }

dependencies {
  api(projects.util.model)
  compileOnly(libs.api.guardian)
  compileOnly(libs.jsr305)
  implementation(libs.uuid.creator)
  implementation(libs.spring.core)
  implementation(libs.spring.data.commons)
  implementation(libs.spring.data.neo4j)
  implementation(libs.vavr)
  runtimeOnly(libs.spring.boot.starter.neo4j)
}
