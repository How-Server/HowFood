package tw.iehow.howfood.item.entries;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class FoodEntries {
    public record Food(String name, int maxStack, int nutrition, float saturation, Item fallbackItem) {}

    public static final Food[] FOODS = new Food[] {
            new Food("sausage_pizza", 64, 8, 0.3f, Items.BREAD),
            new Food("mushroom_pizza", 64, 6, 0.3f, Items.BREAD)
    };
}