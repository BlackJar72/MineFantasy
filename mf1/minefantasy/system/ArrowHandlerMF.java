/*     */ package minefantasy.system;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.arrow.Arrows;
/*     */ import minefantasy.api.arrow.IArrowHandler;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.event.ForgeSubscribe;
/*     */ import net.minecraftforge.event.entity.player.ArrowLooseEvent;
/*     */ import net.minecraftforge.event.entity.player.ArrowNockEvent;
/*     */ 
/*     */ public class ArrowHandlerMF
/*     */ {
/*     */   @ForgeSubscribe
/*     */   public void readyBow(ArrowNockEvent event)
/*     */   {
/*  26 */     if (MineFantasyBase.isBGLoaded()) {
/*  27 */       return;
/*     */     }
/*     */     
/*  30 */     if ((Arrows.arrows == null) || (Arrows.arrows.size() <= 0)) {
/*  31 */       return;
/*     */     }
/*     */     
/*  34 */     EntityPlayer user = event.entityPlayer;
/*  35 */     ItemStack bow = event.result;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  41 */     for (int a = 0; a < Arrows.arrows.size(); a++) {
/*  42 */       ItemStack arrow = (ItemStack)Arrows.arrows.get(a);
/*  43 */       if (user.field_71071_by.func_70431_c(arrow)) {
/*  44 */         user.func_71008_a(bow, bow.func_77988_m());
/*     */         
/*  46 */         loadArrow(user, bow, arrow);
/*     */         
/*  48 */         event.setCanceled(true);
/*  49 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void loadArrow(EntityPlayer player, ItemStack bow, ItemStack arrow)
/*     */   {
/*  58 */     NBTTagCompound nbt = getOrApplyNBT(bow);
/*     */     
/*  60 */     if (arrow == null) {
/*  61 */       nbt.func_82580_o("loadedArrow");
/*     */     } else {
/*  63 */       NBTTagCompound loaded = new NBTTagCompound();
/*  64 */       arrow.func_77955_b(loaded);
/*  65 */       nbt.func_74782_a("loadedArrow", loaded);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static NBTTagCompound getOrApplyNBT(ItemStack bow)
/*     */   {
/*  73 */     if (!bow.func_77942_o()) {
/*  74 */       bow.func_77982_d(new NBTTagCompound());
/*     */     }
/*  76 */     return bow.func_77978_p();
/*     */   }
/*     */   
/*     */   @ForgeSubscribe
/*     */   public void fireArrow(ArrowLooseEvent event) {
/*  81 */     if (MineFantasyBase.isBGLoaded()) {
/*  82 */       return;
/*     */     }
/*     */     
/*  85 */     ItemStack bow = event.bow;
/*  86 */     float power = event.charge;
/*  87 */     EntityPlayer user = event.entityPlayer;
/*  88 */     World world = event.entity.field_70170_p;
/*  89 */     boolean infinite = (user.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, bow) > 0);
/*     */     
/*  91 */     float charge = power / 20.0F;
/*  92 */     charge = (charge * charge + charge * 2.0F) / 3.0F;
/*     */     
/*  94 */     if (charge < 0.1D) {
/*  95 */       return;
/*     */     }
/*     */     
/*  98 */     if (charge > 1.0F) {
/*  99 */       charge = 1.0F;
/*     */     }
/*     */     
/*     */ 
/* 103 */     ItemStack arrow = new ItemStack(Item.field_77704_l);
/* 104 */     if (Arrows.getLoadedArrow(bow) != null)
/*     */     {
/* 106 */       arrow = Arrows.getLoadedArrow(bow);
/*     */     }
/*     */     
/* 109 */     if ((Arrows.handlers != null) && (Arrows.handlers.size() > 0)) {
/* 110 */       for (int a = 0; a < Arrows.handlers.size(); a++)
/*     */       {
/* 112 */         if (((IArrowHandler)Arrows.handlers.get(a)).onFireArrow(world, arrow, bow, user, charge, infinite)) {
/* 113 */           if (!user.field_71075_bZ.field_75098_d) {
/* 114 */             bow.func_77972_a(1, user);
/*     */           }
/* 116 */           if (!infinite) {
/* 117 */             consumePlayerItem(user, arrow);
/*     */           }
/* 119 */           world.func_72956_a(user, "random.bow", 0.5F, 1.0F / (world.field_73012_v.nextFloat() * 0.4F + 1.2F) + charge * 0.5F);
/* 120 */           loadArrow(user, bow, null);
/* 121 */           event.setCanceled(true);
/* 122 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean consumePlayerItem(EntityPlayer player, ItemStack item)
/*     */   {
/* 130 */     for (int a = 0; a < player.field_71071_by.func_70302_i_(); a++) {
/* 131 */       ItemStack i = player.field_71071_by.func_70301_a(a);
/* 132 */       if ((i != null) && (i.func_77969_a(item))) {
/* 133 */         player.field_71071_by.func_70298_a(a, 1);
/* 134 */         return true;
/*     */       }
/*     */     }
/* 137 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/ArrowHandlerMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */