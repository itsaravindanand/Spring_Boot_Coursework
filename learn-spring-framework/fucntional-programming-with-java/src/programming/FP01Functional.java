package programming;

import java.util.List;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 17, 82, 98, 787, 98, 36, 689, 788);

        //printAllNumberInListFunctional(numbers);
        //printAllEvenNumberInListFunctional(numbers);
        //printAllOddNumberInListFunctional(numbers);
        //printAllEvenSquaresNumberInListFunctional(numbers);
        //printAllOddCubesNumberInListFunctional(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");

        //printAllCoursesIndividually(courses);
        //printAllCoursesContainingSpring(courses);
        //printAllCoursesAtleastFourLetters(courses);
        printCourseNameLength(courses);
    }

    //Print all numbers
    private static void printAllNumberInListFunctional(List<Integer> numbers) {
        //Need to convert list of numbers to stream of numbers
        //List of numbers: [12, 17, 82, 98, 787, 98, 36, 689, 788]
        //Stream of numbers (one after the other):
        //12
        //17
        //...

        //What to do?
        /*
        * Descriptive Syntax:
        I have a list which should be taken as a stream and for each element of the stream method this method (injected mentioned using method reference=> class_name::method_name)
        i.e:
        numbers.stream().forEach(FP01Functional::print);
        Here:
        numbers is a list
        stream() denotes change it to a stream
        forEach
        Method reference(FP01Functional::print): FP01Functional is the class and print is the method that prints the integer value
        */
        numbers.stream().forEach(FP01Functional::print); //Method reference of print from this class

        /*
         * Instead of the class's print method, use the println method in System.out
         * This doesn't use the print method in the claaa
         * */
        numbers.stream().forEach(System.out::println); //Method reference of println from System.out class
    }

    //Print all even numbers
    private static void printAllEvenNumberInListFunctional(List<Integer> numbers) {
        //Checking the number is even or not, you can use FILTER and call the isEven method
        numbers.stream().filter(FP01Functional::isEven)//filter with method reference
                .forEach(System.out::println);

        //How to include the isEven method within the filter instead of separate method
        //Using Lambda expression - simpler way of defining a method with simpler syntax (->)
        //lets rewrite the isEven method with lambda expression
        /*
        the input parameter is number so,
        number ->
        and check if that number % 2 == 0
        number -> number%2 == 0
        By default if there is only one statement in the lambda expression, then it will return that value
         */
        numbers.stream().filter(number -> number % 2 == 0)//filter with Lambda Expression
                .forEach(System.out::println);
    }

    //Print all odd numbers
    private static void printAllOddNumberInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(number -> !(number % 2 == 0))//filter with Lambda Expression
                .forEach(System.out::println);
    }

    //Print the squares of all even number
    //Using mapping: map(______ -> _______)
    private static void printAllEvenSquaresNumberInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2 == 0)//filter with Lambda Expression
                .map(number -> number * number)//using map to compute
                .forEach(System.out::println);
    }

    //Print the cubes of all odd numbers
    private static void printAllOddCubesNumberInListFunctional(List<Integer> numbers) {
        numbers.stream().filter(number -> !(number % 2 == 0))//filter with Lambda Expression
                .map(number -> number * number * number)//using map to compute
                .forEach(System.out::println);
    }

    //Print all course names
    private static void printAllCoursesIndividually(List<String> names) {
        names.stream().forEach(System.out::println);
    }

    //Print all names with text Spring in them
    private static void printAllCoursesContainingSpring(List<String> names) {
        names.stream().filter(name -> name.contains("Spring"))
                .forEach(System.out::println);
    }

    //Print all names with length of atleast four
    private static void printAllCoursesAtleastFourLetters(List<String> names) {
        names.stream().filter(name -> name.length() >= 4)
                .forEach(System.out::println);
    }

    //Print number of characters  in course names
    private static void printCourseNameLength(List<String> names) {
        names.stream().map(name -> name + " " + name.length())
                .forEach(System.out::println);
    }

    //No need of these method with simplified functional code
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void print(int number) {
        System.out.println(number);
    }
}
