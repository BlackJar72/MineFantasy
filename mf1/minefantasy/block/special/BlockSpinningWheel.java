/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.common.network.PacketDispatcher;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Random;
/*     */ import minefantasy.client.tile.TileEntitySpinningWheel;
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
/*     */ public class BlockSpinningWheel
/*     */   extends BlockContainer
/*     */ {
/*  36 */   private Random rand = new Random();
/*     */   
/*     */   public BlockSpinningWheel(int id) {
/*  39 */     super(id, Material.field_76245_d);
/*  40 */     func_71849_a(ItemListMF.tabTailor);
/*     */   }
/*     */   
/*     */   public TileEntity func_72274_a(World world)
/*     */   {
/*  45 */     return new TileEntitySpinningWheel();
/*     */   }
/*     */   
/*     */   public void func_71860_a(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
/*     */   {
/*  50 */     int dir = MathHelper.func_76128_c(entity.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/*     */     
/*  52 */     TileEntitySpinningWheel tile = (TileEntitySpinningWheel)world.func_72796_p(x, y, z);
/*  53 */     tile.direction = dir;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2)
/*     */   {
/*  61 */     TileEntitySpinningWheel tile = (TileEntitySpinningWheel)world.func_72796_p(x, y, z);
/*     */     
/*  63 */     if (tile != null) {
/*  64 */       for (int var6 = 0; var6 < tile.func_70302_i_(); var6++) {
/*  65 */         ItemStack var7 = tile.func_70301_a(var6);
/*     */         
/*  67 */         if (var7 != null) {
/*  68 */           float var8 = this.rand.nextFloat() * 0.8F + 0.1F;
/*  69 */           float var9 = this.rand.nextFloat() * 0.8F + 0.1F;
/*  70 */           float var10 = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */           
/*  72 */           while (var7.field_77994_a > 0) {
/*  73 */             int var11 = this.rand.nextInt(21) + 10;
/*     */             
/*  75 */             if (var11 > var7.field_77994_a) {
/*  76 */               var11 = var7.field_77994_a;
/*     */             }
/*     */             
/*  79 */             var7.field_77994_a -= var11;
/*  80 */             EntityItem var12 = new EntityItem(world, x + var8, y + var9, z + var10, new ItemStack(var7.field_77993_c, var11, var7.func_77960_j()));
/*     */             
/*  82 */             if (var7.func_77942_o()) {
/*  83 */               var12.func_92059_d().func_77982_d((NBTTagCompound)var7.func_77978_p().func_74737_b());
/*     */             }
/*     */             
/*  86 */             float var13 = 0.05F;
/*  87 */             var12.field_70159_w = ((float)this.rand.nextGaussian() * var13);
/*  88 */             var12.field_70181_x = ((float)this.rand.nextGaussian() * var13 + 0.2F);
/*  89 */             var12.field_70179_y = ((float)this.rand.nextGaussian() * var13);
/*  90 */             world.func_72838_d(var12);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  96 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/* 101 */     return Block.field_71988_x.func_71858_a(side, meta);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d()
/*     */   {
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71857_b()
/*     */   {
/* 112 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean func_71886_c()
/*     */   {
/* 121 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*     */   {
/* 126 */     TileEntitySpinningWheel tile = (TileEntitySpinningWheel)world.func_72796_p(x, y, z);
/* 127 */     if (tile == null) {
/* 128 */       return super.func_71903_a(world, x, y, z, player, i, f, f1, f2);
/*     */     }
/* 130 */     if (world.field_72995_K) {
/* 131 */       int slot = tile.getSlotFor(f, f2);
/* 132 */       useInventory(world, x, y, z, tile, player, i, slot);
/*     */       
/* 134 */       Packet packet = PacketManagerMF.getPacketIntegerArray(tile, new int[] { 1, player.field_70157_k, i, slot });
/*     */       try {
/* 136 */         PacketDispatcher.sendPacketToServer(packet);
/*     */       } catch (NullPointerException e) {
/* 138 */         System.out.println("MineFantasy: Client connection lost");
/*     */       }
/*     */     }
/* 141 */     ItemStack held = player.func_70694_bm();
/* 142 */     if ((held != null) && (held.field_77993_c == Block.field_72101_ab.field_71990_ca)) {
/* 143 */       return true;
/*     */     }
/* 145 */     return super.func_71903_a(world, x, y, z, player, i, f, f1, f2);
/*     */   }
/*     */   
/*     */   private static boolean tryPlaceItem(int slot, TileEntitySpinningWheel tile, EntityPlayer player) {
/* 149 */     boolean completeStack = true;
/* 150 */     ItemStack heldItem = player.func_70694_bm();
/* 151 */     ItemStack slotItem = tile.func_70301_a(slot);
/*     */     
/* 153 */     if ((slot == 2) && (tile.getResultSlot() != null) && 
/* 154 */       (player.field_71071_by.func_70441_a(tile.getResultSlot().func_77946_l()))) {
/* 155 */       tile.func_70299_a(2, null);
/* 156 */       return true;
/*     */     }
/*     */     
/* 159 */     if (slot == 2) {
/* 160 */       return false;
/*     */     }
/* 162 */     if ((heldItem != null) && (tile.func_94041_b(slot, heldItem))) {
/* 163 */       if (slotItem == null) {
/* 164 */         ItemStack place = heldItem.func_77946_l();
/* 165 */         if (!completeStack) {
/* 166 */           place.field_77994_a = 1;
/*     */         }
/* 168 */         tile.func_70299_a(slot, place);
/*     */         
/* 170 */         if (!completeStack) {
/* 171 */           heldItem.field_77994_a -= 1;
/*     */         } else {
/* 173 */           heldItem.field_77994_a = 0;
/*     */         }
/*     */         
/* 176 */         if (heldItem.field_77994_a <= 0) {
/* 177 */           player.func_70062_b(0, null);
/*     */         }
/* 179 */         return true;
/*     */       }
/* 181 */       if (slotItem.func_77969_a(heldItem)) {
/* 182 */         int transfer = 1;
/* 183 */         if (completeStack) {
/* 184 */           if (slotItem.field_77994_a + heldItem.field_77994_a <= slotItem.func_77976_d()) {
/* 185 */             transfer = heldItem.field_77994_a;
/*     */           } else {
/* 187 */             transfer = slotItem.func_77976_d() - slotItem.field_77994_a;
/*     */           }
/*     */         }
/* 190 */         if (slotItem.field_77994_a + transfer <= slotItem.func_77976_d()) {
/* 191 */           slotItem.field_77994_a += transfer;
/*     */           
/* 193 */           heldItem.field_77994_a -= transfer;
/*     */           
/* 195 */           if (heldItem.field_77994_a <= 0) {
/* 196 */             player.func_70062_b(0, null);
/*     */           }
/*     */           
/* 199 */           return true;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/* 204 */     else if ((slotItem != null) && 
/* 205 */       (player.field_71071_by.func_70441_a(slotItem.func_77946_l()))) {
/* 206 */       tile.func_70299_a(slot, null);
/* 207 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 211 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */   
/*     */   public static boolean useInventory(World world, int x, int y, int z, TileEntitySpinningWheel tile, EntityPlayer player, int i, int slot)
/*     */   {
/* 220 */     if (tile.func_70300_a(player)) {
/* 221 */       if ((i == 1) && (slot >= 0)) {
/* 222 */         if (tryPlaceItem(slot, tile, player)) {
/* 223 */           tile.func_70296_d();
/* 224 */           return true;
/*     */         }
/*     */       } else {
/* 227 */         return tile.use(player);
/*     */       }
/*     */     }
/*     */     
/* 231 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockSpinningWheel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */