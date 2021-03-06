package minefantasy.api.forge;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TongsHelper 
{
	/**
	 * Determines if an item is held
	 */
	public static boolean hasHeldItem(ItemStack tongs)
	{
		NBTTagCompound nbt = getNBT(tongs);
		
		return nbt.hasKey("Held") && nbt.getBoolean("Held");
	}
	
	/**
	 * Empties the item
	 * @return 
	 */
	public static ItemStack clearHeldItem(ItemStack tongs, EntityLivingBase user)
	{
		if(!user.worldObj.isRemote)
		{
			NBTTagCompound nbt = getNBT(tongs);
			nbt.setBoolean("Held", false);
		}
		tongs.damageItem(1, user);
		
		return tongs;
	}
	
	/**
	 * Picks up an item
	 */
	public static boolean trySetHeldItem(ItemStack tongs, ItemStack item)
	{
		if(item == null || item.getItem() == null || !isHotItem(item) || item.getItem() instanceof ItemBlock)
		{
			return false;
		}
		NBTTagCompound nbt = getNBT(tongs);
		nbt.setBoolean("Held", true);
		item.writeToNBT(nbt);
		
		return true;
	}
	
	/**
	 * Used to determine if an item burns you when held, and if tongs can pick it up
	 */
	public static boolean isHotItem(ItemStack item)
	{
		if(item.getItem() instanceof IHotItem)
		{
			return ((IHotItem)item.getItem()).isHot(item);
		}
		return false;
	}
	
	/**
	 * Determines if it can be cooled in a water source
	 */
	public static boolean isCoolableItem(ItemStack item)
	{
		if(item.getItem() instanceof IHotItem)
		{
			return ((IHotItem)item.getItem()).isCoolable(item);
		}
		return false;
	}

	/**
	 * Gets the item picked up
	 */
	public static ItemStack getHeldItem(ItemStack tongs)
	{
		NBTTagCompound nbt = getNBT(tongs);
		if(nbt.hasKey("Held"))
		{
			if(nbt.getBoolean("Held"))
			{
				return ItemStack.loadItemStackFromNBT(nbt);
			}
		}
		return null;
	}
	
	
	
	
	/**
	 * Gets the item held from tongs
	 * @param tongs the itemstack used
	 */
	public static ItemStack getHeldItemTongs(ItemStack tongs)
	{
		NBTTagCompound nbt = getNBT(tongs);
		if(nbt.hasKey("Held"))
		{
			if(nbt.getBoolean("Held"))
			{
				return ItemStack.loadItemStackFromNBT(nbt);
			}
		}
		return null;
	}
	
	/**
	 * Gets a hot item
	 */
	public static ItemStack getHotItem(ItemStack item)
	{
		NBTTagCompound tag = getNBT(item);
		
		if(tag.hasKey("ingotID") && tag.hasKey("ingotMeta"))
		{
			return new ItemStack(tag.getInteger("ingotID"), 1, tag.getInteger("ingotMeta"));
		}
		
		return null;
	}
	
	/**
	 * Used for getting the NBT for itemstacks, if none exists; it creates one
	 */
	public static NBTTagCompound getNBT(ItemStack item)
	{
		if(!item.hasTagCompound())
		{
			item.setTagCompound(new NBTTagCompound());
		}
		return item.getTagCompound();
	}
}
