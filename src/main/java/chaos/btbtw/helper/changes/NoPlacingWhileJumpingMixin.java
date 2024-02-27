package chaos.btbtw.helper.changes;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.util.ActionResult;


public class NoPlacingWhileJumpingMixin {
    public static void init() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            System.out.println("Placed block");
            if (player != null && !player.isOnGround()) {
                System.out.println("You Jumping fuck");
                return  ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
    }
}
