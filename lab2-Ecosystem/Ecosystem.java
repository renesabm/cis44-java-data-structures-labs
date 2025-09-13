package com.mycompany.lab_project_2;

import java.util.Random;

// Step 1: Create the abstract parent class
abstract class Animal {
    // You can add shared attributes or methods here if needed
    // An abstract method for toString() can be helpful for visualization
    public abstract String toString();
}

// Step 2: Create the concrete animal classes
class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

// Main class to run the simulation
public class Ecosystem {
    private Animal[] river;
    private Random random;
    

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        for (int i=0; i<4; i++) {
            int index= random.nextInt(river.length);
            if (river[index]==null) {
                river[index]= new Bear();
                
            }
            
            
        }
        for (int i=0; i<4; i++) {
            int index= random.nextInt(river.length);
            if (river[index]==null) {
                river[index]= new Fish();
                
            }
            
            
        }
        
        // You can add logic here to initially populate the river
    }

    public void runStep() {
        // This is the core logic for a single time step.
        // 1. Create a new array for the next state.
        // 2. Iterate through the current river array.
        // 3. For each animal, decide its next move.
        // 4. Handle collisions and place animals in the new array.
        // 5. Replace the old river with the new one.
        Animal[] newRiver= new Animal[river.length];
        for (int i=0; i<river.length;i++) {
            if (river[i]==null) {
                continue;
            }
            Animal current=river[i];
            int move = random.nextInt(3);
            int target=i;
            if (move==0 && i>0) {
                target=i-1;
            }
            else if (move==2 && i<river.length -1) {
                target=i+1;
            }
            if (newRiver[target]==null) {
                newRiver[target]=current;
                
            }
            else {
                Animal other=newRiver[target];
                if (current.getClass()==other.getClass()) {
                    newRiver[target]=current;
                    for (Animal river1 : river) {
                        int randIndex=random.nextInt(river.length);
                        if (current instanceof Bear) {
                            newRiver[randIndex] = new Bear();
                        }
                        else {
                            newRiver[randIndex] = new Fish();
                        }
                        break;
                    }
                }
                else if (current instanceof Bear && other instanceof Fish) {
                    newRiver[target]=current;
                }
            }
            river[i]=null;
            
            
        }
        river=newRiver;
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20); // Create a river of size 20
        eco.visualize();
        for (int i=1; i<=10; i++) {
            eco.runStep();
            eco.visualize();
                 
        }
    }
}
              