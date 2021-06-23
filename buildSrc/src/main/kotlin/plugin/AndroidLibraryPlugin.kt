package plugin

import androidLibrary

class AndroidLibraryPlugin : BasePlugin() {

    override val pluginConfig: PluginConfig
        get() = { androidLibrary }

    override val libraryConfig: LibraryConfig
        get() = {}

    override val extensions: Array<ProjectExtensions>
        get() = arrayOf(ProjectExtensions.AndroidLib)
}
