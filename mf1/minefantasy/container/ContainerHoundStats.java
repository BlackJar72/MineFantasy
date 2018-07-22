/*    */ package minefantasy.container;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import minefantasy.entity.EntityHound;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.inventory.ICrafting;
/*    */ 
/*    */ public class ContainerHoundStats extends Container
/*    */ {
/*    */   private EntityHound dog;
/* 15 */   private int lastStr = 0;
/* 16 */   private int lastSta = 0;
/* 17 */   private int lastEnd = 0;
/* 18 */   private int lastPt = 0;
/* 19 */   private int lastLvl = 0;
/*    */   
/*    */   public ContainerHoundStats(EntityHound hound) {}
/*    */   
/*    */   public void updateStats(ICrafting craft)
/*    */   {
/* 25 */     super.func_75132_a(craft);
/* 26 */     craft.func_71112_a(this, 0, this.dog.strength);
/* 27 */     craft.func_71112_a(this, 1, this.dog.stamina);
/* 28 */     craft.func_71112_a(this, 2, this.dog.endurance);
/* 29 */     craft.func_71112_a(this, 3, this.dog.AtPoints);
/* 30 */     craft.func_71112_a(this, 4, this.dog.level);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void updateCraftingResults()
/*    */   {
/* 37 */     super.func_75142_b();
/* 38 */     Iterator var1 = this.field_75149_d.iterator();
/*    */     
/* 40 */     while (var1.hasNext()) {
/* 41 */       ICrafting var2 = (ICrafting)var1.next();
/*    */       
/* 43 */       if (this.lastStr != this.dog.strength) {
/* 44 */         var2.func_71112_a(this, 0, this.dog.strength);
/*    */       }
/* 46 */       if (this.lastSta != this.dog.stamina) {
/* 47 */         var2.func_71112_a(this, 1, this.dog.stamina);
/*    */       }
/* 49 */       if (this.lastEnd != this.dog.endurance) {
/* 50 */         var2.func_71112_a(this, 2, this.dog.endurance);
/*    */       }
/* 52 */       if (this.lastPt != this.dog.AtPoints) {
/* 53 */         var2.func_71112_a(this, 3, this.dog.AtPoints);
/*    */       }
/* 55 */       if (this.lastLvl != this.dog.level) {
/* 56 */         var2.func_71112_a(this, 4, this.dog.level);
/*    */       }
/*    */     }
/*    */     
/* 60 */     this.lastStr = this.dog.strength;
/* 61 */     this.lastSta = this.dog.stamina;
/* 62 */     this.lastEnd = this.dog.endurance;
/* 63 */     this.lastPt = this.dog.AtPoints;
/* 64 */     this.lastLvl = this.dog.level;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void updateStats(int id, int amount) {
/* 69 */     if (id == 0) {
/* 70 */       this.dog.strength = amount;
/*    */     }
/* 72 */     if (id == 1) {
/* 73 */       this.dog.stamina = amount;
/*    */     }
/* 75 */     if (id == 2) {
/* 76 */       this.dog.endurance = amount;
/*    */     }
/* 78 */     if (id == 3) {
/* 79 */       this.dog.AtPoints = amount;
/*    */     }
/* 81 */     if (id == 4) {
/* 82 */       this.dog.level = amount;
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean func_75145_c(EntityPlayer user) {
/* 87 */     return this.dog.func_70300_a(user);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/container/ContainerHoundStats.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */