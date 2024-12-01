package io.github.thesquidborn.ivbs.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;

public class BoomStickItem extends SwordItem {
    public BoomStickItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        settings.maxDamage(1);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.getWorld().createExplosion(null, target.getX(), target.getY(), target.getZ(), 2, true, World.ExplosionSourceType.TNT);
        attacker.addVelocity(
                -(target.getX() - attacker.getX()) * 2.2,
                -(target.getY() - attacker.getY()) * 4,
                -(target.getZ() - attacker.getZ()) * 2.2
        );
        target.addVelocity(
                -(attacker.getX() - target.getX()) * 2.2,
                -(attacker.getY() - target.getY()) * 4,
                -(attacker.getZ() - target.getZ()) * 2.2
        );
        stack.decrement(1);
        return true;
    }
}
