package tw.iehow.howfood.item.entries;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class IngredientEntries {
    public record Ingredient(String name, int maxStack, Item fallbackItem) {}

    public static final Ingredient[] INGREDIENTS = new Ingredient[] {
            new Ingredient("empty_bottle", 64, Items.BREAD)
    };
}