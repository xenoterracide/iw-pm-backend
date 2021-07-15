plugins {
  `java-base`
  id("com.diffplug.spotless")
}

val copyright = "Copyright © \$YEAR Caleb Cushing."
val license = "Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE"
val licenseSimple = "https://choosealicense.com/licenses/apache-2.0/#"

spotless {
  val isCI = providers.environmentVariable("CI").forUseAtConfigurationTime().isPresent
  ratchetFrom = if (isCI) "HEAD~1" else "HEAD"

  java {
    licenseHeader(
      String.format(
        "/*%n" +
          " * $copyright%n" +
          " * $license%n" +
          " * $licenseSimple%n" +
          " */%n"
      )
    )
  }
}
