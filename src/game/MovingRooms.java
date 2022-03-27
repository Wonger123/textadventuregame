package game;

import java.util.*;

public class MovingRooms {
    static HashMap<String, Room> roomList = new HashMap<String, Room>();
    static String currentRoom;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Room.setupRooms(roomList);
        currentRoom = "forest1";
        System.out.println("You awake in a forest, the last thing that you remember was flying towards mars when you crashed into a rock and went off course. Now, lying in pieces near you, your ship is unusable. You notice some parts are missing as well. You think you should probably go find them instead of laying here until you die.");
        boolean playing = true;
        while (playing) {
            System.out.print("");
            String answer = sc.next();
            sc.nextLine();
            if (roomList.get(currentRoom).getExit(answer.toLowerCase().charAt(0)) == "")
            {
                System.out.println("Please enter a valid room");
            }

            else
            {
                currentRoom = roomList.get(currentRoom).getExit(answer.toLowerCase().charAt(0));
            }
            System.out.println("You are currently in " + roomList.get(currentRoom).displayName);
        }
    }
}