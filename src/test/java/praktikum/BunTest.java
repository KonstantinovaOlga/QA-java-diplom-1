package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BunTest {

    private Bun bun;
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Булочка {0} стоит {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"Ржаная", 100.5f},
                {"С кунжутом", 50.25f},
        };
    }

    @Before
    public void setUp() {
        this.bun = new Bun(name, price);
    }

    @Test
    public void testGetName() {
        assertEquals(name, this.bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(price, this.bun.getPrice(),0);
    }
}