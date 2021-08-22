plugins {
    kotlinLib
}

dependencies {
    implementation(Library.coroutinesTest)
    implementation(project(Project.executor))
}
