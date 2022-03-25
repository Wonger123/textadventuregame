package game;

import java.util.Scanner;

public class TextAdventureGame {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		String input;

		System.out.println("Hello! Welcome to this text adventure game!");
		// game description
		System.out.println("Made by Raymond and Andrew");
		System.out.println("Written by ");

		// ask if player wants to play
		System.out.print("Would you like to play? (Y/N): ");
		input = YorN("Would you like to play? (Y/N): ");
		
		if (input.equals("Y")) {
			System.out.println("Welcome to The Game");
		}
		if (input.equals("N")) {
			System.out.print("Have a good day :)");
			System.exit(0);
		}
		
		// the rest of the game goes here
	}

	static public String response(String playerInput) {
		playerInput = sc.next();
		sc.nextLine();
		
		if (playerInput.equalsIgnoreCase("exit")) {
			System.out.print("Thanks for playing :)");
			System.exit(0);
		}
		return playerInput;
	}
	
	static public String YorN(String check) {
		check = sc.next().toUpperCase();
		sc.nextLine();

		// checks if player response is valid
		while (!check.equals("Y") && !check.equals("N")) {
			System.out.print("Please enter a valid response (Y/N): ");
			check = sc.next().toUpperCase();
		}
		return check;
	}
}