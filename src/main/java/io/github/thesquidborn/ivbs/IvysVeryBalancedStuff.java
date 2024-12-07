package io.github.thesquidborn.ivbs;

import eu.midnightdust.lib.config.MidnightConfig;
import io.github.thesquidborn.ivbs.entity.ModEntities;
import io.github.thesquidborn.ivbs.entity.roomba.RoombaEntity;
import io.github.thesquidborn.ivbs.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.recipe.CraftingRecipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IvysVeryBalancedStuff implements ModInitializer {
	public static final String MOD_ID = "ivbs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting IVBS");
		LOGGER.info("Prepare to void some warranties!");

		MidnightConfig.init(MOD_ID, IVBSConfig.class);

		ModItems.initialize();

		FabricDefaultAttributeRegistry.register(ModEntities.ROOMBA, RoombaEntity.createRoombaAttributes());
	}
}