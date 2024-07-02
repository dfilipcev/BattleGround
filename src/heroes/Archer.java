package heroes;

import enemies.Enemy;

public class Archer extends Hero {

    public Archer(String name) {
        super(name);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println("Archer attacks enemy!");
        int archerDamage = 20;
        enemy.takeDamage(archerDamage);
    }
}
