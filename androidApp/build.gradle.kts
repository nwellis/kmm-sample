plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdkVersion(AndroidSdk.compile)
    defaultConfig {
        applicationId = "me.nickellis.kmmsample.androidApp"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    lintOptions {
        // TODO: Not working? Refactor to single Dependencies object?
        // https://github.com/PicPay/version-checker-gradle-lint
        enable("VersionCheckerGradleLint")
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(AndroidX.appCompat)

    implementation(UI.materialUI)
    implementation(UI.constrainLayout)

    implementation(Jetpack.lifecycleExtensions)
    implementation(Jetpack.lifecycleViewmodelKtx)
    implementation(Jetpack.lifecycleLivedataKtx)
}