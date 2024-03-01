package chaos.btbtw.blocks.custom;

import chaos.btbtw.items.custom.ChiselItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class TreeStump extends CraftingTableBlock {
    public static final int MaxTable = 3;

    public static final IntProperty TABLE = IntProperty.of("table", 1, MaxTable);
    public TreeStump(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(TABLE, 1));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TABLE);
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(TABLE) == 3) {
            return super.onUse(state, world, pos, player, hand, hit);
        }
        return ActionResult.PASS;
    }

    private void breakOneStage(World world, BlockPos pos, BlockState state) {
        world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 0.7f, 0.9f + world.random.nextFloat() * 0.2f);
        int i = state.get(TABLE);
        if (i >= 3) {
            world.breakBlock(pos, false);
        } else {
            world.setBlockState(pos, state.with(TABLE, i + 1), Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(state));
            world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, pos, Block.getRawIdFromState(state));
        }
    }
    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.afterBreak(world, player, pos, state, blockEntity, tool);
        this.breakOneStage(world, pos, state);
    }


    @Override
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
        if (player.getInventory().getMainHandStack().getItem() instanceof ChiselItem && state.get(TABLE) != 3) {
            return super.calcBlockBreakingDelta(state,player,world,pos);
        }
        return 0;
    }
}
