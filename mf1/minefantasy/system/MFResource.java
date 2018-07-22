/*    */ package minefantasy.system;
/*    */ 
/*    */ public class MFResource {
/*  4 */   public static String game_version = "M - 1.6.4";
/*  5 */   public static String baseImages = "textures";
/*  6 */   public static String armour = "minefantasy:textures/armour/";
/*  7 */   public static String soundDir = "minefantasy:";
/*    */   
/*    */   public static String image(String s) {
/* 10 */     return baseImages + s;
/*    */   }
/*    */   
/*    */   public static String sound(String s) {
/* 14 */     return soundDir + s;
/*    */   }
/*    */   
/*    */   public static String getSoundDir(String s) {
/* 18 */     return soundDir + s;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/MFResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */