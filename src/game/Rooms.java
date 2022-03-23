package game;

import java.util.ArrayList;
import java.util.HashMap;

public class Rooms {

	public static void main(String[] args) {}
}

class Room {

	// String name;
	String displayName;
	String description;
	boolean isDark;
	String N, E, S, W, U, D;
	ArrayList items = new ArrayList();

	// constructor
	Room(String displayName, String description) {
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

	void characteristics(boolean isDark) {
		this.isDark = isDark;
	}

	String getExit(char dir) {
		switch (dir) {
		case 'N': return this.N;
		case 'E': return this.E;
		case 'S': return this.S;
		case 'W': return this.W;
		case 'U': return this.U;
		case 'D': return this.D;
		default: return "";
		}
	}

	static void setupRooms(HashMap<String, Room> roomList) {
		Room r = new Room("Forest",
				"You awake in a forest, the last thing that you remember was flying towards mars when you crashed into a rock and went off course. Now, lying in pieces near you, your ship is unusable. You notice some parts are missing as well. You think you should probably go find them instead of laying here until you die. \n"
				+ "Placeholder North"
				+ "Placeholder East"
				+ "Placeholder South"
				+ "Placeholder West"
				+ "Placeholder Up");
		r.setExits("forest2", "desert","mountains","forestclearing", "trees", "");
		r.characteristics(false);
		roomList.put("forest1", r);
		
		r = new Room("Up in the Trees",
				"Placeholder Description\n"
				+ "Placeholder Down");
		r.setExits("", "", "", "", "", "forest1");
		r.characteristics(false);
		roomList.put("trees", r);
	}
}