/*     */ package minefantasy.system;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.api.weapon.ICrossbowHandler;
/*     */ import minefantasy.entity.EntityArrowMF;
/*     */ import minefantasy.entity.EntityBoltMF;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class CrossbowAmmoMF
/*     */   implements ICrossbowHandler
/*     */ {
/*     */   public boolean shoot(ItemStack item, World world, EntityPlayer shooter, float accuracy, float damage, ItemStack ammo)
/*     */   {
/*  22 */     boolean infinite = (shooter.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/*  23 */     float power = 2.0F;
/*     */     
/*     */ 
/*  26 */     if (ammo.field_77993_c == Item.field_77704_l.field_77779_bT) {
/*  27 */       EntityArrow shot = new EntityArrow(world, shooter, power);
/*  28 */       int enc_Power = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, item);
/*  29 */       if (enc_Power > 0) {
/*  30 */         shot.func_70239_b(damage + enc_Power * 0.5D + 0.5D);
/*     */       }
/*     */       
/*  33 */       int enc_Punch = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, item);
/*     */       
/*  35 */       if (enc_Punch > 0) {
/*  36 */         shot.func_70240_a(enc_Punch);
/*     */       }
/*     */       
/*  39 */       if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, item) > 0) {
/*  40 */         shot.func_70015_d(100);
/*     */       }
/*     */       
/*  43 */       if (infinite) {
/*  44 */         shot.field_70251_a = 2;
/*     */       }
/*     */       
/*  47 */       Random rand = new Random();
/*  48 */       if (!world.field_72995_K) {
/*  49 */         world.func_72838_d(shot);
/*     */       }
/*  51 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  55 */     if ((ammo.field_77993_c == ItemListMF.arrowMF.field_77779_bT) && 
/*  56 */       (shootSpecificArrow(item, world, shooter, power, ammo))) {
/*  57 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  62 */     if ((ammo.field_77993_c == ItemListMF.boltMF.field_77779_bT) && 
/*  63 */       (shootSpecificBolt(item, world, shooter, power, ammo, damage))) {
/*  64 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  68 */     return false;
/*     */   }
/*     */   
/*     */   public boolean shootSpecificArrow(ItemStack item, World world, EntityPlayer player, float power, ItemStack ammo) {
/*  72 */     boolean infinite = (player.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/*  73 */     Random itemRand = new Random();
/*  74 */     EntityArrowMF arrow = new EntityArrowMF(world, player, power, ammo.func_77960_j());
/*     */     
/*  76 */     int var9 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, item);
/*     */     
/*  78 */     if (var9 > 0) {
/*  79 */       arrow.func_70239_b(arrow.func_70242_d() + var9 * 0.5D + 0.5D);
/*     */     }
/*     */     
/*  82 */     int var10 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, item);
/*     */     
/*  84 */     if (var10 > 0) {
/*  85 */       arrow.func_70240_a(var10);
/*     */     }
/*     */     
/*  88 */     if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, item) > 0) {
/*  89 */       arrow.func_70015_d(100);
/*     */     }
/*     */     
/*  92 */     if (infinite) {
/*  93 */       arrow.field_70251_a = 2;
/*     */     }
/*     */     
/*  96 */     if (!world.field_72995_K) {
/*  97 */       world.func_72838_d(arrow);
/*     */     }
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   public boolean shootSpecificBolt(ItemStack item, World world, EntityPlayer player, float power, ItemStack ammo, float damage) {
/* 103 */     boolean infinite = (player.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/* 104 */     Random itemRand = new Random();
/* 105 */     EntityBoltMF arrow = new EntityBoltMF(world, player, power, ammo.func_77960_j());
/*     */     
/* 107 */     arrow.func_70239_b(damage);
/* 108 */     int var9 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, item);
/*     */     
/* 110 */     if (var9 > 0) {
/* 111 */       arrow.func_70239_b(arrow.func_70242_d() + var9 * 0.5D + 0.5D);
/*     */     }
/*     */     
/* 114 */     int var10 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, item);
/*     */     
/* 116 */     if (var10 > 0) {
/* 117 */       arrow.func_70240_a(var10);
/*     */     }
/*     */     
/* 120 */     if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, item) > 0) {
/* 121 */       arrow.func_70015_d(100);
/*     */     }
/*     */     
/* 124 */     if (infinite) {
/* 125 */       arrow.field_70251_a = 2;
/*     */     }
/*     */     
/* 128 */     if (!world.field_72995_K) {
/* 129 */       world.func_72838_d(arrow);
/*     */     }
/* 131 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/CrossbowAmmoMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */