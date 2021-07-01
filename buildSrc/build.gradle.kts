import Build_gradle.Plugin.androidLib
import Build_gradle.Plugin.app
import Build_gradle.Plugin.kotlinLib

plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register(app) {
            id = app
            implementationClass = "plugin.ApplicationPlugin"
        }

        register(androidLib) {
            id = androidLib
            implementationClass = "plugin.AndroidLibraryPlugin"
        }

        register(kotlinLib) {
            id = kotlinLib
            implementationClass = "plugin.KotlinLibraryPlugin"
        }
    }
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = Plugin.Version.kotlin
}

dependencies {
    implementation(Plugin.kotlin)
    implementation(Plugin.androidGradle)
    implementation(Plugin.daggerHilt)
}

repositories {
    google()
    mavenCentral()
}


object Plugin {
    const val app: String = "app"
    const val androidLib: String = "androidLibrary"
    const val kotlinLib: String = "kotlinLibrary"

    object Version {
        const val kotlin: String = "1.5.20"
        const val androidGradle = "7.1.0-alpha02"
        const val daggerHilt = "2.37"
    }

    const val kotlin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    const val androidGradle: String = "com.android.tools.build:gradle:${Version.androidGradle}"
    const val daggerHilt: String =
        "com.google.dagger:hilt-android-gradle-plugin:${Version.daggerHilt}"
}
