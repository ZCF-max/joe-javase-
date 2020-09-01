package com.joezhou.thread.sync;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * @author JoeZhou
 */
public class FieldUpdaterTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Student implements Serializable {
        volatile long id;
        volatile String name;
        volatile int age;
    }

    @Test
    public void atomicLongFieldUpdater() {
        AtomicLongFieldUpdater<Student> updater = AtomicLongFieldUpdater.newUpdater(Student.class, "id");
        Student student = new Student(1L, "zhao-si", 58);
        updater.get(student);
        System.out.println("id from student：" + student.getId());

        updater.compareAndSet(student, 1L, 5L);
        System.out.println("update id from student to 5L：" + student.getId());

        updater.incrementAndGet(student);
        System.out.println("++id：" + student.getId());

        updater.decrementAndGet(student);
        System.out.println("--id：" + student.getId());

        updater.addAndGet(student, 5);
        System.out.println("id+=5 and return：" + student.getId());

        System.out.println("accumulate and return：" + updater.accumulateAndGet(student, 5, (left, right) -> {
            System.out.print("left：" + left + "\t");
            System.out.print("right：" + right + "\n");
            return (left - 1) * (right - 9) / 4;
        }));
    }
}