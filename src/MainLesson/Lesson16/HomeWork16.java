package MainLesson.Lesson16;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork16 {


    public static void main(String[] args) {


        int[] snowFlake1 = {3, 4, 5, 7, 10, 8};
        int[] snowFlake2 = {5, 7, 10, 8, 3, 4};

        getNumber(snowFlake1,snowFlake2);
    }

    public static void getArrays(int[] snowFlake11, int[] snowFlake22) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("First Array[6]:");
            for (int i = 0; i < snowFlake11.length; i++) {
                snowFlake11[i] = scanner.nextInt();
            }


            System.out.println("Second Array[6]:");
            for (int j = 0; j < snowFlake22.length; j++) {
                snowFlake22[j] = scanner.nextInt();
            }


            System.out.println("First Array:");
            for (int i : snowFlake11) {
                System.out.print(i + " ");
            }
            System.out.println();

            System.out.println("Second Array:");
            for (int i : snowFlake22) {
                System.out.print(i + " ");
            }

            getNumber(snowFlake11, snowFlake22);

        } catch (InputMismatchException e) {
            System.out.println("There is mismatch in Arrays input. Please consider");
        } catch (Exception e) {
            e.printStackTrace();
        }




    }


    public static void getNumber(int[] snowFlake1, int[] snowFlake2) {
        int index1;
        int index2;
        boolean result = true;

        for (int i = 0; i < snowFlake1.length; i++) {
            for (int j = 0; j < snowFlake2.length; j++) {
                if (snowFlake1[i] == snowFlake2[j]) {
                    index1 = i + 3;
                    index2 = j + 3;

                    if (i + 3 > 5) {
                        index1 = i + 3 - 6;
                    }

                    if (j + 3 > 5) {
                        index2 = j + 3 - 6;
                    }

                    if (snowFlake1[index1] != snowFlake2[index2]) {
                        result = false;
                        break;
                    }

                }

            }

        }
        System.out.println();
        System.out.println(result ? "Our Arrays is identifical snowflake" : "Our Arrays is not identifical snowflake");

    }


}




