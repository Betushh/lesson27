package MainLesson.Lesson6;

import java.util.Scanner;

public class Homework6 {



    public static void main(String[] args) {

        int number = 10;

        Homework6 h1 = new Homework6();
        int h1Result = h1.getfactorial(number);
        System.out.println("Factorial = " + h1Result);

        Homework6 h2 = new Homework6();
        String h2Result = h2.getReciprocalPrimeNumbers(number, 27);
        System.out.println(h2Result);

        Homework6 h3 = new Homework6();
        int[] h3Array = {2, 4, 6, 8, 34,3,55};
        double h3Result = h3.getArreyMaxMinAverageSum( h3Array);
        System.out.println("Average = "+ h3Result );

        Homework6 h4 = new Homework6();
        new Homework6();

    }

    int getfactorial(int a) {
        if (a == 0 || a == 1) {
            return 1;
        }
        return getfactorial(a - 1) * a;
    }


    int getTask(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getTask(b, a % b);
    }

    String getReciprocalPrimeNumbers(int a, int b) {
        // Check if the GCD of a and b is 1
        if (getTask(a, b) == 1) {
            return a + " and " + b + " are reciprocal prime numbers";
        }
        return a + " and " + b + " are not reciprocal prime numbers";
    }

    int getMax(int[] array){
       int max = array[0];
       for(int i = 0; i< array.length ; i++){
           if(array[i] > max){
               max = array[i];
           }
       }
       return max;
    }

    int getMin(int[] array){
        int min = array[0];
        for(int i = 0; i< array.length ; i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    int getArraySum(int[] array){
        int sum = 0 ;
        for(int i = 0 ; i< array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    double getArreyAverage(int[] array){
        double average = getArraySum(array)/ array.length;
        return average;
    }

    double getArreyMaxMinAverageSum(int[] array){
        int max = getMax(array);
        int min = getMin(array);
        double average = getArreyAverage(array);
        return max + min + average;
    }

}
