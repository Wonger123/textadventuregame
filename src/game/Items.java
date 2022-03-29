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
	 static void setupItems(HashMap<String, Items> itemList, HashMap<String, Room> roomList) {
		 Items z = new Items ("Shovel", "A trusty shovel, good for digging things up.", true, false); // creates item
		 itemList.put("shovel", z); // puts item in item hashmap
		 roomList.get("mountains").items.add("shovel"); // adds item to room

		 z = new Items("Pickaxe", "A sturdy pickaxe, good for breaking rock.", true, false);
		 itemList.put("pickaxe", z);
		 roomList.get("mountains").items.add("pickaxe");

		 z = new Items("Miner's Helmet", "A hard hat with a light on it.", true, false);
		 itemList.put("helmet", z);
		 roomList.get("lmine").items.add("helmet");

		 z = new Items("Scuba Gear", "A wetsuit, and an oxygen tank for diving underwater.", true, false);
		 itemList.put("scuba", z);
		 roomList.get("beach").items.add("scuba");

		 z = new Items("Rocket Left Wing", "The left wing of the rocket.", true, false);
		 itemList.put("leftwing", z);
		 roomList.get("desert").items.add("leftwing");

		 z = new Items("Rocket Nose", "The nose of the rocket.", true, false);
		 itemList.put("nose", z);
		 roomList.get("lake").items.add("nose");

		 z = new Items("Rocket Engine", "The engine of the rocket.", true, false);
		 itemList.put("engine", z);
		 roomList.get("lmine").items.add("engine");

		 z = new Items("Rocket Right Wing", "The right wing of the rocket.", true, false);
		 itemList.put("rightwing", z);
		 roomList.get("cave2").items.add("rightwing");

		 z = new Items("Gold", "Some gold, its shiny.", true, false);
		 itemList.put("gold", z);
		 roomList.get("goldmine").items.add("gold");
	 }
}