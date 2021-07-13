import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun

group = "com.xenoterracide"

version = "0.1.0-SNAPSHOT"

plugins {
  id("ppm.java-library")
  id("org.springframework.boot").version("2.+")
  id("com.gorylenko.gradle-git-properties").version("2.2.4")
}

springBoot { buildInfo() }

tasks.withType<BootRun> { systemProperty("spring.profiles.active", "dev") }

tasks.withType<BootJar> { layered { isEnabled = true } }

dependencies {
  testRuntimeOnly(projects.util.test)
  developmentOnly(platform(libs.spring.platform))
  developmentOnly(libs.spring.boot.devtools)
  runtimeOnly(libs.spring.boot.starter.actuator)
  implementation(libs.spring.boot.starter.web)
  testImplementation(libs.spring.boot.starter.webflux)
  testImplementation(libs.bundles.spring.test)
  runtimeOnly(projects.authn)
}
