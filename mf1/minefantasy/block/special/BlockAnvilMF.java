/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.common.network.PacketDispatcher;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.anvil.IHammer;
/*     */ import minefantasy.api.anvil.ITongs;
/*     */ import minefantasy.api.anvil.ItemRepairHammer;
/*     */ import minefantasy.api.forge.TongsHelper;
/*     */ import minefantasy.client.tile.TileEntityAnvil;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.tool.ItemTongs;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.cfg;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockAnvilMF
/*     */   extends BlockContainer
/*     */ {
/*  52 */   private Random rand = new Random();
/*     */   
/*     */   public BlockAnvilMF(int i, int n, Material m) {
/*  55 */     super(i, m);
/*  56 */     func_71905_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
/*  57 */     func_71849_a(ItemListMF.tabSmith);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d() {
/*  61 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71857_b() {
/*  66 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */   public void addCreativeItems(ArrayList itemList)
/*     */   {
/*  71 */     itemList.add(new ItemStack(this, 1, 0));
/*  72 */     itemList.add(new ItemStack(this, 1, 1));
/*  73 */     itemList.add(new ItemStack(this, 1, 2));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71886_c()
/*     */   {
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public void func_71921_a(World world, int x, int y, int z, EntityPlayer player)
/*     */   {
/*  86 */     TileEntityAnvil tile = (TileEntityAnvil)world.func_72796_p(x, y, z);
/*  87 */     ItemStack item = player.func_70694_bm();
/*     */     
/*  89 */     if ((item == null) || (tile == null)) {
/*  90 */       super.func_71921_a(world, x, y, z, player);
/*  91 */       return;
/*     */     }
/*  93 */     if (isHammer(item)) {
/*  94 */       useHammer(world, x, y, z, tile, player, item, 1);
/*     */     }
/*     */   }
/*     */   
/*     */   public TileEntity func_72274_a(World w)
/*     */   {
/* 100 */     return new TileEntityAnvil();
/*     */   }
/*     */   
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
/*     */   {
/* 105 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/*     */     
/* 107 */     TileEntityAnvil tile = (TileEntityAnvil)world.func_72796_p(x, y, z);
/* 108 */     tile.direction = dir;
/* 109 */     if (stack.func_82837_s()) {
/* 110 */       tile.setCustomName(stack.func_82833_r());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2)
/*     */   {
/* 119 */     TileEntityAnvil tile = (TileEntityAnvil)world.func_72796_p(x, y, z);
/*     */     
/* 121 */     if (tile != null) {
/* 122 */       for (int var6 = 0; var6 < tile.func_70302_i_(); var6++) {
/* 123 */         ItemStack var7 = tile.func_70301_a(var6);
/*     */         
/* 125 */         if (var7 != null) {
/* 126 */           float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 127 */           float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 128 */           float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 130 */           while (var7.field_77994_a > 0) {
/* 131 */             int var11 = this.rand.nextInt(21) + 10;
/*     */             
/* 133 */             if (var11 > var7.field_77994_a) {
/* 134 */               var11 = var7.field_77994_a;
/*     */             }
/*     */             
/* 137 */             var7.field_77994_a -= var11;
/* 138 */             EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(var7.field_77993_c, var11, var7.func_77960_j()));
/*     */             
/* 140 */             if (var7.func_77942_o()) {
/* 141 */               var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/* 144 */             float var13 = 0.05F;
/* 145 */             var12.field_70159_w = ((float)this.rand.nextGaussian() * var13);
/* 146 */             var12.field_70181_x = ((float)this.rand.nextGaussian() * var13 + 0.2F);
/* 147 */             var12.field_70179_y = ((float)this.rand.nextGaussian() * var13);
/* 148 */             world.func_72838_d(var12);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 154 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/* 159 */     if (meta == 0)
/*     */     {
/* 161 */       return Block.field_71978_w.func_71858_a(side, meta);
/*     */     }
/* 163 */     if (meta <= 2) {
/* 164 */       return MineFantasyBase.MFBlockStorage.func_71858_a(side, 3);
/*     */     }
/* 166 */     if (meta <= 4) {
/* 167 */       return MineFantasyBase.MFBlockStorage.func_71858_a(side, 7);
/*     */     }
/* 169 */     if (meta <= 6) {
/* 170 */       return MineFantasyBase.MFBlockStorage.func_71858_a(side, 0);
/*     */     }
/* 172 */     if (meta <= 8) {
/* 173 */       return MineFantasyBase.MFBlockStorage.func_71858_a(side, 8);
/*     */     }
/*     */     
/* 176 */     return MineFantasyBase.MFBlockStorage.func_71858_a(side, 7);
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*     */   {
/* 181 */     TileEntityAnvil tile = (TileEntityAnvil)world.func_72796_p(x, y, z);
/* 182 */     if (tile == null) {
/* 183 */       return super.func_71903_a(world, x, y, z, player, i, f, f1, f2);
/*     */     }
/*     */     
/* 186 */     if (world.field_72995_K) {
/* 187 */       int slot = tile.getSlotFor(f, f2);
/* 188 */       useInventory(world, x, y, z, tile, player, i, slot);
/*     */       
/* 190 */       Packet packet = PacketManagerMF.getPacketIntegerArray(tile, new int[] { 1, player.field_70157_k, i, slot });
/*     */       try {
/* 192 */         PacketDispatcher.sendPacketToServer(packet);
/*     */       } catch (NullPointerException e) {
/* 194 */         System.out.println("MineFantasy: Client connection lost");
/*     */       }
/*     */     }
/*     */     
/* 198 */     return true;
/*     */   }
/*     */   
/*     */   private static boolean isHammer(ItemStack itemstack) {
/* 202 */     return (itemstack != null) && (((itemstack.func_77973_b() instanceof IHammer)) || ((itemstack.func_77973_b() instanceof ItemRepairHammer)));
/*     */   }
/*     */   
/*     */   public int func_71899_b(int meta)
/*     */   {
/* 207 */     return meta;
/*     */   }
/*     */   
/*     */   private static void damageItem(EntityPlayer player, ItemStack item) {
/* 211 */     item.func_77972_a(1, player);
/*     */     
/* 213 */     if ((item.func_77960_j() >= item.func_77958_k()) && (item.field_77994_a <= 1)) {
/* 214 */       player.func_70669_a(item);
/* 215 */       player.func_71028_bD();
/*     */     }
/*     */   }
/*     */   
/*     */   private static void useHammer(World world, int x, int y, int z, TileEntityAnvil tile, EntityPlayer player, ItemStack item, int hitStr) {
/* 220 */     float pitch = 1.0F;
/* 221 */     float volume = 1.0F;
/*     */     
/* 223 */     String sound = "";
/* 224 */     if (tile.getAnvilTier() == -1) {
/* 225 */       pitch = 0.8F;
/*     */     }
/* 227 */     if (hitStr == 0) {
/* 228 */       pitch += 0.2F;
/* 229 */       volume = 0.75F;
/*     */     }
/*     */     
/* 232 */     if ((item.func_77973_b() instanceof IHammer)) {
/* 233 */       float efficiency = EnchantmentHelper.func_77509_b(player) / 2 + 1;
/* 234 */       IHammer hammer = (IHammer)item.func_77973_b();
/* 235 */       if ((EnchantmentHelper.func_77502_d(player)) && 
/* 236 */         (tile.repair(2.0F * efficiency, true, 1.0F, false))) {
/* 237 */         world.func_72908_a(x, y, z, MFResource.sound("repair"), volume, pitch);
/*     */       }
/*     */       
/*     */ 
/* 241 */       if (tile.hitWithHammer(player, hammer.getForgeLevel(), hammer.getForgeStrength() * efficiency, hitStr)) {
/* 242 */         world.func_72908_a(x, y, z, MFResource.sound("AnvilSucceed"), volume, pitch);
/*     */       } else {
/* 244 */         world.func_72908_a(x, y, z, MFResource.sound("AnvilFail"), volume, pitch);
/*     */       }
/* 246 */       damageItem(player, item);
/*     */     }
/*     */     
/* 249 */     if ((item.func_77973_b() instanceof ItemRepairHammer)) {
/* 250 */       ItemRepairHammer hammer = (ItemRepairHammer)item.func_77973_b();
/* 251 */       if (tile.repair(hammer.effectivness, hammer.canRepairEnchant, hammer.maxRepair, true)) {
/* 252 */         world.func_72908_a(x, y, z, MFResource.sound("repair"), volume, pitch);
/*     */       } else {
/* 254 */         world.func_72908_a(x, y, z, MFResource.sound("AnvilFail"), volume, pitch);
/*     */       }
/* 256 */       damageItem(player, item);
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean onUsedWithTongs(EntityPlayer player, ItemStack tongs, int slot, TileEntityAnvil tile)
/*     */   {
/* 262 */     ItemStack held = TongsHelper.getHeldItem(tongs);
/* 263 */     if (held == null) {
/* 264 */       ItemStack out = tile.func_70301_a(slot);
/* 265 */       if ((out != null) && 
/* 266 */         (TongsHelper.trySetHeldItem(tongs, out))) {
/* 267 */         tile.func_70298_a(slot, 1);
/* 268 */         return true;
/*     */       }
/*     */       
/*     */     }
/* 272 */     else if (tile.func_70301_a(slot) == null) {
/* 273 */       ItemStack place = TongsHelper.getHeldItem(tongs);
/*     */       
/* 275 */       tile.func_70299_a(slot, place);
/* 276 */       player.func_70062_b(0, TongsHelper.clearHeldItem(tongs, player));
/* 277 */       return true;
/*     */     }
/*     */     
/* 280 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean moveItems(EntityPlayer player, ItemStack heldItem, int slot, TileEntityAnvil tile) {
/* 284 */     ItemStack slotItem = tile.func_70301_a(slot);
/*     */     
/* 286 */     if ((tile.getResultSlot() != null) && 
/* 287 */       (tile.forgeTime <= 0) && (player.field_71071_by.func_70441_a(tile.getResultSlot().func_77946_l()))) {
/* 288 */       tile.func_70299_a(tile.getGridSize(), null);
/* 289 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 293 */     if (heldItem != null) {
/* 294 */       if ((!isHammer(slotItem)) && (!(heldItem.func_77973_b() instanceof ItemTongs))) {
/* 295 */         if (tile.field_70331_k.field_72995_K) {
/* 296 */           tile.gridTime = 60;
/* 297 */           return true;
/*     */         }
/* 299 */         if (slotItem == null) {
/* 300 */           ItemStack place = heldItem.func_77946_l();
/* 301 */           place.field_77994_a = 1;
/* 302 */           tile.func_70299_a(slot, place);
/*     */           
/* 304 */           heldItem.field_77994_a -= 1;
/*     */           
/* 306 */           if (heldItem.field_77994_a <= 0) {
/* 307 */             player.func_70062_b(0, null);
/*     */           }
/*     */           
/* 310 */           return true;
/*     */         }
/* 312 */         if ((slotItem.func_77969_a(heldItem)) && 
/* 313 */           (slotItem.field_77994_a < slotItem.func_77976_d())) {
/* 314 */           slotItem.field_77994_a += 1;
/*     */           
/* 316 */           heldItem.field_77994_a -= 1;
/*     */           
/* 318 */           if (heldItem.field_77994_a <= 0) {
/* 319 */             player.func_70062_b(0, null);
/*     */           }
/*     */           
/* 322 */           return true;
/*     */         }
/*     */         
/*     */       }
/*     */       
/*     */     }
/* 328 */     else if ((slotItem != null) && 
/* 329 */       (tile.forgeTime <= 0) && (player.field_71071_by.func_70441_a(slotItem.func_77946_l()))) {
/* 330 */       tile.func_70299_a(slot, null);
/* 331 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 335 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */   
/*     */   public static boolean useInventory(World world, int x, int y, int z, TileEntityAnvil tile, EntityPlayer player, int i, int slot)
/*     */   {
/* 344 */     boolean showGUI = true;
/* 345 */     ItemStack itemstack = player.func_70694_bm();
/*     */     
/* 347 */     if (i == 1) {
/* 348 */       if (isHammer(itemstack)) {
/* 349 */         useHammer(world, x, y, z, tile, player, itemstack, 0);
/* 350 */         showGUI = false;
/* 351 */       } else { if ((itemstack != null) && ((itemstack.func_77973_b() instanceof ITongs))) {
/* 352 */           ItemStack held = TongsHelper.getHeldItem(itemstack);
/* 353 */           if (held == null) {
/* 354 */             ItemStack out = tile.getResultSlot();
/* 355 */             if ((out != null) && 
/* 356 */               (TongsHelper.trySetHeldItem(itemstack, out))) {
/* 357 */               tile.func_70298_a(tile.getGridSize(), 1);
/* 358 */               tile.func_70296_d();
/* 359 */               return true;
/*     */             }
/*     */           }
/*     */           
/* 363 */           if ((slot >= 0) && (onUsedWithTongs(player, itemstack, slot, tile))) {
/* 364 */             tile.syncItems();
/* 365 */             return true;
/*     */           }
/* 367 */           return false; }
/* 368 */         if ((slot >= 0) && (moveItems(player, itemstack, slot, tile))) {
/* 369 */           tile.syncItems();
/* 370 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 374 */     if ((i != 1) && (showGUI)) {
/* 375 */       player.openGui(MineFantasyBase.instance, 0, world, x, y, z);
/*     */     }
/* 377 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockAnvilMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */