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
  implementation("com.diffplug.spotless:spotless-plugin-gradle:5.+")
  implementation(libs.plugin.spotbugs)
  implementation("net.ltgt.gradle:gradle-errorprone-plugin:2.+")
  implementation("org.springframework.boot:spring-boot-gradle-plugin:2.+")
  implementation("com.github.ben-manes:gradle-versions-plugin:0.+")
}
