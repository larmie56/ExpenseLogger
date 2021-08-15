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

    // Design
    const val material: String = "com.google.android.material:material:${Version.material}"

    // DI
    const val daggerHiltAndroid: String = "com.google.dagger:hilt-android:${Version.daggerHilt}"
    const val hiltCore: String = "com.google.dagger:hilt-core:${Version.daggerHilt}"
    const val daggerHiltCompiler: String =
        "com.google.dagger:hilt-android-compiler:${Version.daggerHilt}"
    const val hiltViewModel: String =
        "androidx.hilt:hilt-lifecycle-viewmodel:${Version.androidxHilt}"
    const val androidxHiltCompiler: String = "androidx.hilt:hilt-compiler:${Version.androidxHilt}"

    // KotlinX
    const val coroutines: String =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"

    // Coroutine test
    const val coroutinesTest: String =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}"

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

    // Truth
    const val truth: String = "com.google.truth:truth:${Version.truth}"

    // Mockito
    const val mockito: String = "org.mockito:mockito-core:${Version.mockito}"
}

object Project {
    const val executor: String = ":executor"
    const val libExpense: String = ":lib_expense"
}
