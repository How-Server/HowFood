package tw.iehow.howfood;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tw.iehow.howfood.item.*;
import tw.iehow.howfood.item.entries.DrinkEntries;
import tw.iehow.howfood.item.entries.FoodEntries;
import tw.iehow.howfood.item.entries.IngredientEntries;

import java.util.List;

public class HowFood implements ModInitializer {
	public static final String MOD_ID = "howfood";
	public static final Logger LOGGER = LoggerFactory.getLogger("HowFood");

	@Override
	public void onInitialize() {
		ItemsGroup.build();
		new FoodRegistrar().initialize(List.of(FoodEntries.FOODS));
		new DrinkRegistrar().initialize(List.of(DrinkEntries.DRINKS));
		new IngredientRegistrar().initialize(List.of(IngredientEntries.INGREDIENTS));
		PolymerResourcePackUtils.markAsRequired();
		PolymerResourcePackUtils.addModAssets(HowFood.MOD_ID);
		LOGGER.info("HowFood has been initialized!");
	}
}