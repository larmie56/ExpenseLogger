package plugin

import implementation
import kapt
import androidLibrary
import daggerHilt

class AndroidLibraryPlugin : BasePlugin() {

    override val pluginConfig: PluginConfig
        get() = {
            androidLibrary
            daggerHilt
        }

    override val libraryConfig: LibraryConfig
        get() = {
            implementation(
                Library.daggerHiltAndroid
            )
            kapt(Library.hiltCompiler)
        }

    override val extensions: Array<ProjectExtensions>
        get() = arrayOf(ProjectExtensions.AndroidLib)
}
