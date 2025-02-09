package MentorLesson.Lesson2;

import java.util.Scanner;

public class MentorLessonTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number1 = scanner.nextInt();
 //       int number2 = scanner.nextInt();
        MethodsOfL2 methodsOfL2 = new MethodsOfL2();
        System.out.println(methodsOfL2.leapYear(number1));
    //    System.out.println(methodsOfL2.getReversed(number1));

    }

}

