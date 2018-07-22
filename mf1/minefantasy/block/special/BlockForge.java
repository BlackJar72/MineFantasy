/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.common.network.PacketDispatcher;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.anvil.ITongs;
/*     */ import minefantasy.api.forge.HeatableItem;
/*     */ import minefantasy.api.forge.ILighter;
/*     */ import minefantasy.api.forge.TongsHelper;
/*     */ import minefantasy.client.tile.TileEntityForge;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.item.tool.ItemHammer;
/*     */ import minefantasy.system.cfg;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemFlintAndSteel;
/*     */ import net.minecraft.item.ItemPotion;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AABBPool;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockForge
/*     */   extends BlockContainer
/*     */ {
/*  53 */   private static Random rand = new Random();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  60 */   private static boolean keepFurnaceInventory = false;
/*     */   
/*     */   public BlockForge(int id) {
/*  63 */     super(id, Material.field_76246_e);
/*  64 */     func_71849_a(ItemListMF.tabSmellting);
/*  65 */     func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.45F, 1.0F);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d()
/*     */   {
/*  70 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_71886_c()
/*     */   {
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
/*     */   {
/*  80 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/*     */     
/*  82 */     TileEntityForge tile = (TileEntityForge)world.func_72796_p(x, y, z);
/*  83 */     tile.direction = dir;
/*     */   }
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z)
/*     */   {
/*  88 */     int meta = world.func_72805_g(x, y, z);
/*  89 */     if ((meta == 1) || (meta == 3)) {
/*  90 */       return 10;
/*     */     }
/*  92 */     return super.getLightValue(world, x, y, z);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71857_b() {
/*  97 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/* 102 */     return Block.field_71981_t.func_71858_a(side, 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71862_a(World world, int x, int y, int z, Random rand)
/*     */   {
/* 110 */     TileEntityForge tile = (TileEntityForge)world.func_72796_p(x, y, z);
/* 111 */     if (tile.isBurning()) {
/* 112 */       for (int a = 0; a < rand.nextInt(11); a++) {
/* 113 */         world.func_72869_a("smoke", x + rand.nextDouble() * 0.8D + 0.1D, y + 0.3D, z + rand.nextDouble() * 0.8D + 0.1D, 0.0D, 0.02D, 0.0D);
/*     */       }
/* 115 */       if (rand.nextInt(10) == 0) {
/* 116 */         world.func_72869_a("lava", x + rand.nextDouble() * 0.8D + 0.1D, y + 0.3D, z + rand.nextDouble() * 0.8D + 0.1D, 0.0D, 0.02D, 0.0D);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int side, float f, float f1, float f2) {
/* 122 */     ItemStack held = player.func_70694_bm();
/* 123 */     TileEntityForge tile = (TileEntityForge)world.func_72796_p(x, y, z);
/*     */     
/* 125 */     if (tile == null) {
/* 126 */       return super.func_71903_a(world, x, y, z, player, side, f, f1, f2);
/*     */     }
/* 128 */     tile.findConstruction();
/* 129 */     if (tile.constructed != 1) {
/* 130 */       return super.func_71903_a(world, x, y, z, player, side, f, f1, f2);
/*     */     }
/*     */     
/* 133 */     if ((cfg.lightForge) && (held != null))
/*     */     {
/* 135 */       if ((tile.isLit) && (held.field_77993_c == Block.field_71939_E.field_71990_ca)) {
/* 136 */         tile.extinguishByHand();
/* 137 */         return true;
/*     */       }
/* 139 */       if ((tile.fuel > 0) && (((held.func_77973_b() instanceof ILighter)) || ((held.func_77973_b() instanceof ItemFlintAndSteel)))) {
/* 140 */         boolean fire = false;
/* 141 */         world.func_72908_a(x + 0.5D, y - 0.5D, z + 0.5D, "fire.ignite", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
/* 142 */         world.func_72869_a("flame", x + 0.5D, y - 0.5D, z + 0.5D, 0.0D, 0.0D, 0.0D);
/*     */         
/* 144 */         if ((held.func_77973_b() instanceof ILighter)) {
/* 145 */           ILighter lighter = (ILighter)held.func_77973_b();
/* 146 */           if ((lighter.canLight()) && 
/* 147 */             (rand.nextDouble() < lighter.getChance())) {
/* 148 */             fire = true;
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 153 */         if (((fire) || ((held.func_77973_b() instanceof ItemFlintAndSteel))) && 
/* 154 */           (!world.field_72995_K)) {
/* 155 */           tile.setLit(true);
/* 156 */           held.func_77972_a(1, player);
/*     */         }
/*     */         
/* 159 */         return true;
/*     */       }
/* 161 */       if ((!tile.isLit) && (tile.fuel > 0) && ((held.func_77973_b() instanceof ItemHammer))) {
/* 162 */         ItemHammer hammer = (ItemHammer)held.func_77973_b();
/* 163 */         if (hammer.getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 164 */           world.func_72908_a(x + 0.5D, y - 0.5D, z + 0.5D, "fire.ignite", 1.0F, rand.nextFloat() * 0.4F + 0.8F);
/* 165 */           world.func_72869_a("flame", x + 0.5D, y - 0.5D, z + 0.5D, 0.0D, 0.0D, 0.0D);
/*     */           
/* 167 */           if (!world.field_72995_K) {
/* 168 */             tile.setLit(true);
/* 169 */             held.func_77972_a(1, player);
/*     */           }
/* 171 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 175 */     if (world.field_72995_K) {
/* 176 */       int slot = tile.getSlotFor(f, f2);
/* 177 */       useInventory(world, x, y, z, tile, player, side, slot);
/*     */       
/* 179 */       Packet packet = PacketManagerMF.getPacketIntegerArray(tile, new int[] { 2, player.field_70157_k, side, slot });
/*     */       try {
/* 181 */         PacketDispatcher.sendPacketToServer(packet);
/*     */       } catch (NullPointerException e) {
/* 183 */         System.out.println("MineFantasy: Client connection lost");
/*     */       }
/*     */     }
/*     */     
/* 187 */     return true;
/*     */   }
/*     */   
/*     */   private static void tryBurn(EntityPlayer player) {
/* 191 */     if (player.field_71075_bZ.field_75098_d) {
/* 192 */       return;
/*     */     }
/* 194 */     if (rand.nextInt(2) == 0) {
/* 195 */       if ((player.func_82169_q(2) != null) && 
/* 196 */         (player.func_82169_q(2).field_77993_c == ItemListMF.apronSmithy.field_77779_bT)) {
/* 197 */         return;
/*     */       }
/*     */       
/* 200 */       player.func_70015_d(1);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canHeatItem(ItemStack item)
/*     */   {
/* 206 */     if (HeatableItem.canHeatItem(item)) {
/* 207 */       return true;
/*     */     }
/* 209 */     return item.field_77993_c == ItemListMF.hotItem.field_77779_bT;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public TileEntity func_72274_a(World w)
/*     */   {
/* 216 */     return new TileEntityForge();
/*     */   }
/*     */   
/*     */   public int func_71899_b(int meta)
/*     */   {
/* 221 */     return (int)Math.floor(meta / 2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2)
/*     */   {
/* 229 */     if (!keepFurnaceInventory) {
/* 230 */       TileEntityForge tile = (TileEntityForge)world.func_72796_p(x, y, z);
/*     */       
/* 232 */       if (tile != null) {
/* 233 */         for (int var6 = 0; var6 < tile.func_70302_i_(); var6++) {
/* 234 */           ItemStack var7 = tile.func_70301_a(var6);
/*     */           
/* 236 */           if (var7 != null) {
/* 237 */             float var8 = rand.nextFloat() * 0.8F + 0.1F;
/* 238 */             float var9 = rand.nextFloat() * 0.8F + 0.1F;
/* 239 */             float var10 = rand.nextFloat() * 0.8F + 0.1F;
/*     */             
/* 241 */             while (var7.field_77994_a > 0) {
/* 242 */               int var11 = rand.nextInt(21) + 10;
/*     */               
/* 244 */               if (var11 > var7.field_77994_a) {
/* 245 */                 var11 = var7.field_77994_a;
/*     */               }
/*     */               
/* 248 */               var7.field_77994_a -= var11;
/* 249 */               EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(var7.field_77993_c, var11, var7.func_77960_j()));
/*     */               
/* 251 */               if (var7.func_77942_o()) {
/* 252 */                 var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b());
/*     */               }
/*     */               
/* 255 */               float var13 = 0.05F;
/* 256 */               var12.field_70159_w = ((float)rand.nextGaussian() * var13);
/* 257 */               var12.field_70181_x = ((float)rand.nextGaussian() * var13 + 0.2F);
/* 258 */               var12.field_70179_y = ((float)rand.nextGaussian() * var13);
/* 259 */               world.func_72838_d(var12);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 266 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */   public void func_71891_b(World world, int x, int y, int z, Entity entity)
/*     */   {
/* 271 */     TileEntityForge tile = (TileEntityForge)world.func_72796_p(x, y, z);
/*     */     
/* 273 */     if ((tile != null) && 
/* 274 */       (tile.isBurning())) {
/* 275 */       entity.func_70015_d(10);
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean onUsedWithTongs(EntityPlayer player, ItemStack tongs, int slot, TileEntityForge tile)
/*     */   {
/* 281 */     ItemStack held = TongsHelper.getHeldItem(tongs);
/* 282 */     if (held == null) {
/* 283 */       ItemStack out = tile.func_70301_a(slot);
/* 284 */       if ((out != null) && 
/* 285 */         (TongsHelper.trySetHeldItem(tongs, out))) {
/* 286 */         tile.func_70298_a(slot, 1);
/* 287 */         return true;
/*     */       }
/*     */     }
/* 290 */     else if (tile.func_70301_a(slot) == null) {
/* 291 */       tile.func_70299_a(slot, TongsHelper.getHeldItem(tongs));
/* 292 */       player.func_70062_b(0, TongsHelper.clearHeldItem(tongs, player));
/* 293 */       return true;
/*     */     }
/* 295 */     return false;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_71872_e(World world, int x, int y, int z)
/*     */   {
/* 300 */     return AxisAlignedBB.func_72332_a().func_72299_a(x, y, z, x + 1, y + 0.42D, z + 1);
/*     */   }
/*     */   
/*     */   public void func_71869_a(World world, int x, int y, int z, Entity entity)
/*     */   {
/* 305 */     if (world.field_72995_K) {
/* 306 */       return;
/*     */     }
/*     */     
/* 309 */     TileEntityForge tile = (TileEntityForge)world.func_72796_p(x, y, z);
/* 310 */     if ((entity == null) || (tile == null)) {
/* 311 */       return;
/*     */     }
/* 313 */     if (!tile.isBurning()) {
/* 314 */       return;
/*     */     }
/*     */     
/* 317 */     if ((entity instanceof EntityItem)) {
/* 318 */       if (entity.field_70173_aa % 25 == 0) {
/* 319 */         entity.field_70181_x = 0.20000000298023224D;
/* 320 */         entity.func_85030_a("random.fizz", 0.4F, 2.0F + rand.nextFloat() * 0.4F);
/*     */       }
/*     */     } else {
/* 323 */       entity.func_70097_a(DamageSource.field_76372_a, 1.0F);
/*     */     }
/*     */     
/* 326 */     entity.func_70015_d(10);
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */   
/*     */   public static boolean useInventory(World world, int x, int y, int z, TileEntityForge tile, EntityPlayer player, int i, int slot)
/*     */   {
/* 335 */     if (tile != null) {
/* 336 */       if (tile.isBurning()) {
/* 337 */         tryBurn(player);
/*     */       }
/* 339 */       ItemStack itemstack = player.func_70694_bm();
/*     */       
/*     */ 
/* 342 */       if ((itemstack != null) && (itemstack.field_77993_c == Item.field_77726_bs.field_77779_bT) && (itemstack.func_77960_j() == 0)) {
/* 343 */         tile.splashWater();
/* 344 */         if (!player.field_71075_bZ.field_75098_d)
/* 345 */           player.func_70062_b(0, new ItemStack(Item.field_77729_bt));
/* 346 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 350 */       if ((itemstack != null) && (tile.fuel < tile.getMaxFuel()) && (tile.isItemFuel(itemstack))) {
/* 351 */         tile.consumeFuel(itemstack);
/*     */         
/* 353 */         if (!player.field_71075_bZ.field_75098_d) {
/* 354 */           itemstack.field_77994_a -= 1;
/*     */         }
/*     */         
/* 357 */         return true;
/*     */       }
/*     */       
/* 360 */       if (i == 1)
/*     */       {
/* 362 */         if (tile.tryAddItem(slot, itemstack)) {
/* 363 */           if (!player.field_71075_bZ.field_75098_d) {
/* 364 */             itemstack.field_77994_a -= 1;
/*     */           }
/*     */           
/* 367 */           return true;
/*     */         }
/*     */         
/*     */ 
/* 371 */         if ((slot >= 0) && (itemstack != null) && ((itemstack.func_77973_b() instanceof ITongs)) && 
/* 372 */           (onUsedWithTongs(player, itemstack, slot, tile))) {
/* 373 */           tile.syncItems();
/* 374 */           return true;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 380 */       player.openGui(MineFantasyBase.instance, 6, world, x, y, z);
/*     */     }
/*     */     
/* 383 */     return true;
/*     */   }
/*     */   
/*     */   public float func_71934_m(World world, int x, int y, int z)
/*     */   {
/* 388 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/* 390 */     if ((meta == 4) || (meta == 5)) {
/* 391 */       return Block.field_72089_ap.field_71989_cb;
/*     */     }
/* 393 */     return super.func_71934_m(world, x, y, z);
/*     */   }
/*     */   
/*     */   public float getExplosionResistance(Entity explosion, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ)
/*     */   {
/* 398 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/* 400 */     if ((meta == 4) || (meta == 5)) {
/* 401 */       return Block.field_72089_ap.field_72029_cc;
/*     */     }
/* 403 */     return super.getExplosionResistance(explosion, world, x, y, z, explosionX, explosionY, explosionZ);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */