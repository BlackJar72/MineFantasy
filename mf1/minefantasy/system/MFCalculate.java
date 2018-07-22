/*    */ package minefantasy.system;
/*    */ 
/*    */ public class MFCalculate {
/*    */   public static long getTicksForDays(int days) {
/*  5 */     return days * 24 * 60 * 60 * 20;
/*    */   }
/*    */   
/*    */   public static long getTicksForHours(int hours) {
/*  9 */     return hours * 60 * 60 * 20;
/*    */   }
/*    */   
/*    */   public static long getTicksForMinutes(int mins) {
/* 13 */     return mins * 60 * 20;
/*    */   }
/*    */   
/*    */   public static long getTicksForTime(int days, int hours, int mins) {
/* 17 */     return getTicksForDays(days) + getTicksForHours(hours) + getTicksForMinutes(mins);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/MFCalculate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */