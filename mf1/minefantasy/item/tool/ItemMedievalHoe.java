/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.IPublicMaterialItem;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemHoe;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemMedievalHoe
/*     */   extends ItemHoe
/*     */   implements IPublicMaterialItem, IWeaponSpecial
/*     */ {
/*     */   private EnumToolMaterial toolMaterial;
/*     */   
/*     */   public ItemMedievalHoe(int id, EnumToolMaterial material)
/*     */   {
/*  44 */     super(id, material);
/*  45 */     this.toolMaterial = material;
/*  46 */     func_77656_e(material.func_77997_a());
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
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/*  61 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/*  62 */       return rarity(itemStack, 1);
/*     */     }
/*  64 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/*  65 */       return rarity(itemStack, 2);
/*     */     }
/*  67 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/*  71 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/*  72 */     if (item.func_77948_v()) {
/*  73 */       if (lvl == 0) {
/*  74 */         lvl++;
/*     */       }
/*  76 */       lvl++;
/*     */     }
/*  78 */     if (lvl >= rarity.length) {
/*  79 */       lvl = rarity.length - 1;
/*     */     }
/*  81 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial() {
/*  85 */     return this.toolMaterial;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/*  90 */     func_111206_d("minefantasy:Tool/" + name);
/*  91 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/*  96 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/*  97 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 100 */     attacker.func_70691_i(1.0F);
/*     */   }
/*     */   
/*     */   public boolean func_77660_a(ItemStack item, World world, int id, int x, int y, int z, EntityLivingBase user)
/*     */   {
/* 105 */     Random rand = new Random();
/* 106 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/* 107 */       ((user instanceof EntityPlayer))) {
/* 108 */       ((EntityPlayer)user).func_71024_bL().func_75122_a(1, 0.2F);
/*     */     }
/*     */     
/* 111 */     return super.func_77660_a(item, world, id, x, y, z, user);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemMedievalHoe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */