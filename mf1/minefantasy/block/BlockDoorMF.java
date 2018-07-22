/*     */ package minefantasy.block;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.IconFlipped;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class BlockDoorMF
/*     */   extends Block
/*     */ {
/*     */   public MFDoorEnum type;
/*     */   private int blockIndexInTexture;
/*  26 */   public Icon[] icon = new Icon[6];
/*     */   
/*  28 */   private static final String[] doornames = { "doorIronbark_lower", "doorIronbark_upper", "doorSteel_lower", "doorSteel_upper", "doorReinforced_lower", "doorReinforced_upper" };
/*     */   private final int baseTex;
/*     */   
/*     */   public BlockDoorMF(int id, MFDoorEnum door) {
/*  32 */     super(id, door.getMaterial());
/*  33 */     this.type = door;
/*  34 */     func_71896_v();
/*  35 */     this.blockIndexInTexture = (door.getTexture() + 1);
/*  36 */     this.baseTex = door.getTexture();
/*  37 */     func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.5F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Icon func_71858_a(int side, int metadata)
/*     */   {
/*  46 */     return this.icon[this.baseTex];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Icon func_71895_b(IBlockAccess world, int x, int y, int z, int meta)
/*     */   {
/*  54 */     if ((meta != 1) && (meta != 0)) {
/*  55 */       int i1 = getFullMetadata(world, x, y, z);
/*  56 */       int j1 = i1 & 0x3;
/*  57 */       boolean flag = (i1 & 0x4) != 0;
/*  58 */       boolean flag1 = false;
/*  59 */       boolean flag2 = (i1 & 0x8) != 0;
/*     */       
/*  61 */       if (flag) {
/*  62 */         if ((j1 == 0) && (meta == 2)) {
/*  63 */           flag1 = !flag1;
/*  64 */         } else if ((j1 == 1) && (meta == 5)) {
/*  65 */           flag1 = !flag1;
/*  66 */         } else if ((j1 == 2) && (meta == 3)) {
/*  67 */           flag1 = !flag1;
/*  68 */         } else if ((j1 == 3) && (meta == 4)) {
/*  69 */           flag1 = !flag1;
/*     */         }
/*     */       } else {
/*  72 */         if ((j1 == 0) && (meta == 5)) {
/*  73 */           flag1 = !flag1;
/*  74 */         } else if ((j1 == 1) && (meta == 3)) {
/*  75 */           flag1 = !flag1;
/*  76 */         } else if ((j1 == 2) && (meta == 4)) {
/*  77 */           flag1 = !flag1;
/*  78 */         } else if ((j1 == 3) && (meta == 2)) {
/*  79 */           flag1 = !flag1;
/*     */         }
/*     */         
/*  82 */         if ((i1 & 0x10) != 0) {
/*  83 */           flag1 = !flag1;
/*     */         }
/*     */       }
/*     */       
/*  87 */       return this.icon[(this.baseTex + 0 + 0)];
/*     */     }
/*  89 */     return this.icon[this.baseTex];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71926_d()
/*     */   {
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_71918_c(IBlockAccess world, int x, int y, int z) {
/* 103 */     int var5 = getFullMetadata(world, x, y, z);
/* 104 */     return (var5 & 0x4) != 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71886_c()
/*     */   {
/* 112 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_71857_b()
/*     */   {
/* 119 */     return 7;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public AxisAlignedBB func_71911_a_(World world, int x, int y, int z)
/*     */   {
/* 127 */     func_71902_a(world, x, y, z);
/* 128 */     return super.func_71911_a_(world, x, y, z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public AxisAlignedBB func_71872_e(World world, int x, int y, int z)
/*     */   {
/* 136 */     func_71902_a(world, x, y, z);
/* 137 */     return super.func_71872_e(world, x, y, z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71902_a(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 145 */     setDoorRotation(getFullMetadata(world, x, y, z));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getDoorOrientation(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 152 */     return getFullMetadata(world, x, y, z) & 0x3;
/*     */   }
/*     */   
/*     */   public boolean isDoorOpen(IBlockAccess world, int x, int y, int z) {
/* 156 */     return (getFullMetadata(world, x, y, z) & 0x4) != 0;
/*     */   }
/*     */   
/*     */   private void setDoorRotation(int par1) {
/* 160 */     float var2 = 0.1875F;
/* 161 */     func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
/* 162 */     int var3 = par1 & 0x3;
/* 163 */     boolean var4 = (par1 & 0x4) != 0;
/* 164 */     boolean var5 = (par1 & 0x10) != 0;
/*     */     
/* 166 */     if (var3 == 0) {
/* 167 */       if (var4) {
/* 168 */         if (!var5) {
/* 169 */           func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
/*     */         } else {
/* 171 */           func_71905_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
/*     */         }
/*     */       } else {
/* 174 */         func_71905_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
/*     */       }
/* 176 */     } else if (var3 == 1) {
/* 177 */       if (var4) {
/* 178 */         if (!var5) {
/* 179 */           func_71905_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */         } else {
/* 181 */           func_71905_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
/*     */         }
/*     */       } else {
/* 184 */         func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
/*     */       }
/* 186 */     } else if (var3 == 2) {
/* 187 */       if (var4) {
/* 188 */         if (!var5) {
/* 189 */           func_71905_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
/*     */         } else {
/* 191 */           func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
/*     */         }
/*     */       } else {
/* 194 */         func_71905_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */       }
/* 196 */     } else if (var3 == 3) {
/* 197 */       if (var4) {
/* 198 */         if (!var5) {
/* 199 */           func_71905_a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
/*     */         } else {
/* 201 */           func_71905_a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */         }
/*     */       } else {
/* 204 */         func_71905_a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer user, int side, float yaw, float pitch, float pan)
/*     */   {
/* 213 */     if ((this.type != null) && (!this.type.canBeHandOpened())) {
/* 214 */       return false;
/*     */     }
/* 216 */     int var10 = getFullMetadata(world, x, y, z);
/* 217 */     int var11 = var10 & 0x7;
/* 218 */     var11 ^= 0x4;
/*     */     
/* 220 */     if ((var10 & 0x8) == 0) {
/* 221 */       world.func_72921_c(x, y, z, var11, 2);
/* 222 */       world.func_72909_d(x, y, z, x, y, z);
/*     */     } else {
/* 224 */       world.func_72921_c(x, y - 1, z, var11, 2);
/* 225 */       world.func_72909_d(x, y - 1, z, x, y, z);
/*     */     }
/*     */     
/* 228 */     world.func_72889_a(user, 1003, x, y, z, 0);
/* 229 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onPoweredBlockChange(World world, int x, int y, int z, boolean charge)
/*     */   {
/* 237 */     int var6 = getFullMetadata(world, x, y, z);
/* 238 */     boolean var7 = (var6 & 0x4) != 0;
/*     */     
/* 240 */     if (var7 != charge) {
/* 241 */       int var8 = var6 & 0x7;
/* 242 */       var8 ^= 0x4;
/*     */       
/* 244 */       if ((var6 & 0x8) == 0) {
/* 245 */         world.func_72921_c(x, y, z, var8, 2);
/* 246 */         world.func_72909_d(x, y, z, x, y, z);
/*     */       } else {
/* 248 */         world.func_72921_c(x, y - 1, z, var8, 2);
/* 249 */         world.func_72909_d(x, y - 1, z, x, y, z);
/*     */       }
/*     */       
/* 252 */       world.func_72889_a((EntityPlayer)null, 1003, x, y, z, 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71863_a(World world, int x, int y, int z, int meta)
/*     */   {
/* 262 */     int var6 = world.func_72805_g(x, y, z);
/*     */     
/* 264 */     if ((var6 & 0x8) == 0) {
/* 265 */       boolean var7 = false;
/*     */       
/* 267 */       if (world.func_72798_a(x, y + 1, z) != this.field_71990_ca) {
/* 268 */         world.func_94571_i(x, y, z);
/* 269 */         var7 = true;
/*     */       }
/*     */       
/* 272 */       if (!world.func_72797_t(x, y - 1, z)) {
/* 273 */         world.func_94571_i(x, y, z);
/* 274 */         var7 = true;
/*     */         
/* 276 */         if (world.func_72798_a(x, y + 1, z) == this.field_71990_ca) {
/* 277 */           world.func_94571_i(x, y + 1, z);
/*     */         }
/*     */       }
/*     */       
/* 281 */       if (var7) {
/* 282 */         if (!world.field_72995_K) {
/* 283 */           func_71897_c(world, x, y, z, var6, 0);
/*     */         }
/*     */       } else {
/* 286 */         boolean var8 = (world.func_72864_z(x, y, z)) || (world.func_72864_z(x, y + 1, z));
/*     */         
/* 288 */         if (((var8) || ((meta > 0) && (Block.field_71973_m[meta].func_71853_i()))) && (meta != this.field_71990_ca)) {
/* 289 */           onPoweredBlockChange(world, x, y, z, var8);
/*     */         }
/*     */       }
/*     */     } else {
/* 293 */       if (world.func_72798_a(x, y - 1, z) != this.field_71990_ca) {
/* 294 */         world.func_94571_i(x, y, z);
/*     */       }
/*     */       
/* 297 */       if ((meta > 0) && (meta != this.field_71990_ca)) {
/* 298 */         func_71863_a(world, x, y - 1, z, meta);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_71885_a(int id, Random rand, int meta)
/*     */   {
/* 307 */     return (id & 0x8) != 0 ? 0 : getDoorItem().field_77779_bT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MovingObjectPosition func_71878_a(World world, int x, int y, int z, Vec3 vec, Vec3 vec2)
/*     */   {
/* 315 */     func_71902_a(world, x, y, z);
/* 316 */     return super.func_71878_a(world, x, y, z, vec, vec2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71930_b(World par1World, int par2, int par3, int par4)
/*     */   {
/* 324 */     return par3 < 255;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_71915_e()
/*     */   {
/* 332 */     return 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getFullMetadata(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
/*     */   {
/* 340 */     int var5 = par1IBlockAccess.func_72805_g(par2, par3, par4);
/* 341 */     boolean var6 = (var5 & 0x8) != 0;
/*     */     int var8;
/*     */     int var7;
/*     */     int var8;
/* 345 */     if (var6) {
/* 346 */       int var7 = par1IBlockAccess.func_72805_g(par2, par3 - 1, par4);
/* 347 */       var8 = var5;
/*     */     } else {
/* 349 */       var7 = var5;
/* 350 */       var8 = par1IBlockAccess.func_72805_g(par2, par3 + 1, par4);
/*     */     }
/*     */     
/* 353 */     boolean var9 = (var8 & 0x1) != 0;
/* 354 */     return var7 & 0x7 | (var6 ? 8 : 0) | (var9 ? 16 : 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71922_a(World par1World, int par2, int par3, int par4)
/*     */   {
/* 362 */     return getDoorItem().field_77779_bT;
/*     */   }
/*     */   
/*     */   private Item getDoorItem() {
/* 366 */     if (this.type == MFDoorEnum.IRONBARK)
/* 367 */       return ItemListMF.doorIronbark;
/* 368 */     if (this.type == MFDoorEnum.REINFORCED)
/* 369 */       return ItemListMF.doorHard;
/* 370 */     if (this.type == MFDoorEnum.STEEL)
/* 371 */       return ItemListMF.doorSteel;
/* 372 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71846_a(World world, int x, int y, int z, int meta, EntityPlayer player)
/*     */   {
/* 379 */     if ((player.field_71075_bZ.field_75098_d) && ((meta & 0x8) != 0) && (world.func_72798_a(x, y - 1, z) == this.field_71990_ca)) {
/* 380 */       world.func_94571_i(x, y - 1, z);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister par1IconRegister)
/*     */   {
/* 391 */     this.icon = new Icon[doornames.length * 2];
/*     */     
/* 393 */     for (int i = 0; i < doornames.length; i++) {
/* 394 */       this.icon[i] = par1IconRegister.func_94245_a("MineFantasy:Furn/" + doornames[i]);
/* 395 */       this.icon[(i + doornames.length)] = new IconFlipped(this.icon[i], true, false);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/BlockDoorMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */