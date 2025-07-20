package tw.iehow.howfood.item.entries;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class FoodEntries {
    public record Food(String name, int maxStack, int nutrition, float saturation, Item fallbackItem) {}

    public static final Food[] FOODS = new Food[] {
            new Food("sausage_pizza", 64, 8, 0.3f, Items.BREAD),
            new Food("mushroom_pizza", 64, 6, 0.3f, Items.BREAD),
            new Food("tofu_ramen", 64, 8, 0.3f, Items.BREAD),
            new Food("hotdog", 64, 6, 0.3f, Items.BREAD),
            new Food("takoyaki", 64, 6, 0.3f, Items.BREAD),
            new Food("good_cookie", 64, 6, 0.3f, Items.BREAD),
            new Food("melon_juice", 64, 6, 0.3f, Items.BREAD),
            new Food("honey_ricedumpling", 64, 6, 0.3f, Items.BREAD),
            new Food("meat_ricedumpling", 64, 8, 0.3f, Items.BREAD),
            new Food("redbeans_ricedumpling", 64, 6, 0.3f, Items.BREAD),
            new Food("salty_ricedumpling", 64, 4, 0.3f, Items.BREAD),
            new Food("sweet_ricedumpling", 64, 4, 0.3f, Items.BREAD),
    };
}