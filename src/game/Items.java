package game;

import java.util.HashMap;

class Items {
	
	 String itemDisplayName; //unique key
	 String itemName;
	 String itemDescription; //describe the item when you look at it
	 boolean isActivatable;
	 
	 //constructor
	 Items(String displayName, String description, boolean activatable, String name) {
		 itemDisplayName = displayName;
		 itemDescription = description;
		 isActivatable = activatable;
		 itemName = name;
	 }
	 
	 //create items
	 static void setupItems(HashMap<String, Items> itemList, HashMap<String, Room> roomList) {

		 Items i = new Items ("Shovel", "A trusty shovel, good for digging things up.", true, "shovel"); // creates item
		 itemList.put("shovel", i); // puts item in item hash map
		 roomList.get("mountains").items.add("shovel"); // adds item to room

		 i = new Items("Pickaxe", "A sturdy pickaxe, good for breaking rock.", true, "pickaxe");
		 itemList.put("pickaxe", i);
		 roomList.get("mountains").items.add("pickaxe");

		 i = new Items("Miner Helmet", "A hard helmet with a light on it.", true, "helmet");
		 itemList.put("helmet", i);
		 roomList.get("lmine").items.add("helmet");

		 i = new Items("Scuba Gear", "A wetsuit, and an oxygen tank for diving underwater.", true, "scuba");
		 itemList.put("scuba", i);
		 roomList.get("beach").items.add("scuba");

		 i = new Items("Rocket Left Wing", "The left wing of the rocket.", false, "leftwing");
		 itemList.put("leftwing", i);
		 roomList.get("desert").items.add("leftwing");

		 i = new Items("Rocket Nose", "The nose of the rocket.", false, "nose");
		 itemList.put("nose", i);
		 roomList.get("lake").items.add("nose");

		 i = new Items("Rocket Engine", "The engine of the rocket.", false, "engine");
		 itemList.put("engine", i);
		 roomList.get("lmine").items.add("engine");

		 i = new Items("Rocket Right Wing", "The right wing of the rocket.", false, "rightwing");
		 itemList.put("rightwing", i);
		 roomList.get("cave2").items.add("rightwing");

		 i = new Items("Gold", "Some gold, its shiny.", false, "gold");
		 itemList.put("gold", i);
		 roomList.get("goldmine").items.add("gold");
	 }
}