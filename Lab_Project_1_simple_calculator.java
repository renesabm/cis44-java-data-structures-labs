/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab_project_1_dot_product;
import static java.lang.Double.parseDouble;
import java.util.Scanner;

/**
 *
 * @author panka
 */
public class Lab_Project_1_simple_calculator {
    private static boolean containsLetter(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
 
        Scanner scanner= new Scanner(System.in);
        while (true) {
            System.out.print("Enter first number or exit: ");
           
            String input=scanner.nextLine();
            
            if (input.equals("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }
            if (containsLetter(input)) {
                System.out.println("Invalid input.");
                break;
                
            }
            

            System.out.print("Enter operator: ");
            String operator= scanner.nextLine();
            if (!(operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/"))) {
                System.out.println("Invalid operator");
                break;
            }

            System.out.print("Enter second number: ");
            String input2=scanner.nextLine();
            if (containsLetter(input2)) {
                System.out.println("Invalid input.");
                break;
                
            }

            Double num1=parseDouble(input);
            Double num2=parseDouble(input2);

            Double result=0.0;

            switch(operator) {
                case("+"):
                    result= num1+num2;
                    break;
                case("-"):
                    result=num1-num2;
                    break;
                case("*"):
                    result=num1*num2;
                    break;
                case("/"):
                    result=num1/num2; 
                    break;
                default:
                    
                    break;
              
            }

            System.out.print("The answer is "+result);
            System.out.println();
            
        }

    }

}
