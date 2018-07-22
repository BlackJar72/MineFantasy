/*     */ package minefantasy.item;
/*     */ 
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.block.MFDoorEnum;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemDoorMF
/*     */   extends Item
/*     */ {
/*     */   private Material doorMaterial;
/*     */   private MFDoorEnum type;
/*     */   
/*     */   public ItemDoorMF(int id, MFDoorEnum door)
/*     */   {
/*  25 */     super(id);
/*  26 */     this.type = door;
/*  27 */     this.doorMaterial = door.getMaterial();
/*  28 */     this.field_77777_bU = 1;
/*  29 */     func_77637_a(ItemListMF.tabDeco);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_77648_a(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
/*     */   {
/*  38 */     if (par7 != 1) {
/*  39 */       return false;
/*     */     }
/*  41 */     par5++;
/*  42 */     Block var11 = getDoorBlock();
/*     */     
/*  44 */     if ((par2EntityPlayer.func_82247_a(par4, par5, par6, par7, par1ItemStack)) && (par2EntityPlayer.func_82247_a(par4, par5 + 1, par6, par7, par1ItemStack))) {
/*  45 */       if (!var11.func_71930_b(par3World, par4, par5, par6)) {
/*  46 */         return false;
/*     */       }
/*  48 */       int var12 = MathHelper.func_76128_c((par2EntityPlayer.field_70177_z + 180.0F) * 4.0F / 360.0F - 0.5D) & 0x3;
/*  49 */       placeDoorBlock(par3World, par4, par5, par6, var12, var11);
/*  50 */       par1ItemStack.field_77994_a -= 1;
/*  51 */       return true;
/*     */     }
/*     */     
/*  54 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private Block getDoorBlock()
/*     */   {
/*  60 */     if (this.type == MFDoorEnum.IRONBARK)
/*  61 */       return MineFantasyBase.MFBlockDoorIronbark;
/*  62 */     if (this.type == MFDoorEnum.REINFORCED)
/*  63 */       return MineFantasyBase.MFBlockDoorHard;
/*  64 */     if (this.type == MFDoorEnum.STEEL)
/*  65 */       return MineFantasyBase.MFBlockDoorSteel;
/*  66 */     return null;
/*     */   }
/*     */   
/*     */   public static void placeDoorBlock(World world, int x, int y, int z, int side, Block block) {
/*  70 */     byte var6 = 0;
/*  71 */     byte var7 = 0;
/*     */     
/*  73 */     if (side == 0) {
/*  74 */       var7 = 1;
/*     */     }
/*     */     
/*  77 */     if (side == 1) {
/*  78 */       var6 = -1;
/*     */     }
/*     */     
/*  81 */     if (side == 2) {
/*  82 */       var7 = -1;
/*     */     }
/*     */     
/*  85 */     if (side == 3) {
/*  86 */       var6 = 1;
/*     */     }
/*     */     
/*  89 */     int var8 = (world.func_72809_s(x - var6, y, z - var7) ? 1 : 0) + (world.func_72809_s(x - var6, y + 1, z - var7) ? 1 : 0);
/*  90 */     int var9 = (world.func_72809_s(x + var6, y, z + var7) ? 1 : 0) + (world.func_72809_s(x + var6, y + 1, z + var7) ? 1 : 0);
/*  91 */     boolean var10 = (world.func_72798_a(x - var6, y, z - var7) == block.field_71990_ca) || (world.func_72798_a(x - var6, y + 1, z - var7) == block.field_71990_ca);
/*  92 */     boolean var11 = (world.func_72798_a(x + var6, y, z + var7) == block.field_71990_ca) || (world.func_72798_a(x + var6, y + 1, z + var7) == block.field_71990_ca);
/*  93 */     boolean var12 = false;
/*     */     
/*  95 */     if ((var10) && (!var11)) {
/*  96 */       var12 = true;
/*  97 */     } else if (var9 > var8) {
/*  98 */       var12 = true;
/*     */     }
/*     */     
/* 101 */     world.func_72832_d(x, y, z, block.field_71990_ca, side, 2);
/* 102 */     world.func_72832_d(x, y + 1, z, block.field_71990_ca, 0x8 | (var12 ? 1 : 0), 2);
/* 103 */     world.func_72898_h(x, y, z, block.field_71990_ca);
/* 104 */     world.func_72898_h(x, y + 1, z, block.field_71990_ca);
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/* 109 */     func_111206_d("minefantasy:Misc/" + name);
/* 110 */     return super.func_77655_b(name);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemDoorMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */