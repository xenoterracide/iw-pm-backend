rootProject.name = "ppm-backend"

include(
  ":app",
  ":authn",
  ":user:settings",
  ":util:lang",
  ":util:test"
)

project(":app").projectDir = file("module/app")
project(":authn").projectDir = file("module/authn")
project(":user:settings").projectDir = file("module/user/settings")
project(":util:lang").projectDir = file("module/util/lang")
project(":util:test").projectDir = file("module/util/test")

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
