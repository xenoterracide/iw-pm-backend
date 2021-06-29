rootProject.name = "ppm-backend"

include(
  ":app",
  ":authn",
  ":usersettings"
)

project(":app").projectDir = file("module/app")
project(":authn").projectDir = file("module/authn")
project(":usersettings").projectDir = file("module/usersettings")

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
