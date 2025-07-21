package tw.iehow.howfood.item.base;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.function.Consumer;

public abstract class BasePolymerItem extends Item implements PolymerItem {
    private final String tooltipKey;
    private final Item fallbackItem;
    private final Formatting formatting;
    private final int nutrition;
    private final float saturation;

    public BasePolymerItem(String tooltipKey, Settings settings, Item fallbackItem, Formatting formatting, int nutrition, float saturation) {
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
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
        if (nutrition > 0 && saturation > 0) {
            tooltip.accept(Text.literal("\uD83C\uDF56 ").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x9D6D43)))
                    .append(Text.literal(String.valueOf(nutrition / 2)).formatted(Formatting.GRAY))
                    .append(Text.literal(" \uD83C\uDF56 ").formatted(Formatting.DARK_GRAY))
                    .append(Text.literal((saturation / 2f) % 1 == 0 ? String.valueOf((int)(saturation / 2f)) : String.format("%.1f", saturation / 2f)).formatted(Formatting.GRAY))
            );
        }
        tooltip.accept(Text.translatable("itemTooltip.howfood." + tooltipKey).formatted(formatting));
    }
}