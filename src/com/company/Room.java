package com.company;

import java.util.ArrayList;

public class Room {

    private String name;
    private String roomDesc;

    private Room north;
    private Room south;
    private Room east;
    private Room west;

    public ArrayList<Item> inventory = new ArrayList<>();

    public Room(String name){
        this.name = name;
    }

    public String getRoomDesc(){
        return roomDesc;
    }
    public void setRoomDesc(String roomDesc){
        this.roomDesc = roomDesc;
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void addNewItem(String name, String itemDesc){
        Item item = new Item(name, itemDesc);
        inventory.add(item);
    }
    public void addItem(Item item){
        inventory.add(item);
    }

    // Removes items, when player picks them up.
    public Item removeItemFromRoom(Item item){
        if(inventory.contains(item)){
            inventory.remove(item);
            return item;
        }
        return null;
    }

    // Shows if there are intems in the room or not.
    public void getInventory() {
        if(inventory.isEmpty()){
            System.out.println("There are no items to find here.");
        } else {
            for(int i = 0; i < inventory.size(); i++);
            System.out.println(", are in this area.");
        }
    }

    @Override
    public String toString() {
        return name + "\n" + roomDesc;
    }
}