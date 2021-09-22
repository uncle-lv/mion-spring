package beans;

import beans.factory.annotation.Value;
import stereotype.Component;

@Component
public class Phone {

    @Value("${brand}")
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
