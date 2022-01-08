import org.gradle.accessors.dm.LibrariesForLibs

plugins {
  `java-library`
  `java-test-fixtures`
  id("com.github.ben-manes.versions")
}

dependencyLocking {
  lockAllConfigurations()
}

repositories {
  mavenCentral()
}
val libs = the<LibrariesForLibs>()

configurations.configureEach {
  exclude(group = "org.slf4j", module = "slf4j-nop")

  resolutionStrategy {
    componentSelection {
      all {
        if (!this@configureEach.name.matches(Regex("^spotbugs.*"))) {
          val nonRelease = Regex("^[\\d.]+-(M|ea|beta).*$")
          if (candidate.version.matches(nonRelease)) reject("no pre-release")
        }

        if (!this@configureEach.name.matches(Regex("^nullaway$"))) {
          val reason = "crash https://github.com/uber/NullAway/issues/533"
          if (candidate.version.matches(Regex("^0\\.9\\.[34]$"))) reject(reason)
        }
      }
    }
  }
}

dependencies {
  implementation(platform(libs.spring.platform))
  testFixturesImplementation(platform(libs.spring.platform))
  components.all<Neo4jAlignmentRule>()
  modules {
    module("org.springframework.boot:spring-boot-starter-logging") {
      replacedBy("org.springframework.boot:spring-boot-starter-log4j2")
    }
  }
}

abstract class Neo4jAlignmentRule : ComponentMetadataRule {
  override fun execute(ctx: ComponentMetadataContext) {
    ctx.details.run {
      val name = id.module.name
      val driver = name == "neo4j-java-driver"
      val harness = name == "neo4j-harness"
      if (driver || harness) {
        belongsTo("org.neo4j:neo4j-virtual-platform:${id.version}", true)
      }
    }
  }
}
