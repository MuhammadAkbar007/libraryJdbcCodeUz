package uz.akbar;

import java.util.Scanner;

/**
 * StaffController
 */
public class StaffController {

	private final Scanner sc = new Scanner(System.in);

	public void start() {
		boolean loop = true;
		while (loop) {

			showMenu();
			int action = getAction();
			System.out.println();

			switch (action) {
				case 1:
					break;
				case 2:
					break;
				case 0:
					loop = false;
					break;

				default:
					System.out.println("Wrong input!");
					break;
			}
		}
	}

	public void showMenu() {
		System.out.println("*** Admin Menu ***");
		System.out.println("1. Book");
		System.out.println("2. Student");
		System.out.println("0. Exit");
	}

	public int getAction() {
		System.out.print("Enter action => ");
		return sc.nextInt();
	}

}
