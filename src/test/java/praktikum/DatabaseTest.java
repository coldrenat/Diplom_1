package praktikum;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DatabaseTest {

    private Database database;

    @Before
    public void setUp() {
        database = new Database();
    }

    @Test
    public void availableBunsReturnsThreeBuns() {
        List<Bun> buns = database.availableBuns();
        assertEquals(3, buns.size());
    }

    @Test
    public void availableBunsFirstBunHasCorrectName() {
        assertEquals("black bun", database.availableBuns().get(0).getName());
    }

    @Test
    public void availableBunsFirstBunHasCorrectPrice() {
        assertEquals(100, database.availableBuns().get(0).getPrice(), 0);
    }

    @Test
    public void availableIngredientsReturnsSixIngredients() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(6, ingredients.size());
    }

    @Test
    public void availableIngredientsFirstIsSauce() {
        assertEquals(IngredientType.SAUCE, database.availableIngredients().get(0).getType());
    }

    @Test
    public void availableIngredientsLastIsFilling() {
        assertEquals(IngredientType.FILLING, database.availableIngredients().get(5).getType());
    }
}
