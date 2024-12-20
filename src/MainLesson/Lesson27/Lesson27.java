package MainLesson.Lesson27;

import java.util.Scanner;

public class Lesson27 {
    public static void main(String[] args) {

        try{
            Scanner scanner = new Scanner(System.in);
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
        } catch (ArithmeticException a) {
            a.printStackTrace();
        }finally {
            System.out.println("it is jeff's doing");
            System.out.println("new message");
        }
    }
}
