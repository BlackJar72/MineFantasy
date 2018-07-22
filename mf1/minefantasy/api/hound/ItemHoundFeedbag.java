/*    */ package minefantasy.api.hound;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
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
/*    */ public class ItemHoundFeedbag
/*    */   extends Item
/*    */   implements IHoundEquipment, IHoundPackItem
/*    */ {
/*    */   public int size;
/*    */   
/*    */   public ItemHoundFeedbag(int id, int max)
/*    */   {
/* 26 */     super(id);
/* 27 */     func_77656_e(max);
/* 28 */     func_77625_d(1);
/*    */   }
/*    */   
/*    */   public void func_77624_a(ItemStack item, EntityPlayer player, List desc, boolean flag)
/*    */   {
/* 33 */     super.func_77624_a(item, player, desc, flag);
/* 34 */     if ((getRequiredStr() > 0) || (getRequiredSta() > 0) || (getRequiredEnd() > 0)) {
/* 35 */       desc.add("Requirments:");
/* 36 */       if (getRequiredStr() > 0)
/* 37 */         desc.add("Attack: " + getRequiredStr());
/* 38 */       if (getRequiredEnd() > 0)
/* 39 */         desc.add("Defense: " + getRequiredEnd());
/* 40 */       if (getRequiredSta() > 0) {
/* 41 */         desc.add("Stamina: " + getRequiredSta());
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public String getTexture()
/*    */   {
/* 49 */     return null;
/*    */   }
/*    */   
/*    */   public int getPiece()
/*    */   {
/* 54 */     return 0;
/*    */   }
/*    */   
/*    */   public int getRequiredStr()
/*    */   {
/* 59 */     return 0;
/*    */   }
/*    */   
/*    */   public int getRequiredEnd()
/*    */   {
/* 64 */     return 0;
/*    */   }
/*    */   
/*    */   public int getRequiredSta()
/*    */   {
/* 69 */     return 0;
/*    */   }
/*    */   
/*    */   public float getMobilityModifier()
/*    */   {
/* 74 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/hound/ItemHoundFeedbag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */