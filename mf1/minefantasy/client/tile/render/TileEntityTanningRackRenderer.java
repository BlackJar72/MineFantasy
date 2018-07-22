/*    */ package minefantasy.client.tile.render;
/*    */ 
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.client.tile.TileEntityTanningRack;
/*    */ import minefantasy.client.tile.model.ModelTanningRack;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.ItemRenderer;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.Icon;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class TileEntityTanningRackRenderer extends TileEntitySpecialRenderer
/*    */ {
/*    */   private ModelTanningRack model;
/*    */   
/*    */   public TileEntityTanningRackRenderer()
/*    */   {
/* 25 */     this.model = new ModelTanningRack();
/*    */   }
/*    */   
/*    */   public void renderAModelAt(TileEntityTanningRack tile, double d, double d1, double d2, float f) {
/* 29 */     int tiledirection = 1;int tileangle = 90 * tiledirection;
/*    */     
/* 31 */     if (tile.field_70331_k != null) {
/* 32 */       tiledirection = tile.direction;
/*    */     }
/*    */     
/* 35 */     switch (tiledirection) {
/*    */     case 0: 
/* 37 */       tileangle = 0;
/* 38 */       break;
/*    */     
/*    */     case 1: 
/* 41 */       tileangle = 270;
/* 42 */       break;
/*    */     
/*    */     case 2: 
/* 45 */       tileangle = 180;
/* 46 */       break;
/*    */     
/*    */     case 3: 
/*    */     case 4: 
/* 50 */       tileangle = 90;
/*    */     }
/*    */     
/*    */     
/* 54 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/tanner.png")));
/* 55 */     GL11.glPushMatrix();
/* 56 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.45F, (float)d2 + 0.5F);
/* 57 */     GL11.glRotatef(tileangle, 0.0F, 1.0F, 0.0F);
/* 58 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/* 59 */     this.model.renderModel(0.0625F);
/* 60 */     renderHungItem(tile, d, d1, d2, f);
/* 61 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */ 
/*    */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*    */   {
/* 67 */     renderAModelAt((TileEntityTanningRack)tileentity, d, d1, d2, f);
/*    */   }
/*    */   
/*    */   private void renderHungItem(TileEntityTanningRack tile, double d, double d1, double d2, float f) {
/* 71 */     ItemStack itemstack = tile.getHung();
/* 72 */     if (itemstack != null) {
/* 73 */       Item item = itemstack.func_77973_b();
/* 74 */       Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*    */       
/* 76 */       Tessellator image = Tessellator.field_78398_a;
/* 77 */       Icon index = item.func_77617_a(itemstack.func_77960_j());
/* 78 */       float x1 = index.func_94209_e();
/* 79 */       float x2 = index.func_94212_f();
/* 80 */       float y1 = index.func_94206_g();
/* 81 */       float y2 = index.func_94210_h();
/* 82 */       float xPos = 0.5F;
/* 83 */       float yPos = -0.5F;
/* 84 */       GL11.glEnable(32826);
/* 85 */       GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 86 */       float var13 = 1.0F;
/* 87 */       GL11.glScalef(var13, var13, var13);
/*    */       
/* 89 */       GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 90 */       GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/* 91 */       ItemRenderer.func_78439_a(image, x2, y1, x1, y2, index.func_94211_a(), index.func_94216_b(), 0.0625F);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityTanningRackRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */