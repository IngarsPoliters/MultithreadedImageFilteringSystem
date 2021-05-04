package ie.gmit.sw;

import java.util.Scanner;

/**
 * @author Ingars Politers
 * @version 1.0
 * @since 1.8
 *
 * The class Client has a dependence on class Runner.
 * On its request Client getMenu() method will print 
 * the menu output to the screen. Once the menu is displayed
 * user will be asked to enter a number input.
 *
 */
public class Client {
	private int option;
	private Scanner input = new Scanner(System.in);
	
	/**
	 * This method is used to display the menu where the user 
	 * can choose between 4 options and following the requested
	 * option will perform its task
	 */
	public void getMenu() {
		System.out.println("***** Image Filtering System *****\n" + "1) Enter Image Directory\n"
				+ "2) Select Single Image[NOT WORKING]\n" + "3) Add a Custom Filter[NOT WORKING]\n" + "4) Quit\n" + "Select Option [1-4]");
		setOption();
	}

	/**
	 * This method is used for getting the user input
	 * and storing it to option variable
	 */
	public void setOption() {
		option = Integer.parseInt(input.nextLine());
	}

	/**
	 * Simple method to return the option which was received
	 * from the user
	 * @return option to perform menu task
	 */
	public int getOption() {
		return this.option;
	}
}
