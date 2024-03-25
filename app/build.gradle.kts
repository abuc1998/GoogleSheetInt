plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.example.googlesheetprojectabu"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.googlesheetprojectabu"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    packagingOptions {
        exclude ("META-INF/DEPENDENCIES")
    }

    sourceSets {
        getByName("main") {
            assets.srcDirs("src/custom/assets")
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.volley)  // For network requests (if needed)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Google Play services Auth
    implementation("com.google.android.gms:play-services-auth:19.0.0")

    // Google API client for Android
    implementation("com.google.api-client:google-api-client-android:1.31.5")

    // Google Sheets API
    implementation("com.google.apis:google-api-services-sheets:v4-rev581-1.25.0")

    // Https library
    implementation("com.google.http-client:google-http-client-android:1.39.2")
}
