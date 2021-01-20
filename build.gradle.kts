plugins {
    kotlin("jvm") version "1.4.21"
    `java-library`
}

group = "com.mayak.bottom"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.6.2")
    testImplementation("org.junit.jupiter", "junit-jupiter-params", "5.6.2")
    testImplementation("org.junit.jupiter", "junit-jupiter-engine", "5.6.2")
}

java {
    withSourcesJar()
}

tasks {
    jar {
        manifest {
            attributes(mapOf(
                "Implementation-Title" to project.name,
                "Implementation-Version" to project.version
            ))
        }
        configurations["runtimeClasspath"].forEach {
            if (it.name.startsWith("kotlin-") || it.name.startsWith("annotations") || it.name.startsWith("config"))
                return@forEach
            from(zipTree(it.absoluteFile))
        }
    }
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs += "-Xopt-in=kotlin.ExperimentalUnsignedTypes"
            jvmTarget = "1.8"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            freeCompilerArgs += "-Xopt-in=kotlin.ExperimentalUnsignedTypes"
            jvmTarget = "1.8"
        }
    }
    test {
        useJUnitPlatform()
    }
}
