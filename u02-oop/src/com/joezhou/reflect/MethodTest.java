package com.joezhou.reflect;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author JoeZhou
 */
public class MethodTest {
    private Class<?> klass = Demo.class;

    static class Demo {
        public static void methodA(String str, int num) {
            System.out.println("I am methodA..." + str + num);
        }

        private static void methodB() {
            System.out.println("I am methodB...");
        }
    }

    @Test
    public void reflectMethodsOnlyPublic() {
        for (Method method : klass.getMethods()) {
            System.out.println(method);
        }
    }

    @Test
    public void reflectMethods() {
        for (Method method : klass.getDeclaredMethods()) {
            System.out.println(method);
        }
    }

    @Test
    public void reflectMethodOnlyPublic() throws Exception {
        System.out.println(klass.getMethod("methodA", String.class, int.class));
    }

    @Test
    public void reflectMethod() throws Exception {
        System.out.println(klass.getDeclaredMethod("methodB"));
    }

	@Test
	public void usePublicMethod() throws Exception {
		Object instanceA = klass.getDeclaredConstructor().newInstance();
		Method methodA = klass.getMethod("methodA", String.class, int.class);
		methodA.invoke(instanceA, "赵四", 58);
	}

	@Test
	public void usePrivateMethod() throws Exception {
		Object instanceA = klass.getDeclaredConstructor().newInstance();
		Method methodB = klass.getDeclaredMethod("methodB");
		methodB.setAccessible(true);
		methodB.invoke(instanceA);
	}
}