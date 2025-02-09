package MainLesson.Lesson9;

import java.util.Arrays;
import java.util.Scanner;

public class Homework9 {

    public static void main(String[] args) {

//
//        Scanner scanner = new Scanner(System.in);
//        String name1 = scanner.next();
//        String name2 = scanner.next();
//        getEqualNames(name1, name2);

        String name = "       Daniel Riccardo     is    a Legend        ";
        String name1 = "Never odd or even";
        String text = "AcBd";
        String zeroSpaceText = text.replace(" ", "");
        String withoutPuncText = zeroSpaceText.replace(".", "");


        findNamesNumber(name);
        //      findPalindrome(name1);

        //   getAlphabet(text,2);

        System.out.println(getEqualNames("name1   ","name") ? "These names are equal":"These names are not equal");
        System.out.println( "Our name's number is "+findNamesNumber("name human"));

    }


    private static boolean getEqualNames(String name1, String name2){
        if(name1.trim().toLowerCase().equalsIgnoreCase(name2.toLowerCase())){
            return true;
        }
        return false;
    }


    private static int findNamesNumber(String name){
        int number = 0;
        for (String character: name.split(" ")){
            if(character.isEmpty()) {
                continue;
            }
            number++;
        }
        return number;
    }

    static void findPalindrome(String name) {
        String name1 = name.toLowerCase().replace(" ", "");
        String newName = name + ": This String is palindrome";
        for (int i = 0; i < name1.length(); i++) {
            if (name1.charAt(i) != name1.charAt(name1.length() - i - 1)) {
                newName = name + ": This String is NOT palindrome";
                break;
            }
        }
        System.out.println(newName);
    }


    static void getAlphabet(String text, int encrypt) {//solve it
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] textAlp = alphabet.split("");
        for (int i = 0; i < alphabet.length(); i++) {
            System.out.println(textAlp[i]);
        }
    }


}






