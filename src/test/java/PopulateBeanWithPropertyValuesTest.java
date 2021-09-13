import beans.Person;
import beans.Phone;
import beans.exception.BeansException;
import beans.factory.config.BeanDefinition;
import beans.factory.config.BeanReference;
import beans.factory.config.PropertyValue;
import beans.factory.config.PropertyValues;
import beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PopulateBeanWithPropertyValuesTest {

    @Test
    public void testPopulateBeanWithPropertyValues() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "Tom"));
        propertyValues.addPropertyValue(new PropertyValue("age", 18));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        Assertions.assertEquals("Tom", person.getName());
        Assertions.assertEquals(18, person.getAge());
    }

    @Test
    public void testPopulateBeanWithBean() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValuesForPhone = new PropertyValues();
        propertyValuesForPhone.addPropertyValue(new PropertyValue("brand", "IPhone"));
        BeanDefinition phoneBeanDefinition = new BeanDefinition(Phone.class, propertyValuesForPhone);
        beanFactory.registerBeanDefinition("phone", phoneBeanDefinition);

        PropertyValues propertyValuesForPerson = new PropertyValues();
        propertyValuesForPerson.addPropertyValue(new PropertyValue("name", "Tom"));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("age", 18));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("phone", new BeanReference("phone")));
        BeanDefinition personBeanDefinition = new BeanDefinition(Person.class, propertyValuesForPerson);
        beanFactory.registerBeanDefinition("person", personBeanDefinition);
        Person person = (Person) beanFactory.getBean("person");
        Assertions.assertEquals("Tom", person.getName());
        Assertions.assertEquals(18, person.getAge());
        Phone phone = person.getPhone();
        Assertions.assertNotNull(phone);
        Assertions.assertEquals("IPhone", phone.getBrand());
    }
}
