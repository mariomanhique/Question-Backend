plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
//    id ("com.bmuschko.docker-remote-api") version "6.7.0"
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
//    implementation("org.hibernate:hibernate-entitymanager:5.6.15.Final")
//    implementation("org.hibernate:hibernate-core:6.4.1.Final")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
