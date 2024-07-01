package trainingGround;

import heroes.Archer;
import heroes.Hero;
import heroes.Mage;
import heroes.Warrior;

public class TrainingGround {

    public static void main(String[] args) {

        Hero warrior = new Warrior("Warrior");
        warrior.attackEnemy();

        Hero mage = new Mage("Mage");
        mage.attackEnemy();

        Hero archer = new Archer("Archer");
        archer.attackEnemy();

    }
}