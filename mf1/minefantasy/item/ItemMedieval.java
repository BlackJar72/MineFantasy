/*    */ package minefantasy.item;
/*    */ 
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemMedieval
/*    */   extends Item
/*    */ {
/*    */   public boolean FullSize;
/*    */   public boolean using;
/*    */   
/*    */   public ItemMedieval(int i, boolean b, int s)
/*    */   {
/* 21 */     super(i);
/* 22 */     func_77637_a(ItemListMF.tabMedieval);
/* 23 */     this.FullSize = b;
/* 24 */     this.field_77777_bU = Math.max(1, s);
/*    */   }
/*    */   
/*    */   public ItemMedieval(int i, boolean b, int s, int d) {
/* 28 */     this(i, b, s);
/* 29 */     func_77656_e(d);
/*    */   }
/*    */   
/*    */   public boolean func_77662_d()
/*    */   {
/* 34 */     return this.FullSize;
/*    */   }
/*    */   
/*    */   public Item func_77655_b(String name)
/*    */   {
/* 39 */     func_111206_d("minefantasy:Misc/" + name);
/* 40 */     return super.func_77655_b(name);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemMedieval.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */