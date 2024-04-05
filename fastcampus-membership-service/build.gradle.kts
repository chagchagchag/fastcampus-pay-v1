plugins {
	java
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
}

extra["axonVersion"] = "4.9.2"

group = "io.chagchagchag.ddd.fastcampus_v1.membership"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(project(":fastcampus-common"))
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
//	implementation("org.axonframework:axon-configuration:${property("axonVersion")}")
//	implementation("org.axonframework:axon-spring-boot-starter:${property("axonVersion")}")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
//	testImplementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.5.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}