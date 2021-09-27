plugins {
    androidLib
}

dependencies {
    implementation(project(Project.executor))
    implementation(project(Project.cache))
    testImplementation(project(Project.testUtils))
}
