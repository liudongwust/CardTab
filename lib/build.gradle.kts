import com.vanniktech.maven.publish.SonatypeHost
import com.vanniktech.maven.publish.AndroidSingleVariantLibrary

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    id("com.vanniktech.maven.publish") version "0.30.0"
    id("signing")
}

android {
    namespace = "com.wustfly.cardtab"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    dataBinding {
        enable = true
    }
    viewBinding {
        enable = true
    }
}

dependencies {
    api(libs.androidx.appcompat)
    api(libs.androidx.viewpager2)
    api(libs.com.wustfly.cardviews)
}

mavenPublishing {

    configure(AndroidSingleVariantLibrary(
        // the published variant
        variant = "release",
        // whether to publish a sources jar
        sourcesJar = true,
        // whether to publish a javadoc jar
        publishJavadocJar = true,
    ))

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    signAllPublications()

    coordinates("com.wustfly.wult", "cardTab", "1.0.1")

    pom {
        name.set("CardTab")
        description.set("一款好用的android Tab控件，能在布局文件中被渲染，在开发中能够即时查看效果，所见即所得")
        inceptionYear.set("2025")
        url.set("https://github.com/liudongwust/CardTab/")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        developers {
            developer {
                id.set("wult")
                name.set("Wult")
                url.set("https://github.com/liudongwust/")
            }
        }
        scm {
            url.set("https://github.com/liudongwust/CardTab/")
            connection.set("scm:git:git://github.com/liudongwust/CardTab.git")
            developerConnection.set("scm:git:ssh://git@github.com/liudongwust/CardTab.git")
        }
    }
}