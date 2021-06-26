package plugin

import kotlinLibrary
import kotlinKapt

class KotlinLibraryPlugin : BasePlugin() {
    override val pluginConfig: PluginConfig
        get() = {
            kotlinLibrary
            kotlinKapt
        }

    override val libraryConfig: LibraryConfig
        get() = {}

    override val extensions: Array<ProjectExtensions>
        get() = arrayOf()
}