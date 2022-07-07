package by.devincubator.vehicle;

public class TechnicalSpecialist {
    public static final int LOWER_LIMIT_MANUFACTURE_YEAR = 1886;
    private static final String REGEX_REGISTRATION_NUMBER = "[0-9]{4}\\ [A-Z]{2}\\-[0-9]";

    static public boolean validateManufactureYear(int year) {
        int length = String.valueOf(year).length();
        return year >= LOWER_LIMIT_MANUFACTURE_YEAR && length == 4;
    }

    static public boolean validateMileage(int mileage) {
        return mileage > 0;
    }

    static public boolean validateWeight(int weight) {
        return weight > 0;
    }

    static public boolean validateColor(Color color) {
        return color != null;
    }

    static public boolean validateVehicleType(VehicleType type) {
        return type.getTaxCoefficient() > 0 && type.getName() != null && !type.getName().isEmpty();
    }

    static public boolean validateModelName(String name) {
        return !name.isEmpty();
    }

    static public boolean validateRegistrationNumber(String number) {
        return number.matches(REGEX_REGISTRATION_NUMBER);
    }
}
