/*    */ package minefantasy.system;
/*    */ 
/*    */ import cpw.mods.fml.client.FMLClientHandler;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ @cpw.mods.fml.relauncher.SideOnly(cpw.mods.fml.relauncher.Side.CLIENT)
/*    */ public abstract class ExtendedReachHelper
/*    */ {
/* 15 */   private static Minecraft mc = FMLClientHandler.instance().getClient();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static MovingObjectPosition getMouseOver(float tickPart, float maxDist)
/*    */   {
/* 25 */     Minecraft mc = FMLClientHandler.instance().getClient();
/* 26 */     if ((mc.field_71451_h != null) && 
/* 27 */       (mc.field_71441_e != null)) {
/* 28 */       mc.field_96291_i = null;
/* 29 */       double d0 = maxDist;
/* 30 */       MovingObjectPosition objectMouseOver = mc.field_71451_h.func_70614_a(d0, tickPart);
/* 31 */       double d1 = d0;
/* 32 */       Vec3 vec3 = mc.field_71451_h.func_70666_h(tickPart);
/*    */       
/* 34 */       if (objectMouseOver != null) {
/* 35 */         d1 = objectMouseOver.field_72307_f.func_72438_d(vec3);
/*    */       }
/*    */       
/* 38 */       Vec3 vec31 = mc.field_71451_h.func_70676_i(tickPart);
/* 39 */       Vec3 vec32 = vec3.func_72441_c(vec31.field_72450_a * d0, vec31.field_72448_b * d0, vec31.field_72449_c * d0);
/* 40 */       Entity pointedEntity = null;
/* 41 */       float f1 = 1.0F;
/* 42 */       List list = mc.field_71441_e.func_72839_b(mc.field_71451_h, mc.field_71451_h.field_70121_D.func_72321_a(vec31.field_72450_a * d0, vec31.field_72448_b * d0, vec31.field_72449_c * d0).func_72314_b(f1, f1, f1));
/* 43 */       double d2 = d1;
/*    */       
/* 45 */       for (int i = 0; i < list.size(); i++) {
/* 46 */         Entity entity = (Entity)list.get(i);
/*    */         
/* 48 */         if (entity.func_70067_L()) {
/* 49 */           float f2 = entity.func_70111_Y();
/* 50 */           AxisAlignedBB axisalignedbb = entity.field_70121_D.func_72314_b(f2, f2, f2);
/* 51 */           MovingObjectPosition movingobjectposition = axisalignedbb.func_72327_a(vec3, vec32);
/*    */           
/* 53 */           if (axisalignedbb.func_72318_a(vec3)) {
/* 54 */             if ((0.0D < d2) || (d2 == 0.0D)) {
/* 55 */               pointedEntity = entity;
/* 56 */               d2 = 0.0D;
/*    */             }
/* 58 */           } else if (movingobjectposition != null) {
/* 59 */             double d3 = vec3.func_72438_d(movingobjectposition.field_72307_f);
/*    */             
/* 61 */             if ((d3 < d2) || (d2 == 0.0D)) {
/* 62 */               pointedEntity = entity;
/* 63 */               d2 = d3;
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */       
/* 69 */       if ((pointedEntity != null) && ((d2 < d1) || (objectMouseOver == null))) {
/* 70 */         objectMouseOver = new MovingObjectPosition(pointedEntity);
/*    */       }
/*    */       
/* 73 */       return objectMouseOver;
/*    */     }
/*    */     
/* 76 */     return null;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/ExtendedReachHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */