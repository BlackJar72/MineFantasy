/*    */ package minefantasy.item;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.util.StatCollector;
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
/*    */ public class BoltType
/*    */ {
/*    */   public final EnumToolMaterial material;
/*    */   public final int meta;
/*    */   private final String matName;
/*    */   public final int index;
/*    */   private final int durability;
/* 26 */   private static int nextIndex = 0;
/*    */   
/* 28 */   public static List<BoltType> bolts = new ArrayList();
/*    */   
/*    */   private BoltType(String tex, EnumToolMaterial mat, int sub, int i) {
/* 31 */     int dura = 1;
/* 32 */     if (mat.func_77997_a() < 0) {
/* 33 */       dura = -1;
/*    */     } else {
/* 35 */       dura = mat.func_77997_a() / 100;
/*    */     }
/* 37 */     this.index = i;
/* 38 */     this.matName = tex;
/* 39 */     this.durability = dura;
/* 40 */     this.meta = sub;
/* 41 */     this.material = mat;
/*    */   }
/*    */   
/*    */   private BoltType(String tex, EnumToolMaterial mat, int dura, int sub, int i) {
/* 45 */     this.index = i;
/* 46 */     this.matName = tex;
/* 47 */     this.durability = dura;
/* 48 */     this.meta = sub;
/* 49 */     this.material = mat;
/*    */   }
/*    */   
/*    */   public static BoltType getBolt(int subId) {
/* 53 */     if (!bolts.isEmpty()) {
/* 54 */       for (int a = 0; a < bolts.size(); a++) {
/* 55 */         BoltType Bolt = (BoltType)bolts.get(a);
/*    */         
/* 57 */         if (Bolt.meta == subId) {
/* 58 */           return Bolt;
/*    */         }
/*    */       }
/*    */     }
/* 62 */     return null;
/*    */   }
/*    */   
/*    */   public static void addBolt(String tex, EnumToolMaterial mat, int sub) {
/* 66 */     bolts.add(new BoltType(tex, mat, sub, nextIndex));
/* 67 */     nextIndex += 1;
/*    */   }
/*    */   
/*    */   public static void addBolt(String tex, EnumToolMaterial mat, int dura, int sub) {
/* 71 */     bolts.add(new BoltType(tex, mat, dura, sub, nextIndex));
/* 72 */     nextIndex += 1;
/*    */   }
/*    */   
/*    */   public String getDisplayName() {
/* 76 */     return StatCollector.func_74838_a("bolt." + this.matName.toLowerCase());
/*    */   }
/*    */   
/*    */   public String getTextureName() {
/* 80 */     return "bolt" + this.matName;
/*    */   }
/*    */   
/*    */   public int getBreakChance() {
/* 84 */     return this.durability;
/*    */   }
/*    */   
/*    */   public static double getDamage(BoltType type) {
/* 88 */     double dam = 2.5D;
/* 89 */     if (type.meta == 0) {
/* 90 */       return 2.5D;
/*    */     }
/* 92 */     if (type != null) {
/* 93 */       dam = type.material.func_78000_c() * 3.0D + 0.5D;
/*    */     }
/* 95 */     return dam;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/BoltType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */