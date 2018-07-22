/*     */ package minefantasy.block.special;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.forge.ILighter;
/*     */ import minefantasy.client.tile.TileEntityFirepit;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemFlintAndSteel;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockFirepit
/*     */   extends BlockContainer
/*     */ {
/*  35 */   private Random rand = new Random();
/*     */   
/*     */   public BlockFirepit(int id) {
/*  38 */     super(id, Material.field_76245_d);
/*  39 */     func_71905_a(0.2F, 0.0F, 0.2F, 0.8F, 0.5F, 0.8F);
/*  40 */     func_71849_a(ItemListMF.tabCook);
/*     */   }
/*     */   
/*     */   public int func_71885_a(int id, Random rand, int meta) {
/*  44 */     return 0;
/*     */   }
/*     */   
/*     */   public void func_71921_a(World world, int x, int y, int z, EntityPlayer player)
/*     */   {
/*  49 */     if (world.field_72995_K) {
/*  50 */       return;
/*     */     }
/*     */     
/*  53 */     TileEntityFirepit firepit = (TileEntityFirepit)world.func_72796_p(x, y, z);
/*  54 */     if ((firepit != null) && (player.func_70694_bm() != null) && 
/*  55 */       (firepit.isBurning()) && (player.func_70694_bm().func_77973_b() == Item.field_77669_D)) {
/*  56 */       player.func_70694_bm().field_77993_c = Block.field_72069_aq.field_71990_ca;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_71903_a(World world, int x, int y, int z, EntityPlayer player, int i, float f, float f1, float f2)
/*     */   {
/*  62 */     if (world.field_72995_K) {
/*  63 */       return false;
/*     */     }
/*  65 */     TileEntityFirepit firepit = (TileEntityFirepit)world.func_72796_p(x, y, z);
/*     */     
/*  67 */     if (firepit != null) {
/*  68 */       ItemStack held = player.func_70694_bm();
/*  69 */       boolean burning = firepit.isBurning();
/*     */       
/*  71 */       if (held != null) {
/*  72 */         if (burning) {
/*  73 */           if (held.field_77993_c == Block.field_71939_E.field_71990_ca) {
/*  74 */             firepit.extinguish();
/*  75 */             return true;
/*     */           }
/*  77 */           if (held.func_77973_b() == Item.field_77669_D) {
/*  78 */             held.field_77993_c = Block.field_72069_aq.field_71990_ca;
/*  79 */             return true;
/*     */           }
/*  81 */         } else if (firepit.fuel > 0) {
/*  82 */           if ((held.func_77973_b() instanceof ILighter)) {
/*  83 */             world.func_72908_a(x + 0.5D, y - 0.5D, z + 0.5D, "fire.ignite", 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
/*  84 */             world.func_72869_a("flame", x + 0.5D, y - 0.5D, z + 0.5D, 0.0D, 0.0D, 0.0D);
/*     */             
/*  86 */             ILighter lighter = (ILighter)held.func_77973_b();
/*  87 */             if (lighter.canLight()) {
/*  88 */               if ((this.rand.nextDouble() < lighter.getChance()) && 
/*  89 */                 (!world.field_72995_K)) {
/*  90 */                 firepit.setLit(true);
/*  91 */                 held.func_77972_a(1, player);
/*     */               }
/*     */               
/*  94 */               return true;
/*     */             }
/*     */           }
/*  97 */           if ((held.func_77973_b() instanceof ItemFlintAndSteel)) {
/*  98 */             world.func_72908_a(x + 0.5D, y - 0.5D, z + 0.5D, "fire.ignite", 1.0F, this.rand.nextFloat() * 0.4F + 0.8F);
/*  99 */             world.func_72869_a("flame", x + 0.5D, y - 0.5D, z + 0.5D, 0.0D, 0.0D, 0.0D);
/*     */             
/* 101 */             if (!world.field_72995_K) {
/* 102 */               firepit.setLit(true);
/* 103 */               held.func_77972_a(1, player);
/*     */             }
/* 105 */             return true;
/*     */           }
/*     */         }
/* 108 */         if ((firepit.addFuel(held)) && (!player.field_71075_bZ.field_75098_d)) {
/* 109 */           if (held.field_77994_a == 1) {
/* 110 */             if (held.func_77973_b().func_77634_r()) {
/* 111 */               player.func_70062_b(0, held.func_77973_b().getContainerItemStack(held));
/*     */             } else {
/* 113 */               player.func_70062_b(0, null);
/*     */             }
/*     */           } else {
/* 116 */             held.field_77994_a -= 1;
/* 117 */             if ((held.func_77973_b().func_77634_r()) && 
/* 118 */               (!player.field_71071_by.func_70441_a(held.func_77973_b().getContainerItemStack(held)))) {
/* 119 */               player.func_71021_b(held.func_77973_b().getContainerItemStack(held));
/*     */             }
/*     */           }
/*     */           
/* 123 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 127 */     return super.func_71903_a(world, x, y, z, player, i, f, f1, f2);
/*     */   }
/*     */   
/*     */   public TileEntity func_72274_a(World world)
/*     */   {
/* 132 */     return new TileEntityFirepit();
/*     */   }
/*     */   
/*     */   public Icon func_71858_a(int side, int meta)
/*     */   {
/* 137 */     return Block.field_71988_x.func_71858_a(side, 0);
/*     */   }
/*     */   
/*     */   public boolean func_71926_d() {
/* 141 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_71857_b() {
/* 146 */     return cfg.renderId;
/*     */   }
/*     */   
/*     */   public boolean func_71886_c() {
/* 150 */     return false;
/*     */   }
/*     */   
/*     */   public int getLightValue(IBlockAccess world, int x, int y, int z)
/*     */   {
/* 155 */     if (world.func_72805_g(x, y, z) == 1) {
/* 156 */       return 15;
/*     */     }
/* 158 */     return super.getLightValue(world, x, y, z);
/*     */   }
/*     */   
/*     */   public void func_71869_a(World world, int x, int y, int z, Entity entity)
/*     */   {
/* 163 */     if (world.field_72995_K) {
/* 164 */       return;
/*     */     }
/* 166 */     TileEntityFirepit tile = (TileEntityFirepit)world.func_72796_p(x, y, z);
/* 167 */     if ((entity == null) || (tile == null)) {
/* 168 */       return;
/*     */     }
/* 170 */     if ((entity instanceof EntityItem)) {
/* 171 */       EntityItem entIt = (EntityItem)entity;
/* 172 */       if (entIt.func_92059_d() != null) {
/* 173 */         for (int a = 0; a < entIt.func_92059_d().field_77994_a; a++) {
/* 174 */           if (tile.addFuel(entIt.func_92059_d())) {
/* 175 */             entIt.func_92059_d().field_77994_a -= 1;
/*     */           }
/* 177 */           if (entIt.func_92059_d().field_77994_a <= 0) {
/* 178 */             entIt.func_70106_y();
/*     */           }
/*     */         }
/*     */       }
/* 182 */       if ((tile.isBurning()) && (entity.field_70173_aa % 25 == 0)) {
/* 183 */         entity.field_70181_x = 0.20000000298023224D;
/* 184 */         entity.func_85030_a("random.fizz", 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
/*     */       }
/*     */     }
/* 187 */     else if (tile.isBurning()) {
/* 188 */       entity.func_70097_a(DamageSource.field_76372_a, 1.0F);
/*     */     }
/* 190 */     if (tile.isBurning()) {
/* 191 */       entity.func_70015_d(2);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_71852_a(World world, int x, int y, int z, int i1, int i2) {
/* 196 */     TileEntityFirepit tile = (TileEntityFirepit)world.func_72796_p(x, y, z);
/* 197 */     if (tile != null) {
/* 198 */       int charcoal = tile.getCharcoalDrop();
/*     */       
/* 200 */       if (charcoal > 0) {
/* 201 */         float xDrop = this.rand.nextFloat() * 0.8F + 0.1F;
/* 202 */         float yDrop = this.rand.nextFloat() * 0.8F + 0.1F;
/* 203 */         float zDrop = this.rand.nextFloat() * 0.8F + 0.1F;
/*     */         
/* 205 */         for (int c = 0; c < charcoal; c++) {
/* 206 */           EntityItem drop = new EntityItem(world, x + xDrop, y + yDrop, z + zDrop, new ItemStack(Item.field_77705_m, 1, 1));
/*     */           
/* 208 */           float jumpFactor = 0.05F;
/* 209 */           drop.field_70159_w = ((float)this.rand.nextGaussian() * jumpFactor);
/* 210 */           drop.field_70181_x = ((float)this.rand.nextGaussian() * jumpFactor + 0.2F);
/* 211 */           drop.field_70179_y = ((float)this.rand.nextGaussian() * jumpFactor);
/* 212 */           world.func_72838_d(drop);
/*     */         }
/*     */       }
/*     */     }
/* 216 */     super.func_71852_a(world, x, y, z, i1, i2);
/*     */   }
/*     */   
/*     */   public void func_94332_a(IconRegister reg) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/block/special/BlockFirepit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */