create table bus (
     bus_no INT PRIMARY KEY,
     ac BOOLEAN,
     capacity INT,
     driver_name VARCHAR(100),
     starting_point VARCHAR(100),
     ending_point VARCHAR(100),
     stops int,
     fare int
);

create table booking (
    id int primary key AUTO_INCREMENT,
    bus_no int,
    passenger_name varchar(50),
    destination varchar(10),
    date_of_journey date
);

create table route (
    route_id INT PRIMARY KEY AUTO_INCREMENT,
    stop_name VARCHAR(10),
    stop_time TIME,
    bus_no INT,
    CONSTRAINT FK_busNo FOREIGN KEY(bus_no) REFERENCES bus(bus_no)
);