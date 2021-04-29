package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {
    int hitPoints;
    int damage;
    boolean hasArmour;

    int doDamage() {
        return damage;
    }

    void sufferDamage(int damage) {
        if (hasArmour) {
            hitPoints -= damage / 2;
        } else {
            hitPoints -= damage;
        }
    }

    int getHitPoints() {
        return hitPoints;
    }
}
