@file:Suppress("MemberVisibilityCanBePrivate")

object Build {
    const val applicationId = "com.jetpack.demo"
    
    // Update Dockerfile upon updating compileSdk version
    const val compileSdk = 33
    const val minSdk = 21
    const val targetSdk = 33

    // App versioning
    const val majorVersion = "1.0.0"

    const val proguard_android = "proguard-android.txt"
    const val proguard_common = "proguard-rules.pro"
    const val proguard_specific = "proguard-specific.txt"
}
