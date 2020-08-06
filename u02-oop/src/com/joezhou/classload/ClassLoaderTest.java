package com.joezhou.classload;

/**
 * @author JoeZhou
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        new ClassA();
        System.out.println("--------------------");
        new ClassB();
        new ClassC(); new ClassC();
        new ClassC(); new ClassC();
    }
}
class ClassA { }
class ClassB { }
class ClassC {
    static { System.out.println("classC-static-block..."); }
}
class ClassD {
    { System.out.println("classC-dynamic-block..."); }
}