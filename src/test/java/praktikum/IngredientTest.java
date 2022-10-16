package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
    private IngredientType ingredientType;

    private final String ingredientTypeValue;
    private final String name;
    private final float price;

    public IngredientTest(String ingredientTypeValue, String name, float price) {
        this.ingredientTypeValue = ingredientTypeValue;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Ингридиент {0} с названием {1} и ценой {2}")
    public static Object[][] getData() {
        return new Object[][]{
                {"SAUCE", "Ketchup", 3.2f},
                {"FILLING", "cheese", 5.7f},
        };
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(ingredientType.valueOf(ingredientTypeValue),name,price);
    }

    @Test
    public void testGetName() {
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(price, ingredient.getPrice(),0);
    }

    @Test
    public void testGetType() {
        assertEquals(ingredientType.valueOf(ingredientTypeValue), ingredient.getType());
    }
}
