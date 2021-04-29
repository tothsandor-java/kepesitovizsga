package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.Iterator;

public class Army {
    ArrayList<MilitaryUnit> units = new ArrayList<>();

    void addUnit(MilitaryUnit militaryUnit) {
        units.add(militaryUnit);
    }

    void  damageAll(int damage) {
        Iterator<MilitaryUnit> it = units.iterator();
        while (it.hasNext()) {
            MilitaryUnit u = it.next();
            u.sufferDamage(damage);
            if (u.getHitPoints() < 25) {
                it.remove();
            }
        }
    }

    int getArmyDamage() {
        int sum = 0;
        for (MilitaryUnit u: units) {
            sum += u.doDamage();
        }
        return sum;
    }

    int getArmySize() {
        return units.size();
    }
}
