package plugin

import extensions.ProjectExtension
import kotlinKapt
import kotlinPlugin
import implementation
import kapt
import extensions.KotlinExtension
import extensions.JavaExtension

class KotlinLibraryPlugin : BasePlugin() {
    override val pluginConfig: PluginConfig
        get() = {
            kotlinPlugin
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
}