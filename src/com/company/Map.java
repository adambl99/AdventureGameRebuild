package com.company;

public class Map {
    private Room startRoom;

    Room Room1 = new Room("Entrance");
    Room Room2 = new Room("Grave Room");
    Room Room3 = new Room("Spider Room");
    Room Room4 = new Room("Snake pit Room");
    Room Room5 = new Room("The Pharaophs Grave");
    Room Room6 = new Room("Dark Room");
    Room Room7 = new Room("Burial Ground");
    Room Room8 = new Room("Anubis Room");
    Room Room9 = new Room("Butcher's Grave Room");
    Room currentRoom = Room1;

    public void createMap() {
        Room1.setSouth(Room4);
        Room1.setEast(Room2);
        Room2.setEast(Room3);
        Room2.setWest(Room1);
        Room3.setSouth(Room6);
        Room3.setWest(Room2);
        Room4.setNorth(Room1);
        Room4.setSouth(Room7);
        Room5.setSouth(Room8);
        Room6.setNorth(Room3);
        Room6.setSouth(Room9);
        Room7.setNorth(Room4);
        Room7.setEast(Room8);
        Room8.setNorth(Room5);
        Room8.setWest(Room7);
        Room8.setEast(Room9);
        Room9.setWest(Room8);
        Room9.setNorth(Room8);

        startRoom = Room1;


        //Beskriver rummene
        Room1.setRoomDesc("You are at the entrance of the Pharaohs tomb");
        Room2.setRoomDesc("You are standing in an abondoned grave room, wonder who lies here");
        Room3.setRoomDesc("You are in a room filled with poisonous spiders and tangly spiderweb");
        Room4.setRoomDesc("You are standing in a room filled with snakes");
        Room5.setRoomDesc("This is where the Pharaoh is buried, you found his tomb");
        Room6.setRoomDesc("The room is completely black, you need to feel your way around");
        Room7.setRoomDesc("You are standing in a burial ground, seems like it has been used recently");
        Room8.setRoomDesc("This room seems to be dedicated to the god Anubis as the only thing in here is a shrine with a statue of Anubis");
        Room9.setRoomDesc("It appears that you are standing in the Pharaophs butcher's grave room, the atrocities he committed when he was alive...");



        Room2.addNewItem("dirt", "pile of stinky dirt");
        Room2.addNewItem("3 ting test", "test 3 ting i et rum");
        Room2.addNewItem("3 ting test", "test 3 ting i et rum");
        Room3.addNewItem("spiderweb", "big entaglement of spiderweb");
        Room4.addNewItem("snakeskin", "snake skin from a dead snake carcass");
        Room5.addNewItem("pharaohs staff", "the pharaohs golden staff");
        Room6.addNewItem("gold coin", "a gold coin found in darkness");
        Room7.addNewItem("human bones", "bones from recently deceased");
        Room8.addNewItem("Anubis statue", "statue of the god anubis");
        Room9.addNewItem("butcher's cleaver", "the pharaohs butcher's cleaver");
    }
    public Room getStartRoom(){
        return startRoom;
    }
}