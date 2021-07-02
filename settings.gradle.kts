rootProject.name = "ppm-backend"

include(
  ":app",
  ":authn",
  ":user:model",
  ":util:lang",
  ":util:model",
  ":util:model-graph",
  ":util:test"
)

project(":app").projectDir = file("module/app")
project(":authn").projectDir = file("module/authn")
project(":user:model").projectDir = file("module/user/model")
project(":util:lang").projectDir = file("module/util/lang")
project(":util:model").projectDir = file("module/util/model")
project(":util:model-graph").projectDir = file("module/util/model-graph")
project(":util:test").projectDir = file("module/util/test")

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
