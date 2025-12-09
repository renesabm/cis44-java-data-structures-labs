/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.capstone;

/**
 *
 * @author panka
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class SchedulerTest {

    private Scheduler scheduler;

    @Before
    public void setUp() {
        scheduler = new Scheduler();
    }

    @Test
    public void testEmptyScheduler() {
        System.out.println("\n----Case 1: Empty Scheduler----");
        Task result = scheduler.getTask();
        System.out.println("\nProcessing (expected null): " + result);
        assertTrue(result == null);
    }

    @Test
    public void testPriorityCheck() {
        System.out.println("\n\n----Case 2: Priority Check----");

        Task t1 = new Task(1, "Low priority print");
        System.out.println("\nAdding: " + t1);
        scheduler.addTask(t1);

        Task t2 = new Task(5, "Urgent database backup");
        System.out.println("\nAdding: " + t2);
        scheduler.addTask(t2);

        Task t3 = new Task(3, "Medium email send");
        System.out.println("\nAdding: " + t3);
        scheduler.addTask(t3);

        Task t4 = new Task(10, "Critical security patch");
        System.out.println("\nAdding: " + t4);
        scheduler.addTask(t4);

        Task top = scheduler.getTask();
        System.out.println("\nTop task: " + top);
        assertTrue(top != null && top.getPriority() == 10);
        assertEquals(10, top.getPriority());
        System.out.println("\nRemaining execution order:");
        for (Task t : scheduler.getTaskOrder()) {
            System.out.println(t);
        }
    }

    @Test
    public void testTieCase() {
        System.out.println("\n\n----Case 3: Tie Case (Duplicate Priorities)----");

        Task t1 = new Task(2, "Urgent #1");
        System.out.println("\nAdding: " + t1);
        scheduler.addTask(t1);

        Task t2 = new Task(2, "Urgent #2");
        System.out.println("\nAdding: " + t2);
        scheduler.addTask(t2);

        Task tieResult = scheduler.getTask();
        System.out.println("\nReturned task: " + tieResult);
        assertTrue(tieResult != null && tieResult.getPriority() == 2);
        assertEquals(2, tieResult.getPriority());

    }
    

}
