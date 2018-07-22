/*    */ package minefantasy.item.armour;
/*    */ 
/*    */ import minefantasy.item.ArmourDesign;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum EnumArmourMF
/*    */ {
/* 11 */   RAWHIDE("Rawhide", 3, 1.2F, 0, 1.0F),  LEATHER("Leather", 5, 1.3F, 0, 1.0F),  APRON("Apron", 6, 1.2F, 0, 1.0F),  STEALTH("Stealth", 15, 1.5F, 16, 1.0F), 
/*    */   
/* 13 */   BRONZE("Bronze", 20, 2.0F, 15, 1.0F),  IRON("Iron", 20, 2.5F, 16, 1.0F),  STEEL("Steel", 30, 3.5F, 20, 1.0F),  ENCRUSTED("Encrusted", 35, 5.0F, 15, 1.1F),  DEEP_IRON("DeepIron", 40, 6.5F, 16, 1.0F),  BLUE_STEEL("Blue Steel", 50, 7.5F, 20, 1.9F),  MITHRIL("Mithril", 55, 9.0F, 22, 0.8F), 
/* 14 */   MYTHIUM("Mythium", 60, 10.5F, 18, 0.65F),  UNUSED("Unused", 80, 12.0F, 20, 1.5F),  ADAMANTIUM("Adamantium", 100, 13.5F, 24, 1.2F), 
/*    */   
/* 16 */   GUILDED("Guilded", 18, 2.2F, 30, 1.0F),  DRAGONFORGE("Dragonforge", 35, 4.0F, 15, 1.0F),  IGNOTUMITE("Ignotumite", 100, 10.0F, 24, 1.2F);
/*    */   
/*    */   public final String name;
/*    */   public final int durability;
/*    */   public final float armourRating;
/*    */   public final int enchantment;
/*    */   public final float armourWeight;
/*    */   
/*    */   private EnumArmourMF(String title, int dura, float AC, int enchant, float weight) {
/* 25 */     this.name = title;
/* 26 */     this.durability = dura;
/* 27 */     this.armourRating = calculateAC(AC);
/* 28 */     this.enchantment = enchant;
/* 29 */     this.armourWeight = weight;
/*    */   }
/*    */   
/*    */   public static float calculateAC(float ratio) {
/* 33 */     float percent = 100.0F - 100.0F / ratio;
/*    */     
/* 35 */     return percent / 60.0F / ArmourDesign.PLATE.protection;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/armour/EnumArmourMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */