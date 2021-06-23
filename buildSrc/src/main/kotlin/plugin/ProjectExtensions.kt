package plugin

import AppConfig
import BuildType.Companion.Debug
import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion

interface ProjectExtensions {
    val name: String
    fun configure(extension: Any)

    companion object {
        val AndroidApp: ProjectExtensions = AndroidAppExtension()
        val AndroidLib: ProjectExtensions = AndroidLibExtension()
    }
}

private class AndroidAppExtension : ProjectExtensions {

    override val name: String get() = "android"

    override fun configure(extension: Any) {
        if (extension !is AppExtension) return
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
                named(Debug.name) {
                    applicationIdSuffix = Debug.applicationIdSuffix
                    versionNameSuffix = Debug.versionNameSuffix

                    isMinifyEnabled = Debug.isMinifyEnabled
                    isTestCoverageEnabled = Debug.isTestCoverageEnabled

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
}

private class AndroidLibExtension : ProjectExtensions {

    override val name: String get() = "android"

    override fun configure(extension: Any) {
        if (extension !is LibraryExtension) return
        extension.apply {
            compileSdk = AppConfig.compileSdkVersion

            defaultConfig {
                targetSdk = AppConfig.targetSdkVersion
                minSdk = AppConfig.minSdkVersion

                consumerProguardFiles("proguard-rules.pro")
            }

            buildTypes {
                named(Debug.name) {
                    isMinifyEnabled = Debug.isMinifyEnabled
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }
        }
    }
}