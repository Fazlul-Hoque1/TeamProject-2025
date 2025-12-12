-- creating the databases
CREATE DATABASE eventdb;
CREATE DATABASE app_user;

-- main event table
-- USE eventdb;

-- adding necessary fields and attributes
CREATE TABLE event ( 
    event_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(55),
    date_e VARCHAR(55),
    location VARCHAR(55),
    description_n VARCHAR(150),
    PRIMARY KEY (event_id)
);

-- user table
USE app_user;

-- adding the necessary fields and attributes for the app_user db table
CREATE TABLE users (
    user_id INT,
    username VARCHAR(50),
    password VARCHAR(255),
    email VARCHAR(100),
    role VARCHAR(50),
    PRIMARY KEY (user_id),
);
