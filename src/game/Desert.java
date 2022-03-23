package game;

import java.util.ArrayList;
import java.util.HashMap;

public class Desert {

	public static void main(String[] args) {
		
		
	}
}

class Room {

	//String name;
	String displayName;
	String description;
	boolean isVisited;
	boolean isDark;
	String N,S,E,W;	
	ArrayList items = new ArrayList();
	
	//constructor
	Room(String displayName, String descr) {
		this.displayName = displayName;
		this.description = descr;		
	}
	
	void setExits(String N, String S, String E, String W) {
		this.N=N;
		this.E=E;
		this.W=W;
		this.S=S;
	}
	
	String getExit(char dir) {
		switch (dir) {
		case 'N': return this.N;
		case 'S': return this.S;
		case 'W': return this.W;
		case 'E': return this.E;
		default: return "";
		}
	}
	
	static void setupRooms(HashMap<String, Room> roomList) {
		Room r = new Room("Forest Clearing",
				"There is a lovely peaceful clearing here\n"
				+ "A path leads north and it looks like you can go through"
				+ "the forest to the west");
					//N  S  E  W 
		r.setExits("forest1", "path1","","");
		roomList.put("clearing", r);
		
		r = new Room("Tunnel",
				"A slippery tunnel connecting parts of the cave system\n"
				+ "At the south is a massive iron door");
		r.setExits("", "cave", "tunnel2","");
		roomList.put("tunnel1", r);		
	}
	
}