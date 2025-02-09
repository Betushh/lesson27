package MainLesson.Lesson4;

import java.util.ArrayList;

public class Homework4 {
    public static void main(String[] args) {
        int[] array = {12, 23, 36, 47};
        int[][] multiArray = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};

        System.out.println("Task 1. Add additional element:\n" + AddElement(array) + "\n");
        System.out.println("Task 2. Sort array reversed:\n" + getReverseSort(array) + "\n");
        System.out.println("Task 3. Array min element:\n" + getMinArrayElement(array) + "\n");
        System.out.println("Task 4. Array max element:\n" + getMaxArrayElement(array) + "\n");
        System.out.println("Task 5. Array max element:\n" + getSecondMaxArrayElement(array) + "\n");
        System.out.println("Task 6. Multidimensional array diagonal 1 and 0:");
        getMultiDiagonal1And0();
        System.out.println();
        System.out.println("Task 7. Multidimensional array reversed:");
        getMultiReverseOrder(multiArray);
        System.out.println();
        System.out.println("Task 8. Multidimensional array mirror:");
        getMultiMirror(multiArray);
        System.out.println();
        System.out.println("Task 9. Multidimensional array 90:");
        getMulti90Degree(multiArray);
        System.out.println();

    }

    private static ArrayList<Integer> AddElement(int[] array) {
        int number = 100;
        int[] newArray = new int[array.length + 1];
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
            arrayList.add(newArray[i]);
        }
        newArray[newArray.length - 1] = number;
        arrayList.add(newArray[newArray.length - 1]);

        return arrayList;
    }

    private static ArrayList<Integer> getReverseSort(int[] array) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = array.length - 1; i >= 0; i--) {
            arrayList.add(array[i]);
        }
        return arrayList;
    }

    private static int getMinArrayElement(int[] array) {
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    private static int getMaxArrayElement(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    private static int getSecondMaxArrayElement(int[] array) {
        int max = array[0];
        int secondMax = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] > secondMax && array[i] < max) {
                secondMax = array[i];
            }
        }
        return secondMax;
    }

    private static void getMultiDiagonal1And0() {
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i >= j) {
                    array[i][j] = 1;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void getMultiReverseOrder(int[][] multiArray) {
        for (int i = multiArray.length - 1; i >= 0; i--) {
            for (int j = multiArray.length - 1; j >= 0; j--) {
                System.out.print(multiArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void getMultiMirror(int[][] multiArray) {
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = multiArray.length - 1; j >= 0; j--) {
                System.out.print(multiArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void getMulti90Degree(int[][] multiArray){
        int[][] result = new int[multiArray.length][multiArray.length];
        for (int i = 0; i < multiArray.length; i++) {
            for (int j = 0; j < multiArray.length; j++) {

                result[j][multiArray.length-1-i] = multiArray[i][j];
            }

        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j]+" ");

            }
            System.out.println();
        }


    }
}
