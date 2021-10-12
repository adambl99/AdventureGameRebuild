package com.company;

public class Weapon extends Item {
    private int damage;
    private int bowArrows;

public Weapon (String itemName, String itemDescription, int damage, int bowArrows){
    super(itemName, itemDescription);
    this.damage = damage;
    this.bowArrows = bowArrows;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int arrowsLeft(){
    return this.bowArrows;
    }
    public void arrowsUsed(){
    this.bowArrows --;
    }
}


