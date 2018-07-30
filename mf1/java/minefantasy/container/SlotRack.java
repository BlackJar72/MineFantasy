package minefantasy.container;

import minefantasy.block.tileentity.TileEntityWeaponRack;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

public class SlotRack extends Slot
{

    public SlotRack(TileEntityWeaponRack inventory, int slotNum, int x, int y)
    {
        super(inventory, slotNum, x, y);
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    @Override
    public boolean isItemValid(ItemStack item)
    {
    	return TileEntityWeaponRack.canHang(item);
    }

}
