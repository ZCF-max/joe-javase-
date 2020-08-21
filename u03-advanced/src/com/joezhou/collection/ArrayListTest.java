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
        list.add(1, "Thailand");

        List<String> europe = new ArrayList<>();
        europe.add("UK");
        europe.add("France");
        list.addAll(europe);

        List<String> africa = new ArrayList<>();
        africa.add("Congo");
        africa.add("Egypt");
        list.addAll(1, africa);

        System.out.println("add over: " + list);
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
        List<String> africa = new ArrayList<>();
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
    public void iteratorByFor() {
        this.add();
        for (int i = 0, j = list.size(); i < j; i++) {
            System.out.print(list.get(i) + "\0");
        }
    }

    @Test
    public void iteratorByForEach() {
        this.add();
        for (String str : list) {
            System.out.print(str + "\0");
        }
    }

    @Test
    public void iterator() {
        this.add();
        ListIterator<String> listIter = list.listIterator(0);
        while (listIter.hasNext()) {
            String e = listIter.next();
            if ("China".equals(e)) {
                listIter.set("CHINA");
            }
            if ("UK".equals(e)) {
                listIter.remove();
            }
            System.out.print(e + "\0");
        }
    }

    @Test
    public void reverseIterator() {
        this.add();
        ListIterator<String> listIter = list.listIterator(list.size());
        while (listIter.hasPrevious()) {
            System.out.print(listIter.previous() + "\0");
        }
    }

}
