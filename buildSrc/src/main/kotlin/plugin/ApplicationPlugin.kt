package plugin

import Library
import androidApplication
import implementation
import kotlinAndroid
import kotlinKapt

class ApplicationPlugin : BasePlugin() {

    override val pluginConfig: PluginConfig
        get() = {
            androidApplication
            kotlinAndroid
            kotlinKapt
        }

    override val libraryConfig: LibraryConfig
        get() = {
            implementation(
                Library.coreKtx,
                Library.appCompat,
                Library.material
            )
        }

    override val extensions: Array<ProjectExtensions>
        get() = arrayOf(ProjectExtensions.AndroidApp)
}
