import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.PluginContainer

val PluginContainer.androidApplication: Unit
    get() {
        apply("com.android.application")
    }

val PluginContainer.androidLibrary: Unit
    get() {
        apply("com.android.library")
    }

val PluginContainer.kotlinAndroid: Unit
    get() {
        apply("kotlin-android")
    }

val PluginContainer.kotlinKapt: Unit
    get() {
        apply("kotlin-kapt")
    }

fun DependencyHandler.implementation(dependency: String) {
    add("implementation", dependency)
}
fun DependencyHandler.testImplementation(dependency: String) {
    add("testImplementation", dependency)
}

fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)