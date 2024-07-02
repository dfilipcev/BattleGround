package characters.heroes;

import characters.enemies.enemy.Enemy;
import characters.heroes.hero.Hero;

import java.util.concurrent.ThreadLocalRandom;

public class Archer extends Hero {

    private static final double CLEAN_SHOT_PROBABILITY = 0.15;

    public Archer(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (!isAlive()) {
            System.out.println(getName() + " is dead");
            return;
        }
        System.out.println(getName() + " attacks " + enemy.getName() + "!");
        int archerDamage = cleanShot();
        enemy.takeDamage(archerDamage);
    }

    private double cleanShotChance() {
        return ThreadLocalRandom.current().nextDouble(0.0, 1.0);
    }

    private boolean isCanShotClean() {
        return cleanShotChance() <= CLEAN_SHOT_PROBABILITY;
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isAlive()) {
            System.out.println(getName() + " is dead");
        }
    }

    private int cleanShot() {
        if (isCanShotClean()) {
            System.out.println(getName() + " has made a clean shot!");
            return getDamage() << 1;
        } else {
            return getDamage();
        }
    }

}
