package com.company;

public class EnemyNPC {
    private String enemyName;
    private String enemyDescription;
    private Weapon weapon;
    private int hitpoints;
    public Room currentRoom;

    public EnemyNPC(String enemyName, String enemyDescription, int hitpoints, Weapon weapon){
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.weapon = weapon;
        this.hitpoints = hitpoints;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    public int getEnemyHealth(){
        return hitpoints;
    }
    public int takedamage(int playerDamage){
        this.hitpoints = this.hitpoints - playerDamage;
        return this.hitpoints;
    }
    public int attack(){
        return weapon.getDamage();
    }

    @Override
    public String toString(){
        return "Enemy: " + enemyName + ", " + enemyDescription + "\nHP: " + hitpoints + "\nWeapon equipped: " + weapon;

}


}
