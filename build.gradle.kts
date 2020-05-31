/*
 * This file was generated by the Gradle 'init' task.
 */
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    //id 'java'
    //id 'maven-publish'
    id("org.springframework.boot") version "2.3.0.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.3.72"
    kotlin("plugin.spring") version "1.3.72"
}

repositories {
    mavenLocal()
    maven {
        //url = uri('http://repo.maven.apache.org/maven2')
        url = uri("https://maven.aliyun.com/repository/central")
    }
}

dependencies {
    // groupId:artifactId:version
    implementation ("cn.hutool:hutool-all:5.3.2")
    implementation ("commons-lang:commons-lang:2.6")
    implementation ("com.ibeetl:beetl-framework-starter:1.2.30.RELEASE")
    implementation ("com.squareup.okhttp3:okhttp:3.14.7")
    implementation ("com.zaxxer:HikariCP:3.4.2")
    implementation ("mysql:mysql-connector-java:8.0.19")
    implementation ("org.lionsoul:ip2region:1.4")
    implementation ("org.projectlombok:lombok:1.18.12")
    implementation ("org.springframework.boot:spring-boot-starter-actuator:2.2.6.RELEASE")
    implementation ("org.springframework.boot:spring-boot-devtools:2.2.6.RELEASE")
    implementation ("org.springframework.boot:spring-boot-starter-aop:2.2.6.RELEASE")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa:2.2.6.RELEASE")
    implementation ("org.springframework.boot:spring-boot-starter-data-redis:2.2.6.RELEASE")
    implementation ("org.springframework.boot:spring-boot-starter-test:2.2.6.RELEASE")
    implementation ("org.springframework.boot:spring-boot-starter-undertow:2.2.6.RELEASE")
    implementation("org.springframework.boot:spring-boot-starter-web:2.2.6.RELEASE"){
        exclude (module = "spring-boot-starter-tomcat")
    }
    implementation ("org.springframework:spring-jdbc:5.2.5.RELEASE")
    implementation ("org.springframework:spring-tx:5.2.5.RELEASE")
    implementation ("redis.clients:jedis:3.2.0")

    // lombok
    compileOnly ("org.projectlombok:lombok:1.18.12")
    annotationProcessor ("org.projectlombok:lombok:1.18.12")

    testCompileOnly ("org.projectlombok:lombok:1.18.12")
    testAnnotationProcessor ("org.projectlombok:lombok:1.18.12")

    testCompileOnly ("org.mockito:mockito-core")
}

group = "com.d7kj.learn"
version = "0.0.1-SNAPSHOT"
// sourceCompatibility = "1.8"
java.sourceCompatibility = JavaVersion.VERSION_1_8
/*
publishing {
    publications {
        maven(MavenPublication) {
            from(components.java)
        }
    }
}

*/
tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

/*apply(plugin = "org.springframework.boot")*/