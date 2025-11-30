/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_14;

/**
 *
 * @author panka
 */
public class Maps_Hash_Tables_Driver {
    public static void main(String[] args) {
    
    Maps_Hash_Tables<Integer, String> map = new Maps_Hash_Tables<>();
    System.out.println("put(5, A): " + map.put(5, "A"));
    System.out.println("put(7, B): " + map.put(7, "B"));
    System.out.println("put(2, C): " + map.put(2, "C")); 
    System.out.println("put(2, E): " + map.put(2, "E"));

    System.out.println("get(7): " + map.get(7));  
    System.out.println("remove(5): " + map.remove(5)); 
    
    }
    
}
