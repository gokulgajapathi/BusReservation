INSERT INTO bus (bus_no, ac, capacity, driver_name, starting_point, ending_point, stops, fare)
VALUES
    (1, true, 40, 'John Doe', 'City Center', 'Suburbia', 4, 40),
    (2, false, 30, 'Jane Smith', 'Airport', 'Downtown', 3, 30),
    (3, true, 50, 'Michael Johnson', 'Shopping Mall', 'Business District', 5, 50),
    (4, true, 45, 'Emily Brown', 'University Campus', 'Residential Area', 4, 40),
    (5, false, 35, 'David Lee', 'Train Station', 'Industrial Zone', 6, 60);

-- Insert sample data for bus number 1
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('A', '08:00:00', 1);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('B', '08:30:00', 1);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('C', '09:00:00', 1);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('D', '09:30:00', 1);

-- Insert sample data for bus number 2
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('F', '08:15:00', 2);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('G', '08:45:00', 2);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('H', '09:15:00', 2);

-- Insert sample data for bus number 3
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('K', '08:10:00', 3);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('L', '08:40:00', 3);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('M', '09:10:00', 3);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('N', '09:40:00', 3);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('O', '10:10:00', 3);

-- Insert sample data for bus number 4
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('A', '08:20:00', 4);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('B', '08:50:00', 4);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('C', '09:20:00', 4);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('D', '09:50:00', 4);

-- Insert sample data for bus number 5
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('K', '08:25:00', 5);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('L', '08:55:00', 5);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('M', '09:25:00', 5);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('N', '09:55:00', 5);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('O', '10:25:00', 5);
INSERT INTO route (stop_name, stop_time, bus_no) VALUES ('P', '10:45:00', 5);
