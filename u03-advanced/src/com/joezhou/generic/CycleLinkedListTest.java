package com.joezhou.generic;

import org.junit.Before;
import org.junit.Test;

/**
 * @author JoeZhou
 */
public class CycleLinkedListTest {

    private static class CycleLinkedListDemo<E> {

        private Node<E> head;

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

        private CycleLinkedListDemo(E headData) {
            this.head = new Node<>(headData);
            this.head.next = this.head;
        }

        public CycleLinkedListDemo<E> add(E data) {
            Node<E> newNode = new Node<>(data);
            Node<E> headNode = this.head;
            Node<E> neckNode = headNode.next;
            headNode.next = newNode;
            newNode.next = neckNode;
            return this;
        }

        private Node<E> get(E data) {
            Node<E> result = null;
            Node<E> currentNode = this.head;
            do {
                if (data.equals(currentNode.data)) {
                    result = currentNode;
                    break;
                }
                currentNode = currentNode.next;
            } while (currentNode != this.head);
            return result;
        }

        private CycleLinkedListDemo<E> delete(E data) {
            Node currentNode = this.head;
            Node preNode = this.head;
            do {
                if (data.equals(currentNode.data)) {
                    preNode.next = currentNode.next;
                    break;
                }
                preNode = currentNode;
                currentNode = currentNode.next;
            } while (currentNode != this.head);
            return this;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("cycle-linked-list: ");
            Node<E> current = head;
            do {
                result.append("[");
                result.append(current.data);
                result.append("-> ");
                result.append(current.next == null ? "null" : current.next.data);
                result.append("] ");
                current = current.next;
            } while (current != head);
            return result.toString();
        }
    }

    private CycleLinkedListDemo<String> linkList;

    @Before
    public void before() {
        linkList = new CycleLinkedListDemo<>("1111");
    }

    @Test
    public void add() {
        System.out.println(linkList);
        System.out.println(linkList.add("2222"));
        System.out.println(linkList.add("3333"));
        System.out.println(linkList.add("4444"));
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
