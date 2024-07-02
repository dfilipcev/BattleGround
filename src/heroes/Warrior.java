package heroes;

import enemies.Enemy;

public class Warrior extends Hero {

    public Warrior(String name) {
        super(name);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        System.out.println("Warrior attacks enemy!");
        int warriorDamage = 30;
        enemy.takeDamage(warriorDamage);
    }
}
