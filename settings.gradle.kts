rootProject.name = "ppm-backend"

include(
  ":app",
  ":authn"
)

enableFeaturePreview("ONE_LOCKFILE_PER_PROJECT")
