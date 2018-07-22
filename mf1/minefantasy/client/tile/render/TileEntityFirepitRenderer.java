/*    */ package minefantasy.client.tile.render;
/*    */ 
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.client.tile.TileEntityFirepit;
/*    */ import minefantasy.client.tile.model.ModelFirepit;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class TileEntityFirepitRenderer extends TileEntitySpecialRenderer
/*    */ {
/*    */   private ModelFirepit model;
/*    */   
/*    */   public TileEntityFirepitRenderer()
/*    */   {
/* 18 */     this.model = new ModelFirepit();
/*    */   }
/*    */   
/*    */   public void renderAModelAt(TileEntityFirepit tile, double d, double d1, double d2, float f) {
/* 22 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/firepit.png")));
/*    */     
/* 24 */     GL11.glPushMatrix();
/* 25 */     float yOffset = 0.3125F;
/*    */     
/* 27 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + yOffset, (float)d2 + 0.5F);
/* 28 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/* 29 */     this.model.renderModel(tile, 0.0625F);
/* 30 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */ 
/*    */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*    */   {
/* 36 */     renderAModelAt((TileEntityFirepit)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityFirepitRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */