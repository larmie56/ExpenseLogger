package plugin

import implementation
import kapt
import androidLibPlugin
import daggerHilt
import extensions.ProjectExtension
import extensions.AndroidLib

class AndroidLibraryPlugin : BasePlugin() {

    override val pluginConfig: PluginConfig
        get() = {
            androidLibPlugin
            daggerHilt
        }

    override val libraryConfig: LibraryConfig
        get() = {
            implementation(
                Library.daggerHiltAndroid
            )
            kapt(Library.hiltCompiler)
        }

    override val extensions: Array<ProjectExtension>
        get() = arrayOf(ProjectExtension.AndroidLib)
}
