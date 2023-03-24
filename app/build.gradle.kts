import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import deps.dependOn

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.android")
}


fun getLocalProperty(key: String) = gradleLocalProperties(rootDir).getProperty(key)
fun String?.toFile() = file(this!!)
val environment: Map<String, String> = System.getenv()

android {
    compileSdk = Build.compileSdk

    defaultConfig {
        applicationId = Build.applicationId
        minSdk = Build.minSdk
        targetSdk = Build.targetSdk
        versionCode = 1
        versionName = Build.majorVersion
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "BASE_URL", "\"https://backend.com/\"")

    }

    signingConfigs {
        create("LeekimSigningConfig") {
            keyAlias = getLocalProperty("signing.keyAlias") ?: environment["SIGNING_KEY_ALIAS"] ?: error("Error!")
            storeFile = (getLocalProperty("signing.storeFile") ?: environment["SIGNING_STORE_FILE"] ?: error("Error!")).toFile()
            keyPassword = getLocalProperty("signing.keyPassword") ?: environment["SIGNING_KEY_PASSWORD"] ?: error("Error!")
            storePassword = getLocalProperty("signing.storePassword") ?: environment["SIGNING_STORE_PASSWORD"] ?: error("Error!")
            enableV1Signing = true
            enableV2Signing = true
        }
    }

    buildTypes {
        named("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
        }

        named("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            signingConfig = signingConfigs["LeekimSigningConfig"]
            proguardFiles(
                getDefaultProguardFile(Build.proguard_android),
                Build.proguard_common,
                Build.proguard_specific
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = deps.Compose.Versions.composeCompiler
    }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}


dependencies {
    implementation(project(":base:theme"))
    implementation(project(":base:common"))
    implementation(project(":base:ui"))

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    implementation("androidx.recyclerview:recyclerview:1.3.0")

    implementation("com.google.android.material:material:1.8.0")
    implementation("com.vk:androidsdk:1.6.7")
    implementation("com.google.firebase:firebase-auth-ktx:21.1.0")

    implementation("androidx.compose.runtime:runtime-livedata:1.3.3")

    // ===================== Testing related dependencies below ===========
    testImplementation("junit:junit:4.13.2")

    // Espresso
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // androidx.test
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:core:1.5.0")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.5")

    // ========================== OLD =====================================
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))
    implementation("androidx.multidex:multidex:2.0.1")

    implementation("com.github.bumptech.glide:glide:4.13.2")
    implementation(files("libs/commons-io-2.4.jar"))
    implementation(files("libs/nineoldandroids-2.4.0.jar"))

    implementation("androidx.vectordrawable:vectordrawable-animated:1.1.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.media:media:1.6.0")
    implementation("com.aurelhubert:ahbottomnavigation:2.2.0")
    implementation("com.miguelcatalan:materialsearchview:1.4.0")

    implementation("dnsjava:dnsjava:2.1.9")
    implementation("info.androidhive:fontawesome:0.0.5")



    implementation("androidx.startup:startup-runtime:1.1.1")

    dependOn(
        deps.Hilt,
        deps.Compose,
        deps.Log,
        deps.Retrofit,
        deps.AndroidX,
        deps.Room,
        deps.Coroutine
    )
}
