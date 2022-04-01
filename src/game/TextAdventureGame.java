package game;

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
//import java.util.Arrays;

public class TextAdventureGame {

	static Scanner sc = new Scanner(System.in);
	static HashMap<String, Room> roomList = new HashMap<String, Room>();
	static HashMap<String, Items> itemList = new HashMap<String, Items>();
	static String currentRoom;
	static String description = "";
	static int roomCounter;
	static boolean roomChange = false;
	static ArrayList <Items> inventory = new ArrayList <Items>();

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
		System.out.println("Written by Ethan");

		String input = YorN("Would you like to play? (Y/N): ");
		if (input.equals("Y")) {
			System.out.println("\nGame Commencing...\n");
			System.out.println(
					"You awake in a forest, the last thing that you remember was flying towards Mars when you crashed into a rock and went off course.\nNow, lying in pieces near you, your ship is unusable. You notice some parts are missing as well.\nYou think you should probably go find them instead of laying here until you die.");
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
			sc.nextLine();
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
		text = text.replaceAll("go ", "");
		text = text.replaceAll("move ", "");
		text = text.replaceAll("miner helment", "helmet");
		text = text.replaceAll("scuba gear", "scuba");
		text = text.replaceAll("left wing", "leftwing");
		text = text.replaceAll("rocket ", "");
		text = text.replaceAll("right wing", "rightwing");

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
				System.out.println("There are " + roomList.get(currentRoom).items.size() + " items in the area:");
				getItems();
				break;

			case "jump":
				if (currentRoom.equals("peak")) System.out.println("Suicide is a real issue, please call: 1-833-456-4566. You still need to make it home first.");
				else System.out.println("Have fun!");
				break;

			
			case "i": case "inventory":
				getInventory();
				break;
			/*
			case "help":
				printHelp();
				break;
			case "break": case "mine":
			case "look":
			case "fix":
			case "takeoff"
			 */

			/**** two word commands ****/
			case "follow":
				if (word2 != null)
				{
					following(word2);
				}
				else System.out.println("What do you want me to follow?");
				break;

			case "swim":
				if (word2 != null)
				{
					swimming(word2);
				}
				else System.out.println("Where do you want to swim?");
				break;

			case "pickup":
				pickupItem(word2);
				break;

			default:
				System.out.println("Sorry, you can't do that.");
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
			System.out.println("You've ran out of food this morning. You collapse to the ground and die.");
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

	static void getItems()
	{
		if (roomList.get(currentRoom).items.size() == 0)
		{
			return;
		}
		else
		{
			for (int i = 0; i < roomList.get(currentRoom).items.size(); i++)
			{
				System.out.println(itemList.get(roomList.get(currentRoom).items.get(i)).itemName);
				System.out.println(itemList.get(roomList.get(currentRoom).items.get(i)).itemDescription);
			}
		}
	}

	static void swimming(String word)
	{
		if (currentRoom.equals("clearing"))
		{
			if (word.charAt(0) =='d')
			{
				movingRooms('d');
			}
			else System.out.println("You can't swim in that direction!");
		}
		else if (currentRoom.equals("lake")) movingRooms(word.charAt(0));
		else if (currentRoom.equals("cave1")) movingRooms(word.charAt(0));
		else System.out.println("There's nowhere to swim here!");
	}

	static void following(String word)
	{
		if (word.equals("river"))
		{
			if (currentRoom.equals("forest2")) movingRooms('w');
			else if (currentRoom.equals("beach")) movingRooms('e');
			else System.out.println("There's no river here");
		}
		else System.out.println("You can't follow that.");
	}

	static void pickupItem(String item)
	{
		if (roomList.get(currentRoom).items.size() > 0)
		{
			for (int i = 0; i < roomList.get(currentRoom).items.size(); i++)
			{
				if (itemList.get(roomList.get(currentRoom).items.get(i)).itemName.equals(item))
				{
					inventory.add(itemList.get(item));
					System.out.println("Item added to inventory!");
					roomList.get(currentRoom).items.remove(item);
					break;
				}
				else
				{
					System.out.println("Item is not in this room");
				}
			}
		}
		else
		{
			System.out.println("Nothing to pickup here");
		}
	}

	static void getInventory()
	{
		String list = "Inventory: ";
		if (inventory.size() == 0) System.out.println("Nothing in inventory");
		else if (inventory.size() == 1) System.out.println("Inventory: " + inventory.get(0).itemDisplayName);
		else
		{
			for (int i = 0; i < inventory.size(); i++)
			{
				list += "|" + inventory.get(i).itemDisplayName + "| ";
			}
			System.out.println(list);
		}
	}
}