/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.anvil.ICustomRepair;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.client.tile.TileEntityRoad;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.IPublicMaterialItem;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockGrass;
/*     */ import net.minecraft.block.StepSound;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import net.minecraftforge.common.MinecraftForge;
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
/*     */ public class ItemMattock
/*     */   extends ItemToolMF
/*     */   implements IPublicMaterialItem, IWeaponSpecial, ICustomRepair
/*     */ {
/*     */   private EnumToolMaterial toolMaterial;
/*  45 */   public float efficiencyOnProperMaterial = 2.0F;
/*     */   
/*     */   public ItemMattock(int id, EnumToolMaterial material) {
/*  48 */     super(id);
/*  49 */     this.toolMaterial = material;
/*  50 */     func_77656_e(material.func_77997_a() * 2);
/*  51 */     this.efficiencyOnProperMaterial = (material.func_77998_b() * 0.5F);
/*  52 */     MinecraftForge.setToolClass(this, "pickaxe", material.func_77996_d());
/*     */   }
/*     */   
/*     */   public boolean func_77648_a(ItemStack hoe, EntityPlayer player, World world, int x, int y, int z, int facing, float pitch, float yaw, float pan)
/*     */   {
/*  57 */     if (!player.func_82247_a(x, y, z, facing, hoe)) {
/*  58 */       return false;
/*     */     }
/*  60 */     int var11 = world.func_72798_a(x, y, z);
/*  61 */     int var11m = world.func_72805_g(x, y, z);
/*  62 */     int var12 = world.func_72798_a(x, y + 1, z);
/*     */     
/*  64 */     if ((facing == 0) || (var12 != 0))
/*  65 */       return false;
/*  66 */     if ((var11 == Block.field_71980_u.field_71990_ca) || (var11 == Block.field_71979_v.field_71990_ca) || (var11 == Block.field_71939_E.field_71990_ca)) {
/*  67 */       Block var13 = MineFantasyBase.MFBlockRoad;
/*  68 */       int m = 0;
/*     */       
/*  70 */       if (var11 == Block.field_71939_E.field_71990_ca) {
/*  71 */         m = 1;
/*     */       }
/*  73 */       if (var11 == Block.field_71980_u.field_71990_ca) {
/*  74 */         var11 = Block.field_71979_v.field_71990_ca;
/*     */       }
/*  76 */       world.func_72908_a(x + 0.5F, y + 0.5F, z + 0.5F, var13.field_72020_cn.func_72675_d(), (var13.field_72020_cn.func_72677_b() + 1.0F) / 2.0F, var13.field_72020_cn.func_72678_c() * 0.8F);
/*     */       
/*  78 */       if (world.field_72995_K) {
/*  79 */         return true;
/*     */       }
/*  81 */       world.func_72832_d(x, y, z, var13.field_71990_ca, m, 2);
/*     */       
/*  83 */       TileEntityRoad road = new TileEntityRoad();
/*  84 */       road.func_70308_a(world);
/*  85 */       world.func_72837_a(x, y, z, road);
/*  86 */       road.setSurface(var11, var11m);
/*  87 */       hoe.func_77972_a(1, player);
/*  88 */       return true;
/*     */     }
/*     */     
/*  91 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_77644_a(ItemStack item, EntityLivingBase target, EntityLivingBase entityHolder)
/*     */   {
/*  98 */     item.func_77972_a(4, entityHolder);
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_77660_a(ItemStack item, World world, int id, int x, int y, int z, EntityLivingBase user)
/*     */   {
/* 104 */     Random rand = new Random();
/* 105 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/* 106 */       ((user instanceof EntityPlayer))) {
/* 107 */       ((EntityPlayer)user).func_71024_bL().func_75122_a(1, 0.2F);
/*     */     }
/*     */     
/* 110 */     item.func_77972_a(1, user);
/* 111 */     return super.func_77660_a(item, world, id, x, y, z, user);
/*     */   }
/*     */   
/*     */   public boolean canHarvestBlock(Block block, ItemStack stack)
/*     */   {
/* 116 */     return (ForgeHooks.canToolHarvestBlock(block, 0, stack)) || (Item.field_77695_f.canHarvestBlock(block, stack));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getStrVsBlock(ItemStack item, Block block, int metadata)
/*     */   {
/* 125 */     if (canHarvestBlock(block, item)) {
/* 126 */       return this.efficiencyOnProperMaterial;
/*     */     }
/* 128 */     return super.getStrVsBlock(item, block, metadata);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_77619_b()
/*     */   {
/* 136 */     return this.toolMaterial.func_77995_e();
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial() {
/* 140 */     return this.toolMaterial;
/*     */   }
/*     */   
/*     */   public float getRepairValue()
/*     */   {
/* 145 */     return 2.0F;
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/* 150 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 151 */       return rarity(itemStack, 1);
/*     */     }
/* 153 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 154 */       return rarity(itemStack, 2);
/*     */     }
/* 156 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/* 160 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/* 161 */     if (item.func_77948_v()) {
/* 162 */       if (lvl == 0) {
/* 163 */         lvl++;
/*     */       }
/* 165 */       lvl++;
/*     */     }
/* 167 */     if (lvl >= rarity.length) {
/* 168 */       lvl = rarity.length - 1;
/*     */     }
/* 170 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 175 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 176 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 179 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 180 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemMattock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */