package io.github.thesquidborn.ivbs.entity.custom;

import net.minecraft.entity.ai.FuzzyTargeting;
import net.minecraft.entity.ai.goal.WanderAroundGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public class RoombaWanderGoal extends WanderAroundGoal {
    private final float probability;

    public RoombaWanderGoal(PathAwareEntity pathAwareEntity, double d) {
        this(pathAwareEntity, d, 1F);
    }

    public RoombaWanderGoal(PathAwareEntity mob, double speed, float probability) {
        super(mob, speed);
        this.probability = probability;
    }

    @Nullable
    @Override
    protected Vec3d getWanderTarget() {
        if (this.mob.isInsideWaterOrBubbleColumn()) {
            Vec3d vec3d = FuzzyTargeting.find(this.mob, 15, 0);
            return vec3d == null ? super.getWanderTarget() : vec3d;
        } else {
            return this.mob.getRandom().nextFloat() >= this.probability ? FuzzyTargeting.find(this.mob, 10, 0) : super.getWanderTarget();
        }
    }
}