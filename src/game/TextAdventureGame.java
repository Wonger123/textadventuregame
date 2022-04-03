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
	static boolean roomChange = true;
	static boolean fixedShip = false;
	static boolean helmetOn = false;
	static ArrayList <String> inventory = new ArrayList <String>();

	public static void main(String[] args) {
		boolean playing = true;
		String command;
		setup();
		while (playing) {
			commandPrompt();
			roomChange = false;
			command = getCommand();
			playing = parseCommand(command);
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
			System.out.println("Game Commencing...");

			System.out.println();
			System.out.println("You awake in a forest, the last thing that you remember was flying towards Mars when you crashed into a rock and went off course.\nNow, lying in pieces near you, your ship is unusable. You notice some parts are missing as well. You think you should probably go find them instead of laying here until you die.");
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
		text = text.replaceAll("statistics", "stats");
		text = text.replaceAll("take off", "takeoff");

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
				look();
				break;

			case "jump":
				if (currentRoom.equals("peak")) System.out.println("Suicide is a real issue, please call: 1-833-456-4566. You still need to make it home first");
				else System.out.println("Have fun!");
				break;

			case "inventory":
				getInventory();
				break;

			case "fix":
				partCheck();
				fixedShip = true;
				break;

			case "launch":
				if (fixedShip && currentRoom.equals("forest1")) ending();
				else if(currentRoom != "forest1") System.out.println("You need to be in the Forest Basecamp to take off!");
				else System.out.println("Your ship is still broken, you need to fix it!");
				break;

			case "stats":
				stats();
				break;

			case "dig":
				dig();
				break;

			case "help":
				help();
				break;

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

			case "use":
				useItem(word2);
				break;

			case "takeoff": case "remove":
				if (word2.equals("scuba")) roomList.get("lake").isBreatheable = false;
				break;

			default:
				System.out.println("Sorry, you can't do that.");
		}
		System.out.println();
		return true;
	}

	static void commandPrompt() {
		if (roomCounter % 8 == 0 && roomChange == true) {
			System.out.println("Rise and Shine! It's Day " + (roomCounter / 8 + 1) + "!");
			if (roomCounter == 0) System.out.println(roomList.get(currentRoom).displayName + "\n" + roomList.get(currentRoom).description);
			System.out.println("-------------------------------------------");
			System.out.print("Areas Travelled Today: [0/7] - What would you like to start off with today? ");
		}
		else {
			System.out.println("-------------------------------------------");
			System.out.print("Areas Travelled Today: [" + roomCounter % 8 + "/7] - What would you like to do? ");
		}
	}

	static void movingRooms(char direction) {
		if (roomList.get(currentRoom).getExit(direction) == "") {
			System.out.println("You cannot go there!");
		}
		else if(!roomList.get(roomList.get(currentRoom).getExit(direction)).isAccessible)
		{
			System.out.println("You can't access here, yet... Try breaking the wall down with your pickaxe.");
		}
		else if(!roomList.get(roomList.get(currentRoom).getExit(direction)).isBreatheable)
		{
			System.out.println("BAD IDEA! You run out of oxygen and die...");
			System.exit(0);
		}
		else
		{
			roomCounter++;
			if (roomCounter == 61)
			{
				System.out.println("You've ran out of food this morning. You collapse to the ground and die.");
				System.exit(0);
			}
			if (roomCounter != 0 && roomCounter % 8 == 0)
			{
				System.out.println("It's getting dark and cold out, you can't travel to another room. You walk back to your Forest Base Camp.");
				currentRoom = "forest1";
			}
			else
			{
				currentRoom = roomList.get(currentRoom).getExit(direction);
				System.out.println(roomList.get(currentRoom).displayName + "\n" + roomList.get(currentRoom).description);
			}
			roomChange = true;
		}
	}



	static void pickupItem(String item) //Remind user if they've picked something up
	{
		if (roomList.get(currentRoom).items.size() > 0)
		{
			for (int i = 0; i < roomList.get(currentRoom).items.size(); i++)
			{
				if (itemList.get(roomList.get(currentRoom).items.get(i)).itemName.equals(item))
				{
					if (item.equals("leftwing"))
					{
						System.out.println("Yeah, that's in the sand, you're gonna need to dig it up with a shovel");
						break;
					}
					else
					{
						inventory.add(item);
						System.out.println("Item added to inventory!");
						roomList.get(currentRoom).items.remove(item);
						break;
					}
				}
			}
			System.out.println("Item is not in this room");
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
		else if (inventory.size() == 1) System.out.println("Inventory: " + itemList.get(inventory.get(0)).itemDisplayName);
		else
		{
			for (int i = 0; i < inventory.size(); i++)
			{
				list += "|" + itemList.get(inventory.get(i)).itemDisplayName + "| ";
			}
			System.out.println(list);
		}
	}

	static void partCheck()
	{
		if (inventory.contains("leftwing") && inventory.contains("nose") && inventory.contains("engine") && inventory.contains("rightwing"))
		{
			if (currentRoom == "forest1") System.out.println("You have enough parts to fix the ship and the ship is fixed!");
			else System.out.println("You need to be at your Forest Basecamp to fix your ship!");
		}
		else System.out.println("You don't have enough parts");
	}

	static void ending()
	{
		System.out.println("Congrats, you made it out alive, only to realize that you were dreaming.");
		System.exit(0);
	}

	static void stats()
	{
		System.out.println("You have " + (61-roomCounter) + " moves left");
	}

	static void useItem(String word)
	{
		if (itemList.get(word).isActivatable)
		{
			if (inventory.contains(word))
			{
				if (word.equals("pickaxe"))
				{
					if (currentRoom.equals("lmine"))
					{
						roomList.get("goldmine").isAccessible = true;
						System.out.println("Wall is now broken.");
					}
					else System.out.println("There's nothing to mine through here.");
				}

				if (word.equals("scuba")) //Problem with using multiple times (using it when it's on)
				{
					roomList.get("lake").isBreatheable = true;
					if (currentRoom.equals("lake"))
					{
						System.out.println("Scuba Gear is now on, feel free to go into the cave on your east!");
					}
					else System.out.println("Scuba Gear is now on, but why now?");
				}

				if (word.equals("shovel"))
				{
					if (currentRoom.equals("desert"))
					{
						System.out.println("You dug out the left wing! It has been added to your inventory");
						inventory.add("leftwing");
						roomList.get(currentRoom).items.remove("leftwing");
					}
					else System.out.println("There's nothing to dig up here");
				}

				if (word.equals("helmet")) //Problem with using multiple times (using it when it's on)
				{
					System.out.println("Helmet light is turned on!");
					helmetOn = true;
				}
			}
			else System.out.println("Item is not in your inventory");
		}
		else System.out.println("Item can not be used.");
	}

	static boolean itemCheck() //check if item exists
	{
		return true;
	}

	static void dig()
	{
		if (currentRoom.equals("desert"))
		{
			System.out.println("You dug out the left wing! It has been added to your inventory");
			inventory.add("leftwing");
			roomList.get(currentRoom).items.remove("leftwing");
		}
		else System.out.println("There's nothing to dig up here");
	}

	static void look()
	{
		if (!roomList.get(currentRoom).isDark || helmetOn)
		{
			System.out.println(roomList.get(currentRoom).directions);
			System.out.println("There are " + roomList.get(currentRoom).items.size() + " items in the area");
			if (roomList.get(currentRoom).items.size() != 0)
			{
				for (int i = 0; i < roomList.get(currentRoom).items.size(); i++)
				{
					System.out.println(itemList.get(roomList.get(currentRoom).items.get(i)).itemDisplayName);
					System.out.println(itemList.get(roomList.get(currentRoom).items.get(i)).itemDescription);
				}
			}
		}
		else System.out.println("You can't see in here. You're gonna need some kind of light source.");
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

	static void help()
	{}
}