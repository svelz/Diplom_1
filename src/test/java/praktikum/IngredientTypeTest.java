package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;


public class IngredientTypeTest {

    @Test
    public void testIngredientTypeValues() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length);
        assertTrue("Contains SAUCE", contains(values, IngredientType.SAUCE));
        assertTrue("Contains FILLING", contains(values, IngredientType.FILLING));
    }

    @Test
    public void testIngredientTypeValueOf() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    private boolean contains(IngredientType[] values, IngredientType value) {
        for (IngredientType type : values) {
            if (type == value) {
                return true;
            }
        }
        return false;
    }
}
