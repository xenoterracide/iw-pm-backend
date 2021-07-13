buildscript {
  repositories {
    mavenCentral()
  }
}

tasks.dependencies {
  dependsOn(subprojects.map { it.tasks.dependencies })
}
