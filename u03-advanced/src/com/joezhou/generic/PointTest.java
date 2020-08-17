package com.joezhou.generic;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class PointTest {

    private static class Point {
        private Integer integerX;
        private Integer integerY;

        Integer getIntegerX() {
            return integerX;
        }

        void setIntegerX(Integer integerX) {
            this.integerX = integerX;
        }

        Integer getIntegerY() {
            return integerY;
        }

        void setIntegerY(Integer integerY) {
            this.integerY = integerY;
        }
    }

    @Test
    public void pointDemo() {
        Point point = new Point();
        point.setIntegerX(10);
        point.setIntegerY(20);
        System.out.println(point.getIntegerX() + " : " + point.getIntegerY());
        //point.setDoubleX(10.5);
        //point.setDoubleY(20.5);
        //System.out.println(point.getDoubleX() + " : " + point.getDoubleY());
        //point.setStringX("东经108°25′");
        //point.setStringY("东经108°25′");
        //System.out.println(point.getStringX() + " : " + point.getStringY());
    }
}