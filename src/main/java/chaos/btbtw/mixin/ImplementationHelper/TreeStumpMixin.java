package chaos.btbtw.mixin.ImplementationHelper;

import chaos.btbtw.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
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
			blockPlacer.placeBlock(pos, ModBlocks.TREE_STUMP_HELPER.getDefaultState());
			if (config.trunkPlacer instanceof GiantTrunkPlacer) {
				System.out.println(config.trunkProvider.get(random, pos));
				blockPlacer.placeBlock(pos.add(1,0,0), ModBlocks.TREE_STUMP_HELPER.getDefaultState());
				blockPlacer.placeBlock(pos.add(1,0,1), ModBlocks.TREE_STUMP_HELPER.getDefaultState());
				blockPlacer.placeBlock(pos.add(0,0,1), ModBlocks.TREE_STUMP_HELPER.getDefaultState());
			}
		}
	}
}