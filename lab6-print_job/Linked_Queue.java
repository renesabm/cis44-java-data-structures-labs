/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_6;
import java.util.NoSuchElementException;

/**
 *
 * @author panka
 */
public class Linked_Queue {
    // You will need a functioning Queue implementation (like LinkedQueue) for this to work.
    // interface Queue { ... }
    // class LinkedQueue implements Queue { ... }
    interface Queue<T> {
        void enqueue(T element);
        T dequeue();
        boolean isEmpty();
    }
    /**
     * Represents a single document to be printed.
     */
    static class LinkedQueue<T> implements Queue<T> {
        private static class Node<T>{
            private T data;
            private Node<T> next;
            private Node(T data) {
                this.data = data;
            }
        }

        private Node<T> front;
        private Node<T> rear;

        public void enqueue(T element) {
            Node<T> newNode = new Node<>(element);
            if (rear != null) {
                rear.next = newNode;
            }
            rear = newNode;
            if (front == null) {
                front = rear;
            }
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("Queue is empty");
            }
            T data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }
        public boolean isEmpty() {
            return front == null;
        }
    }
    /**
     * Represents a single document to be printed.
     */
    static class PrintJob {
        private String documentName;
        private int pageCount;

        public PrintJob(String documentName, int pageCount) {
            this.documentName = documentName;
            this.pageCount = pageCount;
        }

        @Override
        public String toString() {
            return "PrintJob[Document: " + documentName + ", Pages: " + pageCount + "]";
        }
    }

    /**
     * Simulates a printer that manages a queue of print jobs.
     */
    public static class Printer {
        private Queue jobQueue;

        public Printer() {
            // TODO: Initialize the jobQueue with a LinkedQueue
            jobQueue = new LinkedQueue<>(); // Placeholder
        }

        /**
         * Adds a new print job to the rear of the queue.
         * @param job The print job to add.
         */
        public void addJob(PrintJob job) {
            System.out.println("Adding to queue: " + job);
            // TODO: Enqueue the job
            jobQueue.enqueue(job);
        }

        /**
         * Processes the job at the front of the queue.
         */
        public void processNextJob() {
            // TODO: Check if the queue is empty. If so, print a message.
            // If not empty, dequeue the job and print a "Processing..." message.
            if (jobQueue.isEmpty()) {
                System.out.println("Empty queue");
            }
            else {
                PrintJob job= (PrintJob)jobQueue.dequeue();
                System.out.println("Processing "+job);
                
            }
        }
    }

        public static void main(String[] args) {
            Printer officePrinter = new Printer();

            officePrinter.addJob(new PrintJob("Annual_Report.pdf", 25));
            officePrinter.addJob(new PrintJob("Meeting_Agenda.docx", 2));
            officePrinter.addJob(new PrintJob("Presentation_Slides.pptx", 30));

            System.out.println("\n--- Starting to Print ---");
            officePrinter.processNextJob(); // Should print Annual_Report.pdf
            officePrinter.processNextJob(); // Should print Meeting_Agenda.docx

            System.out.println("\nNew high-priority job arrives...");
            officePrinter.addJob(new PrintJob("Urgent_Memo.pdf", 1));

            officePrinter.processNextJob(); // Should print Presentation_Slides.pptx
            officePrinter.processNextJob(); // Should print Urgent_Memo.pdf
            officePrinter.processNextJob(); // Should say the queue is empty
        }
}
          
