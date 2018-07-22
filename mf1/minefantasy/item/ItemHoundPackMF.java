/*    */ package minefantasy.item;
/*    */ 
/*    */ import java.util.List;
/*    */ import minefantasy.api.hound.ItemHoundPack;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemHoundPackMF
/*    */   extends ItemHoundPack
/*    */ {
/*    */   private String texture;
/*    */   public int stren;
/*    */   public int stamin;
/*    */   
/*    */   public ItemHoundPackMF(int id, int t, int rows, String tex, int loy, int str, int sta)
/*    */   {
/* 23 */     super(id, t, rows);
/* 24 */     this.texture = tex;
/* 25 */     this.stren = str;
/* 26 */     this.stamin = sta;
/* 27 */     func_77637_a(ItemListMF.tabPets);
/*    */   }
/*    */   
/*    */   public String getTexture() {
/* 31 */     return MFResource.image("/mob/" + this.texture + ".png");
/*    */   }
/*    */   
/*    */   public int getRequiredStr()
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */   public int getRequiredSta()
/*    */   {
/* 41 */     return 0;
/*    */   }
/*    */   
/*    */   public Item func_77655_b(String name)
/*    */   {
/* 46 */     func_111206_d("minefantasy:Pets/" + name);
/* 47 */     return super.func_77655_b(name);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemHoundPackMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */