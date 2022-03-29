package game;

import java.util.*;

public class TextAdventureGame {

	static Scanner sc = new Scanner(System.in);
    static HashMap<String, Room> roomList = new HashMap<String, Room>();
    static String currentRoom;

	public static void main(String[] args)
    {
        boolean playing = true;
        String command;
        setup();
        while (playing)
        {
            System.out.print("What would you like to do? ");
            command = getCommand();
            playing = parseCommand(command);
        }
	}

    static void setup()
    {
        //Object, Map and Variable Initialization
        Room.setupRooms(roomList);
        currentRoom = "forest1";

        //Intro
		System.out.println("Hello! Welcome to this text adventure game!");
		System.out.println("Made by Raymond and Andrew");
		System.out.println("Written by ");

		String input = YorN("Would you like to play? (Y/N): ");
		if (input.equals("Y")) {
			System.out.println("Game Commencing...");
            System.out.println ("You awake in a forest, the last thing that you remember was flying towards mars when you crashed into a rock and went off course. Now, lying in pieces near you, your ship is unusable. You notice some parts are missing as well. You think you should probably go find them instead of laying here until you die.");
		}
		if (input.equals("N")) {
			System.out.print("Have a good day :)");
			System.exit(0);
		}
	}

    static String getCommand()
    {	
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
	
	static String YorN(String msg) { // checks for invalid answer when starting the game
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
		//P1. 
		text = text.toLowerCase().trim();
		
		//P2. word replacement
		text = text.replaceAll(" into ", " in ");
		text = text.replaceAll("pick up", "pickup");
		text = text.replaceAll("look around", "look");
		text = text.replaceAll("climb up", "up");
		
		String words[] = text.split(" ");
		
		//P3. remove all instances of "THE"
		ArrayList wordlist = new ArrayList(Arrays.asList(words));		//array list of words
		for(int i=0; i< wordlist.size(); i++) {
			if (wordlist.get(i).equals("the")) wordlist.remove(i--);			
		}

		//separate out into word1, word2, etc.
		String word1 = words[0];
        String word2 = null;
        if (words.length > 1)
        {
            word2 = words[1];
        }

		/***** MAIN PROCESSING *****/
		switch(word1) {
		
		/**** one word commands ****/
		case "quit": case "exit": case "leave":
            String answer = YorN("Do you really want to quit the game? (Y/N): ");
			if (answer.equals("Y"))
            {
				System.out.print("Thanks for playing. Bye.");
				return false;
			}

            if (answer.equals("N"))
            {
                System.out.println("Let's return to the game!");
                return true;
            }

		case "n": case "e": case "s": case "w": case "u": case "d":
		case "north": case "east": case "south": case "west": case "up": case "down":
			movingRooms(word1.charAt(0));
			break;

		/*case "i": case "inventory":
			showInventory();
			break;
		case "help":
			printHelp();
			break; 
		case "pickup":
		case "swim":
		case "break": case "mine":
		case "look":
		case "fix":
		case "takeoff"*/
			
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

    static void movingRooms(char direction)
    {
        if (roomList.get(currentRoom).getExit(direction) == "")
        {
            System.out.println("You cannot go there!");
        }

        else
        {
            currentRoom = roomList.get(currentRoom).getExit(direction);
        }
        System.out.println(roomList.get(currentRoom).displayName + "\n" + roomList.get(currentRoom).description);
    }
}