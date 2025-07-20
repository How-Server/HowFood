package tw.iehow.howfood.item.base;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import xyz.nucleoid.packettweaker.PacketContext;

import java.util.function.Consumer;

public abstract class BasePolymerItem extends Item implements PolymerItem {
    private final String tooltipKey;
    private final Item fallbackItem;
    private final Formatting formatting;

    public BasePolymerItem(String tooltipKey, Settings settings, Item fallbackItem, Formatting formatting) {
        super(settings);
        this.tooltipKey = tooltipKey;
        this.fallbackItem = fallbackItem;
        this.formatting = formatting;
    }

    @Override
    public Item getPolymerItem(ItemStack stack, PacketContext context) {
        return fallbackItem;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
        tooltip.accept(Text.translatable("itemTooltip.howfood." + tooltipKey).formatted(formatting));
    }
}