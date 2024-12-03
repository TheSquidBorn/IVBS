package io.github.thesquidborn.ivbs.entity.custom;

import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeMaker;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.MathHelper;

public class RoombaMoveControl extends MoveControl {
    public RoombaMoveControl(MobEntity entity) {
        super(entity);
    }

    public void tick() {
        if (this.state == MoveControl.State.STRAFE) {
            float f = (float)this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED);
            float g = (float)this.speed * f;
            float h = this.forwardMovement;
            float i = this.sidewaysMovement;
            float j = MathHelper.sqrt(h * h + i * i);
            if (j < 1.0F) {
                j = 1.0F;
            }

            j = g / j;
            h *= j;
            i *= j;
            float k = MathHelper.sin(this.entity.getYaw() * (float) (Math.PI / 180.0));
            float l = MathHelper.cos(this.entity.getYaw() * (float) (Math.PI / 180.0));
            float m = h * l - i * k;
            float n = i * l + h * k;
            if (!this.isPosWalkable(m, n)) {
                this.forwardMovement = 1.0F;
                this.sidewaysMovement = 0.0F;
            }

            this.entity.setMovementSpeed(g);
            this.entity.setForwardSpeed(this.forwardMovement);
            this.entity.setSidewaysSpeed(this.sidewaysMovement);
            this.state = MoveControl.State.WAIT;
        } else if (this.state == MoveControl.State.MOVE_TO) {
            this.state = MoveControl.State.WAIT;
            double d = this.targetX - this.entity.getX();
            double e = this.targetZ - this.entity.getZ();
            double o = this.targetY - this.entity.getY();
            double p = d * d + o * o + e * e;
            if (p < 2.5000003E-7F) {
                this.entity.setForwardSpeed(0.0F);
                return;
            }

            float n = (float)(MathHelper.atan2(e, d) * 180.0F / (float)Math.PI) - 90.0F;
            this.entity.setYaw(this.wrapDegrees(this.entity.getYaw(), n, 90.0F));
            this.entity.setMovementSpeed((float)(this.speed * this.entity.getAttributeValue(EntityAttributes.GENERIC_MOVEMENT_SPEED)));
        }
    }

    private boolean isPosWalkable(float x, float z) {
        EntityNavigation entityNavigation = this.entity.getNavigation();
        if (entityNavigation != null) {
            PathNodeMaker pathNodeMaker = entityNavigation.getNodeMaker();
            if (pathNodeMaker != null
                    && pathNodeMaker.getDefaultNodeType(
                    this.entity.getWorld(), MathHelper.floor(this.entity.getX() + (double)x), this.entity.getBlockY(), MathHelper.floor(this.entity.getZ() + (double)z)
            )
                    != PathNodeType.WALKABLE) {
                return false;
            }
        }

        return true;
    }
}
