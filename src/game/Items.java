package game;

import java.util.HashMap;

class Items {
	
	 String itemName; //unique key
	 String itemDescription; //describe the item when you look at it
	 boolean itemIsCarryable = true;
	 boolean itemIsActivated = false;
	 
	 //constructor
	 Items(String name, String description, boolean isCarryable, boolean isActivated) {
		 itemName = name;
		 itemDescription = description;
		 itemIsCarryable = isCarryable;
		 itemIsActivated = isActivated;
	 }
	 
	 //create items
	 static void setupItems(HashMap<String, Items> itemList, HashMap<String, String> roomList) {
		 itemList.put("Shovel", new Items("Shovel", "A trusty shovel, good for digging things up.", true, false));
		 itemList.put("Pickaxe", new Items("Pickaxe", "A sturdy pickaxe, good for breaking rock.", true, false));
		 itemList.put("Miner's Helmet", new Items("Miner's Helmet", "A hard hat with a light on it.", true, false));
		 itemList.put("Scuba Gear", new Items("Scuba Gear", "A wetsuit, and an oxygen tank for diving underwater.", true, false));
		 itemList.put("Left Wing", new Items("Rocket Left Wing", "The left wing of the rocket.", true, false));
		 itemList.put("Nose", new Items("Rocket Nose", "The nose of the rocket.", true, false));
		 itemList.put("Engine", new Items("Rocket Engine", "The engine of the rocket.", true, false));
		 itemList.put("Right Wing", new Items("Rocket Right Wing", "The right wing of the rocket.", true, false));
		 itemList.put("Gold", new Items("Gold", "Some gold, its shiny.", true, false));
	 }
}