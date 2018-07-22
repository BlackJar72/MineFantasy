/*    */ package minefantasy.client.tile.render;
/*    */ 
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.client.tile.TileEntityDogBowl;
/*    */ import minefantasy.client.tile.model.ModelDogbowl;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class TileEntityDogbowlRenderer extends TileEntitySpecialRenderer
/*    */ {
/*    */   private ModelDogbowl model;
/*    */   
/*    */   public TileEntityDogbowlRenderer()
/*    */   {
/* 19 */     this.model = new ModelDogbowl();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void renderAModelAt(TileEntityDogBowl tile, double d, double d1, double d2, float f)
/*    */   {
/* 27 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/dogbowl" + tile.getTex(tile.itemMeta) + ".png")));
/* 28 */     GL11.glPushMatrix();
/* 29 */     float yOffset = 0.0625F;
/*    */     
/* 31 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + yOffset, (float)d2 + 0.5F);
/* 32 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/* 33 */     this.model.renderModel(tile.food, tile.getFoodMax(), 0.0625F);
/* 34 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */ 
/*    */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*    */   {
/* 40 */     renderAModelAt((TileEntityDogBowl)tileentity, d, d1, d2, f);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityDogbowlRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */