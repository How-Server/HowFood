package tw.iehow.howfood.item;

import net.minecraft.item.Item;
import net.minecraft.util.Formatting;
import tw.iehow.howfood.item.base.BasePolymerItem;
import tw.iehow.howfood.item.base.PolymerItemRegistrar;
import tw.iehow.howfood.item.entries.IngredientEntries;

public class IngredientRegistrar extends PolymerItemRegistrar<IngredientEntries.Ingredient> {

    @Override
    protected void register(IngredientEntries.Ingredient ingredientData) {
        Item.Settings settings = new Item.Settings()
                .maxCount(ingredientData.maxStack());

        registerItem(
                ingredientData.name(),
                s -> new IngredientItem(ingredientData.name(), s, ingredientData.fallbackItem()),
                settings
        );
    }

    public static class IngredientItem extends BasePolymerItem {
        public IngredientItem(String tooltipKey, Settings settings, Item fallbackItem) {
            super(tooltipKey, settings, fallbackItem, Formatting.GRAY);
        }
    }
}