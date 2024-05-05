create table bus (
    busno int primary key,
    ac BOOLEAN,
    capacity int
);

create table booking (
    id int primary key AUTO_INCREMENT,
    busno int,
    passengername varchar(50),
    dateofjourney date
);