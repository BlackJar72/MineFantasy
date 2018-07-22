/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.aesthetic.IWeaponrackHangable;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.IPublicMaterialItem;
/*     */ import mods.battlegear2.api.ISheathed;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemAxe;
/*     */ import net.minecraft.item.ItemShears;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IShearable;
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
/*     */ public class ItemSaw
/*     */   extends ItemAxe
/*     */   implements IWeaponrackHangable, IPublicMaterialItem, IWeaponSpecial, ISheathed
/*     */ {
/*     */   private static Block[] blocksEffectiveAgainst;
/*     */   
/*     */   public ItemSaw(int id, EnumToolMaterial material)
/*     */   {
/*  47 */     super(id, material);
/*  48 */     this.field_77862_b = material;
/*  49 */     this.field_77864_a = (material.func_77998_b() * 2.0F);
/*  50 */     func_77656_e(material.func_77997_a() / 2);
/*  51 */     this.field_77865_bY = (0.0F + material.func_78000_c());
/*  52 */     func_77637_a(ItemListMF.tabTool);
/*     */   }
/*     */   
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
/*     */   public float getStrVsBlock(ItemStack item, Block block, int meta)
/*     */   {
/*  87 */     if ((block.field_72018_cp == Material.field_76257_i) || ((block instanceof IShearable)) || (Item.field_77745_be.func_77638_a(item, block) > super.getStrVsBlock(item, block, meta))) {
/*  88 */       return this.field_77864_a;
/*     */     }
/*  90 */     return super.getStrVsBlock(item, block, meta);
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial()
/*     */   {
/*  95 */     return this.field_77862_b;
/*     */   }
/*     */   
/*     */   public boolean func_77660_a(ItemStack item, World world, int id, int x, int y, int z, EntityLivingBase user)
/*     */   {
/* 100 */     if ((Block.field_71973_m[id].func_71934_m(world, x, y, z) != 0.0D) && 
/* 101 */       (!world.field_72995_K) && (world.func_72803_f(x, y, z) != Material.field_76257_i)) {
/* 102 */       item.func_77972_a(1, user);
/*     */     }
/*     */     
/* 105 */     Random rand = new Random();
/* 106 */     if ((world.func_72803_f(x, y, z) == Material.field_76245_d) && (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) && (rand.nextInt(8) == 0)) {
/* 107 */       dropItem(world, x, y, z, new ItemStack(Item.field_77705_m, 1, 1));
/*     */     }
/*     */     
/* 110 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/* 111 */       ((user instanceof EntityPlayer))) {
/* 112 */       ((EntityPlayer)user).func_71024_bL().func_75122_a(1, 0.2F);
/*     */     }
/*     */     
/*     */ 
/* 116 */     return true;
/*     */   }
/*     */   
/*     */   private void dropItem(World world, int x, int y, int z, ItemStack itemStack) {
/* 120 */     EntityItem drop = new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, itemStack);
/* 121 */     drop.field_70293_c = 10;
/* 122 */     world.func_72838_d(drop);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*     */   
/*     */ 
/*     */   public Item func_77655_b(String name)
/*     */   {
/* 131 */     func_111206_d("minefantasy:Tool/" + name);
/* 132 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   public boolean func_77644_a(ItemStack item, EntityLivingBase target, EntityLivingBase user) {
/* 136 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 137 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 140 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/* 141 */       ((target instanceof EntityLiving))) {
/* 142 */       PotionEffect poison = new PotionEffect(Potion.field_76436_u.field_76415_H, 100, 1);
/* 143 */       ((EntityLiving)target).func_70690_d(poison);
/*     */     }
/*     */     
/* 146 */     return super.func_77644_a(item, target, user);
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 151 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 152 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 155 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 156 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean sheatheOnBack(ItemStack item)
/*     */   {
/* 162 */     return true;
/*     */   }
/*     */   
/*     */   public boolean canUseRenderer(ItemStack item)
/*     */   {
/* 167 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemSaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */