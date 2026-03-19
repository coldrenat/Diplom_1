package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient ingredientTwo;

    @Before
    public void setUp() {
        burger = new Burger();
        when(bun.getName()).thenReturn("Black Bun");
        when(bun.getPrice()).thenReturn(100.0f);
        when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient.getName()).thenReturn("Ketchup");
        when(ingredient.getPrice()).thenReturn(50.0f);
        when(ingredientTwo.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientTwo.getName()).thenReturn("Beef");
        when(ingredientTwo.getPrice()).thenReturn(200.0f);
    }

    @Test
    public void setBunsSetsTheBun() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientIncreasesListSize() {
        burger.addIngredient(ingredient);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void addIngredientAddsCorrectIngredient() {
        burger.addIngredient(ingredient);
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test
    public void removeIngredientMakesListEmpty() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientChangesOrder() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(0, 1);
        assertEquals(ingredientTwo, burger.ingredients.get(0));
    }

    @Test
    public void getPriceWithOneIngredientReturnsCorrectValue() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertEquals(250.0f, burger.getPrice(), 0.01f);
    }

    @Test
    public void getPriceWithTwoIngredientsReturnsCorrectValue() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientTwo);
        assertEquals(450.0f, burger.getPrice(), 0.01f);
    }

    @Test
    public void getReceiptContainsBunName() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertTrue(burger.getReceipt().contains("Black Bun"));
    }

    @Test
    public void getReceiptContainsIngredientName() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertTrue(burger.getReceipt().contains("Ketchup"));
    }

    @Test
    public void getReceiptContainsIngredientType() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertTrue(burger.getReceipt().contains("sauce"));
    }

    @Test
    public void getReceiptContainsPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        assertTrue(burger.getReceipt().contains("250"));
    }
}