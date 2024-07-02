package heroes;

import enemies.Enemy;

public class Mage extends Hero {

    public Mage(String name) {
        super(name);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println("Mage attacks enemy!");
        int mageDamage = 10;
        enemy.takeDamage(mageDamage);
    }
}
