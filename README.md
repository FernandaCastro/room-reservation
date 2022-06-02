# Room Reservation

This project is based on the idea proposed by Frank Moley in his course called "Learning Spring with Spring Boot" at LinkedIn Learning.

- Using remote database (Postgres container)
- Building a service abstraction
- Using the IoC paradigm in Spring to develop a service layer
- Building a controller (@Controller)
- Using Thymeleaf and html/css/js 
- Testing a controller with MockMvc
- Exposing a service layer through REST (@RestController)

## How to run it?

#### Start the postgres container in Docker
Navigate to the project folder
```
docker compose up -d
```

#### Compile and Start the application
```
mvn clean package
java -jar ./target/room-reservation-1.0-SNAPSHOT.jar
```
#### Navigate in your browser to http://localhost:8080/index.html 

#### Explore the available web pages:

```
/guests

/reservations
/reservations?date=2022-06-01
```

Make REST API requests to 
```
GET /api/reservations
GET /api/reservations?date=2022-06-01
```
