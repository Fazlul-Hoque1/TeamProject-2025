-- creating the database for users and events 
create DATABASE userdb;
create DATABASE eventdb;

-- using use eventdb to access the main table
USE eventdb;

-- adding necessary fields and attributes
CREATE TABLE event (
	event_id INT NOT NULL AUTO_INCREMENT,
    title varchar(55),
    date_e  varchar(55),
    location varchar(55),
    description_n varchar(150)
	primary key (event_id)
    )
