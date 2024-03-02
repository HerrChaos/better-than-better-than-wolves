package chaos.btbtw.helper.changes;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.PickaxeItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.WorldEvents;
import net.minecraft.world.event.GameEvent;

public class StoneCracking {
    public static void init() {
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
            if (state.getBlock().equals(Blocks.STONE)) {
                world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 0.7f, 0.9f + world.random.nextFloat() * 0.2f);
                if (!(player.getInventory().getMainHandStack().getItem() instanceof PickaxeItem)) {
                    world.setBlockState(pos, Blocks.COBBLESTONE.getDefaultState(), Block.NOTIFY_LISTENERS);
                }
                world.emitGameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Emitter.of(state));
                world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, pos, Block.getRawIdFromState(state));
            }
        });
    }
}
