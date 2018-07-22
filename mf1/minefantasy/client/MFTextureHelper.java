/*    */ package minefantasy.client;
/*    */ 
/*    */ import com.google.common.collect.Maps;
/*    */ import cpw.mods.fml.client.FMLClientHandler;
/*    */ import java.util.Map;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.ItemRenderer;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MFTextureHelper
/*    */ {
/* 21 */   private static final Map resourceList = ;
/* 22 */   public static final ResourceLocation ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static ResourceLocation getResource(String directory)
/*    */   {
/* 29 */     ResourceLocation resourcelocation = (ResourceLocation)resourceList.get(directory);
/* 30 */     if (resourcelocation == null)
/*    */     {
/* 32 */       resourcelocation = new ResourceLocation("minefantasy", directory);
/* 33 */       resourceList.put(directory, resourcelocation);
/*    */     }
/* 35 */     return resourcelocation;
/*    */   }
/*    */   
/*    */   public static String getModelTextureLocation(String texture) {
/* 39 */     return "minefantasy:" + texture;
/*    */   }
/*    */   
/*    */   public static void renderEnchantmentEffects(Tessellator tessellator) {
/* 43 */     GL11.glDepthFunc(514);
/* 44 */     GL11.glDisable(2896);
/* 45 */     FMLClientHandler.instance().getClient().field_71446_o.func_110577_a(ITEM_GLINT);
/* 46 */     GL11.glEnable(3042);
/* 47 */     GL11.glBlendFunc(768, 1);
/* 48 */     float f7 = 0.76F;
/* 49 */     GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
/* 50 */     GL11.glMatrixMode(5890);
/* 51 */     GL11.glPushMatrix();
/* 52 */     float f8 = 0.125F;
/* 53 */     GL11.glScalef(f8, f8, f8);
/* 54 */     float f9 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 55 */     GL11.glTranslatef(f9, 0.0F, 0.0F);
/* 56 */     GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 57 */     ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
/* 58 */     GL11.glPopMatrix();
/* 59 */     GL11.glPushMatrix();
/* 60 */     GL11.glScalef(f8, f8, f8);
/* 61 */     f9 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 62 */     GL11.glTranslatef(-f9, 0.0F, 0.0F);
/* 63 */     GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 64 */     ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
/* 65 */     GL11.glPopMatrix();
/* 66 */     GL11.glMatrixMode(5888);
/* 67 */     GL11.glDisable(3042);
/* 68 */     GL11.glEnable(2896);
/* 69 */     GL11.glDepthFunc(515);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFTextureHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */