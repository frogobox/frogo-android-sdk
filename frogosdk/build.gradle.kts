plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    `maven-publish`
}

android {

    compileSdk = ProjectSetting.PROJECT_COMPILE_SDK

    defaultConfig {
        minSdk = ProjectSetting.PROJECT_MIN_SDK
        targetSdk = ProjectSetting.PROJECT_TARGET_SDK

        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        consumerProguardFile("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependency.COMPOSE_VERSION
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
        }
    }

}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Dependency.KOTLIN_VERSION}")

    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.preference:preference-ktx:1.2.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("androidx.compose.ui:ui:${Dependency.COMPOSE_VERSION}")
    implementation("androidx.compose.material:material:${Dependency.COMPOSE_VERSION}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Dependency.COMPOSE_VERSION}")

    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
    implementation("androidx.activity:activity-compose:1.4.0")

    implementation("androidx.activity:activity-ktx:${Dependency.ACTIVITY_KTX_VERSION}")
    implementation("androidx.fragment:fragment-ktx:${Dependency.FRAGMENT_KTX_VERSION}")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")

    implementation("androidx.room:room-runtime:${Dependency.ROOM_VERSION}")
    implementation("androidx.room:room-ktx:${Dependency.ROOM_VERSION}")
    implementation("androidx.room:room-rxjava2:${Dependency.ROOM_VERSION}")
    implementation("androidx.room:room-guava:${Dependency.ROOM_VERSION}")

    implementation("com.google.code.gson:gson:2.8.9")
    implementation("com.google.android.material:material:1.5.0")

    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.3")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.21")

    implementation("com.github.javiersantos:PiracyChecker:1.2.8")
    implementation("com.github.bumptech.glide:glide:4.12.0")

    implementation("com.facebook.stetho:stetho:1.5.1")
    implementation("com.readystatesoftware.chuck:library:1.1.0")

    api("com.google.dagger:dagger:2.38.1")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0-native-mt")

    kapt("androidx.lifecycle:lifecycle-compiler:2.4.1")
    kapt("androidx.room:room-compiler:2.4.2")
    kapt("com.google.dagger:dagger-compiler:2.37")
    kapt("com.github.bumptech.glide:compiler:4.12.0")

    implementation("io.insert-koin:koin-core:${Dependency.KOIN_VERSION}") // Koin core features
    implementation("io.insert-koin:koin-android:${Dependency.KOIN_VERSION}") // Koin main features for Android (Scope,ViewModel ...)
    implementation("io.insert-koin:koin-android-compat:${Dependency.KOIN_VERSION}") // Koin Java Compatibility
    implementation("io.insert-koin:koin-androidx-workmanager:${Dependency.KOIN_VERSION}") // Koin for Jetpack WorkManager
    implementation("io.insert-koin:koin-androidx-compose:${Dependency.KOIN_VERSION}") // Koin for Jetpack Compose

    testImplementation("androidx.room:room-testing:${Dependency.ROOM_VERSION}")
    testImplementation("io.insert-koin:koin-test:${Dependency.KOIN_VERSION}")

    androidTestImplementation("androidx.room:room-testing:${Dependency.ROOM_VERSION}")

    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Dependency.COMPOSE_VERSION}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Dependency.COMPOSE_VERSION}")

}

afterEvaluate {
    publishing {
        publications {

            // Creates a Maven publication called "release".
            register("release", MavenPublication::class) {

                // Applies the component for the release build variant.
                // NOTE : Delete this line code if you publish Native Java / Kotlin Library
                from(components["release"])

                // Library Package Name (Example : "com.frogobox.androidfirstlib")
                // NOTE : Different GroupId For Each Library / Module, So That Each Library Is Not Overwritten
                groupId = ProjectSetting.PROJECT_LIB_ID

                // Library Name / Module Name (Example : "androidfirstlib")
                // NOTE : Different ArtifactId For Each Library / Module, So That Each Library Is Not Overwritten
                artifactId = ProjectSetting.NAME_APK

                // Version Library Name (Example : "1.0.0")
                version = ProjectSetting.PROJECT_VERSION_NAME

            }
        }
    }
}