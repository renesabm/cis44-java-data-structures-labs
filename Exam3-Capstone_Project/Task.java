/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.capstone;

/**
 *
 * @author panka
 */
public class Task implements Comparable<Task> {

    private int priority;
    private String description;
    
    public Task(int priority, String description) {
        this.priority = priority;
        this.description = description;
    }
    
    public int compareTo(Task other) {
        return this.priority - other.priority;
    }
    
    public Task higherPriority(Task other) {
        if (this.priority>=other.priority) {
            return this;
        }
        else {
            return other;
        }
    }
    
    public String getDescription() {
        return description;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public String toString() {
        return "Task[priority=" + priority + ", description=" + description + "]";
    }
}
