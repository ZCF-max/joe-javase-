package com.joezhou.reflect;

import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author JoeZhou
 */
public class DynamicOperaTest {

    @Test
    public void dynamicCompile() {
        JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
        String filePath = "D:" + File.separator + "HelloWorld.java";
        int result = javac.run(null, null, null, filePath);
        System.out.println(result == 0 ? "javac success" : "javac success");
    }

    @Test
    public void dynamicRun() throws Exception {
        URL url = new URL("file:" + File.separator + "D:" + File.separator);
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
        Class<?> klass = urlClassLoader.loadClass("HelloWorld");
        Method method = klass.getMethod("main", String[].class);
        // main() is static, so p1 of invoke() must be null
        // 这里必须强转成Object类型，否则String[]数组参数会被拆成"a"和"b",与main方法的参数个数不符合
        method.invoke(null, (Object) new String[]{"a", "b"});
        urlClassLoader.close();
    }
}