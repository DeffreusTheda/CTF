plugins {
    id("java")
}

group = "org.effietheda"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.javassist:javassist:3.29.2-GA")
}

tasks.test {
    useJUnitPlatform()
}