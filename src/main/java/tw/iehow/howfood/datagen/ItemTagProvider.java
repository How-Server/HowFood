package tw.iehow.howfood.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.Identifier;
import tw.iehow.howfood.HowFood;
import tw.iehow.howfood.item.entries.DrinkEntries;
import tw.iehow.howfood.item.entries.FoodEntries;
import tw.iehow.howfood.item.entries.IngredientEntries;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public static final TagKey<Item> HOWFOOD_TAG = TagKey.create(net.minecraft.core.registries.Registries.ITEM, Identifier.fromNamespaceAndPath(HowFood.MOD_ID, "howfood"));
    public static final TagKey<Item> FOODS_TAG = TagKey.create(net.minecraft.core.registries.Registries.ITEM, Identifier.fromNamespaceAndPath(HowFood.MOD_ID, "foods"));
    public static final TagKey<Item> DRINKS_TAG = TagKey.create(net.minecraft.core.registries.Registries.ITEM, Identifier.fromNamespaceAndPath(HowFood.MOD_ID, "drinks"));
    public static final TagKey<Item> INGREDIENTS_TAG = TagKey.create(net.minecraft.core.registries.Registries.ITEM, Identifier.fromNamespaceAndPath(HowFood.MOD_ID, "ingredients"));

    public ItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        var howFoodBuilder = getOrCreateRawBuilder(HOWFOOD_TAG);

        // category tags
        var foodBuilder = getOrCreateRawBuilder(FOODS_TAG);
        var drinksBuilder = getOrCreateRawBuilder(DRINKS_TAG);
        var ingredientsBuilder = getOrCreateRawBuilder(INGREDIENTS_TAG);

        // fabric convention tags
        var foodsBuilder = getOrCreateRawBuilder(ConventionalItemTags.FOODS);

        for (FoodEntries.Food food : FoodEntries.FOODS) {
            Identifier id = Identifier.fromNamespaceAndPath(HowFood.MOD_ID, food.name());
            howFoodBuilder.addElement(id);
            foodBuilder.addElement(id);
            foodsBuilder.addElement(id);
        }

        for (DrinkEntries.Drink drink : DrinkEntries.DRINKS) {
            Identifier id = Identifier.fromNamespaceAndPath(HowFood.MOD_ID, drink.name());
            howFoodBuilder.addElement(id);
            drinksBuilder.addElement(id);
            foodsBuilder.addElement(id);
        }

        for (IngredientEntries.Ingredient ingredient : IngredientEntries.INGREDIENTS) {
            Identifier id = Identifier.fromNamespaceAndPath(HowFood.MOD_ID, ingredient.name());
            howFoodBuilder.addElement(id);
            ingredientsBuilder.addElement(id);
        }
    }
}
