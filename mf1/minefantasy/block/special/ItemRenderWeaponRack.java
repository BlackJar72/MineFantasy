/*    */ package minefantasy.block.special;
/*    */ 
/*    */ import minefantasy.client.tile.model.ModelWeaponRack;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*    */ 
/*    */ public class ItemRenderWeaponRack implements net.minecraftforge.client.IItemRenderer
/*    */ {
/*    */   private ModelWeaponRack model;
/*    */   
/*    */   public ItemRenderWeaponRack()
/*    */   {
/* 14 */     this.model = new ModelWeaponRack();
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*    */   {
/* 20 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, net.minecraftforge.client.IItemRenderer.ItemRendererHelper helper)
/*    */   {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*    */   {
/* 32 */     TileEntityRenderer.field_76963_a.func_76949_a(new minefantasy.client.tile.TileEntityWeaponRack(), 0.0D, 0.0D, 0.0D, 0.0F);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/ItemRenderWeaponRack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */