/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.IPublicMaterialItem;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemAxe;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemMedievalAxe
/*     */   extends ItemAxe
/*     */   implements IPublicMaterialItem, IWeaponSpecial
/*     */ {
/*     */   private static Block[] blocksEffectiveAgainst;
/*     */   
/*     */   public ItemMedievalAxe(int id, EnumToolMaterial material)
/*     */   {
/*  39 */     super(id, material);
/*  40 */     this.field_77862_b = material;
/*  41 */     func_77637_a(ItemListMF.tabTool);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*     */   
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/*  66 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/*  67 */       return rarity(itemStack, 1);
/*     */     }
/*  69 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/*  70 */       return rarity(itemStack, 2);
/*     */     }
/*  72 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/*  76 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/*  77 */     if (item.func_77948_v()) {
/*  78 */       if (lvl == 0) {
/*  79 */         lvl++;
/*     */       }
/*  81 */       lvl++;
/*     */     }
/*  83 */     if (lvl >= rarity.length) {
/*  84 */       lvl = rarity.length - 1;
/*     */     }
/*  86 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial()
/*     */   {
/*  91 */     return this.field_77862_b;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/*  96 */     func_111206_d("minefantasy:Tool/" + name);
/*  97 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   public boolean func_77660_a(ItemStack item, World world, int id, int x, int y, int z, EntityLivingBase user)
/*     */   {
/* 102 */     Random rand = new Random();
/* 103 */     if ((world.func_72803_f(x, y, z) == Material.field_76245_d) && (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) && (rand.nextInt(12) == 0)) {
/* 104 */       dropItem(world, x, y, z, new ItemStack(Item.field_77705_m, 1, 1));
/*     */     }
/*     */     
/* 107 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/* 108 */       ((user instanceof EntityPlayer))) {
/* 109 */       ((EntityPlayer)user).func_71024_bL().func_75122_a(1, 0.2F);
/*     */     }
/*     */     
/*     */ 
/* 113 */     return super.func_77660_a(item, world, id, x, y, y, user);
/*     */   }
/*     */   
/*     */   private void dropItem(World world, int x, int y, int z, ItemStack itemStack) {
/* 117 */     EntityItem drop = new EntityItem(world, x + 0.5D, y + 0.5D, z + 0.5D, itemStack);
/* 118 */     drop.field_70293_c = 10;
/* 119 */     world.func_72838_d(drop);
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 124 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 125 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 128 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 129 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemMedievalAxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */