/*    */ package minefantasy.api.mining;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class RandomOre
/*    */ {
/* 12 */   public static ArrayList<RandomOre> drops = new ArrayList();
/*    */   
/*    */ 
/*    */   private final ItemStack loot;
/*    */   
/*    */   private final float chanceToDrop;
/*    */   
/*    */   private final int blockID;
/*    */   
/*    */   private final int blockSub;
/*    */   
/*    */   private final int harvestLvl;
/*    */   
/*    */   private final int minHeight;
/*    */   
/*    */   private final int maxHeight;
/*    */   
/*    */   private final boolean doesSilktouchDisable;
/*    */   
/*    */ 
/*    */   public static void addOre(ItemStack drop, float chance, Object block, int harvestLevel, int min, int max, boolean silkDisable)
/*    */   {
/* 34 */     drops.add(new RandomOre(drop, chance, block, harvestLevel, min, max, silkDisable));
/*    */   }
/*    */   
/*    */   public static ArrayList<ItemStack> getDroppedItems(int id, int meta, int harvest, int fortune, boolean silktouch, int y) {
/* 38 */     ArrayList<ItemStack> loot = new ArrayList();
/*    */     
/* 40 */     if (!drops.isEmpty()) {
/* 41 */       Iterator list = drops.iterator();
/*    */       
/* 43 */       while (list.hasNext()) {
/* 44 */         RandomOre ore = (RandomOre)list.next();
/* 45 */         if (matchesOre(ore, id, meta, harvest, fortune / 2.0F + 1.0F, silktouch, y)) {
/* 46 */           loot.add(ore.loot);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 51 */     return loot;
/*    */   }
/*    */   
/*    */   private static boolean matchesOre(RandomOre ore, int id, int meta, int harvest, float multiplier, boolean silktouch, int y) {
/* 55 */     Random random = new Random();
/*    */     
/* 57 */     if ((ore.doesSilktouchDisable) && (silktouch)) {
/* 58 */       return false;
/*    */     }
/*    */     
/* 61 */     if (((ore.minHeight != -1) || (ore.maxHeight != -1)) && (
/* 62 */       (y < ore.minHeight) || (y > ore.maxHeight))) {
/* 63 */       return false;
/*    */     }
/*    */     
/* 66 */     if (ore.blockID != id) {
/* 67 */       return false;
/*    */     }
/* 69 */     if ((ore.blockSub != meta) && (ore.blockSub != 32767)) {
/* 70 */       return false;
/*    */     }
/* 72 */     if (ore.harvestLvl > harvest) {
/* 73 */       return false;
/*    */     }
/* 75 */     return random.nextFloat() < ore.chanceToDrop * multiplier;
/*    */   }
/*    */   
/*    */   public RandomOre(ItemStack drop, float chance, Object block, int harvestLevel, int min, int max, boolean silkDisable) {
/* 79 */     this.doesSilktouchDisable = silkDisable;
/* 80 */     this.minHeight = min;
/* 81 */     this.maxHeight = max;
/* 82 */     this.loot = drop;
/* 83 */     this.chanceToDrop = chance;
/* 84 */     this.harvestLvl = harvestLevel;
/*    */     
/* 86 */     if ((block instanceof ItemStack)) {
/* 87 */       this.blockID = ((ItemStack)block).field_77993_c;
/* 88 */       this.blockSub = ((ItemStack)block).func_77960_j();
/* 89 */     } else if ((block instanceof Block)) {
/* 90 */       this.blockID = ((Block)block).field_71990_ca;
/* 91 */       this.blockSub = 32767;
/* 92 */     } else if ((block instanceof Integer)) {
/* 93 */       this.blockID = ((Integer)block).intValue();
/* 94 */       this.blockSub = 32767;
/*    */     } else {
/* 96 */       this.blockID = Block.field_71981_t.field_71990_ca;
/* 97 */       this.blockSub = 32767;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/mining/RandomOre.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */