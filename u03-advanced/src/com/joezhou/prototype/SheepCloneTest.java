package com.joezhou.prototype;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author JoeZhou
 */
public class SheepCloneTest {

    @Test
    public void shallowClone() {
        Date birth = new Date();
        Sheep sheepA = new Sheep();
        sheepA.name = "dorset";
        sheepA.birth = birth;
        Sheep sheepB = sheepA.shallowClone(sheepA);
        sheepB.name = "dolly";
        birth.setTime(999999999999L);
    }

    @Test
    public void multipleShallowClone() {
        Date birth = new Date();
        Sheep sheepA = new Sheep();
        sheepA.name = "dorset";
        sheepA.birth = birth;
        Sheep sheepB = sheepA.multipleShallowClone(sheepA);
        sheepB.name = "dolly";
        birth.setTime(999999999999L);
    }

    @Test
    public void deepClone() {
        Date birth = new Date();
        Sheep sheepA = new Sheep();
        sheepA.name = "dorset";
        sheepA.birth = birth;
        Sheep sheepB = sheepA.deepClone(sheepA);
        sheepB.name = "dolly";
        birth.setTime(999999999999L);
    }
}
