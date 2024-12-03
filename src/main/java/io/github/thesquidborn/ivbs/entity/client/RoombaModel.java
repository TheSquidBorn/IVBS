package io.github.thesquidborn.ivbs.entity.client;

import io.github.thesquidborn.ivbs.entity.animation.ModAnimations;
import io.github.thesquidborn.ivbs.entity.custom.RoombaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class RoombaModel<T extends RoombaEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bone2;
	private final ModelPart head;

	public RoombaModel(ModelPart root) {
		this.head = root.getChild("head");
		this.bone2 = root.getChild("bone2");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bone = modelPartData.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -3.0F, -6.0F, 12.0F, 3.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData bone2 = modelPartData.addChild("bone2", ModelPartBuilder.create().uv(0, 15).cuboid(-1.0F, 0.0F, -4.0F, 2.0F, 0.0F, 8.0F, new Dilation(0.01F)), ModelTransform.pivot(0.0F, 24.0F, -6.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(RoombaEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		bone2.yaw = -animationProgress;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
		bone2.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return head;
	}
}