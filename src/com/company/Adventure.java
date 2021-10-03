package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Adventure {
    Scanner input = new Scanner(System.in);
    Map map = new Map();
    Player player = new Player();
    Room room = new Room("");
    Room startRoom;
    Room currentRoom;


    public Adventure(){
        map.createMap();
        startRoom = map.getStartRoom();
        System.out.println(map.getStartRoom());
        currentRoom = startRoom;
    }

    public void gamePlay(){
        System.out.println("Welcome to Tomb Ascendeance, try to locate the Pharaohs tomb");
        System.out.println("There are 8 rooms in the tomb, maybe the rooms even contains items and artifacts");
        System.out.println("To move between the rooms, type commands like so:" +
                "\nNorth: 'go north'\nSouth: 'go south'\nEast: 'go east'\nWest: 'go west'\nYou can also type shortened versions such as: n, s, e, w");
        System.out.println("Good luck, and don't get lost in the darkness.\n");
        System.out.println(currentRoom);

        while (true) {
            String direction = input.next().trim().toLowerCase(Locale.ROOT);
            switch (direction) {
                case "north", "go north", "n":
                    if (currentRoom.getNorth() == null) {
                        System.out.println("This pathway seems to be blocked");
                    } else {
                        currentRoom = currentRoom.getNorth();
                        System.out.println(currentRoom);
                    }
                    break;

                case "south", "go south", "s":
                    if (currentRoom.getSouth() == null) {
                        System.out.println("This pathway is blocked");
                    } else {
                        currentRoom = currentRoom.getSouth();
                        System.out.println(currentRoom);
                    }
                    break;

                case "west", "go west", "w":
                    if (currentRoom.getWest() == null) {
                        System.out.println("This pathway seems to be blocked");
                    } else {
                        currentRoom = currentRoom.getWest();
                        System.out.println(currentRoom);
                    }
                    break;

                case "east", "go east", "e":
                    if (currentRoom.getEast() == null) {
                        System.out.println("This pathway seems to be blocked");
                    } else {
                        currentRoom = currentRoom.getEast();
                        System.out.println(currentRoom);
                    }
                    break;

                case "look":
                    System.out.println(currentRoom);
                    room.getInventory();
                    break;

                case "help":
                    System.out.println("List of commands:\nNorth: 'go north'\nSouth: 'go south'\nEast: 'go east'" +
                            "\nWest: 'go west'\nTake item: 'take'\nDrop item: 'drop'\nCheck inventory: 'inventory'");
                    break;

                case "exit":
                    System.out.println("You found the pharaohs grave!");
                    System.exit(0);
                    break;

                case "inventory":
                    player.getPlayerInventory();
                    break;

                case "take":
                    System.out.println("What do you want me to pick up?: ");
                    String itemToPickUp = input.next();
                    player.takeItem(currentRoom, itemToPickUp);
                    break;

                case "drop":
                    System.out.println("What do you want to drop?: ");
                    String itemToDrop = input.next();
                    player.dropItem(currentRoom, itemToDrop);
                    break;
            }


        }




    }




}
