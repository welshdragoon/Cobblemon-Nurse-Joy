package welsh.cobblemonnursejoy;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import welsh.cobblemonnursejoy.util.ModCustomTrades;
import welsh.cobblemonnursejoy.villager.ModVillagers;

public class CobblemonNurseJoy implements ModInitializer {
	public static final String MOD_ID = "cobblemon-nurse-joy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModVillagers.registerVillagers();
		ModCustomTrades.registerCustomTrades();
	}
}