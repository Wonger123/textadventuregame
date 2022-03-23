package game;

import java.util.HashMap;

class Item {
	 String itemName; //unique key
	 String itemDescription; //describe the item when you look at it
	 //the location is in the Room object OR here.
	 boolean itemIsCarryable = true;
	 boolean itemIsActivated = false;
	 
	 //constructors
	 
	 Item(String name, String description, boolean isCarryable, boolean isActivated) {
		 itemName = name;
		 itemDescription = description;
		 itemIsCarryable = isCarryable;
		 itemIsActivated = isActivated;
	 }
	 
	 //getters
	 
	 //create items
	 static void setupItems(HashMap<String, Item> itemList, HashMap<String, String> roomList) {
		 itemList.put("Shovel", new Item("Shovel", "A trusty shovel, good for digging things up", true, false));
		 itemList.put("Pickaxe", new Item("Pickaxe", "placeholder description", true, false));
		 itemList.put("Miner's Helmet", new Item("Miner's Helmet", "placeholder description", true, false));
		 itemList.put("Scuba Gear", new Item("Scuba Gear", "placeholder description", true, false));
		 itemList.put("Rocket Part 1", new Item("Part 1", "placeholder description", true, false));
		 itemList.put("Rocket Part 2", new Item("Part 2", "placeholder description", true, false));
		 itemList.put("Rocket Part 3", new Item("Part 3", "placeholder description", true, false));
		 itemList.put("Rocket Part 4", new Item("Part 4", "placeholder description", true, false));
		 itemList.put("Gold", new Item("Gold", "placeholder description", true, false));
	 }
}