package chaos.btbtw.blocks.custom;

import chaos.btbtw.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ChippedTreeTrunkBlock extends Block {
    public static final int MaxChip = 4;

    public static final IntProperty CHIP = IntProperty.of("chip", 1, MaxChip);
    public ChippedTreeTrunkBlock(Settings settings) {
        super(settings);
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CHIP);
    }

    private void breakOneStage(World world, BlockPos pos, BlockState state) {
        world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 0.7f, 0.9f + world.random.nextFloat() * 0.2f);
        int i = state.get(CHIP);
        if (i >= 4) {
            world.breakBlock(pos, true);
        } else {
            ItemEntity itemEntity = null;
            if (new Random().nextInt(3) == 2) {
                itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), ModItems.SAWDUST.getDefaultStack());
            } else {
                itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), Items.STICK.getDefaultStack());
            }
            world.spawnEntity(itemEntity);
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
}
