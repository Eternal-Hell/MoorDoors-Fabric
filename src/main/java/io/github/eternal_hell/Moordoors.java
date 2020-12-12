package io.github.eternal_hell;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Moordoors implements ModInitializer {

	public static Logger LOGGER = LogManager.getLogger();
	public static String VERSION = "0.0.1";
	public static String MOD_ID = "moordoors";

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Thank you for using our mods! :D");
	}
}
