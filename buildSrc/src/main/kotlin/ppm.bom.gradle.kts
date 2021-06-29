plugins {
  `java-base`
  id("com.github.ben-manes.versions")
}

dependencyLocking {
  lockAllConfigurations()
}

repositories {
  mavenCentral()
}

configurations.configureEach {
  resolutionStrategy {
    componentSelection {
      all {
        if (!this@configureEach.name.matches(Regex("^spotbugs.*"))) {
          val nonRelease = Regex("^[\\d.]+-(M|ea|beta).*$")
          if (candidate.version.matches(nonRelease)) reject("no pre-release")
        }
      }
    }
  }
}

dependencies {
  modules {
    module("org.springframework.boot:spring-boot-starter-logging") {
      replacedBy("org.springframework.boot:spring-boot-starter-log4j2")
    }
  }
}
