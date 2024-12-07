package io.github.thesquidborn.ivbs.entity;

import io.github.thesquidborn.ivbs.IvysVeryBalancedStuff;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer ROOMBA =
            new EntityModelLayer(new Identifier(IvysVeryBalancedStuff.MOD_ID, "roomba"), "main");
}