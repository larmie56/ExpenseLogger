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
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        with(kotlinOptions) {
            jvmTarget = JavaVersion.VERSION_11.toString()
            freeCompilerArgs += "-Xuse-experimental=" +
                "kotlin.Experimental," +
                "kotlinx.coroutines.ExperimentalCoroutinesApi," +
                "kotlinx.coroutines.InternalCoroutinesApi," +
                "kotlinx.coroutines.ObsoleteCoroutinesApi," +
                "kotlinx.coroutines.FlowPreview"
            freeCompilerArgs += "-Xopt-in=kotlin.ExperimentalStdlibApi"
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
    }
}
