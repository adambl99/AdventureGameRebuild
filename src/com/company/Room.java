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

    public ArrayList<EnemyNPC> enemies = new ArrayList<>();

    public void addToItem(Item item) {
        this.inventory.add(item);
    }
    public void addEnemyNPC(EnemyNPC enemyNPC){
        this.enemies.add(enemyNPC);
    }

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


    public Item removeItemFromRoom(Item item){
        if(inventory.contains(item)){
            inventory.remove(item);
            return item;
        }
        return null;
    }
    public void removeEnemyNPCfromRoom(String enemyName){
        Weapon weapontoDrop;

        for (int i = 0; i < this.enemies.size(); i++){
            if (this.enemies.get(i).getEnemyName().contains(enemyName)){
                weapontoDrop = this.enemies.get(i).getWeapon();
                addToItem(weapontoDrop);
                this.enemies.remove(i);
            }
        }
    }

    public ArrayList<EnemyNPC> getEnemies(){
        return this.enemies;
    }

    public String getInventory() {
        if(inventory.isEmpty()){
            return "There are no items to find here.";
        } else {
            for(int i = 0; i < inventory.size(); i++);
            return ", are in this area.";
        }
    }
    public String toString() {

        return name + "\n" + roomDesc + "\n" + inventory.toString() + "\n" + enemies.toString();
    }
}