package com.mycompany.lab_project_2;


import static java.lang.Math.tan;
import java.util.Scanner;

// Step 1: Define the interface
interface Polygon {
    double area();
    double perimeter();
}

// Step 2: Implement a base class for a specific shape
class Quadrilateral implements Polygon {
    // What attributes do all quadrilaterals have?
    // ...
    protected double side1, side2, side3, side4;

    public Quadrilateral(double side1, double side2, double side3, double side4) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.side4 = side4;
    }
    
    @Override
    public double area() {
        // To be implemented by subclasses
        return 0;
    }

    @Override
    public double perimeter() {
        // To be implemented by subclasses
        return 0;
    }
}

class Triangle implements Polygon {
    protected double base, height, side;
    public Triangle(double base, double height, double side) {
        this.base=base;
        this.height=height;
        this.side=side;
    }

    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimeter() {
        return 0;
    }
    
}
class Pentagon implements Polygon {
    protected double side;
    public Pentagon(double side) {
        this.side=side;
    }

    @Override
    public double area() {
        
        return Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * Math.pow(side, 2)/ 4;
    }

    @Override
    public double perimeter() {
        return 5*side;
    }
    
}

class Hexagon implements Polygon {
    protected double side;
    public Hexagon(double side) {
        this.side=side;
    }

    @Override
    public double area() {
        return (3 * Math.sqrt(3) * side * side) / 2;
    }

    @Override
    public double perimeter() {
        return 6*side;
    }
    
}

class Octagon implements Polygon {
    protected double side;
    public Octagon(double side) {
        this.side=side;
    }

    @Override
    public double area() {
        return 2 * side * side * (1 + Math.sqrt(2));
    }

    @Override
    public double perimeter() {
        return 8*side;
    }
    
}
class IsocelesTriangle extends Triangle {
    
    
    public IsocelesTriangle(double base, double height, double side) {
        super(base, height, side);
    }
    @Override
    public double area() {
        return 0.5*height*base;       
    }
    @Override
    public double perimeter() {
        return side+side+base;        
    }    
}
class EquilateralTriangle extends Triangle {
    
    
    public EquilateralTriangle (double base, double height, double side ) {
        super(base, height, side);
    }
    @Override
    public double area() {
        return 0.5*height*side;
    }
    @Override
    public double perimeter() {
        return side+side+side;
    }
}

// Step 3: Create a subclass using inheritance
class Rectangle extends Quadrilateral
{

    public Rectangle(double length, double width) {
        super(length, width, length, width);
    }

    //@Override
    public double area() {
        return side1*side2;
    }
    //@Override
    public double perimeter() {
        return 2*(side1+side2);
    
    }

    // You implement the perimeter method...done
}

// Step 4: Create a more specific subclass
class Square extends Rectangle {
    public Square(double side) {
        // How do you call the Rectangle constructor from here?
        super(side,side);
    }
    
}

// Main class for user interface
public class PolygonCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //while (true) {
        System.out.println("Create a polygon(Quadrilateral, Triangle, Hexagon, Pentagon, Octagon):");
        String shape= scanner.nextLine();
        
        if (shape.equalsIgnoreCase("Quadrilateral")) {
            System.out.println("Enter Quadrilateral:");
            String type= scanner.nextLine();
            if (type.equalsIgnoreCase("Square")) {
                System.out.println("Enter side length:");
                double dimensions=scanner.nextDouble();
                Square square= new Square(dimensions);
                System.out.printf("The area is %.2f",square.area());
                System.out.printf("\nThe perimeter is %.2f",square.perimeter());
                
                
            }
            if (type.equalsIgnoreCase("Rectangle")) {
                System.out.println("Enter length:");
                double length=scanner.nextDouble();
                System.out.println("Enter width");
                double width=scanner.nextDouble();
                Rectangle rectangle= new Rectangle(length,width);
                System.out.printf("The area is %.2f",rectangle.area());
                System.out.printf("\nThe perimeter is %.2f",rectangle.perimeter());
                
                
            }
        }
        else if (shape.equalsIgnoreCase("Triangle")) {
            System.out.println("Enter Triangle:");
            String type= scanner.nextLine();
            if (type.equalsIgnoreCase("Isosceles Triangle")) {
                System.out.println("Enter base length:");
                double base= scanner.nextDouble();
                System.out.println("Enter height:");
                double height=scanner.nextDouble();
                System.out.println("Enter side length:");
               
                double side=scanner.nextDouble();
                IsocelesTriangle isoctriangle= new IsocelesTriangle(base, height, side);
                System.out.printf("The area is %.2f",isoctriangle.area());
                System.out.printf("\nThe perimeter is %.2f",isoctriangle.perimeter());
                
                
            }
            if (type.equalsIgnoreCase("Equilateral Triangle")) {
                System.out.println("Enter base length:");
                double base= scanner.nextDouble();
                System.out.println("Enter height:");
                double height=scanner.nextDouble();
                System.out.println("Enter side length:");
               
                double side=scanner.nextDouble();
                EquilateralTriangle equitriangle= new EquilateralTriangle(base, height, side);
                System.out.printf("The area is %.2f",equitriangle.area());
                System.out.printf("\nThe perimeter is %.2f",equitriangle.perimeter());
                
                
            }
        }
        else if (shape.equalsIgnoreCase("Pentagon")) {
            System.out.println("Enter side length");
            double side=scanner.nextDouble();
            Pentagon pentagon= new Pentagon(side);
            System.out.printf("The area is %.2f",pentagon.area());
            System.out.printf("\nThe perimeter is %.2f",pentagon.perimeter());
        }
        else if (shape.equalsIgnoreCase("Hexagon")) {
            System.out.println("Enter side length");
            double side=scanner.nextDouble();
            Hexagon hexagon= new Hexagon(side);
            System.out.printf("The area is %.2f",hexagon.area());
            System.out.printf("\nThe perimeter is %.2f",hexagon.perimeter());
        }
        else if (shape.equalsIgnoreCase("Octagon")) {
            System.out.println("Enter side length");
            double side=scanner.nextDouble();
            Octagon octagon= new Octagon(side);
            System.out.printf("The area is %.2f",octagon.area());
            System.out.printf("\nThe perimeter is %.2f",octagon.perimeter());
        }
        
        }
    }


              