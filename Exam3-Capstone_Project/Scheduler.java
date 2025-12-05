/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone;

/**
 *
 * @author panka
 */
import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private MaxHeap heap;
    
    public Scheduler() {
        heap=new MaxHeap();
    }
    
    public void addTask(Task task) {
        heap.insert(task);
    }
    
    public Task getTask() {
       return null; //placeholder
       // TODO- returns highest priority task
    }
    
    public List<Task> getTaskOrder() {
        return new ArrayList<>();
        // returns the array in order of tasks being completed
    }
}

