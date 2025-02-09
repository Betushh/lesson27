package MainLesson.Lesson33;

public class Singleton {
    public static Singleton instance;

    private Singleton() {

    }

    public static Singleton getSingletonInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;

    }
}