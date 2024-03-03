package chaos.btbtw.items;

import chaos.btbtw.BetterThanBetterThanWolves;
import chaos.btbtw.blocks.ModBlocks;
import chaos.btbtw.items.custom.ChiselItem;
import chaos.btbtw.items.custom.ToolMaterials.ChiselToolMaterial;
import chaos.btbtw.items.custom.ToolMaterials.PointyStickToolMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static chaos.btbtw.BetterThanBetterThanWolves.MOD_ID;

public class ModItems {
    public static final Item IRON_CHISEL = new ChiselItem(ChiselToolMaterial.INSTANCE,3, 1, new FabricItemSettings().maxCount(1).maxDamage(20));
    public static final Item DIAMOND_CHISEL = new ChiselItem(ChiselToolMaterial.INSTANCE, 5, 1, new FabricItemSettings().maxCount(1).maxDamage(40));

    public static final Item BARK_OAK = new Item(new FabricItemSettings());
    public static final Item BARK_BIRCH = new Item(new FabricItemSettings());
    public static final Item BARK_SPRUCE = new Item(new FabricItemSettings());
    public static final Item BARK_JUNGLE = new Item(new FabricItemSettings());
    public static final Item BARK_ACACIA = new Item(new FabricItemSettings());
    public static final Item BARK_DARK_OAK = new Item(new FabricItemSettings());

    public static final Item SAWDUST = new Item(new FabricItemSettings());

    public static final Item POINTY_STICK = new ToolItem(PointyStickToolMaterial.INSTANCE, new FabricItemSettings().maxCount(1).maxDamage(5));
    public static final Item LOOSE_STONE = new Item(new FabricItemSettings());


    public static final Item PILE_OF_DIRT = new Item(new FabricItemSettings());
    public static final Item PILE_OF_GRAVEL = new Item(new FabricItemSettings());
    public static final Item PILE_OF_SAND = new Item(new FabricItemSettings());

    //TODO Game crashes cus some translation key stuff with block items and thees are the only ones i have

    public static final Item DIRT_SLAB = new BlockItem(ModBlocks.DIRT_SLAB, new FabricItemSettings());
    public static final Item GRAVEL_SLAB = new BlockItem(ModBlocks.GRAVEL_SLAB, new FabricItemSettings());
    public static final Item SAND_SLAB = new BlockItem(ModBlocks.SAND_SLAB, new FabricItemSettings());

    private static void newItem(Item block, String name) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), block);
    }
    private static void newFuelItem(Item block, String name, int burnTimeInSec) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), block);
        FuelRegistry.INSTANCE.add(block, burnTimeInSec * 20);
    }

    private static void registerBarkItems() {
        newFuelItem(BARK_OAK, "bark_oak", 2);
        newFuelItem(BARK_BIRCH, "bark_birch", 2);
        newFuelItem(BARK_SPRUCE, "bark_spruce", 2);
        newFuelItem(BARK_JUNGLE, "bark_jungle", 2);
        newFuelItem(BARK_ACACIA, "bark_acacia", 2);
        newFuelItem(BARK_DARK_OAK, "bark_dark_oak", 2);
    }


    private static void registerPileAndSlabsItems() {
        newItem(PILE_OF_DIRT, "pile_of_dirt");
        newItem(PILE_OF_GRAVEL, "pile_of_gravel");
        newItem(PILE_OF_SAND, "pile_of_sand");

        newItem(DIRT_SLAB, "dirt_slab");
        newItem(GRAVEL_SLAB, "gravel_slab");
        newItem(SAND_SLAB, "sand_slab");

    }
    public static void registerModItems(String MOD_ID) {
        BetterThanBetterThanWolves.LOGGER.info("Registering mod Items for " + MOD_ID);

        registerBarkItems();
        registerPileAndSlabsItems();

        newFuelItem(SAWDUST, "sawdust", 1);

        newItem(IRON_CHISEL, "iron_chisel");
        newItem(DIAMOND_CHISEL, "diamond_chisel");
        newItem(POINTY_STICK, "pointy_stick");
        newItem(LOOSE_STONE, "loose_stone");
    }
}
