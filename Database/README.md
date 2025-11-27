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





