/*    */ package minefantasy.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import minefantasy.api.aesthetic.IChimney;
/*    */ import minefantasy.item.ItemListMF;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.util.Icon;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.ForgeDirection;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockChimney
/*    */   extends Block
/*    */   implements IChimney
/*    */ {
/* 22 */   private Icon[] icons = new Icon[14];
/* 23 */   private String[] names = { "ChimneyIron_Side", "ChimneyIron_Top", "ChimneySteel_Side", "ChimneySteel_Top", "ChimneyCobblestone_Side", "ChimneyCobblestone_Top", "ChimneyBrick_Side", "ChimneyBrick_Top", "ChimneyBronze_Side", "ChimneyBronze_Top", "ChimneyDeepIron_Side", "ChimneyDeepIron_Top" };
/*    */   
/*    */   public BlockChimney(int id)
/*    */   {
/* 27 */     super(id, Material.field_76246_e);
/* 28 */     func_71849_a(ItemListMF.tabSmellting);
/* 29 */     float f = 0.1875F;
/* 30 */     func_71905_a(f, 0.0F, f, 1.0F - f, 1.0F, 1.0F - f);
/*    */   }
/*    */   
/*    */   public boolean func_71886_c()
/*    */   {
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   public boolean func_71926_d()
/*    */   {
/* 40 */     return false;
/*    */   }
/*    */   
/*    */   public Icon func_71858_a(int side, int metadata)
/*    */   {
/* 45 */     int ic = metadata * 2;
/* 46 */     if (side <= 1) {
/* 47 */       ic++;
/*    */     }
/* 49 */     return this.icons[ic];
/*    */   }
/*    */   
/*    */   public boolean puffSmoke(World world, int x, int y, int z, float num, float speedX, float speedY)
/*    */   {
/* 54 */     IChimney chimney = (IChimney)Block.field_71973_m[world.func_72798_a(x, y, z)];
/* 55 */     if (chimney == null) {
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     Random rand = new Random();
/*    */     
/* 61 */     if ((Block.field_71973_m[world.func_72798_a(x, y + 1, z)] instanceof IChimney)) {
/* 62 */       IChimney chimney2 = (IChimney)Block.field_71973_m[world.func_72798_a(x, y + 1, z)];
/* 63 */       return chimney2.puffSmoke(world, x, y + 1, z, num, speedX, speedY);
/*    */     }
/*    */     
/* 66 */     for (int a = 0; a < 30.0F * num; a++) {
/* 67 */       if (!world.isBlockSolidOnSide(x, y + 1, z, ForgeDirection.DOWN)) {
/* 68 */         world.func_72869_a("largesmoke", x + 0.5F, y + 1, z + 0.5F, (rand.nextFloat() - 0.5F) / 6.0F * speedX, 0.065F * speedY, (rand.nextFloat() - 0.5F) / 6.0F * speedX);
/*    */       }
/*    */     }
/* 71 */     return true;
/*    */   }
/*    */   
/*    */   public int func_71899_b(int meta)
/*    */   {
/* 76 */     return meta;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94332_a(IconRegister reg)
/*    */   {
/* 85 */     this.icons = new Icon[this.names.length];
/* 86 */     for (int a = 0; a < this.names.length; a++) {
/* 87 */       this.icons[a] = reg.func_94245_a("minefantasy:Furn/" + this.names[a]);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockChimney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */