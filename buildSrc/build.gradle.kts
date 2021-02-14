group = "com.xenoterracide"
version = "0.1.0-SNAPSHOT"

plugins {
  `kotlin-dsl`
}

kotlinDslPluginOptions {
  experimentalWarning.set(false)
}

repositories {
  gradlePluginPortal()
}

dependencies {
  implementation("com.diffplug.spotless:spotless-plugin-gradle:5.8.2")
  implementation("gradle.plugin.com.github.spotbugs.snom:spotbugs-gradle-plugin:4.6.0")
  implementation("net.ltgt.gradle:gradle-errorprone-plugin:1.3.0")
  implementation("net.ltgt.gradle:gradle-nullaway-plugin:1.0.2")
  implementation("org.springframework.boot:spring-boot-gradle-plugin:2.4.0")
  implementation("org.checkerframework:checkerframework-gradle-plugin:0.5.16")

}

