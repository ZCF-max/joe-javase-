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
 * 2.1 创建一个新节点newNode，注入节点内容
 * 2.2 指定newNode为头节点head
 * 2.3 方法：toString()：遍历打印链表中的所有节点
 * <p>
 * 设计测试类：SingleLinkedListTest
 * 1. 获取链表类实例
 * 2. 测试 toString()
 * <p>
 * 链表类中添加新方法：resetHead(E data)
 * 1. 创建一个新的节点newNode，注入节点内容
 * 2. newNode指向原头节点
 * 3. newNode变更为链表头
 * 4. 返回当前链表实例
 * 5. 测试
 * <p>
 * 链表类中添加新方法：add(E data)
 * 1. 创建一个新的节点newNode，注入节点内容
 * 2. 从头开始向后一直寻找
 * 2.1 找到链表的尾节点（currentNode）
 * 3. currentNode指向newNode
 * 4. 返回当前链表实例
 * 5. 测试
 * <p>
 * 链表类中添加新方法：add(E data, int pos)
 * 1. 如果pos<=0，视为重置头节点操作，直接调用resetHead()
 * 2. 创建一个新的节点newNode，注入节点内容
 * 3. 从头开始向后寻找2次（假设pos值为2）
 * 3.1 找到链表中原2号位置上的节点（currentNode）
 * 3.2 同时找到链表中原2-1号位置上的节点（preNode）
 * 3.3 如果寻找过程中就已经到了节点末尾，直接调用add(E data)
 * 4. preNode节点指向newNode
 * 5. newNode指向currentNode
 * 6. 返回当前链表实例
 * 7. 测试
 *
 * 链表类中添加新方法：get(E data)
 * 1. 从头开始向后一直寻找
 * 1.1 寻找的过程中不断地用指定值比对每个节点的data
 * 1.2 比对成功返回对应节点
 * 1.3 比对失败返回null
 * 2. 测试
 *
 * 链表类中添加新方法：delete(E data)
 * 1. 从头开始向后一直寻找
 * 1.2 找到链表中对应指定内容的节点（currentNode）
 * 1.3 同时找到currentNode的上一个的节点（preNode）
 * 1.4 一旦找到，则将preNode节点执行currentNode的next
 * 2. 返回当前链表实例
 * 3. 测试
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
                return "[" + data + "-> " + (next == null ? "null" : next.data) + "]";
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
            Node<E> preNode = this.head;
            for (int i = 0; i < pos; i++) {
                if (currentNode.next == null) {
                    add(data);
                    return this;
                }
                preNode = currentNode;
                currentNode = currentNode.next;
            }
            preNode.next = newNode;
            newNode.next = currentNode;
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
        System.out.println(linkList.add("2222"));
        System.out.println(linkList.add("3333"));
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
