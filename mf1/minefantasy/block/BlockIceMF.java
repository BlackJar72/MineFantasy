/*     */ package minefantasy.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockBreakable;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockIceMF
/*     */   extends BlockBreakable
/*     */ {
/*     */   public BlockIceMF(int id, int tex)
/*     */   {
/*  26 */     super(id, "Ice_MF", Material.field_76260_u, false);
/*  27 */     this.field_72016_cq = 0.98F;
/*  28 */     func_71907_b(true);
/*  29 */     func_71849_a(ItemListMF.tabDeco);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71856_s_()
/*     */   {
/*  37 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_71877_c(IBlockAccess block, int x, int y, int z, int meta)
/*     */   {
/*  46 */     return super.func_71877_c(block, x, y, z, 1 - meta);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71893_a(World world, EntityPlayer player, int x, int y, int z, int meta)
/*     */   {
/*  59 */     player.func_71064_a(net.minecraft.stats.StatList.field_75934_C[this.field_71990_ca], 1);
/*  60 */     player.func_71020_j(0.025F);
/*     */     
/*  62 */     if ((func_71906_q_()) && (EnchantmentHelper.func_77502_d(player))) {
/*  63 */       ItemStack var9 = func_71880_c_(meta);
/*     */       
/*  65 */       if (var9 != null) {
/*  66 */         func_71929_a(world, x, y, z, var9);
/*     */       }
/*     */     } else {
/*  69 */       world.func_94571_i(z, y, z);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_71925_a(Random rand)
/*     */   {
/*  77 */     return 0;
/*     */   }
/*     */   
/*     */   protected ItemStack func_71880_c_(int meta) {
/*  81 */     int var2 = 0;
/*     */     
/*  83 */     if ((this.field_71990_ca >= 0) && (this.field_71990_ca < Item.field_77698_e.length) && (Item.field_77698_e[this.field_71990_ca].func_77614_k())) {
/*  84 */       var2 = meta;
/*     */     }
/*     */     
/*  87 */     return new ItemStack(Block.field_72036_aT.field_71990_ca, 1, var2);
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/*  92 */     return Block.field_72036_aT.func_71858_a(side, meta);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71847_b(World world, int x, int y, int z, Random rand)
/*     */   {
/*  99 */     world.func_94571_i(x, y, z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71915_e()
/*     */   {
/* 107 */     return 0;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockIceMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */