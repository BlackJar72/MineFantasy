/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.List;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.IPublicMaterialItem;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
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
/*     */ 
/*     */ 
/*     */ public class ItemRakeMF
/*     */   extends ItemToolMF
/*     */   implements IPublicMaterialItem, IWeaponSpecial
/*     */ {
/*     */   private EnumToolMaterial toolMaterial;
/*     */   
/*     */   public ItemRakeMF(int id, EnumToolMaterial material)
/*     */   {
/*  43 */     super(id);
/*  44 */     this.toolMaterial = material;
/*  45 */     func_77656_e(material.func_77997_a() * 10);
/*  46 */     func_77637_a(ItemListMF.tabTool);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/*  56 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/*  57 */       return rarity(itemStack, 1);
/*     */     }
/*  59 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/*  60 */       return rarity(itemStack, 2);
/*     */     }
/*  62 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/*  66 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/*  67 */     if (item.func_77948_v()) {
/*  68 */       if (lvl == 0) {
/*  69 */         lvl++;
/*     */       }
/*  71 */       lvl++;
/*     */     }
/*  73 */     if (lvl >= rarity.length) {
/*  74 */       lvl = rarity.length - 1;
/*     */     }
/*  76 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public boolean func_77648_a(ItemStack rake, EntityPlayer player, World world, int x, int y, int z, int facing, float pitch, float yaw, float pan)
/*     */   {
/*  81 */     double dist = 8.0D;
/*  82 */     AxisAlignedBB search = player.field_70121_D.func_72314_b(dist, dist, dist);
/*  83 */     List<EntityItem> items = player.field_70170_p.func_72872_a(EntityItem.class, search);
/*  84 */     if (!items.isEmpty()) {
/*  85 */       for (Object obj : items.toArray()) {
/*  86 */         EntityItem item = (EntityItem)obj;
/*  87 */         moveItem(item, player, dist);
/*     */       }
/*     */     }
/*  90 */     rake.func_77972_a(1, player);
/*  91 */     return true;
/*     */   }
/*     */   
/*     */   private void moveItem(EntityItem item, EntityPlayer closestPlayer, double range) {
/*  95 */     if (closestPlayer != null) {
/*  96 */       double d1 = (closestPlayer.field_70165_t - item.field_70165_t) / range;
/*  97 */       double d2 = (closestPlayer.field_70163_u + closestPlayer.func_70047_e() - item.field_70163_u) / range;
/*  98 */       double d3 = (closestPlayer.field_70161_v - item.field_70161_v) / range;
/*  99 */       double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
/* 100 */       double d5 = 1.0D - d4;
/*     */       
/* 102 */       double speed = 1.5D;
/* 103 */       if (d5 > 0.0D) {
/* 104 */         d5 *= d5;
/* 105 */         item.field_70159_w += d1 / d4 * d5 * speed;
/* 106 */         item.field_70181_x += d2 / d4 * d5 * speed;
/* 107 */         item.field_70179_y += d3 / d4 * d5 * speed;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial() {
/* 113 */     return this.toolMaterial;
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 118 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 119 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 122 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 123 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemRakeMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */