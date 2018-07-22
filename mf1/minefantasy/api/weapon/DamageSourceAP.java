/*    */ package minefantasy.api.weapon;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ChatMessageComponent;
/*    */ import net.minecraft.util.DamageSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DamageSourceAP
/*    */   extends DamageSource
/*    */ {
/* 14 */   public static final DamageSource blunt = new DamageSourceAP("blunt_mf").func_76348_h();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public DamageSourceAP(String name)
/*    */   {
/* 21 */     super(name);
/*    */   }
/*    */   
/*    */   public ChatMessageComponent func_76360_b(EntityLivingBase entity)
/*    */   {
/* 26 */     return ChatMessageComponent.func_111066_d("");
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/weapon/DamageSourceAP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */