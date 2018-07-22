/*     */ package minefantasy.item.weapon;
/*     */ 
/*     */ import minefantasy.api.weapon.IExtendedReachItem;
/*     */ import minefantasy.api.weapon.IWeaponCustomSpeed;
/*     */ import minefantasy.api.weapon.IWeaponMobility;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemLance
/*     */   extends ItemWeaponMF
/*     */   implements IWeaponMobility, IWeaponCustomSpeed, IExtendedReachItem
/*     */ {
/*     */   public ItemLance(int id, EnumToolMaterial material)
/*     */   {
/*  26 */     super(id, material);
/*     */   }
/*     */   
/*     */   public ItemLance(int id, EnumToolMaterial material, float dam, int uses) {
/*  30 */     this(id, material);
/*     */   }
/*     */   
/*     */   public float getDamageModifier()
/*     */   {
/*  35 */     return 0.25F;
/*     */   }
/*     */   
/*     */   public int getHitTime(ItemStack weapon, EntityLivingBase target)
/*     */   {
/*  40 */     return 15;
/*     */   }
/*     */   
/*     */   public float getReachModifierInBlocks(ItemStack mainhand)
/*     */   {
/*  45 */     return 3.5F;
/*     */   }
/*     */   
/*     */   public float getExaustion()
/*     */   {
/*  50 */     return 0.2F;
/*     */   }
/*     */   
/*     */   public float getSpeedWhenEquipped()
/*     */   {
/*  55 */     float degrade = 0.25F;
/*  56 */     if (getMaterial() == ToolMaterialMedieval.MITHRIL) {
/*  57 */       degrade /= 2.0F;
/*     */     }
/*  59 */     return 1.0F - degrade;
/*     */   }
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack item) {
/*  63 */     return EnumAction.none;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
/*     */   {
/*  72 */     return item;
/*     */   }
/*     */   
/*     */   public float getKnockback()
/*     */   {
/*  77 */     return 8.0F;
/*     */   }
/*     */   
/*     */   public boolean canJoust()
/*     */   {
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   public float getDurability()
/*     */   {
/*  87 */     return 2.0F;
/*     */   }
/*     */   
/*     */   public float getJoustModifierDamage()
/*     */   {
/*  92 */     return 7.5F;
/*     */   }
/*     */   
/*     */   public int getHandsUsed()
/*     */   {
/*  97 */     return 2;
/*     */   }
/*     */   
/*     */   public float getBalance()
/*     */   {
/* 102 */     return 1.0F;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemLance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */