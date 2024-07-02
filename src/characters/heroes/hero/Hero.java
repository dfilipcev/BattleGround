package characters.heroes.hero;

import characters.enemies.enemy.Enemy;
import characters.properties.mortal.Mortal;

public abstract class Hero implements Mortal {

    private String name;
    private int health;
    private int damage;

    public Hero(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public abstract void attackEnemy(Enemy enemy);

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
