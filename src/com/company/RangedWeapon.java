package com.company;

public class RangedWeapon extends Weapon {

    int bowArrows;
    int damage;
public RangedWeapon(String itemName, String itemDescription, int damage, int bowArrows){
    super(itemName, itemDescription, damage, bowArrows);
    this.bowArrows = bowArrows;
}

    public int getBowArrows() {
        return bowArrows;
    }

    public void setBowArrows(int bowArrows) {
        this.bowArrows = bowArrows;
    }


    public int getDamage() {
        return damage;
    }


    public void setDamage(int damage) {
        this.damage = damage;
    }
}
