/*     */ package minefantasy.item.weapon;
/*     */ 
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.weapon.IWeaponCustomSpeed;
/*     */ import minefantasy.api.weapon.IWeaponPenetrateArmour;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ 
/*     */ public class ItemWarpick
/*     */   extends ItemWeaponMF
/*     */   implements IWeaponPenetrateArmour, IWeaponCustomSpeed
/*     */ {
/*  24 */   private static Block[] blocksEffectiveAgainst = { Block.field_71978_w, Block.field_72079_ak, Block.field_72085_aj, Block.field_71981_t, Block.field_71957_Q, Block.field_72087_ao, Block.field_71949_H, Block.field_72083_ai, Block.field_71950_I, Block.field_72105_ah, Block.field_71941_G, Block.field_72073_aw, Block.field_72071_ax, Block.field_72036_aT, Block.field_72012_bb, Block.field_71947_N, Block.field_71948_O, Block.field_72047_aN, Block.field_72048_aO, Block.field_72056_aG, Block.field_71953_U, Block.field_71954_T };
/*     */   
/*  26 */   public float efficiencyOnProperMaterial = 2.0F;
/*     */   private float APdamage;
/*     */   
/*     */   public ItemWarpick(int id, EnumToolMaterial material) {
/*  30 */     super(id, material);
/*  31 */     DecimalFormat decimal_format = new DecimalFormat("#.#");
/*     */     
/*  33 */     this.APdamage = (this.baseDamage * getAPPercent());
/*     */     
/*  35 */     if (!(this instanceof ItemWarhammer)) {
/*  36 */       this.efficiencyOnProperMaterial = (material.func_77998_b() * 0.75F);
/*  37 */       MinecraftForge.setToolClass(this, "pickaxe", material.func_77996_d());
/*     */     }
/*     */   }
/*     */   
/*     */   public float getDamageModifier()
/*     */   {
/*  43 */     return 0.75F;
/*     */   }
/*     */   
/*     */   public int getHitTime(ItemStack weapon, EntityLivingBase target)
/*     */   {
/*  48 */     return 3;
/*     */   }
/*     */   
/*     */   public float getAPDamage()
/*     */   {
/*  53 */     return this.APdamage;
/*     */   }
/*     */   
/*     */   public boolean func_77660_a(ItemStack item, World world, int x, int y, int z, int meta, EntityLivingBase entity)
/*     */   {
/*  58 */     item.func_77972_a(1, entity);
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public boolean canHarvestBlock(Block block, ItemStack stack)
/*     */   {
/*  64 */     if (!(this instanceof ItemWarhammer)) {
/*  65 */       return ForgeHooks.canToolHarvestBlock(block, 0, stack);
/*     */     }
/*  67 */     return super.func_77641_a(block);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getStrVsBlock(ItemStack item, Block block, int metadata)
/*     */   {
/*  76 */     if (!(this instanceof ItemWarhammer)) {
/*  77 */       return ForgeHooks.isToolEffective(item, block, metadata) ? this.efficiencyOnProperMaterial : super.func_77638_a(item, block);
/*     */     }
/*  79 */     return super.getStrVsBlock(item, block, metadata) * 3.0F;
/*     */   }
/*     */   
/*     */   public float getDurability()
/*     */   {
/*  84 */     return 1.5F;
/*     */   }
/*     */   
/*     */   public float getArmourDamageBonus()
/*     */   {
/*  89 */     return 1.5F;
/*     */   }
/*     */   
/*     */   public boolean buffDamage()
/*     */   {
/*  94 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean sheatheOnBack(ItemStack item)
/*     */   {
/* 100 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isOffhandHandDual(ItemStack off)
/*     */   {
/* 106 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean offhandClickAir(PlayerInteractEvent event, ItemStack mainhandItem, ItemStack offhandItem)
/*     */   {
/* 112 */     return false;
/*     */   }
/*     */   
/*     */   public int getHandsUsed()
/*     */   {
/* 117 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 124 */     super.onHit(damage, weapon, target, attacker);
/*     */     
/* 126 */     if ((target != null) && ((target instanceof EntityLivingBase)) && 
/* 127 */       (this.rand.nextFloat() * 3.0F < getDebilitation())) {
/* 128 */       if ((this instanceof ItemWarhammer)) {
/* 129 */         attacker.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 300, 0));
/*     */         
/* 131 */         if ((attacker instanceof EntityPlayer)) {
/* 132 */           ((EntityPlayer)attacker).func_71024_bL().func_75122_a(0, 2.0F);
/*     */         }
/*     */         
/* 135 */         target.field_70170_p.func_72876_a(attacker, target.field_70165_t, target.field_70163_u + target.field_70131_O / 2.0F, target.field_70161_v, 1.0F, false);
/* 136 */         target.func_70690_d(new PotionEffect(Potion.field_76431_k.field_76415_H, 150, this.rand.nextInt(3)));
/*     */       } else {
/* 138 */         target.func_85030_a("minefantasy:Weapon.crit", 1.0F, 1.0F);
/* 139 */         target.func_70690_d(new PotionEffect(Potion.field_76437_t.field_76415_H, 600, this.rand.nextInt(3)));
/*     */       }
/*     */       
/* 142 */       target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 600, this.rand.nextInt(3)));
/*     */     }
/*     */   }
/*     */   
/*     */   public float getDebilitation()
/*     */   {
/* 148 */     return 0.4F;
/*     */   }
/*     */   
/*     */   protected float getAPPercent()
/*     */   {
/* 153 */     return 0.5F;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemWarpick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */