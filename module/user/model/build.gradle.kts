plugins { id("ppm.java-library") }

dependencies {
  implementation(projects.util.modelGraph)
  implementation(libs.spring.context)
  testRuntimeOnly(projects.util.test)
  implementation(libs.spring.boot.starter.neo4j)
}
