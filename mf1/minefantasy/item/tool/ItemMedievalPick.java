/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.IPublicMaterialItem;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemPickaxe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.FoodStats;
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
/*     */ 
/*     */ public class ItemMedievalPick
/*     */   extends ItemPickaxe
/*     */   implements IPublicMaterialItem, IWeaponSpecial
/*     */ {
/*     */   private int damageVsEntity;
/*     */   
/*     */   public ItemMedievalPick(int id, EnumToolMaterial material)
/*     */   {
/*  41 */     super(id, material);
/*  42 */     MinecraftForge.setToolClass(this, "pickaxe", material.func_77996_d());
/*  43 */     func_77637_a(ItemListMF.tabTool);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*     */   
/*     */   public float func_77638_a(ItemStack item, Block block)
/*     */   {
/*  51 */     if ((item != null) && 
/*  52 */       ((item.func_77973_b() instanceof ItemMedievalPick)) && 
/*  53 */       (block == Block.field_72089_ap)) {
/*  54 */       if (((ItemMedievalPick)item.func_77973_b()).getMaterial() == ToolMaterialMedieval.MITHRIL) {
/*  55 */         return this.field_77864_a * 1.5F;
/*     */       }
/*  57 */       if (((ItemMedievalPick)item.func_77973_b()).getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/*  58 */         return this.field_77864_a * 2.0F;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  63 */     return super.func_77638_a(item, block);
/*     */   }
/*     */   
/*     */   public boolean func_77641_a(Block block)
/*     */   {
/*  68 */     if (block == Block.field_72073_aw) {
/*  69 */       return (getMaterial().func_77996_d() >= 2) && (getMaterial() != ToolMaterialMedieval.BRONZE);
/*     */     }
/*  71 */     if (block == Block.field_71949_H) {
/*  72 */       return getMaterial().func_77996_d() >= 2;
/*     */     }
/*  74 */     if (block == Block.field_72089_ap) {
/*  75 */       return getMaterial().func_77996_d() >= 3;
/*     */     }
/*     */     
/*  78 */     int harvest = MinecraftForge.getBlockHarvestLevel(block, 0, "pickaxe");
/*  79 */     if (getMaterial().func_77996_d() >= harvest) {
/*  80 */       return true;
/*     */     }
/*  82 */     return super.func_77641_a(block);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/*  92 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/*  93 */       return rarity(itemStack, 1);
/*     */     }
/*  95 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/*  96 */       return rarity(itemStack, 2);
/*     */     }
/*  98 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/* 102 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/* 103 */     if (item.func_77948_v()) {
/* 104 */       if (lvl == 0) {
/* 105 */         lvl++;
/*     */       }
/* 107 */       lvl++;
/*     */     }
/* 109 */     if (lvl >= rarity.length) {
/* 110 */       lvl = rarity.length - 1;
/*     */     }
/* 112 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial()
/*     */   {
/* 117 */     return this.field_77862_b;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/* 122 */     func_111206_d("minefantasy:Tool/" + name);
/* 123 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 128 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 129 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 132 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 133 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_77660_a(ItemStack item, World world, int id, int x, int y, int z, EntityLivingBase user)
/*     */   {
/* 139 */     Random rand = new Random();
/* 140 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/* 141 */       ((user instanceof EntityPlayer))) {
/* 142 */       ((EntityPlayer)user).func_71024_bL().func_75122_a(1, 0.2F);
/*     */     }
/*     */     
/*     */ 
/* 146 */     return super.func_77660_a(item, world, id, x, y, z, user);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemMedievalPick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */