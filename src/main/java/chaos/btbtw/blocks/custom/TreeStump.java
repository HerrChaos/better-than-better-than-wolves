package chaos.btbtw.blocks.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TreeStump extends CraftingTableBlock {
    public static final int MaxTable = 3;

    public int Table = 0;

    public TreeStump(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        super.onUse(state, world, pos, player, hand, hit);
        return super.onUse(state, world, pos, player, hand, hit);
        /*
        if (this.Table == 3) {
            return super.onUse(state, world, pos, player, hand, hit);
        }
        return ActionResult.PASS;

         */
    }
}
