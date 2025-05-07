plugins {
    id("com.android.library") version "8.9.2"
}

android {
    namespace = "org.example"
    compileSdk = 35

    buildTypes["debug"].isTestCoverageEnabled = true
}
