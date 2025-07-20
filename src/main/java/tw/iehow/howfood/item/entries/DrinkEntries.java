package tw.iehow.howfood.item.entries;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class DrinkEntries {
    public record Drink(String name, int maxStack, int nutrition, float saturation, SoundEvent soundEvent, Item fallbackItem) {}

    public static final Drink[] DRINKS = new Drink[] {
            new Drink("water", 64, 1, 0.1f, SoundEvents.ENTITY_GENERIC_DRINK.value(), Items.BREAD),
            new Drink("milktea", 64, 3, 0.2f, SoundEvents.ITEM_HONEY_BOTTLE_DRINK.value(), Items.BREAD),
            new Drink("bubble_milktea", 64, 6, 0.3f, SoundEvents.ITEM_HONEY_BOTTLE_DRINK.value(), Items.BREAD),
    };
}