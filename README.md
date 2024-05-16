# Bus Reservation System using Spring JDBC with JDBC Template


## Description
The Bus Reservation System is a Java application designed to manage bus bookings, bus routes, and user authentication. It allows administrators to add and cancel buses, and view bookings, while passengers can book and cancel bus tickets.


## Features
- **Admin Panel**: Administrators can log in, add buses, cancel buses, and view all bookings.
  
- **Passenger Panel**: Passengers can log in, book bus tickets, cancel booked tickets, and view available buses.


## Technologies Used
- Java
- Spring Framework
- Spring Boot
- Spring JDBC
- MySQL
- Maven

  

## Setup Instructions

1. **Clone the Repository**:

`
git clone https://github.com/gokulgajapathi/BusReservation.git
`

Navigate to the project directory:
`
cd busReservation
`

2. **Database Setup**:
- Set up a MySQL database and import the schema from `src/main/resources/schema.sql`.
- Optionally, you can import sample data from `src/main/resources/data.sql`.


## Usage
Run the BusReservationApplication class:
`
java com.gokul.BusReservationApplication
`

Follow the prompts to book or cancel bus tickets.


## Contributing
Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1. Fork the project
2. Create your feature branch `(git checkout -b feature/YourFeature)`
3. Commit your changes ` (git commit -am 'Add some feature')`
4. Push to the branch `(git push origin feature/YourFeature)`
5. Open a pull request
Please make sure to update tests as appropriate.

## License
This project is licensed under the [MIT License](https://github.com/gokulgajapathi/BusReservation/blob/main/LICENSE).
