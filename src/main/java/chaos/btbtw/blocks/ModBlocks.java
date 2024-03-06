package chaos.btbtw.blocks;

import chaos.btbtw.BetterThanBetterThanWolves;
import chaos.btbtw.blocks.custom.ChippedTreeTrunkBlock;
import chaos.btbtw.blocks.custom.GavitieSlabBlock;
import chaos.btbtw.blocks.custom.TreeStump;
import chaos.btbtw.blocks.custom.blockEnities.ModBlockEntityTypes;
import chaos.btbtw.items.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static chaos.btbtw.BetterThanBetterThanWolves.MOD_ID;

public class ModBlocks {
    public static final Block TREE_STUMP_OAK  = new TreeStump(AbstractBlock.Settings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_BIRCH  = new TreeStump(AbstractBlock.Settings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_SPRUCE  = new TreeStump(AbstractBlock.Settings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_JUNGLE  = new TreeStump(AbstractBlock.Settings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_ACACIA  = new TreeStump(AbstractBlock.Settings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_DARK_OAK  = new TreeStump(AbstractBlock.Settings.create().burnable().dropsNothing().strength(5F, 200.0F));

    public static final Block CHIPPED_OAK_LOG = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()), Items.STONE_AXE, SoundEvents.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR);
    public static final Block CHIPPED_BIRCH_LOG = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()), null, SoundEvents.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR);
    public static final Block CHIPPED_SPRUCE_LOG = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()), null, SoundEvents.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR);
    public static final Block CHIPPED_JUNGLE_LOG = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()), null, SoundEvents.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR);
    public static final Block CHIPPED_ACACIA_LOG = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()), null, SoundEvents.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR);
    public static final Block CHIPPED_DARK_OAK_LOG = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()), null, SoundEvents.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR);

    public static final Block DIRT_SLAB = new GavitieSlabBlock(FabricBlockSettings.copyOf(Blocks.DIRT.getSettings()), ModItems.PILE_OF_DIRT);
    public static final Block GRAVEL_SLAB = new GavitieSlabBlock(FabricBlockSettings.copyOf(Blocks.GRAVEL.getSettings()), ModItems.PILE_OF_GRAVEL);
    public static final Block SAND_SLAB = new GavitieSlabBlock(FabricBlockSettings.copyOf(Blocks.SAND.getSettings()), ModItems.PILE_OF_SAND);
    private static void NewBlock(Block block, String name) {
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }
    private static void registerSlabs() {
        NewBlock(DIRT_SLAB, "dirt_slab");
        NewBlock(GRAVEL_SLAB, "gravel_slab");
        NewBlock(SAND_SLAB, "sand_slab");
    }

    private static void registerTreeStumps() {
        NewBlock(TREE_STUMP_OAK, "tree_stump_oak");
        NewBlock(TREE_STUMP_BIRCH, "tree_stump_birch");
        NewBlock(TREE_STUMP_SPRUCE, "tree_stump_spruce");
        NewBlock(TREE_STUMP_JUNGLE, "tree_stump_jungle");
        NewBlock(TREE_STUMP_ACACIA, "tree_stump_acacia");
        NewBlock(TREE_STUMP_DARK_OAK, "tree_stump_dark_oak");
    }


    private static void registerChippedTreeTrunks() {
        NewBlock(CHIPPED_OAK_LOG, "chipped_oak_log");
        NewBlock(CHIPPED_BIRCH_LOG, "chipped_birch_log");
        NewBlock(CHIPPED_SPRUCE_LOG, "chipped_spruce_log");
        NewBlock(CHIPPED_JUNGLE_LOG, "chipped_jungle_log");
        NewBlock(CHIPPED_ACACIA_LOG, "chipped_acacia_log");
        NewBlock(CHIPPED_DARK_OAK_LOG, "chipped_dark_oak_log");
    }
    public static void registerModBlocks(String MOD_ID) {
        ModBlockEntityTypes.registerModBlockEntities(MOD_ID);
        registerSlabs();
        registerTreeStumps();
        registerChippedTreeTrunks();

        BetterThanBetterThanWolves.LOGGER.info("registering modBlocks for " + MOD_ID);
    }
}
