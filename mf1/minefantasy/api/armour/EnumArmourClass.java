/*    */ package minefantasy.api.armour;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum EnumArmourClass
/*    */ {
/* 16 */   UNARMOURED("Null", 1.0F, true, 1.0F, 1.0F, new int[] { -1, -3, -4, -2 }),  LIGHT("Light", 1.0F, true, 1.0F, 1.0F, new int[] { 0, 0, 0, 0 }),  MEDIUM("Medium", 0.9F, true, 1.1F, 0.9F, new int[] { 2, 6, 8, 4 }),  HEAVY("Heavy", 0.85F, true, 1.2F, 0.5F, new int[] { 5, 15, 20, 10 }),  PLATE("Plate", 0.8F, false, 1.5F, 0.0F, new int[] { 10, 30, 40, 20 });
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private final String className;
/*    */   
/*    */ 
/*    */ 
/*    */   private final float travelSpeed;
/*    */   
/*    */ 
/*    */ 
/*    */   private final boolean canSprintIn;
/*    */   
/*    */ 
/*    */ 
/*    */   private final float exaustionRate;
/*    */   
/*    */ 
/*    */ 
/*    */   private final float knockbackStrength;
/*    */   
/*    */ 
/*    */ 
/*    */   private int[] noise;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private EnumArmourClass(String name, float speed, boolean canSprint, float exaustion, float knockback, int[] sound)
/*    */   {
/* 48 */     this.className = name;
/* 49 */     this.travelSpeed = speed;
/* 50 */     this.canSprintIn = canSprint;
/* 51 */     this.exaustionRate = exaustion;
/* 52 */     this.knockbackStrength = knockback;
/* 53 */     this.noise = sound;
/*    */   }
/*    */   
/*    */   public float getSpeedReduction() {
/* 57 */     return 1.0F - this.travelSpeed;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 61 */     return this.className;
/*    */   }
/*    */   
/*    */   public boolean canSprintIn() {
/* 65 */     return this.canSprintIn;
/*    */   }
/*    */   
/*    */   public float getExaustion() {
/* 69 */     return this.exaustionRate;
/*    */   }
/*    */   
/*    */   public float getKnockback() {
/* 73 */     return 1.0F - this.knockbackStrength;
/*    */   }
/*    */   
/*    */   public double getSoundMod(int id) {
/* 77 */     return this.noise[id];
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/armour/EnumArmourClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */