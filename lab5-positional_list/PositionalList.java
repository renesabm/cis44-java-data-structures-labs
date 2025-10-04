/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_5;

/**
 *
 * @author panka
 */
import java.util.Iterator;
public class PositionalList {
    
// You'll need a Position interface
public interface Position<E> { E getElement(); }

public class LinkedPositionalList<E> implements Iterable<E> {
    // --- Nested Node Class (implements Position) ---
    private static class Node<E> implements Position<E> {
        // ... element, prev, next pointers and methods ...
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E element, Node<E> prev, Node<E> next) {
            this.element=element;
            this.prev=prev;
            this.next=next;
        }
        public void setElement(E newElement) {
            element = newElement;
        }
        public E getElement() {
            return element;
        }
        
        public Node<E> getPrev() {
        return prev;
        }
        public Node<E> getNext() {
        return next;
        }
        public void setPrev(Node<E> newPrev) {
        prev=newPrev;
        }
        public void setNext(Node<E> newNext) {
        next=newNext;
        }
        
    }
    
    private Node header;
    private Node trailer;
    private int size = 0;

    public LinkedPositionalList() {
        // ... constructor to create sentinel nodes ...
    header = new Node<>(null, null, null);   // header's prev is null
    trailer = new Node<>(null, header, null); // trailer's prev is header
    header.setNext(trailer);                 // header's next is trailer
    }
    
    // ... Implement all the Positional List methods ...
    public Position<E> first() {
        return (header.getNext());
    }
    public Position<E> last() {
        return (trailer.getPrev());
    }
    public Position<E> before(Position<E> p) {
        return ((Node<E>)(p)).getPrev();
    }
    public Position<E> after(Position <E> p) {
        return ((Node<E>)(p)).getNext();
    }
    public Position<E> addFirst(E e) {
        Node<E> next = header.getNext();                          // the current first node
        Node<E> newNode = new Node<>(e, header, next);            // create new node
        header.setNext(newNode);                                  // link header to new node
        next.setPrev(newNode);                                    // link former first to new node
        size++;                                                   // increment size
        return newNode;  
        
    }
    public Position<E> addLast(E e) {
        Node<E> prev = trailer.getPrev();                          // the current first node
        Node<E> newNode = new Node<>(e, prev, trailer);            // create new node
        prev.setNext(newNode);                                  // link header to new node
        trailer.setPrev(newNode);                                    // link former first to new node
        size++;                                                   // increment size
        return newNode;  
    }
    public Position<E> addBefore(Position <E> p,E e) {
        Node<E> current=(Node<E>)(p);
        Node<E> prev=current.getPrev();
        Node<E> newNode = new Node<E>(e, prev, current);
        prev.setNext(newNode);
        current.setPrev(newNode);
        size++;
        return newNode; 
    }
    public Position<E> addAfter(Position <E> p,E e) {
        Node<E> current=(Node<E>)(p);
        Node<E> next=current.getNext();
        Node<E> newNode=new Node<E>(e, current, next);
        current.setNext(newNode);   // link current to new node
        next.setPrev(newNode); 
        size++;
        return newNode;
    }

    public E set(Position <E> p,E e) {
        Node<E> node = (Node<E>)(p);
        E old = node.getElement();
        node.setElement(e);
        return old;
        
    }
    public E remove(Position<E> p) {
        Node<E> node = (Node<E>)(p);
        Node<E> prev=node.getPrev();
        Node<E> next=node.getNext();
        prev.setNext(next);                   // Link prev to next, skipping node
        next.setPrev(prev);
        E element=node.getElement();
        size--;
        return element;
    }

    /**
     *
     * @return
     */
    public Iterator iterator() {
        return new ElementIterator();
    }

    // --- Nested Iterator Class ---
    private class ElementIterator implements Iterator {
        Position<E> cursor = first(); // Start at the first element
        
        public boolean hasNext() {
            return cursor != null;
        }
        
        public E next() {
            // Store the element at the current cursor
            // Advance the cursor to the next position using after()
            // Return the stored element
        E element = cursor.getElement();   // Step 1: get element
        cursor = after(cursor);            // Step 2: move cursor forward
        return element;                    // Step 3: return element
        }
        public Iterator<E> iterator() {
            return new ElementIterator();
        }
    }
    

    }

    public static void main(String[] args) {
        PositionalList outer = new PositionalList();
        PositionalList.LinkedPositionalList<String> itinerary = outer.new LinkedPositionalList<>();


        Position<String> stop1 = itinerary.addLast("New York");
        Position<String> stop2 = itinerary.addLast("Paris");
        Position<String> stop3 = itinerary.addLast("Tokyo");

        Position<String> stopLondon = itinerary.addAfter(stop1, "London");

        System.out.println("Final itinerary:");
        for (String city : itinerary) {
            System.out.println(city);
        }
    }

}

    
    

