package io.github.eternal_hell.blocks;

import com.swordglowsblue.artifice.api.Artifice;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import io.github.eternal_hell.Moordoors;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.lang.reflect.Field;

public class ArtificeRegistrar {

	private static Identifier id(String path) {
		return new Identifier(Moordoors.MOD_ID, "block/" + path);
	}

	public static void register() {
		ArtificeResourcePack resourcePack = Artifice.registerAssets("moordoors:moordoors", pack -> {
			pack.setDisplayName("Moordoors Assets");
			pack.setDescription("Assets for Moordoors");

			Field[] fields = BlockRegistrar.class.getFields();
			for (Field field : fields) {

				try {
					Block.class.asSubclass(field.getType());
				} catch (ClassCastException e) {
					continue; // field is not of type Block or a subclass of it
				}
				try {
					field.setAccessible(true);
					Identifier identifier = Registry.BLOCK.getId((Block) field.get(null));


					pack.addBlockModel(id(identifier.getPath()), model -> model
						                                                   .parent(new Identifier("block/door_bottom"))
						                                                   .texture("bottom", id(identifier.getPath() + "_bottom"))
						                                                   .texture("top", id(identifier.getPath() + "_top")));
					pack.addBlockModel(id(identifier.getPath()), model -> model
						                                                   .parent(new Identifier("block/door_bottom_rh"))
						                                                   .texture("bottom", id(identifier.getPath() + "_bottom"))
						                                                   .texture("top", id(identifier.getPath() + "_top")));
					pack.addBlockModel(id(identifier.getPath()), model -> model
						                                                      .parent(new Identifier("block/door_top"))
						                                                      .texture("bottom", id(identifier.getPath() + "_bottom"))
						                                                      .texture("top", id(identifier.getPath() + "_top")));
					pack.addBlockModel(id(identifier.getPath()), model -> model
						                                                      .parent(new Identifier("block/door_top_rh"))
						                                                      .texture("bottom", id(identifier.getPath() + "_bottom"))
						                                                      .texture("top", id(identifier.getPath() + "_top")));
					pack.addItemModel(id(identifier.getPath()), model -> model
						.parent(id(identifier.getPath())));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					System.out.println("can't access field");
				}
			}
		});
	}
}
