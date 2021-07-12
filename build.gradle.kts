// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    ktlint
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    applyKtlint
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
