package tw.iehow.howfood.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import tw.iehow.howfood.HowFood;
import tw.iehow.howfood.utils.TooltipItem;

import java.util.function.Function;

public class FoodItems {
    public static final Item SAUSAGE_PIZZA = registerWithTooltip("sausage_pizza",
            foodSettings(64, 6, 0.3f));

    public static void initialize() {
        HowFood.LOGGER.info("HowFood has been initialized !");
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HowFood.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        ItemGroupEvents.modifyEntriesEvent(ItemsGroup.ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(item));
        return item;
    }

    public static Item registerWithTooltip(String name, Item.Settings settings) {
        return register(name, s -> new TooltipItem(s, name), settings);
    }

    public static Item.Settings foodSettings(int maxCount, int nutrition, float saturation) {
        return new Item.Settings()
            .maxCount(maxCount)
            .food(new FoodComponent.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation)
                .build());
    }
}