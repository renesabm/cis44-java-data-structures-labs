/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_8;

/**
 *
 * @author panka
 */
import java.util.Random;
import java.util.Arrays;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};
        
        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");
            
            // TODO: Generate a random array and time both algorithms.
            
            int[] print = generateRandomArrayWithNegatives(n);
            long start=System.nanoTime();
            MaxSubarraySolver.bruteForceMaxSum(print);
            long end=System.nanoTime();
            System.out.println("Brute Force:");
            System.out.println(end-start +" ns");
            start=System.nanoTime();
            MaxSubarraySolver.kadanesAlgorithmMaxSum(print);
            end=System.nanoTime();
            System.out.println("Kadanes Algorithm:");
            System.out.println(end-start +" ns");
            
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        // Implementation provided in previous response
        int[] test= new int[size];
        int minNum=-1000;
        int maxNum=1000;
        for (int i=0; i<size; i++) {
            test[i]=(int)(Math.random()*(maxNum-minNum+1)+minNum);
        }
        return test;
    }
}
