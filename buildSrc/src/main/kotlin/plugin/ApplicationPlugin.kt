package plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.AppExtension
import org.gradle.api.JavaVersion
import org.gradle.kotlin.dsl.dependencies

import implementation
import androidApplication
import kotlinAndroid
import kotlinKapt

class ApplicationPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        applyPlugins(project)

        applyAppExtensions(project)

        importExternalLibs(project)
    }

    private fun applyPlugins(project: Project) {
        project.plugins.apply {
            androidApplication
            kotlinAndroid
            kotlinKapt
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

                targetSdk = AppConfig.targetSdkVersion
                minSdk = AppConfig.minSdkVersion

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
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }
        }

    }

    private fun importExternalLibs(project: Project) {
        project.dependencies {
            implementation(Library.coreKtx)
            implementation(Library.appCompat)
            implementation(Library.material)

            // Other external library dependencies
        }
    }
}