/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab_project_5;

/**
 *
 * @author panka
 */
import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.List; 
public class IteratorInventory {
    public class Item { 
        String name; 
        // Constructor, getter, toString...
        public Item(String name) {
            this.name=name;
        }
        public String getName() {
            return name;
        }
        @Override
        public String toString() {
            return name;
            
        }
    } 
    public class Inventory { 
        private List<Item> items; 
        public Inventory() { 
            this.items = new ArrayList<>(); 
        } 
        public void addItem(Item item) {items.add(item); } 

        public void display() { System.out.println("Inventory: "+items); } 

        public void combineItems(String name1, String name2) { 
            boolean found1 = false; 
            boolean found2 = false; 

            Iterator<Item> iter = items.iterator(); 
            while (iter.hasNext()) { 
                Item current = iter.next(); 
                if (current.getName().equals(name1) && !found1) { 
                    // How do you track which item you found? 
                    // How do you remove it safely? 
                    found1=true;
                    iter.remove(); 
                } else if (current.getName().equals(name2) && !found2) {
                    found2=true;
                    iter.remove();
                    
                }
            } 

            // After the loop, check if both were found. 
            // If so, add the new combined item. 
            // What happens if you add the new item inside the loop?
            if (found1 && found2) {
                Item combinedItem = new Item("Magic Staff");
                items.add(combinedItem);
                System.out.println("Combined \"" + name1 + "\" and \"" + name2 + "\" into \"Magic Staff\"");
            }
            else {
                System.out.println("Items not found");
            }
        }
        
    }
    public static void main(String[] args) {
        IteratorInventory outer = new IteratorInventory();
        Inventory inventory = outer.new Inventory();
        Item item1 = outer.new Item("Rock");
        inventory.addItem(item1);
        Item item2 = outer.new Item("Crystal");
        inventory.addItem(item2);
        Item item3 = outer.new Item("Jade");
        inventory.addItem(item3);
        Item item4 = outer.new Item("Shell");
        inventory.addItem(item4);
        
        inventory.display();
        
        inventory.combineItems("Rock", "Jade");
        inventory.display();
        }
}