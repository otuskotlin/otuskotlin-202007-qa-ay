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
    val ktorVersion: String by project
    val logbackVersion: String by project
    val serializationVersion: String by project

    implementation(kotlin("stdlib-jdk8"))
    implementation(project(":qa-transport-common"))
    implementation(project(":qa-common"))
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:$serializationVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}