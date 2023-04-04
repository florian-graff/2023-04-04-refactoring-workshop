package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    // choose this one if you are familiar with mocks
//    @Disabled("Test is not finished yet")
    @Test
    void damageCalculationsWithMocks() {
//        given

        Item rightHand = new BasicItem("flashy sword of danger", 10, 1.0F);
        Item leftHand = new BasicItem("round shield", 0, 1.4F);
        Item feet = new BasicItem("ten league boots", 0, 0.1F);
        Item head = new BasicItem("helmet of swiftness", 0, 1.2F);
        Item chest = new BasicItem("breastplate of steel", 0, 1.4F);
        Equipment equipment = new Equipment(leftHand, rightHand, head, feet, chest);

        Inventory inventory = new Inventory(equipment);



        Armor armor = new SimpleArmor(1);
        Buff buff1 = new BasicBuff(1, 1);
        Buff buff2 = new BasicBuff(2, 2);
        List<Buff> buffs = new ArrayList<>();
        buffs.add(buff1);
        buffs.add(buff2);
        SimpleEnemy target = new SimpleEnemy(armor, buffs);

        Stats stats = new Stats(1);
        final Player player = new Player(inventory, stats);

//        when
        Damage damage = player.calculateDamage(target);

//        then
        assertEquals(48, damage.getAmount());
    }

    // choose this one if you are not familiar with mocks
//    @Disabled("Test is not finished yet")
    @Test
    void damageCalculations() {
        Inventory inventory = new Inventory(null);
        Stats stats = new Stats(0);
        SimpleEnemy target = new SimpleEnemy(null, null);
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }
}
