package characters.heroes;

import characters.enemies.enemy.Enemy;
import characters.heroes.hero.Hero;

import java.util.concurrent.ThreadLocalRandom;

public class Warrior extends Hero {

    private static final double BERSERK_RAGE = 0.05;

    public Warrior(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (!isAlive()) {
            System.out.println(getName() + " is dead");
            return;
        }
        System.out.println(getName() + " attacks enemy!");
        int warriorDamage = berserkRage();
        enemy.takeDamage(warriorDamage);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isAlive()) {
            System.out.println(getName() + " is dead");
        }
    }

    private double berserkRageChance() {
        return ThreadLocalRandom.current().nextDouble(0.0, 1.0);
    }

    private boolean isIntoBerserkRage() {
        return berserkRageChance() <= BERSERK_RAGE;
    }

    private int berserkRage() {
        if (isIntoBerserkRage()) {
            System.out.println(getName() + " is in berserk rage!");
            takeDamage(0);
            return getDamage() << 1;
        }
        else {
            return getDamage();
        }
    }
}
