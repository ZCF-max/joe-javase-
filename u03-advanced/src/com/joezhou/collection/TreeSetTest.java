package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author JoeZhou
 */
public class TreeSetTest {

    private TreeSet<String> treeSet;

    @Before
    public void before() {
        treeSet = new TreeSet<>();
    }

    @Test
    public void naturalSort() {
        treeSet.add("abc");
        treeSet.add("aac");
        treeSet.add("abb");
        treeSet.add("acc");
        treeSet.add("3");
        treeSet.add("1");
        treeSet.add("2");
        System.out.println(treeSet);
    }

}
