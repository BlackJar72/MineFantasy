/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import minefantasy.client.tile.model.ModelTripHammer;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*    */ 
/*    */ public class ItemRenderTripHammer implements net.minecraftforge.client.IItemRenderer
/*    */ {
/*    */   private ModelTripHammer model;
/*    */   private minefantasy.client.tile.model.ModelTripHammerBack model2;
/*    */   
/*    */   public ItemRenderTripHammer()
/*    */   {
/* 15 */     this.model = new ModelTripHammer();
/* 16 */     this.model2 = new minefantasy.client.tile.model.ModelTripHammerBack();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*    */   {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, net.minecraftforge.client.IItemRenderer.ItemRendererHelper helper)
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*    */   {
/* 34 */     TileEntityRenderer.field_76963_a.func_76949_a(new minefantasy.client.tile.TileEntityTripHammer(item.func_77960_j()), 0.0D, 0.0D, 0.0D, 0.0F);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemRenderTripHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */