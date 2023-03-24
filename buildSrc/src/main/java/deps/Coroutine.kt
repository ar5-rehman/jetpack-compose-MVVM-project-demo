package deps

object Coroutine : Dependency() {

    object Versions {
        const val coroutines = "1.6.4"
    }

    private const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
    private const val kotlinCoreJvm = "org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.4"
    private const val androidCoroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"

    override fun implementations() = listOf<String>(
        core,
        androidCoroutine,
        kotlinCoreJvm
    )
}
