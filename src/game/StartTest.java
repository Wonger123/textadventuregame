package game;

import java.util.*;

public class StartTest {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Would you like to play a game? (Y/N)"); //Beginning
        String answer = sc.next();
        sc.nextLine();

        while (!answer.toLowerCase().equals("y") && !answer.toLowerCase().equals("n")) { //Catches Errors
            System.out.println("Would you like to play a game? (Y/N)");
            answer = sc.next();
            sc.nextLine();
        }

        if (answer.toLowerCase().equals("y")) { //Initiates Game
            System.out.println("Let's start the game");
            boolean isPlaying = true;
            
            while (isPlaying) {
                System.out.print("Type something: "); //User is prompted to type
                String thing = sc.next();
                sc.nextLine();

                if (thing.toLowerCase().equals("exit")) { //Handles exiting game
                    System.out.println("Are you sure? (Y/N)");
                    String exit = sc.next();
                    sc.nextLine();

                    while (!exit.toLowerCase().equals("y") && !exit.toLowerCase().equals("n")) {
                        System.out.println("Invalid answer, please type Y or N");
                        answer = sc.next();
                        sc.nextLine();
                    }

                    if (exit.toLowerCase().equals("y")) //Exits game and breaks out of loop
                    {
                        System.out.println("Goodbye!");
                        isPlaying = false;
                    }
                }

                else
                {
                    //gamestuff
                }
            }
        }
        else System.out.println("Goodbye!"); //If user does not want to play

        System.out.println("Program End"); //Confirms the program has reached the end
    }
}
