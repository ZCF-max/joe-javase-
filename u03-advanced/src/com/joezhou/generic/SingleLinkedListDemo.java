package com.joezhou.generic;

/**
 * @author JoeZhou
 */
public class SingleLinkedListDemo<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SingleLinkedListDemo(E headData) {
        this.head = new Node<>(headData);
        this.tail = head;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "[" + data + "-> " + (next == null ? "null" : next.data) + "]";
        }
    }

    public void addHead(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = this.head;
        this.head = newNode;
        size++;
    }

    public void addTail(E data) {
        Node<E> newNode = new Node<>(data);
        tail.next = newNode;
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
                    preNode.next = currentNode.next;
                    size--;
                    break;
                } else {
                    preNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> current = head;
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
}