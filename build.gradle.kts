plugins {
    `java-library`
    `maven-publish`
}

group = "me.andromedov"
version = "1.0"
description = "MythicMobs support addon for BreweryX"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
    withSourcesJar()
}

repositories {
    mavenCentral()
    // Paper & Spigot API
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")

    // BreweryX API
    maven("https://repo.jsinco.dev/releases")
    // MythicMobs API
    maven("https://mvn.lumine.io/repository/maven-public/")
}

dependencies {
    // Paper API
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    // BreweryX API
    compileOnly("com.dre.brewery:BreweryX:3.6.0")
    // MythicMobs API
    compileOnly("io.lumine:Mythic-Dist:5.9.5")

    // Annotations
    compileOnly("org.jetbrains:annotations:24.0.1")
}

tasks.processResources {
    val props = mapOf(
        "name" to "MythicMobs-BreweryX-Addon",
        "version" to project.version,
        "description" to project.description,
        "author" to "Andromedov",
        "main" to "me.andromedov.mythicmobsbreweryx.MythicMobsBreweryXAddon"
    )
    inputs.properties(props)
    filesMatching("addon.yml") {
        expand(props)
    }
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    archiveBaseName.set("MythicMobs-BreweryX-Addon")
}

tasks.build {
    dependsOn(tasks.jar)
}