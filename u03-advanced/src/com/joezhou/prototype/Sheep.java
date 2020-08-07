package com.joezhou.prototype;

import java.util.Date;

/**
 * @author JoeZhou
 */
public class Sheep implements Cloneable {
    String name;
    Date birth;

    Sheep shallowClone(Sheep sheep) {
        Sheep result = null;
        try {
            result = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }

    Sheep multipleShallowClone(Sheep sheep) {
        Sheep result = null;
        try {
            result = (Sheep) super.clone();
            Date birth = (Date) result.birth.clone();
            result.birth = birth;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }
}