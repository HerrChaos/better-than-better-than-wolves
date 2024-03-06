package chaos.btbtw.blocks.custom;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class ChippedTreeTrunkBlock extends MultieBreakBlock implements Waterloggable {
    public static final int MaxChip = 4;

    public static final BooleanProperty UP = Properties.UP;
    public static final BooleanProperty BOTTOM = Properties.BOTTOM;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public ChippedTreeTrunkBlock(Settings settings, @Nullable Item tool, @Nullable SoundEvent soundEvents) {
        super(settings, tool, soundEvents);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(CHIP, 1).with(BOTTOM, true).with(UP, true));
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(UP);
        builder.add(BOTTOM);
        builder.add(WATERLOGGED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);
    }

    @Override
    public void breakOneStage(WorldAccess world, BlockPos pos, BlockState state) {
        if (world.getBlockState(pos.up()).getBlock().equals(Blocks.AIR)) {
            state = state.with(UP, false);
        }
        if (world.getBlockState(pos.down()).getBlock().equals(Blocks.AIR)) {
            state = state.with(BOTTOM, false);
        }
        super.breakOneStage(world,pos,state);
    }


    // idk what any of this following does, but it looks good ay?

    @Override
    public boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return !state.get(WATERLOGGED);
    }
    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED)) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }
    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
