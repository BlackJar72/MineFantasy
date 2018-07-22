/*    */ package minefantasy.item.tool;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemLighter extends Item implements minefantasy.api.forge.ILighter
/*    */ {
/*    */   private double efficiency;
/*    */   
/*    */   public ItemLighter(int id, int uses, double successRate)
/*    */   {
/* 15 */     super(id);
/* 16 */     this.field_77777_bU = 1;
/* 17 */     func_77656_e(uses);
/* 18 */     this.efficiency = successRate;
/* 19 */     func_77637_a(net.minecraft.creativetab.CreativeTabs.field_78040_i);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean func_77648_a(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float f, float f1, float f2)
/*    */   {
/* 28 */     if (side == 0) {
/* 29 */       y--;
/*    */     }
/*    */     
/* 32 */     if (side == 1) {
/* 33 */       y++;
/*    */     }
/*    */     
/* 36 */     if (side == 2) {
/* 37 */       z--;
/*    */     }
/*    */     
/* 40 */     if (side == 3) {
/* 41 */       z++;
/*    */     }
/*    */     
/* 44 */     if (side == 4) {
/* 45 */       x--;
/*    */     }
/*    */     
/* 48 */     if (side == 5) {
/* 49 */       x++;
/*    */     }
/*    */     
/* 52 */     if (!player.func_82247_a(x, y, z, side, item)) {
/* 53 */       return false;
/*    */     }
/* 55 */     int i1 = world.func_72798_a(x, y, z);
/*    */     
/* 57 */     if (i1 == 0) {
/* 58 */       world.func_72908_a(x + 0.5D, y + 0.5D, z + 0.5D, "fire.ignite", 1.0F, field_77697_d.nextFloat() * 0.4F + 0.8F);
/* 59 */       world.func_72869_a("flame", x + 0.5D, y + 0.5D, z + 0.5D, 0.0D, 0.0D, 0.0D);
/* 60 */       if ((player.func_70681_au().nextDouble() < this.efficiency) && 
/* 61 */         (!world.field_72995_K)) {
/* 62 */         world.func_94575_c(x, y, z, net.minecraft.block.Block.field_72067_ar.field_71990_ca);
/* 63 */         item.func_77972_a(1, player);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 68 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public Item func_77655_b(String name)
/*    */   {
/* 74 */     func_111206_d("minefantasy:Tool/" + name);
/* 75 */     return super.func_77655_b(name);
/*    */   }
/*    */   
/*    */   public double getChance()
/*    */   {
/* 80 */     return this.efficiency;
/*    */   }
/*    */   
/*    */   public boolean canLight()
/*    */   {
/* 85 */     return true;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemLighter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */