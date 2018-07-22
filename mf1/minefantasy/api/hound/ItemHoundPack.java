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
/*    */ 
/*    */ 
/*    */ public class ItemHoundPack
/*    */   extends Item
/*    */   implements IHoundEquipment, IHoundPackItem
/*    */ {
/*    */   public int size;
/*    */   public int type;
/*    */   
/*    */   public ItemHoundPack(int id, int piece, int rows)
/*    */   {
/* 29 */     super(id);
/* 30 */     func_77625_d(1);
/* 31 */     this.size = rows;
/* 32 */     this.type = piece;
/*    */   }
/*    */   
/*    */   public void func_77624_a(ItemStack item, EntityPlayer player, List desc, boolean flag)
/*    */   {
/* 37 */     super.func_77624_a(item, player, desc, flag);
/* 38 */     if ((getRequiredStr() > 0) || (getRequiredSta() > 0) || (getRequiredEnd() > 0)) {
/* 39 */       desc.add("Requirments:");
/* 40 */       if (getRequiredStr() > 0)
/* 41 */         desc.add("Attack: " + getRequiredStr());
/* 42 */       if (getRequiredEnd() > 0)
/* 43 */         desc.add("Defense: " + getRequiredEnd());
/* 44 */       if (getRequiredSta() > 0)
/* 45 */         desc.add("Stamina: " + getRequiredSta());
/*    */     }
/*    */   }
/*    */   
/*    */   public int getAvalibleRows() {
/* 50 */     return this.size;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public String getTexture()
/*    */   {
/* 57 */     return null;
/*    */   }
/*    */   
/*    */   public int getPiece()
/*    */   {
/* 62 */     return this.type;
/*    */   }
/*    */   
/*    */   public int getRequiredStr()
/*    */   {
/* 67 */     return 0;
/*    */   }
/*    */   
/*    */   public int getRequiredEnd()
/*    */   {
/* 72 */     return 0;
/*    */   }
/*    */   
/*    */   public int getRequiredSta()
/*    */   {
/* 77 */     return 0;
/*    */   }
/*    */   
/*    */   public float getMobilityModifier()
/*    */   {
/* 82 */     return 0.0F;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/hound/ItemHoundPack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */