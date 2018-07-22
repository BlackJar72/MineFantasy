/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.mining.RandomOre;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.IPublicMaterialItem;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemPickaxe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.world.GameRules;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
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
/*     */ public class ItemHandpick
/*     */   extends ItemPickaxe
/*     */   implements IPublicMaterialItem, IWeaponSpecial
/*     */ {
/*     */   private int damageVsEntity;
/*     */   
/*     */   public ItemHandpick(int id, EnumToolMaterial material)
/*     */   {
/*  47 */     super(id, material);
/*  48 */     MinecraftForge.setToolClass(this, "pickaxe", material.func_77996_d());
/*  49 */     func_77637_a(ItemListMF.tabTool);
/*  50 */     func_77656_e((int)(material.func_77997_a() * 0.5F));
/*  51 */     this.field_77864_a = (material.func_77998_b() * 0.5F);
/*     */   }
/*     */   
/*     */   public boolean func_77641_a(Block block)
/*     */   {
/*  56 */     if (block == Block.field_72073_aw) {
/*  57 */       return (getMaterial().func_77996_d() >= 2) && (getMaterial() != ToolMaterialMedieval.BRONZE);
/*     */     }
/*  59 */     if (block == Block.field_71949_H) {
/*  60 */       return getMaterial().func_77996_d() >= 2;
/*     */     }
/*  62 */     if (block == Block.field_72089_ap) {
/*  63 */       return getMaterial().func_77996_d() >= 3;
/*     */     }
/*     */     
/*  66 */     int harvest = MinecraftForge.getBlockHarvestLevel(block, 0, "pickaxe");
/*  67 */     if (getMaterial().func_77996_d() >= harvest) {
/*  68 */       return true;
/*     */     }
/*  70 */     return super.func_77641_a(block);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/*  80 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/*  81 */       return rarity(itemStack, 1);
/*     */     }
/*  83 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/*  84 */       return rarity(itemStack, 2);
/*     */     }
/*  86 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/*  90 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/*  91 */     if (item.func_77948_v()) {
/*  92 */       if (lvl == 0) {
/*  93 */         lvl++;
/*     */       }
/*  95 */       lvl++;
/*     */     }
/*  97 */     if (lvl >= rarity.length) {
/*  98 */       lvl = rarity.length - 1;
/*     */     }
/* 100 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial()
/*     */   {
/* 105 */     return this.field_77862_b;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/* 110 */     func_111206_d("minefantasy:Tool/" + name);
/* 111 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 116 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 117 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 120 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 121 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onBlockStartBreak(ItemStack item, int x, int y, int z, EntityPlayer living)
/*     */   {
/* 127 */     World world = living.field_70170_p;
/*     */     
/* 129 */     if ((!living.field_71075_bZ.field_75098_d) && (living.field_71075_bZ.field_75099_e) && (!world.field_72995_K)) {
/* 130 */       int id = world.func_72798_a(x, y, z);
/* 131 */       int meta = world.func_72805_g(x, y, z);
/* 132 */       int harvestlvl = getMaterial().func_77996_d();
/* 133 */       int fortune = EnchantmentHelper.func_77517_e(living);
/* 134 */       boolean silk = EnchantmentHelper.func_77502_d(living);
/*     */       
/* 136 */       ArrayList<ItemStack> drops = RandomOre.getDroppedItems(id, meta, harvestlvl, fortune, silk, y);
/*     */       
/* 138 */       if ((drops != null) && (!drops.isEmpty())) {
/* 139 */         Iterator list = drops.iterator();
/*     */         
/* 141 */         while (list.hasNext()) {
/* 142 */           ItemStack newdrop = (ItemStack)list.next();
/*     */           
/* 144 */           if (newdrop != null) {
/* 145 */             if (newdrop.field_77994_a < 1) {
/* 146 */               newdrop.field_77994_a = 1;
/*     */             }
/* 148 */             dropBlockAsItem_do(world, x, y, z, newdrop);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 153 */     return super.onBlockStartBreak(item, x, y, z, living);
/*     */   }
/*     */   
/*     */   protected void dropBlockAsItem_do(World world, int x, int y, int z, ItemStack item) {
/* 157 */     if ((!world.field_72995_K) && (world.func_82736_K().func_82766_b("doTileDrops"))) {
/* 158 */       float f = 0.7F;
/* 159 */       double d0 = world.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5D;
/* 160 */       double d1 = world.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5D;
/* 161 */       double d2 = world.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5D;
/* 162 */       EntityItem entityitem = new EntityItem(world, x + d0, y + d1, z + d2, item);
/* 163 */       entityitem.field_70293_c = 10;
/* 164 */       world.func_72838_d(entityitem);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_77660_a(ItemStack item, World world, int id, int x, int y, int z, EntityLivingBase user)
/*     */   {
/* 170 */     Random rand = new Random();
/* 171 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/* 172 */       ((user instanceof EntityPlayer))) {
/* 173 */       ((EntityPlayer)user).func_71024_bL().func_75122_a(1, 0.2F);
/*     */     }
/*     */     
/*     */ 
/* 177 */     return super.func_77660_a(item, world, id, x, y, z, user);
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemHandpick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */