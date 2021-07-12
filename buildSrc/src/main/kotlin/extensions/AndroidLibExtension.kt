package extensions

import AppConfig
import BuildType.Companion.Debug
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion

val ProjectExtension.Companion.AndroidLib: ProjectExtension
    get() = AndroidLibExtension()

private class AndroidLibExtension : ProjectExtension {

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