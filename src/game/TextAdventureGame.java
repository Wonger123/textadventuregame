package game;

import java.util.Scanner;

public class TextAdventureGame {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean isPlaying = false;
		String playerInput;

		System.out.println("Hello! Welcome to this text adventure game!");
		System.out.println("Made by Raymond \n");

		System.out.print("Would you like to play? (Y/N) ");
		playerInput = sc.next();
		sc.nextLine();

		while (!isPlaying) {
			if (playerInput.equalsIgnoreCase("Y")) {
				System.out.println("Welcome to The Game");
				// the game
			}
			if (playerInput.equalsIgnoreCase("N")) { //fix this tmrw
				System.out.print("Have a good day :)");
				System.exit(0);
			}
			if (!playerInput.equalsIgnoreCase("Y") && !playerInput.equalsIgnoreCase("N")) {
				System.out.print("Please input a valid answer (Y/N): ");
				playerInput = sc.nextLine();
			}

			System.out.println("test");
			playerInput = sc.next();
			sc.nextLine();

			if (playerInput.equalsIgnoreCase("Exit")) {
				System.out.println("Thanks for playing");
				System.out.println("Goodbye");
				break;
			}
		}
	}
}