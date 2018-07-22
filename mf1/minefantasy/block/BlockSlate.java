/*    */ package minefantasy.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.Icon;
/*    */ 
/*    */ public class BlockSlate extends Block
/*    */ {
/*    */   public static final int amount = 4;
/*    */   @SideOnly(Side.CLIENT)
/*    */   private Icon[] iconArray;
/*    */   
/*    */   public BlockSlate(int id)
/*    */   {
/* 22 */     super(id, Material.field_76246_e);
/* 23 */     func_71849_a(ItemListMF.tabDeco);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Icon func_71858_a(int side, int meta)
/*    */   {
/* 32 */     return this.iconArray[(meta % this.iconArray.length)];
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int func_71899_b(int meta)
/*    */   {
/* 40 */     return meta;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_71879_a(int id, CreativeTabs tab, List list)
/*    */   {
/* 48 */     for (int j = 0; j < 4; j++) {
/* 49 */       list.add(new ItemStack(id, 1, j));
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94332_a(IconRegister reg)
/*    */   {
/* 60 */     this.iconArray = new Icon[4];
/* 61 */     for (int i = 0; i < this.iconArray.length; i++) {
/* 62 */       this.iconArray[i] = reg.func_94245_a("MineFantasy:Basic/slate" + i);
/*    */     }
/*    */   }
/*    */   
/*    */   public Block func_71864_b(String name)
/*    */   {
/* 68 */     func_111022_d("minefantasy:Basic/" + name);
/* 69 */     return super.func_71864_b(name);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockSlate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */