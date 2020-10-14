CREATE database customerdb;
USE customerdb;

CREATE TABLE customer(
id int AUTO_INCREMENT NOT NULL,
firstName varchar(60) NOT NULL,
lastName varchar(60) NOT NULL,
middleName varchar(60) ,
PRIMARY KEY (id)
);
INSERT INTO customer VALUES
(1, 'tony', 'stark', NULL),
(2, 'steve', 'rogers', NULL),
(3, 'bruce', 'banner', NULL);
INSERT INTO customer (firstname, lastname, middlename) VALUES
('tony', 'stark', NULL),
('steve', 'rogers', NULL);

CREATE TABLE contact(
id int AUTO_INCREMENT NOT NULL,
customerId int NOT NULL,
isPrimaryContact bit NOT NULL,
phoneNumber int NOT NULL,
secondaryPhoneNumber int ,
homeAddress varchar(60) NOT NULL,
zip int NOT NULL,
state varchar(30) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (customerId) REFERENCES customer(id)
);
INSERT INTO contact (customerId, isPrimaryContact, phoneNumber, secondaryPhoneNumber, homeAddress, zip, state ) VALUES
(1,1,1234567789,745463321,'123 Marvel st.',25632,'NY'),
(1,0,1234567789,NULL,'123 Marvel st.',25632,'NY'),
(2,1,1234567789,745463321,'123 Marvel st.',25632,'NY'),
(3,1,1234567789,NULL,'123 Marvel st.',25632,'NY');

