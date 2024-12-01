package io.github.thesquidborn.ivbs;

import io.github.thesquidborn.ivbs.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IvysVeryBalancedStuff implements ModInitializer {
	public static final String MOD_ID = "ivbs";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("WE BOUTTA VOID WARRANTIES NOT YET WRITTEN");
		LOGGER.info("WE WILL DRAW THE BLOOD USED TO WRITE THEM");

		ModItems.initialize();
	}
}