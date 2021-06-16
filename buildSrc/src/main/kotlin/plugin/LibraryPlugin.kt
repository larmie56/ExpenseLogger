package plugin

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class LibraryPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        applyPlugins(project)

        applyLibraryExtension(project)

        importExternalLibs(project)
    }

    private fun applyPlugins(project: Project) {
        project.plugins.apply {
            apply("com.android.library")
        }
    }

    private fun applyLibraryExtension(project: Project) {
        val extension = project.extensions.getByName("android")
                as? LibraryExtension ?: return
        extension.apply {
            compileSdkVersion(AppConfig.compileSdkVersion)

            defaultConfig {
                targetSdkVersion(AppConfig.targetSdkVersion)
                minSdkVersion(AppConfig.minSdkVersion)

                consumerProguardFiles("proguard-rules.pro")
            }

            buildTypes {
                named(BuildType.DEBUG) {
                    isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
        }
    }

    private fun importExternalLibs(project: Project) {
        project.dependencies {
            // Library modules dependencies
        }
    }
}