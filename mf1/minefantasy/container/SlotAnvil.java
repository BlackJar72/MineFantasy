/*    */ package minefantasy.container;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class SlotAnvil extends Slot
/*    */ {
/*    */   private EntityPlayer thePlayer;
/*    */   private int experiance;
/*    */   public float experiancePoints;
/*    */   
/*    */   public SlotAnvil(EntityPlayer player, IInventory inventory, int slotNum, int x, int y)
/*    */   {
/* 17 */     super(inventory, slotNum, x, y);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean func_75214_a(ItemStack item)
/*    */   {
/* 25 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public ItemStack func_75209_a(int slot)
/*    */   {
/* 33 */     if (func_75216_d()) {
/* 34 */       this.experiance += Math.min(slot, func_75211_c().field_77994_a);
/*    */     }
/*    */     
/* 37 */     return super.func_75209_a(slot);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_75210_a(ItemStack item, int amount)
/*    */   {
/* 46 */     this.experiance += amount;
/* 47 */     func_75208_c(item);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_75208_c(ItemStack stack)
/*    */   {
/* 55 */     if (this.thePlayer == null)
/* 56 */       return;
/* 57 */     stack.func_77980_a(this.thePlayer.field_70170_p, this.thePlayer, this.experiance);
/*    */     
/* 59 */     if (!this.thePlayer.field_70170_p.field_72995_K) {
/* 60 */       int var2 = this.experiance;
/*    */       
/*    */ 
/*    */ 
/* 64 */       float var3 = this.experiancePoints;
/*    */       
/*    */ 
/* 67 */       if (var3 == 0.0F) {
/* 68 */         var2 = 0;
/* 69 */       } else if (var3 < 1.0F) {
/* 70 */         int var4 = MathHelper.func_76141_d(var2 * var3);
/*    */         
/* 72 */         if ((var4 < MathHelper.func_76123_f(var2 * var3)) && ((float)Math.random() < var2 * var3 - var4)) {
/* 73 */           var4++;
/*    */         }
/*    */         
/* 76 */         var2 = var4;
/*    */       }
/*    */       
/* 79 */       while (var2 > 0) {
/* 80 */         int var4 = net.minecraft.entity.item.EntityXPOrb.func_70527_a(var2);
/* 81 */         var2 -= var4;
/* 82 */         this.thePlayer.field_70170_p.func_72838_d(new net.minecraft.entity.item.EntityXPOrb(this.thePlayer.field_70170_p, this.thePlayer.field_70165_t, this.thePlayer.field_70163_u + 0.5D, this.thePlayer.field_70161_v + 0.5D, var4));
/*    */       }
/*    */     }
/*    */     
/* 86 */     this.experiance = 0;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/SlotAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */