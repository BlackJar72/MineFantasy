/*    */ package minefantasy.client.tile.render;
/*    */ 
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.client.tile.TileEntitySmelter;
/*    */ import minefantasy.client.tile.model.ModelCrucible;
/*    */ import minefantasy.client.tile.model.ModelSmelter;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class TileEntitySmelterRenderer extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*    */ {
/*    */   private ModelSmelter model;
/*    */   private ModelCrucible hearth;
/*    */   
/*    */   public TileEntitySmelterRenderer()
/*    */   {
/* 20 */     this.model = new ModelSmelter();
/* 21 */     this.hearth = new ModelCrucible();
/*    */   }
/*    */   
/*    */   public void renderAModelAt(TileEntitySmelter tile, double d, double d1, double d2, float f) {
/* 25 */     int tiledirection = 1;int tileangle = 90 * tiledirection;
/*    */     
/* 27 */     if (tile.field_70331_k != null) {
/* 28 */       tiledirection = tile.direction;
/*    */     }
/*    */     
/* 31 */     switch (tiledirection) {
/*    */     case 0: 
/* 33 */       tileangle = 0;
/* 34 */       break;
/*    */     
/*    */     case 1: 
/* 37 */       tileangle = 270;
/* 38 */       break;
/*    */     
/*    */     case 2: 
/* 41 */       tileangle = 180;
/* 42 */       break;
/*    */     
/*    */     case 3: 
/*    */     case 4: 
/* 46 */       tileangle = 90;
/*    */     }
/*    */     
/*    */     
/*    */ 
/* 51 */     String type = "Bloomery";
/* 52 */     if (tile.getTier() == 1) {
/* 53 */       type = "crucible";
/* 54 */     } else if (tile.getTier() == 2) {
/* 55 */       type = "crucibleGranite";
/*    */     }
/*    */     
/* 58 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/" + type + ".png")));
/* 59 */     if ((tile.isBurning()) && (tile.getTier() == 0)) {
/* 60 */       Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/" + type + "Active.png")));
/*    */     }
/* 62 */     boolean display = tile.hasSmelted();
/* 63 */     if (tile.getTier() >= 1) {
/* 64 */       display = tile.isBurning();
/*    */     }
/* 66 */     GL11.glPushMatrix();
/* 67 */     float scale = 1.0F;
/* 68 */     if (tile.field_70331_k != null) {
/* 69 */       scale = 1.0F;
/*    */     }
/*    */     
/* 72 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + scale, (float)d2 + 0.5F);
/* 73 */     GL11.glRotatef(tileangle + 180, 0.0F, 1.0F, 0.0F);
/* 74 */     GL11.glScalef(scale, -scale, -scale);
/*    */     
/* 76 */     if (tile.getTier() == 0) {
/* 77 */       this.model.renderModel(0.0625F, display);
/*    */     }
/* 79 */     if (tile.getTier() >= 1) {
/* 80 */       this.hearth.renderModel(0.0625F, display, tile.willShowBase());
/*    */     }
/* 82 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */ 
/*    */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*    */   {
/* 88 */     renderAModelAt((TileEntitySmelter)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntitySmelterRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */