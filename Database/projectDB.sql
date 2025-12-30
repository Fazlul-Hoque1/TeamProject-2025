-- creating the databases
CREATE DATABASE eventdb;
CREATE DATABASE app_user;

-- main event table
-- USE eventdb;

-- adding necessary fields and attributes
CREATE TABLE event ( 
    PRIMARY KEY (event_id),
    event_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(55),
    date_e VARCHAR(55),
    location VARCHAR(55),
    description_n VARCHAR(150),
    createdBy INT NOT NULL,
    joinedBy INT
);

-- user table
USE app_user;

-- adding the necessary fields and attributes for the app_user db table
CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id)
    UNIQUE (username),
);
