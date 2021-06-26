package plugin

import Library
import androidApplication
import implementation
import kapt
import kotlinAndroid
import kotlinKapt
import daggerHilt

class ApplicationPlugin : BasePlugin() {

    override val pluginConfig: PluginConfig
        get() = {
            androidApplication
            kotlinAndroid
            kotlinKapt
            daggerHilt
        }

    override val libraryConfig: LibraryConfig
        get() = {
            implementation(
                Library.coreKtx,
                Library.appCompat,
                Library.material,
                Library.daggerHiltAndroid
            )
            kapt(Library.hiltCompiler)
        }

    override val extensions: Array<ProjectExtensions>
        get() = arrayOf(ProjectExtensions.AndroidApp)
}
