/*    */ package minefantasy.item.tool;
/*    */ 
/*    */ import java.util.Random;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import minefantasy.item.ToolMaterialMedieval;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.EnumToolMaterial;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemPickaxe;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ItemTool;
/*    */ import net.minecraft.world.GameRules;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.oredict.OreDictionary;
/*    */ 
/*    */ public class ItemPrimitivePick extends ItemTool
/*    */ {
/*    */   public ItemPrimitivePick(int id, EnumToolMaterial material)
/*    */   {
/* 22 */     super(id, 2.0F, material, ItemPickaxe.field_77867_c);
/* 23 */     func_77637_a(ItemListMF.tabTool);
/*    */   }
/*    */   
/*    */   public boolean func_77641_a(Block block) {
/* 27 */     if (this.field_77862_b == ToolMaterialMedieval.PRIMITIVE_COPPER) {
/* 28 */       return Item.field_77713_t.func_77641_a(block);
/*    */     }
/* 30 */     return false;
/*    */   }
/*    */   
/*    */   public float func_77638_a(ItemStack item, Block block) {
/* 34 */     return Item.field_77713_t.func_77638_a(item, block);
/*    */   }
/*    */   
/*    */   public boolean onBlockStartBreak(ItemStack item, int x, int y, int z, EntityPlayer living)
/*    */   {
/* 39 */     boolean copper = this.field_77862_b == ToolMaterialMedieval.PRIMITIVE_COPPER;
/*    */     
/* 41 */     World world = living.field_70170_p;
/* 42 */     ItemStack newdrop = null;
/* 43 */     int id = world.func_72798_a(x, y, z);
/* 44 */     int meta = world.func_72805_g(x, y, z);
/* 45 */     if ((isCopper(id, meta)) && 
/* 46 */       (!copper)) {
/* 47 */       newdrop = ItemListMF.component(113);
/*    */     }
/* 49 */     if (((id == Block.field_71981_t.field_71990_ca) || (id == Block.field_71978_w.field_71990_ca)) && 
/* 50 */       (!copper)) {
/* 51 */       newdrop = ItemListMF.component(111);
/*    */     }
/* 53 */     if ((newdrop != null) && 
/* 54 */       (!world.field_72995_K)) {
/* 55 */       dropBlockAsItem_do(world, x, y, z, newdrop);
/*    */     }
/* 57 */     return super.onBlockStartBreak(newdrop, x, y, z, living);
/*    */   }
/*    */   
/*    */   private boolean isCopper(int id, int meta) {
/* 61 */     for (ItemStack copper : OreDictionary.getOres("oreCopper")) {
/* 62 */       if (copper == null) {
/* 63 */         return false;
/*    */       }
/* 65 */       if (copper.func_77969_a(new ItemStack(id, 1, meta))) {
/* 66 */         return true;
/*    */       }
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   protected void dropBlockAsItem_do(World world, int x, int y, int z, ItemStack item) {
/* 73 */     if ((!world.field_72995_K) && (world.func_82736_K().func_82766_b("doTileDrops"))) {
/* 74 */       float f = 0.7F;
/* 75 */       double d0 = world.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5D;
/* 76 */       double d1 = world.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5D;
/* 77 */       double d2 = world.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5D;
/* 78 */       EntityItem entityitem = new EntityItem(world, x + d0, y + d1, z + d2, item);
/* 79 */       entityitem.field_70293_c = 10;
/* 80 */       world.func_72838_d(entityitem);
/*    */     }
/*    */   }
/*    */   
/*    */   public Item func_77655_b(String name)
/*    */   {
/* 86 */     func_111206_d("minefantasy:Tool/" + name);
/* 87 */     return super.func_77655_b(name);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemPrimitivePick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */