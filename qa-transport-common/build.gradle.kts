plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
}

group = "com.github.yanadroidua"
version = "0.0.1"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    val serializationVersion: String by project
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}