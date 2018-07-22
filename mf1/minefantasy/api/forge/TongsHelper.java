/*     */ package minefantasy.api.forge;
/*     */ 
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class TongsHelper
/*     */ {
/*     */   public static boolean hasHeldItem(ItemStack tongs)
/*     */   {
/*  13 */     NBTTagCompound nbt = getNBT(tongs);
/*     */     
/*  15 */     return (nbt.func_74764_b("Held")) && (nbt.func_74767_n("Held"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ItemStack clearHeldItem(ItemStack tongs, EntityLivingBase user)
/*     */   {
/*  24 */     if (!user.field_70170_p.field_72995_K) {
/*  25 */       NBTTagCompound nbt = getNBT(tongs);
/*  26 */       nbt.func_74757_a("Held", false);
/*     */     }
/*  28 */     tongs.func_77972_a(1, user);
/*     */     
/*  30 */     return tongs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean trySetHeldItem(ItemStack tongs, ItemStack item)
/*     */   {
/*  37 */     if ((item == null) || (item.func_77973_b() == null) || (!isHotItem(item)) || ((item.func_77973_b() instanceof ItemBlock))) {
/*  38 */       return false;
/*     */     }
/*  40 */     NBTTagCompound nbt = getNBT(tongs);
/*  41 */     nbt.func_74757_a("Held", true);
/*  42 */     item.func_77955_b(nbt);
/*     */     
/*  44 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isHotItem(ItemStack item)
/*     */   {
/*  52 */     if ((item.func_77973_b() instanceof IHotItem)) {
/*  53 */       return ((IHotItem)item.func_77973_b()).isHot(item);
/*     */     }
/*  55 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean isCoolableItem(ItemStack item)
/*     */   {
/*  62 */     if ((item.func_77973_b() instanceof IHotItem)) {
/*  63 */       return ((IHotItem)item.func_77973_b()).isCoolable(item);
/*     */     }
/*  65 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static ItemStack getHeldItem(ItemStack tongs)
/*     */   {
/*  72 */     NBTTagCompound nbt = getNBT(tongs);
/*  73 */     if ((nbt.func_74764_b("Held")) && 
/*  74 */       (nbt.func_74767_n("Held"))) {
/*  75 */       return ItemStack.func_77949_a(nbt);
/*     */     }
/*     */     
/*  78 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ItemStack getHeldItemTongs(ItemStack tongs)
/*     */   {
/*  88 */     NBTTagCompound nbt = getNBT(tongs);
/*  89 */     if ((nbt.func_74764_b("Held")) && 
/*  90 */       (nbt.func_74767_n("Held"))) {
/*  91 */       return ItemStack.func_77949_a(nbt);
/*     */     }
/*     */     
/*  94 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static ItemStack getHotItem(ItemStack item)
/*     */   {
/* 101 */     NBTTagCompound tag = getNBT(item);
/*     */     
/* 103 */     if ((tag.func_74764_b("ingotID")) && (tag.func_74764_b("ingotMeta"))) {
/* 104 */       return new ItemStack(tag.func_74762_e("ingotID"), 1, tag.func_74762_e("ingotMeta"));
/*     */     }
/*     */     
/* 107 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static NBTTagCompound getNBT(ItemStack item)
/*     */   {
/* 114 */     if (!item.func_77942_o()) {
/* 115 */       item.func_77982_d(new NBTTagCompound());
/*     */     }
/* 117 */     return item.func_77978_p();
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/forge/TongsHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */