package tw.iehow.howfood.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.Level;
import tw.iehow.howfood.HowFood;
import tw.iehow.howfood.item.base.BasePolymerItem;
import tw.iehow.howfood.item.base.PolymerItemRegistrar;
import tw.iehow.howfood.item.entries.DrinkEntries;

import java.util.Objects;

public class DrinkRegistrar extends PolymerItemRegistrar<DrinkEntries.Drink> {

    @Override
    protected void register(DrinkEntries.Drink drinkData) {
        Item.Properties settings = new Item.Properties()
                .stacksTo(drinkData.maxStack())
                .useCooldown(1.0f)
                .food(new FoodProperties(drinkData.nutrition(), drinkData.saturation(), false))
                .component(DataComponents.CONSUMABLE, Consumable.builder()
                        .sound(Holder.direct(drinkData.soundEvent()))
                        .build());
        registerItem(
                drinkData.name(),
                s -> new DrinkItem(drinkData.name(), s, drinkData.fallbackItem(), drinkData.nutrition(), drinkData.saturation()),
                settings
        );
    }

    public static class DrinkItem extends BasePolymerItem {
        public DrinkItem(String tooltipKey, Properties settings, Item fallbackItem, int nutrition, float saturation) {
            super(tooltipKey, settings, fallbackItem, ChatFormatting.GOLD, nutrition, saturation);
        }

        @Override
        public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity user) {
            Player playerEntity = (Player) user;
            ItemEntity item = playerEntity.drop(BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath(HowFood.MOD_ID, "bottle")).getDefaultInstance(), true);
            Objects.requireNonNull(item).setPickUpDelay(0);
            stack.shrink(1);
            return stack;
        }
    }
}