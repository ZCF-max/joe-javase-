package com.joezhou.collection;

import org.junit.Test;

import java.io.Serializable;

/**
 * @author JoeZhou
 */
public class WorkTest {

    @SuppressWarnings("unchecked")
    private static class CustomArrayList<E> {
        private E[] array;
        private int total;

        private CustomArrayList() {
            this(10);
        }


        private CustomArrayList(int size) {
            array = (E[]) new Object[size];
        }

        public void add(E e) {
            if (total >= array.length) {
                E[] newArr = (E[]) new Object[array.length + 10];
                System.arraycopy(array, 0, newArr, 0, array.length);
                newArr[total] = e;
                array = newArr;
            } else {
                array[total] = e;
            }
            total++;
        }


        public E get(int index) {
            if (total <= index) {
                throw new IndexOutOfBoundsException();
            } else {
                return array[index];
            }
        }


    }

    private static class Student implements Serializable {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        Student(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + "]";
        }
    }

    @Test
    public void customArrayList() {
        CustomArrayList<Student> list = new CustomArrayList<>();
        for (int i = 0, j = 100; i < j; i++) {
            list.add(new Student("name-" + i));
        }
        System.out.println(list.get(99));
        System.out.println(list.get(200));
    }
}
