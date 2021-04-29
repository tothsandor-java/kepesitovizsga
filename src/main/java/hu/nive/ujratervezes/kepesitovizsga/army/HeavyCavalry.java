package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {
    int attacks ;

    public HeavyCavalry() {
        hitPoints = 150;
        damage = 20;
        hasArmour = true;
        attacks = 0;
    }

    int doDamage() {
        attacks++;
        if ( attacks == 1 ) {
            return 3 * damage;
        } else {
            return damage;
        }
    }
}
