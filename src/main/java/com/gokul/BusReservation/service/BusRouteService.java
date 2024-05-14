package com.gokul.BusReservation.service;

import com.gokul.BusReservation.model.BusRoute;
import com.gokul.BusReservation.repo.BusRouteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

@Service
public class BusRouteService {

    @Autowired
    private BusRouteDAO busRouteDAO;

    public void setBusStop (List<BusRoute> busStops) {
        for (BusRoute stop : busStops) {
            busRouteDAO.saveBusStop(stop);
        }
    }

    public List<BusRoute> addBus(int num) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter bus details:");
        int busNumber = num;

        System.out.print("Number of stops: ");
        int numStops = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<BusRoute> busRoutes = new ArrayList<>();
        for (int i = 0; i < numStops; i++) {
            char stopName = Character.highSurrogate(i + 65);

            System.out.printf("Stop %c time (HH:MM format): ", i + 65);
            String stopTimeStr = scanner.nextLine();
            LocalTime stopTime = LocalTime.parse(stopTimeStr, DateTimeFormatter.ofPattern("HH:mm"));

            busRoutes.add(new BusRoute(stopName, stopTime));
        }
        //saveBusWithStops(busNumber, busRoutes);
        return busRoutes;
    }

    /*private void saveBusWithStops(int busNumber, List<BusRoute> busRoutes) {
        // Save bus details to database, you can implement this method based on your DAO classes
        System.out.println("Saving bus details to the database...");

        // Example: Saving bus details and stops
        System.out.println("Bus number: " + busNumber);
        for (BusRoute route : busRoutes) {
            System.out.println("Stop: " + route.getStopName() + ", Time: " + route.getStopTime());
            busRouteDAO.saveBusStop(route);
        }

        System.out.println("Bus details saved successfully.");
    }*/
}
