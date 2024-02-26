package chaos.btbtw.blocks;

import chaos.btbtw.BetterThanBetterThanWolves;
import chaos.btbtw.blocks.custom.TreeStump;
import chaos.btbtw.blocks.custom.TreeStumpHelper;
import chaos.btbtw.blocks.custom.blockEnities.ModBlockEntityTypes;
import chaos.btbtw.blocks.custom.blockEnities.TreeStumpHelperEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block TREE_STUMP  = new TreeStump(FabricBlockSettings.create());
    public static final Block TREE_STUMP_HELPER  = new TreeStumpHelper(FabricBlockSettings.create());

    public static void registerModBlocks(String MOD_ID) {
        ModBlockEntityTypes.registerModBlockEntities(MOD_ID);

        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tree_stump"), TREE_STUMP);
        Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "tree_stump_helper"), TREE_STUMP_HELPER);

        BetterThanBetterThanWolves.LOGGER.info("registering modBlocks for " + MOD_ID);
    }
}
