package eiteam.esteemedinnovation.item.armor.exosuit;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import eiteam.esteemedinnovation.api.exosuit.ExosuitSlot;
import eiteam.esteemedinnovation.api.exosuit.ModelExosuitUpgrade;
import eiteam.esteemedinnovation.client.render.model.exosuit.ModelAnchors;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

import java.util.UUID;

public class ItemExosuitAnchorHeels extends ItemExosuitUpgrade {
    public ItemExosuitAnchorHeels() {
        super(ExosuitSlot.BOOTS_FEET, "", null, 0);
    }

    @Override
    public Class<? extends ModelExosuitUpgrade> getModel() {
        return ModelAnchors.class;
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiersForExosuit(EntityEquipmentSlot armorSlot, ItemStack armorPieceStack) {
        Multimap<String, AttributeModifier> map = HashMultimap.create();
        map.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getAttributeUnlocalizedName(),
          new AttributeModifier(new UUID(776437, armorSlot.getSlotIndex()), "Lead exosuit " + armorSlot.getName(),
            0.25D, 0));
        return map;
    }
}
