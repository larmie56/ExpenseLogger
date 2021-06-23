package plugin

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

import androidLibrary

class AndroidLibraryPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        applyPlugins(project)

        applyLibraryExtension(project)

        importExternalLibs(project)
    }

    private fun applyPlugins(project: Project) {
        project.plugins.apply {
            androidLibrary
        }
    }

    private fun applyLibraryExtension(project: Project) {
        val extension = project.extensions.getByName("android")
                as? LibraryExtension ?: return
        extension.apply {
            compileSdk = AppConfig.compileSdkVersion

            defaultConfig {
                targetSdk = AppConfig.targetSdkVersion
                minSdk = AppConfig.minSdkVersion

                consumerProguardFiles("proguard-rules.pro")
            }

            buildTypes {
                named(BuildType.DEBUG) {
                    isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }
        }
    }

    private fun importExternalLibs(project: Project) {
        project.dependencies {
            // Library modules dependencies
        }
    }
}