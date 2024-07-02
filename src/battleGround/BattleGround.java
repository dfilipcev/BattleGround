package battleGround;

import characters.enemies.Necromancer;
import characters.enemies.enemy.Enemy;
import characters.enemies.Zombie;
import characters.heroes.Archer;
import characters.heroes.hero.Hero;
import characters.heroes.Warrior;

public class BattleGround {

    public static void main(String[] args) {

        Hero warrior = new Warrior("Warrior", 120, 30);
        Enemy zombie = new Zombie("Zombie", 100, 10);

        while (true) {
            if(!zombie.isAlive() || !warrior.isAlive()) {
                break;
            } else {
                warrior.attackEnemy(zombie);
                zombie.attackHero(warrior);
            }
        }

        Hero archer = new Archer("Archer", 100, 20);
        Enemy necromancer = new Necromancer("Necromancer", 80, 20);

        while (true) {
            if(!archer.isAlive() || !necromancer.isAlive()) {
                break;
            } else {
                archer.attackEnemy(necromancer);
                necromancer.attackHero(archer);
            }
        }
    }
}
