/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone;

/**
 *
 * @author panka
 */
public class SchedulerDriver {
    
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        // TODO- implementation with various test cases
        // insert tasks, extract tasks, print final order
        
        System.out.println("\n----Scheduler Driver Tests----");
        System.out.println("\nCase 1: Empty ");
        Task result = scheduler.getTask();
        System.out.println("\nProcessing (expected null): " + result);
        if (result == null) {
            System.out.println("PASS Empty scheduler returned null");
        }
        else {
            System.out.println("FAIL null expected");
        }
        System.out.println("\n\nCase 2: Priority Check ");
        scheduler = new Scheduler();
        System.out.println("\nAdding: " + new Task(1, "Low priority print"));
        scheduler.addTask(new Task(1, "Low priority print"));
        System.out.println("\nAdding: " + new Task(5, "Urgent database backup"));
        scheduler.addTask(new Task(5, "Urgent database backup"));
        System.out.println("\nAdding: " + new Task(3, "Medium email send"));
        scheduler.addTask(new Task(3, "Medium email send"));
        System.out.println("\nAdding: " + new Task(10, "Critical security patch"));
        scheduler.addTask(new Task(10, "Critical security patch"));
        Task top = scheduler.getTask();
        System.out.println("\nTop task: " + top);
        if (top != null && top.getPriority() == 10) {
            System.out.println("PASS Highest priority returned first");
        } 
        else {
            System.out.println("FAIL Expected priority 10");
        }
        System.out.println("\nRemaining execution order:");
        for (Task t : scheduler.getTaskOrder()) {
            System.out.println("\n"+t);
        }
        System.out.println("\n\nCase 3: Tie Case (Duplicate Priorities)");
        scheduler = new Scheduler();
        System.out.println("\nAdding: " + new Task(2, "Low Priority #1"));
        scheduler.addTask(new Task(2, "Urgent #1"));
        System.out.println("\nAdding: " + new Task(2, "Low Priority #2"));
        scheduler.addTask(new Task(2, "Urgent #2"));

        Task tieResult = scheduler.getTask();

        System.out.println("\nReturned task: " + tieResult);

        if (tieResult != null && tieResult.getPriority() == 2) {
            System.out.println("PASS Correctly handled tie on priority 2\n");
        } else {
            System.out.println("FAIL Expected priority 2\n");
        }
        
    }
}
