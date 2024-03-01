package chaos.btbtw.items;

import chaos.btbtw.items.custom.IronChiselItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item IRON_CHISEL = new IronChiselItem(new FabricItemSettings().maxCount(1).maxDamage(20));
    public static void registerModItems(String MOD_ID) {

        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "iron_chisel"), IRON_CHISEL);
    }
}
