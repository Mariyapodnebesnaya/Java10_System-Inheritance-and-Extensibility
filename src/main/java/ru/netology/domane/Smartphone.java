package ru.netology.domane;

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches(String search) {
        boolean matches = super.matches(search);
        if (matches) {
            return true;
        } else {
            if (getManufacturer().contains(search)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
