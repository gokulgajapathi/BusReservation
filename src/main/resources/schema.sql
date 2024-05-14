create table bus (
     busNo INT PRIMARY KEY,
     ac BOOLEAN,
     capacity INT,
     driverName VARCHAR(100),
     startingPoint VARCHAR(100),
     endingPoint VARCHAR(100)
);

create table booking (
    id int primary key AUTO_INCREMENT,
    busno int,
    passengername varchar(50),
    dateofjourney date
);