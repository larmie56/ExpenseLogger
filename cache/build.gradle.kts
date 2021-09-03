plugins {
    androidLib
}

dependencies {
    implementation(Library.room)
    kapt(Library.roomCompiler)

    testImplementation(
        Library.androidXTest,
        Library.runner,
        Library.androidXTest,
        Library.robolectric
    )
}
