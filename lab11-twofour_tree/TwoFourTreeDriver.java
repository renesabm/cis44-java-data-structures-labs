/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_11;

/**
 *
 * @author panka
 */
public class TwoFourTreeDriver {
    public static void main(String[] args) {
        TwoFourTree tree = new TwoFourTree();

        // Test sequence for splits
        int[] keys = {10, 20, 30, 40, 50, 60, 70, 80, 90, 5, 15, 25, 35};

        System.out.println("Inserting keys into 2-4 Tree...");
        for (int key : keys) {
            System.out.println("Inserting: " + key);
            tree.insert(key);
        }

        System.out.println("\nFinal Tree Traversals:");
        tree.inorder();

        // TODO: Students can also implement preorder/postorder traversal for practice

        System.out.println("\nExpected Inorder: 5 10 15 20 25 30 35 40 50 60 70 80 90");
        System.out.println("\nExpected Preorder: 20 40 60 5 10 15 25 30 35 50 70 80 90");
         System.out.println("\nExpected Postorder: 5 10 15 25 30 35 50 70 80 90 20 40 60");
    }
}