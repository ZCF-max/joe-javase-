package com.joezhou.reflect;

import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author JoeZhou
 */
public class DynamicOperaTest {

    @Test
    public void dynamicCompile() throws Exception {
        // 获取系统编辑器
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // p1：inputStream输入流，传递给javac的数据，如果为null，表示使用System.in
        // p2：outputStream输出流，javac返回的数据，如果为null，表示使用System.out
        // p3：outputStream输出流，javac返回的错误信息，如果为null，表示使用System.err
        // p4：String类型的不定长数组，可以传递一个或者多个java源文件
        int result = compiler.run(null, null, null, "E:\\HelloWorld.java");
        System.out.println(result);// 0代表编译成功，1代表编译失败
    }

    @Test
    public void dynamicRun() throws Exception {
        URL url = new URL("file:/E:/");
        // 类加载器：把加载到内存中
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
        // 加载类名
        Class<?> loadClass = urlClassLoader.loadClass("HelloWorld");
        // 获取方法：main方法
        // p1：调用的方法的名字
        // p2：当你调用这个方法的时候传进来的参数类型
        Method method = loadClass.getMethod("main", String[].class);
        // invoke 是真正的在调用这个方法
        // 这里必须强转成Object类型，否则String[]数组参数会被拆成"a"和"b",与main方法的参数个数不符合
        method.invoke(null, (Object) new String[]{"a", "b"});
        urlClassLoader.close();
    }
}