CREATE TABLE IF NOT EXISTS person (
  id varchar(36) NOT NULL PRIMARY KEY,
  name varchar(25) NOT NULL,
  age INT NOT NULL
);

INSERT INTO person(id, name, age) VALUES ('c626b4bf-af69-42b6-9e12-3fca6d9c3b2c', 'Jake', 24);
INSERT INTO person(id, name, age) VALUES ('3200ff01-a291-4451-93c3-366d447ee1eb', 'Fred', 41);