package com.joezhou.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author JoeZhou
 */
public class FieldTest {
    private Class<?> klass = FieldTest.class;
    public String name;
    private int gender = 0;

    @Test
    public void reflectFieldsOnlyPublic() {
        for (Field field : klass.getFields()) {
            System.out.println(field);
        }
    }

    @Test
    public void reflectFields() {
        for (Field field : klass.getDeclaredFields()) {
            System.out.println(field);
        }
    }

    @Test
    public void reflectFieldOnlyPublic() throws Exception {
        System.out.println(klass.getField("name"));
    }

    @Test
    public void reflectField() throws Exception {
        System.out.println(klass.getDeclaredField("name"));
        System.out.println(klass.getDeclaredField("gender"));
    }
}