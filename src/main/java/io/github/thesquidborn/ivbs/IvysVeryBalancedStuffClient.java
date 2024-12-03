package io.github.thesquidborn.ivbs;

import io.github.thesquidborn.ivbs.entity.ModEntities;
import io.github.thesquidborn.ivbs.entity.client.ModModelLayers;
import io.github.thesquidborn.ivbs.entity.client.RoombaModel;
import io.github.thesquidborn.ivbs.entity.client.RoombaRendrer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class IvysVeryBalancedStuffClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.ROOMBA, RoombaRendrer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ROOMBA, RoombaModel::getTexturedModelData);

    }
}
