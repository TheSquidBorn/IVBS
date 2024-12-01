package io.github.thesquidborn.ivbs.item;

import io.github.thesquidborn.ivbs.IvysVeryBalancedStuff;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static Item register(Item item, String id) {
        Identifier itemID = new Identifier(IvysVeryBalancedStuff.MOD_ID, id);

        return Registry.register(Registries.ITEM, itemID, item);
    }

    // "Tools"
    public static final Item THE_BOOM_STICK = register(
            new BoomStickItem(ToolMaterials.WOOD, 1, 1.2f, new FabricItemSettings().rarity(Rarity.UNCOMMON)),
            "boom_stick");

    // Create creative item tab
    public static final RegistryKey<ItemGroup> IVBS_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(IvysVeryBalancedStuff.MOD_ID,"item_group"));
    public static final ItemGroup IVBS_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.THE_BOOM_STICK))
            .displayName(Text.translatable("itemGroup.ivbs"))
            .build();

    public static void initialize() {
        // Register items in creative item tab
        Registry.register(Registries.ITEM_GROUP, IVBS_ITEM_GROUP_KEY, IVBS_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(IVBS_ITEM_GROUP_KEY).register(itemGroup -> itemGroup.add(ModItems.THE_BOOM_STICK));
    }
}
