/*    */ package minefantasy.api.cooking;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UtensilManager
/*    */ {
/*    */   public static String getTypeOfTool(ItemStack tool)
/*    */   {
/* 12 */     if ((tool != null) && (tool.func_77973_b() != null) && 
/* 13 */       ((tool.func_77973_b() instanceof IUtensil))) {
/* 14 */       return ((IUtensil)tool.func_77973_b()).getType(tool);
/*    */     }
/*    */     
/*    */ 
/* 18 */     return "Null";
/*    */   }
/*    */   
/*    */   public static boolean isToolValid(ItemStack tool, String type) {
/* 22 */     return getTypeOfTool(tool).equalsIgnoreCase(type);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/cooking/UtensilManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */