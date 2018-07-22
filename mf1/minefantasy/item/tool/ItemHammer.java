/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.List;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.anvil.IHammer;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemTool;
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
/*     */ public class ItemHammer
/*     */   extends ItemTool
/*     */   implements IHammer, IWeaponSpecial
/*     */ {
/*     */   private EnumToolMaterial hammerMaterial;
/*     */   private float efficiency;
/*     */   private int level;
/*     */   
/*     */   public ItemHammer(int i, float power, EnumToolMaterial mat)
/*     */   {
/*  39 */     super(i, mat.func_77998_b(), mat, new Block[0]);
/*  40 */     this.hammerMaterial = mat;
/*  41 */     func_77625_d(1);
/*  42 */     this.efficiency = power;
/*  43 */     func_77656_e(mat.func_77997_a());
/*  44 */     func_77637_a(ItemListMF.tabTool);
/*  45 */     this.field_77777_bU = 1;
/*  46 */     this.level = (mat == ToolMaterialMedieval.ORNATE ? 1 : 0);
/*  47 */     this.field_77865_bY = (mat.func_78000_c() + 2.0F);
/*     */   }
/*     */   
/*     */   public boolean func_77662_d()
/*     */   {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public float getForgeStrength() {
/*  56 */     return this.efficiency;
/*     */   }
/*     */   
/*     */   public int func_77619_b() {
/*  60 */     return this.hammerMaterial.func_77995_e();
/*     */   }
/*     */   
/*     */   public int getForgeLevel() {
/*  64 */     return this.level;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/*  69 */     func_111206_d("minefantasy:Tool/" + name);
/*  70 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   public float func_77638_a(ItemStack stack, Block block)
/*     */   {
/*  75 */     if (block == MineFantasyBase.MFBlockAnvil) {
/*  76 */       return 0.0F;
/*     */     }
/*  78 */     return super.func_77638_a(stack, block);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*     */   
/*     */ 
/*     */   public void func_77624_a(ItemStack weapon, EntityPlayer player, List list, boolean fullInfo)
/*     */   {
/*  88 */     super.func_77624_a(weapon, player, list, fullInfo);
/*     */     
/*  90 */     list.add("Efficiency: " + getForgeStrength());
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/*  95 */     if ((this.hammerMaterial == ToolMaterialMedieval.DRAGONFORGE) || (this.hammerMaterial == ToolMaterialMedieval.ORNATE)) {
/*  96 */       return rarity(itemStack, 1);
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
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 117 */     if (this.hammerMaterial == ToolMaterialMedieval.DRAGONFORGE) {
/* 118 */       target.func_70015_d(20);
/*     */     }
/* 120 */     if (this.hammerMaterial == ToolMaterialMedieval.IGNOTUMITE) {
/* 121 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial() {
/* 126 */     return this.hammerMaterial;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */