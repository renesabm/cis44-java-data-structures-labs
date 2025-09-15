/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_3;
import java.util.Random;
/**
 *
 * @author panka
 */
public class Matrix {
    private int[][] data;
    public Matrix(int rows, int cols) {
        this.data=new int[rows][cols];
    }
    @Override
    public String toString() {
        String result="";
        for (int i=0; i<data.length; i++) {
            for (int j=0;j<data[i].length;j++) {
                result+=data[i][j] +"\t";
            }
            result+="\n";
        }
        return result;
    }
    public void populateRandom() {
        Random random= new Random();
        for (int i=0; i<data.length; i++) {
            for (int j=0;j<data[i].length;j++) {
                this.data[i][j] = random.nextInt(10) + 1;
            }
        }
    }
    public Matrix add(Matrix other) {
        if ((this.data.length!=other.data.length)||(this.data[0].length!=other.data[0].length)) {
            throw new IllegalArgumentException("Matrix size doesn't match");   
        }
        int rows = this.data.length;
        int cols = this.data[0].length;
        Matrix sum = new Matrix(rows, cols);
        for (int i=0; i<data.length; i++) {
            for (int j=0;j<data[i].length;j++) {
                sum.data[i][j]=this.data[i][j]+other.data[i][j];
            }
        }
        return sum;
    }
    public Matrix multiply(Matrix other) {
        if ((this.data.length!=other.data.length)||(this.data[0].length!=other.data[0].length)) {
            throw new IllegalArgumentException("Matrix size doesn't match");   
        }
        int rows = this.data.length;
        int cols = this.data[0].length;
        Matrix product = new Matrix(rows, cols);
        for (int i=0; i<data.length; i++) {
            for (int j=0;j<data[i].length;j++) {
                product.data[i][j]=this.data[i][j]*other.data[i][j];
            }
        }
        return product;
    }
}
