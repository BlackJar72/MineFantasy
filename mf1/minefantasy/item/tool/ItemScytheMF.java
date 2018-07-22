/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.IPublicMaterialItem;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockGrass;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.GameRules;
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
/*     */ public class ItemScytheMF
/*     */   extends ItemToolMF
/*     */   implements IWeaponSpecial, IPublicMaterialItem
/*     */ {
/*     */   private EnumToolMaterial toolMaterial;
/*     */   
/*     */   public ItemScytheMF(int id, EnumToolMaterial material)
/*     */   {
/*  43 */     super(id);
/*  44 */     this.toolMaterial = material;
/*  45 */     func_77656_e(material.func_77997_a());
/*  46 */     this.damageVsEntity = (3.0F + material.func_78000_c());
/*  47 */     func_77637_a(ItemListMF.tabTool);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/*  62 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/*  63 */       return rarity(itemStack, 1);
/*     */     }
/*  65 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/*  66 */       return rarity(itemStack, 2);
/*     */     }
/*  68 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/*  72 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/*  73 */     if (item.func_77948_v()) {
/*  74 */       if (lvl == 0) {
/*  75 */         lvl++;
/*     */       }
/*  77 */       lvl++;
/*     */     }
/*  79 */     if (lvl >= rarity.length) {
/*  80 */       lvl = rarity.length - 1;
/*     */     }
/*  82 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public boolean func_77648_a(ItemStack hoe, EntityPlayer player, World world, int x, int y, int z, int facing, float pitch, float yaw, float pan)
/*     */   {
/*  87 */     if (!player.func_82247_a(x, y, z, facing, hoe)) {
/*  88 */       return false;
/*     */     }
/*  90 */     int var11 = world.func_72798_a(x, y, z);
/*  91 */     int var12 = world.func_72798_a(x, y + 1, z);
/*     */     
/*  93 */     if (Block.field_71973_m[var11] != null) {
/*  94 */       Material m = world.func_72803_f(x, y, z);
/*  95 */       float hard = Block.field_71973_m[var11].func_71934_m(world, x, y, z);
/*  96 */       if (canCutMaterial(m, hard, false)) {
/*  97 */         if (cutGrass(world, x, y, z, 5, player, false)) {
/*  98 */           hoe.func_77972_a(1, player);
/*  99 */           player.func_71038_i();
/*     */         }
/* 101 */       } else if ((canCutMaterial(m, hard, true)) && 
/* 102 */         (cutGrass(world, x, y, z, 3, player, true))) {
/* 103 */         hoe.func_77972_a(1, player);
/* 104 */         player.func_71038_i();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial() {
/* 113 */     return this.toolMaterial;
/*     */   }
/*     */   
/*     */   private boolean cutGrass(World world, int x, int y, int z, int r, EntityPlayer entity, boolean leaf) {
/* 117 */     boolean flag = false;
/* 118 */     for (int x2 = -r; x2 <= r; x2++) {
/* 119 */       for (int y2 = -r; y2 <= r; y2++) {
/* 120 */         for (int z2 = -r; z2 <= r; z2++) {
/* 121 */           int id = world.func_72798_a(x + x2, y + y2, z + z2);
/* 122 */           int meta = world.func_72805_g(x + x2, y + y2, z + z2);
/* 123 */           if (Block.field_71973_m[id] != null) {
/* 124 */             Material m = world.func_72803_f(x + x2, y + y2, z + z2);
/* 125 */             if ((canCutMaterial(m, Block.field_71973_m[id].func_71934_m(world, x + x2, y + y2, z + z2), leaf)) && 
/* 126 */               (getDistance(x + x2, y + y2, z + z2, x, y, z) < r * 1)) {
/* 127 */               Block block = Block.field_71973_m[id];
/* 128 */               flag = true;
/*     */               
/* 130 */               ArrayList<ItemStack> items = block.getBlockDropped(world, x + x2, y + y2, z + z2, meta, 0);
/* 131 */               world.func_94571_i(x + x2, y + y2, z + z2);
/* 132 */               world.func_72926_e(2001, x + x2, y + y2, z + z2, Block.field_71980_u.field_71990_ca);
/*     */               
/* 134 */               if (!entity.field_71075_bZ.field_75098_d) {
/* 135 */                 for (ItemStack item : items) {
/* 136 */                   if (world.field_73012_v.nextFloat() <= 1.0F) {
/* 137 */                     dropBlockAsItem_do(world, x + x2, y + y2, z + z2, item);
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 147 */     return flag;
/*     */   }
/*     */   
/*     */   private boolean canCutMaterial(Material m, float str, boolean leaf) {
/* 151 */     if (!leaf) {
/* 152 */       if (str <= 0.0F) {
/* 153 */         return (m == Material.field_76255_k) || (m == Material.field_76254_j) || (m == Material.field_76247_b);
/*     */       }
/* 155 */       return false;
/*     */     }
/* 157 */     return (m == Material.field_76257_i) || (m == Material.field_76255_k);
/*     */   }
/*     */   
/*     */   public double getDistance(double x, double y, double z, int posX, int posY, int posZ) {
/* 161 */     double var7 = posX - x;
/* 162 */     double var9 = posY - y;
/* 163 */     double var11 = posZ - z;
/* 164 */     return MathHelper.func_76133_a(var7 * var7 + var9 * var9 + var11 * var11);
/*     */   }
/*     */   
/*     */   protected void dropBlockAsItem_do(World world, int x, int y, int z, ItemStack drop) {
/* 168 */     if ((!world.field_72995_K) && (world.func_82736_K().func_82766_b("doTileDrops"))) {
/* 169 */       float var6 = 0.7F;
/* 170 */       double var7 = world.field_73012_v.nextFloat() * var6 + (1.0F - var6) * 0.5D;
/* 171 */       double var9 = world.field_73012_v.nextFloat() * var6 + (1.0F - var6) * 0.5D;
/* 172 */       double var11 = world.field_73012_v.nextFloat() * var6 + (1.0F - var6) * 0.5D;
/* 173 */       EntityItem var13 = new EntityItem(world, x + var7, y + var9, z + var11, drop);
/* 174 */       var13.field_70293_c = 10;
/* 175 */       world.func_72838_d(var13);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 181 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 182 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 185 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 186 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_77660_a(ItemStack item, World world, int id, int x, int y, int z, EntityLivingBase user)
/*     */   {
/* 192 */     Random rand = new Random();
/* 193 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/* 194 */       ((user instanceof EntityPlayer))) {
/* 195 */       ((EntityPlayer)user).func_71024_bL().func_75122_a(1, 0.2F);
/*     */     }
/*     */     
/*     */ 
/* 199 */     return super.func_77660_a(item, world, id, x, y, z, user);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemScytheMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */