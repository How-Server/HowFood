package tw.iehow.howfood.item.base;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.ChatFormatting;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.function.Consumer;

public abstract class BasePolymerItem extends Item implements PolymerItem {
    private final String tooltipKey;
    private final Item fallbackItem;
    private final ChatFormatting formatting;
    private final int nutrition;
    private final float saturation;

    public BasePolymerItem(String tooltipKey, Properties settings, Item fallbackItem, ChatFormatting formatting, int nutrition, float saturation) {
        super(settings);
        this.tooltipKey = tooltipKey;
        this.fallbackItem = fallbackItem;
        this.formatting = formatting;
        this.nutrition = nutrition;
        this.saturation = saturation;
    }

    @Override
    public Item getPolymerItem(ItemStack stack, PacketContext context) {
        return fallbackItem;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay displayComponent, Consumer<Component> tooltip, TooltipFlag type) {
        if (nutrition > 0 && saturation > 0) {
            tooltip.accept(Component.literal("\uD83C\uDF56 ").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x9D6D43)))
                    .append(Component.literal(String.valueOf(nutrition / 2)).withStyle(ChatFormatting.GRAY))
                    .append(Component.literal(" \uD83C\uDF56 ").withStyle(ChatFormatting.DARK_GRAY))
                    .append(Component.literal((saturation / 2f) % 1 == 0 ? String.valueOf((int)(saturation / 2f)) : String.format("%.1f", saturation / 2f)).withStyle(ChatFormatting.GRAY))
            );
        }
        tooltip.accept(Component.translatable("itemTooltip.howfood." + tooltipKey).withStyle(formatting));
    }
}