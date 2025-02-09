package MainLesson.Lesson3;

import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {

        /*//task 1
        System.out.println("TASK 1");
        Scanner scanner0 = new Scanner(System.in);
        int a = scanner0.nextInt();
        int b = scanner0.nextInt();
        int c = scanner0.nextInt();

        if(a > b && a > c){
            System.out.println("a is the greatest");
        } else if(b > a && b > c){
            System.out.println("b is the greatest");
        }else
            System.out.println("c is the greatest");

        //task 2
        Scanner scanner02 = new Scanner(System.in);
        int ss = scanner02.nextInt();
        System.out.println("TASK 2");
        for(int i = 0; i<1000;i++ ){
            if(i % 29 == 0){
                System.out.println(i);

            }
        }

        // task 3
        System.out.println("TASK 3");
       Scanner scanner = new Scanner(System.in);
       int task3 = scanner.nextInt();
        System.out.println("Task's number is "+ task3);
        int j1 = 0;
        for(int j = 1;j<= task3 ;j++){
            System.out.println(j);
            j1 += j;
        }
        System.out.println("sum = "+ j1);


//        //task 4
        System.out.println("TASK 4");
        Scanner scanner1 = new Scanner(System.in);
        int task4 = scanner1.nextInt();
        System.out.println("Task's number is "+ task4);
        int k1 = 1;
        for(int k = 1; k <= task4 ; k++){
                System.out.println(k);
                k1 *= k;
        }
        System.out.println("task 4 result is "+k1);
*/

/*
        Scanner scanner2 = new Scanner(System.in);
        int task5 = scanner2.nextInt();
        System.out.println("Task's number is "+ task5);
        boolean ourCase = true;

        if(task5 == 0 || task5 == 1){
            ourCase = false;
        }
        for(int t5 = 2;t5 <= task5/2 ;t5++){
            if(task5 % t5 ==0){
                ourCase = false;
                break;
            }
        }
        System.out.println("your number is "+ (ourCase ? "prime": "not prime"));

 */

        //task 6
      /*  for(int s6 = 2; s6<100 ;s6++){
            boolean task6 = true;
            for (int t6 = 2; t6 <= s6 / 2; t6++) {
                if (s6 % t6 == 0) {
                    task6 = false;
                    break;
                }
            }
                System.out.println("the number is "+ s6 + ((task6) ? " is prime" : " is not prime"));
            }

*/


        /*//task 7
        System.out.println("TASK 7");
        Scanner scanner3 = new Scanner(System.in);
        int task7 = scanner3.nextInt();
        System.out.println("Task's number is "+ task7);
        int s7 = 0;
        for(int t7 = 1 ; t7<task7;t7++){
            if(task7 % t7 ==0){
                System.out.println(t7);
                s7 += t7;
            }
        }
        System.out.println("task 7 result is "+s7);
        if(task7 == s7){
            System.out.println("the number is perfect");
        }else{
            System.out.println("the number is not perfect");
        }
*/
       /*   //task 8
        for(int s8 = 1 ; s8 < 1000 ; s8++){
            int task8 = 0;
            for(int t8 = 1 ; t8 < s8 ; t8++){
                if(s8 % t8 ==0){
                    task8 += t8;
                }
            }
            if (s8 == task8){
                System.out.println(s8);
            }
        }
*/

    //    task 9
        Scanner scanner9 = new Scanner(System.in);
        int task9 = scanner9.nextInt();
        System.out.println("Task's number is "+ task9);
        int palydrome = task9;
        int reverse = 0;
       while (task9 >0){
            reverse = reverse * 10 + palydrome %10;
            task9 /= 10;
        }
        System.out.println(reverse);
        System.out.println( palydrome == reverse ? "the number is palydrome " : "is not palydrome ");

        }
    }
