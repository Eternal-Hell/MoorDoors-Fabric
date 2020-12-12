package io.github.eternal_hell;

import com.swordglowsblue.artifice.api.Artifice;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import io.github.eternal_hell.blocks.ArtificeRegistrar;
import io.github.eternal_hell.blocks.BlockRegistrar;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Moordoors implements ModInitializer {

	public static Logger LOGGER = LogManager.getLogger();
	public static String VERSION = "0.0.1";
	public static String MOD_ID = "moordoors";

	public static final ItemGroup DOOR_GROUP = FabricItemGroupBuilder.create(
		new Identifier(MOD_ID, "door_group"))
		                                            .icon(() -> new ItemStack(Items.OAK_DOOR))
		                                            .build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Moordoors v" + VERSION + " Thank you for using our mods! :D");
		LOGGER.info("Registering blocks");
		BlockRegistrar.registerBlocks();
		ArtificeRegistrar.register();
		LOGGER.info("Moordoors has loaded successfully!");
	}
}
