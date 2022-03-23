package game;

import java.util.HashMap;

public class Items {

	public static void main(String[] args) {
		
		
	}
}

class Item {
	 String name; //unique key
	 String description; //describe the item when you look at it
	 //the location is in the Room object OR here.
	 boolean isCarryable = true;
	 boolean isActivated = false; //eg flashlight off or on
	 String descrActive = ""; //description for when it's active
	 //maybe also damage points, weight, cost in gold ...
	 String readText = ""; //if there is writing on it
	 
	 //constructors
	 
	 //getters
	 
	 //create items
	 static void setupItems(HashMap<String,Item> itemList,
		HashMap<String, Item> roomList) {
	 }
}