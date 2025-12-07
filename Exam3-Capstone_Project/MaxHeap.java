package com.mycompany.capstone;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author panka
 */

import java.util.ArrayList;
public class MaxHeap {
    private ArrayList<Task> heap;
    
    public MaxHeap() {
        this.heap = new ArrayList<>();
    }
    
    public void insert(Task task) {
        // TODO- inserts a new task into the heap
        heap.add(task);
        upheap(heap.size()-1);
    }
    
    public Task extractMax() {
        if (heap.isEmpty()) {
            return null;
        }

        Task max = heap.get(0);

        Task last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0);
        }

        return max;
        // returns max prioirty task
        
    }   
    
    public void upheap(int index) {
        // TODO- restores heap property afrer element inserted
        
        while (index>0) {
            int parent = (index - 1) / 2;
            int p = parent;
            if (heap.get(p).compareTo(heap.get(index))>=0) {
                break;
            }
            swap(index,p);
            index=p;
            
        }
    }
    
    public void downheap(int index) {
        // TODO- restores heap property after element removed
         
        while (true) {
            int left = 2 * index + 1; 
            int right = 2 * index + 2;
            int largest = index;
 
            if (left < heap.size() && heap.get(left).compareTo(heap.get(largest)) > 0) {
                largest=left;
            }
            if (right < heap.size() && heap.get(right).compareTo(heap.get(largest)) > 0) {
            largest = right;
            }
            if (largest == index) {
            break; 
            }
            swap(index, largest);
            index = largest;
        }
    }
    
    public void swap(int i, int j) {
        Task temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
}
