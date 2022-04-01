package game;

import java.util.HashMap;

class Items {
	
	 String itemDisplayName; //unique key
	 String itemName;
	 String itemDescription; //describe the item when you look at it
	 
	 //constructor
	 Items(String displayName, String description, String name) {
		 itemDisplayName = displayName;
		 itemDescription = description;
		 itemName = name;
	 }
	 
	 //create items
	 static void setupItems(HashMap<String, Items> itemList, HashMap<String, Room> roomList) {
		 Items z = new Items ("Shovel", "A trusty shovel, good for digging things up.", "shovel"); // creates item
		 itemList.put("shovel", z); // puts item in item hash map
		 roomList.get("mountains").items.add("shovel"); // adds item to room

		 z = new Items("Pickaxe", "A sturdy pickaxe, good for breaking rock.", "pickaxe");
		 itemList.put("pickaxe", z);
		 roomList.get("mountains").items.add("pickaxe");

		 z = new Items("Miner Helmet", "A hard hat with a light on it.", "helmet");
		 itemList.put("helmet", z);
		 roomList.get("lmine").items.add("helmet");

		 z = new Items("Scuba Gear", "A wetsuit, and an oxygen tank for diving underwater.", "scuba");
		 itemList.put("scuba", z);
		 roomList.get("beach").items.add("scuba");

		 z = new Items("Rocket Left Wing", "The left wing of the rocket.", "leftwing");
		 itemList.put("leftwing", z);
		 roomList.get("desert").items.add("leftwing");

		 z = new Items("Rocket Nose", "The nose of the rocket.", "nose");
		 itemList.put("nose", z);
		 roomList.get("lake").items.add("nose");

		 z = new Items("Rocket Engine", "The engine of the rocket.", "engine");
		 itemList.put("engine", z);
		 roomList.get("lmine").items.add("engine");

		 z = new Items("Rocket Right Wing", "The right wing of the rocket.", "rightwing");
		 itemList.put("rightwing", z);
		 roomList.get("cave2").items.add("rightwing");

		 z = new Items("Gold", "Some gold, its shiny.", "gold");
		 itemList.put("gold", z);
		 roomList.get("goldmine").items.add("gold");
	 }
}