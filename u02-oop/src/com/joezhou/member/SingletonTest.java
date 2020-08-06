package com.joezhou.member;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class SingletonTest {
    @Test
    public void hungrySingleton() {
        HungrySingleton instanceA = HungrySingleton.getInstance();
        HungrySingleton instanceB = HungrySingleton.getInstance();
        System.out.println(instanceA == instanceB);
    }

    @Test
    public void fullSingleton() {
        FullSingleton instanceA = FullSingleton.getInstance();
        FullSingleton instanceB = FullSingleton.getInstance();
        System.out.println(instanceA == instanceB);
    }
}
