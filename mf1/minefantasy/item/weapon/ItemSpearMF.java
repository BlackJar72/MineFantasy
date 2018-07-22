/*     */ package minefantasy.item.weapon;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.api.weapon.IExtendedReachItem;
/*     */ import minefantasy.api.weapon.IWeaponCustomSpeed;
/*     */ import minefantasy.api.weapon.IWeaponMobility;
/*     */ import minefantasy.entity.EntityThrownSpear;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.AttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ItemSpearMF
/*     */   extends ItemWeaponMF
/*     */   implements IWeaponMobility, IWeaponCustomSpeed, IExtendedReachItem
/*     */ {
/*     */   public ItemSpearMF(int id, EnumToolMaterial material)
/*     */   {
/*  26 */     super(id, material);
/*     */   }
/*     */   
/*     */   public ItemSpearMF(int id, EnumToolMaterial material, float dam, int uses) {
/*  30 */     this(id, material);
/*     */   }
/*     */   
/*     */   public float getDamageModifier()
/*     */   {
/*  35 */     return 1.2F;
/*     */   }
/*     */   
/*     */   public int getHitTime(ItemStack weapon, EntityLivingBase target)
/*     */   {
/*  40 */     if (isPrimitive()) {
/*  41 */       return 6;
/*     */     }
/*  43 */     return 8;
/*     */   }
/*     */   
/*     */   public float getReachModifierInBlocks(ItemStack mainhand)
/*     */   {
/*  48 */     if (isPrimitive()) {
/*  49 */       return 2.0F;
/*     */     }
/*  51 */     return 3.0F;
/*     */   }
/*     */   
/*     */   public float getExaustion()
/*     */   {
/*  56 */     if (isPrimitive()) {
/*  57 */       return 0.0F;
/*     */     }
/*  59 */     return 0.1F;
/*     */   }
/*     */   
/*     */   public float getSpeedWhenEquipped()
/*     */   {
/*  64 */     if (isPrimitive()) {
/*  65 */       return 1.0F;
/*     */     }
/*  67 */     float degrade = 0.1F;
/*  68 */     if (getMaterial() == ToolMaterialMedieval.MITHRIL) {
/*  69 */       degrade /= 2.0F;
/*     */     }
/*  71 */     return 1.0F - degrade;
/*     */   }
/*     */   
/*     */   public int func_77626_a(ItemStack item) {
/*  75 */     return 8;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumAction func_77661_b(ItemStack item)
/*     */   {
/*  83 */     return EnumAction.bow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
/*     */   {
/*  92 */     player.func_71008_a(item, func_77626_a(item));
/*  93 */     return item;
/*     */   }
/*     */   
/*     */   public float getKnockback()
/*     */   {
/*  98 */     if (isPrimitive()) {
/*  99 */       return 2.0F;
/*     */     }
/* 101 */     return 5.5F;
/*     */   }
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack item, World world, EntityPlayer player)
/*     */   {
/* 106 */     if (item.field_77993_c != this.field_77779_bT)
/* 107 */       return item;
/* 108 */     if (!world.field_72995_K) {
/* 109 */       float d = (float)player.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/* 110 */       float var7 = 1.0F;
/*     */       
/* 112 */       if (getMaterial() == ToolMaterialMedieval.MITHRIL) {
/* 113 */         var7 += 1.05F;
/*     */       }
/* 115 */       EntityThrownSpear spear = new EntityThrownSpear(world, player, var7).setSpear(item.func_77946_l());
/* 116 */       spear.field_70251_a = 1;
/* 117 */       spear.func_70239_b(d);
/* 118 */       world.func_72956_a(player, MFResource.sound("spearThrow"), 1.2F, 0.5F / (field_77697_d.nextFloat() * 0.5F + 1.0F));
/* 119 */       world.func_72838_d(spear);
/* 120 */       spear.syncSpear();
/*     */     }
/* 122 */     item.field_77994_a -= 1;
/* 123 */     if (item.field_77994_a <= 0)
/* 124 */       player.func_71028_bD();
/* 125 */     player.func_71038_i();
/* 126 */     return item;
/*     */   }
/*     */   
/*     */   public boolean canJoust()
/*     */   {
/* 131 */     if (isPrimitive()) {
/* 132 */       return false;
/*     */     }
/* 134 */     return true;
/*     */   }
/*     */   
/*     */   public float getDurability()
/*     */   {
/* 139 */     if (isPrimitive()) {
/* 140 */       return 1.0F;
/*     */     }
/* 142 */     return 1.5F;
/*     */   }
/*     */   
/*     */   public int getHandsUsed()
/*     */   {
/* 147 */     return 2;
/*     */   }
/*     */   
/*     */   public float getBalance()
/*     */   {
/* 152 */     return 0.5F;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemSpearMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */