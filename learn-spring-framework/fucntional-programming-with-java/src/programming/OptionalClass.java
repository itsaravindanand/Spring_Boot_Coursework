package programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalClass {
    public static void main(String[] args) {
        //Providing a safeguard for null fields
        //When you declare a String/any object as Optional, when it is used in other class, it would make the coder to check null values
        //The error for accessing an Optional Object which is null is java.util.NoSuchElementException: No value present
        List<String> fruits = List.of("apple", "banana", "mango", "blackberry");
        //predicate lambda statement
        Predicate<? super String> predicate = fruit -> fruit.startsWith("b");
        //optional type variable
        Optional<String> optional = fruits.stream().filter(predicate).findFirst();
        //default optional method
        System.out.println(optional);
        System.out.println(optional.isEmpty());
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        Predicate<? super String> predicate1 = fruit -> fruit.startsWith("c");
        Optional<String> optional1 = fruits.stream().filter(predicate1).findFirst();
        System.out.println(optional1);
        System.out.println(optional1.isEmpty());
        System.out.println(optional1.isPresent());
        //This throws an exception: java.util.NoSuchElementException: No value present
        //System.out.println(optional1.get());

        //Direct Optional creation
        Optional<String> fruit = Optional.of("Jack Fruit");
        Optional<String> emptyString = Optional.empty();
        System.out.println(fruit.get());
        System.out.println(emptyString);
    }
}
