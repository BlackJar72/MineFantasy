/*    */ package minefantasy.container;
/*    */ 
/*    */ import minefantasy.MineFantasyBase;
/*    */ import minefantasy.api.hound.IHoundEquipment;
/*    */ import minefantasy.entity.EntityHound;
/*    */ import net.minecraft.inventory.Slot;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SlotHoundArmour
/*    */   extends Slot
/*    */ {
/*    */   final int armourType;
/*    */   EntityHound hound;
/*    */   final ContainerHoundArmour parent;
/*    */   
/*    */   SlotHoundArmour(ContainerHoundArmour container, EntityHound inventory, int id, int x, int y, int piece)
/*    */   {
/* 33 */     super(inventory, id, x, y);
/* 34 */     this.hound = inventory;
/* 35 */     this.parent = container;
/* 36 */     this.armourType = piece;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int func_75219_a()
/*    */   {
/* 44 */     return 1;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean func_75214_a(ItemStack item)
/*    */   {
/* 52 */     if (this.hound.func_70631_g_()) {
/* 53 */       return false;
/*    */     }
/* 55 */     if (item == null) {
/* 56 */       return false;
/*    */     }
/* 58 */     if ((item.func_77973_b() instanceof IHoundEquipment)) {
/* 59 */       IHoundEquipment equipment = (IHoundEquipment)item.func_77973_b();
/*    */       
/* 61 */       if ((!MineFantasyBase.isDebug()) && 
/* 62 */         (!this.hound.canEquip(equipment))) {
/* 63 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 67 */       return equipment.getPiece() == this.armourType;
/*    */     }
/*    */     
/* 70 */     return false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/SlotHoundArmour.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */