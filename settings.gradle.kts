rootProject.name = "ppm-backend"

include(
  ":app",
  ":authn"
)

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
