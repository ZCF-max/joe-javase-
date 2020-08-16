package com.joezhou.generic;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CycleLinkedListTest<T> {

    private CycleLinkedListDemo<String> linkList = new CycleLinkedListDemo<>("head");

    @Test
    public void add() {
        System.out.println(linkList);
        linkList.add("aaaa");
        System.out.println(linkList);
        linkList.add("bbbb");
        System.out.println(linkList);
        linkList.add("cccc");
    }

    @Test
    public void get() {
        System.out.println(linkList);
        linkList.add("aaaa");
        System.out.println(linkList);
        linkList.add("bbbb");
        System.out.println(linkList);
        System.out.println(linkList.get("head"));
    }

    @Test
    public void delete() {
        System.out.println(linkList);
        linkList.add("aaaa");
        System.out.println(linkList);
        linkList.add("bbbb");
        System.out.println(linkList);
        linkList.add("cccc");
        System.out.println(linkList);
        linkList.delete("bbbb");
        System.out.println(linkList);
    }
}
