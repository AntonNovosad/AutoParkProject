package by.devincubator.vehicle;

public class TechnicalSpecialist {
    public static final int LOWER_LIMIT_MANUFACTURE_YEAR = 1886;

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
        char[] chars = number.toCharArray();
        if (number == null) {
            return false;
        }
        if (!checkNumber(chars[0]) || !checkNumber(chars[1]) || !checkNumber(chars[2]) || !checkNumber(chars[3]) || !checkNumber(chars[8])) {
            return false;
        }
        if (!checkString(number.substring(5, 7))) {
            return false;
        }
        if (!checkSymbol(' ', number, 4) && !checkSymbol('-', number, 7)) {
            return false;
        }
        return true;
    }

    static private boolean checkNumber(char number) {
        return number >= '0' && number <= '9';
    }

    static private boolean checkString(String str) {
        if (str != null) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < 'A' || str.charAt(i) > 'Z') {
                    return false;
                }
            }
        }
        return true;
    }

    static private boolean checkSymbol(char symbol, String str, int index) {
        return str.charAt(index) == symbol;
    }
}
