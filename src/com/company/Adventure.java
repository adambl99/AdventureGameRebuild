package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Adventure {
    Scanner input = new Scanner(System.in);
    Map map = new Map();
    static Player player = new Player();
    Room room = new Room("");
    Room startRoom;
    static Room currentRoom;

    public Adventure() {
        map.createMap();
        startRoom = map.getStartRoom();
        System.out.println(map.getStartRoom());
        currentRoom = startRoom;
    }

    public void gamePlay() {
        System.out.println("Welcome to Tomb Ascendeance, try to locate the Pharaohs tomb");
        System.out.println("There are 8 rooms in the tomb, maybe the rooms even contains items and artifacts");
        System.out.println("To move between the rooms, type commands like so:" +
                "\nNorth: 'go north'\nSouth: 'go south'\nEast: 'go east'\nWest: 'go west'\nYou can also type shortened versions such as: n, s, e, w");
        System.out.println("Good luck, and don't get lost in the darkness.\n");
        System.out.println(currentRoom);
        player.setHealth(100);


        while (true) {
            String direction = input.next().trim().toLowerCase(Locale.ROOT);
            if (player.getHealth() <= 0) {
                System.out.println("You are dead, better luck next time..");
                System.exit(0);
            }
            switch (direction) {
                case "north", "go north", "n":
                    if (currentRoom.getNorth() == null) {
                        System.out.println("This pathway seems to be blocked");
                    } else {
                        currentRoom = currentRoom.getNorth();
                        System.out.println(currentRoom);
                    }
                    break;

                case "south", "go south", "s":
                    if (currentRoom.getSouth() == null) {
                        System.out.println("This pathway is blocked");
                    } else {
                        currentRoom = currentRoom.getSouth();
                        System.out.println(currentRoom);
                    }
                    break;

                case "west", "go west", "w":
                    if (currentRoom.getWest() == null) {
                        System.out.println("This pathway seems to be blocked");
                    } else {
                        currentRoom = currentRoom.getWest();
                        System.out.println(currentRoom);
                    }
                    break;

                case "east", "go east", "e":
                    if (currentRoom.getEast() == null) {
                        System.out.println("This pathway seems to be blocked");
                    } else {
                        currentRoom = currentRoom.getEast();
                        System.out.println(currentRoom);
                    }
                    break;

                case "look":
                    System.out.println(currentRoom);
                    room.getInventory();
                    room.getEnemies();
                    break;

                case "help":
                    System.out.println("List of commands:\nNorth: 'go north'\nSouth: 'go south'\nEast: 'go east'" +
                            "\nWest: 'go west'\nTake item: 'take'\nDrop item: 'drop'\nCheck inventory: 'inventory'");
                    break;

                case "exit":
                    System.out.println("Thanks for playing! :D");
                    System.exit(0);
                    break;

                case "inventory":
                    player.getPlayerInventory();
                    break;

                case "take":
                    String itemToPickUp = input.next();
                    player.takeItem(currentRoom, itemToPickUp);
                    break;

                case "drop":
                    String itemToDrop = input.next();
                    player.dropItem(currentRoom, itemToDrop);
                    break;

                case "health":
                    int playerHitpoints = player.getHealth();
                    System.out.println("Your HP is: " + playerHitpoints);
                    System.out.println(player.health());
                    break;
                case "eat":
                    String itemToEat = input.next().trim().toLowerCase(Locale.ROOT);
                    if (itemToEat.length() > 0) {
                        player.eat(itemToEat);
                    }
                    break;
                case "equip":
                    String itemToEquip = input.next().trim().toLowerCase(Locale.ROOT);
                    if (itemToEquip.length() > 0) {
                        player.equip(itemToEquip);
                    }
                    break;

                case "attack":
                    EnemyNPC enemyToAttack = player.enemyToAttack(input.next().trim().toLowerCase(Locale.ROOT), currentRoom);
                    if (currentRoom.getEnemies().size() == 0) {
                        System.out.println("There are no enemies to attack in this room");
                    } else if (enemyToAttack != null && currentRoom.getEnemies().size() >= 1) {
                        if (((Weapon) player.getEquippedWeapon()).arrowsLeft() > 0) {
                            int damageDoneToEnemy = player.attack();
                            enemyToAttack.takedamage(damageDoneToEnemy);
                            ((Weapon) player.getEquippedWeapon()).arrowsLeft();
                            System.out.println("You attack: " + enemyToAttack.getEnemyName() + " and hit it for " + ((Weapon) player.getEquippedWeapon()).getDamage() + " HP");
                            System.out.println("The enemy: " + enemyToAttack.getEnemyName() + " now has " + enemyToAttack.getEnemyHealth() + " HP left");
                            if (enemyToAttack.getEnemyHealth() >= 0) {
                                int damageDoneToPlayer = enemyToAttack.attack();
                                player.takeDamage(damageDoneToPlayer);
                                System.out.println("The " + enemyToAttack.getEnemyName() + "attacks you for: " + damageDoneToPlayer + " HP");
                                System.out.println("You now have: " + player.getHealth() + " HP Remaining");
                            } else {
                                System.out.println("The enemy succumbs to your strength, you have won the battle adventurer!");
                                currentRoom.removeEnemyNPCfromRoom(enemyToAttack.getEnemyName());
                            }
                        }
                    }
                    break;
            }
        }
    }
}











