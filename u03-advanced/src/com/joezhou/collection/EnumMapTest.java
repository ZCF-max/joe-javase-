package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author JoeZhou
 */
public class EnumMapTest {

    private HashMap<String, Object> hashMap;

    @Before
    public void before() {
        hashMap = new HashMap<>(5);
    }

    @Test
    public void create() {
        /*EnumMap<Week, String> map = new EnumMap<>(Week.class);
        map.put(Week.MON, "星期一");
        map.put(Week.TUE, "星期二");
        map.put(Week.WED, "星期三");
        map.put(Week.THU, "星期四");
        map.put(Week.FRI, "星期五");
        map.put(Week.SAT, "星期六");
        map.put(Week.SUN, "星期日");

        Set<Map.Entry<Week,String>> set = map.entrySet();
        for (Map.Entry<Week,String> e : set){
            System.out.println(e.getKey() + " : " + e.getValue());
        }*/
    }

}



