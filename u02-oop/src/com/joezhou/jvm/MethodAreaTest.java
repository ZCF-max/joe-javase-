package com.joezhou.jvm;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class MethodAreaTest {

    @Test
    public void work01(){
        String a = "abc";
        String b = "abc";
        System.out.println(a == b);
        String c = new String("abc");
        System.out.println(a == c);
        System.out.println(a == c.intern());
    }

    @Test
    public void codeReuse() {
        Integer a = 100;
        Integer b = 100;
        Integer c = new Integer(100);
        System.out.println(a == b);
        System.out.println(b == c);
    }

    @Test
    public void work02() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(g == (a + h));
    }


}
