package com.mycompany.lab_project_11;


import com.mycompany.lab_project_11.AVLTree;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author panka
 */
public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // TODO: Insert test values
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        // TODO: Add more insertions to test all 4 rotation cases
        tree.insert(5);
        tree.insert(4); 
        tree.insert(8);
        tree.insert(25);
        // TODO: Print traversals
        System.out.print("Inorder: "); // Expected: 4 5 8 10 20 25 30 
        tree.inorder();

        System.out.print("Preorder: "); // Expected: 20 5 4 10 8 30 25
        tree.preorder();

        System.out.print("Postorder: "); // Expected: 4 8 10 5 25 30 20
        tree.postorder();

        // TODO: Add expected results as comments for verification
    }
}