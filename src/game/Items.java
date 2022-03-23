package game;

import java.util.HashMap;

class Item {
	 String itemName; //unique key
	 String itemDescription; //describe the item when you look at it
	 boolean itemIsCarryable = true;
	 boolean itemIsActivated = false;
	 
	 //constructor
	 Item(String name, String description, boolean isCarryable, boolean isActivated) {
		 itemName = name;
		 itemDescription = description;
		 itemIsCarryable = isCarryable;
		 itemIsActivated = isActivated;
	 }
	 
	 //create items
	 static void setupItems(HashMap<String, Item> itemList, HashMap<String, String> roomList) {
		 itemList.put("Shovel", new Item("Shovel", "A trusty shovel, good for digging things up.", true, false));
		 itemList.put("Pickaxe", new Item("Pickaxe", "A sturdy pickaxe, good for breaking rock.", true, false));
		 itemList.put("Miner's Helmet", new Item("Miner's Helmet", "A hard hat with a light on it.", true, false));
		 itemList.put("Scuba Gear", new Item("Scuba Gear", "A wetsuit, and an oxygen tank for diving underwater.", true, false));
		 itemList.put("Left Wing", new Item("Rocket Left Wing", "The left wing of the rocket.", true, false));
		 itemList.put("Nose", new Item("Rocket Nose", "The nose of the rocket.", true, false));
		 itemList.put("Engine", new Item("Rocket Engine", "The engine of the rocket.", true, false));
		 itemList.put("Right Wing", new Item("Rocket Right Wing", "The right wing of the rocket.", true, false));
		 itemList.put("Gold", new Item("Gold", "Some gold, its shiny.", true, false));
	 }
}