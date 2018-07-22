/*    */ package minefantasy.item.tool;
/*    */ 
/*    */ import java.util.List;
/*    */ import minefantasy.api.cooking.IUtensil;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import minefantasy.item.ToolMaterialMedieval;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.EnumRarity;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ItemTool;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemMallet
/*    */   extends ItemTool
/*    */   implements IUtensil
/*    */ {
/*    */   private EnumToolMaterial material;
/*    */   
/*    */   public ItemMallet(int i, EnumToolMaterial mat)
/*    */   {
/* 35 */     super(i, mat.func_77998_b(), mat, new Block[0]);
/* 36 */     this.material = mat;
/* 37 */     func_77625_d(1);
/* 38 */     func_77656_e(mat.func_77997_a() * 4);
/* 39 */     func_77637_a(ItemListMF.tabTool);
/* 40 */     this.field_77777_bU = 1;
/*    */   }
/*    */   
/*    */   public boolean func_77662_d()
/*    */   {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public int func_77619_b() {
/* 49 */     return this.material.func_77995_e();
/*    */   }
/*    */   
/*    */   public Item func_77655_b(String name)
/*    */   {
/* 54 */     func_111206_d("minefantasy:Tool/" + name);
/* 55 */     return super.func_77655_b(name);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*    */   
/*    */ 
/*    */   public EnumRarity func_77613_e(ItemStack itemStack)
/*    */   {
/* 65 */     if (this.material == ToolMaterialMedieval.EBONY) {
/* 66 */       return rarity(itemStack, 1);
/*    */     }
/* 68 */     return super.func_77613_e(itemStack);
/*    */   }
/*    */   
/*    */   private EnumRarity rarity(ItemStack item, int lvl) {
/* 72 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/* 73 */     if (item.func_77948_v()) {
/* 74 */       if (lvl == 0) {
/* 75 */         lvl++;
/*    */       }
/* 77 */       lvl++;
/*    */     }
/* 79 */     if (lvl >= rarity.length) {
/* 80 */       lvl = rarity.length - 1;
/*    */     }
/* 82 */     return rarity[lvl];
/*    */   }
/*    */   
/*    */   public String getType(ItemStack tool)
/*    */   {
/* 87 */     return "mallet";
/*    */   }
/*    */   
/*    */   public float getEfficiency(ItemStack tool)
/*    */   {
/* 92 */     return this.material.func_77998_b();
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemMallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */