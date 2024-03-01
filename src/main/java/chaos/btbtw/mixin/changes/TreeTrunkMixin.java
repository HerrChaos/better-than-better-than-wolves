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
        LogBlocks.add("block.minecraft.oak_log", Blocks.OAK_LOG, null);
        LogBlocks.add("block.minecraft.dark_oak_log", Blocks.DARK_OAK_LOG, null);
        LogBlocks.add("block.minecraft.acacia_log", Blocks.ACACIA_LOG,null);
        LogBlocks.add("block.minecraft.birch_log", Blocks.BIRCH_LOG, null);
        LogBlocks.add("block.minecraft.jungle_log", Blocks.JUNGLE_LOG, null);
        LogBlocks.add("block.minecraft.spruce_log", Blocks.SPRUCE_LOG, null);
        if (LogBlocks.checkFor(state.getBlock().getTranslationKey()) != null) {
            System.out.println("broke loefsefgg: " + LogBlocks.checkFor(state.getBlock().getTranslationKey()));
        }
    }
}
