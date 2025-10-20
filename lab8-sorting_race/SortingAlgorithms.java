/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab_project_8;

/**
 *
 * @author panka
 */
public class SortingAlgorithms {

    /**
     * Implements the Selection Sort algorithm.
     * Theoretical Complexity: O(n^2)
     */
    public static void selectionSort(int[] arr) {
        // TODO: Implement the Selection Sort algorithm.
        for (int i=0; i<arr.length-1; i++) {
            int minIndex=i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp=arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i]=temp;
        }
    }

    /**
     * Implements the Insertion Sort algorithm.
     * Theoretical Complexity: O(n^2) / Best-Case: O(n)
     */
    public static void insertionSort(int[] arr) {
        // TODO: Implement the Insertion Sort algorithm.
        for (int i=1; i<arr.length; i++) {
            int key =arr[i];
            int j=i-1;
            while ((j>=0)&& arr[j]>key) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

    /**
     * Implements the Merge Sort algorithm. Public-facing method.
     * Theoretical Complexity: O(n log n)
     */
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // Already sorted
        }
        int[] temp = new int[arr.length];
        mergeSortRecursive(arr, temp, 0, arr.length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        // TODO: Implement the recursive logic for Merge Sort.
        if (left<right) {
            int mid=(left+right)/2;
            mergeSortRecursive(arr, temp, left, mid);
            mergeSortRecursive(arr, temp, mid+1, right);
            //mergeSortRecursive(arr, temp, mid-1, left);
            merge(arr, temp, left, mid, right);
               
        }
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // TODO: Implement the merge logic for Merge Sort.
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;     // Left subarray index
        int j = mid + 1;  // Right subarray index
        int k = left;     // Merged array index

        // Merge elements back into the original array
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements from the left half (if any)
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }

        // No need to copy the right half since it’s already in place
    }
}
