package com.joezhou.generic;

import org.junit.Before;
import org.junit.Test;

/**
 * 设计流程：
 * <p>
 * 设计节点类：Node<E>
 * 1. 属性：E data：节点内容
 * 2. 属性：Node<E> next：当前节点的后继节点
 * 3. 构造：Node(E data)：指定data内容
 * 4. 方法：toString()：[this.data -> next.data]
 * <p>
 * 设计链表类：SingleLinkedListDemo<E>
 * 1. 属性：Node<E> head：头节点
 * 2. 构造：SingleLinkedListDemo(E headData)
 * 2.1 创建一个新节点，注入节点内容
 * 2.2 指定新节点为头节点
 * 2.3 方法：toString()：遍历打印链表中的所有节点
 * <p>
 * 设计测试类：SingleLinkedListTest
 * 1. 获取链表类实例
 * 2. 测试 toString()
 * <p>
 * 链表类中添加新方法：resetHead(E data)
 * 1. 创建一个新的节点，注入节点内容
 * 2. 将新节点的next指向原头节点
 * 3. 将新节点变更为链表的新头节点
 * 4. 返回当前链表实例
 * 5. 测试
 *
 * 链表类中添加新方法：add(E data)
 * 1. 创建一个新的节点，注入节点内容
 * 2. 从头开始向后寻找尾节点（next为null的就是尾节点）
 * 3. 将尾节点的next由null更改为新节点
 * 4. 返回当前链表实例
 * 5. 测试
 *
 * 链表类中添加新方法：add(E data, int pos)
 * 1. 如果pos<=0，视为重置头节点操作，直接调用resetHead()
 * 2. 创建一个新的节点，注入节点内容
 * 3. 从头开始向后寻找pos原位置上的节点（假设为A节点）
 * 3.1 如果过程中发现尾节点，直接调用add(E data)
 * 4. 将新节点的next变更A节点的next
 * 5. 将A节点的next变更为新节点
 * 6. 返回当前链表实例
 * 7. 测试
 *
 * @author JoeZhou
 */
public class SingleLinkedListTest {

    private static class SingleLinkedListDemo<E> {

        private static class Node<E> {
            private E data;
            private Node<E> next;

            private Node(E data) {
                this.data = data;
            }

            @Override
            public String toString() {
                return data + "-> " + (next == null ? "null" : next.data);
            }
        }

        private Node<E> head;

        private SingleLinkedListDemo(E headData) {
            this.head = new Node<>(headData);
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("single-linked-list: ");
            Node<E> current = this.head;
            while (current != null) {
                result.append("[");
                result.append(current.data);
                result.append("-> ");
                result.append(current.next == null ? "null" : current.next.data);
                result.append("] ");
                current = current.next;
            }
            return result.toString();
        }

        private SingleLinkedListDemo<E> resetHead(E data) {
            Node<E> newNode = new Node<>(data);
            newNode.next = this.head;
            this.head = newNode;
            return this;
        }

        private SingleLinkedListDemo<E> add(E data) {
            Node<E> currentNode = this.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = new Node<>(data);
            return this;
        }

        private SingleLinkedListDemo<E> add(E data, int pos) {

            if (pos <= 0) {
                this.resetHead(data);
                return this;
            }

            Node<E> newNode = new Node<>(data);
            Node<E> currentNode = this.head;
            for (int i = 0; i < pos - 1; i++) {
                if (currentNode.next == null) {
                    add(data);
                    return this;
                }
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            return this;
        }

        private Node<E> get(E data) {
            Node<E> result = null;
            Node<E> currentNode = this.head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    result = currentNode;
                    break;
                }
                currentNode = currentNode.next;
            }
            return result;
        }

        private SingleLinkedListDemo<E> delete(E data) {
            Node currentNode = this.head;
            Node preNode = this.head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    preNode.next = currentNode.next;
                    break;
                }
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            return this;
        }
    }

    private SingleLinkedListDemo<String> linkList;

    @Before
    public void before() {
        linkList = new SingleLinkedListDemo<>("1111");
    }

    @Test
    public void iterator() {
        System.out.println(linkList);
    }

    @Test
    public void resetHead() {
        System.out.println(linkList);
        System.out.println(linkList.resetHead("2222"));
        System.out.println(linkList.resetHead("3333"));
        System.out.println(linkList.resetHead("4444"));
    }

    @Test
    public void add() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222"));
        System.out.println(linkList.add("3333"));
        System.out.println(linkList.add("4444"));
    }

    @Test
    public void addWithPos() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222", 0));
        System.out.println(linkList.add("3333", 9));
        System.out.println(linkList.add("4444", 1));
        System.out.println(linkList.add("5555", 2));
    }

    @Test
    public void get() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222", 9));
        System.out.println(linkList.add("3333", 0));
        System.out.println("node: " + linkList.get("2222"));
        System.out.println("node: " + linkList.get("3333"));
        System.out.println("node: " + linkList.get("4444"));
    }

    @Test
    public void delete() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222"));
        System.out.println(linkList.add("3333"));
        System.out.println(linkList.add("4444"));
        System.out.println(linkList.delete("2222"));
        System.out.println(linkList.delete("5555"));
    }
}
