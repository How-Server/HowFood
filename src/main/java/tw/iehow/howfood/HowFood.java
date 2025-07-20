package tw.iehow.howfood;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tw.iehow.howfood.item.ItemsGroup;
import tw.iehow.howfood.item.FoodItems;

public class HowFood implements ModInitializer {
	public static final String MOD_ID = "howfood";
	public static final Logger LOGGER = LoggerFactory.getLogger("HowFood");

	@Override
	public void onInitialize() {
		ItemsGroup.build();
		FoodItems.initialize();
		PolymerResourcePackUtils.markAsRequired();
		PolymerResourcePackUtils.addModAssets(HowFood.MOD_ID);
		LOGGER.info("HowFood has been initialized!");
	}
}