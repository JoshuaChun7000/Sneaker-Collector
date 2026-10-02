public class Sneaker {
    private final String brand;
    private final String model;
    private final double retailPrice;
    private double resalePrice;
    private boolean isDeadstock;
    private final String colorTheme;
    private int timesWorn;
    public Sneaker(String brand, String model, double retailPrice,
                   double resalePrice, boolean isDeadStock, String colorTheme,
                   int timesWorn) {
        this.brand = brand;
        this.model = model;
        this.retailPrice = retailPrice;
        this.resalePrice = resalePrice;
        this.isDeadstock = isDeadStock;
        this.colorTheme = colorTheme;
        this.timesWorn = timesWorn;
    }
    public String getBrand() {return brand;}
    public String getModel() {return model;}
    public double getRetailPrice() {return retailPrice;}
    public double getResalePrice() {return resalePrice;}
    public void setResalePrice(double resalePrice) {
        this.resalePrice = resalePrice;
        if (this.resalePrice < 0) {
            this.resalePrice = 0;}}
    public boolean isDeadstock() {return isDeadstock;}
    public void setDeadstockStatus(boolean isDeadstock) {
        if (this.timesWorn == 0) {
            this.isDeadstock = isDeadstock;
        }
    }
    public String getColorTheme() {return colorTheme;}
    public int getTimesWorn() {return timesWorn;}
    public void setTimesWorn(int timesWorn) {
        if (timesWorn < 0) {return;}
        this.timesWorn += timesWorn;
        if (this.timesWorn > 0) {setDeadstockStatus(false);}
    }
    public String toString() {
        if (!"None".equals(getBrand())) {
            if (isDeadstock()) {
                return "\n" + getBrand() + " "
                        + getModel() + " — " + getColorTheme() + "\n" +
                        "Retail Price: $" + getRetailPrice() + "\nShoe is in mint condition" +
                        "\n---------------";
            } else {
                return "\n" + getBrand() + " "
                        + getModel() + " — " + getColorTheme() + "\n" +
                        "Retail Price: $" + getRetailPrice() + "\nHas been worn " + getTimesWorn() +
                        " time(s)\n---------------";
            }
        } else {
            return getBrand() + "\n---------------";
        }
    }
}

