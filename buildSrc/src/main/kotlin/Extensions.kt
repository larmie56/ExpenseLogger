import org.gradle.api.Project
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.plugins.PluginContainer
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

// region plugin extensions

internal val PluginContainer.androidApplication: Unit
    get() {
        apply("com.android.application")
    }

internal val PluginContainer.androidLibPlugin: Unit
    get() {
        apply("com.android.library")
    }

internal val PluginContainer.kotlinAndroid: Unit
    get() {
        apply("kotlin-android")
    }

internal val PluginContainer.kotlinKapt: Unit
    get() {
        apply("kotlin-kapt")
    }

internal val PluginContainer.kotlinPlugin: Unit
    get() {
        apply("kotlin")
    }

internal val PluginContainer.daggerHilt: Unit
    get() {
        apply("dagger.hilt.android.plugin")
    }

val PluginDependenciesSpec.androidApp: PluginDependencySpec
    get() = id("app")

val PluginDependenciesSpec.androidLib: PluginDependencySpec
    get() = id("androidLibrary")

val PluginDependenciesSpec.kotlinLib: PluginDependencySpec
    get() = id("kotlinLibrary")

val PluginDependenciesSpec.ktlintPlugin: PluginDependencySpec
    get() = id("org.jlleitschuh.gradle.ktlint") version Version.ktlintPlugin

// endregion

// region project extensions

val Project.applyKtlint
    get() = apply(plugin = "org.jlleitschuh.gradle.ktlint")

//endregion

// region dependency extensions

fun DependencyHandler.implementation(dependency: String) = add(
    "implementation", dependency
)

fun DependencyHandler.implementation(vararg dependencies: String) {
    dependencies.forEach(::implementation)
}

fun DependencyHandler.testImplementation(dependency: String) {
    add("testImplementation", dependency)
}

fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)

// endregion