/*    */ package minefantasy.client.tile.model;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ModelSmelter
/*    */   extends ModelBase
/*    */ {
/*    */   ModelRenderer chimney;
/*    */   ModelRenderer Base;
/*    */   ModelRenderer Furnace;
/*    */   ModelRenderer top;
/*    */   ModelRenderer ingot;
/*    */   ModelRenderer mould;
/*    */   
/*    */   public ModelSmelter()
/*    */   {
/* 24 */     this.field_78090_t = 128;
/* 25 */     this.field_78089_u = 64;
/*    */     
/* 27 */     this.chimney = new ModelRenderer(this, 84, 43);
/* 28 */     this.chimney.func_78789_a(-5.5F, 0.0F, -5.5F, 11, 2, 11);
/* 29 */     this.chimney.func_78793_a(0.0F, 0.0F, 0.0F);
/* 30 */     this.chimney.func_78787_b(128, 64);
/* 31 */     this.chimney.field_78809_i = true;
/* 32 */     this.Base = new ModelRenderer(this, 0, 0);
/* 33 */     this.Base.func_78789_a(-9.0F, 14.0F, -9.0F, 18, 2, 18);
/* 34 */     this.Base.func_78793_a(0.0F, 0.0F, 0.0F);
/* 35 */     this.Base.func_78787_b(128, 64);
/* 36 */     this.Base.field_78809_i = true;
/* 37 */     this.Furnace = new ModelRenderer(this, 64, 11);
/* 38 */     this.Furnace.func_78789_a(-8.0F, 5.0F, -8.0F, 16, 9, 16);
/* 39 */     this.Furnace.func_78793_a(0.0F, 0.0F, 0.0F);
/* 40 */     this.Furnace.func_78787_b(128, 64);
/* 41 */     this.Furnace.field_78809_i = true;
/* 42 */     this.top = new ModelRenderer(this, 0, 46);
/* 43 */     this.top.func_78789_a(-7.0F, 2.0F, -7.0F, 14, 3, 14);
/* 44 */     this.top.func_78793_a(0.0F, 0.0F, 0.0F);
/* 45 */     this.top.func_78787_b(128, 64);
/* 46 */     this.top.field_78809_i = true;
/*    */     
/* 48 */     this.ingot = new ModelRenderer(this, 0, 30);
/* 49 */     this.ingot.func_78789_a(8.5F, 11.5F, -2.5F, 2, 2, 5);
/* 50 */     this.ingot.func_78793_a(0.0F, 0.0F, 0.0F);
/* 51 */     this.ingot.func_78787_b(128, 64);
/* 52 */     this.ingot.field_78809_i = true;
/*    */     
/* 54 */     this.mould = new ModelRenderer(this, 0, 20);
/* 55 */     this.mould.func_78789_a(8.0F, 12.0F, -3.0F, 3, 3, 6);
/* 56 */     this.mould.func_78793_a(0.0F, 0.0F, 0.0F);
/* 57 */     this.mould.func_78787_b(128, 64);
/* 58 */     this.mould.field_78809_i = true;
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
/* 62 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 63 */     this.chimney.func_78785_a(f5);
/* 64 */     this.Base.func_78785_a(f5);
/* 65 */     this.Furnace.func_78785_a(f5);
/* 66 */     this.top.func_78785_a(f5);
/*    */   }
/*    */   
/*    */   public void renderModel(float f5, boolean result) {
/* 70 */     this.chimney.func_78785_a(f5);
/* 71 */     this.Base.func_78785_a(f5);
/* 72 */     this.Furnace.func_78785_a(f5);
/* 73 */     this.top.func_78785_a(f5);
/* 74 */     this.mould.func_78785_a(f5);
/* 75 */     if (result) {
/* 76 */       this.ingot.func_78785_a(f5);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/model/ModelSmelter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */