/*    */ package minefantasy.block;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public enum MFDoorEnum
/*    */ {
/*  9 */   IRONBARK(0, true, true, Material.field_76245_d),  STEEL(2, false, false, Material.field_76243_f),  REINFORCED(4, true, false, Material.field_76245_d);
/*    */   
/*    */   private final boolean canHandOpen;
/*    */   private final boolean canMobSmash;
/*    */   private final Material doorMaterial;
/*    */   private Item item;
/*    */   private Block block;
/*    */   private int texture;
/*    */   
/*    */   private MFDoorEnum(int tex, boolean open, boolean smash, Material material) {
/* 19 */     this.canHandOpen = open;
/* 20 */     this.canMobSmash = smash;
/* 21 */     this.doorMaterial = material;
/* 22 */     this.texture = tex;
/*    */   }
/*    */   
/*    */   public boolean canBeHandOpened() {
/* 26 */     return this.canHandOpen;
/*    */   }
/*    */   
/*    */   public boolean canMobSmash() {
/* 30 */     return this.canMobSmash;
/*    */   }
/*    */   
/*    */   public Material getMaterial() {
/* 34 */     return this.doorMaterial;
/*    */   }
/*    */   
/*    */   public int getTexture() {
/* 38 */     return this.texture;
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/MFDoorEnum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */