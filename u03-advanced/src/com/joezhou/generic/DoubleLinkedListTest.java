package com.joezhou.generic;

import org.junit.Test;

/**
 * @author JoeZhou
 */
public class DoubleLinkedListTest<T> {

    private static class DoubleLinkedListDemo<E> {

        private static class Node<E> {
            E data;
            Node<E> next;
            Node<E> pre;

            Node(E data) {
                this.data = data;
            }

            @Override
            public String toString() {
                return "["
                        + (pre == null ? "null" : pre.data)
                        + "|" + data + "|"
                        + (next == null ? "null" : next.data)
                        + "]";
            }
        }

        private Node<E> head;
        private Node<E> tail;
        private int size;

        DoubleLinkedListDemo(E headData) {
            this.head = new Node<>(headData);
            this.tail = head;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            Node<E> current = head;
            while (current != null) {
                result.append("[");
                result.append(current.pre == null ? "null" : current.pre.data);
                result.append(" <-");
                result.append(current.data);
                result.append("-> ");
                result.append(current.next == null ? "null" : current.next.data);
                result.append("] ");
                current = current.next;
            }
            return result.toString();
        }

        void addHead(E data) {
            Node<E> newNode = new Node<>(data);
            this.head.pre = newNode;
            newNode.next = this.head;
            this.head = newNode;
            size++;
        }

        void addTail(E data) {
            Node<E> newNode = new Node<>(data);
            this.tail.next = newNode;
            newNode.pre = this.tail;
            this.tail = newNode;
            size++;
        }

        public void add(int pos, E data) {

            if (pos <= 0) {
                this.addHead(data);
                return;
            }

            if (pos >= this.size) {
                this.addTail(data);
                return;
            }

            Node<E> newNode = new Node<>(data);
            Node<E> currentNode = this.head;
            for (int i = 0; i < pos - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            newNode.pre = currentNode;
            currentNode.next = newNode;
            size++;
        }

        public Node get(E data) {
            Node<E> result = null;
            Node<E> currentNode = this.head;
            while (currentNode != null) {
                if (data.equals(currentNode.data)) {
                    result = currentNode;
                    break;
                } else {
                    currentNode = currentNode.next;
                }
            }
            return result;
        }

        public void delete(E data) {
            if (this.size > 0) {
                Node currentNode = this.head;
                Node preNode = head;
                while (currentNode != null) {
                    if (data.equals(currentNode.data)) {
                        preNode.next = currentNode.next.pre;
                        size--;
                        break;
                    } else {
                        preNode = currentNode;
                        currentNode = currentNode.next;
                    }
                }
            }
        }

    }

    private DoubleLinkedListDemo<String> linkList = new DoubleLinkedListDemo<>("head");

    @Test
    public void addHead() {
        System.out.println(linkList);
        linkList.addHead("aaaa");
        System.out.println(linkList);
        linkList.addHead("bbbb");
        System.out.println(linkList);
    }

    @Test
    public void addTail() {
        System.out.println(linkList);
        linkList.addTail("aaaa");
        System.out.println(linkList);
        linkList.addTail("bbbb");
        System.out.println(linkList);
    }

    @Test
    public void add() {
        System.out.println(linkList);
        linkList.add(0, "aaaa");
        System.out.println(linkList);
        linkList.add(9, "bbbb");
        System.out.println(linkList);
        linkList.add(1, "cccc");
        System.out.println(linkList);
        linkList.add(2, "dddd");
        System.out.println(linkList);
    }

    @Test
    public void get() {
        linkList.addTail("aaaa");
        linkList.addTail("bbbb");
        System.out.println(linkList.get("bbbb"));
    }

    @Test
    public void delete() {
        System.out.println(linkList);
        linkList.addTail("aaaa");
        System.out.println(linkList);
        linkList.addTail("bbbb");
        System.out.println(linkList);
        linkList.addTail("cccc");
        System.out.println(linkList);
        linkList.delete("bbbb");
        System.out.println(linkList);
    }
}
