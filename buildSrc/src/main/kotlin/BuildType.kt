interface BuildType {

    companion object {
        val Debug: BuildType = BuildTypeDebug
        val Release: BuildType = BuildTypeRelease
    }

    val name: String
    val isMinifyEnabled: Boolean
    val isTestCoverageEnabled: Boolean
    val applicationIdSuffix: String
    val versionNameSuffix: String
}

private object BuildTypeDebug : BuildType {
    override val name: String get() = "debug"
    override val isMinifyEnabled: Boolean get() = false
    override val isTestCoverageEnabled: Boolean get() = true
    override val applicationIdSuffix: String get() = ".debug"
    override val versionNameSuffix: String get() = "-DEBUG"
}

private object BuildTypeRelease : BuildType {
    override val name: String get() = "release"
    override val isMinifyEnabled: Boolean get() = true
    override val isTestCoverageEnabled: Boolean get() = true
    override val applicationIdSuffix: String get() = ".release"
    override val versionNameSuffix: String get() = "-RELEASE"
}
