package chaos.btbtw.mixin.ImplementationHelper;

import chaos.btbtw.blocks.ModBlocks;
import chaos.btbtw.helper.util.CompareList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.DarkOakTrunkPlacer;
import net.minecraft.world.gen.trunk.GiantTrunkPlacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.BiConsumer;

@Mixin(TreeFeature.class)
public abstract class TreeStumpMixin {
	@Inject(at = @At("RETURN"), method = "generate(Lnet/minecraft/world/StructureWorldAccess;Lnet/minecraft/util/math/random/Random;Lnet/minecraft/util/math/BlockPos;Ljava/util/function/BiConsumer;Ljava/util/function/BiConsumer;Lnet/minecraft/world/gen/foliage/FoliagePlacer$BlockPlacer;Lnet/minecraft/world/gen/feature/TreeFeatureConfig;)Z")
	public void generate(StructureWorldAccess world, Random random, BlockPos pos, BiConsumer<BlockPos, BlockState> rootPlacerReplacer, BiConsumer<BlockPos, BlockState> trunkPlacerReplacer, FoliagePlacer.BlockPlacer blockPlacer, TreeFeatureConfig config, CallbackInfoReturnable<Boolean> cir) {
		if (cir.getReturnValue()) {
			CompareList LogBlocks = new CompareList();
			LogBlocks.add("block.minecraft.oak_log", ModBlocks.TREE_STUMP_OAK, null);
			LogBlocks.add("block.minecraft.birch_log", ModBlocks.TREE_STUMP_BIRCH, null);
			LogBlocks.add("block.minecraft.jungle_log", ModBlocks.TREE_STUMP_JUNGLE, null);
			LogBlocks.add("block.minecraft.spruce_log", ModBlocks.TREE_STUMP_SPRUCE, null);
			LogBlocks.add("block.minecraft.acacia_log", ModBlocks.TREE_STUMP_ACACIA, null);
			LogBlocks.add("block.minecraft.dark_oak_log", ModBlocks.TREE_STUMP_DARK_OAK, null);
			//if (config.trunkProvider.get(random, pos.up()).getBlock() == config.trunkProvider.get(random, pos).getBlock()) {
				blockPlacer.placeBlock(pos, ((Block) LogBlocks.checkFor(config.trunkProvider.get(random, pos).getBlock().getTranslationKey())).getDefaultState());
				if ((config.trunkPlacer instanceof GiantTrunkPlacer) || (config.trunkPlacer instanceof DarkOakTrunkPlacer)) {
					blockPlacer.placeBlock(pos.add(1, 0, 0), ((Block) LogBlocks.checkFor(config.trunkProvider.get(random, pos).getBlock().getTranslationKey())).getDefaultState());
					blockPlacer.placeBlock(pos.add(1, 0, 1), ((Block) LogBlocks.checkFor(config.trunkProvider.get(random, pos).getBlock().getTranslationKey())).getDefaultState());
					blockPlacer.placeBlock(pos.add(0, 0, 1), ((Block) LogBlocks.checkFor(config.trunkProvider.get(random, pos).getBlock().getTranslationKey())).getDefaultState());
				}
			//}
		}
	}
}