/*    */ package minefantasy.item.tool;
/*    */ 
/*    */ import java.util.List;
/*    */ import minefantasy.api.tailor.INeedle;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.EnumRarity;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemNeedle
/*    */   extends Item
/*    */   implements INeedle
/*    */ {
/*    */   private float efficiency;
/*    */   private int tier;
/*    */   
/*    */   public ItemNeedle(int id, EnumToolMaterial material, int customTier)
/*    */   {
/* 25 */     this(id, material);
/* 26 */     this.tier = customTier;
/*    */   }
/*    */   
/*    */   public ItemNeedle(int id, EnumToolMaterial material) {
/* 30 */     super(id);
/* 31 */     func_77625_d(1);
/* 32 */     func_77637_a(ItemListMF.tabTailor);
/* 33 */     func_77656_e(material.func_77997_a() * 4);
/*    */     
/* 35 */     this.efficiency = material.func_77998_b();
/* 36 */     this.tier = material.func_77996_d();
/*    */   }
/*    */   
/*    */   public Item func_77655_b(String name)
/*    */   {
/* 41 */     func_111206_d("minefantasy:Tool/" + name);
/* 42 */     return super.func_77655_b(name);
/*    */   }
/*    */   
/*    */   public float getEfficiency()
/*    */   {
/* 47 */     return this.efficiency;
/*    */   }
/*    */   
/*    */   public int getTier()
/*    */   {
/* 52 */     return this.tier;
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*    */   {
/* 57 */     if (id != ItemListMF.needleBone.field_77779_bT) {
/* 58 */       return;
/*    */     }
/* 60 */     add(list, ItemListMF.needleBone);
/* 61 */     add(list, ItemListMF.needleBronze);
/* 62 */     add(list, ItemListMF.needleIron);
/* 63 */     add(list, ItemListMF.needleSteel);
/* 64 */     add(list, ItemListMF.needleDeepIron);
/* 65 */     add(list, ItemListMF.needleMithril);
/*    */     
/* 67 */     add(list, 151);
/* 68 */     add(list, Item.field_77683_K);
/*    */   }
/*    */   
/*    */   private void add(List list, int item) {
/* 72 */     list.add(new ItemStack(ItemListMF.misc, 1, item));
/*    */   }
/*    */   
/*    */   private void add(List list, Item item) {
/* 76 */     list.add(new ItemStack(item));
/*    */   }
/*    */   
/*    */   private void add(List list, Block block) {
/* 80 */     list.add(new ItemStack(block));
/*    */   }
/*    */   
/*    */   private EnumRarity rarity(ItemStack item, int lvl) {
/* 84 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/* 85 */     if (item.func_77948_v()) {
/* 86 */       if (lvl == 0) {
/* 87 */         lvl++;
/*    */       }
/* 89 */       lvl++;
/*    */     }
/* 91 */     if (lvl >= rarity.length) {
/* 92 */       lvl = rarity.length - 1;
/*    */     }
/* 94 */     return rarity[lvl];
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemNeedle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */