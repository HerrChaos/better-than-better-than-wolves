package chaos.btbtw.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class MultieBreakBlock extends Block {
    private PlayerEntity LastTuchingPlayer;
    private final Item requiredTool;
    private final SoundEvent breakSound;
    public MultieBreakBlock(Settings settings,@Nullable Item tool, @Nullable SoundEvent soundEvents) {
        super(settings);
        breakSound = soundEvents;
        this.requiredTool = tool;
    }
    public static final int MaxChip = 4;
    public static final IntProperty CHIP = IntProperty.of("chip", 1, MaxChip);

    private boolean canBeBroken = true;

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(CHIP);
    }

    public void breakOneStage(WorldAccess world, BlockPos pos, BlockState state) {
        if (this.requiredTool != null && this.LastTuchingPlayer != null && this.LastTuchingPlayer.getInventory().getMainHandStack().getItem() == this.requiredTool) {
            return;
        }

        if (this.requiredTool == null) {
            int i = state.get(CHIP);
            //checks if we exceeded the limit of chip cus if yes we crash
            if (i >= MaxChip) return;

            //IDFK sets new block n shit
            world.setBlockState(pos, state.with(CHIP, i + 1), Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(state));
            world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, pos, Block.getRawIdFromState(state));
        }
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (this.breakSound != null) {
            world.playSound(null, pos, this.breakSound, SoundCategory.BLOCKS, 0.7f, 0.9f + new Random().nextFloat() * 0.2f);
        }
        if (state.get(CHIP) < MaxChip) {
            this.breakOneStage(world,pos,state);
            this.canBeBroken = false;
            return;
        }
        super.onBroken(world, pos, state);
    }

    @Override
    public float calcBlockBreakingDelta(BlockState state, PlayerEntity player, BlockView world, BlockPos pos) {
        this.LastTuchingPlayer = player;
        //breaking normally
        if (this.canBeBroken) {
            return super.calcBlockBreakingDelta(state,player,world,pos);
        }
        //stop breaking for seamless transition
        this.canBeBroken = true;
        return 0;
    }
}
