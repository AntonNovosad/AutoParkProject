package by.devincubator;

public class VehicleType {
    private String name;
    private double taxCoefficient;

    public VehicleType() {
    }

    public VehicleType(String name, double taxCoefficient) {
        this.name = name;
        this.taxCoefficient = taxCoefficient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTaxCoefficient() {
        return taxCoefficient;
    }

    public void setTaxCoefficient(double taxCoefficient) {
        this.taxCoefficient = taxCoefficient;
    }

    public String display() {
        return "Type name = " + name + '\n' +
                "Tax coefficient = " + taxCoefficient;
    }

    @Override
    public String toString() {
        return name + "," + '\"' + taxCoefficient + '\"';
    }
}
