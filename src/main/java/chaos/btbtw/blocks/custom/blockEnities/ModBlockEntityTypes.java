package chaos.btbtw.blocks.custom.blockEnities;


import chaos.btbtw.BetterThanBetterThanWolves;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static chaos.btbtw.blocks.ModBlocks.TREE_STUMP_HELPER;

public class ModBlockEntityTypes {
    public static final BlockEntityType<TreeStumpHelperEntity> TREE_STUMP_HELPER_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            new Identifier(BetterThanBetterThanWolves.MOD_ID, "tree_stump_entity_helper"),
            FabricBlockEntityTypeBuilder.create(TreeStumpHelperEntity::new, TREE_STUMP_HELPER).build()
    );

    public static void registerModBlockEntities(String MOD_ID) {
        BetterThanBetterThanWolves.LOGGER.info("Loading mod EntityTypes for " + MOD_ID);
    }
}