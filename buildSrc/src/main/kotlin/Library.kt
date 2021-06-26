object Library {
    // AndroidX
    const val coreKtx: String = "androidx.core:core-ktx:${Version.coreKtx}"
    const val appCompat: String = "androidx.appcompat:appcompat:${Version.appCompat}"
    const val constraintLayout: String =
        "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
    const val fragment: String = "androidx.fragment:fragment-ktx:${Version.fragment}"
    const val recyclerView: String = "androidx.recyclerview:recyclerview:${Version.recyclerView}"
    const val navigationFragmentKtx: String =
        "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
    const val navigationUiKtx: String =
        "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
    const val room: String = "androidx.room:room-ktx:${Version.room}"
    const val androidxJUnit: String = "androidx.test.ext:junit:${Version.androidxJUnit}"
    const val espresso: String = "androidx.test.espresso:espresso-core:${Version.espresso}"
    const val viewModel: String =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"

    // Google
    const val material: String = "com.google.android.material:material:${Version.material}"
    const val daggerHiltAndroid: String = "com.google.dagger:hilt-android:${Version.daggerHilt}"
    const val hiltCompiler: String = "com.google.dagger:hilt-android-compiler:${Version.daggerHilt}"

    // KotlinX
    const val coroutines: String =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"

    // Square
    val okhttp: String =
        "com.squareup.okhttp3:okhttp:${Version.okhttp}"
    const val loggingInterceptor: String =
        "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
    const val retrofit: String = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val retrofitMoshi: String =
        "com.squareup.retrofit2:converter-moshi:${Version.retrofit}"
    const val moshi: String = "com.squareup.moshi:moshi-kotlin:${Version.moshi}"

    // Junit
    const val junit: String = "unit:junit:${Version.junit}"
}