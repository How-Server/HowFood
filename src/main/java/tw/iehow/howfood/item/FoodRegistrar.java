package tw.iehow.howfood.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.Formatting;
import tw.iehow.howfood.item.base.BasePolymerItem;
import tw.iehow.howfood.item.base.PolymerItemRegistrar;
import tw.iehow.howfood.item.entries.FoodEntries;

public class FoodRegistrar extends PolymerItemRegistrar<FoodEntries.Food> {

    @Override
    protected void register(FoodEntries.Food foodData) {
        Item.Settings settings = new Item.Settings()
                .maxCount(foodData.maxStack())
                .food(new FoodComponent.Builder()
                        .nutrition(foodData.nutrition())
                        .saturationModifier(foodData.saturation())
                        .build());

        registerItem(
                foodData.name(),
                s -> new FoodItem(foodData.name(), s, foodData.fallbackItem()),
                settings
        );
    }

    public static class FoodItem extends BasePolymerItem {
        public FoodItem(String tooltipKey, Settings settings, Item fallbackItem) {
            super(tooltipKey, settings, fallbackItem, Formatting.GOLD);
        }
    }
}