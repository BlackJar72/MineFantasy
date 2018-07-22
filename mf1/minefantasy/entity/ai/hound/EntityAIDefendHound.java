/*    */ package minefantasy.entity.ai.hound;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import minefantasy.entity.EntityHound;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.ai.EntityAITarget;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.PlayerCapabilities;
/*    */ import net.minecraft.util.AABBPool;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ 
/*    */ public class EntityAIDefendHound extends EntityAITarget
/*    */ {
/*    */   boolean alertFriends;
/*    */   net.minecraft.entity.EntityLivingBase attacker;
/*    */   private EntityHound dog;
/*    */   
/*    */   public EntityAIDefendHound(EntityHound user, boolean alert)
/*    */   {
/* 21 */     super(user, false);
/* 22 */     this.alertFriends = alert;
/* 23 */     func_75248_a(1);
/* 24 */     this.dog = user;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75250_a()
/*    */   {
/* 31 */     if ((!this.dog.func_70909_n()) && (!this.dog.inPack()) && (this.dog.func_110143_aJ() < 5.0F)) {
/* 32 */       return false;
/*    */     }
/* 34 */     return func_75296_a(this.field_75299_d.func_70643_av(), true);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75253_b()
/*    */   {
/* 41 */     return (this.field_75299_d.func_70643_av() != null) && (this.field_75299_d.func_70643_av() != this.attacker);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_75249_e()
/*    */   {
/* 48 */     this.field_75299_d.func_70624_b(this.field_75299_d.func_70643_av());
/* 49 */     this.attacker = this.field_75299_d.func_70643_av();
/*    */     
/* 51 */     if (this.alertFriends) {
/* 52 */       List list = this.field_75299_d.field_70170_p.func_72872_a(EntityHound.class, AxisAlignedBB.func_72332_a().func_72299_a(this.field_75299_d.field_70165_t, this.field_75299_d.field_70163_u, this.field_75299_d.field_70161_v, this.field_75299_d.field_70165_t + 1.0D, this.field_75299_d.field_70163_u + 1.0D, this.field_75299_d.field_70161_v + 1.0D).func_72314_b(func_111175_f(), 10.0D, func_111175_f()));
/*    */       
/*    */ 
/*    */ 
/* 56 */       Iterator iterator = list.iterator();
/*    */       
/* 58 */       while (iterator.hasNext()) {
/* 59 */         EntityHound friend = (EntityHound)iterator.next();
/*    */         
/* 61 */         if ((this.field_75299_d != friend) && (friend.func_70638_az() == null) && 
/* 62 */           (friend.willFightFor((EntityHound)this.field_75299_d))) {
/* 63 */           friend.func_70624_b(this.field_75299_d.func_70643_av());
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 69 */     super.func_75249_e();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_75251_c()
/*    */   {
/* 76 */     if ((this.field_75299_d.func_70638_az() != null) && ((this.field_75299_d.func_70638_az() instanceof EntityPlayer)) && (((EntityPlayer)this.field_75299_d.func_70638_az()).field_71075_bZ.field_75102_a)) {
/* 77 */       super.func_75251_c();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/ai/hound/EntityAIDefendHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */