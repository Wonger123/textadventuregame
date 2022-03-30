package game;
import java.util.*;

class Room {

	// String name;
	String displayName;
	String description;
	String directions;
	boolean isDark;
	//boolean isVisited;
	String N, E, S, W, U, D;
	ArrayList items = new ArrayList();

	// constructor
	Room(String displayName, String description, String directions) {
		this.displayName = displayName;
		this.description = description;
		this.directions = directions;
	}

	void setExits(String N, String E, String S, String W, String U, String D) {
		this.N = N;
		this.E = E;
		this.S = S;
		this.W = W;
		this.U = U;
		this.D = D;
	}

	/*void characteristics(boolean isDark) {
		this.isDark = isDark;
	}*/

	String getExit(char dir) {
		switch (dir) {
		case 'n': return this.N;
		case 'e': return this.E;
		case 's': return this.S;
		case 'w': return this.W;
		case 'u': return this.U;
		case 'd': return this.D;
		default: return "";
		}
	}

	static void setupRooms(HashMap<String, Room> roomList) {
		Room r = new Room("Forest",
				"This small clearing in the trees houses your rocket. In each direction there are dirt pathways.",
				"Heading north you'll reach another part of this forest.\n"
				+ "Heading east you'll find a desert.\n"
				+ "Heading south you'll come across some mountains.\n"
				+ "Heading west you come across a clearing, surrounded by trees.\n"
				+ "You climb up into the trees and find a structure.");
		r.setExits("forest2", "desert", "mountains", "clearing", "trees", "");
		roomList.put("forest1", r);
		
		r = new Room("Structure in Trees",
				"Sitting in the trees you find a building resembling a treehouse. It is empty",
				"You can head back down to the forest below.");
		r.setExits("", "", "", "", "", "forest1");
		roomList.put("trees", r);

		r = new Room("Desert",
				"You come across a desert, hot and dry. Nearby you see a pyramid.",
				"Heading west you enter the forest, back to the clearing where your ship resides.");
		r.setExits("", "", "", "forest1", "", "");
		roomList.put("desert", r);

		r = new Room("Forest",
				"This part of the forest is dense with trees",
				"Heading east, there is a clearing where you can see what looks to be a mine.\n"
				+ "Heading south there is a pathway to enter the forest, back to the clearing where your ship resides.\n"
				+ "Following the river heading to the west you reach a beach.");
		r.setExits("", "umine", "forest1", "beach", "", "");
		roomList.put("forest2", r);

		r = new Room("Upper Mine",
				"At the top of the mine there is a minecart on a track.",
				"Heading South there is a path back to the forest.\n"
				+ "Heading down you see a miners hat sitting on the floor, lighting up the room.");
		r.setExits("", "", "", "forest2", "", "lmine");
		roomList.put("umine", r);

		r = new Room("Lower Mine",
				"You see a hat on the ground with a light on it lighting up the east wall, against that wall you see the ship engine. On the east wall you see an image depicting a sun shining down onto a field of crops.",
				"Heading east there seems to be another room you can enter.\n"
				+ "You can also go back up the mine.");
		r.setExits("", "goldmine", "", "", "umine", "");
		roomList.put("lmine", r);

		r = new Room("Gold Mine",
				"The room is filled with piles of gold that glisten when you turn to look at them.",
				"You climb through the hole in the wall that you broke to the west, re-entering the lower part of the mines.");
		r.setExits("", "", "", "lmine", "", "");
		roomList.put("goldmine", r);

		r = new Room("Beach",
				"On this beach you see a river flowing into the ocean. The ocean spans as far as you can see.",
				"Following the river you come to an opening in the forests.\n"
				+ "Heading south, you come across a clearing");
		r.setExits("", "forest2", "clearing", "", "", "");
		roomList.put("beach", r);

		r = new Room("Forest Clearing",
				"The forest has a clearing here, a lake below is surrounded by trees.",
				"Heading north you reach a beach.\n"
				+ "Heading east you enter the forest, back to the clearing where your ship resides.\n"
				+ "Heading south the forest becomes less dense, before disappearing as you enter a rocky landscape, where you find mountains.\n"
				+ "There is a lake that you cannot see to the bottom of down below. The sun reflecting off of it is too bright.");
		r.setExits("beach", "forest1", "mountains", "", "", "lake");
		roomList.put("clearing", r);

		r = new Room("Lake",
				"Looking around the lake you see small plants along the bottom of the lake, as well as many crevices lining the walls.",
				"Swimming east towards where your ship was you notice a cave.\n"
				+ "Swimming back up you reach the surface, where you climb out and stand on the path.");
		r.setExits("", "cave1", "", "", "clearing", "");
		roomList.put("lake", r);
		
		r = new Room("Cave",
				"A small room full of bright coral and strange plants lighting up the room. The plants are stems with white bulbs on the end emanating light.",
				"Exiting the small cave on the west, you re-enter the lake.");
		r.setExits("", "", "", "lake", "", "");
		roomList.put("cave1", r);

		r = new Room("Mountains",
				"The rocky landscape is home to many mountains.",
				"Heading north you enter the forest, back to the clearing where your ship resides.\n"
				+ "You see a cave to the west, it is too dark to see inside.\n"
				+ "Feel free to climb up the mountains to get a better view of this planet.");
		r.setExits("forest1", "", "", "cave2", "peak", "");
		roomList.put("mountains", r);

		r = new Room("Mountain Peak",
				"Looking around from up here you can see a beach far off to the north west. Off to the east you can see a desert, and somewhere in the middle is covered in forest. Though you see a clearing off to the west part of the forest as well as farther north.",
				"I think you should head down, it's quite high up here.");
		r.setExits("", "", "", "", "", "mountains");
		roomList.put("peak", r);

		r = new Room("Cave",
				"The cave is vast and empty. You cannot see properly due to how dark it is.",
				"You exit the cave to the east and return to the mountains.\n"
				+ "You head down into a hidden area of the cave.");
		r.setExits("", "mountains", "", "", "", "secret");
		roomList.put("cave2", r);

		r = new Room("Secret Cave",
				"You found a secret cave!",
				"You head back up into the main cave.");
		r.setExits("", "", "", "", "cave2", "");
		roomList.put("secret", r);
	}
}