During Sprint 1 my responsibility was Database and Testing:<br>
-- Designing the initial database schema<br>
-- Configuring and connecting the database<br>
-- Ensuring backend <-> database communication works<br>

------------------------------------------------------------------------

We decided to use MySQL as the database for the project. The configuration was completed together with the backend developer (Zain) using:<br>
-- Spring Boot (a backend framework)<br>
-- Railway (a database hosting)<br>


Here spring boot handles database connectivity through its application.properties configuration. Below is the configuration used to connect spring boot with the MySQL database (also used for the initial testing/configuration):<br>

//points to the MySQL database
**spring.datasource.url=jdbc:mysql://localhost:3306/eventdb**

//username and password used for authentication
**spring.datasource.username=root**
**spring.datasource.password=adminn**

//registers the MySQL JDBC driver
**spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver**

//automatically updates database tables when Entity classes change, useful during development
**spring.jpa.hibernate.ddl-auto=update**

[This configuration connected Spring Boot to a locally installed MySQL database (eventdb). It was used to test the initial setup, entity mapping, and the creation of event related tables]

-------------------------------------------------------------------------

After we configuring the database locally, we developed the same setup through Railway allowing:<br>
-- Remote MySQL hosting<br>
-- A stable backend <-> database connection<br>
-- Easier access for the team<br>





