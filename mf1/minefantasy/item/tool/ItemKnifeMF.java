/*     */ package minefantasy.item.tool;
/*     */ 
/*     */ import java.util.List;
/*     */ import minefantasy.api.cooking.IUtensil;
/*     */ import minefantasy.api.leatherwork.EnumToolType;
/*     */ import minefantasy.api.leatherwork.ITanningItem;
/*     */ import minefantasy.api.weapon.IWeaponSpecial;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemTool;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemKnifeMF
/*     */   extends ItemTool
/*     */   implements ITanningItem, IUtensil, IWeaponSpecial
/*     */ {
/*     */   private float quality;
/*     */   
/*     */   public ItemKnifeMF(int id, EnumToolMaterial material)
/*     */   {
/*  31 */     this(id, material.func_78000_c() + 1.0F, material);
/*     */   }
/*     */   
/*     */   public ItemKnifeMF(int id, float dam, EnumToolMaterial material) {
/*  35 */     super(id, material.func_77998_b(), material, new Block[0]);
/*  36 */     this.quality = material.func_77998_b();
/*  37 */     this.field_77865_bY = dam;
/*  38 */     func_77637_a(ItemListMF.tabTool);
/*     */   }
/*     */   
/*     */   public boolean func_77662_d()
/*     */   {
/*  43 */     return true;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/*  48 */     func_111206_d("minefantasy:Tool/" + name);
/*  49 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   public float getQuality()
/*     */   {
/*  54 */     return this.quality;
/*     */   }
/*     */   
/*     */   public EnumToolType getType()
/*     */   {
/*  59 */     return EnumToolType.KNIFE;
/*     */   }
/*     */   
/*     */   public String getType(ItemStack tool)
/*     */   {
/*  64 */     return "knife";
/*     */   }
/*     */   
/*     */   public float getEfficiency(ItemStack tool)
/*     */   {
/*  69 */     int enchant = EnchantmentHelper.func_77506_a(Enchantment.field_77349_p.field_77352_x, tool);
/*     */     
/*  71 */     return this.quality * (1.0F + 0.5F * enchant);
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*     */   {
/*  76 */     if (id != ItemListMF.knifeBronze.field_77779_bT) {
/*  77 */       return;
/*     */     }
/*  79 */     add(list, ItemListMF.spadeCopperForged);
/*  80 */     add(list, ItemListMF.spadeTin);
/*  81 */     add(list, ItemListMF.spadeBronze);
/*  82 */     add(list, ItemListMF.spadeIronForged);
/*  83 */     add(list, ItemListMF.spadeSteelForged);
/*  84 */     add(list, ItemListMF.spadeEncrusted);
/*  85 */     add(list, ItemListMF.spadeDragon);
/*  86 */     add(list, ItemListMF.spadeDeepIron);
/*  87 */     add(list, ItemListMF.spadeMithril);
/*  88 */     add(list, ItemListMF.spadeIgnotumiteForged);
/*     */     
/*  90 */     add(list, ItemListMF.axeCopperForged);
/*  91 */     add(list, ItemListMF.axeTin);
/*  92 */     add(list, ItemListMF.axeBronze);
/*  93 */     add(list, ItemListMF.axeIronForged);
/*  94 */     add(list, ItemListMF.axeSteelForged);
/*  95 */     add(list, ItemListMF.axeEncrusted);
/*  96 */     add(list, ItemListMF.axeDragon);
/*  97 */     add(list, ItemListMF.axeDeepIron);
/*  98 */     add(list, ItemListMF.axeMithril);
/*  99 */     add(list, ItemListMF.axeIgnotumiteForged);
/*     */     
/* 101 */     add(list, ItemListMF.handpickBronze);
/* 102 */     add(list, ItemListMF.handpickIron);
/* 103 */     add(list, ItemListMF.handpickSteel);
/* 104 */     add(list, ItemListMF.handpickEncrusted);
/* 105 */     add(list, ItemListMF.handpickDragonforge);
/* 106 */     add(list, ItemListMF.handpickDeepIron);
/* 107 */     add(list, ItemListMF.handpickMithril);
/* 108 */     add(list, ItemListMF.handpickIgnotumite);
/*     */     
/* 110 */     add(list, ItemListMF.pickCopperForged);
/* 111 */     add(list, ItemListMF.pickTin);
/* 112 */     add(list, ItemListMF.pickBronze);
/* 113 */     add(list, ItemListMF.pickIronForged);
/* 114 */     add(list, ItemListMF.pickSteelForged);
/* 115 */     add(list, ItemListMF.pickEncrusted);
/* 116 */     add(list, ItemListMF.pickDragon);
/* 117 */     add(list, ItemListMF.pickDeepIron);
/* 118 */     add(list, ItemListMF.pickMithril);
/* 119 */     add(list, ItemListMF.pickIgnotumiteForged);
/*     */     
/* 121 */     add(list, ItemListMF.hoeCopperForged);
/* 122 */     add(list, ItemListMF.hoeTin);
/* 123 */     add(list, ItemListMF.hoeBronze);
/* 124 */     add(list, ItemListMF.hoeIronForged);
/* 125 */     add(list, ItemListMF.hoeSteelForged);
/* 126 */     add(list, ItemListMF.hoeDragon);
/* 127 */     add(list, ItemListMF.hoeDeepIron);
/* 128 */     add(list, ItemListMF.hoeMithril);
/*     */     
/* 130 */     add(list, ItemListMF.knifeStone);
/* 131 */     add(list, ItemListMF.knifeCopper);
/* 132 */     add(list, ItemListMF.knifeTin);
/* 133 */     add(list, ItemListMF.knifeBronze);
/* 134 */     add(list, ItemListMF.knifeIron);
/* 135 */     add(list, ItemListMF.knifeSteel);
/* 136 */     add(list, ItemListMF.knifeDragon);
/* 137 */     add(list, ItemListMF.knifeDeepIron);
/* 138 */     add(list, ItemListMF.knifeMithril);
/*     */     
/* 140 */     add(list, ItemListMF.malletWood);
/* 141 */     add(list, ItemListMF.malletIronbark);
/* 142 */     add(list, ItemListMF.malletEbony);
/*     */     
/* 144 */     add(list, ItemListMF.hammerStone);
/* 145 */     add(list, ItemListMF.hammerCopper);
/* 146 */     add(list, ItemListMF.hammerTin);
/* 147 */     add(list, ItemListMF.hammerBronze);
/* 148 */     add(list, ItemListMF.hammerIron);
/* 149 */     add(list, ItemListMF.hammerSteel);
/* 150 */     add(list, ItemListMF.hammerDragon);
/* 151 */     add(list, ItemListMF.hammerDeepIron);
/* 152 */     add(list, ItemListMF.hammerMithril);
/* 153 */     add(list, ItemListMF.hammerOrnate);
/*     */     
/* 155 */     add(list, ItemListMF.tongsStone);
/* 156 */     add(list, ItemListMF.tongsCopper);
/* 157 */     add(list, ItemListMF.tongsTin);
/* 158 */     add(list, ItemListMF.tongsBronze);
/* 159 */     add(list, ItemListMF.tongsIron);
/* 160 */     add(list, ItemListMF.tongsSteel);
/* 161 */     add(list, ItemListMF.tongsDragon);
/* 162 */     add(list, ItemListMF.tongsDeepIron);
/* 163 */     add(list, ItemListMF.tongsMithril);
/*     */     
/* 165 */     add(list, ItemListMF.hammerRepair);
/* 166 */     add(list, ItemListMF.hammerRepair2);
/* 167 */     add(list, ItemListMF.hammerRepairArtisan);
/* 168 */     add(list, ItemListMF.hammerRepairOrnate);
/* 169 */     add(list, ItemListMF.hammerRepairOrnate2);
/* 170 */     add(list, ItemListMF.hammerRepairOrnateArtisan);
/*     */     
/* 172 */     add(list, ItemListMF.shearsCopper);
/* 173 */     add(list, ItemListMF.shearsTin);
/* 174 */     add(list, ItemListMF.shearsBronze);
/* 175 */     add(list, ItemListMF.shearsIron);
/* 176 */     add(list, ItemListMF.shearsSteel);
/* 177 */     add(list, ItemListMF.shearsDragon);
/* 178 */     add(list, ItemListMF.shearsDeepIron);
/* 179 */     add(list, ItemListMF.shearsMithril);
/*     */     
/* 181 */     add(list, ItemListMF.rakeBronze);
/* 182 */     add(list, ItemListMF.rakeIron);
/* 183 */     add(list, ItemListMF.rakeSteel);
/* 184 */     add(list, ItemListMF.rakeDragon);
/* 185 */     add(list, ItemListMF.rakeDeepIron);
/* 186 */     add(list, ItemListMF.rakeMithril);
/*     */     
/* 188 */     add(list, ItemListMF.mattockBronze);
/* 189 */     add(list, ItemListMF.mattockIron);
/* 190 */     add(list, ItemListMF.mattockSteel);
/* 191 */     add(list, ItemListMF.mattockDragon);
/* 192 */     add(list, ItemListMF.mattockDeepIron);
/* 193 */     add(list, ItemListMF.mattockMithril);
/*     */     
/* 195 */     add(list, ItemListMF.sawBronze);
/* 196 */     add(list, ItemListMF.sawIron);
/* 197 */     add(list, ItemListMF.sawSteel);
/* 198 */     add(list, ItemListMF.sawDragon);
/* 199 */     add(list, ItemListMF.sawDeepIron);
/* 200 */     add(list, ItemListMF.sawMithril);
/*     */     
/* 202 */     add(list, ItemListMF.scytheBronze);
/* 203 */     add(list, ItemListMF.scytheIron);
/* 204 */     add(list, ItemListMF.scytheSteel);
/* 205 */     add(list, ItemListMF.scytheDragon);
/* 206 */     add(list, ItemListMF.scytheDeepIron);
/* 207 */     add(list, ItemListMF.scytheMithril);
/*     */   }
/*     */   
/*     */   private void add(List list, Item item) {
/* 211 */     list.add(new ItemStack(item));
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial() {
/* 215 */     return this.field_77862_b;
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/* 220 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 221 */       return rarity(itemStack, 1);
/*     */     }
/* 223 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 224 */       return rarity(itemStack, 2);
/*     */     }
/* 226 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/* 230 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/* 231 */     if (item.func_77948_v()) {
/* 232 */       if (lvl == 0) {
/* 233 */         lvl++;
/*     */       }
/* 235 */       lvl++;
/*     */     }
/* 237 */     if (lvl >= rarity.length) {
/* 238 */       lvl = rarity.length - 1;
/*     */     }
/* 240 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 245 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 246 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 249 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 250 */       attacker.func_70691_i(1.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/tool/ItemKnifeMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */