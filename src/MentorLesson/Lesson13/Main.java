package MentorLesson.Lesson13;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {


        Updated updated = new Updated();
        changeObject(updated, "age", 90);
        System.out.println(updated);
    }

    public static <T> void changeObject(Object object, String dataType, T newValue) throws IllegalAccessException {

        Class<?> reflection = object.getClass();

        for (Field field : reflection.getDeclaredFields()) {
            if (field.getName().equalsIgnoreCase(dataType)) {
                field.setAccessible(true);
                field.set(object, newValue);
                System.out.println("Updated version: "+field.get(object));
                break;
            }
        }
    }
}
