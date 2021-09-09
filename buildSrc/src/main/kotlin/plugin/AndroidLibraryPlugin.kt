package plugin

import Library
import androidModule
import daggerHilt
import extensions.AndroidLib
import extensions.ProjectExtension
import implementation
import kapt
import kotlinAndroid
import kotlinKapt
import testImplementation

class AndroidLibraryPlugin : BasePlugin() {

    override val pluginConfig: PluginConfig
        get() = {
            androidModule
            kotlinAndroid
            kotlinKapt
            daggerHilt
        }

    override val libraryConfig: LibraryConfig
        get() = {
            implementation(
                Library.daggerHiltAndroid,
                Library.coroutines
            )
            testImplementation(
                Library.junit,
                Library.truth,
                Library.mockito,
                Library.coroutinesTest
            )
            kapt(Library.daggerHiltCompiler)
        }

    override val extensions: Array<ProjectExtension>
        get() = arrayOf(ProjectExtension.AndroidLib)
}
