/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab_6;

/**
 *
 * @author N TECH
 */
public class LinkedListQueue {
    // Node class for the linked list
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front, rear;

    // Constructor
    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    // Add an element to the rear of the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Remove and return the front element
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int data = front.data;
        front = front.next;
        if (front == null) { // If the queue becomes empty
            rear = null;
        }
        return data;
    }

    // Return the front element without removing it
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }

    // Display the queue
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();

        System.out.println("Peek: " + queue.peek());
        queue.enqueue(40);
        queue.display();
    }
}
