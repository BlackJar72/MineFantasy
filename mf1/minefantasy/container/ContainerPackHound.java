/*    */ package minefantasy.container;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.inventory.Slot;
/*    */ 
/*    */ public class ContainerPackHound extends net.minecraft.inventory.Container
/*    */ {
/*    */   private IInventory lowerChestInventory;
/*    */   private int numRows;
/*    */   
/*    */   public ContainerPackHound(IInventory viewer, IInventory container, int rows)
/*    */   {
/* 14 */     this.lowerChestInventory = container;
/* 15 */     this.numRows = rows;
/* 16 */     container.func_70295_k_();
/* 17 */     int var3 = (this.numRows - 4) * 18;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 22 */     for (int var4 = 0; var4 < this.numRows; var4++) {
/* 23 */       for (int var5 = 0; var5 < 9; var5++) {
/* 24 */         func_75146_a(new Slot(container, var5 + var4 * 9, 8 + var5 * 18, 18 + var4 * 18));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 29 */     for (var4 = 0; var4 < 3; var4++) {
/* 30 */       for (int var5 = 0; var5 < 9; var5++) {
/* 31 */         func_75146_a(new Slot(viewer, var5 + var4 * 9 + 9, 8 + var5 * 18, 103 + var4 * 18 + var3));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 36 */     for (var4 = 0; var4 < 9; var4++) {
/* 37 */       func_75146_a(new Slot(viewer, var4, 8 + var4 * 18, 161 + var3));
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer par1EntityPlayer) {
/* 42 */     return this.lowerChestInventory.func_70300_a(par1EntityPlayer);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public net.minecraft.item.ItemStack func_82846_b(EntityPlayer player, int num)
/*    */   {
/* 50 */     net.minecraft.item.ItemStack var3 = null;
/* 51 */     Slot var4 = (Slot)this.field_75151_b.get(num);
/*    */     
/* 53 */     int max = this.numRows * 9;
/* 54 */     if (max > 72) {
/* 55 */       max = 72;
/*    */     }
/* 57 */     if ((var4 != null) && (var4.func_75216_d())) {
/* 58 */       net.minecraft.item.ItemStack var5 = var4.func_75211_c();
/* 59 */       var3 = var5.func_77946_l();
/*    */       
/* 61 */       if (num < max) {
/* 62 */         if (!func_75135_a(var5, max, this.field_75151_b.size(), true)) {
/* 63 */           return null;
/*    */         }
/* 65 */       } else if (!func_75135_a(var5, 0, max, false)) {
/* 66 */         return null;
/*    */       }
/*    */       
/* 69 */       if (var5.field_77994_a == 0) {
/* 70 */         var4.func_75215_d((net.minecraft.item.ItemStack)null);
/*    */       } else {
/* 72 */         var4.func_75218_e();
/*    */       }
/*    */     }
/*    */     
/* 76 */     return var3;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void func_75134_a(EntityPlayer user)
/*    */   {
/* 84 */     super.func_75134_a(user);
/* 85 */     this.lowerChestInventory.func_70305_f();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public IInventory getLowerChestInventory()
/*    */   {
/* 92 */     return this.lowerChestInventory;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerPackHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */