/*    */ package minefantasy.client.entityrender;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.entity.EntityShrapnel;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderShrapnel
/*    */   extends Render
/*    */ {
/*    */   public void renderArrow(EntityShrapnel arrow, double x, double y, double z, float xr, float yr)
/*    */   {
/* 23 */     loadTexture(MFResource.image("/item/Projectile/" + arrow.getTexture() + ".png"));
/* 24 */     GL11.glPushMatrix();
/* 25 */     GL11.glTranslatef((float)x, (float)y, (float)z);
/* 26 */     GL11.glRotatef(arrow.field_70126_B + (arrow.field_70177_z - arrow.field_70126_B) * yr - 90.0F, 0.0F, 1.0F, 0.0F);
/* 27 */     GL11.glRotatef(arrow.field_70127_C + (arrow.field_70125_A - arrow.field_70127_C) * yr, 0.0F, 0.0F, 1.0F);
/* 28 */     Tessellator var10 = Tessellator.field_78398_a;
/* 29 */     byte var11 = 0;
/* 30 */     float var12 = 0.0F;
/* 31 */     float var13 = 0.5F;
/* 32 */     float var14 = (0 + var11 * 10) / 32.0F;
/* 33 */     float var15 = (5 + var11 * 10) / 32.0F;
/* 34 */     float var16 = 0.0F;
/* 35 */     float var17 = 0.15625F;
/* 36 */     float var18 = (5 + var11 * 10) / 32.0F;
/* 37 */     float var19 = (10 + var11 * 10) / 32.0F;
/* 38 */     float var20 = 0.05625F;
/* 39 */     GL11.glEnable(32826);
/* 40 */     float var21 = arrow.field_70249_b - yr;
/*    */     
/* 42 */     if (var21 > 0.0F) {
/* 43 */       float var22 = -MathHelper.func_76126_a(var21 * 3.0F) * var21;
/* 44 */       GL11.glRotatef(var22, 0.0F, 0.0F, 1.0F);
/*    */     }
/*    */     
/* 47 */     GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
/* 48 */     GL11.glScalef(var20, var20, var20);
/* 49 */     GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
/* 50 */     GL11.glNormal3f(var20, 0.0F, 0.0F);
/* 51 */     var10.func_78382_b();
/* 52 */     var10.func_78374_a(-7.0D, -2.0D, -2.0D, var16, var18);
/* 53 */     var10.func_78374_a(-7.0D, -2.0D, 2.0D, var17, var18);
/* 54 */     var10.func_78374_a(-7.0D, 2.0D, 2.0D, var17, var19);
/* 55 */     var10.func_78374_a(-7.0D, 2.0D, -2.0D, var16, var19);
/* 56 */     var10.func_78381_a();
/* 57 */     GL11.glNormal3f(-var20, 0.0F, 0.0F);
/* 58 */     var10.func_78382_b();
/* 59 */     var10.func_78374_a(-7.0D, 2.0D, -2.0D, var16, var18);
/* 60 */     var10.func_78374_a(-7.0D, 2.0D, 2.0D, var17, var18);
/* 61 */     var10.func_78374_a(-7.0D, -2.0D, 2.0D, var17, var19);
/* 62 */     var10.func_78374_a(-7.0D, -2.0D, -2.0D, var16, var19);
/* 63 */     var10.func_78381_a();
/*    */     
/* 65 */     for (int var23 = 0; var23 < 4; var23++) {
/* 66 */       GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/* 67 */       GL11.glNormal3f(0.0F, 0.0F, var20);
/* 68 */       var10.func_78382_b();
/* 69 */       var10.func_78374_a(-8.0D, -2.0D, 0.0D, var12, var14);
/* 70 */       var10.func_78374_a(8.0D, -2.0D, 0.0D, var13, var14);
/* 71 */       var10.func_78374_a(8.0D, 2.0D, 0.0D, var13, var15);
/* 72 */       var10.func_78374_a(-8.0D, 2.0D, 0.0D, var12, var15);
/* 73 */       var10.func_78381_a();
/*    */     }
/*    */     
/* 76 */     GL11.glDisable(32826);
/* 77 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void func_76986_a(Entity entity, double x, double y, double z, float xr, float yr)
/*    */   {
/* 89 */     renderArrow((EntityShrapnel)entity, x, y, z, xr, yr);
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity)
/*    */   {
/* 94 */     return null;
/*    */   }
/*    */   
/*    */   private void loadTexture(String image) {
/* 98 */     func_110776_a(MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/RenderShrapnel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */