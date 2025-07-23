package tw.iehow.howfood.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import tw.iehow.howfood.HowFood;
import tw.iehow.howfood.item.entries.DrinkEntries;
import tw.iehow.howfood.item.entries.FoodEntries;
import tw.iehow.howfood.item.entries.IngredientEntries;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public static final TagKey<Item> HOWFOOD_TAG = TagKey.of(net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(HowFood.MOD_ID, "howfood"));
    public static final TagKey<Item> FOODS_TAG = TagKey.of(net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(HowFood.MOD_ID, "foods"));
    public static final TagKey<Item> DRINKS_TAG = TagKey.of(net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(HowFood.MOD_ID, "drinks"));
    public static final TagKey<Item> INGREDIENTS_TAG = TagKey.of(net.minecraft.registry.RegistryKeys.ITEM, Identifier.of(HowFood.MOD_ID, "ingredients"));

    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        var howFoodBuilder = getTagBuilder(HOWFOOD_TAG);

        // category tags
        var foodBuilder = getTagBuilder(FOODS_TAG);
        var drinksBuilder = getTagBuilder(DRINKS_TAG);
        var ingredientsBuilder = getTagBuilder(INGREDIENTS_TAG);

        // fabric convention tags
        var foodsBuilder = getTagBuilder(ConventionalItemTags.FOODS);

        for (FoodEntries.Food food : FoodEntries.FOODS) {
            Identifier id = Identifier.of(HowFood.MOD_ID, food.name());
            howFoodBuilder.add(id);
            foodBuilder.add(id);
            foodsBuilder.add(id);
        }

        for (DrinkEntries.Drink drink : DrinkEntries.DRINKS) {
            Identifier id = Identifier.of(HowFood.MOD_ID, drink.name());
            howFoodBuilder.add(id);
            drinksBuilder.add(id);
            foodsBuilder.add(id);
        }

        for (IngredientEntries.Ingredient ingredient : IngredientEntries.INGREDIENTS) {
            Identifier id = Identifier.of(HowFood.MOD_ID, ingredient.name());
            howFoodBuilder.add(id);
            ingredientsBuilder.add(id);
        }
    }
}
