/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_3;

/**
 *
 * @author panka
 */
public class Main_Test_Dynamic_Array {
    public static void main(String[] args) {
        Dynamic_Array<String> arr = new Dynamic_Array<>();
        arr.add("red");
        arr.add("blue");
        arr.add("yellow");
        arr.add("turquoise");
        arr.add("pink");
        arr.add("orange");
        arr.add("purple");
        arr.add("indigo");
        System.out.print("Original array: ");
        for (int i=0;i<arr.size();i++) {
            System.out.print(arr.get(i)+" ");
             
        }
        System.out.println("\nAdding green, brown, black");
        arr.add("green");
        arr.add("brown");
        arr.add("black");
        System.out.print("Printing modfied array: ");
        for (int i=0;i<arr.size();i++) {
            System.out.print(arr.get(i)+" ");  
        }
        System.out.print("\nPrinting array size: ");
        System.out.println(arr.size());
        
        System.out.println("Getting element at index 5:");
        try {
        System.out.println(arr.get(5));
        } catch (IndexOutOfBoundsException e) {
        System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Getting element at index 50:");
        try {
        System.out.println(arr.get(50));
        } catch (IndexOutOfBoundsException e) {
        System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Removing element at 0");
        try {
        System.out.println("Removing " + arr.remove(0));
        } catch (IndexOutOfBoundsException e) {
        System.out.println("Error: " + e.getMessage());
        }
        System.out.print("Printing modified array: ");
        for (int i=0;i<arr.size();i++) {
            System.out.print(arr.get(i)+" ");
             
        }
        System.out.println("\nRemoving element at -5");
        try {
        System.out.println("Removing" + arr.remove(-5));
        } catch (IndexOutOfBoundsException e) {
        System.out.println("Error: " + e.getMessage());
        }
        
        System.out.print("Printing final array: ");
        for (int i=0;i<arr.size();i++) {
            System.out.print(arr.get(i)+" ");
             
        }
        
        
        
         
    }
}
