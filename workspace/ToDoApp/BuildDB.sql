DROP DATABASE IF EXISTS to_do_app_db;
CREATE DATABASE to_do_app_db;
USE to_do_app_db;

CREATE TABLE users( 
  userID int NOT NULL AUTO_INCREMENT,
  first_name varchar(64) NOT NULL,
  last_name varchar(64) NOT NULL,
  username varchar(64) NOT NULL,
  password varchar(64) NOT NULL,
  location varchar(64) NOT NULL,
  gender varchar(64) NOT NULL,
  PRIMARY KEY (userID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE tasks( 
  taskID int NOT NULL AUTO_INCREMENT,
  userID int NOT NULL,
  task varchar(64) NOT NULL,
  date_created datetime NOT NULL,
  description varchar(64) NOT NULL,
  PRIMARY KEY (taskID),
  FOREIGN KEY (userID) REFERENCES users(userID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

