/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import minefantasy.client.tile.TileEntityFoodPrep;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.IItemRenderer;
/*    */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*    */ import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
/*    */ 
/*    */ 
/*    */ public class ItemRenderFoodPrep
/*    */   implements IItemRenderer
/*    */ {
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*    */   {
/* 16 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*    */   {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*    */   {
/* 28 */     TileEntityRenderer.field_76963_a.func_76949_a(new TileEntityFoodPrep(), 0.0D, 0.0D, 0.0D, 0.0F);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemRenderFoodPrep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */