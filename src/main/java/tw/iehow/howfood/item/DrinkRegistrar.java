package tw.iehow.howfood.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import tw.iehow.howfood.HowFood;
import tw.iehow.howfood.item.base.BasePolymerItem;
import tw.iehow.howfood.item.base.PolymerItemRegistrar;
import tw.iehow.howfood.item.entries.DrinkEntries;

import java.util.Objects;

public class DrinkRegistrar extends PolymerItemRegistrar<DrinkEntries.Drink> {

    @Override
    protected void register(DrinkEntries.Drink drinkData) {
        Item.Settings settings = new Item.Settings()
                .maxCount(drinkData.maxStack())
                .useCooldown(1.0f)
                .food(new FoodComponent(drinkData.nutrition(), drinkData.saturation(), false))
                .component(DataComponentTypes.CONSUMABLE, ConsumableComponent.builder()
                        .sound(RegistryEntry.of(drinkData.soundEvent()))
                        .build());
        registerItem(
                drinkData.name(),
                s -> new DrinkItem(drinkData.name(), s, drinkData.fallbackItem(), drinkData.nutrition(), drinkData.saturation()),
                settings
        );
    }

    public static class DrinkItem extends BasePolymerItem {
        public DrinkItem(String tooltipKey, Settings settings, Item fallbackItem, int nutrition, float saturation) {
            super(tooltipKey, settings, fallbackItem, Formatting.GOLD, nutrition, saturation);
        }

        @Override
        public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
            PlayerEntity playerEntity = (PlayerEntity) user;
            ItemEntity item = playerEntity.dropItem(Registries.ITEM.get(Identifier.of(HowFood.MOD_ID, "bottle")).getDefaultStack(), true);
            Objects.requireNonNull(item).setPickupDelay(0);
            stack.decrement(1);
            return stack;
        }
    }
}