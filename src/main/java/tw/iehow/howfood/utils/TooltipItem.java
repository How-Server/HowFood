package tw.iehow.howfood.utils;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.function.Consumer;

public class TooltipItem extends Item {
    private final String tooltipKey;
    public TooltipItem(Settings settings, String tooltipKey) {
        super(settings);
        this.tooltipKey = tooltipKey;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
        tooltip.accept(Text.translatable("itemTooltip.howfood." + tooltipKey).formatted(Formatting.GOLD));
    }
}