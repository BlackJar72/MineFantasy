/*    */ package minefantasy.client.entityrender;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.renderer.entity.RenderBiped;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSkeletalKnight
/*    */   extends RenderBiped
/*    */ {
/*    */   public RenderSkeletalKnight(ModelBiped model)
/*    */   {
/* 34 */     super(model, 1.0F, 1.0F);
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity)
/*    */   {
/* 39 */     return MFTextureHelper.getResource("textures/mob/SkeletonKnight.png");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/RenderSkeletalKnight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */