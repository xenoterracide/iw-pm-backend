import net.ltgt.gradle.errorprone.CheckSeverity
import net.ltgt.gradle.errorprone.errorprone
import net.ltgt.gradle.nullaway.nullaway

plugins {
  `java-library`
  id("net.ltgt.errorprone")
  id("net.ltgt.nullaway")
}

dependencies {
  errorprone("com.google.errorprone:error_prone_core:2.+")
  errorprone("com.uber.nullaway:nullaway:0.8.+")
  compileOnly("com.google.errorprone:error_prone_annotations:2.+")

  compileOnly("org.checkerframework:checker-qual:3.+")
  testCompileOnly("org.checkerframework:checker-qual:3.+")
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(11))
  }
}

nullaway {
  annotatedPackages.add("com.xenoterracide")
}

tasks.withType<JavaCompile>().configureEach {
  options.compilerArgs.addAll(
    listOf(
      "-parameters",
//    "-Werror",
      "-Xlint:deprecation",
      "-Xlint:unchecked"
    )
  )
  options.errorprone {
    nullaway {
      severity.set(CheckSeverity.ERROR)
      acknowledgeRestrictiveAnnotations.set(true)
      handleTestAssertionLibraries.set(true)
    }
    disableWarningsInGeneratedCode.set(true)
    excludedPaths.set("$buildDir/generated/sources/.*")

    error(
      "AmbiguousMethodReference",
      "ArgumentSelectionDefectChecker",
      "ArrayAsKeyOfSetOrMap",
      "AssertEqualsArgumentOrderChecker",
      "AssertThrowsMultipleStatements",
      "AssertionFailureIgnored",
      "AssignmentToMock",
      "BadComparable",
      "BadImport",
      "BadInstanceof",
      "BigDecimalEquals",
      "BigDecimalLiteralDouble",
      "BoxedPrimitiveConstructor",
      "BoxedPrimitiveEquality",
      "ByteBufferBackingArray",
      "CacheLoaderNull",
      "CannotMockFinalClass",
      "CanonicalDuration",
      "CatchFail",
      "CatchAndPrintStackTrace",
      "ClassCanBeStatic",
      "ClassNewInstance", // sketchy
      "CollectionUndefinedEquality",
      "CollectorShouldNotUseState",
      "ComparableAndComparator",
      "CompareToZero",
      "ComplexBooleanConstant",
      "DateFormatConstant",
      "DefaultCharset",
      "DefaultPackage",
      "DoubleBraceInitialization",
      "DoubleCheckedLocking",
      "EmptyCatch",
      "EqualsGetClass",
      "EqualsIncompatibleType",
      "EqualsUnsafeCast",
      "EqualsUsingHashCode",
      "ExtendingJUnitAssert",
      "FallThrough",
      "Finally",
      "FloatCast",
      "FloatingPointLiteralPrecision",
      "FutureReturnValueIgnored",
      "GetClassOnEnum",
      "HidingField",
      "ImmutableAnnotationChecker",
      "ImmutableEnumChecker",
      "InconsistentCapitalization",
      "InconsistentHashCode",
      "IncrementInForLoopAndHeader",
      "InlineFormatString",
      "InputStreamSlowMultibyteRead",
      "InstanceOfAndCastMatchWrongType",
      "InvalidThrows",
      "IterableAndIterator",
      "JavaDurationGetSecondsGetNano",
      "JavaDurationWithNanos",
      "JavaDurationWithSeconds",
      "JavaInstantGetSecondsGetNano",
      "JavaLangClash",
      "JavaLocalDateTimeGetNano",
      "JavaLocalTimeGetNano",
      "JavaTimeDefaultTimeZone",
      // "JavaUtilDate",
      "LockNotBeforeTry",
      "LockOnBoxedPrimitive",
      "LogicalAssignment",
      "MissingCasesInEnumSwitch",
      "Overrides",
      "MissingOverride",
      "MixedMutabilityReturnType",
      "ModifiedButNotUsed",
      "ModifyCollectionInEnhancedForLoop",
      "ModifySourceCollectionInStream",
      "MultipleParallelOrSequentialCalls",
      "MultipleUnaryOperatorsInMethodCall",
      "MutableConstantField",
      "MutablePublicArray",
      "NestedInstanceOfConditions",
      "NonAtomicVolatileUpdate",
      "NonOverridingEquals",
      "NullOptional",
      "NullableConstructor",
      "NullablePrimitive",
      "NullableVoid",
      "ObjectToString",
      "ObjectsHashCodePrimitive",
      "OperatorPrecedence",
      "OptionalMapToOptional",
      "OrphanedFormatString",
      "OverrideThrowableToString",
      "PreconditionsCheckNotNullRepeated",
      "PrimitiveAtomicReference",
      "ProtectedMembersInFinalClass",
      "PreconditionsCheckNotNullRepeated",
      "ReferenceEquality",
      "ReturnFromVoid",
      "RxReturnValueIgnored",
      "SameNameButDifferent",
      "ShortCircuitBoolean",
      "StaticAssignmentInConstructor",
      "StaticGuardedByInstance",
      // "StaticMockMember",
      "StreamResourceLeak",
      // "StreamToIterable",
      "StringSplitter",
      "SynchronizeOnNonFinalField",
      "ThreadJoinLoop",
      "ThreadLocalUsage",
      "ThreeLetterTimeZoneID",
      "TimeUnitConversionChecker",
      "ToStringReturnsNull",
      "TreeToString",
      "TypeEquals",
      "TypeNameShadowing",
      "TypeParameterShadowing",
      "TypeParameterUnusedInFormals", // sketchy
      "URLEqualsHashCode",
      "UndefinedEquals",
      "UnnecessaryAnonymousClass",
      "UnnecessaryLambda",
      "UnnecessaryMethodInvocationMatcher",
      // "UnnecessaryMethodReference",
      "UnnecessaryParentheses", // sketchy
      "UnsafeFinalization",
      "UnsafeReflectiveConstructionCast",
      "UnusedMethod",
      "UnusedNestedClass",
      "UnusedVariable",
      "UseCorrectAssertInTests",
      // "UseTimeInScope",
      "VariableNameSameAsType",
      "WaitNotInLoop",
      "ClassName",
      "ComparisonContractViolated",
      "DeduplicateConstants",
      "DivZero",
      "EmptyIf",
      "FuzzyEqualsShouldNotBeUsedInEqualsMethod",
      "IterablePathParameter",
      "LongLiteralLowerCaseSuffix",
      "NumericEquality",
      "StaticQualifiedUsingExpression",
      "AnnotationPosition",
      "AssertFalse",
      "CheckedExceptionNotThrown",
      // "DifferentNameButSame",
      "EmptyTopLevelDeclaration",
      "EqualsBrokenForNull",
      "ExpectedExceptionChecker",
      "InconsistentOverloads",
      // "InitializeInline",
      "InterruptedExceptionSwallowed",
      "InterfaceWithOnlyStatics",
      "NonCanonicalStaticMemberImport",
      "PreferJavaTimeOverload",
      "ClassNamedLikeTypeParameter",
      "ConstantField",
      "FieldCanBeLocal",
      "FieldCanBeStatic",
      "ForEachIterable",
      "MethodCanBeStatic",
      "MultiVariableDeclaration",
      "MultipleTopLevelClasses",
      "PackageLocation",
      "RemoveUnusedImports",
      "Var",
      "WildcardImport"
    )
  }
}
