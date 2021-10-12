package com.company;

public class Food extends Item {
    private int hitPoints;

    public Food(String itemName, String itemDescription, int hitPoints){
        super(itemName, itemDescription);
        this.hitPoints = hitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
