/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.IPublicMaterialItem;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemSpade;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.world.World;
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
/*     */ public class ItemMedievalSpade
/*     */   extends ItemSpade
/*     */   implements IPublicMaterialItem, IWeaponSpecial
/*     */ {
/*     */   public ItemMedievalSpade(int id, EnumToolMaterial material)
/*     */   {
/*  35 */     super(id, material);
/*  36 */     MinecraftForge.setToolClass(this, "shovel", material.func_77996_d());
/*  37 */     func_77637_a(ItemListMF.tabTool);
/*  38 */     this.field_77865_bY = (material.func_78000_c() + 2.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/*  52 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/*  53 */       return rarity(itemStack, 1);
/*     */     }
/*  55 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/*  56 */       return rarity(itemStack, 2);
/*     */     }
/*  58 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/*  62 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/*  63 */     if (item.func_77948_v()) {
/*  64 */       if (lvl == 0) {
/*  65 */         lvl++;
/*     */       }
/*  67 */       lvl++;
/*     */     }
/*  69 */     if (lvl >= rarity.length) {
/*  70 */       lvl = rarity.length - 1;
/*     */     }
/*  72 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial()
/*     */   {
/*  77 */     return this.field_77862_b;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/*  82 */     func_111206_d("minefantasy:Tool/" + name);
/*  83 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/*  88 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/*  89 */       target.func_70015_d(20);
/*     */     }
/*     */     
/*  92 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/*  93 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_77660_a(ItemStack item, World world, int id, int x, int y, int z, EntityLivingBase user)
/*     */   {
/*  99 */     Random rand = new Random();
/* 100 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/* 101 */       ((user instanceof EntityPlayer))) {
/* 102 */       ((EntityPlayer)user).func_71024_bL().func_75122_a(1, 0.2F);
/*     */     }
/*     */     
/*     */ 
/* 106 */     return super.func_77660_a(item, world, id, x, y, z, user);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemMedievalSpade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */