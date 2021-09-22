package beans;

import stereotype.Component;

@Component
public class Phone {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
