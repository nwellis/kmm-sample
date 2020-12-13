import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("kotlinx-serialization")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                // Kotlin
                implementation(Libs.kotlinCoroutines)
                implementation(Libs.kotlinCoreSerialization)

                // Ktor
                implementation(Libs.ktorClientCore)
                implementation(Libs.ktorClientJson)
                implementation(Libs.ktorClientAuth)
                implementation(Libs.ktorClientLogging)
                implementation(Libs.ktorClientSerialization)

                // SQL Delight
                implementation(Libs.sqlDelightRuntime)
                implementation(Libs.sqlDelightCoroutineExtensions)

                // koin
                api(Libs.koinCore)

                // kermit
                api(Libs.kermit)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Libs.ktorClientAndroid)
                implementation(Libs.sqlDelightAndroidDriver)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(Libs.junit)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Libs.ktorClientIos)
                implementation(Libs.sqlDelightNativeDriver)
            }
        }
        val iosTest by getting
    }
}

android {
    compileSdkVersion(AndroidSdk.compile)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)
