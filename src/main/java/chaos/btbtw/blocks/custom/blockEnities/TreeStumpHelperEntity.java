package chaos.btbtw.blocks.custom.blockEnities;

import chaos.btbtw.blocks.ModBlocks;
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
        if (world.getBlockState(pos.up()).getBlock().equals(Blocks.OAK_LOG)) {
            System.out.println("Block up is: "+ world.getBlockState(pos.up()).getBlock());
            System.out.println("Checking for: "+ Blocks.OAK_LOG);
            world.setBlockState(pos, ModBlocks.TREE_STUMP.getDefaultState());
            return;
        }
        world.setBlockState(pos, Blocks.DIRT.getDefaultState());
    }
}
