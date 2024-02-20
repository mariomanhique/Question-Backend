plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.mariomanhique"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("javax.xml.bind:jaxb-api:2.3.0")
    compileOnly ("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

//    implementation("com.github.javafaker:javafaker:1.0.2")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
