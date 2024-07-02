package characters.enemies;

import characters.abilities.resurrected.Resurrected;
import characters.enemies.enemy.Enemy;
import characters.heroes.hero.Hero;

import java.util.concurrent.ThreadLocalRandom;

public class Zombie extends Enemy implements Resurrected {

    private static final double RESURRECTION_PROBABILITY = 0.1;
    private final int initialHealth;
    private boolean hasDied;

    public Zombie(String name, int health, int damage) {
        super(name, health, damage);
        initialHealth = health;
        hasDied = false;
    }

    @Override
    public void attackHero(Hero hero) {
        if (!isAlive()) {
            return;
        }
        System.out.println(getName() + " attacks " + hero.getName());
        hero.takeDamage(getDamage());
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isAlive() && !hasDied) {
            System.out.println(getName() + " has died");
            hasDied = true;
            resurrect();
        }
    }

    private double resurrectChance() {
        return ThreadLocalRandom.current().nextDouble(0.0, 1.0);
    }

    private boolean isCanResurrect() {
        return resurrectChance() <= RESURRECTION_PROBABILITY;
    }

    @Override
    public void resurrect() {
        if (isCanResurrect()) {
            setHealth(initialHealth);
            hasDied = false;
            System.out.println(getName() + " has resurrected!");
        } else if (hasDied){
            System.out.println(getName() + " is finally died!");
        }
    }

}
