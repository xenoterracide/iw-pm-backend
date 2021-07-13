tasks.dependencies {
  dependsOn(subprojects.map { it.tasks.dependencies })
}
