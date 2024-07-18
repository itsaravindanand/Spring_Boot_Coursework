package com.in28minutes.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean; //indicates that a method produces a bean to be managed by a Spring Container
import org.springframework.context.annotation.Configuration; //indicates that the class would have @bean methods to be implemented
import org.springframework.context.annotation.Primary; //indicates the use of primary for prioritizing a bean

//Record helps in creating the constructor of a separately undefined class
//Eliminate verbosity in creating Java Beans
//Public accessor methods, constructor, setters, getters
//equals, hashcode and toString are automatically created.
//Released in JDK 16.
record Person(String name, int age, Address address) {
};

record Address(String firstLine, String city) {
};

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name() {
        return "Aravind";
    }

    @Bean
    public int age() {
        return 27;
    }

    @Bean
    public Person person() {
        var person = new Person("Kishore", 30, new Address("1180 Reed Ave", "San Jose"));
        //Test Printing the values called using getters of record
        //System.out.println(person.name());
        //System.out.println(person.age());
        return person;
    }

    @Bean(name = "address1")
    public Address address() {
        return new Address("2054 N Beverly plaza", "Long Beach");
    }

    //We are referring Address.class in the Main method, so only one method returning Address is allowed
    @Bean
    @Qualifier("address2Qualifier")
    public Address address2() {
        return new Address("1180 Reed Ave", "San Jose");
    }

    @Bean
    //Used to give address3 the priority when referred with return type of the bean in the main class
    @Primary
    public Address address3() {
        return new Address("Apt 250, 2054 N Beverly plaza", "Long Beach");
    }

    //Calling existing beans within another bean
    //Note: for beans with pseudo names, use the actual name while calling the bean directly
    @Bean
    public Person personByBeanMethodCall() {
        return new Person(name(),age(), address());
    }

    //passing the beans as parameters
    //A way of auto-wiring/injecting the beans
    //Spring will try to inject the beans of that datatype and
    //If there are more than one bean of same datatype, it will check for qualifier or primary
    @Bean
    public Person personByParameter(String name, int age, Address address) {//Beans: name, age and address passed as parameters, bean names should match correctly
        return new Person(name,age, address);
    }

    //Qualifier AutoWiring uses the Primary tagged bean
    //there are two beans with Address return type and with the primary tag, we specify which one to pick
    @Bean
    public Person personByQualifierParameter(String name, int age, @Qualifier("address2Qualifier") Address address) {//Beans: name, age and address2 passed as parameters, bean names should match correctly
        return new Person(name,age, address);
    }
}

