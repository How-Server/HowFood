package tw.iehow.howfood.item.entries;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class IngredientEntries {
    public record Ingredient(String name, int maxStack, Item fallbackItem) {}

    public static final Ingredient[] INGREDIENTS = new Ingredient[] {
            new Ingredient("bottle", 64, Items.BREAD),
            new Ingredient("plastic", 64, Items.BREAD),
            new Ingredient("brown_sugar", 64, Items.BREAD),

            new Ingredient("lye_water", 64, Items.BREAD),
            new Ingredient("salt", 64, Items.BREAD),
    };
}