package game;

import java.util.Scanner;

public class TextAdventureGame {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String playerInput;

		System.out.println("Hello! Welcome to this text adventure game!");
		// game description
		System.out.println("Made by Raymond and Andrew");
		System.out.println("Written by ");

		// ask if player wants to play
		System.out.print("Would you like to play? (Y/N): ");
		playerInput = YorN("Would you like to play? (Y/N): ");
		
		if (playerInput.equals("Y")) {
			System.out.println("Welcome to The Game");
		}
		if (playerInput.equals("N")) {
			System.out.print("Have a good day :)");
			System.exit(0);
		}
		
		// the rest of the game goes here
	}

	public void quit(String playerInput) {
		// type "exit" at any point to quit the game
	}
	
	static public String YorN(String playerInput) {
		playerInput = sc.next().toUpperCase();
		sc.nextLine();

		// checks if player response is valid
		while (!playerInput.equals("Y") && !playerInput.equals("N")) {
			System.out.print("Please enter a valid response (Y/N): ");
			playerInput = sc.next().toUpperCase();
		}
		return playerInput;
	}
}