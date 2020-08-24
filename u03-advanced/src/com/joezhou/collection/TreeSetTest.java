package com.joezhou.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * @author JoeZhou
 */
public class TreeSetTest {

    private static class CustomComparator implements Comparator<Person> {

        @Override
        public int compare(Person personA, Person personB) {
            String nameOfPersonA = personA.getName();
            String nameOfPersonB = personB.getName();
            int result = nameOfPersonA.compareTo(nameOfPersonB);
            if (result == 0) {
                Integer ageOfPersonA = personA.getAge();
                Integer ageOfPersonB = personB.getAge();
                result = ageOfPersonA.compareTo(ageOfPersonB);
            }
            return result;
        }
    }

    private static class Person {
        private String name;
        private int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Person [name=" + name + ", age=" + age + "]";
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


    private TreeSet<String> treeSet;

    @Before
    public void before() {
        treeSet = new TreeSet<>();
    }

    @Test
    public void naturalSort() {
        treeSet.add("abc");
        treeSet.add("aac");
        treeSet.add("abb");
        treeSet.add("acc");
        treeSet.add("3");
        treeSet.add("1");
        treeSet.add("2");
        System.out.println(treeSet);
    }

    @Test
    public void sortByComparator() {
        Set<Person> set = new TreeSet<>(new CustomComparator());
        set.add(new Person("b", 18));
        set.add(new Person("b", 15));
        set.add(new Person("a", 9));
        set.add(new Person("a", 9));
        System.out.println(set);
    }


}
