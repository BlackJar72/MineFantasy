/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.leatherwork.EnumToolType;
/*     */ import minefantasy.api.leatherwork.ITanningItem;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockLeaves;
/*     */ import net.minecraft.block.BlockRedstoneWire;
/*     */ import net.minecraft.block.BlockTallGrass;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemShears;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.IShearable;
/*     */ 
/*     */ public class ItemShearsMF extends ItemShears implements ITanningItem, IWeaponSpecial
/*     */ {
/*     */   private EnumToolMaterial material;
/*     */   private float quality;
/*     */   
/*     */   public ItemShearsMF(int id, EnumToolMaterial material)
/*     */   {
/*  34 */     super(id);
/*  35 */     func_77664_n();
/*  36 */     func_77656_e(material.func_77997_a());
/*  37 */     this.quality = material.func_77998_b();
/*  38 */     this.material = material;
/*  39 */     func_77637_a(ItemListMF.tabTool);
/*     */   }
/*     */   
/*     */   public float getQuality()
/*     */   {
/*  44 */     return this.quality;
/*     */   }
/*     */   
/*     */   public EnumToolType getType()
/*     */   {
/*  49 */     return EnumToolType.CUTTER;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/*  54 */     func_111206_d("minefantasy:Tool/" + name);
/*  55 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*     */   
/*     */ 
/*     */   public boolean func_77660_a(ItemStack item, World world, int id, int y, int z, int s, EntityLivingBase user)
/*     */   {
/*  64 */     Random rand = new Random();
/*  65 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/*  66 */       ((user instanceof EntityPlayer))) {
/*  67 */       ((EntityPlayer)user).func_71024_bL().func_75122_a(1, 0.2F);
/*     */     }
/*     */     
/*     */ 
/*  71 */     if ((id != Block.field_71952_K.field_71990_ca) && (id != Block.field_71955_W.field_71990_ca) && (id != Block.field_71962_X.field_71990_ca) && (id != Block.field_71998_bu.field_71990_ca) && (id != Block.field_72062_bU.field_71990_ca) && (!(Block.field_71973_m[id] instanceof IShearable))) {
/*  72 */       return super.func_77660_a(item, world, id, y, z, s, user);
/*     */     }
/*  74 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_77641_a(Block block)
/*     */   {
/*  80 */     return (block.field_72018_cp == Material.field_76257_i) || (block.field_71990_ca == Block.field_71955_W.field_71990_ca) || (block.field_71990_ca == Block.field_72075_av.field_71990_ca) || (block.field_71990_ca == Block.field_72062_bU.field_71990_ca);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getStrVsBlock(ItemStack item, Block block, int meta)
/*     */   {
/*  89 */     if ((block.field_72018_cp == Material.field_76257_i) || ((block instanceof IShearable)) || (Item.field_77745_be.func_77638_a(item, block) > super.getStrVsBlock(item, block, meta))) {
/*  90 */       if (block.field_72018_cp == Material.field_76253_m) {
/*  91 */         return 5.0F;
/*     */       }
/*  93 */       return 15.0F;
/*     */     }
/*  95 */     return super.getStrVsBlock(item, block, meta);
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/* 100 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 101 */       return rarity(itemStack, 1);
/*     */     }
/* 103 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 104 */       return rarity(itemStack, 2);
/*     */     }
/* 106 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial() {
/* 110 */     return this.material;
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/* 114 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/* 115 */     if (item.func_77948_v()) {
/* 116 */       if (lvl == 0) {
/* 117 */         lvl++;
/*     */       }
/* 119 */       lvl++;
/*     */     }
/* 121 */     if (lvl >= rarity.length) {
/* 122 */       lvl = rarity.length - 1;
/*     */     }
/* 124 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 129 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 130 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 133 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 134 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemShearsMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */