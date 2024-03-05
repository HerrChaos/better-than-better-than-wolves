package chaos.btbtw.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class ChippedTreeTrunkBlock extends Block implements Waterloggable {
    public static final int MaxChip = 4;

    public static final IntProperty CHIP = IntProperty.of("chip", 1, MaxChip);
    public static final BooleanProperty UP = Properties.UP;
    public static final BooleanProperty BOTTOM = Properties.BOTTOM;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public ChippedTreeTrunkBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(CHIP, 1).with(BOTTOM, true).with(UP, true));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CHIP);
        builder.add(UP);
        builder.add(BOTTOM);
        builder.add(WATERLOGGED);
    }

    private void breakOneStage(World world, BlockPos pos, BlockState state) {
        world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 0.7f, 0.9f + world.random.nextFloat() * 0.2f);
        int i = state.get(CHIP);
        if (i >= MaxChip) {
            world.breakBlock(pos, true);
        } else {
            world.setBlockState(pos, state.with(CHIP, i + 1), Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(state));
            world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, pos, Block.getRawIdFromState(state));
        }
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        this.breakOneStage(world, pos, state);
        super.afterBreak(world, player, pos, state, blockEntity, tool);
    }
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
