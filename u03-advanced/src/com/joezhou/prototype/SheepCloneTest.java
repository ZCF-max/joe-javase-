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
        System.out.println("sheepA：" + sheepA.name + "-" + sheepA.birth);

        Sheep sheepB = sheepA.shallowClone(sheepA);
        System.out.println("sheepB：" + sheepB.name + "-" + sheepB.birth);
        System.out.println(sheepA == sheepB ? "is same sheep" : "is different sheep");

        birth.setTime(999999999999L);
        System.out.println("sheepA-birth：" + sheepA.birth);
        System.out.println("sheepB-birth：" + sheepB.birth);
    }

    @Test
    public void multipleShallowClone() {
        Date birth = new Date();

        Sheep sheepA = new Sheep();
        sheepA.name = "dorset";
        sheepA.birth = birth;
        System.out.println("sheepA：" + sheepA.name + "-" + sheepA.birth);

        Sheep sheepB = sheepA.multipleShallowClone(sheepA);
        System.out.println("sheepB：" + sheepB.name + "-" + sheepB.birth);
        System.out.println(sheepA == sheepB ? "is same sheep" : "is different sheep");

        birth.setTime(999999999999L);
        System.out.println("sheepA-birth：" + sheepA.birth);
        System.out.println("sheepB-birth：" + sheepB.birth);
    }
}
