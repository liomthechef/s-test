import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

version = "0.1.0"

plugins {
    // to make fatjars for simple execution
    id("com.github.johnrengelman.shadow") version "6.1.0"
    kotlin("jvm") version "1.4.10"
}
repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

tasks.withType<ShadowJar> {
    manifest {
        attributes["Main-Class"] = "square.AppKt"
    }
}

tasks {
    "shadowJar"(ShadowJar::class) {
        // required for more than 65565 files
        isZip64 = true
    }
}

tasks.test {
    useJUnit()
    maxHeapSize = "1G"
}