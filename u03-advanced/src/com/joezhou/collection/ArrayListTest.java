package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        list.add("US");
        list.add(1, "India");
        list.add("Africa");
        List<String> newList = new ArrayList<>();
        newList.add("Canada");
        newList.add("UK");
        list.addAll(newList);
        newList = new ArrayList<>();
        newList.add("Japan");
        newList.add("Korea");
        list.addAll(1, newList);
        System.out.println(list);
    }

    @Test
    public void retrieve() {
        list.add("China");
        list.add("US");
        list.add("Canada");
        list.add("UK");
        list.add("Japan");
        list.add("China");
        List<String> newList = new ArrayList<>();
        newList.add("Korea");
        System.out.println(list.get(5));
        System.out.println(list.indexOf("China"));
        System.out.println(list.lastIndexOf("China"));
        System.out.println(list.equals(newList));
        System.out.println(list.contains("Japan"));
        System.out.println(list.containsAll(newList));
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        System.out.println(list.toArray()[0]);
    }

    @Test
    public void update() {
        list.add("US");
        list.set(0, "UK");
        System.out.println(list);
    }

    @Test
    public void delete() {
        list.add("China");
        list.add("US");
        list.add("Canada");
        list.add("UK");
        list.add("Japan");
        list.add("China");
        System.out.println(list.subList(0, 3));
        System.out.println(list.remove(1));
        System.out.println(list.remove("UK"));
        ArrayList<String> newList = new ArrayList<>();
        newList.add("Canada");
        list.removeAll(newList);
        newList = new ArrayList<>();
        newList.add("China");
        list.retainAll(newList);
        list.clear();
    }
}
