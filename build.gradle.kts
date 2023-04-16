plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.8.0"
    id("org.jetbrains.compose")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js(IR) {
        browser {
            testTask {
                testLogging.showStandardStreams = true
                useKarma {
                    useChromeHeadless()
                    useFirefox()
                }
            }
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                val ktor_version = "2.2.4"
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation(kotlin("stdlib-common"))
                implementation("io.ktor:ktor-client-core:$ktor_version")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
                implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0-Beta")
                implementation("org.jetbrains.kotlin:atomicfu:1.6.21")
                implementation(npm("materialize-css", "next"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}