package com.company;

import java.util.ArrayList;
import java.util.Locale;


public class Player {

    //TODO Error kommer måske fra her
    private Room currentRoom;
    private Item equippedWeapon;
    private Map map = new Map();
    private ArrayList<Item> playerInventory = new ArrayList<>();
    private int health;


    public Room getCurrentRoom() {
        this.currentRoom = map.getStartRoom();
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void getPlayerInventory() {
        if (playerInventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (int i = 0; i < playerInventory.size(); i++) ;
            System.out.println(playerInventory);
        }
    }

    public void setPlayerInventory(ArrayList<Item> playerInventory) {
        this.playerInventory = playerInventory;
    }


    public Item takeItem(Room playerrooom, String itemName) {
        for (Item item : playerrooom.inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                playerInventory.add(item);
                playerrooom.removeItemFromRoom(item);
                System.out.println("You've picked up: " + item.getItemName());
                return item;
            }
        }
        return null;
    }

    public Item dropItem(Room playerroom, String itemName) {
        for (Item item : playerInventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                playerInventory.remove(item);
                playerroom.addItem(item);
                System.out.println("You've dropped: " + itemName);
                return item;
            }
        }
        return null;
    }

    public void removeEatenItem(Item itemToInventory) {
        playerInventory.remove(itemToInventory);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void addToCurrentHealth(int healthPoints) {
        this.health += healthPoints;
    }

    public void setEquippedWeapon(Item equippedWeapon) {
        if (this.equippedWeapon != null) {
            playerInventory.add(this.equippedWeapon);
        }
        this.equippedWeapon = equippedWeapon;
    }

    public Item getEquippedWeapon() {
        return equippedWeapon;
    }


    public String health() {
        String s = " ";
        int currentHealth = getHealth();
        if (currentHealth <= 100 && currentHealth > 75) {
            System.out.println("HP: " + currentHealth);
            System.out.println("You have loads of HP, keep fighting");
        } else if (currentHealth <= 75 && currentHealth > 50) {
            System.out.println("HP: " + currentHealth);
            System.out.println("You still have a decent amount of HP but " +
                    "be careful!");
        } else if (currentHealth <= 50 && currentHealth > 25) {
            System.out.println("HP: " + currentHealth);
            System.out.println("You have low HP, avoid fighting right now!");
        } else if (currentHealth <= 25 && currentHealth > 0) {
            System.out.println("HP: " + currentHealth);
            System.out.println("You have very low HP, the next enemy attack might mean your demise!");
        }

        return s;
    }

    public enum edibleItems {
        APPLE, ONION, SALAD, BROCCOLI, MANGO
    }

    public enum weaponsYouCanEquip {
        AXE, SHANK, WHIP, BOW
    }

    public boolean isItemInInventory(String itemToFind) {
        boolean isInInventory = false;
        for (int i = 0; i < this.playerInventory.size(); i++) {
            if (this.playerInventory.get(i).getItemName().contains(itemToFind)) {
                isInInventory = true;
            }
        }
        return isInInventory;
    }

    public Item getItemInInventory(String itemToFind) {
        Item itemToGet = null;
        for (int i = 0; i < this.playerInventory.size(); i++) {
            if (this.playerInventory.get(i).getItemName().contains(itemToFind)) {
                itemToGet = this.playerInventory.get(i);
            }
        }
        return itemToGet;
    }

    public void eat(String itemToEat) {
        if (isItemInInventory(itemToEat)) {
            try {
                edibleItems.valueOf(itemToEat.toUpperCase());
                Item selectedItem = getItemInInventory(itemToEat);
                if (selectedItem instanceof Food) {
                    int healthToAdd = ((Food) selectedItem).getHitPoints();
                    addToCurrentHealth(healthToAdd);
                    System.out.println("You have gained " + healthToAdd + " health from eating " + itemToEat + "!");
                    // Remove eaten item from player inventory
                    removeEatenItem(selectedItem);
                    System.out.println("Your current health is now: " + getHealth());
                }
            } catch (IllegalArgumentException e) {
                System.out.println("The item " + itemToEat + " is not edible!");
            }
        } else {
            System.out.println("The item " + itemToEat + " is not in your inventory!");
        }
    }

    public void equip(String weapontoEquip) {
        if (isItemInInventory(weapontoEquip)) {
            try {
                weaponsYouCanEquip.valueOf(weapontoEquip.toUpperCase(Locale.ROOT));
                Item chosenWeapon = getItemInInventory(weapontoEquip);
                if (chosenWeapon instanceof Weapon) {
                    setEquippedWeapon(chosenWeapon);
                    System.out.println("The weapon " + getEquippedWeapon().getItemName() + " has been equipped!");
                    removeEatenItem(chosenWeapon);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("The weapon " + weapontoEquip + " is not possible to equip!");
            }

        } else {
            System.out.println("The item " + weapontoEquip + " is not in your inventory!");
        }
    }

    public int attack() {
        int damage = 0;
        if (equippedWeapon instanceof Weapon) {
            damage = ((Weapon) equippedWeapon).getDamage();
        }
        return damage;
    }

    public int takeDamage(int enemyDamage) {
        health = this.health - enemyDamage;
        return this.health;
    }

    public EnemyNPC enemyToAttack(String input, Room currentRoom) {
        EnemyNPC enemyToAttack = null;
            for (int i = 0; i < currentRoom.getEnemies().size(); i++) {
                if (currentRoom.getEnemies().get(i).getEnemyName().contains(input)) {
                    enemyToAttack = currentRoom.getEnemies().get(i);
                }
            }
        return enemyToAttack;
    }

    public void attackSequence(EnemyNPC enemyNPC) {
        if (enemyNPC != null) {
            if (((Weapon) getEquippedWeapon()).arrowsLeft() > 0) {
                int damageDoneToEnemy = attack();
                enemyNPC.takedamage(damageDoneToEnemy);
                ((Weapon) getEquippedWeapon()).arrowsLeft();
                System.out.println("You attack: " + enemyNPC.getEnemyName() + " and hit it for " + ((Weapon) getEquippedWeapon()).getDamage() + " HP");
                System.out.println("The enemy: " + enemyNPC.getEnemyName() + " now has " + enemyNPC.getEnemyHealth() + " HP left");
                if (enemyNPC.getEnemyHealth() >= 0) {
                    int damageDoneToPlayer = enemyNPC.attack();
                    takeDamage(damageDoneToPlayer);
                    System.out.println("The attacks you for: " + damageDoneToPlayer + " HP");
                    System.out.println("You now have: " + getHealth() + " HP Remaining");
                } else {
                    System.out.println("The enemy succumbs to your strength, you have won the battle adventurer!");
                    currentRoom.removeEnemyNPCfromRoom(enemyNPC.getEnemyName());
                }
            }
        } else {
            System.out.println("There is no such enemy");
        }
    }
}







