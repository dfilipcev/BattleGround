package characters.heroes;

import characters.enemies.enemy.Enemy;
import characters.heroes.hero.Hero;

import java.util.concurrent.ThreadLocalRandom;

public class Mage extends Hero {

    private static final double SELF_HEALING_PROBABILITY = 0.1;
    private final int initialHealth;

    public Mage(String name, int health, int damage) {
        super(name, health, damage);
        initialHealth = health;
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (!isAlive()) {
            System.out.println(getName() + " is dead");
            return;
        }
        System.out.println(getName() + " attacks enemy!");
        enemy.takeDamage(getDamage());
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isAlive()) {
            System.out.println(getName() + " is dead");
            return;
        }
        selfHealing();
    }

    private double selfHealingChance() {
        return ThreadLocalRandom.current().nextDouble(0.0, 1.0);
    }

    private boolean isCanSelfHeal() {
        return selfHealingChance() <= SELF_HEALING_PROBABILITY;
    }

    private void selfHealing() {
        if (isCanSelfHeal()) {
            setHealth(initialHealth);
            System.out.println(getHealth() + " is healing himself!");
        }
    }
}
