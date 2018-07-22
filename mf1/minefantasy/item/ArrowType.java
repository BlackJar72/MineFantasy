/*     */ package minefantasy.item;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ArrowType
/*     */ {
/*     */   public final EnumToolMaterial material;
/*     */   public final int arrowType;
/*     */   public final int meta;
/*     */   private final String matName;
/*     */   private final int durability;
/*     */   public final int index;
/*  30 */   private static int nextIndex = 0;
/*     */   
/*  32 */   public static List<ArrowType> arrows = new ArrayList();
/*     */   
/*     */   private ArrowType(String tex, EnumToolMaterial mat, int type, int sub, int i) {
/*  35 */     int dura = 1;
/*  36 */     if (mat.func_77997_a() < 0) {
/*  37 */       dura = -1;
/*     */     } else {
/*  39 */       dura = mat.func_77997_a() / 100;
/*     */     }
/*     */     
/*  42 */     this.index = i;
/*  43 */     this.matName = tex;
/*  44 */     this.meta = sub;
/*  45 */     this.material = mat;
/*  46 */     this.durability = dura;
/*  47 */     this.arrowType = type;
/*     */   }
/*     */   
/*     */   private ArrowType(String tex, EnumToolMaterial mat, int dura, int type, int sub, int i) {
/*  51 */     this.index = i;
/*  52 */     this.matName = tex;
/*  53 */     this.meta = sub;
/*  54 */     this.material = mat;
/*  55 */     this.durability = dura;
/*  56 */     this.arrowType = type;
/*     */   }
/*     */   
/*     */   public static ArrowType getArrow(int subId) {
/*  60 */     if (!arrows.isEmpty()) {
/*  61 */       for (int a = 0; a < arrows.size(); a++) {
/*  62 */         ArrowType arrow = (ArrowType)arrows.get(a);
/*     */         
/*  64 */         if (arrow.meta == subId) {
/*  65 */           return arrow;
/*     */         }
/*     */       }
/*     */     }
/*  69 */     return null;
/*     */   }
/*     */   
/*     */   public static void addArrow(String tex, EnumToolMaterial mat, int type, int sub) {
/*  73 */     arrows.add(new ArrowType(tex, mat, type, sub, nextIndex));
/*  74 */     nextIndex += 1;
/*     */   }
/*     */   
/*     */   public String getUnlocalisedDisplayName() {
/*  78 */     String name = getTypeTex().length() > 0 ? getTypeTex() : "arrow";
/*     */     
/*  80 */     return name.toLowerCase() + "." + this.matName.toLowerCase();
/*     */   }
/*     */   
/*     */   public String getTextureName() {
/*  84 */     return "arrow" + this.matName + getTypeTex();
/*     */   }
/*     */   
/*     */   private String getTypeTex() {
/*  88 */     if (this.arrowType == 2) {
/*  89 */       return "Broad";
/*     */     }
/*  91 */     if (this.arrowType == 1) {
/*  92 */       return "Bodkin";
/*     */     }
/*  94 */     return "";
/*     */   }
/*     */   
/*     */   public int getBreakChance() {
/*  98 */     return this.durability;
/*     */   }
/*     */   
/*     */   public static double getDamage(ArrowType type) {
/* 102 */     double dam = 2.0D;
/*     */     
/* 104 */     if (type != null) {
/* 105 */       if (type.meta == 0) {
/* 106 */         return 1.5D;
/*     */       }
/*     */       
/* 109 */       dam = type.material.func_78000_c() * 2.5D + 0.5D;
/*     */       
/* 111 */       if (type.arrowType == 0) {
/* 112 */         dam *= 0.5D;
/*     */       }
/* 114 */       if (type.arrowType == 1) {
/* 115 */         dam *= 0.35D;
/*     */       }
/* 117 */       if (type.arrowType == 2) {
/* 118 */         dam *= 0.65D;
/*     */       }
/*     */     }
/* 121 */     return dam;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ArrowType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */