package MainLesson.Lesson28;

public class Main {
    public static void main(String[] args) {
        //ikilik
        int a = 0b101;
        System.out.println(a);

        //sekkizlik
        int b= 015;
        System.out.println(b);

        //onaltiliq
        int c= 0xFF;
        System.out.println(c);

        long d=300000000000L;
        //it consider it as int so we have to highlight the l

        int $ = 6;
        //it is valid , but _ not valid for naming
        System.out.println($);

        double e = 124.5_6d;
        //we cannot put _ after or before .

        //reserved word that is not java key word, but still cannot use as a name: goto, const
    }
}
