package minefantasy.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHalfSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

/**
 *
 * @author Anonymous Productions
 * 
 * Sources are provided for educational reasons.
 * though small bits of code, or methods can be used in your own creations.
 */
public class ItemStoneSlabMF extends ItemSlab{


    public ItemStoneSlabMF(int id, BlockHalfSlab half,
			BlockHalfSlab full, boolean isFull) {
		super(id, half, full, isFull);
	}

	@Override
    public String getItemDisplayName(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();
        switch(i)
        {
            case 0:
                return StatCollector.translateToLocal("tile.cobbBrick.half");
            case 1:
                return StatCollector.translateToLocal("tile.granite.half");
            case 2:
                return StatCollector.translateToLocal("tile.granite.brick.half");
            case 3:
                return StatCollector.translateToLocal("tile.smoothstone.half");
            case 4:
                return StatCollector.translateToLocal("tile.mudBrick.half");
            case 5:
                return StatCollector.translateToLocal("tile.cobbBrick.half");
            case 6:
                return StatCollector.translateToLocal("tile.mudBrick.half");
        }
        return "Stone Slab";
    }
}
