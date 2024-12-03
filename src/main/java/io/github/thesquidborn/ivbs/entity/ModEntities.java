package io.github.thesquidborn.ivbs.entity;

import io.github.thesquidborn.ivbs.IvysVeryBalancedStuff;
import io.github.thesquidborn.ivbs.entity.custom.RoombaEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<RoombaEntity> ROOMBA = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(IvysVeryBalancedStuff.MOD_ID, "roomba"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RoombaEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());
}
