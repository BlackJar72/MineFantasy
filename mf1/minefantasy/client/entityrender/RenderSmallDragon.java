/*    */ package minefantasy.client.entityrender;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.entity.EntityDragonSmall;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
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
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSmallDragon
/*    */   extends RenderLiving
/*    */ {
/*    */   public RenderSmallDragon(ModelBase model, float shadow)
/*    */   {
/* 35 */     super(model, shadow);
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity)
/*    */   {
/* 40 */     if ((entity instanceof EntityDragonSmall)) {
/* 41 */       return MFTextureHelper.getResource(((EntityDragonSmall)entity).getTexture());
/*    */     }
/* 43 */     return MFTextureHelper.getResource(MFResource.image("/mob/dragonRed.png"));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/RenderSmallDragon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */