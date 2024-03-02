package chaos.btbtw.blocks;

import chaos.btbtw.BetterThanBetterThanWolves;
import chaos.btbtw.blocks.custom.ChippedTreeTrunkBlock;
import chaos.btbtw.blocks.custom.TreeStump;
import chaos.btbtw.blocks.custom.TreeStumpHelper;
import chaos.btbtw.blocks.custom.blockEnities.ModBlockEntityTypes;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static chaos.btbtw.BetterThanBetterThanWolves.MOD_ID;

public class ModBlocks {
    public static final Block TREE_STUMP_OAK  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_BIRCH  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_SPRUCE  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_JUNGLE  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_ACACIA  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_DARK_OAK  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_HELPER  = new TreeStumpHelper(FabricBlockSettings.create());

    public static final Block CHIPPED_OAK_STUMP  = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()));
    public static final Block CHIPPED_BIRCH_STUMP  = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()));
    public static final Block CHIPPED_SPRUCE_STUMP  = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()));
    public static final Block CHIPPED_JUNGLE_STUMP  = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()));
    public static final Block CHIPPED_ACACIA_STUMP  = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()));
    public static final Block CHIPPED_DARK_OAK_STUMP  = new ChippedTreeTrunkBlock(FabricBlockSettings.create().strength(Blocks.OAK_LOG.getHardness(), Blocks.OAK_LOG.getBlastResistance()));
    public static final Block DIRT_SLAB = new SlabBlock(Blocks.DIRT.getSettings());
    private static void NewBlock(Block block, String name) {
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }

    private static void registerTreeStumps() {
        NewBlock(TREE_STUMP_OAK, "tree_stump_oak");
        NewBlock(TREE_STUMP_BIRCH, "tree_stump_birch");
        NewBlock(TREE_STUMP_SPRUCE, "tree_stump_spruce");
        NewBlock(TREE_STUMP_JUNGLE, "tree_stump_jungle");
        NewBlock(TREE_STUMP_ACACIA, "tree_stump_acacia");
        NewBlock(TREE_STUMP_DARK_OAK, "tree_stump_dark_oak");
        NewBlock(TREE_STUMP_HELPER, "tree_stump_helper");
    }


    private static void registerChippedTreeTrunks() {
        NewBlock(CHIPPED_OAK_STUMP, "chipped_oak_stump");
        NewBlock(CHIPPED_BIRCH_STUMP, "chipped_birch_stump");
        NewBlock(CHIPPED_SPRUCE_STUMP, "chipped_spruce_stump");
        NewBlock(CHIPPED_JUNGLE_STUMP, "chipped_jungle_stump");
        NewBlock(CHIPPED_ACACIA_STUMP, "chipped_acacia_stump");
        NewBlock(CHIPPED_DARK_OAK_STUMP, "chipped_dark_oak_stump");
    }
    public static void registerModBlocks(String MOD_ID) {
        ModBlockEntityTypes.registerModBlockEntities(MOD_ID);
        registerTreeStumps();
        registerChippedTreeTrunks();
        NewBlock(DIRT_SLAB, "dirt_slab");

        BetterThanBetterThanWolves.LOGGER.info("registering modBlocks for " + MOD_ID);
    }
}
