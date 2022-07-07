package by.devincubator.vehicle;

import java.util.Objects;

public class Vehicle implements Comparable<Vehicle> {
    private VehicleType type;
    private String modelName;
    private String registrationNumber;
    private int weightKg;
    private int manufactureYear;
    private int mileage;
    private Color color;
    private double sizeTank;

    public Vehicle() {
    }

    public Vehicle(VehicleType type,
                   String modelName,
                   String registrationNumber,
                   int weightKg,
                   int manufactureYear,
                   int mileage,
                   Color color,
                   double sizeTank) {
        if (TechnicalSpecialist.validateVehicleType(type)) {
            this.type = type;
        }
        if (TechnicalSpecialist.validateModelName(modelName)) {
            this.modelName = modelName;
        }
        if (TechnicalSpecialist.validateRegistrationNumber(registrationNumber)) {
            this.registrationNumber = registrationNumber;
        }
        if (TechnicalSpecialist.validateWeight(weightKg)) {
            this.weightKg = weightKg;
        }
        if (TechnicalSpecialist.validateManufactureYear(manufactureYear)) {
            this.manufactureYear = manufactureYear;
        }
        if (TechnicalSpecialist.validateMileage(mileage)) {
            this.mileage = mileage;
        }
        if (TechnicalSpecialist.validateColor(color)) {
            this.color = color;
        }
        this.sizeTank = sizeTank;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        if (TechnicalSpecialist.validateVehicleType(type)) {
            this.type = type;
        }
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        if (TechnicalSpecialist.validateModelName(modelName)) {
            this.modelName = modelName;
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (TechnicalSpecialist.validateRegistrationNumber(registrationNumber)) {
            this.registrationNumber = registrationNumber;
        }
    }

    public int getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(int weightKg) {
        if (TechnicalSpecialist.validateWeight(weightKg)) {
            this.weightKg = weightKg;
        }
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        if (TechnicalSpecialist.validateManufactureYear(manufactureYear)) {
            this.manufactureYear = manufactureYear;
        }
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        if (TechnicalSpecialist.validateMileage(mileage)) {
            this.mileage = mileage;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (TechnicalSpecialist.validateColor(color)) {
            this.color = color;
        }
    }

    public double getSizeTank() {
        return sizeTank;
    }

    public void setSizeTank(double sizeTank) {
        this.sizeTank = sizeTank;
    }

    public Double getCalcTaxPerMonth() {
        return (weightKg * 0.0013) + (type.getTaxCoefficient() * 30) + 5;
    }

    @Override
    public String toString() {
        return type + ", " +
                modelName + ", " +
                registrationNumber + ", " +
                weightKg + ", " +
                manufactureYear + ", " +
                mileage + ", " +
                color + ", " +
                sizeTank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(type, vehicle.type) && Objects.equals(modelName, vehicle.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, modelName);
    }

    public int compareTo(Vehicle obj) {
        if (manufactureYear < obj.manufactureYear) {
            return -1;
        } else if (manufactureYear > obj.manufactureYear) {
            return 1;
        } else {
            if (mileage < obj.mileage) {
                return -1;
            } else if (mileage > obj.mileage) {
                return 1;
            }
        }
        return 0;
    }
}