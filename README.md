# Gradle `8.14` with AGP's `isTestCoverageEnabled` issue sample
Sample repo reproducing an issue with Gradle `8.14` and AGP's `isTestCoverageEnabled` flag.

Run:
```bash
./gradlew build
```
to get:
```
FAILURE: Build failed with an exception.

* What went wrong:
Configuration cache state could not be cached: field `destinationFile` of `org.gradle.testing.jacoco.plugins.JacocoPluginExtension$JacocoOutputCleanupTestTaskAction` bean found in field `action` of `org.gradle.api.internal.AbstractTask$TaskActionWrapper` bean found in field `actions` of task `:testDebugUnitTest` of type `com.android.build.gradle.tasks.factory.AndroidUnitTest`: error writing value of type 'org.gradle.api.internal.provider.DefaultProvider'
> Querying the mapped value of map(java.io.File task ':testDebugUnitTest' property 'jacocoCoverageOutputFile' org.gradle.api.internal.file.DefaultFilePropertyFactory$ToFileTransformer@fb2d8ff) before task ':testDebugUnitTest' has completed is not supported
```

This was not happening in Gradle `8.13`. 

It's not caused by Configuration Cache, since disabling it also produces:
```
FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':testDebugUnitTest'.
> Querying the mapped value of map(java.io.File task ':testDebugUnitTest' property 'jacocoCoverageOutputFile' org.gradle.api.internal.file.DefaultFilePropertyFactory$ToFileTransformer@3bb1e58d) before task ':testDebugUnitTest' has completed is not supported
```
