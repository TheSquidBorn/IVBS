package io.github.thesquidborn.ivbs.entity.roomba.client;

import io.github.thesquidborn.ivbs.IvysVeryBalancedStuff;
import io.github.thesquidborn.ivbs.entity.ModModelLayers;
import io.github.thesquidborn.ivbs.entity.roomba.RoombaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class RoombaRendrer extends MobEntityRenderer<RoombaEntity, RoombaModel<RoombaEntity>> {
    private static final Identifier TEXTURE = new Identifier(IvysVeryBalancedStuff.MOD_ID, "textures/entity/roomba.png");

    public RoombaRendrer(EntityRendererFactory.Context context) {
        super(context, new RoombaModel<>(context.getPart(ModModelLayers.ROOMBA)), 0.4f);
    }

    @Override
    public Identifier getTexture(RoombaEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(RoombaEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider,int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
