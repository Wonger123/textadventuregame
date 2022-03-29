package game;
import java.util.*;

class Room {

	// String name;
	String displayName;
	String description;
	boolean isDark;
	//boolean isVisited;
	String N, E, S, W, U, D;
	ArrayList items = new ArrayList();

	// constructor
	Room(String displayName, String description, String directions) {
		this.displayName = displayName;
		this.description = description;
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
				"Heading north you'll reach another part of this forest\n"
				+ "Desert on the East"
				+ "Heading south you'll come across some mountains. You see a cave to the east, it is too dark to see inside"
				+ "Heading west you come across a clearing, surrounded by trees."
				+ "Structure in the Trees Going Up");
		r.setExits("forest2", "desert", "mountains", "clearing", "trees", "");
		roomList.put("forest1", r);
		
		r = new Room("Structure in Trees",
				"Placeholder Description",
				"You can head back down to the forest below");
		r.setExits("", "", "", "", "", "forest1");
		roomList.put("trees", r);

		r = new Room("Desert",
				"You come across a desert, hot and dry. Nearby you see a pyramid.",
				"Heading west you enter the forest, back to the clearing where your ship resides. ");
		r.setExits("", "", "", "forest1", "", "");
		roomList.put("desert", r);

		r = new Room("Forest",
				"Placeholder Description",
				"You enter the mine, there is an empty mine cart on a track at the top"
				+ "Heading south you enter the forest, back to the clearing where your ship resides."
				+ "A beach is to the west, you can get to it by following the river");
		r.setExits("", "mine", "forest1", "beach", "", "");
		roomList.put("forest2", r);

		r = new Room("Upper Mine",
				"Placeholder Description",
				"Heading west you come to the forest"
				+ "Heading down you see a miners hat sitting on the floor, lighting up the room.");
		r.setExits("", "", "", "forest2", "", "lmine");
		roomList.put("umine", r);

		r = new Room("Lower Mine",
				"Placeholder Description",
				"Placeholder East"
				+ "Placeholder Up");
		r.setExits("", "goldmine", "", "", "umine", "");
		roomList.put("lmine", r);

		r = new Room("Gold Mine",
				"Placeholder Description",
				"Placeholder West");
		r.setExits("", "", "", "lmine", "", "");
		roomList.put("goldmine", r);

		r = new Room("Beach",
				"Placeholder Description",
				"Following the river you come to an opening in the forests."
				+ "Placeholder South");
		r.setExits("", "forest2", "clearing", "", "", "");
		roomList.put("beach", r);

		r = new Room("Forest Clearing",
				"Placeholder Description",
				"Placeholder North"
				+ "Heading east you enter the forest, back to the clearing where your ship resides."
				+ "Placeholder South"
				+ "There is a lake that you cannot see to the bottom of down below");
		r.setExits("beach", "forest1", "mountains", "", "", "lake");
		roomList.put("clearing", r);

		r = new Room("Lake",
				"Placeholder Description",
				"Placeholder East"
				+ "Placeholder Up");
		r.setExits("", "cave1", "", "", "clearing", "");
		roomList.put("lake", r);
		
		r = new Room("Cave",
				"Placeholder Description",
				"Placeholder West");
		r.setExits("", "", "", "lake", "", "");
		roomList.put("cave1", r);

		r = new Room("Mountains",
				"Placeholder Description",
				"Heading north you enter the forest, back to the clearing where your ship resides."
				+ "You see a cave to the west, it is too dark to see inside"
				+ "Placeholder Up");
		r.setExits("forest1", "", "", "cave2", "peak", "");
		roomList.put("mountains", r);

		r = new Room("Mountain Peak",
				"Placeholder Description",
				"Placeholder Down");
		r.setExits("", "", "", "", "", "mountains");
		roomList.put("peak", r);

		r = new Room("Cave",
				"Placeholder Description",
				"Placeholder East"
				+ "Placeholder Down");
		r.setExits("", "mountains", "", "", "", "secret");
		roomList.put("cave2", r);

		r = new Room("Secret Cave",
				"Placeholder Description",
				"Placeholder Up");
		r.setExits("", "", "", "", "cave2", "");
		roomList.put("secret", r);
	}
}