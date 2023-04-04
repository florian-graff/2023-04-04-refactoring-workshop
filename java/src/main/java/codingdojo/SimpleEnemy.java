package codingdojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleEnemy extends Target {

    private Armor armor;
    private List<Buff> buffs;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    public int getDamageSoak() {
       return this.armor.getDamageSoak();
    }

    public int getSoak() {
            return Math.round(
                    getDamageSoak() *
                            (
                                    ((float) getBuffs()
                                            .stream()
                                            .mapToDouble(Buff::soakModifier)
                                            .sum()) +
                                            1f
                            )
            );
    }

    List<Buff> getBuffs() {
        return buffs;
    }

    Armor getArmor() {
        return this.armor;
    }
}
