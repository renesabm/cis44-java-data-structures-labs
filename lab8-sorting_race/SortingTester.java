package com.mycompany.lab_project_8;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author panka
 */
import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};
        
        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            // TODO: Call your test methods for Average, Best, and Worst cases.
        System.out.println("Average Case:");
              
        int[] print =generateRandomArray(n);
        SortingTester.runAndTimeAllSorts(print);
        System.out.println("\nBest Case:");
        print=generateSortedArray(n);
        SortingTester.runAndTimeAllSorts(print);
        System.out.println("\nWorst Case:");
        print=generateReverseSortedArray(n);
        SortingTester.runAndTimeAllSorts(print);
            
        }
    }
    
    // TODO: Implement the runAndTimAllSorts helper method.
    public static void runAndTimeAllSorts(int[] arr) {
        long start=System.nanoTime();
   
        SortingAlgorithms.selectionSort(arr);
        long end=System.nanoTime();
        System.out.println("Selection Sort time: " + (end-start)+" ns");
        start=System.nanoTime();
   
        SortingAlgorithms.insertionSort(arr);
        end=System.nanoTime();
        System.out.println("Insertion Sort time: " + (end-start)+" ns");
        start=System.nanoTime();
   
        SortingAlgorithms.mergeSort(arr);
        end=System.nanoTime();
        System.out.println("Merge Sort time: " + (end-start)+" ns");
    }

    public static int[] generateRandomArray(int size) {
        // Implementation provided in previous response
        Random rand=new Random();
        int[] average= new int[size];
        for (int i=0; i<size; i++) {
            average[i]=(int)(Math.random()*1000);
        }
        return average;
    }

    public static int[] generateSortedArray(int size) {
        // Implementation provided in previous response
        int[] best= new int[size];
        for (int i=0; i<size; i++) {
            best[i]=(int)(Math.random()*1000);
        }
        Arrays.sort(best);
        return best;
    }

    public static int[] generateReverseSortedArray(int size) {
        // Implementation provided in previous response
        int[] worst = generateSortedArray(size);
        for (int i = 0; i < size / 2; i++) {
        int temp = worst[i];
        worst[i] = worst[size - 1 - i];
        worst[size - 1 - i] = temp;
        
        }
        return worst;
    }
}
