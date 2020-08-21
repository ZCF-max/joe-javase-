package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * @author JoeZhou
 */
public class ArrayListTest {

    private List<String> list;

    @Before
    public void before() {
        list = new ArrayList<>(10);
    }

    @Test
    public void add() {
        list.add("China");
        list.add("Japan");
        list.add(1, "Korea");
        list.add(1,"Thailand");

        List<String> europe = new ArrayList<>();
        europe.add("UK");
        europe.add("France");
        list.addAll(europe);

        List<String> africa  = new ArrayList<>();
        africa.add("Congo");
        africa.add("Egypt");
        list.addAll(1, africa);

        System.out.println(list);
    }

    @Test
    public void retrieve() {
        this.add();
        List<String> europe = new ArrayList<>();
        europe.add("UK");
        europe.add("France");

        System.out.println(list.get(0));
        System.out.println(list.indexOf("China"));
        System.out.println(list.lastIndexOf("UK"));
        System.out.println(list.equals(europe));
        System.out.println(list.contains("Japan"));
        System.out.println(list.containsAll(europe));
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.toArray()[0]);
    }

    @Test
    public void update() {
        this.add();

        list.set(1, "UK");
        System.out.println(list);
    }

    @Test
    public void delete() {
        this.add();
        List<String> europe = new ArrayList<>();
        europe.add("UK");
        europe.add("France");
        List<String> africa  = new ArrayList<>();
        africa.add("Congo");
        africa.add("Egypt");

        System.out.println(list.subList(0, 3));
        System.out.println(list.remove(1));
        System.out.println(list.remove("Egypt"));
        list.removeAll(europe);
        list.retainAll(africa);
        list.clear();
    }

    @Test
    public void iterator() {
        List<String> list = new ArrayList<String>();
        list.add("中国");
        list.add("印度");
        list.add("美国");

        System.out.println("\n\n使用for遍历list...");
        for (int i = 0, j = list.size(); i < j; i++) {
            System.out.print(list.get(i) + "\t");
        }

        System.out.println("\n\n使用foreach遍历list...");
        for (String e : list) {
            System.out.print(e + "\t");
        }

        // ListIterator是List接口提供的特殊的迭代器，是Iterator的子类，只能遍历list，用法和iterator一致
        // ListIterator除了Iterator接口提供的正常操作外，还额外提供了hasPrevious()、previous()、set()等方法
        System.out.println("\n\n使用listIterator遍历list...");
        ListIterator<String> lit1 = list.listIterator();// 获取list迭代器对象，指针置于首位
        while (lit1.hasNext()) {// 如果有下一个元素
            String e = lit1.next();// 获取下一个元素
            if ("中国".equals(e)) {// 如果当前元素是"中国"，则改为"中华人民共和国"
                lit1.set("中华人民共和国");
            }
            if ("印度".equals(e)) {// 如果当前元素是"印度'，则删除这个元素
                lit1.remove();
            }
            System.out.print(e + "\t");// 此时输出的结果仍是["中国 印度 美国"]，但原list中的元素已经改为["中华人民共和国 美国"]
        }

        System.out.println("\n\n使用listIterator反向遍历list...");
        ListIterator<String> lit2 = list.listIterator(2);// 获取list迭代器对象，指针置于2号位置
        while (lit2.hasPrevious()) {// 如果有上一个元素
            System.out.print(lit2.previous() + "\t");// 获取上一个元素并打印
        }
    }
}
