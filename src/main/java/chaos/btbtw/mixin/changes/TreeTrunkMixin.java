package chaos.btbtw.mixin.changes;

import chaos.btbtw.blocks.ModBlocks;
import chaos.btbtw.helper.util.CompareList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
public class TreeTrunkMixin {
    @Inject(at = @At("HEAD"), method = "afterBreak")
    public void onBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack tool, CallbackInfo ci) {
        if (!(tool.getItem() instanceof AxeItem)) {
            CompareList LogBlocks = new CompareList();
            LogBlocks.add("block.minecraft.oak_log", ModBlocks.CHIPPED_OAK_LOG, null);
            LogBlocks.add("block.minecraft.birch_log", ModBlocks.CHIPPED_BIRCH_LOG, null);
            LogBlocks.add("block.minecraft.jungle_log", ModBlocks.CHIPPED_JUNGLE_LOG, null);
            LogBlocks.add("block.minecraft.spruce_log", ModBlocks.CHIPPED_SPRUCE_LOG, null);
            LogBlocks.add("block.minecraft.acacia_log", ModBlocks.CHIPPED_ACACIA_LOG, null);
            LogBlocks.add("block.minecraft.dark_oak_log", ModBlocks.CHIPPED_DARK_OAK_LOG, null);
            if (LogBlocks.checkFor(state.getBlock().getTranslationKey()) != null) {
                world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, 0.7f, 0.9f + world.random.nextFloat() * 0.2f);
                world.setBlockState(pos, ((Block) LogBlocks.checkFor(state.getBlock().getTranslationKey())).getDefaultState());
            }
        }
    }
}
