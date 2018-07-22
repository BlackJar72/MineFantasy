/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.common.network.PacketDispatcher;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.tailor.INeedle;
/*     */ import minefantasy.client.tile.TileEntityTailor;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.cfg;
/*     */ import minefantasy.system.network.PacketManagerMF;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockTailor
/*     */   extends BlockContainer
/*     */ {
/*  50 */   private Random rand = new Random();
/*     */   
/*     */   public BlockTailor(int i, Material m) {
/*  53 */     super(i, m);
/*  54 */     func_71849_a(ItemListMF.tabTailor);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d() {
/*  58 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71857_b() {
/*  63 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71886_c()
/*     */   {
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public void func_71921_a(World world, int x, int y, int z, EntityPlayer player)
/*     */   {
/*  76 */     TileEntityTailor tile = (TileEntityTailor)world.func_72796_p(x, y, z);
/*     */     
/*  78 */     if (tile != null) {
/*  79 */       tile.onUse(player);
/*     */     }
/*     */   }
/*     */   
/*     */   public TileEntity func_72274_a(World w)
/*     */   {
/*  85 */     return new TileEntityTailor();
/*     */   }
/*     */   
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
/*     */   {
/*  90 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/*     */     
/*  92 */     TileEntityTailor tile = (TileEntityTailor)world.func_72796_p(x, y, z);
/*  93 */     tile.direction = dir;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2)
/*     */   {
/* 100 */     TileEntityTailor tile = (TileEntityTailor)world.func_72796_p(x, y, z);
/*     */     
/* 102 */     if (tile != null) {
/* 103 */       for (int var6 = 0; var6 < tile.func_70302_i_(); var6++) {
/* 104 */         ItemStack var7 = tile.func_70301_a(var6);
/*     */         
/* 106 */         if (var7 != null) {
/* 107 */           float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 108 */           float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
/* 109 */           float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */           
/* 111 */           while (var7.field_77994_a > 0) {
/* 112 */             int var11 = this.rand.nextInt(21) + 10;
/*     */             
/* 114 */             if (var11 > var7.field_77994_a) {
/* 115 */               var11 = var7.field_77994_a;
/*     */             }
/*     */             
/* 118 */             var7.field_77994_a -= var11;
/* 119 */             EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(var7.field_77993_c, var11, var7.func_77960_j()));
/*     */             
/* 121 */             if (var7.func_77942_o()) {
/* 122 */               var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/* 125 */             float var13 = 0.05F;
/* 126 */             var12.field_70159_w = ((float)this.rand.nextGaussian() * var13);
/* 127 */             var12.field_70181_x = ((float)this.rand.nextGaussian() * var13 + 0.2F);
/* 128 */             var12.field_70179_y = ((float)this.rand.nextGaussian() * var13);
/* 129 */             world.func_72838_d(var12);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 135 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/* 140 */     return Block.field_71988_x.func_71858_a(side, meta);
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*     */   {
/* 145 */     TileEntityTailor tile = (TileEntityTailor)world.func_72796_p(x, y, z);
/* 146 */     if (tile == null) {
/* 147 */       return super.func_71903_a(world, x, y, z, player, i, f, f1, f2);
/*     */     }
/* 149 */     if (world.field_72995_K) {
/* 150 */       int slot = tile.getSlotFor(f, f2);
/* 151 */       useInventory(world, x, y, z, tile, player, i, slot);
/*     */       
/* 153 */       Packet packet = PacketManagerMF.getPacketIntegerArray(tile, new int[] { 1, player.field_70157_k, i, slot });
/*     */       try {
/* 155 */         PacketDispatcher.sendPacketToServer(packet);
/*     */       } catch (NullPointerException e) {
/* 157 */         System.out.println("MineFantasy: Client connection lost");
/*     */       }
/*     */     }
/*     */     
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   public int func_71899_b(int meta)
/*     */   {
/* 166 */     return meta;
/*     */   }
/*     */   
/*     */   private void damageItem(EntityPlayer player, ItemStack item) {
/* 170 */     item.func_77972_a(1, player);
/*     */     
/* 172 */     if ((item.func_77960_j() >= item.func_77958_k()) && (item.field_77994_a <= 1)) {
/* 173 */       player.func_70669_a(item);
/* 174 */       player.func_71028_bD();
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean tryPlaceItem(int slot, TileEntityTailor tile, EntityPlayer player) {
/* 179 */     boolean completeStack = (slot < 4) || (player.func_70093_af());
/* 180 */     ItemStack heldItem = player.func_70694_bm();
/* 181 */     ItemStack slotItem = tile.func_70301_a(slot);
/*     */     
/* 183 */     if ((heldItem != null) && ((heldItem.func_77973_b() instanceof INeedle))) {
/* 184 */       return false;
/*     */     }
/*     */     
/* 187 */     if ((tile.getResultSlot() != null) && 
/* 188 */       (player.field_71071_by.func_70441_a(tile.getResultSlot().func_77946_l()))) {
/* 189 */       tile.func_70299_a(tile.func_70302_i_() - 1, null);
/* 190 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 194 */     if (heldItem != null) {
/* 195 */       if (slotItem == null) {
/* 196 */         ItemStack place = heldItem.func_77946_l();
/* 197 */         if (!completeStack) {
/* 198 */           place.field_77994_a = 1;
/*     */         }
/* 200 */         tile.func_70299_a(slot, place);
/*     */         
/* 202 */         if (!completeStack) {
/* 203 */           heldItem.field_77994_a -= 1;
/*     */         } else {
/* 205 */           heldItem.field_77994_a = 0;
/*     */         }
/*     */         
/* 208 */         if (heldItem.field_77994_a <= 0) {
/* 209 */           player.func_70062_b(0, null);
/*     */         }
/* 211 */         return true;
/*     */       }
/* 213 */       if (slotItem.func_77969_a(heldItem)) {
/* 214 */         int transfer = 1;
/* 215 */         if (completeStack) {
/* 216 */           if (slotItem.field_77994_a + heldItem.field_77994_a <= slotItem.func_77976_d()) {
/* 217 */             transfer = heldItem.field_77994_a;
/*     */           } else {
/* 219 */             transfer = slotItem.func_77976_d() - slotItem.field_77994_a;
/*     */           }
/*     */         }
/* 222 */         if (slotItem.field_77994_a + transfer <= slotItem.func_77976_d()) {
/* 223 */           slotItem.field_77994_a += transfer;
/*     */           
/* 225 */           heldItem.field_77994_a -= transfer;
/*     */           
/* 227 */           if (heldItem.field_77994_a <= 0) {
/* 228 */             player.func_70062_b(0, null);
/*     */           }
/*     */           
/* 231 */           return true;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/* 236 */     else if ((slotItem != null) && 
/* 237 */       (player.field_71071_by.func_70441_a(slotItem.func_77946_l()))) {
/* 238 */       tile.func_70299_a(slot, null);
/* 239 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 243 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */   
/*     */   public static boolean useInventory(World world, int x, int y, int z, TileEntityTailor tile, EntityPlayer player, int i, int slot)
/*     */   {
/* 252 */     if (tile.onUse(player)) {
/* 253 */       return true;
/*     */     }
/*     */     
/* 256 */     if ((slot >= 0) && (i == 1) && 
/* 257 */       (tryPlaceItem(slot, tile, player))) {
/* 258 */       tile.func_70296_d();
/* 259 */       return true;
/*     */     }
/*     */     
/* 262 */     if (i != 1) {
/* 263 */       player.openGui(MineFantasyBase.instance, 3, world, x, y, z);
/*     */     }
/* 265 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockTailor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */