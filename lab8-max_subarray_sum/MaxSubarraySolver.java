/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_8;

import java.util.ArrayList;

/**
 *
 * @author panka
 */
public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     * Iterates through nested for loops(max of n*n elements)
     */
    public static int bruteForceMaxSum(int[] arr) {
        // TODO: Implement the O(n^2) brute-force algorithm.
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j]; 
                maxSum = Math.max(maxSum, currentSum); 
            }
        }
        
        return maxSum;
        
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     * Iterates through one for each loop(max of n elements)
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        // TODO: Implement the O(n) Kadane's Algorithm.
        int maxSum=Integer.MIN_VALUE;
        int runningSum=0;
        for (int a: arr) {
            runningSum+=a;
            maxSum=Math.max(maxSum, runningSum);
        }
        return maxSum; // Placeholder
    }
}
    
