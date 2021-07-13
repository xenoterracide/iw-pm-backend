plugins {
  id("com.github.jakemarsden.git-hooks").version("0.+")
}


gitHooks {
  setHooks(mapOf("pre-commit" to "spotlessApply"))
}

tasks.dependencies {
  dependsOn(subprojects.map { it.tasks.dependencies })
}
