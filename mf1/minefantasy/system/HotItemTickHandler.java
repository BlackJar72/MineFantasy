/*    */ package minefantasy.system;
/*    */ 
/*    */ import cpw.mods.fml.common.ITickHandler;
/*    */ import cpw.mods.fml.common.TickType;
/*    */ import java.util.EnumSet;
/*    */ import java.util.Random;
/*    */ import minefantasy.api.MineFantasyAPI;
/*    */ import minefantasy.item.ItemBloom;
/*    */ import minefantasy.item.ItemHotItem;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HotItemTickHandler
/*    */   implements ITickHandler
/*    */ {
/* 23 */   Random rand = new Random();
/*    */   
/*    */ 
/*    */ 
/*    */   public void tickStart(EnumSet<TickType> type, Object... tickData) {}
/*    */   
/*    */ 
/*    */ 
/*    */   public void tickEnd(EnumSet<TickType> type, Object... tickData)
/*    */   {
/* 33 */     if (!type.contains(TickType.PLAYER)) {
/* 34 */       return;
/*    */     }
/* 36 */     EntityLivingBase user = (EntityLivingBase)tickData[0];
/*    */     
/* 38 */     if ((cfg.burnPlayer) && (user != null) && (user.field_70173_aa % 20 == 0)) {
/* 39 */       if ((user instanceof EntityPlayer)) {
/* 40 */         burnInv((EntityPlayer)user);
/* 41 */       } else if (isHotItem(user.func_70694_bm())) {
/* 42 */         user.func_70097_a(DamageSource.field_76372_a, 1.0F);
/* 43 */         user.func_85030_a("random.fizz", 1.0F, 1.0F);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private void burnInv(EntityPlayer player)
/*    */   {
/* 50 */     boolean hasBurnt = false;
/* 51 */     for (int a = 0; a < player.field_71071_by.func_70302_i_(); a++) {
/* 52 */       ItemStack item = player.field_71071_by.func_70301_a(a);
/* 53 */       if ((item != null) && 
/* 54 */         (isHotItem(item))) {
/* 55 */         if (!hasBurnt) {
/* 56 */           player.func_70097_a(DamageSource.field_76370_b, 1.0F);
/* 57 */           player.func_85030_a("random.fizz", 1.0F, 1.0F);
/*    */         }
/* 59 */         hasBurnt = true;
/*    */         
/* 61 */         if (!player.field_70170_p.field_72995_K) {
/* 62 */           player.func_70099_a(item, 1.0F);
/* 63 */           player.field_71071_by.func_70299_a(a, null);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private boolean isHotItem(ItemStack item)
/*    */   {
/* 71 */     return (item != null) && (((item.func_77973_b() instanceof ItemHotItem)) || ((item.func_77973_b() instanceof ItemBloom)) || (MineFantasyAPI.isHotToPickup(item)));
/*    */   }
/*    */   
/*    */   public EnumSet<TickType> ticks()
/*    */   {
/* 76 */     return EnumSet.of(TickType.PLAYER);
/*    */   }
/*    */   
/*    */   public String getLabel()
/*    */   {
/* 81 */     return "Hot Item Tick Handler";
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/HotItemTickHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */