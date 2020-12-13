pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }
    
}
rootProject.name = "KMMSample"


include(":androidApp")
include(":shared")

gradle.beforeProject {
    rootDir.resolve("local.properties")
        .takeIf { it.exists() }
        ?.let { file -> java.util.Properties().apply { load(file.inputStream()) } }
        ?.forEach { (key, value) -> if (key is String) project.extra.set(key, value) }
}

