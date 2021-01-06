plugins {
    kotlin("jvm")
    application
}

group = "me.scurab"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":shared"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.create<Jar>("assembleDistFatJar") {
    manifest {
        attributes["Main-Class"] = "com.scurab.mpp.jvm.AppKt"
    }
    group = "build"
    archiveBaseName.set(project.name)
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    with(tasks["jar"] as CopySpec)
}
