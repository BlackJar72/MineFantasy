/*    */ package minefantasy.api.armour;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import java.util.HashMap;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ArmourWeightClass
/*    */ {
/*  9 */   public static HashMap<Integer, Integer> configArmours = new HashMap();
/*    */   
/*    */   public static EnumArmourClass getClassFor(ItemStack item, EnumArmourClass Default) {
/* 12 */     int id = item.field_77993_c;
/*    */     
/* 14 */     if ((!configArmours.isEmpty()) && (configArmours.containsKey(Integer.valueOf(id)))) {
/* 15 */       if (hasId(0, id))
/* 16 */         return EnumArmourClass.LIGHT;
/* 17 */       if (hasId(1, id))
/* 18 */         return EnumArmourClass.MEDIUM;
/* 19 */       if (hasId(2, id))
/* 20 */         return EnumArmourClass.HEAVY;
/* 21 */       if (hasId(3, id)) {
/* 22 */         return EnumArmourClass.PLATE;
/*    */       }
/*    */     }
/* 25 */     return Default;
/*    */   }
/*    */   
/*    */   private static boolean hasId(int tier, int id) {
/* 29 */     return (configArmours.get(Integer.valueOf(id)) != null) && (((Integer)configArmours.get(Integer.valueOf(id))).intValue() == tier);
/*    */   }
/*    */   
/*    */   public static void add(int armourID, int armourClass) {
/* 33 */     if (!configArmours.containsKey(Integer.valueOf(armourID))) {
/* 34 */       configArmours.put(Integer.valueOf(armourID), Integer.valueOf(armourClass));
/*    */     } else {
/* 36 */       FMLLog.warning("[Mine Fantasy] Armour with ID" + armourID + " already found in list, ignoring", new Object[0]);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/armour/ArmourWeightClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */