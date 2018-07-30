package minefantasy.system;

import java.util.Iterator;
import java.util.Random;

import minefantasy.MineFantasyBase;
import minefantasy.api.MineFantasyAPI;
import minefantasy.api.anvil.ITongs;
import minefantasy.api.arrow.ISpecialBow;
import minefantasy.api.forge.TongsHelper;
import minefantasy.api.weapon.EnumWeaponType;
import minefantasy.api.weapon.WeaponClass;
import minefantasy.block.BlockListMF;
import minefantasy.block.BlockSaplingMF;
import minefantasy.entity.EntityArrowMF;
import minefantasy.item.ItemBloom;
import minefantasy.item.ItemHotItem;
import minefantasy.item.ItemListMF;
import minefantasy.item.ToolMaterialMedieval;
import minefantasy.item.weapon.ItemBowMF;
import minefantasy.item.weapon.ItemWeaponMF;
import mods.battlegear2.api.PlayerEventChild.QuiverArrowEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import cpw.mods.fml.common.FMLLog;

public class EventManagerMF 
{
	
	public static String nonTendon[] = {"MoCEntityEnt"}; 
	
	@ForgeSubscribe
	public void entityDrop(LivingDropsEvent event)
	{
		Class enClass = event.entityLiving.getClass();
		String name = "";
		if(enClass != null && EntityList.classToStringMapping.get(enClass) != null)
		{
			name = (String) EntityList.classToStringMapping.get(enClass);
			
		}
		
		if(event.entityLiving instanceof EntityAnimal && cfg.hardcoreCraft)
		{
						boolean primitive = false;
			if(event.source != null && event.source.getEntity() != null && event.source.getEntity() instanceof EntityPlayer)
			{
				primitive = isPrimitive(((EntityPlayer)event.source.getEntity()).getHeldItem());
			}
			
			Random rand = event.entityLiving.getRNG();
			if(primitive)
			{
				for(String ent : nonTendon)
				{
					if (enClass.getName().endsWith(ent)){
						break;
					}else{
						for(int a = 0; a < 1 + rand.nextInt(4); a ++){
							event.entityLiving.entityDropItem(new ItemStack(ItemListMF.misc, 1, ItemListMF.tendon), 1.0F);
						}
					}
				}
			}
		}
		EntityLivingBase dropper = event.entityLiving;

		for(EntityItem item : event.drops)
		{
			if(item.getEntityItem().isItemEqual(new ItemStack(Item.leather)))
			{	
				item.setDead();
			
						if(name.equals("EntityHorse")||enClass.getName().endsWith("GaiaCentaur")||enClass.getName().endsWith("MoCEntityHorse")|| enClass.getName().endsWith("MoCEntityHorseMob"))
						{
							dropHide(event.lootingLevel, ItemListMF.hideHorse, dropper);
						}
						else if(enClass.getName().endsWith("EntityAtmosBison"))
						{
							dropHide(event.lootingLevel, ItemListMF.rawHide, dropper);
						}
						else if(enClass.getName().endsWith("GaiaHunter"))
						{
							dropHide(event.lootingLevel, ItemListMF.leatherRaw, dropper);
						}
						else if(enClass.getName().endsWith("MoCEntityFox"))
						{
							dropHide(event.lootingLevel, ItemListMF.hideHound, dropper);
						}
						else if(enClass.getName().endsWith("EntityTroll"))
						{
							dropHide(event.lootingLevel, ItemListMF.hideHound, dropper);
						}
						else if(name.equals("Cow"))
						{
							dropHide(event.lootingLevel, ItemListMF.rawHide, dropper);
                    	}
						else
						{
							if (!enClass.getName().startsWith("net.minecraft")&&!enClass.getName().startsWith("minefantasy")){
							    FMLLog.warning("[MineFantasy] "+enClass.getName()+"is attempting to drop vanilla leather, report this to the developers");
		    					dropHide(event.lootingLevel, ItemListMF.hideGeneric, dropper); 
							}
						}
			}
		}
              
		if(name.equals("Skeleton"))
		{
			for(EntityItem item : event.drops)
			{
				if(item.getEntityItem().isItemEqual(new ItemStack(Item.coal)))
				{	
					item.setEntityItemStack(new ItemStack(ItemListMF.misc, 1, ItemListMF.HellCoal));
				}
				else if(item.getEntityItem().isItemEqual(new ItemStack(Item.bow)))
				{	
					item.setEntityItemStack(new ItemStack(ItemListMF.shortbow));
				}
			}
		}
		if(name.equals("Sheep")||name.toLowerCase().contains("sheep")||name.toLowerCase().contains("goat"))
		{
			dropHide(event.lootingLevel, ItemListMF.hideSheep, dropper);
			
			if(cfg.dropMutton)
			{
				int amount = MineFantasyBase.isHOLoaded() ? 1 : dropper.getRNG().nextInt(3);
				
				if(event.lootingLevel > 0)
				{
					amount += dropper.getRNG().nextInt(event.lootingLevel);
				}
			
				ItemStack food = new ItemStack(dropper.isBurning() ? ItemListMF.muttonCooked : ItemListMF.muttonRaw);
				
				if(food.stackSize > 0)
				{
					for(int a = 0; a < amount; a ++)
						dropper.entityDropItem(food, 0.0F);
				}
			}
		}	
		if(name.equals("Chicken"))
		{
			int amount = dropper.getRNG().nextInt(2) + 1 + dropper.getRNG().nextInt(1 + event.lootingLevel);
			
			ItemStack featherdrop = new ItemStack(Item.feather);
			if(featherdrop.stackSize > 0)
				for(int a = 0; a < amount; a ++)
			dropper.entityDropItem(featherdrop, 0.0F);
		}	
		if(name.equals("Blaze"))
		{
			
			int amount = 1 + dropper.getRNG().nextInt(1 + event.lootingLevel);
			
			ItemStack hellDrop = new ItemStack(ItemListMF.misc, 1, ItemListMF.HellCoal);
			if(hellDrop.stackSize > 0)
			{
				for(int a = 0; a < amount; a ++)
					dropper.entityDropItem(hellDrop, 0.0F);
			}
		}
		
		if(enClass.getName().endsWith("MoCEntityBoar") || enClass.getName().endsWith("MoCEntityDeer"))
		{
			ItemStack drop = new ItemStack(Item.porkRaw);
			if(event.entityLiving.isBurning())
				drop = new ItemStack(Item.porkCooked);
			int num = event.lootingLevel + event.entityLiving.getRNG().nextInt(2);
			for(int a = 0; a < num; a ++)
			event.entityLiving.entityDropItem(drop, 0.0F);
		}
		
		if(enClass.getName().endsWith("MoCEntityFishy"))
		{
			ItemStack drop = new ItemStack(Item.fishRaw);
			if(event.entityLiving.isBurning())
				drop = new ItemStack(Item.fishCooked);
			event.entityLiving.entityDropItem(drop, 0.0F);
		}
		
		if(event.entityLiving instanceof EntityWolf/* && !(event.entityLiving instanceof EntityHound)*/)
		{
			dropHide(event.lootingLevel, ItemListMF.hideHound, dropper);
		}
	}

	private void dropHide(int loot, int hide, EntityLivingBase dropper) 
	{
		int amount = 1 + dropper.getRNG().nextInt(1 + loot);
		
		ItemStack leatherdrop = new ItemStack(ItemListMF.misc, 1 , hide);
		
		if(leatherdrop.stackSize > 0)
			for(int a = 0; a < amount; a ++)
		dropper.entityDropItem(leatherdrop, 0.0F);
	}

	@ForgeSubscribe
	public void itemEvent(EntityItemPickupEvent event)
	{
		EntityPlayer player = event.entityPlayer;
		
		EntityItem drop = event.item;
		ItemStack item = drop.getEntityItem();
		ItemStack held = player.getHeldItem();
		
		if(held != null && held.getItem() instanceof ITongs)
		{
			if(!TongsHelper.hasHeldItem(held))
			{
				if(isHotItem(item))
				{
					if(TongsHelper.trySetHeldItem(held, item))
					{
						drop.setDead();
						
						if(event.isCancelable())
						{
							event.setCanceled(true);
						}
						return;
					}
				}
			}
		}
		{
			if(cfg.burnPlayer && item != null && isHotItem(item))
			{
				if(event.isCancelable())
				{
					event.setCanceled(true);
				}
			}
		}
	}
	
	private boolean isPrimitive(ItemStack heldItem) 
	{
		if(heldItem == null)return true;
		
		if(heldItem.isItemEqual(ItemListMF.component(ItemListMF.rock)))
		{
			return true;
		}
		if(heldItem.itemID == Item.swordStone.itemID || heldItem.itemID == Item.swordWood.itemID)
		{
			return true;
		}
		if(heldItem.getItem() != null)
		{
			if(heldItem.getItem() instanceof IPublicMaterialItem)
			{
				EnumToolMaterial mat = ((IPublicMaterialItem)heldItem.getItem()).getMaterial();
				return mat == EnumToolMaterial.STONE ||  mat == EnumToolMaterial.WOOD ||  mat == ToolMaterialMedieval.PRIMITIVE_COPPER || mat == ToolMaterialMedieval.PRIMITIVE_STONE;
			}
			if(heldItem.getItem() instanceof ItemWeaponMF)
			{
				return ((ItemWeaponMF)heldItem.getItem()).isPrimitive();
			}
		}
		return false;
	}


	@ForgeSubscribe
	public void setTarget(LivingSetAttackTargetEvent event)
	{
		if(event.entity != null && event.target != null)
		{
			if(event.entityLiving.canEntityBeSeen(event.target))
			if(!TacticalManager.isDetected(event.target, event.entityLiving))
			{
					if(event.isCancelable())
						event.setCanceled(true);
					else
					{
						if(event.entityLiving instanceof EntityLiving)
						{
							((EntityLiving)event.entityLiving).setAttackTarget(null);
						}
					}
			}
			
			if(event.entityLiving instanceof EntityCreeper && !(event.target instanceof EntityPlayer))
				if(event.isCancelable())
				event.setCanceled(true);
				else
				{
					if(event.entityLiving instanceof EntityLiving)
					{
						((EntityLiving)event.entityLiving).setAttackTarget(null);
					}
				}
		}
	}
	
	private static String getType(String type, EnumWeaponType wC) {
		if(wC == EnumWeaponType.AXE
	    || wC == EnumWeaponType.BIGAXE
	    || wC == EnumWeaponType.BIGBLADE
	   	|| wC == EnumWeaponType.BIGPOLEARM
	  	|| wC == EnumWeaponType.LONGBLADE
	    || wC == EnumWeaponType.MEDBLADE
	    || wC == EnumWeaponType.POLEARM
	    || wC == EnumWeaponType.SMLAXE
	   	|| wC == EnumWeaponType.SMLBLADE
	 	|| wC == EnumWeaponType.STAFF
	   	)
		{
			return "blade";
		}
		return "blunt";
	}

	
	public static void makeHitSound(ItemStack weapon, Entity target)
	{
		if(!cfg.hitSound)
		{
			return;
		}
		if(weapon != null)
		{
			EnumWeaponType WC = WeaponClass.getClassFor(weapon);
			String material = "metal";
			String type = "blunt";
			
			material = getMaterial(material, weapon.getItem());
			if(WC != null)
			{
				type = getType(type, WC);
				String sndString = data_minefantasy.sound("Weapon.hit." + type + "." + material + "_");
				
				float volume = 1.0F;
				target.playSound(sndString, 1.0F, 1.0F);
			}
		}
	}

	private static String getMaterial(String material, Item item) {
		
		if(item instanceof ItemTool)
		{
			if(((ItemTool)item).getToolMaterialName().equalsIgnoreCase("WOOD"))
			{
				material = "wood";
			}
			if(((ItemTool)item).getToolMaterialName().equalsIgnoreCase("STONE"))
			{
				material = "stone";
			}
		}
		
		if(item instanceof ItemSword)
		{
			if(((ItemSword)item).getToolMaterialName().equalsIgnoreCase("WOOD"))
			{
				material = "wood";
			}
			if(((ItemSword)item).getToolMaterialName().equalsIgnoreCase("STONE"))
			{
				material = "stone";
			}
		}
		
		if(item instanceof IPublicMaterialItem)
		{
			EnumToolMaterial mat = ((IPublicMaterialItem)item).getMaterial();
			
			if(mat == ToolMaterialMedieval.PRIMITIVE_STONE)
			{
				material = "stone";
			}
		}
		return material;
	}


	public void readyBow(ArrowNockEvent event)
	{	
		if(MineFantasyBase.isBGLoaded())
		{
			return;
		}
		EntityPlayer player = event.entityPlayer;
		ItemStack bow = event.result;
		boolean infinite = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, bow) > 0;
		
		for(ItemStack arrow: ArrowsMF.useableArrows)
		{
			if(player.inventory.hasItemStack(arrow))
			{
				player.setItemInUse(bow, bow.getMaxItemUseDuration());
				ItemBowMF.loadArrow(player, bow, arrow, true);
				event.setCanceled(true);
				return;
			}
		}
		
		if(infinite)
		{
			player.setItemInUse(bow, bow.getMaxItemUseDuration());
			ItemBowMF.loadArrow(player, bow, new ItemStack(Item.arrow), true);
			event.setCanceled(true);
			return;
		}
	}
	//ItemBow
	public void fireArrow(ArrowLooseEvent event)
	{
		if(MineFantasyBase.isBGLoaded())
		{
			return;
		}
		
		ItemStack bow = event.bow;
		float charge = event.charge;
		EntityPlayer player = event.entityPlayer;
		World world = event.entity.worldObj;
		
		ItemBowMF.loadArrow(player, bow, null, true);
		
		for(ItemStack arrow: ArrowsMF.useableArrows)
		{
	        if(shootSpecificArrow( bow, world, player, charge, arrow))
	        {
	        	event.setCanceled(true);
	        	return;
	        }
		}
	}
	
	@ForgeSubscribe
	public void playWorldSound(PlaySoundAtEntityEvent event)
	{
		if(event != null && event.name != null)
		{
			if(event.name.equalsIgnoreCase("random.bow"))
			{
				event.name = "minefantasy:oldbow";
			}
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean shootSpecificArrow(ItemStack item, World world, EntityPlayer player, float power, ItemStack ammo)
    {
		boolean infinite = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, item) > 0;
		Random itemRand = new Random();
        if (player.inventory.hasItemStack(ammo))
        {
            float charge = (float)power / 20.0F;
            charge = (charge * charge + charge * 2.0F) / 3.0F;

            if ((double)charge < 0.1D)
            {
                return false;
            }

            if (charge > 1.0F)
            {
                charge = 1.0F;
            }

            float force = 2.0F;
            EntityArrowMF arrow = new EntityArrowMF(world, player, charge * 2.0F, ammo.getItemDamage());

            if (charge == 1.0F)
            {
                arrow.setIsCritical(true);
            }

            int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, item);

            if (var9 > 0)
            {
                arrow.setDamage(arrow.getDamage() + (double)var9 * 0.5D + 0.5D);
            }

            int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, item);

            if (var10 > 0)
            {
                arrow.setKnockbackStrength(var10);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, item) > 0)
            {
                arrow.setFire(100);
            }

            if(!player.capabilities.isCreativeMode)
            {
            	item.damageItem(1, player);
            }
            
            if(!infinite)
            {
            	consumePlayerItem(player, ammo);
            }
            else
            {
            	arrow.canBePickedUp = 2;
            }
            world.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + charge * 0.5F);


            if (!world.isRemote)
            {
                world.spawnEntityInWorld(arrow);
            }
            return true;
        }
        return false;
    }
	
	@ForgeSubscribe
	public void hurtEntity(LivingHurtEvent event)
	{
		CombatManager.onAttack(event);
	}
	@ForgeSubscribe
	public void onAttack(LivingAttackEvent event)
	{
		Entity source = event.source.getSourceOfDamage();
		
		if(source != null && source instanceof EntityLiving && !event.source.isProjectile())
		{
			EntityLiving attacker = (EntityLiving)source;
			
			PotionEffect affliction = attacker.getActivePotionEffect(Potion.confusion);
			
			if(affliction != null)
			{
				Random rand = attacker.getRNG();
				int tier = affliction.getAmplifier();
				
				if(rand.nextInt(5) <= tier)
				{
					event.setCanceled(true);
				}
			}
		}
	}
	
	
	@ForgeSubscribe
	public void fertellise (BonemealEvent event)
	{
		World world = event.world;
		EntityPlayer player = event.entityPlayer;
		int x = event.X;
		int y = event.Y;
		int z = event.Z;
		int id = event.ID;
		ItemStack item = player.getHeldItem();
		int meta = world.getBlockMetadata(x, y, z);
		
		if (id == BlockListMF.sapling.blockID)
        {
            if (!world.isRemote)
            {
                if ((double)world.rand.nextFloat() < ((BlockSaplingMF)BlockListMF.sapling).getBonemealChance(meta))
                {
                    ((BlockSaplingMF)BlockListMF.sapling).markOrGrowMarked(world, x, y, z, world.rand);
                }
            }

            event.setResult(Result.ALLOW);
        }
	}
	
	
	private boolean consumePlayerItem(EntityPlayer player, ItemStack item) 
    {
    	for(int a = 0; a < player.inventory.getSizeInventory(); a ++)
    	{
    		ItemStack i = player.inventory.getStackInSlot(a);
    		if(i != null && i.isItemEqual(item))
    		{
    			player.inventory.decrStackSize(a, 1);
    			return true;
    		}
    	}
    	return false;
	}
	
	private boolean isHotItem(ItemStack item) 
	{
		return item != null && (item.getItem() instanceof ItemHotItem || item.getItem() instanceof ItemBloom || MineFantasyAPI.isHotToPickup(item));
	}
	
	
	/*@ForgeSubscribe
	public void loadChunk(ChunkDataEvent.Load event)
	{
		if(!cfg.regen)return;
		
		NBTTagCompound nbt = event.getData();
		int layer = cfg.regenLayer;
		
		if(nbt.hasKey("MineFantasyWG_" + layer))
		{
			return;
		}
		nbt.setBoolean("MineFantasyWG_" + layer, true);
		
		World world = event.world;
		int chunkX = event.getChunk().xPosition;
		int chunkZ = event.getChunk().zPosition;
		Random rand = event.world.rand;
		
		MineFantasyBase.generator.generate(rand, chunkX, chunkZ, world, world.getChunkProvider(), world.getChunkProvider());
	}*/
	
	@ForgeSubscribe
	public void fireMBArrow(QuiverArrowEvent.Firing event)
	{
		ItemStack bow = event.getBow();
		EntityArrow arrow = event.arrow;
		
		if(bow != null && bow.getItem() != null && bow.getItem() instanceof ISpecialBow)
        {
        	arrow = (EntityArrow) ((ISpecialBow)bow.getItem()).modifyArrow(arrow);
        }
	}
	
	@ForgeSubscribe
    public void onEntityJoinWorld(EntityJoinWorldEvent event)
	{
		if(event.entity instanceof EntityArrow)
		{
			EntityArrow arrow = (EntityArrow)event.entity;
			if(arrow.shootingEntity != null && arrow.shootingEntity instanceof EntityLiving)
			{
				EntityLiving attacker = (EntityLiving)arrow.shootingEntity;
				
				PotionEffect affliction = attacker.getActivePotionEffect(Potion.confusion);
				
				if(affliction != null)
				{
					Random rand = attacker.getRNG();
					float tier = (float)affliction.getAmplifier()+1*5F;
					
					arrow.motionX *= 1F + ((rand.nextFloat()*0.2F - 0.1F)*tier);
					arrow.motionY *= 1F + ((rand.nextFloat()*0.2F - 0.1F)*tier);
					arrow.motionZ *= 1F + ((rand.nextFloat()*0.2F - 0.1F)*tier);
				}
			}
		}
	}
/*	
	@ForgeSubscribe
	public void blockWithShield(PlayerEventChild.ShieldBlockEvent event)
	{
		float damage = event.ammount;
		EntityLivingBase attacker = null;
		if(event.source.getSourceOfDamage() != null && event.source.getSourceOfDamage() instanceof EntityLivingBase)
		{
			attacker = (EntityLivingBase)event.source.getSourceOfDamage();
		}
		ItemStack shield = event.shield;
		
		if(shield != null && shield.getItem() instanceof ItemShield)
		{
			if(attacker != null)
			{
				event.damageShield = ((ItemShield)shield.getItem()).collideWithShield(event.source, attacker, damage);
			}
		}
	}
	*/
}
