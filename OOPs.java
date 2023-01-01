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