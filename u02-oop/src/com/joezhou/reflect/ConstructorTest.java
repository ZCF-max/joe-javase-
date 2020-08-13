package com.joezhou.reflect;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class ConstructorTest {

    private Class<?> klass;

    @Before
    public void before() {
        klass = Demo.class;
    }

    @Test
    public void reflectConstructorsOnlyPublic() {
        for (Constructor<?> constructor : klass.getConstructors()) {
            System.out.println(constructor);
        }
    }

    @Test
    public void reflectConstructors() {
        for (Constructor<?> constructor : klass.getDeclaredConstructors()) {
            System.out.println(constructor);
        }
    }

    @Test
    public void reflectConstructorOnlyPublic() throws Exception {
        System.out.println(klass.getConstructor());
        System.out.println(klass.getConstructor(String.class));
    }

    @Test
    public void reflectConstructor() throws Exception {
        System.out.println(klass.getDeclaredConstructor());
        System.out.println(klass.getDeclaredConstructor(int.class));
        System.out.println(klass.getDeclaredConstructor(String.class));
        System.out.println(klass.getDeclaredConstructor(Double.class));
        System.out.println(klass.getDeclaredConstructor(Float.class));
    }
}

class Demo {
    public Demo() {
        System.out.println("public + ()：");
    }

    public Demo(String str) {
        System.out.println("public + (String)：" + str);
    }

    private Demo(int num) {
        System.out.println("private + (int)：" + num);
    }

    Demo(Double dbl) {
        System.out.println("(Double)：" + dbl);
    }

    protected Demo(Float flt) {
        System.out.println("protected  + (Float)：" + flt);
    }

    public void sayHello() {
        System.out.println("hello!");
    }
}