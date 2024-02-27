package chaos.btbtw.blocks.custom.blockEnities;

import chaos.btbtw.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TreeStumpHelperEntity extends BlockEntity {
    public TreeStumpHelperEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public TreeStumpHelperEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityTypes.TREE_STUMP_HELPER_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, TreeStumpHelperEntity treeStumpHelperEntity) {
        Block ceckedBlock = world.getBlockState(pos.up()).getBlock();
        if (ceckedBlock.equals(Blocks.OAK_LOG)) {
            world.setBlockState(pos, ModBlocks.TREE_STUMP_OAK.getDefaultState());
            return;
        }
        if (ceckedBlock.equals(Blocks.BIRCH_LOG)) {
            world.setBlockState(pos, ModBlocks.TREE_STUMP_BIRCH.getDefaultState());
            return;
        }
        if (ceckedBlock.equals(Blocks.SPRUCE_LOG)) {
            world.setBlockState(pos, ModBlocks.TREE_STUMP_SPRUCE.getDefaultState());
            return;
        }
        if (ceckedBlock.equals(Blocks.JUNGLE_LOG)) {
            world.setBlockState(pos, ModBlocks.TREE_STUMP_JUNGLE.getDefaultState());
            return;
        }
        if (ceckedBlock.equals(Blocks.DARK_OAK_LOG)) {
            world.setBlockState(pos, ModBlocks.TREE_STUMP_DARK_OAK.getDefaultState());
            return;
        }
        world.setBlockState(pos, Blocks.DIRT.getDefaultState());
    }
}
