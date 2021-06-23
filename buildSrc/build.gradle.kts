plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("app") {
            id = "app"
            implementationClass = "plugin.ApplicationPlugin"
        }

        register("library") {
            id = "library"
            implementationClass = "plugin.AndroidLibraryPlugin"
        }
    }
}

object Plugin {
    object Version {
        const val kotlin: String = "1.5.10"
        const val androidGradle = "7.1.0-alpha02"
    }

    const val kotlin: String = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"

    const val androidGradle: String = "com.android.tools.build:gradle:${Version.androidGradle}"
}

dependencies {
    implementation(Plugin.kotlin)
    implementation(Plugin.androidGradle)
}

repositories {
    google()
    mavenCentral()
}