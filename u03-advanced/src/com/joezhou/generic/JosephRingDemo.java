package com.joezhou.generic;

/**
 * @author JoeZhou
 */
public class JosephRingDemo<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    public JosephRingDemo(E headData) {
        this.head = new Node<>(headData);
        this.head.next = head;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        Node<E> currentNode = this.head;
        Node<E> currentNodeNextNode = currentNode.next;
        currentNode.next = newNode;
        newNode.next = currentNodeNextNode;
        this.head = newNode;
        size++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> current = head;
        do {
            result.append("[");
            result.append(current.data);
            result.append("] ");
            current = current.next;
        } while (current != head);
        return result.toString();
    }

    public void kill(){
        while (this.size > 0) {
            Node<E> currentNode = this.head;
            Node<E> left = currentNode.next;
            Node<E> right = currentNode.next.next.next;
            left.next = right;
            this.head = right;
            size--;
            System.out.println(toString());
        }
    }
}
