package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("black bun", 100);
    }

    @Test
    public void testGetName() {
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(100, bun.getPrice(), 0.01f);
    }

    @Test
    public void testWhiteBun() {
        Bun whiteBun = new Bun("white bun", 200);
        assertEquals("white bun", whiteBun.getName());
        assertEquals(200, whiteBun.getPrice(), 0.01f);
    }

    @Test
    public void testRedBun() {
        Bun redBun = new Bun("red bun", 300);
        assertEquals("red bun", redBun.getName());
        assertEquals(300, redBun.getPrice(), 0.01f);
    }

    @RunWith(Parameterized.class)
    public static class BunParameterizedTest {

        private final String name;
        private final float price;

        public BunParameterizedTest(String name, float price) {
            this.name = name;
            this.price = price;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"black bun", 100},
                    {"white bun", 200},
                    {"red bun", 300}
            });
        }

        @Test
        public void testBunCreation() {
            Bun bun = new Bun(name, price);
            assertEquals(name, bun.getName());
            assertEquals(price, bun.getPrice(), 0.01f);
        }
    }
}
