use testeventdb;

INSERT INTO event (title, date_e, location, description_n)
VALUES
('Music Night', '2025-12-05', 'Auditorium', 'Live music performances by local bands'),
('Coding Workshop', '2025-12-10', 'Room 101', 'Hands-on workshop for beginners'),
('Art Exhibition', '2025-12-15', 'Gallery Hall', 'Showcasing student artwork');

SELECT * FROM testeventdb.event;
