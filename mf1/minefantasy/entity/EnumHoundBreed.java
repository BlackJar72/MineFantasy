/*     */ package minefantasy.entity;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum EnumHoundBreed
/*     */ {
/*  12 */   BLACK(0, "Black", 4, 3, 3),  GRAY(0, "Gray", 3, 3, 4),  WHITE(0, "White", 3, 4, 3),  BROWN(0, "Brown", 3, 3, 4),  GOLD(0, "Gold", 3, 4, 3),  RED(0, "Red", 4, 3, 3), 
/*     */   
/*     */ 
/*  15 */   MIX_BL_GR(1, "Black", "Gray", 4, 2, 4, 0.4F),  MIX_BL_WH(1, "White", "Black", 4, 4, 2, 0.4F),  MIX_BL_BR(1, "Brown", "Black", 4, 2, 4, 0.4F),  MIX_BL_GO(1, "Black", "Gold", 4, 4, 2, 0.4F), 
/*     */   
/*  17 */   MIX_GR_WH(1, "White", "Gray", 2, 4, 4, 0.4F),  MIX_GR_GO(1, "Gray", "Gold", 2, 4, 4, 0.4F),  MIX_GR_RE(1, "Red", "Gray", 4, 2, 4, 0.4F), 
/*     */   
/*  19 */   MIX_WH_BR(1, "White", "Brown", 2, 4, 4, 0.4F),  MIX_WH_RE(1, "Red", "White", 4, 4, 2, 0.4F), 
/*     */   
/*  21 */   MIX_BR_GO(1, "Gold", "Brown", 2, 4, 4, 0.4F),  MIX_BR_RE(1, "Red", "Brown", 4, 2, 4, 0.4F), 
/*     */   
/*  23 */   MIX_GO_RE(1, "Gold", "Red", 4, 4, 2, 0.4F), 
/*     */   
/*     */ 
/*  26 */   THORSTR(2, "Attack", 8, 2, 2, 0.1F),  THORDEF(2, "Defense", 2, 8, 2, 0.1F),  THORSTA(2, "Stamina", 2, 2, 8, 0.1F), 
/*     */   
/*     */ 
/*  29 */   WAR(3, "War", 10, 10, 5, 0.01F),  HOLY(3, "Holy", 5, 10, 10, 0.01F),  BLOOD(3, "Blood", 10, 5, 10, 0.01F);
/*     */   
/*     */ 
/*     */ 
/*     */   private static List<HoundBreedMix> breeding;
/*     */   
/*     */ 
/*     */   public String texture;
/*     */   
/*     */ 
/*     */   public String spots;
/*     */   
/*     */ 
/*     */   public int attack;
/*     */   
/*     */ 
/*     */   public int defense;
/*     */   
/*     */ 
/*     */   public int stamina;
/*     */   
/*     */   public float chanceToCreate;
/*     */   
/*     */   public int tierOfBreed;
/*     */   
/*     */ 
/*     */   private EnumHoundBreed(int type, String name, int att, int def, int sta)
/*     */   {
/*  57 */     this(type, name, att, def, sta, 1.0F);
/*     */   }
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
/*     */   private EnumHoundBreed(int type, String name, int att, int def, int sta, float chance)
/*     */   {
/*  75 */     this(type, name, null, att, def, sta, chance);
/*     */   }
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
/*     */   private EnumHoundBreed(int type, String tex, String spot, int att, int def, int sta, float chance)
/*     */   {
/*  95 */     this.chanceToCreate = chance;
/*  96 */     this.texture = tex;
/*  97 */     this.spots = spot;
/*  98 */     this.attack = att;
/*  99 */     this.defense = def;
/* 100 */     this.stamina = sta;
/* 101 */     this.tierOfBreed = type;
/*     */   }
/*     */   
/*     */   public static EnumHoundBreed getBreed(int i) {
/* 105 */     if ((i < 0) || (i > getMaxBreeds())) {
/* 106 */       return null;
/*     */     }
/* 108 */     return values()[i];
/*     */   }
/*     */   
/*     */   public static void addBreeding(EnumHoundBreed b1, EnumHoundBreed b2, EnumHoundBreed breed) {
/* 112 */     breeding.add(new HoundBreedMix(b1, b2, breed));
/*     */   }
/*     */   
/*     */   public static void addBreeding(int b1, int b2, EnumHoundBreed breed) {
/* 116 */     addBreeding(getBreed(b1), getBreed(b2), breed);
/*     */   }
/*     */   
/*     */   public static EnumHoundBreed getBreedFor(int b1, int b2) {
/* 120 */     return getBreedFor(getBreed(b1), getBreed(b2));
/*     */   }
/*     */   
/*     */   public static EnumHoundBreed getBreedFor(EnumHoundBreed b1, EnumHoundBreed b2) {
/* 124 */     Iterator results = breeding.iterator();
/*     */     
/* 126 */     while (results.hasNext()) {
/* 127 */       HoundBreedMix result = (HoundBreedMix)results.next();
/* 128 */       if (result.matches(b1, b2)) {
/* 129 */         return result.getResult();
/*     */       }
/*     */     }
/* 132 */     return null;
/*     */   }
/*     */   
/*     */   public static int getMaxBreeds() {
/* 136 */     return values().length - 1;
/*     */   }
/*     */   
/*     */   static
/*     */   {
/*  31 */     breeding = new ArrayList();
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
/* 141 */     addBreeding(BLACK, GRAY, MIX_BL_GR);
/* 142 */     addBreeding(BLACK, WHITE, MIX_BL_WH);
/* 143 */     addBreeding(BLACK, BROWN, MIX_BL_BR);
/* 144 */     addBreeding(BLACK, GOLD, MIX_BL_GO);
/*     */     
/* 146 */     addBreeding(GRAY, WHITE, MIX_GR_WH);
/* 147 */     addBreeding(GRAY, GOLD, MIX_GR_GO);
/* 148 */     addBreeding(GRAY, RED, MIX_GR_RE);
/*     */     
/* 150 */     addBreeding(WHITE, BROWN, MIX_WH_BR);
/* 151 */     addBreeding(WHITE, RED, MIX_WH_RE);
/*     */     
/* 153 */     addBreeding(BROWN, GOLD, MIX_BR_GO);
/* 154 */     addBreeding(BROWN, RED, MIX_BR_RE);
/*     */     
/* 156 */     addBreeding(GOLD, RED, MIX_GO_RE);
/*     */     
/* 158 */     addBreeding(BLACK, RED, THORSTR);
/* 159 */     addBreeding(WHITE, GOLD, THORDEF);
/* 160 */     addBreeding(GRAY, BROWN, THORSTA);
/*     */     
/* 162 */     addBreeding(THORSTR, THORDEF, WAR);
/* 163 */     addBreeding(THORDEF, THORSTA, HOLY);
/* 164 */     addBreeding(THORSTR, THORSTA, BLOOD);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/entity/EnumHoundBreed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */