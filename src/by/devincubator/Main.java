package by.devincubator;

import by.devincubator.engine.GasolineEngine;
import by.devincubator.vehicle.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    private static final String PATH = "./src/resources/data/";
    private static final String TYPES_PATH = PATH + "types.csv";
    private static final String VEHICLES_PATH = PATH + "vehicles.csv";
    private static final String RENTS_PATH = PATH + "rents.csv";

    public static void main(String[] args) {
        MyComparator comparator = new MyComparator();
        VehicleCollection collection = new VehicleCollection(TYPES_PATH, VEHICLES_PATH, RENTS_PATH);
        VehicleStack<Vehicle> list = new VehicleStack<>();

        for (Vehicle v : collection.getVehicleList()) {
            list.push(v);
            System.out.println("Auto " + v.getId() + " drove into the garage");
        }
        System.out.println("Garage is full");
        while (!list.isEmpty()) {
            System.out.println("Auto " + list.pop().getId() + " drove out the garage");
        }
    }

    private static List<Rent> createListRent() {
        List<Rent> list = new ArrayList<>();
        list.add(new Rent(8, new Date(), 100));
        list.add(new Rent(8, new Date(), 50));
        return list;
    }

    private static Vehicle createVehicle() {
        return new Vehicle(
                8,
                new VehicleType(1, "Bus", 1.2),
                "Volkswagen ",
                "5437 AX-7",
                2022,
                2015,
                36000,
                Color.BLUE,
                new GasolineEngine(2, 75, 8.1),
                createListRent());
    }
}