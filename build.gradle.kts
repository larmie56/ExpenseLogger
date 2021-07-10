// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    ktlintPlugin
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    applyKtlint
    ktlint {
        version.set(Version.ktlint)
        debug.set(false)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        ignoreFailures.set(false)
        enableExperimentalRules.set(true)
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}