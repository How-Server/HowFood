package tw.iehow.howfood.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.ChatFormatting;
import tw.iehow.howfood.item.base.BasePolymerItem;
import tw.iehow.howfood.item.base.PolymerItemRegistrar;
import tw.iehow.howfood.item.entries.FoodEntries;

public class FoodRegistrar extends PolymerItemRegistrar<FoodEntries.Food> {

    @Override
    protected void register(FoodEntries.Food foodData) {
        Item.Properties settings = new Item.Properties()
                .stacksTo(foodData.maxStack())
                .food(new FoodProperties(foodData.nutrition(), foodData.saturation(), false));

        registerItem(
                foodData.name(),
                s -> new FoodItem(foodData.name(), s, foodData.fallbackItem(), foodData.nutrition(), foodData.saturation()),
                settings
        );
    }

    public static class FoodItem extends BasePolymerItem {
        public FoodItem(String tooltipKey, Properties settings, Item fallbackItem, int nutrition, float saturation) {
            super(tooltipKey, settings, fallbackItem, ChatFormatting.GOLD, nutrition, saturation);
        }
    }
}