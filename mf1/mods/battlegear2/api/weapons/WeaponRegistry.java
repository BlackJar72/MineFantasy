/*    */ package mods.battlegear2.api.weapons;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Set;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WeaponRegistry
/*    */ {
/* 17 */   private static Set<StackHolder> weapons = new HashSet();
/* 18 */   private static Set<StackHolder> mainHand = new HashSet();
/* 19 */   private static Set<StackHolder> offHand = new HashSet();
/*    */   
/*    */ 
/*    */ 
/*    */   public static void addDualWeapon(ItemStack stack)
/*    */   {
/* 25 */     weapons.add(new StackHolder(stack));
/* 26 */     mainHand.add(new StackHolder(stack));
/* 27 */     offHand.add(new StackHolder(stack));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void addTwoHanded(ItemStack stack)
/*    */   {
/* 35 */     weapons.add(new StackHolder(stack));
/* 36 */     mainHand.add(new StackHolder(stack));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void addOffhandWeapon(ItemStack stack)
/*    */   {
/* 44 */     weapons.add(new StackHolder(stack));
/* 45 */     offHand.add(new StackHolder(stack));
/*    */   }
/*    */   
/*    */   public static boolean isWeapon(ItemStack stack) {
/* 49 */     return weapons.contains(new StackHolder(stack));
/*    */   }
/*    */   
/*    */   public static boolean isMainHand(ItemStack stack) {
/* 53 */     return mainHand.contains(new StackHolder(stack));
/*    */   }
/*    */   
/*    */   public static boolean isOffHand(ItemStack stack) {
/* 57 */     return offHand.contains(new StackHolder(stack));
/*    */   }
/*    */   
/*    */   static class StackHolder {
/*    */     private final ItemStack stack;
/*    */     
/*    */     public StackHolder(ItemStack stack) {
/* 64 */       this.stack = stack;
/*    */     }
/*    */     
/*    */     public int hashCode()
/*    */     {
/* 69 */       int prime = 31;
/* 70 */       int result = 31 + (this.stack == null ? 0 : this.stack.field_77993_c ^ this.stack.field_77994_a + (this.stack.func_77942_o() ? 0x3C1 ^ this.stack.func_77978_p().hashCode() : 0));
/* 71 */       return result;
/*    */     }
/*    */     
/*    */     public boolean equals(Object obj)
/*    */     {
/* 76 */       if (this == obj) {
/* 77 */         return true;
/*    */       }
/* 79 */       if (obj == null) {
/* 80 */         return false;
/*    */       }
/* 82 */       if (!(obj instanceof StackHolder)) {
/* 83 */         return false;
/*    */       }
/* 85 */       if (!ItemStack.func_77989_b(this.stack, ((StackHolder)obj).stack)) {
/* 86 */         return false;
/*    */       }
/* 88 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/weapons/WeaponRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */