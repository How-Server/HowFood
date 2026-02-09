package tw.iehow.howfood.item.entries;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

public class DrinkEntries {
    public record Drink(String name, int maxStack, int nutrition, float saturation, SoundEvent soundEvent, Item fallbackItem) {}

    public static final Drink[] DRINKS = new Drink[] {
            // saturation = nutrition * 3.0f
            new Drink("water", 64, 2, 6.0f, SoundEvents.GENERIC_DRINK.value(), Items.BREAD),
            new Drink("milktea", 64, 4, 12.0f, SoundEvents.HONEY_DRINK.value(), Items.BREAD),
            new Drink("bubble_milktea", 64, 6, 18.0f, SoundEvents.HONEY_DRINK.value(), Items.BREAD),
    };
}