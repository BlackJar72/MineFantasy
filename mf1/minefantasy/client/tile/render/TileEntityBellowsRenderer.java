/*    */ package minefantasy.client.tile.render;
/*    */ 
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.client.tile.TileEntityBellows;
/*    */ import minefantasy.client.tile.model.ModelBellows;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class TileEntityBellowsRenderer extends TileEntitySpecialRenderer
/*    */ {
/*    */   private ModelBellows model;
/*    */   
/*    */   public TileEntityBellowsRenderer()
/*    */   {
/* 17 */     this.model = new ModelBellows();
/*    */   }
/*    */   
/*    */   public void renderAModelAt(TileEntityBellows tile, double d, double d1, double d2, float f) {
/* 21 */     int tiledirection = 1;int tileangle = 90 * tiledirection;
/*    */     
/* 23 */     if (tile.field_70331_k != null) {
/* 24 */       tiledirection = tile.direction;
/*    */     }
/*    */     
/* 27 */     switch (tiledirection) {
/*    */     case 0: 
/* 29 */       tileangle = 90;
/* 30 */       break;
/*    */     
/*    */     case 1: 
/* 33 */       tileangle = 0;
/* 34 */       break;
/*    */     
/*    */     case 2: 
/* 37 */       tileangle = 270;
/* 38 */       break;
/*    */     
/*    */     case 3: 
/* 41 */       tileangle = 180;
/*    */     }
/*    */     
/*    */     
/* 45 */     int p = tile.press;
/* 46 */     this.model.rotate(p);
/*    */     
/* 48 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(minefantasy.system.MFResource.image("/item/Bellows.png")));
/* 49 */     GL11.glPushMatrix();
/* 50 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.525F, (float)d2 + 0.5F);
/* 51 */     GL11.glRotatef(tileangle, 0.0F, 1.0F, 0.0F);
/* 52 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/*    */     
/* 54 */     this.model.renderModel(p, 0.0625F);
/*    */     
/* 56 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */ 
/*    */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*    */   {
/* 62 */     renderAModelAt((TileEntityBellows)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityBellowsRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */