package chaos.btbtw.helper.changes;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.util.ActionResult;


public class NoPlacingWhileJumping {
    public static void init() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            if (player != null && !player.isOnGround()) {
                return  ActionResult.FAIL;
            }
            return ActionResult.PASS;
        });
    }
}
