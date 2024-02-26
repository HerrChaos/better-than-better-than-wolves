package chaos.btbtw;

import chaos.btbtw.blocks.ModBlocks;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterThanBetterThanWolves implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("btbtw");

	public static final String MOD_ID = "btbtw";
	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks(MOD_ID);

		LOGGER.info("Hello Fabric world!");
	}
}