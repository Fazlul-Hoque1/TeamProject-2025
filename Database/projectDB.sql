-- creating the databases
CREATE DATABASE userdb;
CREATE DATABASE eventdb;
CREATE DATABASE testeventdb;

-- main event table
USE eventdb;

-- adding necessary fields and attributes
CREATE TABLE event ( 
    event_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(55),
    date_e VARCHAR(55),
    location VARCHAR(55),
    description_n VARCHAR(150),
    PRIMARY KEY (event_id)
);

-- test event table
USE testeventdb;

CREATE TABLE event (
    event_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(55),
    date_e VARCHAR(55),
    location VARCHAR(55),
    description_n VARCHAR(150),
    PRIMARY KEY (event_id)
);

-- check contents of test table (should be empty)
SELECT * FROM event;
