package chaos.btbtw.mixin.changes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

@Mixin(Block.class)
public class TreeTrunkMixin {
    @Inject(at = @At("TAIL"), method = "afterBreak")
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool, CallbackInfo ci) {
        List<Block> LogBlocks = new ArrayList<>();
        LogBlocks.add(Blocks.OAK_LOG);
        LogBlocks.add(Blocks.DARK_OAK_LOG);
        LogBlocks.add(Blocks.ACACIA_LOG);
        LogBlocks.add(Blocks.BIRCH_LOG);
        LogBlocks.add(Blocks.JUNGLE_LOG);
        LogBlocks.add(Blocks.SPRUCE_LOG);
        if (LogBlocks.contains(state.getBlock())) {
            System.out.println("broke log");
        }
    }
}
