package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    // choose this one if you are familiar with mocks
//    @Disabled("Test is not finished yet")
    @Test
    void damageCalculationsWithMocks() {
//        given
        Inventory inventory = mock(Inventory.class);
        Equipment equipment = mock(Equipment.class);
        when(inventory.getEquipment()).thenReturn(equipment);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);
        final Player player = new Player(inventory, stats);

//        when
        Damage damage = player.calculateDamage(target);

//        then
        assertEquals(10, damage.getAmount());
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
