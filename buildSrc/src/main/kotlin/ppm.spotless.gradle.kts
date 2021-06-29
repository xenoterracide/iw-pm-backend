plugins {
  id("com.diffplug.spotless")
}


val copyright = "Copyright © \$YEAR Caleb Cushing."
val license = "Apache 2.0. See https://github.com/xenoterracide/brix/LICENSE"
val licenseSimple = "https://choosealicense.com/licenses/apache-2.0/#"
spotless {
  ratchetFrom = "HEAD"
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
