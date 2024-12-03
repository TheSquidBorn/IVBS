package io.github.thesquidborn.ivbs;

import io.github.thesquidborn.ivbs.entity.ModEntities;
import io.github.thesquidborn.ivbs.entity.custom.RoombaEntity;
import io.github.thesquidborn.ivbs.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IvysVeryBalancedStuff implements ModInitializer {
	public static final String MOD_ID = "ivbs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("WE WILL VOID WARRANTIES NOT YET WRITTEN");
		LOGGER.info("WE SHALL DRAW THE BLOOD USED TO WRITE THEM");

		ModItems.initialize();
		FabricDefaultAttributeRegistry.register(ModEntities.ROOMBA, RoombaEntity.createRoombaAttributes());
	}
}