package io.github.eternal_hell.blocks;

import com.swordglowsblue.artifice.api.Artifice;
import com.swordglowsblue.artifice.api.ArtificeResourcePack;
import io.github.eternal_hell.Moordoors;
import net.minecraft.util.Identifier;

public class ArtificeRegistrar {

	private static Identifier id(String path) {
		return new Identifier(Moordoors.MOD_ID, path);
	}

	public static void register() {
		ArtificeResourcePack resourcePack = Artifice.registerAssets("moordoors:moordoors", pack -> {
			pack.setDisplayName("Moordoors Assets");
			pack.setDescription("Assets for Moordoors");

			for (String blockId : BlockRegistrar.BLOCKS) {
				Moordoors.LOGGER.warn("block/" + blockId + " and " + id(blockId).toString());
				pack.addBlockState(id(blockId), state -> {
					state.variant("facing=east,half=lower,hinge=left,open=false", model -> model.model(id("block/" + blockId)));
					state.variant("facing=south,half=lower,hinge=left,open=false", model -> model.model(id("block/" + blockId)).rotationY(90));
					state.variant("facing=west,half=lower,hinge=left,open=false", model -> model.model(id("block/" + blockId)).rotationY(180));
				});
				pack.addBlockModel(id(blockId), model -> model
					.parent(new Identifier("block/door_bottom"))
					.texture("bottom", id("block/" + blockId + "_bottom"))
					.texture("top", id("block/" + blockId + "_top")));
				pack.addBlockModel(id(blockId), model -> model
					 .parent(new Identifier("block/door_bottom_rh"))
					 .texture("bottom", id("block/" + blockId + "_bottom"))
					 .texture("top", id("block/" + blockId + "_top")));
				pack.addBlockModel(id(blockId), model -> model
					  .parent(new Identifier("block/door_top"))
					  .texture("bottom", id("block/" + blockId + "_bottom"))
					  .texture("top", id("block/" + blockId + "_top")));
				pack.addBlockModel(id(blockId), model -> model
					  .parent(new Identifier("block/door_top_rh"))
					  .texture("bottom", id("block/" + blockId + "_bottom"))
					  .texture("top", id("block/" + blockId + "_top")));
				pack.addItemModel(id(blockId), model -> model
					  .parent(new Identifier("item/generated"))
					  .texture("layer0", id("item/" + blockId)));
			}
		});
	}
}
