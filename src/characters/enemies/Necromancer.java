package characters.enemies;

import characters.enemies.enemy.Enemy;
import characters.heroes.hero.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Necromancer extends Enemy {

    private static final double SKELETONS_INVOKE_PROBABILITY = 1.0;
    private List<Skeleton> skeletons;

    public Necromancer(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void attackHero(Hero hero) {
        if (!isAlive()) {
            System.out.println(getName() + " is dead");
            return;
        }
        System.out.println(getName() + " attacks " + hero.getName());
        hero.takeDamage(getDamage());
        skeletonsInvoke();
        if (isHasSkeletons()) {
            for (Skeleton skeleton : new ArrayList<>(skeletons)) {
                if (skeleton.isAlive()) {
                    skeleton.attackHero(hero);
                }
                if (hero.isAlive()) {
                    hero.attackEnemy(skeleton);
                }
            }
        }
    }

    public List<Skeleton> getSkeletons() {
        return skeletons;
    }

    private boolean isHasSkeletons() {
        return skeletons != null && !skeletons.isEmpty();
    }

    private double skeletonsInvokeChance() {
        return ThreadLocalRandom.current().nextDouble(0.0, 1.0);
    }

    private boolean isCanInvokeSkeletons() {
        return skeletonsInvokeChance() <= SKELETONS_INVOKE_PROBABILITY;
    }

    private void skeletonsInvoke() {
        if (isCanInvokeSkeletons()) {
            if (skeletons == null) {
                skeletons = new ArrayList<>();
            }
            System.out.println(getName() + " has invoked skeleton!");
            skeletons.add(new Skeleton("Skeleton " + Skeleton.getSkeletonsCount(), 20, 15));
        }
    }

    private class Skeleton extends Enemy {

        private static int skeletonsCount = 0;

        public Skeleton(String name, int health, int damage) {
            super(name, health, damage);
            skeletonsCount += 1;
        }

        @Override
        public void attackHero(Hero hero) {
            if (!isAlive()) {
                System.out.println(getName() + " has fall apart");
                Necromancer.this.getSkeletons().remove(Skeleton.this);
                return;
            }
            System.out.println(getName() + " attacks " + hero.getName());
            hero.takeDamage(getDamage());
        }

        @Override
        public void takeDamage(int damage) {
            super.takeDamage(damage);
            if (!isAlive()) {
                System.out.println(getName() + " has fall apart");
            }
        }

        public static int getSkeletonsCount() {
            return skeletonsCount;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Skeleton skeleton = (Skeleton) obj;
            return getName().equals(skeleton.getName());
        }

        @Override
        public int hashCode() {
            int hash = 31 * getName().hashCode();
            return hash;
        }
    }
}
