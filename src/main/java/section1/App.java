package section1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) throws ClassNotFoundException {

        Class<String> stringClass = String.class;

        Map<String, Integer> mapObj = new HashMap<>();

        Class<?> hashMapClass = mapObj.getClass();

        Class<?> squareClass = Class.forName("exercises.App$Square");

//        printClassInfo(stringClass, hashMapClass, squareClass);

        System.out.println("------------------------------------");

        var circleObj = new Drawable() {

            @Override
            public int getNumberOfCorners() {
                return 0;
            }

        };

        printClassInfo(Collection.class, boolean.class, int[][].class, Color.class);
    }

    private static void printClassInfo(Class<?>... classes) {

        for (Class<?> aClass : classes) {

            System.out.println(String.format("class name : %s, class package name : %s",
                    aClass.getSimpleName(),
                    aClass.getPackageName()));

            Class<?>[] implementedInterfaces = aClass.getInterfaces();

            for (Class<?> implementedInterface : implementedInterfaces) {
                System.out.println(String.format("class %s implements : %s",
                        aClass.getSimpleName(),
                        implementedInterface.getSimpleName()));
            }

            System.out.println("Is array : " + aClass.isArray());
            System.out.println("Is primitive : " + aClass.isPrimitive());
            System.out.println("Is enum : " + aClass.isEnum());
            System.out.println("Is interface : " + aClass.isInterface());
            System.out.println("Is anonymous : " + aClass.isAnonymousClass());

            System.out.println();
            System.out.println();

        }

    }

    private static class Square implements Drawable {

        @Override
        public int getNumberOfCorners() {
            return 4;
        }

    }

    private static interface Drawable {
        int getNumberOfCorners();
    }

    private enum Color {
        BLUE,
        RED,
        GREEN
    }

}
