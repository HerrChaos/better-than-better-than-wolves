package chaos.btbtw.blocks;

import chaos.btbtw.BetterThanBetterThanWolves;
import chaos.btbtw.blocks.custom.TreeStump;
import chaos.btbtw.blocks.custom.TreeStumpHelper;
import chaos.btbtw.blocks.custom.blockEnities.ModBlockEntityTypes;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block TREE_STUMP  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_OAK  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_BIRCH  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_SPRUCE  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_JUNGLE  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_DARK_OAK  = new TreeStump(FabricBlockSettings.create().burnable().dropsNothing().strength(5F, 200.0F));
    public static final Block TREE_STUMP_HELPER  = new TreeStumpHelper(FabricBlockSettings.create());

    public static void registerModBlocks(String MOD_ID) {
        ModBlockEntityTypes.registerModBlockEntities(MOD_ID);

        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tree_stump"), TREE_STUMP);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tree_stump_oak"), TREE_STUMP_OAK);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tree_stump_birch"), TREE_STUMP_BIRCH);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tree_stump_spruce"), TREE_STUMP_SPRUCE);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tree_stump_jungle"), TREE_STUMP_JUNGLE);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tree_stump_dark_oak"), TREE_STUMP_DARK_OAK);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tree_stump_helper"), TREE_STUMP_HELPER);

        BetterThanBetterThanWolves.LOGGER.info("registering modBlocks for " + MOD_ID);
    }
}
