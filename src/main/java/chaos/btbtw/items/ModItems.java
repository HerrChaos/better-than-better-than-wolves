package chaos.btbtw.items;

import chaos.btbtw.items.custom.IronChiselItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static chaos.btbtw.BetterThanBetterThanWolves.MOD_ID;

public class ModItems {
    public static final Item IRON_CHISEL = new IronChiselItem(new FabricItemSettings().maxCount(1).maxDamage(20));
    public static final Item BARK_OAK = new Item(new FabricItemSettings());
    private static void newItem(Item block, String name) {
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), block);
    }
    public static void registerModItems(String MOD_ID) {
        System.out.println("Registering mod Items for " + MOD_ID);
        FuelRegistry.INSTANCE.add(BARK_OAK, 2*20);
        newItem(BARK_OAK, "bark_oak");
        newItem(IRON_CHISEL, "iron_chisel");
    }
}
