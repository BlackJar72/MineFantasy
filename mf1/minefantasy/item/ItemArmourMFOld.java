/*     */ package minefantasy.item;
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
/*     */ 
/*     */ 
/*     */ public class ItemArmourMFOld
/*     */   extends ItemArmor
/*     */   implements IArmourClass, IElementalResistance, ISpecialArmor, IArmourCustomSpeed
/*     */ {
/*  52 */   public static final DecimalFormat decimal_format = new DecimalFormat("#.##");
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private Icon[] ironChain;
/*  56 */   private static final int[] maxDamageArray = { 11, 16, 15, 13 };
/*     */   
/*     */ 
/*     */   public final int armourType;
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
/*     */   private final EnumArmorMaterial material;
/*     */   
/*     */ 
/*     */   private final ArmourDesign AD;
/*     */   
/*     */ 
/*     */ 
/*     */   public ItemArmourMFOld(int i, ArmourDesign design, EnumArmorMaterial mat, int render, int type, String s)
/*     */   {
/*  80 */     super(i, mat, render, type);
/*     */     
/*  82 */     this.AD = design;
/*     */     
/*     */ 
/*     */ 
/*  86 */     func_77637_a(ItemListMF.tabArmour);
/*     */     
/*  88 */     this.material = mat;
/*  89 */     this.file = s;
/*  90 */     this.armourType = type;
/*  91 */     this.field_77880_c = render;
/*  92 */     this.field_77879_b = mat.func_78044_b(type);
/*  93 */     func_77656_e(mat.func_78046_a(type));
/*  94 */     this.field_77777_bU = 1;
/*     */   }
/*     */   
/*     */   private boolean isBasicMaterial(ArmourDesign d, EnumArmorMaterial mat) {
/*  98 */     return (isVChain()) || ((d == ArmourDesign.SOLID) && ((mat == MedievalArmourMaterial.STEEL) || (mat == MedievalArmourMaterial.RAWHIDE)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack item, EntityPlayer user, List info, boolean special)
/*     */   {
/* 108 */     super.func_77624_a(item, user, info, special);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Icon func_77617_a(int dam)
/*     */   {
/* 114 */     if (isVChain()) {
/* 115 */       return this.ironChain[this.armourType];
/*     */     }
/* 117 */     return super.func_77617_a(dam);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_77619_b()
/*     */   {
/* 125 */     return this.material.func_78045_a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static int[] getMaxDamageArray()
/*     */   {
/* 133 */     return maxDamageArray;
/*     */   }
/*     */   
/*     */   public EnumArmorMaterial getMaterial() {
/* 137 */     return this.material;
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/* 142 */     if (getMaterial() == MedievalArmourMaterial.DRAGON) {
/* 143 */       return rarity(itemStack, 1);
/*     */     }
/* 145 */     return rarity(itemStack, 0);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/* 149 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/* 150 */     if (item.func_77948_v()) {
/* 151 */       if (lvl == 0) {
/* 152 */         lvl++;
/*     */       }
/* 154 */       lvl++;
/*     */     }
/* 156 */     if (this.AD == ArmourDesign.PLATE) {
/* 157 */       lvl++;
/*     */     }
/* 159 */     if (lvl >= rarity.length) {
/* 160 */       lvl = rarity.length - 1;
/*     */     }
/* 162 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
/*     */   {
/* 168 */     if (stack.field_77993_c == ItemListMF.apronSmithy.field_77779_bT) {
/* 169 */       return "textures/entity/villager/smith.png";
/*     */     }
/* 171 */     return MFResource.armour + this.file + ".png";
/*     */   }
/*     */   
/*     */   private boolean isVChain() {
/* 175 */     return (getMaterial() == EnumArmorMaterial.IRON) && (this.AD == ArmourDesign.CHAIN);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private void joinParts(ModelRenderer part, ModelRenderer anchor) {
/* 180 */     part.field_78795_f = anchor.field_78795_f;
/* 181 */     part.field_78796_g = anchor.field_78796_g;
/* 182 */     part.field_78808_h = anchor.field_78808_h;
/*     */   }
/*     */   
/*     */   public EnumArmourClass getArmourClass()
/*     */   {
/* 187 */     if ((getMaterial() == MedievalArmourMaterial.APRON) || (getMaterial() == MedievalArmourMaterial.RAWHIDE) || (getMaterial() == MedievalArmourMaterial.STEALTH)) {
/* 188 */       return EnumArmourClass.LIGHT;
/*     */     }
/* 190 */     return ArmourDesign.getAC(this.AD.AC);
/*     */   }
/*     */   
/*     */   public float fireResistance()
/*     */   {
/* 195 */     if (getMaterial() == MedievalArmourMaterial.DRAGON) {
/* 196 */       float resistance = 1.0F / ArmourDesign.PLATE.protection * this.AD.protection;
/*     */       
/* 198 */       if (resistance > 1.0F) {
/* 199 */         resistance = 1.0F;
/*     */       }
/* 201 */       return 1.0F - resistance;
/*     */     }
/* 203 */     if (getMaterial() == MedievalArmourMaterial.APRON) {
/* 204 */       return 0.8F;
/*     */     }
/* 206 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float shockResistance()
/*     */   {
/* 211 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float corrosiveResistance()
/*     */   {
/* 216 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float frostResistance()
/*     */   {
/* 221 */     if (getArmourClass() == EnumArmourClass.PLATE) {
/* 222 */       return 0.9F;
/*     */     }
/* 224 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float arcaneResistance()
/*     */   {
/* 229 */     if (getMaterial() == MedievalArmourMaterial.ENCRUSTED) {
/* 230 */       return 0.8F;
/*     */     }
/* 232 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public int damageReduction()
/*     */   {
/* 237 */     return 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelBiped getArmorModel(EntityLivingBase entity, ItemStack item, int armourslot)
/*     */   {
/* 243 */     if (getMaterial() == MedievalArmourMaterial.APRON) {
/* 244 */       ModelApron apron = new ModelApron(0.0F);
/* 245 */       return apron;
/*     */     }
/* 247 */     return super.getArmorModel(entity, item, armourslot);
/*     */   }
/*     */   
/*     */   public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot)
/*     */   {
/* 252 */     if (getMaterial() == MedievalArmourMaterial.GUILDED) {
/* 253 */       if ((source != null) && (source.func_76346_g() != null) && 
/* 254 */         ((source.func_76346_g() instanceof EntityLivingBase))) {
/* 255 */         EntityLivingBase mob = (EntityLivingBase)source.func_76346_g();
/* 256 */         if (shouldSilverHurt(mob)) {
/* 257 */           float deflect = (float)damage * (source.func_76352_a() ? 0.5F : 1.0F);
/* 258 */           mob.func_70097_a(DamageSource.field_76376_m, deflect);
/*     */         }
/*     */       }
/*     */       
/* 262 */       if ((source.func_82725_o()) || (source == DamageSource.field_82727_n)) {
/* 263 */         if ((damage <= 1.0D) && (player.func_70681_au().nextFloat() * 2.0F < this.AD.protection)) {
/* 264 */           damage = 0.0D;
/*     */         }
/* 266 */         damage /= 2.0F * this.AD.protection;
/*     */       }
/*     */     }
/*     */     
/* 270 */     double AC = this.field_77879_b;
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
/* 289 */       if (getMaterial() == MedievalArmourMaterial.STEALTH) {
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
/* 301 */     return new ISpecialArmor.ArmorProperties(0, AC / 25.0D, (int)m);
/*     */   }
/*     */   
/*     */   public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
/*     */   {
/* 306 */     float AC = ((ItemArmor)armor.func_77973_b()).field_77879_b;
/* 307 */     AC *= this.AD.protection;
/*     */     
/* 309 */     return (int)AC;
/*     */   }
/*     */   
/*     */   public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot)
/*     */   {
/* 314 */     if ((getMaterial() == MedievalArmourMaterial.GUILDED) && (source != null) && (source.func_76346_g() != null) && 
/* 315 */       ((source.func_76346_g() instanceof EntityLivingBase)) && 
/* 316 */       (shouldSilverHurt((EntityLivingBase)source.func_76346_g()))) {
/* 317 */       return;
/*     */     }
/*     */     
/*     */ 
/* 321 */     if ((getMaterial() == MedievalArmourMaterial.DRAGON) && (source != null) && (source.func_76347_k())) {
/* 322 */       return;
/*     */     }
/* 324 */     stack.func_77972_a(1, entity);
/*     */   }
/*     */   
/*     */   public static boolean shouldSilverHurt(EntityLivingBase target)
/*     */   {
/* 329 */     Class enClass = target.getClass();
/* 330 */     String name = "";
/* 331 */     if ((enClass != null) && (EntityList.field_75626_c.get(enClass) != null)) {
/* 332 */       name = (String)EntityList.field_75626_c.get(enClass);
/*     */     }
/*     */     
/* 335 */     if (target.func_70668_bt() == EnumCreatureAttribute.UNDEAD) {
/* 336 */       return true;
/*     */     }
/* 338 */     if (name.endsWith("Werewolf")) {
/* 339 */       return true;
/*     */     }
/*     */     
/* 342 */     return false;
/*     */   }
/*     */   
/*     */   public float getMoveSpeed(ItemStack item)
/*     */   {
/* 347 */     float decr = 1.0F - this.AD.moveSpeed;
/* 348 */     if (getMaterial() == MedievalArmourMaterial.MITHRIL) {
/* 349 */       decr /= 2.0F;
/*     */     }
/*     */     
/* 352 */     if (getMaterial() == MedievalArmourMaterial.STEALTH) {
/* 353 */       return 1.2F;
/*     */     }
/* 355 */     if ((getMaterial() == MedievalArmourMaterial.APRON) || (getMaterial() == MedievalArmourMaterial.RAWHIDE)) {
/* 356 */       return 1.0F;
/*     */     }
/* 358 */     return 1.0F - decr;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/* 363 */     if (isVChain()) {
/* 364 */       func_111206_d("minecraft:");
/* 365 */       return super.func_77655_b(name);
/*     */     }
/* 367 */     func_111206_d("minefantasy:Apparel/" + name);
/* 368 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/* 374 */     if (isVChain()) {
/* 375 */       this.ironChain = new Icon[4];
/*     */       
/* 377 */       this.ironChain[0] = reg.func_94245_a("MineFantasy:Apparel/ironChainHelmet");
/* 378 */       this.ironChain[1] = reg.func_94245_a("MineFantasy:Apparel/ironChainChest");
/* 379 */       this.ironChain[2] = reg.func_94245_a("MineFantasy:Apparel/ironChainLegs");
/* 380 */       this.ironChain[3] = reg.func_94245_a("MineFantasy:Apparel/ironChainBoots");
/*     */     } else {
/* 382 */       super.func_94581_a(reg);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {
/* 387 */     if (tabs != ItemListMF.tabArmour) {
/* 388 */       super.func_77633_a(id, tabs, list);
/* 389 */       return;
/*     */     }
/* 391 */     if (id != ItemListMF.apronSmithy.field_77779_bT) {
/* 392 */       return;
/*     */     }
/* 394 */     add(list, ItemListMF.apronSmithy);
/*     */     
/* 396 */     add(list, ItemListMF.helmetLeatherRough);
/* 397 */     add(list, ItemListMF.plateLeatherRough);
/* 398 */     add(list, ItemListMF.legsLeatherRough);
/* 399 */     add(list, ItemListMF.bootsLeatherRough);
/*     */     
/* 401 */     add(list, ItemListMF.helmetBronzeScale);
/* 402 */     add(list, ItemListMF.plateBronzeScale);
/* 403 */     add(list, ItemListMF.legsBronzeScale);
/* 404 */     add(list, ItemListMF.bootsBronzeScale);
/* 405 */     add(list, ItemListMF.helmetIronScale);
/* 406 */     add(list, ItemListMF.plateIronScale);
/* 407 */     add(list, ItemListMF.legsIronScale);
/* 408 */     add(list, ItemListMF.bootsIronScale);
/* 409 */     add(list, ItemListMF.helmetGuildedScale);
/* 410 */     add(list, ItemListMF.plateGuildedScale);
/* 411 */     add(list, ItemListMF.legsGuildedScale);
/* 412 */     add(list, ItemListMF.bootsGuildedScale);
/* 413 */     add(list, ItemListMF.helmetSteelScale);
/* 414 */     add(list, ItemListMF.plateSteelScale);
/* 415 */     add(list, ItemListMF.legsSteelScale);
/* 416 */     add(list, ItemListMF.bootsSteelScale);
/* 417 */     add(list, ItemListMF.helmetDeepIronScale);
/* 418 */     add(list, ItemListMF.plateDeepIronScale);
/* 419 */     add(list, ItemListMF.legsDeepIronScale);
/* 420 */     add(list, ItemListMF.bootsDeepIronScale);
/* 421 */     add(list, ItemListMF.helmetMithrilScale);
/* 422 */     add(list, ItemListMF.plateMithrilScale);
/* 423 */     add(list, ItemListMF.legsMithrilScale);
/* 424 */     add(list, ItemListMF.bootsMithrilScale);
/* 425 */     add(list, ItemListMF.helmetDragonScale);
/* 426 */     add(list, ItemListMF.plateDragonScale);
/* 427 */     add(list, ItemListMF.legsDragonScale);
/* 428 */     add(list, ItemListMF.bootsDragonScale);
/*     */     
/* 430 */     add(list, ItemListMF.helmetBronzeChain);
/* 431 */     add(list, ItemListMF.plateBronzeChain);
/* 432 */     add(list, ItemListMF.legsBronzeChain);
/* 433 */     add(list, ItemListMF.bootsBronzeChain);
/* 434 */     add(list, Item.field_77694_Z);
/* 435 */     add(list, Item.field_77814_aa);
/* 436 */     add(list, Item.field_77816_ab);
/* 437 */     add(list, Item.field_77810_ac);
/* 438 */     add(list, ItemListMF.helmetGuildedChain);
/* 439 */     add(list, ItemListMF.plateGuildedChain);
/* 440 */     add(list, ItemListMF.legsGuildedChain);
/* 441 */     add(list, ItemListMF.bootsGuildedChain);
/* 442 */     add(list, ItemListMF.helmetSteelChain);
/* 443 */     add(list, ItemListMF.plateSteelChain);
/* 444 */     add(list, ItemListMF.legsSteelChain);
/* 445 */     add(list, ItemListMF.bootsSteelChain);
/* 446 */     add(list, ItemListMF.helmetDeepIronChain);
/* 447 */     add(list, ItemListMF.plateDeepIronChain);
/* 448 */     add(list, ItemListMF.legsDeepIronChain);
/* 449 */     add(list, ItemListMF.bootsDeepIronChain);
/* 450 */     add(list, ItemListMF.helmetMithrilChain);
/* 451 */     add(list, ItemListMF.plateMithrilChain);
/* 452 */     add(list, ItemListMF.legsMithrilChain);
/* 453 */     add(list, ItemListMF.bootsMithrilChain);
/* 454 */     add(list, ItemListMF.helmetDragonChain);
/* 455 */     add(list, ItemListMF.plateDragonChain);
/* 456 */     add(list, ItemListMF.legsDragonChain);
/* 457 */     add(list, ItemListMF.bootsDragonChain);
/*     */     
/* 459 */     add(list, ItemListMF.helmetBronzeSplint);
/* 460 */     add(list, ItemListMF.plateBronzeSplint);
/* 461 */     add(list, ItemListMF.legsBronzeSplint);
/* 462 */     add(list, ItemListMF.bootsBronzeSplint);
/* 463 */     add(list, ItemListMF.helmetIronSplint);
/* 464 */     add(list, ItemListMF.plateIronSplint);
/* 465 */     add(list, ItemListMF.legsIronSplint);
/* 466 */     add(list, ItemListMF.bootsIronSplint);
/* 467 */     add(list, ItemListMF.helmetGuildedSplint);
/* 468 */     add(list, ItemListMF.plateGuildedSplint);
/* 469 */     add(list, ItemListMF.legsGuildedSplint);
/* 470 */     add(list, ItemListMF.bootsGuildedSplint);
/* 471 */     add(list, ItemListMF.helmetSteelSplint);
/* 472 */     add(list, ItemListMF.plateSteelSplint);
/* 473 */     add(list, ItemListMF.legsSteelSplint);
/* 474 */     add(list, ItemListMF.bootsSteelSplint);
/* 475 */     add(list, ItemListMF.helmetDeepIronSplint);
/* 476 */     add(list, ItemListMF.plateDeepIronSplint);
/* 477 */     add(list, ItemListMF.legsDeepIronSplint);
/* 478 */     add(list, ItemListMF.bootsDeepIronSplint);
/* 479 */     add(list, ItemListMF.helmetMithrilSplint);
/* 480 */     add(list, ItemListMF.plateMithrilSplint);
/* 481 */     add(list, ItemListMF.legsMithrilSplint);
/* 482 */     add(list, ItemListMF.bootsMithrilSplint);
/* 483 */     add(list, ItemListMF.helmetDragonSplint);
/* 484 */     add(list, ItemListMF.plateDragonSplint);
/* 485 */     add(list, ItemListMF.legsDragonSplint);
/* 486 */     add(list, ItemListMF.bootsDragonSplint);
/*     */     
/* 488 */     add(list, ItemListMF.helmetBronzeHvyChain);
/* 489 */     add(list, ItemListMF.plateBronzeHvyChain);
/* 490 */     add(list, ItemListMF.legsBronzeHvyChain);
/* 491 */     add(list, ItemListMF.bootsBronzeHvyChain);
/* 492 */     add(list, ItemListMF.helmetIronHvyChain);
/* 493 */     add(list, ItemListMF.plateIronHvyChain);
/* 494 */     add(list, ItemListMF.legsIronHvyChain);
/* 495 */     add(list, ItemListMF.bootsIronHvyChain);
/* 496 */     add(list, ItemListMF.helmetGuildedHvyChain);
/* 497 */     add(list, ItemListMF.plateGuildedHvyChain);
/* 498 */     add(list, ItemListMF.legsGuildedHvyChain);
/* 499 */     add(list, ItemListMF.bootsGuildedHvyChain);
/* 500 */     add(list, ItemListMF.helmetSteelHvyChain);
/* 501 */     add(list, ItemListMF.plateSteelHvyChain);
/* 502 */     add(list, ItemListMF.legsSteelHvyChain);
/* 503 */     add(list, ItemListMF.bootsSteelHvyChain);
/* 504 */     add(list, ItemListMF.helmetDeepIronHvyChain);
/* 505 */     add(list, ItemListMF.plateDeepIronHvyChain);
/* 506 */     add(list, ItemListMF.legsDeepIronHvyChain);
/* 507 */     add(list, ItemListMF.bootsDeepIronHvyChain);
/* 508 */     add(list, ItemListMF.helmetMithrilHvyChain);
/* 509 */     add(list, ItemListMF.plateMithrilHvyChain);
/* 510 */     add(list, ItemListMF.legsMithrilHvyChain);
/* 511 */     add(list, ItemListMF.bootsMithrilHvyChain);
/* 512 */     add(list, ItemListMF.helmetDragonHvyChain);
/* 513 */     add(list, ItemListMF.plateDragonHvyChain);
/* 514 */     add(list, ItemListMF.legsDragonHvyChain);
/* 515 */     add(list, ItemListMF.bootsDragonHvyChain);
/*     */     
/* 517 */     add(list, ItemListMF.helmetBronzePlate);
/* 518 */     add(list, ItemListMF.plateBronzePlate);
/* 519 */     add(list, ItemListMF.legsBronzePlate);
/* 520 */     add(list, ItemListMF.bootsBronzePlate);
/* 521 */     add(list, ItemListMF.helmetIronPlate);
/* 522 */     add(list, ItemListMF.plateIronPlate);
/* 523 */     add(list, ItemListMF.legsIronPlate);
/* 524 */     add(list, ItemListMF.bootsIronPlate);
/* 525 */     add(list, ItemListMF.helmetGuildedPlate);
/* 526 */     add(list, ItemListMF.plateGuildedPlate);
/* 527 */     add(list, ItemListMF.legsGuildedPlate);
/* 528 */     add(list, ItemListMF.bootsGuildedPlate);
/* 529 */     add(list, ItemListMF.helmetSteelPlate);
/* 530 */     add(list, ItemListMF.plateSteelPlate);
/* 531 */     add(list, ItemListMF.legsSteelPlate);
/* 532 */     add(list, ItemListMF.bootsSteelPlate);
/* 533 */     add(list, ItemListMF.helmetEncrustedPlate);
/* 534 */     add(list, ItemListMF.plateEncrustedPlate);
/* 535 */     add(list, ItemListMF.legsEncrustedPlate);
/* 536 */     add(list, ItemListMF.bootsEncrustedPlate);
/* 537 */     add(list, ItemListMF.helmetDragonPlate);
/* 538 */     add(list, ItemListMF.plateDragonPlate);
/* 539 */     add(list, ItemListMF.legsDragonPlate);
/* 540 */     add(list, ItemListMF.bootsDragonPlate);
/* 541 */     add(list, ItemListMF.helmetDeepIronPlate);
/* 542 */     add(list, ItemListMF.plateDeepIronPlate);
/* 543 */     add(list, ItemListMF.legsDeepIronPlate);
/* 544 */     add(list, ItemListMF.bootsDeepIronPlate);
/* 545 */     add(list, ItemListMF.helmetMithrilPlate);
/* 546 */     add(list, ItemListMF.plateMithrilPlate);
/* 547 */     add(list, ItemListMF.legsMithrilPlate);
/* 548 */     add(list, ItemListMF.bootsMithrilPlate);
/* 549 */     add(list, ItemListMF.helmetStealth);
/* 550 */     add(list, ItemListMF.plateStealth);
/* 551 */     add(list, ItemListMF.legsStealth);
/* 552 */     add(list, ItemListMF.bootsStealth);
/*     */   }
/*     */   
/*     */   private void add(List list, Item item) {
/* 556 */     list.add(new ItemStack(item));
/*     */   }
/*     */   
/* 559 */   public static float[] armourSize = { 0.20833333F, 0.33333334F, 0.29166666F, 0.16666667F };
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemArmourMFOld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */