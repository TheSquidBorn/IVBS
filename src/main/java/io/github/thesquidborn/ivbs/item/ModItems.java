package io.github.thesquidborn.ivbs.item;

import io.github.thesquidborn.ivbs.IvysVeryBalancedStuff;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static Item register(Item item, String id) {
        Identifier itemID = new Identifier(IvysVeryBalancedStuff.MOD_ID, id);

        return Registry.register(Registries.ITEM, itemID, item);
    };

    public static final Item THE_BOOM_STICK = register(new BoomStickItem(ToolMaterials.WOOD, 1, 1.2f, new FabricItemSettings().rarity(Rarity.UNCOMMON)),"boom_stick");


    public static void initialize() {
    }
}
