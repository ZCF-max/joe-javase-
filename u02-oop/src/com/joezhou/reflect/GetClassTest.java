package com.joezhou.reflect;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class GetClassTest {
    @Test
    public void getClassByGetClassMethod() {
        GetClassTest instance = new GetClassTest();
        Class<?> class01 = instance.getClass();
        Class<?> class02 = instance.getClass();
        System.out.println(class01.hashCode() == class02.hashCode());
    }

    @Test
    public void getClassByClassField() {
        Class<?> class01 = GetClassTest.class;
        Class<?> class02 = GetClassTest.class;
        System.out.println(class01.hashCode() == class02.hashCode());
    }

    @Test
    public void getClassByForNameMethod() throws ClassNotFoundException {
        String qualifiedName = "com.joezhou.reflect.GetClassTest";
        Class<?> class01 = Class.forName(qualifiedName);
        Class<?> class02 = Class.forName(qualifiedName);
        System.out.println(class01.hashCode() == class02.hashCode());
    }
}