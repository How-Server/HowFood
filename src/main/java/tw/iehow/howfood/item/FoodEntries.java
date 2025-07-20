package tw.iehow.howfood.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class FoodEntries {
    public record ModFood(String name, int maxStack, int nutrition, float saturation, Item fallbackItem) {}

    public static final ModFood[] FOODS = new ModFood[] {
            new ModFood("sausage_pizza", 64, 8, 0.3f, Items.BREAD),
            new ModFood("mushroom_pizza", 64, 6, 0.3f, Items.BREAD)
    };
}