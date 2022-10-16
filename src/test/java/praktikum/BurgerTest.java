package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BurgerTest {

    private Burger burger;
    private Bun bun;
    private IngredientType ingredientType;
    private Database database;
    private Ingredient ingredientFirst;
    private Ingredient ingredientSecond;

    @Before
    public void setUp() {
        this.burger = new Burger();
        this.database = new Database();
        bun = this.database.availableBuns().get(0);
        burger.setBuns(bun);
        ingredientFirst = this.database.availableIngredients().get(0);
        burger.addIngredient(ingredientFirst);
        ingredientSecond = this.database.availableIngredients().get(1);
        burger.addIngredient(ingredientSecond);
    }

    @Test
    public void testSetBunsCheckName() {
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void testSetBunsCheckPrice() {
        assertEquals(bun.getPrice(), burger.bun.getPrice(),0);
    }

    @Test
    public void testAddIngredientAmount() {
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void testAddIngredientCheckName() {
        assertEquals(ingredientFirst.getName(), burger.ingredients.get(0).getName());
    }

    @Test
    public void testAddIngredientCheckPrice() {
        assertEquals(ingredientFirst.getPrice(), burger.ingredients.get(0).getPrice(), 0);
    }

    @Test
    public void testAddIngredientCheckTypeIngredient() {
        assertEquals(ingredientFirst.getType(), burger.ingredients.get(0).getType());
    }

    @Test
    public void testRemoveIngredient() {
        burger.removeIngredient(1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredientFirst.getName(), burger.ingredients.get(0).getName());
    }

    @Test
    public void testMoveIngredient() {
        burger.moveIngredient(1,0);
        assertEquals(2, burger.ingredients.size());
        assertEquals(ingredientSecond.getName(), burger.ingredients.get(0).getName());
        assertEquals(ingredientFirst.getName(), burger.ingredients.get(1).getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(bun.getPrice()*2+ingredientFirst.getPrice()+ingredientSecond.getPrice(), burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
       assertNotEquals(-1,burger.getReceipt().indexOf("(==== "+bun.getName()+" ====)"));
       assertNotEquals(-1,burger.getReceipt().indexOf("= "+ingredientFirst.getType().toString().toLowerCase()+" " +ingredientFirst.getName() +" ="));
       assertNotEquals(-1,burger.getReceipt().indexOf("= "+ingredientSecond.getType().toString().toLowerCase()+" " +ingredientSecond.getName() +" ="));
       assertNotEquals(-1,burger.getReceipt().indexOf(String.format("Price: %f%n", burger.getPrice())));
    }
}