/*    */ package minefantasy.item;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemPetChange
/*    */   extends Item
/*    */ {
/*    */   public ItemPetChange(int id)
/*    */   {
/* 15 */     super(id);
/* 16 */     func_77625_d(1);
/* 17 */     func_77637_a(ItemListMF.tabPets);
/*    */   }
/*    */   
/*    */ 
/*    */   public Item func_77655_b(String name)
/*    */   {
/* 23 */     func_111206_d("minefantasy:Pets/" + name);
/* 24 */     return super.func_77655_b(name);
/*    */   }
/*    */   
/*    */   private void addTabItems(int id, CreativeTabs tabs, List list) {}
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemPetChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */