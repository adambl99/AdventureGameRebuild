package com.company;

import java.util.ArrayList;

public class Player{

    Map map = new Map();
    private Room currentRoom;
    private ArrayList<Item> playerInventory = new ArrayList<>();

    public Player(){
        this.currentRoom = map.getStartRoom();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    // Shows if there are items in the player's inventory or not.
    public void getPlayerInventory() {
        if(playerInventory.isEmpty()){
            System.out.println("Your inventory is empty.");
        } else {
            for (int i = 0; i < playerInventory.size(); i++);
            System.out.println(playerInventory);
        }
    }

    public void setPlayerInventory(ArrayList<Item> playerInventory) {
        this.playerInventory = playerInventory;
    }


    public Item takeItem(Room playerrooom, String itemName){
        for(Item item : playerrooom.inventory ) {
            if(item.getItemName().equalsIgnoreCase(itemName)){
                playerInventory.add(item);
                playerrooom.removeItemFromRoom(item);
                System.out.println("You've picked up: " + item.getItemName());
                return item;
            }
        }
        return null;
    }

    public Item dropItem(Room playerroom, String itemName){
        for (Item item : playerInventory){
            if (item.getItemName().equalsIgnoreCase(itemName)){
                playerInventory.remove(item);
                playerroom.addItem(item);
                System.out.println("You've dropped: " + itemName);
                return item;
            }
        }
        return null;
    }


}