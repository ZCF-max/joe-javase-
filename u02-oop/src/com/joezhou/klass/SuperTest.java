package com.joezhou.klass;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class SuperTest {
    @Test
    public void animalAndBirdAndDog() {
        System.out.println(new Bird().getName());
        new Dog().methodA();
    }
}

class Animal {
    private String name;

    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    public void move() {
        System.out.println("动物都可以移动！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Bird extends Animal {
    public Bird() {
        super("精卫");
    }
}

class Dog extends Animal {
    public Dog() {
        super.move();
    }

    public void methodA() {
        super.move();
    }
}
