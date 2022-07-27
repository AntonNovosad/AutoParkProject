package by.devincubator.vehicle;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MechanicService implements Fixer {
    private static String[] details = {"Фильтр", "Втулка", "Вал", "Ось", "Свечка", "Масло", "ГРМ", "ШРУС"};
    private static final String PATH_ORDERS_FILE = "./src/resources/data/orders.csv";
    private static final int MIN_NUMBER_OF_BROKEN = 0;
    private static final int MAX_NUMBER_OF_BROKEN = 4;
    private static final int MIN_NUMBER_OF_DETAILS = 1;
    private static final int MAX_NUMBER_OF_DETAILS = 3;
    private static final String REGEX = ".+";

    @Override
    public Map<String, Integer> detectBreaking(Vehicle vehicle) {
        Map<String, Integer> map = new HashMap<>();
        fillMap(map);
        if (!map.isEmpty()) {
            String line = createStringFromMap(map, vehicle);
            writeString(line, PATH_ORDERS_FILE);
        }
        return map;
    }

    @Override
    public void repair(Vehicle vehicle) {
        List<String> list = readFile(PATH_ORDERS_FILE);
        if (isBroken(vehicle)) {
            list.removeIf(i -> i.matches(vehicle.getId() + REGEX));
        }
        writeList(list, PATH_ORDERS_FILE);
    }

    @Override
    public boolean isBroken(Vehicle vehicle) {
        List<String> list = readFile(PATH_ORDERS_FILE);
        for (String str : list) {
            if (str.matches(vehicle.getId() + REGEX)) {
                return true;
            }
        }
        return false;
    }

    private void fillMap(Map<String, Integer> map) {
        int numberOfBroken = getRandomInteger(MIN_NUMBER_OF_BROKEN, MAX_NUMBER_OF_BROKEN);
        int counter = 0;
        while (counter != numberOfBroken) {
            String randomDetails = details[getRandomInteger(0, details.length - 1)];
            int numberOfDetails = getRandomInteger(MIN_NUMBER_OF_DETAILS, MAX_NUMBER_OF_DETAILS);
            map.put(randomDetails, numberOfDetails);
            counter++;
        }
    }

    private String createStringFromMap(Map<String, Integer> map, Vehicle vehicle) {
        String line = String.valueOf(vehicle.getId());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            line = line + "," + entry.getKey() + "," + entry.getValue();
        }
        line = line + "\n";
        return line;
    }

    private void writeString(String line, String fileName) {
        try {
            Files.write(Paths.get(fileName), line.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void writeList(List<String> list, String fileName) {
        try {
            Files.write(Paths.get(fileName), list, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<String> readFile(String inFile) {
        List<String> list = null;
        try {
            list = Files.readAllLines(Paths.get(inFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static int getRandomInteger(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1) + min);
    }

    public void showVehicleWithoutBrokenDetails(List<Vehicle> listVehicle) {
        listVehicle.forEach(vehicle -> {
            if (!isBroken(vehicle)) {
                System.out.println("Auto #" + vehicle.toString() + " not broken");
            }
        });
    }

    public void showVehicleWithMaxBrokenDetails(List<Vehicle> listVehicle) {
        List<String> list = readFile(PATH_ORDERS_FILE);
        int max = findMaxNumberBrokenDetails();
        list.forEach(s -> {
            if (max == findNumberBrokenDetails(s)) {
                listVehicle.forEach(vehicle -> {
                    if (s.matches(vehicle.getId() + REGEX)) {
                        System.out.println("Vehicle with max broken details: " + vehicle);
                    }
                });
            }
        });
    }

    private int findMaxNumberBrokenDetails() {
        List<String> list = readFile(PATH_ORDERS_FILE);
        int max = 0;
        for (String str : list) {
            if (max < findNumberBrokenDetails(str)) {
                max = findNumberBrokenDetails(str);
            }
        }
        return max;
    }

    private int findNumberBrokenDetails(String str) {
        int numberOfDetail = 0;
        String[] array = str.split(",");
        for (int i = 1; i < array.length; i++) {
            if (array[i].matches("[1-3]")) {
                numberOfDetail += Integer.parseInt(array[i]);
            }
        }
        return numberOfDetail;
    }
}
