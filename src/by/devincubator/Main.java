package by.devincubator;

import by.devincubator.engine.DieselEngine;
import by.devincubator.engine.ElectricalEngine;
import by.devincubator.engine.GasolineEngine;
import by.devincubator.vehicle.Color;
import by.devincubator.vehicle.Vehicle;
import by.devincubator.vehicle.VehicleType;

public class Main {
    public static void main(String[] args) {
        Vehicle[] types = createArrayVehicle();
        showTypes(types);
    }

    private static VehicleType[] createArrayVehicleType() {
        VehicleType bus = new VehicleType("Bus", 1.2);
        VehicleType car = new VehicleType("Car", 1);
        VehicleType rink = new VehicleType("Rink", 1.5);
        VehicleType tractor = new VehicleType("Tractor", 1.2);
        return new VehicleType[]{bus, car, rink, tractor};
    }

    private static Vehicle[] createArrayVehicle() {
        VehicleType[] types = createArrayVehicleType();
        Vehicle car1 = new Vehicle(
                types[0],
                "Volkswagen Crafter",
                "5427 AX-7",
                2022,
                2015,
                376000,
                Color.BLUE,
                new GasolineEngine(2, 75, 8.1)
        );
        Vehicle car2 = new Vehicle(
                types[0],
                "Volkswagen Crafter",
                "6427 AA-7",
                2500,
                2014,
                227010,
                Color.WHITE,
                new GasolineEngine(2.18, 75, 8.5)
        );
        Vehicle car3 = new Vehicle(
                types[0],
                "Electric Bus E321",
                "6785 BA-7",
                12080,
                2019,
                20451,
                Color.GREEN,
                new ElectricalEngine(50, 150)
        );
        Vehicle car4 = new Vehicle(
                types[1],
                "Golf 5",
                "8682 AX-7",
                1200,
                2006,
                230451,
                Color.GRAY,
                new DieselEngine(1.6, 55, 7.2)
        );
        Vehicle car5 = new Vehicle(
                types[1],
                "Tesla Model S 70D",
                "0001 AA-7",
                2200,
                2019,
                10454,
                Color.WHITE,
                new ElectricalEngine(25, 70)
        );
        Vehicle car6 = new Vehicle(
                types[2],
                "Hamm HD 12 VV",
                "1234 FF-7",
                3000,
                2016,
                122,
                Color.YELLOW,
                new DieselEngine(3.2, 20, 25)
        );
        Vehicle car7 = new Vehicle(
                types[3],
                "МТЗ Беларус-1025.4",
                "1145 AB-7",
                1200,
                2020,
                109,
                Color.RED,
                new DieselEngine(4.75, 135, 20.1)
        );
        return new Vehicle[]{car1, car2, car3, car4, car5, car6, car7};
    }

    private static void showTypes(Vehicle[] types) {
        for (Vehicle v : types) {
            System.out.println(v.toString());
        }
    }

    private static void sortByYear(Vehicle[] types) {
        System.out.println("Sorted by Manufacture Year");
        for (int i = 0; i < types.length; i++) {
            for (int j = 0; j < types.length - 1; j++) {
                switch (types[j].compareTo(types[j + 1])) {
                    case -1:
                        Vehicle obj = types[j];
                        types[j] = types[j + 1];
                        types[j + 1] = obj;
                    case 1:
                        Vehicle obj1 = types[j + 1];
                        types[j + 1] = types[j];
                        types[j] = obj1;
                    case 0:
                        types[j] = types[j];
                }
            }
        }
    }

    private static int findMaxMileage(Vehicle[] types) {
        int max = 0;
        for (Vehicle v : types) {
            if (v.getMileage() > max) {
                max = v.getMileage();
            }
        }
        return max;
    }

    private static int findMinMileage(Vehicle[] types) {
        int min = types[0].getMileage();
        for (Vehicle v : types) {
            if (v.getMileage() < min) {
                min = v.getMileage();
            }
        }
        return min;
    }

    private static void printMinOrMax(String text, Vehicle[] types, int number) {
        for (Vehicle v : types) {
            if (v.getMileage() == number) {
                System.out.println(text);
                System.out.println(v);
            }
        }
    }

    private static Vehicle findSameTypes(Vehicle[] types) {
        for (int i = 0; i < types.length; i++) {
            for (int j = i + 1; j < types.length - 1; j++) {
                if (types[i].equals(types[j])) {
                    return types[i];
                }
            }
        }
        return null;
    }

    private static void displaySameTypes(Vehicle[] types) {
        Vehicle vehicle = findSameTypes(types);
        if (vehicle != null) {
            System.out.println(vehicle);
        } else {
            System.out.println("No cars are the same");
        }
    }

    private static double findMaxKilometres(Vehicle[] types) {
        double max = 0;
        for (Vehicle v : types) {
            if (v.getEngine().getMaxKilometers() > max) {
                max = v.getEngine().getMaxKilometers();
            }
        }
        return max;
    }

    private static void displayMaxKilometres(Vehicle[] types) {
        double max = findMaxKilometres(types);
        for (Vehicle v : types) {
            if (v.getEngine().getMaxKilometers() == max) {
                System.out.println("Maximum kilometres traveled: ");
                System.out.println(v);
            }
        }
    }
}