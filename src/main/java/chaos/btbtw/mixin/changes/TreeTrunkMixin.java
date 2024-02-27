package chaos.btbtw.mixin.changes;

import chaos.btbtw.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

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
            
        }
    }
}
