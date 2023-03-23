plugins {
    kotlin("jvm") version "1.8.0"
}

group = "com.github.curur"
version = "0.0.1"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
}

tasks {
    build {
        doLast {
            copy {
                val jarName = "${rootProject.name}-$version.jar"
                from("build\\libs\\$jarName")
                into("D:\\server\\dev server\\plugins")
            }
            delete("D:\\server\\dev server\\plugins\\update\\RELOAD")
        }
    }
}
