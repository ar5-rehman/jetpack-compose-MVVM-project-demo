package deps

object
Hilt : Dependency() {
    object Versions {
        const val hilt = "2.44"
    }

    private const val android = "com.google.dagger:hilt-android:${Versions.hilt}"
    private const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    private const val hiltWork = "androidx.hilt:hilt-work:1.0.0"
    private const val hiltKapt = "androidx.hilt:hilt-compiler:1.0.0"

    override fun implementations() = listOf(
            android,
            hiltWork
    )

    override fun kapt() = listOf(
            compiler,
            hiltKapt
    )
}