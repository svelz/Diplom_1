package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    @Mock
    private Ingredient mockIngredient;

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300}
        });
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockIngredient.getType()).thenReturn(type);
        when(mockIngredient.getName()).thenReturn(name);
        when(mockIngredient.getPrice()).thenReturn(price);
    }

    @Test
    public void testGetType() {
        assertEquals(type, mockIngredient.getType());
    }

    @Test
    public void testGetName() {
        assertEquals(name, mockIngredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(price, mockIngredient.getPrice(), 0.01f);
    }
}
