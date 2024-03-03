package chaos.btbtw;

import chaos.btbtw.blocks.ModBlocks;
import chaos.btbtw.helper.changes.EventHandler;
import chaos.btbtw.items.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterThanBetterThanWolves implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("btbtw");

	public static final String MOD_ID = "btbtw";
	@Override
	public void onInitialize() {
		ModItems.registerModItems(MOD_ID);
		ModBlocks.registerModBlocks(MOD_ID);
		EventHandler.InitAll();
		LOGGER.info("Hello Fabric world!");
		//TODO Make stone block actually drop the loose stone with sharp stick
	}
}