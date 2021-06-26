# ExpenseLogger
Android app for keeping track of daily expenses. Daily expense entries are shown in a list, and categorized by date.

### Prerequisite
To build this project, you require;
- Android Studio Bumble bee
- Gradle 7.1.0-alpha02

### Mock up
![20210625_210214](https://user-images.githubusercontent.com/43486366/123519374-cac6bc00-d6a2-11eb-93d4-0e8c23c840e0.jpg)

### Libraries
- [Room](https://developer.android.com/training/data-storage/room): Provides abstraction layer over SQLite
- [Retrofit](https://square.github.io/retrofit/): Type safe http client and supports coroutines out of the box.
- [Moshi](https://github.com/square/moshi): JSON Parser, used to parse requests on the data layer for entities and understands Kotlin non-nullable and default parameters
- [Okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md): Logs HTTP request and response data.
- [Kotlin.coroutines](https://github.com/Kotlin/kotlinx.coroutines): Library support for Kotlin coroutines
- [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android): Built on top of dagger, handles dependency injection
- [Navigation component](https://developer.android.com/guide/navigation): Implements navigation
- [Espresso](https://developer.android.com/training/testing/espresso): Test framework for UI tests
- [Kotlin Gradle DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html): Gradle’s Kotlin DSL provides an alternative syntax to the traditional Groovy DSL with an enhanced editing experience

