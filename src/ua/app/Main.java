package ua.app;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {

        Date date1 = new Date();
        Time time1 = new Time();

        Date date2 = new Date(10, 12, 1990);
        Time time2 = new Time(23, 30, 10);

        Date date3 = new Date(40, 40, 40);
        Time time3 = new Time(100, 100, 100);

        date1.print();
        time1.print();
        date2.print();
        time2.print();
        date3.print();
        time3.print();

        System.out.println();

        String className1 = "ua.epam.Date";
        String className2 = "ua.epam.Time";
        Class clazzDate = Class.forName(className1);
        Class clazzTime = Class.forName(className2);
        Object obj1 = clazzDate.newInstance();
        Object obj2 = clazzTime.newInstance();

        for (Method method : clazzDate.getMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                MyAnnotation annot = method.getAnnotation(MyAnnotation.class);
                System.out.println("Found annotation --> " +
                        annot.annotationType() + " in method --> " + method.getName());
                System.out.println("Method returns: " + method.invoke(obj1));
            }
        }
        System.out.println();

        // Super class name
        System.out.println(obj1.getClass());

        // All Constructors with params for super class
        Constructor[] constructors = clazzDate.getConstructors();

        for (Constructor constructor : constructors) {
            System.out.print("constructor " + clazzDate.getSimpleName() + " with parameters: ");
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }

        // Super class Modifiers
        int modsDate = clazzDate.getModifiers();
        System.out.print("Modifiers of class " + clazzDate.getName() + ": ");

        if (Modifier.isPublic(modsDate)) {
            System.out.print("public ");
        }
        if (Modifier.isAbstract(modsDate)) {
            System.out.print("abstract ");
        }
        if (Modifier.isFinal(modsDate)) {
            System.out.print("final ");
        }

        System.out.println();

        // Ext class name
        System.out.println(obj2.getClass());

        // All Constructors with params for ext class
        constructors = clazzTime.getConstructors();

        for (Constructor constructor : constructors) {
            System.out.print("constructor " + clazzTime.getSimpleName() + " with parameters: ");
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
//                if(paramType.getName().)
//                    System.out.print(" <no params> ");
//                else
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }

        // Ext class Modifiers
        int modsTime = clazzTime.getModifiers();
        System.out.print("Modifiers of class " + clazzTime.getName()  + ": ");

        if (Modifier.isPublic(modsTime)) {
            System.out.print("public ");
        }
        if (Modifier.isAbstract(modsTime)) {
            System.out.print("abstract ");
        }
        if (Modifier.isFinal(modsTime)) {
            System.out.print("final ");
        }

    }
}
