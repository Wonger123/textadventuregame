package game;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class TextAdventureGame {

	static Scanner sc = new Scanner(System.in);
	static HashMap<String, Room> roomList = new HashMap<String, Room>();
	static HashMap<String, Items> itemList = new HashMap<String, Items>();
	static String currentRoom;
	static String description;
	static int roomCounter;
	static boolean roomChange = false;
	static ArrayList inventory = new ArrayList();

	public static void main(String[] args) {
		boolean playing = true;
		String command;
		setup();
		while (playing) {
			System.out.print(commandPrompt());
			roomChange = false;
			command = getCommand();
			playing = parseCommand(command);
			playing = death();
		}
	}

	static void setup() {
		// Object, Map and Variable Initialization
		Room.setupRooms(roomList);
		Items.setupItems(itemList, roomList);
		currentRoom = "forest1";

		// Intro
		System.out.println("Hello! Welcome to this text adventure game!");
		System.out.println("Made by Raymond and Andrew");
		System.out.println("Written by ");

		String input = YorN("Would you like to play? (Y/N): ");
		if (input.equals("Y")) {
			System.out.println("Game Commencing...");
			System.out.println(
					"You awake in a forest, the last thing that you remember was flying towards Mars when you crashed into a rock and went off course.\nNow, lying in pieces near you, your ship is unusable. You notice some parts are missing as well. You think you should probably go find them instead of laying here until you die.");
		}
		if (input.equals("N")) {
			System.out.print("Have a good day :)");
			System.exit(0);
		}
	}

	static String getCommand() {
		String text = sc.nextLine();
		return text;
	}

	static String response() { // takes player input, quits game if they input "exit"
		String playerInput = sc.next();
		sc.nextLine();

		if (playerInput.equalsIgnoreCase("exit")) {
			System.out.print("Thanks for playing :)");
			System.exit(0);
		}
		return playerInput;
	}

	static String YorN(String msg) { // handles exceptions for Yes or No questions
		System.out.print(msg);
		String check = sc.next().toUpperCase();
		sc.nextLine();

		// checks if player response is valid
		while (!check.equals("Y") && !check.equals("N")) {
			System.out.print("Please enter a valid response (Y/N): ");
			check = sc.next().toUpperCase();
		}
		return check;
	}

	static boolean parseCommand(String text) {

		/***** PREPROCESSING *****/
		// P1.
		text = text.toLowerCase().trim();

		// P2. word replacement
		text = text.replaceAll("pick up", "pickup");
		text = text.replaceAll("look around", "look");
		text = text.replaceAll("climb up", "up");

		String words[] = text.split(" ");

		// P3. remove all instances of "THE"
		/*
		 * ArrayList wordlist = new ArrayList(Arrays.asList(words)); //array list of
		 * words
		 * for(int i=0; i< wordlist.size(); i++) {
		 * if (wordlist.get(i).equals("the")) wordlist.remove(i--);
		 * }
		 */

		// separate out into word1, word2, etc.
		String word1 = words[0];
		String word2 = null;
		if (words.length > 1) {
			word2 = words[1];
		}

		/***** MAIN PROCESSING *****/
		switch (word1) {

			/**** one word commands ****/
			case "quit": case "exit": case "leave":
				String answer = YorN("Do you really want to quit the game? (Y/N): ");
				if (answer.equals("Y")) {
					System.out.print("Thanks for playing. Bye.");
					System.exit(0);
				}

				if (answer.equals("N")) {
					System.out.println("Let's return to the game!");
					return true;
				}

			case "n": case "e": case "s": case "w": case "u": case "d":
			case "north": case "east": case "south": case "west": case "up": case "down":
				movingRooms(word1.charAt(0));
				break;

			case "look":
				System.out.println(roomList.get(currentRoom).directions);
				System.out.println("There are " + roomList.get(currentRoom).items.size() + " items in the area");
				System.out.println(getItems());
				break;

			/*
			 * case "i": case "inventory":
			 * showInventory();
			 * break;
			 * case "help":
			 * printHelp();
			 * break;
			 * case "pickup":
			 * case "swim":
			 * case "break": case "mine":
			 * case "look":
			 * case "fix":
			 * case "takeoff"
			 */

			/**** two word commands ****/
			case "go": case "move":
				movingRooms(word2.charAt(0));
				break;

			default:
				System.out.println("Sorry, I don't understand that command");
		}
		System.out.println();
		return true;
	}

	static void movingRooms(char direction) {
		if (roomList.get(currentRoom).getExit(direction) == "") {
			System.out.println("You cannot go there!");
		} else {
			currentRoom = roomList.get(currentRoom).getExit(direction);
			roomCounter++;
			roomChange = true;
		}
		System.out.println(roomList.get(currentRoom).displayName + "\n" + roomList.get(currentRoom).description);
	}

	static boolean death() {
		if (roomCounter == 52) {
			System.out.println("You've ran out of food this morning. You collapse to the ground and die");
			return false;
		} else
			return true;
	}

	static String commandPrompt() {
		String prompt;
		if (roomCounter == 0 && roomChange == true) {
			prompt = "Rise and Shine! It's Day " + (roomCounter / 7 + 1)
					+ "!\nWhat would you like to start off with today? ";
		} else if (roomCounter % 7 == 0 && roomChange == true) {
			currentRoom = "forest1";
			prompt = "It's getting dark and cold out, you start to walk back to the Forest where your base camp is.\nRise and Shine! It's Day "
					+ (roomCounter / 7 + 1) + "!\nWhat would you like to start off with today? ";
		} else {
			prompt = "What would you like to do? ";
		}
		return prompt;
	}

	static String getItems()
	{
		if (roomList.get(currentRoom).items.size() == 0)
		{
			description = "";
		}
		else
		{
			for (int i = 0; i < roomList.get(currentRoom).items.size(); i++)
			{
				description += itemList.get(roomList.get(currentRoom).items.get(i)).itemName + "\n" + itemList.get(roomList.get(currentRoom).items.get(i)).itemDescription + "\n";
			}
		}
		return description;
	}
}