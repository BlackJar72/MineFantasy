/*    */ package minefantasy.item;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Random;
/*    */ import minefantasy.MineFantasyBase;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.EnumMovingObjectType;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemPaper
/*    */   extends Item
/*    */ {
/*    */   public ItemPaper(int i)
/*    */   {
/* 26 */     super(i);
/* 27 */     func_77637_a(ItemListMF.tabMF);
/*    */   }
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
/*    */   {
/* 32 */     Random rand = new Random();
/* 33 */     MovingObjectPosition movingobjectposition = func_77621_a(world, player, true);
/*    */     
/* 35 */     if (movingobjectposition == null) {
/* 36 */       return item;
/*    */     }
/* 38 */     if ((!world.field_72995_K) && (movingobjectposition.field_72313_a == EnumMovingObjectType.TILE)) {
/* 39 */       int i = movingobjectposition.field_72311_b;
/* 40 */       int j = movingobjectposition.field_72312_c;
/* 41 */       int k = movingobjectposition.field_72309_d;
/*    */       
/* 43 */       if (!world.func_72962_a(player, i, j, k)) {
/* 44 */         return item;
/*    */       }
/*    */       
/* 47 */       if (!player.func_82247_a(i, j, k, movingobjectposition.field_72310_e, item)) {
/* 48 */         return item;
/*    */       }
/*    */       
/* 51 */       if (isSaltWaterSource(world, i, j, k)) {
/* 52 */         world.func_72956_a(player, "random.splash", 0.125F + rand.nextFloat() / 4.0F, 0.5F + rand.nextFloat());
/* 53 */         item.field_77994_a -= 1;
/* 54 */         EntityItem result = new EntityItem(world, player.field_70165_t, player.field_70163_u, player.field_70161_v, new ItemStack(ItemListMF.misc, 1, 16));
/* 55 */         world.func_72838_d(result);
/*    */       }
/*    */     }
/*    */     
/* 59 */     return item;
/*    */   }
/*    */   
/*    */   private boolean isSaltWaterSource(World world, int i, int j, int k) {
/* 63 */     for (int x = -1; x <= 1; x++) {
/* 64 */       for (int z = -1; z <= 1; z++) {
/* 65 */         if (!isProperSource(world, i + x, j, k + z)) {
/* 66 */           return false;
/*    */         }
/*    */       }
/*    */     }
/* 70 */     return true;
/*    */   }
/*    */   
/*    */   private boolean isProperSource(World world, int x, int y, int z) {
/* 74 */     if (world.func_72803_f(x, y, z) != Material.field_76244_g) {
/* 75 */       return false;
/*    */     }
/* 77 */     return isSandBedded(world, x, y, z);
/*    */   }
/*    */   
/*    */   private boolean isSandBedded(World world, int x, int y, int z) {
/* 81 */     for (int y1 = y; y1 >= 0; y1--) {
/* 82 */       if (world.func_72803_f(x, y1, z) == Material.field_76251_o) {
/* 83 */         if ((!world.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 84 */           System.out.println("Sand " + x + " " + y + " " + z);
/*    */         }
/* 86 */         return true; }
/* 87 */       if (world.func_72803_f(x, y1, z) != Material.field_76244_g) {
/* 88 */         return false;
/*    */       }
/*    */     }
/* 91 */     return false;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemPaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */