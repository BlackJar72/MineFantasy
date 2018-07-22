/*    */ package minefantasy.api.arrow;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Arrows
/*    */ {
/* 14 */   public static List<ItemStack> arrows = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/* 18 */   public static List<IArrowHandler> handlers = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */   public static void addArrow(ItemStack item)
/*    */   {
/* 24 */     arrows.add(item);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static void addArrow(Item item)
/*    */   {
/* 31 */     addArrow(new ItemStack(item, 1, 32767));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static void addHandler(IArrowHandler handler)
/*    */   {
/* 38 */     handlers.add(handler);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static ItemStack getLoadedArrow(ItemStack bow)
/*    */   {
/* 45 */     if ((bow != null) && (bow.func_77942_o()) && 
/* 46 */       (bow.func_77978_p().func_74764_b("loadedArrow"))) {
/* 47 */       return ItemStack.func_77949_a(bow.func_77978_p().func_74775_l("loadedArrow"));
/*    */     }
/*    */     
/* 50 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/arrow/Arrows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */