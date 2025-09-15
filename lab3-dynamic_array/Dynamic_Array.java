/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab_project_3;

/**
 *
 * @author panka
 */
public class Dynamic_Array<T> {
    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY=10;
    public Dynamic_Array() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        size=0;
    }
    public void add(T element) {
        if (size==data.length) {
            resize();
        }
        data[size]=element;
        size++;
        
    }
    public T get(int index) {
        if (index<0||index>=size) {
            throw new IndexOutOfBoundsException(index+" is not a valid index");    
        }
        else {
            return data[index];
        }
    }
    public T remove(int index) {
        if (index<0||index>=size) {
            throw new IndexOutOfBoundsException(index+" is not a valid index");    
        }
        else {
            T removed=data[index];
            for (int i=index;i<size-1;i++) {
                data[i]=data[i+1];
            }
            data[size-1]=null;
            size--;
            return removed;
        }
    }

    
    public int size() {
        return size;
    }
    private void resize() {
        int newSize= data.length*2;
        T[] newData= (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
        
    }
}
