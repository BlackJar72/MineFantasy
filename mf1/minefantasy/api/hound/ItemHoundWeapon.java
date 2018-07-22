/*     */ package minefantasy.api.hound;
/*     */ 
/*     */ import java.util.List;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemHoundWeapon
/*     */   extends Item
/*     */   implements IHoundEquipment, IHoundApparel, IHoundWeapon
/*     */ {
/*     */   protected float weaponDamage;
/*     */   protected final EnumToolMaterial toolMaterial;
/*     */   
/*     */   public ItemHoundWeapon(int id, EnumToolMaterial material)
/*     */   {
/*  31 */     super(id);
/*  32 */     this.toolMaterial = material;
/*  33 */     this.field_77777_bU = 1;
/*  34 */     func_77656_e(material.func_77997_a() * 2);
/*  35 */     func_77637_a(CreativeTabs.field_78037_j);
/*  36 */     this.weaponDamage = (4.0F + material.func_78000_c());
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack item, EntityPlayer player, List desc, boolean flag)
/*     */   {
/*  41 */     super.func_77624_a(item, player, desc, flag);
/*  42 */     if ((getRequiredStr() > 0) || (getRequiredSta() > 0) || (getRequiredEnd() > 0)) {
/*  43 */       desc.add("Requirments:");
/*  44 */       if (getRequiredStr() > 0)
/*  45 */         desc.add("Attack: " + getRequiredStr());
/*  46 */       if (getRequiredEnd() > 0)
/*  47 */         desc.add("Defense: " + getRequiredEnd());
/*  48 */       if (getRequiredSta() > 0) {
/*  49 */         desc.add("Stamina: " + getRequiredSta());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public float getDamage(Entity tar) {
/*  55 */     return this.weaponDamage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hitEntity(ItemStack weapon, EntityLiving target, EntityLiving user)
/*     */   {
/*  63 */     weapon.func_77972_a(1, user);
/*  64 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_77619_b()
/*     */   {
/*  72 */     return this.toolMaterial.func_77995_e();
/*     */   }
/*     */   
/*     */   public String getMaterialName() {
/*  76 */     return this.toolMaterial.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_82789_a(ItemStack item1, ItemStack item2)
/*     */   {
/*  83 */     return this.toolMaterial.func_82844_f() == item2.field_77993_c ? true : super.func_82789_a(item1, item2);
/*     */   }
/*     */   
/*     */   public int getPiece()
/*     */   {
/*  88 */     return 0;
/*     */   }
/*     */   
/*     */   public int getRequiredStr()
/*     */   {
/*  93 */     return 0;
/*     */   }
/*     */   
/*     */   public int getRequiredEnd()
/*     */   {
/*  98 */     return 0;
/*     */   }
/*     */   
/*     */   public int getRequiredSta()
/*     */   {
/* 103 */     return 0;
/*     */   }
/*     */   
/*     */   public String getTexture()
/*     */   {
/* 108 */     return null;
/*     */   }
/*     */   
/*     */   public String getOverlay()
/*     */   {
/* 113 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public float getMobilityModifier()
/*     */   {
/* 119 */     return 0.0F;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/hound/ItemHoundWeapon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */