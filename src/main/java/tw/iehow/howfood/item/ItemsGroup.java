package tw.iehow.howfood.item;

import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import tw.iehow.howfood.HowFood;

public class ItemsGroup {
    public static final ResourceKey<CreativeModeTab> ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(HowFood.MOD_ID, "item_group"));
    public static final CreativeModeTab ITEM_GROUP = PolymerItemGroupUtils.builder()
            .icon(() -> new ItemStack(BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath(HowFood.MOD_ID, "sausage_pizza"))))
            .title(Component.translatable("itemGroup.howfood"))
            .build();

    public static void build() {
        PolymerItemGroupUtils.registerPolymerItemGroup(ITEM_GROUP_KEY, ITEM_GROUP);
    }
}