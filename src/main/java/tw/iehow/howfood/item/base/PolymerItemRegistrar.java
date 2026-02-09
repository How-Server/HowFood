package tw.iehow.howfood.item.base;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import tw.iehow.howfood.HowFood;
import tw.iehow.howfood.item.ItemsGroup;

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

    protected void registerItem(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(HowFood.MOD_ID, name));
        Item item = itemFactory.apply(settings.setId(itemKey));
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        ItemGroupEvents.modifyEntriesEvent(ItemsGroup.ITEM_GROUP_KEY).register(itemGroup -> itemGroup.accept(item));
        registeredCount++;
    }
}