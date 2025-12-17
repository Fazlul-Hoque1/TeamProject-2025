During Sprint 1 my responsibility was Database and Testing:<br>
-- Designing the initial database schema<br>
-- Configuring and connecting the database<br>
-- Ensuring backend <-> database communication works<br>

------------------------------------------------------------------------

We decided to use MySQL as the database for the project. The configuration was completed together with the backend developer (Zain) using:<br>
-- Spring Boot (a backend framework)<br>
-- Railway (a database hosting)<br>


Here spring boot handles database connectivity through its application.properties configuration. Below is the configuration used to connect spring boot with the MySQL database (also used for the initial testing/configuration):<br>

//points to the MySQL database <br> 
__spring.datasource.url=jdbc:mysql://localhost:3306/eventdb__ 

//username and password used for authentication<br>
__spring.datasource.username=root__<br>
__spring.datasource.password=adminn__ 

//registers the MySQL JDBC driver<br>
__spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver__ 

//automatically updates database tables when Entity classes change, useful during development<br>
__spring.jpa.hibernate.ddl-auto=update__ 

[This configuration connected Spring Boot to a locally installed MySQL database (eventdb). It was used to test the initial setup, entity mapping, and the creation of event related tables]

-------------------------------------------------------------------------

Railway database configuration (used for main project):

//points to the Railway MySQL database<br>
__spring.datasource.url=jdbc:mysql://mysql.railway.internal:3306/railway__

//username and password used for authentication<br>
__spring.datasource.username=root__<br>
__spring.datasource.password=********************************__

//ensures tables are automatically created and updated based on the entity classes<br>
__spring.jpa.hibernate.ddl-auto=update__

[This configuration allows the backend to connect to Railway’s MySQL instance, which serves as the primary database for the project. All event data is now stored remotely, making it accessible for the entire team and stable enough for deployment]

-------------------------------------------------------------------------

After we configuring the database locally, we developed the same setup through Railway allowing:<br>
-- Remote MySQL hosting<br>
-- A stable backend <-> database connection<br>
-- Easier access for the team<br>

-------------------------------------------------------------------------

Testing: <br>
As part of my testing, I used Postman to verify communication between the backend and the MySQL database. Postman allowed us to manually send HTTP requests to the Spring Boot API and confirm that the backend was correctly handling requests and interacting with the database. <br>

Postman communicates with the backend by sending requests to the API endpoints exposed by the Spring Boot server. After running the backend locally, the server is available on "http://localhost:8080". Main HTTP Methods Used for Endpoints: GET, POST, PUT, PATCH, DELETE....

What I tested using postman was I validated all basic CRUD operations for the Events :
1) Tested the connection using "GET http://localhost:8080/events" which verified the backend could retrieve data from the database (confirmed that the endpoint responded without errors, proving that the backend <-> database link was working perfectly fine).

2) Created a new event by sending the POST request to the localhost:8080 and adding the body

"{<br>
  "title": "Test Event",<br>
  "date_e": "2025-02-01",<br>
  "location": "Campus A",<br>
  "description_n": "This is a sample event for testing."<br>
}"<br>

This successfully created a new event in the database, showing a new row in the eventdb table in MySQL meaning the connection between backend and database is working 100%.

This manual API testing confirmed that the core functionality of the sprint is working pecfectly.

-------------------------------------------------------------------------








