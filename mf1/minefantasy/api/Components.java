/*    */ package minefantasy.api;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import java.lang.reflect.Field;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Components
/*    */ {
/*    */   public static ItemStack getItem(String itemString, int meta)
/*    */   {
/* 19 */     ItemStack item = null;
/*    */     try
/*    */     {
/* 22 */       String itemClass = "minefantasy.item.ItemListMF";
/* 23 */       Object obj = Class.forName(itemClass).getField(itemString).get(null);
/* 24 */       if ((obj instanceof Item)) {
/* 25 */         item = new ItemStack((Item)obj, 1, meta);
/* 26 */       } else if ((obj instanceof Block)) {
/* 27 */         item = new ItemStack((Block)obj, 1, meta);
/* 28 */       } else if ((obj instanceof ItemStack)) {
/* 29 */         item = (ItemStack)obj;
/*    */       }
/*    */     } catch (Exception ex) {
/* 32 */       FMLLog.warning("[MineFantasy] Could not retrieve item or block identified by: " + itemString, new Object[0]);
/*    */     }
/*    */     
/* 35 */     return item;
/*    */   }
/*    */   
/*    */   public static ItemStack component(int meta) {
/* 39 */     return getItem("misc", meta);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/Components.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */