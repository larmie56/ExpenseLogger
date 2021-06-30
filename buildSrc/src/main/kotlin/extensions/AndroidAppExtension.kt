package extensions

import AppConfig
import BuildType.Companion.Debug
import com.android.build.gradle.AppExtension
import org.gradle.api.JavaVersion

val ProjectExtension.Companion.AndroidApp: ProjectExtension
    get() = AndroidAppExtension()

private class AndroidAppExtension : ProjectExtension {

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