group = "com.xenoterracide"
version = "0.1.0-SNAPSHOT"

plugins {
  `kotlin-dsl`
}

repositories {
  gradlePluginPortal()
}

dependencyLocking {
  lockAllConfigurations()
}

dependencies {
  implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
  implementation(libs.plugin.spotless)
  implementation(libs.plugin.spotbugs)
  implementation(libs.plugin.errorprone)
  implementation(libs.plugin.gradle.v)
}
