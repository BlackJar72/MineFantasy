/*    */ package minefantasy.client.entityrender;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelApron extends ModelBiped
/*    */ {
/*    */   public ModelApron(float scale)
/*    */   {
/* 14 */     this(scale, 0.0F, 64, 64);
/*    */   }
/*    */   
/*    */   public ModelApron(float scale, float rotate, int x, int y) {
/* 18 */     this.field_78115_e = new ModelRenderer(this).func_78787_b(x, y);
/* 19 */     this.field_78115_e.func_78793_a(0.0F, 0.0F + rotate, 0.0F);
/* 20 */     this.field_78115_e.func_78784_a(0, 38).func_78790_a(-4.0F, 0.0F, -3.0F, 8, 18, 6, scale + 0.5F);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*    */   {
/* 27 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/* 28 */     this.field_78115_e.func_78785_a(f5);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/ModelApron.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */