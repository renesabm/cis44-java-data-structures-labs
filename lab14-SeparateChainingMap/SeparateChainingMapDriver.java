/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_14;

/**
 *
 * @author panka
 */
public class SeparateChainingMapDriver {
    public static void main(String[] args) {
    
    SeparateChainingMap<Integer,String> map = new SeparateChainingMap<>();
    System.out.println("put(1, A): " + map.put(1, "A"));
    System.out.println("put(12, B): " + map.put(12, "B"));
    System.out.println("put(23, C): " + map.put(23, "C")); 
    System.out.println("put(34, D): " + map.put(34, "D"));
    System.out.println("put(34, E): " + map.put(34, "E"));
    

    System.out.println("get(1): " + map.get(1)); 
    System.out.println("get(12): " + map.get(12)); 
    System.out.println("get(23): " + map.get(23)); 
    System.out.println("get(34): " + map.get(34)); 
    }
}
