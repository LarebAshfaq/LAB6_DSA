/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab_6;

/**
 *
 * @author N TECH
 */
class DoublyLinkedList {
    // Node class
    class Node {
        int data;
        Node prev, next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    // a) Insertion Operations
    public void addAtStart(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    public void addAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void addAtPosition(int data, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 0) {
            addAtStart(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    // b) Deletion Operations
    public void deleteFromStart() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
    }

    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
    }

    public void deleteByValue(int data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == data) {
            deleteFromStart();
            return;
        }
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Value not found");
            return;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

    // c) Traversal Operations
    public void displayFromStart() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // d) Search Operation
    public void search(int value) {
        Node current = head;
        int position = 0;
        while (current != null) {
            if (current.data == value) {
                System.out.println("Value found at position: " + position);
                return;
            }
            current = current.next;
            position++;
        }
        System.out.println("Value not found");
    }

    // e) Reverse the List
    public void reverse() {
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    // f) Count Nodes
    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Testing the DoublyLinkedList
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Insert nodes
        dll.addAtStart(10);
        dll.addAtEnd(20);
        dll.addAtPosition(15, 1);
        dll.addAtEnd(25);
        dll.addAtStart(5);

        // Display list
        System.out.println("List from start:");
        dll.displayFromStart();

        System.out.println("List from end:");
        dll.displayFromEnd();

        // Delete nodes
        dll.deleteFromStart();
        System.out.println("After deleting from start:");
        dll.displayFromStart();

        dll.deleteFromEnd();
        System.out.println("After deleting from end:");
        dll.displayFromStart();

        dll.deleteByValue(15);
        System.out.println("After deleting value 15:");
        dll.displayFromStart();

        // Search for values
        dll.search(20);
        dll.search(100);

        // Reverse the list
        dll.reverse();
        System.out.println("After reversing the list:");
        dll.displayFromStart();

        // Count nodes
        System.out.println("Total nodes: " + dll.countNodes());
    }
}