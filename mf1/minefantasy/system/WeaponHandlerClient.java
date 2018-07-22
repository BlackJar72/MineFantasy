/*    */ package minefantasy.system;
/*    */ 
/*    */ import cpw.mods.fml.client.FMLClientHandler;
/*    */ import cpw.mods.fml.common.ITickHandler;
/*    */ import cpw.mods.fml.common.TickType;
/*    */ import java.util.EnumSet;
/*    */ import java.util.Random;
/*    */ import minefantasy.api.weapon.IExtendedReachItem;
/*    */ import minefantasy.api.weapon.IWeightedWeapon;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.multiplayer.PlayerControllerMP;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumMovingObjectType;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ 
/*    */ public class WeaponHandlerClient implements ITickHandler
/*    */ {
/*    */   public void tickStart(EnumSet<TickType> type, Object... tickData)
/*    */   {
/* 23 */     if (!type.contains(TickType.PLAYER))
/* 24 */       return;
/* 25 */     EntityPlayer entityPlayer = (EntityPlayer)tickData[0];
/* 26 */     ItemStack weapon = entityPlayer.func_70694_bm();
/* 27 */     float balance = 0.0F;
/*    */     
/* 29 */     if ((weapon != null) && ((weapon.func_77973_b() instanceof IWeightedWeapon))) {
/* 30 */       balance = ((IWeightedWeapon)weapon.func_77973_b()).getBalance();
/*    */     }
/*    */     
/* 33 */     if ((cfg.useBalance) && (balance > 0.0F) && (entityPlayer != null))
/*    */     {
/* 35 */       if (entityPlayer.field_110158_av == -1) {
/* 36 */         float amplify = 30.0F;
/*    */         
/* 38 */         float offsetX = entityPlayer.func_70681_au().nextFloat() * balance - balance / 2.0F;
/* 39 */         float offsetY = entityPlayer.func_70681_au().nextFloat() * balance;
/*    */         
/* 41 */         entityPlayer.field_70177_z += offsetX * amplify;
/* 42 */         entityPlayer.field_70125_A += offsetY * amplify;
/* 43 */         entityPlayer.field_70702_br += offsetX;
/* 44 */         if (offsetY > 0.0F) {
/* 45 */           entityPlayer.field_70701_bs += offsetY;
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void tickEnd(EnumSet<TickType> type, Object... tickData)
/*    */   {
/* 53 */     if (!type.contains(TickType.PLAYER)) {
/* 54 */       return;
/*    */     }
/* 56 */     EntityPlayer entityPlayer = (EntityPlayer)tickData[0];
/*    */     
/* 58 */     if (entityPlayer != null)
/*    */     {
/* 60 */       if (entityPlayer.field_110158_av == 1) {
/* 61 */         ItemStack mainhand = entityPlayer.func_71045_bC();
/* 62 */         if ((mainhand != null) && ((mainhand.func_77973_b() instanceof IExtendedReachItem))) {
/* 63 */           float extendedReach = ((IExtendedReachItem)mainhand.func_77973_b()).getReachModifierInBlocks(mainhand);
/* 64 */           if (extendedReach > 0.0F) {
/* 65 */             MovingObjectPosition mouseOver = ExtendedReachHelper.getMouseOver(0.0F, extendedReach + 4.0F);
/* 66 */             if ((mouseOver != null) && (mouseOver.field_72313_a == EnumMovingObjectType.ENTITY)) {
/* 67 */               Entity target = mouseOver.field_72308_g;
/* 68 */               if (((target instanceof EntityLiving)) && (target != entityPlayer) && 
/* 69 */                 (target.field_70172_ad != ((EntityLiving)target).field_70771_an)) {
/* 70 */                 FMLClientHandler.instance().getClient().field_71442_b.func_78764_a(entityPlayer, target);
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public EnumSet<TickType> ticks()
/*    */   {
/* 82 */     return EnumSet.of(TickType.PLAYER);
/*    */   }
/*    */   
/*    */   public String getLabel()
/*    */   {
/* 87 */     return "Minefantasy Weapon Ticker";
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/WeaponHandlerClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */