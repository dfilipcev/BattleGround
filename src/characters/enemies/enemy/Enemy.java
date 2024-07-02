package characters.enemies.enemy;

import characters.heroes.hero.Hero;
import characters.properties.mortal.Mortal;

public abstract class Enemy implements Mortal {

    private String name;
    private int health;
    private int damage;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
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

    public void takeDamage(int damage) {
        health -= damage;
    }

    public abstract void attackHero(Hero hero);

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
