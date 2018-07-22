/*    */ package mods.battlegear2.api;
/*    */ 
/*    */ public abstract interface IDefaultRender {
/*    */   public abstract boolean useDefaultRenderer();
/*    */   
/*    */   public abstract RenderType getRenderer();
/*    */   
/*    */   public abstract void setRenderState(boolean paramBoolean);
/*    */   
/*    */   public static enum RenderType {
/* 11 */     Bow, 
/* 12 */     FlagPole, 
/* 13 */     Quiver, 
/* 14 */     Shield, 
/* 15 */     Spear, 
/* 16 */     HeraldryCrest, 
/* 17 */     HeraldryItem;
/*    */     
/*    */     private RenderType() {}
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/IDefaultRender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */