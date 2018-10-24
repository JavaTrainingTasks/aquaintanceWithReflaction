import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        Parrent parrent = new Parrent();
        Child child =new Child();
        //knocking to te private field
        Field privateField = parrent.getClass().getDeclaredField("field1");
        privateField.setAccessible(true);
        System.out.println(privateField.getInt(parrent));

        //knocking to Constructor
        Constructor<?>[] constructors = parrent.getClass().getDeclaredConstructors();
        Arrays.stream(constructors).forEach(constructor -> System.out.println(constructor.getName()));

        //getting all fields
        Field[] field =parrent.getClass().getDeclaredFields();
        Arrays.stream(field).forEach(field1 -> System.out.println(field1.getName() + " " + field1.getType() + " " + field1.getModifiers()));

        // get name of package
        System.out.println(parrent.getClass().getPackage());

        //get superclass name

        System.out.println(child.getClass().getSuperclass().getName());

    }
}
