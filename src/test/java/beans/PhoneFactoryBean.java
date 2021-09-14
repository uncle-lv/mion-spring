package beans;

import beans.factory.FactoryBean;

public class PhoneFactoryBean implements FactoryBean<Phone> {

    private String brand;

    @Override
    public Phone getObject() throws Exception {
        Phone phone = new Phone();
        phone.setBrand(brand);
        return  phone;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
