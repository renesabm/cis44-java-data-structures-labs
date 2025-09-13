/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab_project_1_dot_product;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author panka
 */
public class Lab_Project_1_dot_product {

    public static void main(String[] args) {
        Scanner ask=new Scanner(System.in);
        System.out.print("Enter array length: ");
        int n=ask.nextInt();
        int[] a= new int[n];
        int[] b= new int[n];
        Random rand= new Random();
        for (int i=0; i<n; i++) {  
            a[i]= rand.nextInt(100);
            b[i]=rand.nextInt(100);
            
        }
        int[] c= new int[n];
        for (int i=0; i<n; i++) {
            c[i]=a[i]*b[i];
        }
        for (int i:a) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i:b) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i:c) {
            System.out.print(i+" ");
        }
        
    }
}
