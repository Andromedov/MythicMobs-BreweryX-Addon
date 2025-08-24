plugins {
    id("java")
}

group = "dev.jsinco.brewery"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    // Include the latest release of BreweryX instead of this version.
    compileOnly("com.github.BreweryTeam:BreweryX:snapshot-SNAPSHOT")

    // We need to include our own copy of whatever server software we're writing against!
    compileOnly("org.spigotmc:spigot-api:1.20.2-R0.1-SNAPSHOT")

    // Lombok is recommended if using configs in Java
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")
}
