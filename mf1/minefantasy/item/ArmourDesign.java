/*     */ package minefantasy.item;
/*     */ 
/*     */ import minefantasy.api.armour.EnumArmourClass;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum ArmourDesign
/*     */ {
/*  13 */   LEATHER("Light", 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  18 */   STUDDED("Light", 1.0F, 0.0F, 1.0F, 1.2F, 1.0F, 1.0F, 1.0F), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  24 */   SCALE("Light", 0.75F, 0.0F, 0.7F, 0.7F, 0.7F, 0.75F, 1.0F), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  32 */   CHAIN("Medium", 0.8F, 0.0F, 0.6F, 1.5F, 0.7F, 1.5F, 0.9F), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  38 */   SPLINT("Medium", 0.85F, 0.05F, 0.9F, 0.85F, 1.2750001F, 0.8F, 0.9F), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */   HVYCHAIN("Heavy", 0.9F, 0.0F, 0.5F, 2.5F, 0.8F, 1.8000001F, 0.85F), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  53 */   SOLID("Heavy", 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.85F), 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  62 */   PLATE("Plate", 1.0F, 0.5F, 1.0F, 1.0F, 1.0F, 5.25F, 0.8F);
/*     */   
/*     */   public final String AC;
/*     */   public final float protection;
/*     */   public final float bluntResist;
/*     */   public final float fallResist;
/*     */   public final float expResist;
/*     */   public final float projResist;
/*     */   public final float fireResist;
/*     */   public final float dura;
/*     */   public final float moveSpeed;
/*     */   
/*     */   private ArmourDesign(String Ac, float Pro, float blunt, float Exp, float Proj, float Fire, float fall, float Dur, float speed) {
/*  75 */     this.moveSpeed = speed;
/*  76 */     this.AC = Ac;
/*  77 */     this.protection = Pro;
/*  78 */     this.bluntResist = blunt;
/*  79 */     this.expResist = Exp;
/*  80 */     this.projResist = Proj;
/*  81 */     this.fireResist = Fire;
/*  82 */     this.dura = Dur;
/*  83 */     this.fallResist = fall;
/*     */   }
/*     */   
/*     */   private ArmourDesign(String Ac, float Pro, float blunt, float Exp, float Proj, float Fire, float Dur, float speed) {
/*  87 */     this(Ac, Pro, blunt, Exp, Proj, Fire, 0.0F, Dur, speed);
/*     */   }
/*     */   
/*     */   public static EnumArmourClass getAC(String s) {
/*  91 */     if (s.equalsIgnoreCase("Light")) {
/*  92 */       return EnumArmourClass.LIGHT;
/*     */     }
/*  94 */     if (s.equalsIgnoreCase("Medium")) {
/*  95 */       return EnumArmourClass.MEDIUM;
/*     */     }
/*  97 */     if (s.equalsIgnoreCase("Heavy")) {
/*  98 */       return EnumArmourClass.HEAVY;
/*     */     }
/* 100 */     if (s.equalsIgnoreCase("Plate")) {
/* 101 */       return EnumArmourClass.PLATE;
/*     */     }
/* 103 */     return EnumArmourClass.HEAVY;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ArmourDesign.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */