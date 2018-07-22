/*     */ package minefantasy.item;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.entity.EntityThrownSpear;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemJavelin
/*     */   extends Item
/*     */ {
/*     */   private int weaponDamage;
/*     */   public boolean isUsing;
/*     */   
/*     */   public ItemJavelin(int id, int dam)
/*     */   {
/*  40 */     super(id);
/*  41 */     func_77664_n();
/*  42 */     this.field_77777_bU = 8;
/*  43 */     func_77637_a(ItemListMF.tabWeapon);
/*     */     
/*  45 */     this.weaponDamage = dam;
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack item, EntityPlayer player, List desc, boolean flag)
/*     */   {
/*  50 */     if ((item.func_77942_o()) && 
/*  51 */       (item.func_77978_p().func_74764_b("Sharp"))) {
/*  52 */       int sharp = item.func_77978_p().func_74762_e("Sharp");
/*  53 */       desc.add("Sharpened: " + sharp);
/*     */     }
/*     */     
/*  56 */     super.func_77624_a(item, player, desc, flag);
/*     */   }
/*     */   
/*     */   public int getDamageVsEntity(Entity entity) {
/*  60 */     return 2;
/*     */   }
/*     */   
/*     */   public int func_77626_a(ItemStack item) {
/*  64 */     return 72000;
/*     */   }
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack item) {
/*  68 */     return EnumAction.bow;
/*     */   }
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player) {
/*  72 */     player.func_71008_a(item, func_77626_a(item));
/*  73 */     return item;
/*     */   }
/*     */   
/*     */   public void func_77615_a(ItemStack item, World world, EntityPlayer player, int time) {
/*  77 */     if (item.field_77993_c != this.field_77779_bT)
/*  78 */       return;
/*  79 */     if (player.field_82175_bq) {
/*  80 */       return;
/*     */     }
/*  82 */     int var6 = func_77626_a(item) - time;
/*     */     
/*  84 */     float var7 = var6 / 20.0F;
/*  85 */     var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
/*     */     
/*  87 */     if (var7 < 0.1D) {
/*  88 */       return;
/*     */     }
/*     */     
/*  91 */     if (var7 > 1.0F) {
/*  92 */       var7 = 1.0F;
/*     */     }
/*     */     
/*  95 */     var7 += 0.5F;
/*     */     
/*  97 */     if (!world.field_72995_K) {
/*  98 */       ItemStack itemspear = item.func_77946_l();
/*  99 */       itemspear.field_77994_a = 1;
/* 100 */       EntityThrownSpear spear = new EntityThrownSpear(world, player, var7).setSpear(itemspear);
/* 101 */       world.func_72956_a(player, MFResource.sound("spearThrow"), 1.2F, 0.5F / (field_77697_d.nextFloat() * 0.5F + 1.0F));
/* 102 */       if (player.field_71075_bZ.field_75098_d) {
/* 103 */         spear.field_70251_a = 2;
/*     */       }
/* 105 */       world.func_72838_d(spear);
/* 106 */       spear.syncSpear();
/*     */     }
/* 108 */     if (!player.field_71075_bZ.field_75098_d) {
/* 109 */       item.field_77994_a -= 1;
/* 110 */       if (item.field_77994_a <= 0)
/* 111 */         player.func_71028_bD();
/*     */     }
/* 113 */     player.func_71038_i();
/*     */   }
/*     */   
/*     */   public int getSpearDamage()
/*     */   {
/* 118 */     return this.weaponDamage;
/*     */   }
/*     */   
/*     */   public int getBreakChance() {
/* 122 */     return 40;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/* 127 */     func_111206_d("minefantasy:Weapon/" + name);
/* 128 */     return super.func_77655_b(name);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemJavelin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */