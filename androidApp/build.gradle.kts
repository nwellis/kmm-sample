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
        // https://github.com/PicPay/version-checker-gradle-lint
        enable("VersionCheckerGradleLint")
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(AndroidLibs.appCompat)

    implementation(AndroidLibs.koinAndroid)
    implementation(AndroidLibs.koinAndroidViewModel)

    implementation(AndroidLibs.materialUI)
    implementation(AndroidLibs.constrainLayout)

    implementation(AndroidLibs.lifecycleExtensions)
    implementation(AndroidLibs.lifecycleRuntimeKtx)
    implementation(AndroidLibs.lifecycleViewmodelKtx)
    implementation(AndroidLibs.lifecycleLivedataKtx)
}