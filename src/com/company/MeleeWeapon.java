package com.company;

public class MeleeWeapon extends Weapon {

    private int damage;

    public MeleeWeapon(String itemName, String itemDescription, int damage, int bowArrows) {
        super(itemName, itemDescription, damage, bowArrows);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }


}

