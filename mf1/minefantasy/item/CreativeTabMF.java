/*    */ package minefantasy.item;
/*    */ 
/*    */ import minefantasy.MineFantasyBase;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public final class CreativeTabMF extends CreativeTabs
/*    */ {
/*    */   private int type;
/*    */   
/*    */   CreativeTabMF(int id, String item, int t)
/*    */   {
/* 14 */     super(id, item);
/* 15 */     this.type = t;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @cpw.mods.fml.relauncher.SideOnly(cpw.mods.fml.relauncher.Side.CLIENT)
/*    */   public int func_78012_e()
/*    */   {
/* 23 */     switch (this.type) {
/*    */     case 0: 
/* 25 */       return ItemListMF.swordSteelForged.field_77779_bT;
/*    */     case 1: 
/* 27 */       return ItemListMF.helmetSteelPlate.field_77779_bT;
/*    */     case 2: 
/* 29 */       return ItemListMF.sawSteel.field_77779_bT;
/*    */     case 3: 
/* 31 */       return MineFantasyBase.MFBlockTailor.field_71990_ca;
/*    */     case 4: 
/* 33 */       return ItemListMF.shortbow.field_77779_bT;
/*    */     case 5: 
/* 35 */       return ItemListMF.tongsBronze.field_77779_bT;
/*    */     case 6: 
/* 37 */       return MineFantasyBase.MFBlockSmelter.field_71990_ca;
/*    */     case 7: 
/* 39 */       return MineFantasyBase.MFBlockAnvil.field_71990_ca;
/*    */     case 8: 
/* 41 */       return MineFantasyBase.MFBlockClayWall.field_71990_ca;
/*    */     case 9: 
/* 43 */       return MineFantasyBase.MFBlockFirepit.field_71990_ca;
/*    */     case 10: 
/* 45 */       return ItemListMF.hammerIron.field_77779_bT;
/*    */     case 11: 
/* 47 */       return Item.field_77755_aX.field_77779_bT;
/*    */     }
/* 49 */     return ItemListMF.swordSteelForged.field_77779_bT;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/CreativeTabMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */