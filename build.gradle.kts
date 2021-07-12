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
