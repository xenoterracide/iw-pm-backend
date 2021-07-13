plugins {
  id("com.diffplug.spotless")
}

val copyright = "Copyright © \$YEAR Caleb Cushing."
val license = "Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE"
val licenseSimple = "https://choosealicense.com/licenses/apache-2.0/#"

spotless {
  val isCI = providers.environmentVariable("CI").forUseAtConfigurationTime().isPresent
  ratchetFrom = if (isCI) "HEAD~1" else "HEAD"
  java {
    removeUnusedImports()
    // importOrder()
    licenseHeader(
      String.format(
        "/*%n" +
          " * $copyright%n" +
          " * $license%n" +
          " * $licenseSimple%n" +
          " */%n"
      )
    )
    prettier(mapOf("prettier-plugin-java" to "1.x"))
  }
  kotlinGradle {
    ktfmt().googleStyle()
  }
  format("xml") {
    target("*.xml")
    prettier().config(mapOf("@prettier/plugin-xml" to "0.x"))
  }
  format("properties") {
    target("*.properties")
    prettier().config(mapOf("prettier-plugin-properties" to "0.x"))
  }
}
