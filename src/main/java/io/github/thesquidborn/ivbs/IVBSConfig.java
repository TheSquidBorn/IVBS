package io.github.thesquidborn.ivbs;

import eu.midnightdust.lib.config.MidnightConfig;

public class IVBSConfig extends MidnightConfig {
    public static final String ENTITIES = "entities";
    public static final String ITEMS = "items";

    // @Comment(category = ENTITIES) public static Comment entities;

    @Entry
    public static boolean enableRoomba = true;

    // @Comment(category = ITEMS) public static Comment items;

    @Entry
    public static boolean enableBoomstick = true;
}
