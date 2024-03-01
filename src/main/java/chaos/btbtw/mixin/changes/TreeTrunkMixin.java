package chaos.btbtw.mixin.changes;

import chaos.btbtw.helper.util.CompareList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class TreeTrunkMixin {
    @Inject(at = @At("TAIL"), method = "onBreak")
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfoReturnable<BlockState> cir) {
        CompareList LogBlocks = new CompareList();
        LogBlocks.add("oak_log", Blocks.OAK_LOG, 1);
        LogBlocks.add("dark_oak_log", Blocks.DARK_OAK_LOG, 2);
        LogBlocks.add("acacia_log", Blocks.ACACIA_LOG,3);
        LogBlocks.add("birch_log", Blocks.BIRCH_LOG, 4);
        LogBlocks.add("jungle_log", Blocks.JUNGLE_LOG, 5);
        LogBlocks.add("spruce_log", Blocks.SPRUCE_LOG, 6);
        System.out.println("broke log: " + state.getBlock().toString());
        if (LogBlocks.checkFor(state.getBlock().toString()) != null) {
            System.out.println("broke log: " + LogBlocks.checkFor(state.getBlock().toString()));
        }
    }
}
