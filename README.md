# University-Event-Management
# UserValidations
### Requirements
* IntelliJIDEA
* ServerPort: 8080 (use: localhost:8080)
* Java version: 17
* Everything is present in the pom.xml (no need to download any library)
### Steps to run the Project
* Download the source code and import in IntelliJ idea.
* Go to localhost:8080/
* Put specific end_points beside the port accordingly to run the project to access and modify the data
# Dependencies
## Validation
* Bean Validation with Hibernate validator.
## Spring Web
* Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
## Spring Boot DevTools
* Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
## Spring Data JPA
* Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
## Lombok
* Java annotation library which helps to reduce boilerplate code.
# Project Structure(MVC Structure)
## Model
* Event
* Student
## Controller
* EventContoller
* StudentController
## Service
* EventService
* StudentService
## Repository
* EventRepository
* StudentRepository
# EndPoints
* Add student
* update student department
* delete student
* Get all students
* Get student by Id
* Add event
* Update event
* Delete event
* Get All events by date

# Working
* Project mainly focuses on how to create api for the event and map their relation to the Students before saving the data to the database.
* In this project we had used the H2 Database.
* In this project We have created API for the event and Students. 
