package tw.iehow.howfood.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import tw.iehow.howfood.HowFood;

import java.util.function.Function;

public abstract class PolymerItemRegistrar<T> {
    private int registeredCount = 0;

    public void initialize(Iterable<T> entries) {
        for (T entry : entries) {
            register(entry);
        }
        HowFood.LOGGER.info("{} items registered by {}.", registeredCount, this.getClass().getSimpleName());
    }

    protected abstract void register(T entry);

    protected void registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HowFood.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        ItemGroupEvents.modifyEntriesEvent(ItemsGroup.ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(item));
        registeredCount++;
    }
}