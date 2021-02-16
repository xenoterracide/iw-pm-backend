plugins {
  `java-library`
}

dependencies {
  constraints {
    configurations.all {
      resolutionStrategy.eachDependency {
        if (requested.group === "org.immutables") useVersion("2.+")
      }
    }
  }
}
