package minefantasy.block.special;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

/**
 *
 * @author Anonymous Productions
 * 
 * Sources are provided for educational reasons.
 * though small bits of code, or methods can be used in your own creations.
 */
public class ItemBlockForge extends ItemBlock{

    public ItemBlockForge(int id)
    {
        super(id);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        setCreativeTab(CreativeTabs.tabDecorations);
    }
    
    @Override
    public void getSubItems(int id, CreativeTabs tabs, List list)
    {
        for (int n = 0; n < 3; ++n)
        {
            list.add(new ItemStack(id, 1, n));
        }
    }

    @Override
    public int getMetadata(int damage)
    {
        return damage*2;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public EnumRarity getRarity(ItemStack item)
    {
    	if(item.getItemDamage() == 2)
    	{
    		return EnumRarity.rare;
    	}
    	return super.getRarity(item);
    }

    @Override
    public String getItemDisplayName(ItemStack itemstack)
    {
    	if(itemstack.getItemDamage() == 2)
    	{
    		return StatCollector.translateToLocal("tile.obsidian.name") + " " + StatCollector.translateToLocal("block.forge");
    	}
        return StatCollector.translateToLocal("block.forge");
    }
}
