plugins {
    `java-library`
    alias(libs.plugins.vanniktechMavenPublish)
}

group = "io.github.storytellerf"
version = providers.gradleProperty("version").orElse("1.0.4-SNAPSHOT").get()

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.test {
    useJUnitPlatform()
    jvmArgs(
        "-Djava.util.logging.config.file=${file("src/test/resources/logging.properties")}",
        "-Dvavi.test.volume=0.02"
    )
}

// Publishing configuration via Vanniktech plugin
mavenPublishing {
    publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()
    coordinates(artifactId = "jlayer")

    pom {
        name.set("JLayer")
        description.set("MP3 Decoder in pure Java")
        url.set("https://github.com/AgentStart1/jlayer")
        licenses {
            license {
                name.set("GNU Lesser General Public License v3.0")
                url.set("https://www.gnu.org/licenses/lgpl-3.0.html")
            }
        }
        developers {
            developer {
                id.set("AgentStart1")
                name.set("AgentStart1")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/AgentStart1/jlayer.git")
            developerConnection.set("scm:git:ssh://github.com:AgentStart1/jlayer.git")
            url.set("https://github.com/AgentStart1/jlayer")
        }
    }
}
