package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {
    boolean hasShield;

    public Swordsman(boolean hasArmour) {
        hitPoints = 100;
        damage = 10;
        this.hasArmour = hasArmour;
        hasShield = true;
    }

    void sufferDamage(int damage) {
        if ( hasShield ) {
            hasShield = false;
        } else {
            super.sufferDamage(damage);
        }
    }
}
