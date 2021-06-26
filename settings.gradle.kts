rootProject.name = "ppm-backend"

include(
  ":app",
  ":authn"
)

project(":app").projectDir = file("module/app")
project(":authn").projectDir = file("module/authn")

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
