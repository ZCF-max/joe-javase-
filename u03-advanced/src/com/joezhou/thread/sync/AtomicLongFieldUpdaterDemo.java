package com.joezhou.thread.sync;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * @author JoeZhou
 */
public class AtomicLongFieldUpdaterDemo {

private static  class Student {
    private volatile long id;
    private volatile String name;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}

    private static AtomicLongFieldUpdater<Student> longFieldUpdater;

    public static void main(String[] args) {

        longFieldUpdater = AtomicLongFieldUpdater.newUpdater(Student.class, "id");

        Student student = new Student(1L, "赵四");
        longFieldUpdater.get(student);
        System.out.println("当前student中的ID值：" + student.getId());

        longFieldUpdater.compareAndSet(student, 1L, 5L);
        System.out.println("当前student中的ID值如果是1就改为5：" + student.getId());

        longFieldUpdater.incrementAndGet(student);
        System.out.println("当前student中的ID+1后值：" + student.getId());

        longFieldUpdater.decrementAndGet(student);
        System.out.println("当当前student中的ID-1后值：" + student.getId());

        longFieldUpdater.addAndGet(student, 5);
        System.out.println("当前student中的ID+5后值：" + student.getId());

        long result = longFieldUpdater.accumulateAndGet(student, 5, (left, right) -> {
            System.out.print("left：" + left + "\t");
            System.out.print("right：" + right + "\n");
            return left * right;
        });
        System.out.println("当前student中的ID*5后值：" + student.getId());
        
    }
}