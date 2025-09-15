/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_3;

/**
 *
 * @author panka
 */
public class Main_Test_Matrix {
    public static void main(String[] args) {
        Matrix matrix= new Matrix(3,4);
        Matrix matrix2=new Matrix(3,4);
        matrix.populateRandom();
        matrix2.populateRandom();
        System.out.println("Matrix 1:\n"+matrix);
        System.out.println("Matrix 2:\n"+matrix2);
        System.out.println("Sum of matrix 1 and matrix 2:");
        try {
            System.out.println(matrix.add(matrix2));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: "+e.getMessage()+"\n" );            
        }
        Matrix matrix3= new Matrix(4,4);
        matrix3.populateRandom();
        System.out.println("Matrix 3:\n"+matrix3);
        System.out.println("Sum of matrix 1 and matrix 3:");
        try {
            System.out.println(matrix.add(matrix3));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: "+e.getMessage()+"\n");           
        }
        System.out.println("Product of matrix 1 and matrix 2:");
        try {
            System.out.println(matrix.multiply(matrix2));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: "+e.getMessage()+"\n");
        }
        System.out.println("Product of matrix 2 and matrix 3:");
        try {
            System.out.println(matrix2.multiply(matrix3));
        } catch(IllegalArgumentException e) {
            System.out.println("Error: "+e.getMessage()+"\n");           
        }
    }
}
