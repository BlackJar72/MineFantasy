/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import minefantasy.client.tile.model.ModelCrucible;
/*    */ import minefantasy.client.tile.model.ModelSmelter;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*    */ import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
/*    */ 
/*    */ public class ItemRenderSmelter implements net.minecraftforge.client.IItemRenderer
/*    */ {
/*    */   private ModelSmelter model;
/*    */   private ModelCrucible hearth;
/*    */   
/*    */   public ItemRenderSmelter()
/*    */   {
/* 17 */     this.model = new ModelSmelter();
/* 18 */     this.hearth = new ModelCrucible();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*    */   {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*    */   {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*    */   {
/* 37 */     TileEntityRenderer.field_76963_a.func_76949_a(new minefantasy.client.tile.TileEntitySmelter(item.func_77960_j()), 0.0D, 0.0D, 0.0D, 0.0F);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemRenderSmelter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */