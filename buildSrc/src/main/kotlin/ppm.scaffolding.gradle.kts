open class Generator : DefaultTask() {
  @Input
  @Option(description = "args")
  lateinit var args: List<String>

  @TaskAction
  fun processTemplates() {
    logger.error("args:", args)
    // ...
  }
}
tasks.register("gen", Generator::class);
