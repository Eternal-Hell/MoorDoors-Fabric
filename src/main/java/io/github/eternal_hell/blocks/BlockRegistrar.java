package io.github.eternal_hell.blocks;

import io.github.eternal_hell.Moordoors;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class BlockRegistrar {

	public static ArrayList<String> BLOCKS = new ArrayList<String>();
	private static final DoorBlock BRACED_OAK_DOOR = new DefaultDoorBlock(AbstractBlock.Settings.of(Material.WOOD));

	public static void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier(Moordoors.MOD_ID, "braced_oak_door"), BRACED_OAK_DOOR);
		Registry.register(Registry.ITEM, new Identifier(Moordoors.MOD_ID, "braced_oak_door"),
			new BlockItem(BRACED_OAK_DOOR, new Item.Settings().group(Moordoors.DOOR_GROUP)));
		BLOCKS.add("braced_oak_door");
	}
}
