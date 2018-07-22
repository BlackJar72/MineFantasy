/*    */ package minefantasy.client.entityrender;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.entity.EntityBasilisk;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderBasilisk extends RenderLiving
/*    */ {
/*    */   public RenderBasilisk()
/*    */   {
/* 18 */     super(new ModelBasilisk(), 1.0F);
/* 19 */     func_77042_a(new ModelBasilisk());
/*    */   }
/*    */   
/*    */   protected float setSpiderDeathMaxRotation(EntityBasilisk basilisk) {
/* 23 */     return 180.0F;
/*    */   }
/*    */   
/*    */   protected void scaleSpider(EntityBasilisk basilisk, float scale) {
/* 27 */     float f1 = basilisk.getScale();
/* 28 */     GL11.glScalef(f1, f1, f1);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void preRenderCallback(EntityLiving living, float scale)
/*    */   {
/* 36 */     scaleSpider((EntityBasilisk)living, scale);
/*    */   }
/*    */   
/*    */   protected float getDeathMaxRotation(EntityLiving living) {
/* 40 */     return setSpiderDeathMaxRotation((EntityBasilisk)living);
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity)
/*    */   {
/* 45 */     if ((entity instanceof EntityBasilisk)) {
/* 46 */       return MFTextureHelper.getResource(((EntityBasilisk)entity).getTexture());
/*    */     }
/* 48 */     return MFTextureHelper.getResource("mob/basilisk");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/RenderBasilisk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */