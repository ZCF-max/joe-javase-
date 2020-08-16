package com.joezhou.generic;

/**
 * @author JoeZhou
 */
public class CycleLinkedListDemo<E> {

    private Node<E> head;
    private int size;

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

    public CycleLinkedListDemo(E headData) {
        this.head = new Node<>(headData);
        this.head.next = head;
    }

    public void add(E data) {
        Node<E> newNode = new Node<>(data);
        Node<E> currentNode = this.head;
        Node<E> currentNodeNextNode = currentNode.next;
        currentNode.next = newNode;
        newNode.next = currentNodeNextNode;
        size++;
    }

    public Node get(E data) {
        Node<E> result = null;
        Node<E> currentNode = this.head;
        do {
            if (data.equals(currentNode.data)) {
                result = currentNode;
                break;
            } else {
                currentNode = currentNode.next;
            }
        } while (currentNode != head);
        return result;
    }

    public void delete(E data) {
        if (this.size > 0) {
            Node currentNode = this.head;
            Node preNode = head;
            do {
                if (data.equals(currentNode.data)) {
                    preNode.next = currentNode.next;
                    size--;
                    break;
                } else {
                    preNode = currentNode;
                    currentNode = currentNode.next;
                }
            } while (currentNode != head);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
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
