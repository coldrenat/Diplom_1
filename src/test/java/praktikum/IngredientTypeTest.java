package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeHasSauceValue() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void ingredientTypeHasFillingValue() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

    @Test
    public void ingredientTypeHasTwoValues() {
        assertEquals(2, IngredientType.values().length);
    }
}
