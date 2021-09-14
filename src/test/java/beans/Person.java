package beans;

import beans.factory.DisposableBean;
import beans.factory.InitializingBean;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Person implements InitializingBean, DisposableBean {

    private String name;

    private int age;

    private Phone phone;

    public void customInitMethod() {
        log.info("customInitMethod...");
    }

    public void customDestroyMethod() {
        log.info("customDestroyMethod...");
    }

    @Override
    public void destroy() throws Exception {
        log.info("destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("afterPropertiesSet...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
