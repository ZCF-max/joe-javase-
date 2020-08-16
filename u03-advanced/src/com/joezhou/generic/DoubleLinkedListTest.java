package com.joezhou.generic;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class DoubleLinkedListTest<T> {

    private DoubleLinkedListDemo<String> linkList = new DoubleLinkedListDemo<>("head");

    @Test
    public void addHead() {
        System.out.println(linkList);
        linkList.addHead("aaaa");
        System.out.println(linkList);
        linkList.addHead("bbbb");
        System.out.println(linkList);
    }

    @Test
    public void addTail() {
        System.out.println(linkList);
        linkList.addTail("aaaa");
        System.out.println(linkList);
        linkList.addTail("bbbb");
        System.out.println(linkList);
    }

    @Test
    public void add() {
        System.out.println(linkList);
        linkList.add(0, "aaaa");
        System.out.println(linkList);
        linkList.add(9, "bbbb");
        System.out.println(linkList);
        linkList.add(1, "cccc");
        System.out.println(linkList);
        linkList.add(2, "dddd");
        System.out.println(linkList);
    }

    @Test
    public void get() {
        linkList.addTail("aaaa");
        linkList.addTail("bbbb");
        System.out.println(linkList.get("bbbb"));
    }

    @Test
    public void delete() {
        System.out.println(linkList);
        linkList.addTail("aaaa");
        System.out.println(linkList);
        linkList.addTail("bbbb");
        System.out.println(linkList);
        linkList.addTail("cccc");
        System.out.println(linkList);
        linkList.delete("bbbb");
        System.out.println(linkList);
    }
}
