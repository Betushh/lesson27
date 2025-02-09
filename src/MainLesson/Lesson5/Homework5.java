package MainLesson.Lesson5;

import java.util.Scanner;

public class Homework5 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//3
        int fac = calculator.getFactorial(n);
        System.out.println(fac);
        int s = calculator.getMaxAndMeanMultiple(3,4,7);
        System.out.println(s);

        System.out.println("democrats");
        String result = getRelativeAnswer(27, 9);
        System.out.println(result);

    }

    public static int getRelativePrimeNumbers(int a, int b) {

        if (a == 0 || b == 0) {
            return 0;
        }

        if (a == 1 || b == 1) {
            return 1;
        }
        return a > b ? getRelativePrimeNumbers(a % b, b) : getRelativePrimeNumbers(a, b % a);
    }

    public static String getRelativeAnswer(int number1, int number2) {
        if (getRelativePrimeNumbers(number1, number2) == 1) {
            return "These numbers are relative prime numbers";
        }
        return "These numbers are not relative prime numbers";
    }

}
