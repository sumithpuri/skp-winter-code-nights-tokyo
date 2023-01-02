/*
[Question/Problem Statement is the Property of Techgig]
 
Java Inheritance / Simple OOPs [www.techgig.com]
Create Two Classes:

BaseClass
The Rectangle class should have two data fields-width and height of int types... The class should have display() method, 
to print the width and height of the rectangle separated by space.

DerivedClass
The RectangleArea class is Derived from Rectangle class, i.e., it is the Sub-Class of Rectangle class.. The class should 
have read_input() method, to Read the Values of width and height of the Rectangle... The RectangleArea class should also 
Overload the display() Method to Print the Area (width*height) of the Rectangle.

Input Format
The First and Only Line of Input contains two space-separated Integers denoting the width and height of the Rectangle.

Constraints
1 <= width,height <= 10^3

Output Format
The Output Should Consist of Exactly Two Lines.
In the First Line, Print the Width and Height of the Rectangle Separated by Space.
In the Second Line, Print the Area of the Rectangle.


[Explanation of the Solution]
This is the Simplest of all OOPs Questions! Demonstration of Inheritance and Overriding (~Liskov Substitution of SOLID).
*/

/*    
 * Techgig Core Java Basics Problem - Get Simple OOPs Right!  
 * Author: Sumith Puri [I Bleed Java!]; GitHub: @sumithpuri;  
*/

import java.util.Scanner;

class Rectangle {

	private int width;
	private int height;

	public void display() {

		System.out.println(width + " " + height);
	}

	public int getWidth() {

		return width;
	}

	public void setWidth(int width) {

		this.width = width;
	}

	public int getHeight() {

		return height;
	}

	public void setHeight(int height) {

		this.height = height;
	}
}

class RectangleArea extends Rectangle {

	public void read_input() {

		Scanner scanner = new Scanner(System.in);

		setWidth(scanner.nextInt());
		setHeight(scanner.nextInt());
	}

	public void display() {

		super.display();
		System.out.println(getWidth() * getHeight());
	}
}

public class OOPs {

	public static void main(String args[]) throws Exception {

		RectangleArea rectangleArea = new RectangleArea();
		rectangleArea.read_input();

		rectangleArea.display();
	}
}