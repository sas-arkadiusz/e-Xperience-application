# e-Xperience Application

## Table of contents
* [General Info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Application](#application)


## General Info
This repository contains web application that returns the name of the latest modified repository.

## Technologies
This project is created with:
* Application: Java, Spring
* Tests: JUnit4, MockMvc
* Serialize/Deserialize JSON: Jackson

## Setup
1. Building
* To build the project use following command: mvn clean package

2. Running
* After building the application run following command to start it: `java -jar target/cognifide.book.library.management-0.0.1-SNAPSHOT.jar`.
* You can also start the application with following command: `mvn spring-boot:run`. <br>

* By default, the application runs on 8090 port. To run the application on custom port use following command: `mvn spring-boot:run -Dspring-boot.run.arguments=--server.port={your port}`.

## API
* To display user's latest modified repository use following path: `http://localhost:8090/latestModifiedRepository`
