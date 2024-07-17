package programming;

import java.util.List;

public class FP01Structured {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 17, 82, 98, 787, 98, 36, 689, 788);
        printAllNumberInListStructured(numbers);
        printAllEachNumberInListStructured(numbers);
    }

    private static void printAllNumberInListStructured(List<Integer> numbers) {
        //How do you loop all the numbers
        for (int num : numbers) {
            System.out.println(num);
        }
    }

    private static void printAllEachNumberInListStructured(List<Integer> numbers) {
        //How do you loop all and print the even numbers alone
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
    }
}
