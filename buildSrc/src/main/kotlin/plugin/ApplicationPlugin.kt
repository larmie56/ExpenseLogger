package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.AppExtension
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.dependencies

class ApplicationPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        applyPlugins(project)

        applyAppExtensions(project)

        importExternalLibs(project)
    }

    private fun applyPlugins(project: Project) {
        project.plugins.apply {
            apply("com.android.application")
            apply("kotlin-android")
            apply("kotlin-kapt")
        }
    }

    private fun applyAppExtensions(project: Project) {
        val extension = project.extensions.getByName("android")
            as? AppExtension ?: return
        extension.apply {
            compileSdkVersion(AppConfig.compileSdkVersion)

            defaultConfig {
                applicationId = AppConfig.applicationId

                versionCode(AppConfig.versionCode)
                versionName(AppConfig.versionName)

                targetSdkVersion(AppConfig.targetSdkVersion)
                minSdkVersion(AppConfig.minSdkVersion)

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

            buildTypes {
                named(BuildType.DEBUG) {
                    applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
                    versionNameSuffix = BuildTypeDebug.versionNameSuffix

                    isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
                    isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled

                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
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
            add("implementation", Library.coreKtx)
            add("implementation", Library.appCompat)
            add("implementation", Library.material)
            add("testImplementation", Library.junit)
            add("androidTestImplementation", Library.androidxJUnit)
            add("androidTestImplementation", Library.espresso)
            // Other external library dependencies
        }
    }
}