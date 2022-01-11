import com.github.spotbugs.snom.Confidence
import com.github.spotbugs.snom.Effort
import com.github.spotbugs.snom.SpotBugsTask

plugins {
  `java-base`
  id("com.github.spotbugs")
}

spotbugs {
  val config = rootProject.file(".config/spotbugs/exclude.xml")
  if (config.exists()) {
    excludeFilter.set(config)
  }
  effort.set(Effort.MAX)
  reportLevel.set(Confidence.LOW)
}

tasks.withType<SpotBugsTask>().configureEach {
  reports.register("html") {
    enabled = true
  }
}

dependencies {
  spotbugs("com.github.spotbugs:spotbugs:4.5.3")
}
