package chaos.btbtw.items.custom.ToolMaterials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class ChiselToolMaterial implements ToolMaterial {
    public static final ChiselToolMaterial INSTANCE = new ChiselToolMaterial();
    @Override
    public int getDurability() {
        return 20;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 1;
    }

    @Override
    public float getAttackDamage() {
        return 3;
    }

    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.IRON_NUGGET);
    }
}
