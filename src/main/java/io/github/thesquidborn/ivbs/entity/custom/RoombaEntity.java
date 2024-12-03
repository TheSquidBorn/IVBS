package io.github.thesquidborn.ivbs.entity.custom;

import io.github.thesquidborn.ivbs.item.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.InventoryOwner;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RoombaEntity extends AnimalEntity implements InventoryOwner {
    private final SimpleInventory inventory = new SimpleInventory(7);
    private int time;

    // Entity Creation
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
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new RoombaWanderGoal(this, 1));
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    // Inventory
    @Override
    protected void dropInventory() {
        super.dropInventory();

        if (this.inventory != null) {
            for (int i = 0; i < this.inventory.size(); i++) {
                ItemStack itemStack = this.inventory.getStack(i);
                if (!itemStack.isEmpty() && !EnchantmentHelper.hasVanishingCurse(itemStack)) {
                    this.dropStack(itemStack);
                }
            }
        }
    }

    @Override
    public void mobTick() {
        time++;
        super.mobTick();

        if(time >= 20) {
            time = 0;
            Box box = new Box(this.getX() + 1, this.getY() + 1, this.getZ() + 1, this.getX() - 1, this.getY() - 1, this.getZ() - 1);
            List<ItemEntity> itemArray = this.getWorld().getEntitiesByType(EntityType.ITEM, box, Entity::isOnGround);

            if(!itemArray.isEmpty()) {
                InventoryOwner.pickUpItem(this, this, itemArray.get(0));
            }
        }
    }

    // pick up
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        this.dropInventory();
        this.dropItem(ModItems.ROOMBA);
        this.discard();
        return ActionResult.PASS;
    }

    // Sounds
    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CAT_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DOLPHIN_DEATH;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        this.writeInventory(nbt);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.readInventory(nbt);
    }

    @Override
    public SimpleInventory getInventory() {
        return this.inventory;
    }
}