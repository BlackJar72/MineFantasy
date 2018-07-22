/*     */ package minefantasy.item.armour;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.armour.EnumArmourClass;
/*     */ import minefantasy.api.armour.IArmourClass;
/*     */ import minefantasy.api.armour.IArmourCustomSpeed;
/*     */ import minefantasy.api.armour.IElementalResistance;
/*     */ import minefantasy.api.weapon.DamageSourceAP;
/*     */ import minefantasy.client.entityrender.ModelApron;
/*     */ import minefantasy.item.ArmourDesign;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.MedievalArmourMaterial;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumArmorMaterial;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemArmourMF
/*     */   extends ItemArmor
/*     */   implements IArmourClass, IElementalResistance, ISpecialArmor, IArmourCustomSpeed
/*     */ {
/*  53 */   public static final DecimalFormat decimal_format = new DecimalFormat("#.##");
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private Icon[] ironChain;
/*  57 */   private static final int[] maxDamageArray = { 11, 16, 15, 13 };
/*     */   
/*     */ 
/*     */ 
/*     */   public final int armourType;
/*     */   
/*     */ 
/*     */ 
/*     */   public final int field_77879_b;
/*     */   
/*     */ 
/*     */   private String file;
/*     */   
/*     */ 
/*     */   public final int field_77880_c;
/*     */   
/*     */ 
/*     */   private final EnumArmourMF material;
/*     */   
/*     */ 
/*  77 */   private static EnumArmorMaterial base = MedievalArmourMaterial.BASIC;
/*     */   private final ArmourDesign AD;
/*     */   
/*     */   public ItemArmourMF(int i, ArmourDesign design, EnumArmourMF mat, int render, int type, String s)
/*     */   {
/*  82 */     super(i, base, render, type);
/*     */     
/*  84 */     this.AD = design;
/*  85 */     func_77637_a(ItemListMF.tabArmour);
/*     */     
/*  87 */     this.material = mat;
/*  88 */     this.file = s;
/*  89 */     this.armourType = type;
/*  90 */     this.field_77880_c = render;
/*  91 */     this.field_77879_b = ((int)Math.min(20.0F, base.func_78044_b(type) * mat.armourRating * design.protection));
/*  92 */     func_77656_e((int)(mat.durability * base.func_78044_b(type) * this.AD.dura));
/*  93 */     this.field_77777_bU = 1;
/*     */   }
/*     */   
/*     */   private boolean isBasicMaterial(ArmourDesign d, EnumArmorMaterial mat) {
/*  97 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack item, EntityPlayer user, List info, boolean special)
/*     */   {
/* 107 */     super.func_77624_a(item, user, info, special);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Icon func_77617_a(int dam)
/*     */   {
/* 113 */     if (isVChain()) {
/* 114 */       return this.ironChain[this.armourType];
/*     */     }
/* 116 */     return super.func_77617_a(dam);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_77619_b()
/*     */   {
/* 124 */     return this.material.enchantment;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int[] getMaxDamageArray()
/*     */   {
/* 132 */     return maxDamageArray;
/*     */   }
/*     */   
/*     */   public EnumArmourMF getMaterial() {
/* 136 */     return this.material;
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/* 141 */     if (getMaterial() == EnumArmourMF.DRAGONFORGE) {
/* 142 */       return rarity(itemStack, 1);
/*     */     }
/* 144 */     return rarity(itemStack, 0);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/* 148 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/* 149 */     if (item.func_77948_v()) {
/* 150 */       if (lvl == 0) {
/* 151 */         lvl++;
/*     */       }
/* 153 */       lvl++;
/*     */     }
/* 155 */     if (this.AD == ArmourDesign.PLATE) {
/* 156 */       lvl++;
/*     */     }
/* 158 */     if (lvl >= rarity.length) {
/* 159 */       lvl = rarity.length - 1;
/*     */     }
/* 161 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
/*     */   {
/* 167 */     if (stack.field_77993_c == ItemListMF.apronSmithy.field_77779_bT) {
/* 168 */       return "textures/entity/villager/smith.png";
/*     */     }
/* 170 */     return MFResource.armour + this.file + ".png";
/*     */   }
/*     */   
/*     */   private boolean isVChain() {
/* 174 */     return (getMaterial() == EnumArmourMF.IRON) && (this.AD == ArmourDesign.CHAIN);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private void joinParts(ModelRenderer part, ModelRenderer anchor) {
/* 179 */     part.field_78795_f = anchor.field_78795_f;
/* 180 */     part.field_78796_g = anchor.field_78796_g;
/* 181 */     part.field_78808_h = anchor.field_78808_h;
/*     */   }
/*     */   
/*     */   public EnumArmourClass getArmourClass()
/*     */   {
/* 186 */     if ((getMaterial() == EnumArmourMF.APRON) || (getMaterial() == EnumArmourMF.RAWHIDE) || (getMaterial() == EnumArmourMF.STEALTH)) {
/* 187 */       return EnumArmourClass.LIGHT;
/*     */     }
/* 189 */     return ArmourDesign.getAC(this.AD.AC);
/*     */   }
/*     */   
/*     */   public float fireResistance()
/*     */   {
/* 194 */     if (getMaterial() == EnumArmourMF.DRAGONFORGE) {
/* 195 */       float resistance = 1.0F / ArmourDesign.PLATE.protection * this.AD.protection;
/*     */       
/* 197 */       if (resistance > 1.0F) {
/* 198 */         resistance = 1.0F;
/*     */       }
/* 200 */       return 1.0F - resistance;
/*     */     }
/* 202 */     if (getMaterial() == EnumArmourMF.APRON) {
/* 203 */       return 0.8F;
/*     */     }
/* 205 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float shockResistance()
/*     */   {
/* 210 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float corrosiveResistance()
/*     */   {
/* 215 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float frostResistance()
/*     */   {
/* 220 */     if (getArmourClass() == EnumArmourClass.PLATE) {
/* 221 */       return 0.9F;
/*     */     }
/* 223 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float arcaneResistance()
/*     */   {
/* 228 */     if (getMaterial() == EnumArmourMF.ENCRUSTED) {
/* 229 */       return 0.8F;
/*     */     }
/* 231 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public int damageReduction()
/*     */   {
/* 236 */     return 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack item, int armourslot)
/*     */   {
/* 242 */     if (getMaterial() == EnumArmourMF.APRON) {
/* 243 */       ModelApron apron = new ModelApron(0.0F);
/* 244 */       return apron;
/*     */     }
/* 246 */     return super.getArmorModel(entity, item, armourslot);
/*     */   }
/*     */   
/*     */   public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
/*     */   {
/* 251 */     if (getMaterial() == EnumArmourMF.GUILDED) {
/* 252 */       if ((source != null) && (source.func_76346_g() != null) && 
/* 253 */         ((source.func_76346_g() instanceof EntityLivingBase))) {
/* 254 */         EntityLivingBase mob = (EntityLivingBase)source.func_76346_g();
/* 255 */         if (shouldSilverHurt(mob)) {
/* 256 */           float deflect = (float)damage * (source.func_76352_a() ? 0.5F : 1.0F);
/* 257 */           mob.func_70097_a(DamageSource.field_76376_m, deflect);
/*     */         }
/*     */       }
/*     */       
/* 261 */       if ((source.func_82725_o()) || (source == DamageSource.field_82727_n)) {
/* 262 */         if ((damage <= 1.0D) && (player.func_70681_au().nextFloat() * 2.0F < this.AD.protection)) {
/* 263 */           damage = 0.0D;
/*     */         }
/* 265 */         damage /= 2.0F * this.AD.protection;
/*     */       }
/*     */     }
/*     */     
/* 269 */     int value = base.func_78044_b(this.field_77881_a);
/* 270 */     double AC = value * this.material.armourRating;
/*     */     
/* 272 */     if (source.func_76352_a()) {
/* 273 */       AC *= this.AD.projResist;
/* 274 */     } else if (source.func_76347_k()) {
/* 275 */       AC *= this.AD.fireResist;
/* 276 */     } else if (source.func_94541_c()) {
/* 277 */       AC *= this.AD.expResist;
/* 278 */     } else if (source == DamageSourceAP.blunt) {
/* 279 */       AC *= this.AD.bluntResist;
/*     */     } else {
/* 281 */       AC *= this.AD.protection;
/*     */     }
/*     */     
/* 284 */     if ((source != DamageSourceAP.blunt) && (source.func_76363_c())) {
/* 285 */       AC = 0.0D;
/*     */     }
/*     */     
/* 288 */     if (source == DamageSource.field_76379_h) {
/* 289 */       if (getMaterial() == EnumArmourMF.STEALTH) {
/* 290 */         AC += 4.0D;
/*     */       } else {
/* 292 */         AC *= this.AD.fallResist;
/*     */       }
/*     */     }
/*     */     
/* 296 */     if ((!player.field_70170_p.field_72995_K) && (MineFantasyBase.isDebug())) {
/* 297 */       System.out.println("AC: " + AC);
/*     */     }
/*     */     
/* 300 */     float m = (float)((func_77612_l() + 1 - armor.func_77960_j()) * AC);
/* 301 */     double maxRatio = 0.099D * base.func_78044_b(this.field_77881_a);
/* 302 */     double ratio = Math.min(AC / 25.0D, maxRatio);
/*     */     
/* 304 */     return new ISpecialArmor.ArmorProperties(0, AC / 25.0D, (int)m);
/*     */   }
/*     */   
/*     */   public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
/*     */   {
/* 309 */     float AC = ((ItemArmourMF)armor.func_77973_b()).field_77879_b;
/* 310 */     AC *= this.AD.protection * this.material.armourRating;
/*     */     
/* 312 */     return (int)AC;
/*     */   }
/*     */   
/*     */   public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
/*     */   {
/* 317 */     if ((getMaterial() == EnumArmourMF.ADAMANTIUM) || (getMaterial() == EnumArmourMF.IGNOTUMITE)) {
/* 318 */       return;
/*     */     }
/* 320 */     if ((getMaterial() == EnumArmourMF.GUILDED) && (source != null) && (source.func_76346_g() != null) && 
/* 321 */       ((source.func_76346_g() instanceof EntityLivingBase)) && 
/* 322 */       (shouldSilverHurt((EntityLivingBase)source.func_76346_g()))) {
/* 323 */       return;
/*     */     }
/*     */     
/*     */ 
/* 327 */     if ((getMaterial() == EnumArmourMF.DRAGONFORGE) && (source != null) && (source.func_76347_k())) {
/* 328 */       return;
/*     */     }
/* 330 */     stack.func_77972_a(1, entity);
/*     */   }
/*     */   
/*     */   public static boolean shouldSilverHurt(EntityLivingBase target)
/*     */   {
/* 335 */     Class enClass = target.getClass();
/* 336 */     String name = "";
/* 337 */     if ((enClass != null) && (EntityList.field_75626_c.get(enClass) != null)) {
/* 338 */       name = (String)EntityList.field_75626_c.get(enClass);
/*     */     }
/*     */     
/* 341 */     if (target.func_70668_bt() == EnumCreatureAttribute.UNDEAD) {
/* 342 */       return true;
/*     */     }
/* 344 */     if (name.endsWith("Werewolf")) {
/* 345 */       return true;
/*     */     }
/*     */     
/* 348 */     return false;
/*     */   }
/*     */   
/*     */   public float getMoveSpeed(ItemStack item)
/*     */   {
/* 353 */     float decr = 1.0F - this.AD.moveSpeed;
/* 354 */     return 1.0F - decr * this.material.armourWeight;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/* 359 */     if (isVChain()) {
/* 360 */       func_111206_d("minecraft:");
/* 361 */       return super.func_77655_b(name);
/*     */     }
/* 363 */     func_111206_d("minefantasy:Apparel/" + name);
/* 364 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/* 370 */     if (isVChain()) {
/* 371 */       this.ironChain = new Icon[4];
/*     */       
/* 373 */       this.ironChain[0] = reg.func_94245_a("MineFantasy:Apparel/ironChainHelmet");
/* 374 */       this.ironChain[1] = reg.func_94245_a("MineFantasy:Apparel/ironChainChest");
/* 375 */       this.ironChain[2] = reg.func_94245_a("MineFantasy:Apparel/ironChainLegs");
/* 376 */       this.ironChain[3] = reg.func_94245_a("MineFantasy:Apparel/ironChainBoots");
/*     */     } else {
/* 378 */       super.func_94581_a(reg);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {
/* 383 */     if (tabs != ItemListMF.tabArmour) {
/* 384 */       super.func_77633_a(id, tabs, list);
/* 385 */       return;
/*     */     }
/* 387 */     if (id != ItemListMF.apronSmithy.field_77779_bT) {
/* 388 */       return;
/*     */     }
/* 390 */     add(list, ItemListMF.apronSmithy);
/*     */     
/* 392 */     add(list, ItemListMF.helmetLeatherRough);
/* 393 */     add(list, ItemListMF.plateLeatherRough);
/* 394 */     add(list, ItemListMF.legsLeatherRough);
/* 395 */     add(list, ItemListMF.bootsLeatherRough);
/*     */     
/* 397 */     add(list, ItemListMF.helmetBronzeScale);
/* 398 */     add(list, ItemListMF.plateBronzeScale);
/* 399 */     add(list, ItemListMF.legsBronzeScale);
/* 400 */     add(list, ItemListMF.bootsBronzeScale);
/* 401 */     add(list, ItemListMF.helmetIronScale);
/* 402 */     add(list, ItemListMF.plateIronScale);
/* 403 */     add(list, ItemListMF.legsIronScale);
/* 404 */     add(list, ItemListMF.bootsIronScale);
/* 405 */     add(list, ItemListMF.helmetGuildedScale);
/* 406 */     add(list, ItemListMF.plateGuildedScale);
/* 407 */     add(list, ItemListMF.legsGuildedScale);
/* 408 */     add(list, ItemListMF.bootsGuildedScale);
/* 409 */     add(list, ItemListMF.helmetSteelScale);
/* 410 */     add(list, ItemListMF.plateSteelScale);
/* 411 */     add(list, ItemListMF.legsSteelScale);
/* 412 */     add(list, ItemListMF.bootsSteelScale);
/* 413 */     add(list, ItemListMF.helmetDeepIronScale);
/* 414 */     add(list, ItemListMF.plateDeepIronScale);
/* 415 */     add(list, ItemListMF.legsDeepIronScale);
/* 416 */     add(list, ItemListMF.bootsDeepIronScale);
/* 417 */     add(list, ItemListMF.helmetMithrilScale);
/* 418 */     add(list, ItemListMF.plateMithrilScale);
/* 419 */     add(list, ItemListMF.legsMithrilScale);
/* 420 */     add(list, ItemListMF.bootsMithrilScale);
/* 421 */     add(list, ItemListMF.helmetDragonScale);
/* 422 */     add(list, ItemListMF.plateDragonScale);
/* 423 */     add(list, ItemListMF.legsDragonScale);
/* 424 */     add(list, ItemListMF.bootsDragonScale);
/*     */     
/* 426 */     add(list, ItemListMF.helmetBronzeChain);
/* 427 */     add(list, ItemListMF.plateBronzeChain);
/* 428 */     add(list, ItemListMF.legsBronzeChain);
/* 429 */     add(list, ItemListMF.bootsBronzeChain);
/* 430 */     add(list, Item.field_77694_Z);
/* 431 */     add(list, Item.field_77814_aa);
/* 432 */     add(list, Item.field_77816_ab);
/* 433 */     add(list, Item.field_77810_ac);
/* 434 */     add(list, ItemListMF.helmetGuildedChain);
/* 435 */     add(list, ItemListMF.plateGuildedChain);
/* 436 */     add(list, ItemListMF.legsGuildedChain);
/* 437 */     add(list, ItemListMF.bootsGuildedChain);
/* 438 */     add(list, ItemListMF.helmetSteelChain);
/* 439 */     add(list, ItemListMF.plateSteelChain);
/* 440 */     add(list, ItemListMF.legsSteelChain);
/* 441 */     add(list, ItemListMF.bootsSteelChain);
/* 442 */     add(list, ItemListMF.helmetDeepIronChain);
/* 443 */     add(list, ItemListMF.plateDeepIronChain);
/* 444 */     add(list, ItemListMF.legsDeepIronChain);
/* 445 */     add(list, ItemListMF.bootsDeepIronChain);
/* 446 */     add(list, ItemListMF.helmetMithrilChain);
/* 447 */     add(list, ItemListMF.plateMithrilChain);
/* 448 */     add(list, ItemListMF.legsMithrilChain);
/* 449 */     add(list, ItemListMF.bootsMithrilChain);
/* 450 */     add(list, ItemListMF.helmetDragonChain);
/* 451 */     add(list, ItemListMF.plateDragonChain);
/* 452 */     add(list, ItemListMF.legsDragonChain);
/* 453 */     add(list, ItemListMF.bootsDragonChain);
/*     */     
/* 455 */     add(list, ItemListMF.helmetBronzeSplint);
/* 456 */     add(list, ItemListMF.plateBronzeSplint);
/* 457 */     add(list, ItemListMF.legsBronzeSplint);
/* 458 */     add(list, ItemListMF.bootsBronzeSplint);
/* 459 */     add(list, ItemListMF.helmetIronSplint);
/* 460 */     add(list, ItemListMF.plateIronSplint);
/* 461 */     add(list, ItemListMF.legsIronSplint);
/* 462 */     add(list, ItemListMF.bootsIronSplint);
/* 463 */     add(list, ItemListMF.helmetGuildedSplint);
/* 464 */     add(list, ItemListMF.plateGuildedSplint);
/* 465 */     add(list, ItemListMF.legsGuildedSplint);
/* 466 */     add(list, ItemListMF.bootsGuildedSplint);
/* 467 */     add(list, ItemListMF.helmetSteelSplint);
/* 468 */     add(list, ItemListMF.plateSteelSplint);
/* 469 */     add(list, ItemListMF.legsSteelSplint);
/* 470 */     add(list, ItemListMF.bootsSteelSplint);
/* 471 */     add(list, ItemListMF.helmetDeepIronSplint);
/* 472 */     add(list, ItemListMF.plateDeepIronSplint);
/* 473 */     add(list, ItemListMF.legsDeepIronSplint);
/* 474 */     add(list, ItemListMF.bootsDeepIronSplint);
/* 475 */     add(list, ItemListMF.helmetMithrilSplint);
/* 476 */     add(list, ItemListMF.plateMithrilSplint);
/* 477 */     add(list, ItemListMF.legsMithrilSplint);
/* 478 */     add(list, ItemListMF.bootsMithrilSplint);
/* 479 */     add(list, ItemListMF.helmetDragonSplint);
/* 480 */     add(list, ItemListMF.plateDragonSplint);
/* 481 */     add(list, ItemListMF.legsDragonSplint);
/* 482 */     add(list, ItemListMF.bootsDragonSplint);
/*     */     
/* 484 */     add(list, ItemListMF.helmetBronzeHvyChain);
/* 485 */     add(list, ItemListMF.plateBronzeHvyChain);
/* 486 */     add(list, ItemListMF.legsBronzeHvyChain);
/* 487 */     add(list, ItemListMF.bootsBronzeHvyChain);
/* 488 */     add(list, ItemListMF.helmetIronHvyChain);
/* 489 */     add(list, ItemListMF.plateIronHvyChain);
/* 490 */     add(list, ItemListMF.legsIronHvyChain);
/* 491 */     add(list, ItemListMF.bootsIronHvyChain);
/* 492 */     add(list, ItemListMF.helmetGuildedHvyChain);
/* 493 */     add(list, ItemListMF.plateGuildedHvyChain);
/* 494 */     add(list, ItemListMF.legsGuildedHvyChain);
/* 495 */     add(list, ItemListMF.bootsGuildedHvyChain);
/* 496 */     add(list, ItemListMF.helmetSteelHvyChain);
/* 497 */     add(list, ItemListMF.plateSteelHvyChain);
/* 498 */     add(list, ItemListMF.legsSteelHvyChain);
/* 499 */     add(list, ItemListMF.bootsSteelHvyChain);
/* 500 */     add(list, ItemListMF.helmetDeepIronHvyChain);
/* 501 */     add(list, ItemListMF.plateDeepIronHvyChain);
/* 502 */     add(list, ItemListMF.legsDeepIronHvyChain);
/* 503 */     add(list, ItemListMF.bootsDeepIronHvyChain);
/* 504 */     add(list, ItemListMF.helmetMithrilHvyChain);
/* 505 */     add(list, ItemListMF.plateMithrilHvyChain);
/* 506 */     add(list, ItemListMF.legsMithrilHvyChain);
/* 507 */     add(list, ItemListMF.bootsMithrilHvyChain);
/* 508 */     add(list, ItemListMF.helmetDragonHvyChain);
/* 509 */     add(list, ItemListMF.plateDragonHvyChain);
/* 510 */     add(list, ItemListMF.legsDragonHvyChain);
/* 511 */     add(list, ItemListMF.bootsDragonHvyChain);
/*     */     
/* 513 */     add(list, ItemListMF.helmetBronzePlate);
/* 514 */     add(list, ItemListMF.plateBronzePlate);
/* 515 */     add(list, ItemListMF.legsBronzePlate);
/* 516 */     add(list, ItemListMF.bootsBronzePlate);
/* 517 */     add(list, ItemListMF.helmetIronPlate);
/* 518 */     add(list, ItemListMF.plateIronPlate);
/* 519 */     add(list, ItemListMF.legsIronPlate);
/* 520 */     add(list, ItemListMF.bootsIronPlate);
/* 521 */     add(list, ItemListMF.helmetGuildedPlate);
/* 522 */     add(list, ItemListMF.plateGuildedPlate);
/* 523 */     add(list, ItemListMF.legsGuildedPlate);
/* 524 */     add(list, ItemListMF.bootsGuildedPlate);
/* 525 */     add(list, ItemListMF.helmetSteelPlate);
/* 526 */     add(list, ItemListMF.plateSteelPlate);
/* 527 */     add(list, ItemListMF.legsSteelPlate);
/* 528 */     add(list, ItemListMF.bootsSteelPlate);
/* 529 */     add(list, ItemListMF.helmetEncrustedPlate);
/* 530 */     add(list, ItemListMF.plateEncrustedPlate);
/* 531 */     add(list, ItemListMF.legsEncrustedPlate);
/* 532 */     add(list, ItemListMF.bootsEncrustedPlate);
/* 533 */     add(list, ItemListMF.helmetDragonPlate);
/* 534 */     add(list, ItemListMF.plateDragonPlate);
/* 535 */     add(list, ItemListMF.legsDragonPlate);
/* 536 */     add(list, ItemListMF.bootsDragonPlate);
/* 537 */     add(list, ItemListMF.helmetDeepIronPlate);
/* 538 */     add(list, ItemListMF.plateDeepIronPlate);
/* 539 */     add(list, ItemListMF.legsDeepIronPlate);
/* 540 */     add(list, ItemListMF.bootsDeepIronPlate);
/* 541 */     add(list, ItemListMF.helmetMithrilPlate);
/* 542 */     add(list, ItemListMF.plateMithrilPlate);
/* 543 */     add(list, ItemListMF.legsMithrilPlate);
/* 544 */     add(list, ItemListMF.bootsMithrilPlate);
/* 545 */     add(list, ItemListMF.helmetStealth);
/* 546 */     add(list, ItemListMF.plateStealth);
/* 547 */     add(list, ItemListMF.legsStealth);
/* 548 */     add(list, ItemListMF.bootsStealth);
/*     */   }
/*     */   
/*     */   private void add(List list, Item item) {
/* 552 */     list.add(new ItemStack(item));
/*     */   }
/*     */   
/* 555 */   public static float[] armourSize = { 0.20833333F, 0.33333334F, 0.29166666F, 0.16666667F };
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/armour/ItemArmourMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */