# Hibernate in Bus Booking System 

This is a simple command-line application for booking bus tickets using Hibernate ORM for database interactions.

## Introduction

This project is a Java-based bus booking system that allows users to book bus tickets through a command-line interface. It provides basic functionalities like displaying bus information, booking tickets, and canceling bookings.

## Features

- Display bus information
- Book bus tickets
- Cancel booked tickets

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6.0 or higher
- A relational database (e.g., MySQL, PostgreSQL)
- Hibernate 5.x or higher

## Installation

1. Clone the repository:

   `
   git clone https://github.com/your-username/busReservation.git
   `


2. Navigate to the project directory:
  `
  cd busReservation
  `
3. Update the `hibernate.cfg.xml` file with your database configuration:

```xml
<!DOCTYPE hibernate-configuration PUBLIC
  "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
  "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
  <session-factory>
      <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
      <property name="hibernate.connection.password">MySQL@22</property>
      <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/bus_reservation</property>
      <property name="hibernate.connection.username">root</property>
      <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
      <property name="hbm2ddl.auto">create</property>
      <property name="show_sql">true</property>
  </session-factory>
</hibernate-configuration>
```


## Usage
Run the App class:
`
java com.gokul.BusResevHibernate.App
`

Follow the prompts to book or cancel bus tickets.

## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the project
2. Create your feature branch `(git checkout -b feature/YourFeature)`
3. Commit your changes` (git commit -am 'Add some feature')`
4. Push to the branch `(git push origin feature/YourFeature)`
5. Open a pull request
Please make sure to update tests as appropriate.

## License
This project is licensed under the [MIT License](https://github.com/gokulgajapathi/BusReservation/blob/main/LICENSE).
