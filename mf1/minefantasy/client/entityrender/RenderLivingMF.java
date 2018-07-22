/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(cpw.mods.fml.relauncher.Side.CLIENT)
/*     */ public abstract class RenderLivingMF extends RendererLivingEntityMF
/*     */ {
/*     */   public RenderLivingMF(ModelBase base, float shadow)
/*     */   {
/*  16 */     super(base, shadow);
/*     */   }
/*     */   
/*     */   protected boolean func_130007_b(EntityLiving par1EntityLiving) {
/*  20 */     return (super.func_110813_b(par1EntityLiving)) && ((par1EntityLiving.func_94059_bO()) || ((par1EntityLiving.func_94056_bM()) && (par1EntityLiving == this.field_76990_c.field_96451_i)));
/*     */   }
/*     */   
/*     */   public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/*  24 */     super.func_130000_a(par1EntityLiving, par2, par4, par6, par8, par9);
/*  25 */     renderLeash(par1EntityLiving, par2, par4, par6, par8, par9);
/*     */   }
/*     */   
/*     */   private double func_110828_a(double par1, double par3, double par5) {
/*  29 */     return par1 + (par3 - par1) * par5;
/*     */   }
/*     */   
/*     */   protected void renderLeash(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
/*  33 */     Entity entity = par1EntityLiving.func_110166_bE();
/*     */     
/*  35 */     if (entity != null) {
/*  36 */       par4 -= (1.6D - par1EntityLiving.field_70131_O) * 0.5D;
/*  37 */       Tessellator tessellator = Tessellator.field_78398_a;
/*  38 */       double d3 = func_110828_a(entity.field_70126_B, entity.field_70177_z, par9 * 0.5F) * 0.01745329238474369D;
/*  39 */       double d4 = func_110828_a(entity.field_70127_C, entity.field_70125_A, par9 * 0.5F) * 0.01745329238474369D;
/*  40 */       double d5 = Math.cos(d3);
/*  41 */       double d6 = Math.sin(d3);
/*  42 */       double d7 = Math.sin(d4);
/*     */       
/*  44 */       if ((entity instanceof net.minecraft.entity.EntityHanging)) {
/*  45 */         d5 = 0.0D;
/*  46 */         d6 = 0.0D;
/*  47 */         d7 = -1.0D;
/*     */       }
/*     */       
/*  50 */       double d8 = Math.cos(d4);
/*  51 */       double d9 = func_110828_a(entity.field_70169_q, entity.field_70165_t, par9) - d5 * 0.7D - d6 * 0.5D * d8;
/*  52 */       double d10 = func_110828_a(entity.field_70167_r + entity.func_70047_e() * 0.7D, entity.field_70163_u + entity.func_70047_e() * 0.7D, par9) - d7 * 0.5D - 0.25D;
/*  53 */       double d11 = func_110828_a(entity.field_70166_s, entity.field_70161_v, par9) - d6 * 0.7D + d5 * 0.5D * d8;
/*  54 */       double d12 = func_110828_a(par1EntityLiving.field_70760_ar, par1EntityLiving.field_70761_aq, par9) * 0.01745329238474369D + 1.5707963267948966D;
/*  55 */       d5 = Math.cos(d12) * par1EntityLiving.field_70130_N * 0.4D;
/*  56 */       d6 = Math.sin(d12) * par1EntityLiving.field_70130_N * 0.4D;
/*  57 */       double d13 = func_110828_a(par1EntityLiving.field_70169_q, par1EntityLiving.field_70165_t, par9) + d5;
/*  58 */       double d14 = func_110828_a(par1EntityLiving.field_70167_r, par1EntityLiving.field_70163_u, par9);
/*  59 */       double d15 = func_110828_a(par1EntityLiving.field_70166_s, par1EntityLiving.field_70161_v, par9) + d6;
/*  60 */       par2 += d5;
/*  61 */       par6 += d6;
/*  62 */       double d16 = (float)(d9 - d13);
/*  63 */       double d17 = (float)(d10 - d14);
/*  64 */       double d18 = (float)(d11 - d15);
/*  65 */       GL11.glDisable(3553);
/*  66 */       GL11.glDisable(2896);
/*  67 */       GL11.glDisable(2884);
/*  68 */       boolean flag = true;
/*  69 */       double d19 = 0.025D;
/*  70 */       tessellator.func_78371_b(5);
/*     */       
/*     */ 
/*     */ 
/*  74 */       for (int i = 0; i <= 24; i++) {
/*  75 */         if (i % 2 == 0) {
/*  76 */           tessellator.func_78369_a(0.5F, 0.4F, 0.3F, 1.0F);
/*     */         } else {
/*  78 */           tessellator.func_78369_a(0.35F, 0.28F, 0.21000001F, 1.0F);
/*     */         }
/*     */         
/*  81 */         float f2 = i / 24.0F;
/*  82 */         tessellator.func_78377_a(par2 + d16 * f2 + 0.0D, par4 + d17 * (f2 * f2 + f2) * 0.5D + ((24.0F - i) / 18.0F + 0.125F), par6 + d18 * f2);
/*  83 */         tessellator.func_78377_a(par2 + d16 * f2 + 0.025D, par4 + d17 * (f2 * f2 + f2) * 0.5D + ((24.0F - i) / 18.0F + 0.125F) + 0.025D, par6 + d18 * f2);
/*     */       }
/*     */       
/*  86 */       tessellator.func_78381_a();
/*  87 */       tessellator.func_78371_b(5);
/*     */       
/*  89 */       for (i = 0; i <= 24; i++) {
/*  90 */         if (i % 2 == 0) {
/*  91 */           tessellator.func_78369_a(0.5F, 0.4F, 0.3F, 1.0F);
/*     */         } else {
/*  93 */           tessellator.func_78369_a(0.35F, 0.28F, 0.21000001F, 1.0F);
/*     */         }
/*     */         
/*  96 */         float f2 = i / 24.0F;
/*  97 */         tessellator.func_78377_a(par2 + d16 * f2 + 0.0D, par4 + d17 * (f2 * f2 + f2) * 0.5D + ((24.0F - i) / 18.0F + 0.125F) + 0.025D, par6 + d18 * f2);
/*  98 */         tessellator.func_78377_a(par2 + d16 * f2 + 0.025D, par4 + d17 * (f2 * f2 + f2) * 0.5D + ((24.0F - i) / 18.0F + 0.125F), par6 + d18 * f2 + 0.025D);
/*     */       }
/*     */       
/* 101 */       tessellator.func_78381_a();
/* 102 */       GL11.glEnable(2896);
/* 103 */       GL11.glEnable(3553);
/* 104 */       GL11.glEnable(2884);
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean func_110813_b(EntityLivingBase par1EntityLivingBase) {
/* 109 */     return func_130007_b((EntityLiving)par1EntityLivingBase);
/*     */   }
/*     */   
/*     */   public void renderPlayer(EntityLivingBase par1EntityLivingBase, double par2, double par4, double par6, float par8, float par9) {
/* 113 */     doRenderLiving((EntityLiving)par1EntityLivingBase, par2, par4, par6, par8, par9);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_76986_a(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
/*     */   {
/* 125 */     doRenderLiving((EntityLiving)par1Entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/RenderLivingMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */