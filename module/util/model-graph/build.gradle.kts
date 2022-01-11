plugins { id("ppm.java-library") }

dependencies {
  api(projects.util.model)
  compileOnly(libs.api.guardian)
  compileOnly(libs.jsr305)
  implementation(libs.commons.lang)
  implementation(libs.uuid.creator)
  implementation(libs.spring.core)
  implementation(libs.spring.data.commons)
  implementation(libs.spring.data.neo4j)
  implementation(libs.vavr)
  testFixturesApi(libs.junit.api)
  testCompileOnly(libs.neo4j.driver)
  testImplementation(libs.equalsverifier)
  testFixturesRuntimeOnly(libs.spring.data.neo4j)
  testFixturesImplementation(libs.spring.context)
  testFixturesImplementation(libs.neo4j.driver)
  testFixturesImplementation(libs.neo4j.testcontainers)
  testFixturesImplementation(libs.testcontainers)
  /*
  testFixturesImplementation(libs.neo4j.test) {
    exclude( group = "org.junit.vintage", module = "junit-vintage-engine")
  }
  */
  testFixturesImplementation(libs.bundles.spring.test)
  testRuntimeOnly(projects.util.test)
  testImplementation(testFixtures(projects.util.modelGraph))
}
