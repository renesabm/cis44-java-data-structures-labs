/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_4;

/**
 *
 * @author panka
 */
public class TextEditor {
        private static class Node {
            String textState;
            Node prev;
            Node next;
            // Node constructor...
            public Node(String textState, Node prev, Node next) {
                this.textState=textState;
                this.prev=prev;
                this.next=next;
            }
        }

        private Node currentNode;

        public TextEditor() {
            // Start with an initial empty string state.
            Node initialNode = new Node("", null, null);
            this.currentNode = initialNode;
        }

        public void add(String newText) {
            // Create a new node with the updated text.
            // Set its 'prev' to the current node.
            // Set the current node's 'next' to this new node.
            // Finally, update currentNode to point to the new node.
            currentNode.next = null;
            String updated=currentNode.textState+newText;
            Node newNode=new Node(updated, currentNode, null);
            currentNode.next=newNode;
            currentNode=newNode;
            //System.out.println("Adding: "+currentNode.textState);
        }

        public String undo() {
            // Check if currentNode.prev is not null.
            // If it is, move currentNode back and return the text.
            // Otherwise, you can't undo.
  
            if (currentNode.prev!=null) {
                System.out.println("Undo from "+currentNode.textState+ " to " + currentNode.prev.textState);
                currentNode=currentNode.prev;
                
                return currentNode.textState;
            }
            System.out.println("Nothing to undo");
            return null;
        }

        public String redo() {
            // Check if currentNode.next is not null.
            // If it is, move currentNode forward and return the text.
            if (currentNode.next!=null) {
                System.out.println("Redo from "+currentNode.textState+ " to " + currentNode.next.textState);
                currentNode=currentNode.next;
                
                return currentNode.textState;

            }
            System.out.println("Nothing to redo");
            return null;
        }

        public void printCurrent() {
            System.out.println("Current text: " + currentNode.textState);
        }
    public static void main(String[] args) {
        TextEditor text1= new TextEditor();
        text1.add("Hello");
        text1.printCurrent();
        text1.add(" all");
        text1.printCurrent();
        //text1.add("Hello Everyone");
        //text1.printCurrent();
        text1.undo();
        text1.printCurrent();
        text1.redo();
        text1.printCurrent();
    }
}
