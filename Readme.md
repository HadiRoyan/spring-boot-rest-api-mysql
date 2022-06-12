# Rest API with Spring Boot
Rest API using Spring Web MVC, Spring Data JPA, Spring Validation and MySQL database.

## API Endpoint
Student Endpoint : 
```text
POST : http://localhost:8080/api/students
GET : http://localhost:8080/api/students/{name}
GET : http://localhost:8080/api/students
PUT : http://localhost:8080/api/students/{name}
DELETE : http://localhost:8080/api/students/{name}
```
Course EndPoint : 
```text
POST : http://localhost:8080/api/courses
GET : http://localhost:8080/api/courses/{title}
GET : http://localhost:8080/api/courses
PUT : http://localhost:8080/api/courses/{title}
DELETE : http://localhost:8080/api/courses/{title}
```

## Installation
1. download or clone project from this repository
2. create MySQL database `create school_management_system`
3. open project with IDE or Text Editor
4. change username and password 
   - open `src/main/resources/application.properties`
   - change `spring.datasource.username` and `spring.datasource.password`
5. Build and run using maven `mvn spring:boot run`
6. test with postman



