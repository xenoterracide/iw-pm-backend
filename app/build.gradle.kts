import org.springframework.boot.gradle.tasks.bundling.BootJar
import org.springframework.boot.gradle.tasks.run.BootRun

group = "com.xenoterracide"
version = "0.1.0-SNAPSHOT"
plugins {
  id("ppm.java-app")
  id("org.springframework.boot")
  id("com.gorylenko.gradle-git-properties").version("2.2.4")
}

application {
  mainClass.set("com.xenoterracide.ppm.Application")
}

springBoot {
  buildInfo()
}

tasks.withType<BootRun> {
  systemProperty("spring.profiles.active", "dev")
}

tasks.withType<BootJar> {
  layered {
    isEnabled = true
  }
}

dependencies {
  developmentOnly(platform("org.springframework.boot:spring-boot-starter-parent:2.4.+"))
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  runtimeOnly("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-web")
  testImplementation("org.springframework.boot:spring-boot-starter-webflux")

  runtimeOnly(project(":authn"))
}
