package com.joezhou.member;

/**
 * @author JoeZhou
 */
public class FullSingleton {

    private static FullSingleton instance;

    private FullSingleton() {
    }

    public static FullSingleton getInstance() {
        if (instance == null) {
            instance = new FullSingleton();
        }
        return instance;
    }
}
