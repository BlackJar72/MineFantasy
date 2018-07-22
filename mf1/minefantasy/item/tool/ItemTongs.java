/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.Color;
/*     */ import java.util.List;
/*     */ import minefantasy.api.anvil.ITongs;
/*     */ import minefantasy.api.forge.TongsHelper;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockCauldron;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumMovingObjectType;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.MovingObjectPosition;
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
/*     */ public class ItemTongs
/*     */   extends Item
/*     */   implements ITongs, IWeaponSpecial
/*     */ {
/*     */   private EnumToolMaterial material;
/*     */   
/*     */   public ItemTongs(int id, EnumToolMaterial mat)
/*     */   {
/*  45 */     super(id);
/*  46 */     this.material = mat;
/*  47 */     func_77664_n();
/*  48 */     func_77656_e(mat.func_77997_a());
/*  49 */     func_77625_d(1);
/*  50 */     func_77637_a(ItemListMF.tabTool);
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack stack, EntityPlayer player, List list, boolean fullInfo)
/*     */   {
/*  55 */     super.func_77624_a(stack, player, list, fullInfo);
/*     */     
/*  57 */     ItemStack held = TongsHelper.getHeldItem(stack);
/*  58 */     if (held != null) {
/*  59 */       list.add("");
/*  60 */       list.add(held.func_77973_b().func_77628_j(held));
/*  61 */       held.func_77973_b().func_77624_a(held, player, list, fullInfo);
/*     */     }
/*     */   }
/*     */   
/*     */   public Icon getIcon(ItemStack stack, int renderPass) {
/*  66 */     ItemStack item = TongsHelper.getHeldItem(stack);
/*     */     
/*  68 */     if ((renderPass == 0) && (item != null)) {
/*  69 */       return item.func_77973_b().getIcon(item, renderPass);
/*     */     }
/*  71 */     return this.field_77791_bV;
/*     */   }
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player) {
/*  75 */     MovingObjectPosition movingobjectposition = func_77621_a(world, player, true);
/*     */     
/*  77 */     if (movingobjectposition == null) {
/*  78 */       return item;
/*     */     }
/*  80 */     if (movingobjectposition.field_72313_a == EnumMovingObjectType.TILE) {
/*  81 */       int i = movingobjectposition.field_72311_b;
/*  82 */       int j = movingobjectposition.field_72312_c;
/*  83 */       int k = movingobjectposition.field_72309_d;
/*     */       
/*  85 */       if (!world.func_72962_a(player, i, j, k)) {
/*  86 */         return item;
/*     */       }
/*     */       
/*  89 */       if (!player.func_82247_a(i, j, k, movingobjectposition.field_72310_e, item)) {
/*  90 */         return item;
/*     */       }
/*     */       
/*  93 */       if ((isWaterSource(world, i, j, k)) && (TongsHelper.getHeldItem(item) != null)) {
/*  94 */         ItemStack drop = TongsHelper.getHeldItem(item).func_77946_l();
/*  95 */         if (TongsHelper.isCoolableItem(drop)) {
/*  96 */           drop = TongsHelper.getHotItem(drop);
/*     */           
/*  98 */           player.func_85030_a("random.splash", 1.0F, 1.0F);
/*  99 */           player.func_85030_a("random.fizz", 2.0F, 0.5F);
/*     */           
/* 101 */           for (int a = 0; a < 5; a++) {
/* 102 */             world.func_72869_a("largesmoke", i + 0.5F, j + 1, k + 0.5F, 0.0D, 0.06499999761581421D, 0.0D);
/*     */           }
/*     */         }
/* 105 */         drop.field_77994_a = item.field_77994_a;
/* 106 */         if (drop != null) {
/* 107 */           player.func_71021_b(drop);
/*     */         }
/*     */         
/* 110 */         return TongsHelper.clearHeldItem(item, player);
/*     */       }
/*     */     }
/*     */     
/* 114 */     return item;
/*     */   }
/*     */   
/*     */   private boolean isWaterSource(World world, int i, int j, int k)
/*     */   {
/* 119 */     if (world.func_72803_f(i, j, k) == Material.field_76244_g) {
/* 120 */       return true;
/*     */     }
/* 122 */     if (isCauldron(world, i, j, k)) {
/* 123 */       return true;
/*     */     }
/* 125 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isCauldron(World world, int x, int y, int z) {
/* 129 */     return (world.func_72798_a(x, y, z) == Block.field_72108_bG.field_71990_ca) && (world.func_72805_g(x, y, z) > 0);
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/* 134 */     func_111206_d("minefantasy:Tool/" + name);
/* 135 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   public int func_82790_a(ItemStack item, int renderPass)
/*     */   {
/* 145 */     if (renderPass == 1) {
/* 146 */       return Color.WHITE.getRGB();
/*     */     }
/*     */     
/* 149 */     ItemStack held = TongsHelper.getHeldItem(item);
/* 150 */     if (held != null) {
/* 151 */       return held.func_77973_b().func_82790_a(held, 0);
/*     */     }
/*     */     
/* 154 */     return Color.WHITE.getRGB();
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/* 159 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 160 */       return rarity(itemStack, 1);
/*     */     }
/* 162 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 163 */       return rarity(itemStack, 2);
/*     */     }
/* 165 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial() {
/* 169 */     return this.material;
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/* 173 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/* 174 */     if (item.func_77948_v()) {
/* 175 */       if (lvl == 0) {
/* 176 */         lvl++;
/*     */       }
/* 178 */       lvl++;
/*     */     }
/* 180 */     if (lvl >= rarity.length) {
/* 181 */       lvl = rarity.length - 1;
/*     */     }
/* 183 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 188 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 189 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 192 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 193 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemTongs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */