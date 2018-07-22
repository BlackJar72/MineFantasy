/*    */ package minefantasy.api.weapon;
/*    */ 
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WeaponClass
/*    */ {
/*    */   public static EnumWeaponType getClassFor(ItemStack item)
/*    */   {
/* 15 */     if ((item != null) && (item.func_77973_b() != null)) {
/* 16 */       if ((item.func_77973_b() instanceof IWeaponClass)) {
/* 17 */         return ((IWeaponClass)item.func_77973_b()).getType(item);
/*    */       }
/* 19 */       return getDefaultOn(item.func_77973_b().func_77667_c(item));
/*    */     }
/*    */     
/* 22 */     return null;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static EnumWeaponType getDefaultOn(String name)
/*    */   {
/* 34 */     if (guessClass(name, new String[] { "waraxe" })) {
/* 35 */       return EnumWeaponType.AXE;
/*    */     }
/*    */     
/* 38 */     if (guessClass(name, new String[] { "battleaxe", "beardedaxe", "greataxe" })) {
/* 39 */       return EnumWeaponType.BIGAXE;
/*    */     }
/*    */     
/* 42 */     if (guessClass(name, new String[] { "bastard", "bastardsword", "claymore", "greatsword" })) {
/* 43 */       return EnumWeaponType.BIGBLADE;
/*    */     }
/*    */     
/* 46 */     if (guessClass(name, new String[] { "warhammer", "morningstar", "maul" })) {
/* 47 */       return EnumWeaponType.BIGBLUNT;
/*    */     }
/*    */     
/* 50 */     if (guessClass(name, new String[] { "halbeard", "trident" })) {
/* 51 */       return EnumWeaponType.BIGPOLEARM;
/*    */     }
/*    */     
/* 54 */     if (guessClass(name, new String[] { "longsword", "broadsword", "broad", "katana", "rapier", "sabre", "scimitar", "cutlass" })) {
/* 55 */       return EnumWeaponType.LONGBLADE;
/*    */     }
/*    */     
/* 58 */     if (guessClass(name, new String[] { "spear", "javelin", "pike" })) {
/* 59 */       return EnumWeaponType.POLEARM;
/*    */     }
/*    */     
/* 62 */     if (guessClass(name, new String[] { "axe", "tommahawk", "hatchet" })) {
/* 63 */       return EnumWeaponType.SMLAXE;
/*    */     }
/*    */     
/* 66 */     if (guessClass(name, new String[] { "knife", "dagger", "dirk", "stiletto" })) {
/* 67 */       return EnumWeaponType.SMLBLADE;
/*    */     }
/*    */     
/* 70 */     if (guessClass(name, new String[] { "mace", "club", "blackjack" })) {
/* 71 */       return EnumWeaponType.SMLBLUNT;
/*    */     }
/*    */     
/* 74 */     if (guessClass(name, new String[] { "staff", "quaterstaff" })) {
/* 75 */       return EnumWeaponType.STAFF;
/*    */     }
/*    */     
/* 78 */     return EnumWeaponType.MEDBLADE;
/*    */   }
/*    */   
/*    */   private static boolean guessClass(String name, String[] keys) {
/* 82 */     for (String key : keys) {
/* 83 */       if (name.contains(key)) {
/* 84 */         return true;
/*    */       }
/*    */     }
/* 87 */     return false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/weapon/WeaponClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */