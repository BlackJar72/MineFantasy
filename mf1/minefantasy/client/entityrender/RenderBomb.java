/*    */ package minefantasy.client.entityrender;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.entity.IBomb;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.projectile.EntityPotion;
/*    */ import net.minecraft.item.ItemPotion;
/*    */ import net.minecraft.potion.PotionHelper;
/*    */ import net.minecraft.util.Icon;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderBomb
/*    */   extends Render
/*    */ {
/*    */   public void func_76986_a(Entity bomb, double x, double y, double z, float pitch, float yaw)
/*    */   {
/* 34 */     Icon icon = null;
/* 35 */     if ((bomb instanceof IBomb)) {
/* 36 */       icon = ((IBomb)bomb).getIcon();
/*    */     }
/*    */     
/* 39 */     if (icon != null) {
/* 40 */       GL11.glPushMatrix();
/* 41 */       GL11.glTranslatef((float)x, (float)y, (float)z);
/* 42 */       GL11.glEnable(32826);
/* 43 */       GL11.glScalef(0.5F, 0.5F, 0.5F);
/* 44 */       func_110776_a(TextureMap.field_110576_c);
/* 45 */       Tessellator tessellator = Tessellator.field_78398_a;
/*    */       
/* 47 */       if (icon == ItemPotion.func_94589_d("potion_splash")) {
/* 48 */         int i = PotionHelper.func_77915_a(((EntityPotion)bomb).func_70196_i(), false);
/* 49 */         float f2 = (i >> 16 & 0xFF) / 255.0F;
/* 50 */         float f3 = (i >> 8 & 0xFF) / 255.0F;
/* 51 */         float f4 = (i & 0xFF) / 255.0F;
/* 52 */         GL11.glColor3f(f2, f3, f4);
/* 53 */         GL11.glPushMatrix();
/* 54 */         func_77026_a(tessellator, ItemPotion.func_94589_d("potion_contents"));
/* 55 */         GL11.glPopMatrix();
/* 56 */         GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*    */       }
/*    */       
/* 59 */       func_77026_a(tessellator, icon);
/* 60 */       GL11.glDisable(32826);
/* 61 */       GL11.glPopMatrix();
/*    */     }
/*    */   }
/*    */   
/*    */   private void func_77026_a(Tessellator model, Icon image) {
/* 66 */     float f = image.func_94209_e();
/* 67 */     float f1 = image.func_94212_f();
/* 68 */     float f2 = image.func_94206_g();
/* 69 */     float f3 = image.func_94210_h();
/* 70 */     float f4 = 1.0F;
/* 71 */     float f5 = 0.5F;
/* 72 */     float f6 = 0.25F;
/* 73 */     GL11.glRotatef(180.0F - this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 74 */     GL11.glRotatef(-this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 75 */     model.func_78382_b();
/* 76 */     model.func_78375_b(0.0F, 1.0F, 0.0F);
/* 77 */     model.func_78374_a(0.0F - f5, 0.0F - f6, 0.0D, f, f3);
/* 78 */     model.func_78374_a(f4 - f5, 0.0F - f6, 0.0D, f1, f3);
/* 79 */     model.func_78374_a(f4 - f5, f4 - f6, 0.0D, f1, f2);
/* 80 */     model.func_78374_a(0.0F - f5, f4 - f6, 0.0D, f, f2);
/* 81 */     model.func_78381_a();
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity)
/*    */   {
/* 86 */     return TextureMap.field_110576_c;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/RenderBomb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */