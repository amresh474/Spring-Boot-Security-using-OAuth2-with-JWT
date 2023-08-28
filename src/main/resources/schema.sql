CREATE TABLE employee
(
 employeeName varchar(100) NOT NULL,
  employeeId varchar(11) NOT NULL ,
 employeeAddress varchar(100) DEFAULT NULL,
 employeeEmail varchar(100) DEFAULT NULL,
 PRIMARY KEY (employeeId)
);

CREATE TABLE USERS (ID INT PRIMARY KEY, USERNAME VARCHAR(50), PASSWORD VARCHAR(70));