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
  testFixturesApi(libs.junit.api)
  testFixturesRuntimeOnly(libs.spring.data.neo4j)
  testFixturesImplementation(libs.spring.context)
  testFixturesImplementation(libs.neo4j.test)
  testFixturesImplementation(libs.spring.test)
  testRuntimeOnly(projects.util.test)
  testImplementation(libs.bundles.spring.test)
  testImplementation(libs.neo4j.test)
  testImplementation(testFixtures(projects.util.modelGraph))
  runtimeOnly(libs.spring.boot.starter.neo4j)
}
