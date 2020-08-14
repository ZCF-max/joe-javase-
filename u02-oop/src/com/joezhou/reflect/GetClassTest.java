package com.joezhou.reflect;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class GetClassTest {
    @Test
    public void getClassByGetClassMethod() {
        GetClassTest instance = new GetClassTest();
        Class<?> classA = instance.getClass();
        Class<?> classB = instance.getClass();
        System.out.println(classA.hashCode() == classB.hashCode());
    }

    @Test
    public void getClassByClassField() {
        Class<?> classA = GetClassTest.class;
        Class<?> classB = GetClassTest.class;
        System.out.println(classA.hashCode() == classB.hashCode());
    }

    @Test
    public void getClassByForNameMethod() throws ClassNotFoundException {
        String qualifiedName = "com.joezhou.reflect.GetClassTest";
        Class<?> classA = Class.forName(qualifiedName);
        Class<?> classB = Class.forName(qualifiedName);
        System.out.println(classA.hashCode() == classB.hashCode());
    }
}