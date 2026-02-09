package tw.iehow.howfood.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.ChatFormatting;
import tw.iehow.howfood.item.base.BasePolymerItem;
import tw.iehow.howfood.item.base.PolymerItemRegistrar;
import tw.iehow.howfood.item.entries.IngredientEntries;

public class IngredientRegistrar extends PolymerItemRegistrar<IngredientEntries.Ingredient> {

    @Override
    protected void register(IngredientEntries.Ingredient ingredientData) {
        Item.Properties settings = new Item.Properties()
                .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
                .stacksTo(ingredientData.maxStack());

        registerItem(
                ingredientData.name(),
                s -> new IngredientItem(ingredientData.name(), s, ingredientData.fallbackItem()),
                settings
        );
    }

    public static class IngredientItem extends BasePolymerItem {
        public IngredientItem(String tooltipKey, Properties settings, Item fallbackItem) {
            super(tooltipKey, settings, fallbackItem, ChatFormatting.GRAY, 0, 0);
        }
    }
}