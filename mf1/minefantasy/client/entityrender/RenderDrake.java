/*    */ package minefantasy.client.entityrender;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.entity.EntityDrake;
/*    */ import minefantasy.entity.IGrowable;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderDrake
/*    */   extends RenderLiving
/*    */ {
/*    */   private float scale;
/*    */   
/*    */   public RenderDrake(ModelBase base, float shadow)
/*    */   {
/* 24 */     super(base, 0.0F);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void preRenderScale(IGrowable entity, float f)
/*    */   {
/* 31 */     this.scale = entity.getTotalScale();
/* 32 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_77041_b(EntityLivingBase living, float f)
/*    */   {
/* 41 */     preRenderScale((IGrowable)living, f);
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity)
/*    */   {
/* 46 */     return getTexture((EntityDrake)entity);
/*    */   }
/*    */   
/*    */   protected ResourceLocation getTexture(EntityDrake entity) {
/* 50 */     return MFTextureHelper.getResource(MFResource.image("/mob/" + entity.getTexture() + ".png"));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/RenderDrake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */