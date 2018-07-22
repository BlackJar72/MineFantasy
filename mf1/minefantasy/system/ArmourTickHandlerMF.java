/*    */ package minefantasy.system;
/*    */ 
/*    */ import cpw.mods.fml.common.ITickHandler;
/*    */ import cpw.mods.fml.common.TickType;
/*    */ import java.util.EnumSet;
/*    */ import java.util.Random;
/*    */ import minefantasy.MineFantasyBase;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.ForgeDirection;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArmourTickHandlerMF
/*    */   implements ITickHandler
/*    */ {
/* 24 */   Random rand = new Random();
/*    */   
/*    */ 
/*    */ 
/*    */   public void tickStart(EnumSet<TickType> type, Object... tickData) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void tickEnd(EnumSet<TickType> type, Object... tickData)
/*    */   {
/* 34 */     if ((cfg.disableWeight) || (!type.contains(TickType.PLAYER))) {
/* 35 */       return;
/*    */     }
/* 37 */     EntityLivingBase user = (EntityLivingBase)tickData[0];
/*    */     
/* 39 */     if ((user != null) && 
/* 40 */       (user.field_70122_E)) {
/* 41 */       float speedMod = CombatManager.getMovementSpeedModifier(user);
/* 42 */       if ((!cfg.disableWeight) || (speedMod >= 1.0F)) {
/* 43 */         float speed = speedMod;
/* 44 */         user.field_70159_w *= speed;
/* 45 */         user.field_70179_y *= speed;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 50 */     int sprint = CombatManager.getAntisprintArmours(user);
/* 51 */     if ((!cfg.disableWeight) && (sprint > 0) && (user.func_70051_ag())) {
/* 52 */       if ((user instanceof EntityPlayer)) {
/* 53 */         float exhaust = MineFantasyBase.scaleExhaustion(0.01F * sprint);
/* 54 */         ((EntityPlayer)user).func_71020_j(exhaust);
/*    */       }
/* 56 */       user.field_70702_br += user.func_70681_au().nextFloat() * 10.0F - 5.0F;
/*    */     }
/* 58 */     double speed = Math.hypot(user.field_70159_w, user.field_70179_y);
/* 59 */     if ((speed > 0.01D) && (CombatManager.getAntisprintArmours(user) > 0)) {
/* 60 */       float volume = 0.05F * CombatManager.getAntisprintArmours(user);
/* 61 */       if (this.rand.nextInt(20) == 0) {
/* 62 */         user.func_85030_a("mob.irongolem.throw", volume, 1.0F);
/*    */       }
/*    */     }
/*    */     
/* 66 */     if ((user.func_70090_H()) && (!user.field_70170_p.isBlockSolidOnSide((int)Math.round(user.field_70165_t), (int)user.field_70163_u - 2, (int)Math.round(user.field_70161_v), ForgeDirection.UP))) {
/* 67 */       float spd = CombatManager.getMovementSpeedModifier(user);
/* 68 */       if (spd < 1.0F) {
/* 69 */         float sink = 0.01F * (1.0F / spd);
/* 70 */         user.field_70159_w *= spd;
/* 71 */         user.field_70179_y *= spd;
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public EnumSet<TickType> ticks()
/*    */   {
/* 78 */     return EnumSet.of(TickType.PLAYER);
/*    */   }
/*    */   
/*    */   public String getLabel()
/*    */   {
/* 83 */     return "Armour Tick Handler";
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/ArmourTickHandlerMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */