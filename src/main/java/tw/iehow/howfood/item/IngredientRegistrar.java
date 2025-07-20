package tw.iehow.howfood.item;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import tw.iehow.howfood.HowFood;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.function.Consumer;
import java.util.function.Function;

public class IngredientRegistrar {
    private static int registeredIngredientCount = 0;

    public static void initialize() {
        for (IngredientEntries.Ingredient ingredients : IngredientEntries.INGREDIENTS) {
            registerPolymerIngredient(ingredients);
        }
        HowFood.LOGGER.info("{} ingredient items registered.", registeredIngredientCount);
    }

    public static class PolymerIngredientItem extends Item implements PolymerItem {
        private final String tooltipKey;
        private final Item fallbackItem;

        public PolymerIngredientItem(String tooltipKey, Settings settings, Item fallbackItem) {
            super(settings);
            this.tooltipKey = tooltipKey;
            this.fallbackItem = fallbackItem;
        }

        @Override
        public Item getPolymerItem(ItemStack stack, PacketContext context) {
            return fallbackItem;
        }

        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
            tooltip.accept(Text.translatable("itemTooltip.howfood." + tooltipKey).formatted(Formatting.GRAY));
        }
    }

    public static void registerPolymerIngredient(IngredientEntries.Ingredient ingredientData) {
        Item.Settings settings = ingredientSettings(ingredientData.maxStack());
        register(ingredientData.name(), s -> new PolymerIngredientItem(ingredientData.name(), s, ingredientData.fallbackItem()), settings);
    }

    public static void register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(HowFood.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        ItemGroupEvents.modifyEntriesEvent(ItemsGroup.ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(item));
        registeredIngredientCount++;
    }

    public static Item.Settings ingredientSettings(int maxCount) {
        return new Item.Settings()
                .maxCount(maxCount);
    }
}