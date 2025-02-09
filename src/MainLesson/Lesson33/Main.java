package MainLesson.Lesson33;

public class Main {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getSingletonInstance();
        Singleton singleton1 = Singleton.getSingletonInstance();

        System.out.println(singleton.equals(singleton1));
    }
}
