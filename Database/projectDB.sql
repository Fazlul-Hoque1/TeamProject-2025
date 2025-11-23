-- creating the database for users and events 
create DATABASE userdb;
create DATABASE eventdb;

-- using use eventdb to access the main table
USE eventdb;

-- adding necessary fields and attributes
CREATE TABLE event (
	event_id INT NOT NULL AUTO_INCREMENT,
    title varchar(10),
    date_e  varchar(10),
    location varchar(10),
    description_n varchar(50)
    )
