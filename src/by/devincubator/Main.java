package by.devincubator;

public class Main {
    public static void main(String[] args) {
        VehicleType[] types = createArray();
        showTypes(types);
        setCoefficientInTypes(types);
        findMaxCoefficient(types);
        findAverageCoefficient(types);
        competeAllPoints(types);
    }

    private static VehicleType[] createArray() {
        VehicleType bus = new VehicleType("Bus", 1.2);
        VehicleType car = new VehicleType("Car", 1);
        VehicleType rink = new VehicleType("Rink", 1.5);
        VehicleType tractor = new VehicleType("Tractor", 1.2);
        return new VehicleType[]{bus, car, rink, tractor};
    }

    private static void showTypes(VehicleType[] types) {
        for (VehicleType v : types) {
            System.out.println(v.display());
        }
    }

    private static void setCoefficientInTypes(VehicleType[] types) {
        for (int i = 0; i < types.length; i++) {
            if (i == types.length - 1) {
                types[i].setTaxCoefficient(1.3);
            }
        }
    }

    private static void findMaxCoefficient(VehicleType[] types) {
        double max = 0;
        for (int i = 0; i < types.length; i++) {
            if (types[i].getTaxCoefficient() > max) {
                max = types[i].getTaxCoefficient();
            }
        }
        System.out.println(max);
    }

    private static void findAverageCoefficient(VehicleType[] types) {
        double average = 0;
        for (int i = 0; i < types.length; i++) {
            average += types[i].getTaxCoefficient();
        }
        System.out.println(average / types.length);
    }

    private static void competeAllPoints(VehicleType[] types) {
        boolean isComplete = true;
        while (isComplete) {
            showTypes(types);
            findMaxCoefficient(types);
            findAverageCoefficient(types);
            isComplete = false;
        }
    }
}