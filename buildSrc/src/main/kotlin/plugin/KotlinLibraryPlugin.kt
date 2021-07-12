package plugin

import Library
import extensions.JavaExtension
import extensions.KotlinExtension
import extensions.ProjectExtension
import implementation
import kapt
import kotlinKapt

class KotlinLibraryPlugin : BasePlugin() {
    override val pluginConfig: PluginConfig
        get() = {
            apply(KOTLIN_PLUGIN_ID)
            kotlinKapt
        }

    override val libraryConfig: LibraryConfig
        get() = {
            implementation(Library.hiltCore)
            kapt(Library.hiltCompiler)
        }

    override val extensions: Array<ProjectExtension>
        get() = arrayOf(
            ProjectExtension.KotlinExtension,
            ProjectExtension.JavaExtension
        )

    private companion object {
        const val KOTLIN_PLUGIN_ID: String = "kotlin"
    }
}
