/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import minefantasy.client.tile.model.ModelAnvil;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*    */ import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
/*    */ 
/*    */ public class ItemRenderAnvilMF implements net.minecraftforge.client.IItemRenderer
/*    */ {
/*    */   private ModelAnvil model;
/*    */   
/*    */   public ItemRenderAnvilMF()
/*    */   {
/* 15 */     this.model = new ModelAnvil();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*    */   {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*    */   {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*    */   {
/* 34 */     TileEntityRenderer.field_76963_a.func_76949_a(new minefantasy.client.tile.TileEntityAnvil(item.func_77960_j(), true), 0.0D, 0.0D, 0.0D, 0.0F);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemRenderAnvilMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */