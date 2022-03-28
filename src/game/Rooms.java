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
				"Heading north you come across a river heading West, as well as a mine through a clearing to the east.\n"
				+ "Desert on the East"
				+ "Heading south you'll come across some mountains. You see a cave to the east, it is too dark to see inside"
				+ "Clearing towards the West"
				+ "Structure in the Trees Going Up");
		r.setExits("forest2", "desert", "mountains", "clearing", "trees", "");
		roomList.put("forest1", r);
		
		r = new Room("Structure in Trees",
				"Placeholder Description",
				"Back to Forest Below");
		r.setExits("", "", "", "", "", "forest1");
		roomList.put("trees", r);

		r = new Room("Desert",
				"You come across a desert, hot and dry. Nearby you see a pyramid.",
				"Desert in the West");
		r.setExits("", "", "", "forest1", "", "");
		roomList.put("desert", r);

		r = new Room("Forest",
				"Placeholder Description",
				"Placeholder East"
				+ "Placeholder South"
				+ "Placeholder West");
		r.setExits("", "mine", "forest1", "beach", "", "");
		roomList.put("forest2", r);

		r = new Room("Mines",
				"Placeholder Description",
				"Placeholder East"
				+ "Placeholder West");
		r.setExits("", "goldmine", "", "forest2", "", "");
		roomList.put("mine", r);

		r = new Room("Gold Mine",
				"Placeholder Description",
				"Placeholder West");
		r.setExits("", "", "", "mine", "", "");
		roomList.put("goldmine", r);

		r = new Room("Beach",
				"Placeholder Description",
				"Placeholder East"
				+ "Placeholder South");
		r.setExits("", "forest2", "clearing", "", "", "");
		roomList.put("beach", r);

		r = new Room("Forest Clearing",
				"Placeholder Description",
				"Placeholder North"
				+ "Placeholder East"
				+ "Placeholder South"
				+ "Placeholder Down");
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
				"Placeholder North"
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