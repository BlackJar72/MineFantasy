/*    */ package minefantasy.item.mabShield;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ChatMessageComponent;
/*    */ import net.minecraft.util.DamageSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DamageSourceShieldfail
/*    */   extends DamageSource
/*    */ {
/*    */   private DamageSource baseSrc;
/*    */   
/*    */   public DamageSourceShieldfail(DamageSource sourceBase)
/*    */   {
/* 19 */     super("shieldBypass");
/* 20 */     this.baseSrc = sourceBase;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_76352_a()
/*    */   {
/* 27 */     return this.baseSrc.func_76352_a();
/*    */   }
/*    */   
/*    */   public boolean func_94541_c() {
/* 31 */     return this.baseSrc.func_94541_c();
/*    */   }
/*    */   
/*    */   public boolean func_76363_c() {
/* 35 */     return this.baseSrc.func_76363_c();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public float func_76345_d()
/*    */   {
/* 42 */     return this.baseSrc.func_76345_d();
/*    */   }
/*    */   
/*    */   public boolean func_76357_e() {
/* 46 */     return this.baseSrc.func_76357_e();
/*    */   }
/*    */   
/*    */   public Entity func_76364_f() {
/* 50 */     return func_76346_g();
/*    */   }
/*    */   
/*    */   public Entity func_76346_g() {
/* 54 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public ChatMessageComponent func_76360_b(EntityLivingBase hit)
/*    */   {
/* 61 */     return this.baseSrc.func_76360_b(hit);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_76347_k()
/*    */   {
/* 68 */     return this.baseSrc.func_76347_k();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String func_76355_l()
/*    */   {
/* 75 */     return this.baseSrc.func_76355_l();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public DamageSource func_76351_m()
/*    */   {
/* 83 */     this.baseSrc.func_76351_m();
/* 84 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean func_76350_n()
/*    */   {
/* 92 */     return this.baseSrc.func_76350_n();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_82725_o()
/*    */   {
/* 99 */     return this.baseSrc.func_82725_o();
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/mabShield/DamageSourceShieldfail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */