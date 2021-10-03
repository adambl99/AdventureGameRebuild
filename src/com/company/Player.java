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


    public Item takeItem(String itemName){
        for(Item item : currentRoom.inventory ) {
            if(item.getItemName().equalsIgnoreCase(itemName)){
                currentRoom.removeItemFromRoom(item);
                playerInventory.add(item);
                return item;
            }
        }
        return null;
    }

    public Item dropItem(String itemName){
        for (Item item : playerInventory){
            if (item.getItemName().equalsIgnoreCase(itemName)){
                playerInventory.remove(item);
                currentRoom.addItem(item);
                return item;
            }
        }
        return null;
    }


}