rootProject.name = "OtusStackOwerflow"

pluginManagement {
    val kotlinVersion: String by settings
    plugins {
        kotlin("jvm") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
    }
}
include("qa-common")
include("qa-transport-common")
include("qa-transport-rest")
include("qa-transport-rest")
