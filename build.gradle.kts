plugins {
    id("io.papermc.paperweight.userdev") version "1.4.0"
    kotlin("jvm") version "1.7.21"
}

group = "com.github.curur"
version = "1.0-SNAPSHOT"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
}

dependencies {
    paperDevBundle("1.19.3-R0.1-SNAPSHOT")
}

tasks {
    build {
        doLast {
            copy {
                val jarName = "${rootProject.name}-$version.jar"
                from("build\\libs\\$jarName")
                into("D:\\server\\[서버이름]\\plugins")
            }
        }
    }
    assemble {
        dependsOn(reobfJar)
    }
}