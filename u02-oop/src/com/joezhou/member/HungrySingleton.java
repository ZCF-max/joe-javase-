package com.joezhou.member;

/**
 * @author JoeZhou
 */
public class HungrySingleton {

    private final static HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
