package io.github.thesquidborn.ivbs.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RoombaEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public RoombaEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
        this.moveControl = new RoombaMoveControl(this);
    }

    public static DefaultAttributeContainer.Builder createRoombaAttributes() {
      return MobEntity.createMobAttributes()
              .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
              .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15f)
              .add(EntityAttributes.GENERIC_ARMOR, 1)
              .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1);
    };

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new RoombaWanderGoal(this, 1));
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}
