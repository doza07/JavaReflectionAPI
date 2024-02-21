import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionApi {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        User user = new User(25L, "Daniil", 30);
        Class<? extends User> aClass = user.getClass();
        Class<User> userClass = User.class;
        System.out.println(aClass == userClass);

        testConstructor();
        testFields(user);
        testMethod(user);
    }

    public static void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<User> constructor = User.class.getConstructor(Long.class, String.class, Integer.class);
        User user = constructor.newInstance(5L, "Test", 24);
        System.out.println(user);
    }

    private static void testFields(User user) throws IllegalAccessException {
        Field[] declaredFields = User.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object o = declaredField.get(user);
            System.out.println(o);
        }
    }

    private static void testMethod(User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getName = user.getClass().getDeclaredMethod("getName");
        System.out.println(getName.invoke(user));

    }

    private class Test1 {

    }

    private static class Test3 {

    }

    private enum Test2 {
        ONE, TWO
    }
}