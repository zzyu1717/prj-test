package interview.sort;

import java.lang.reflect.Field;

public class IntegerSwap {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = new Integer(1);
        Integer b = new Integer(2);
        swap (a,b);
        System.out.println("a = "+a + ", b = " + b);
    }

    public static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends Integer> aClass = a.getClass();
        Class<? extends Integer> bClass = b.getClass();
        Field aField = aClass.getDeclaredField("value");
        Field bField = bClass.getDeclaredField("value");
        aField.setAccessible(true);
        bField.setAccessible(true);
        Object aValue = aField.get(a);
        Object bValue = aField.get(b);

        aField.set(a,bValue);
        bField.set(b,aValue);
    }

}
