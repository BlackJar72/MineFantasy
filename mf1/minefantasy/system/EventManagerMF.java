/*     */ package minefantasy.system;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.MineFantasyAPI;
/*     */ import minefantasy.api.anvil.ITongs;
/*     */ import minefantasy.api.arrow.ISpecialBow;
/*     */ import minefantasy.api.forge.TongsHelper;
/*     */ import minefantasy.api.weapon.EnumWeaponType;
/*     */ import minefantasy.api.weapon.WeaponClass;
/*     */ import minefantasy.block.BlockSaplingMF;
/*     */ import minefantasy.entity.EntityArrowMF;
/*     */ import minefantasy.item.ItemBloom;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.item.weapon.ItemBowMF;
/*     */ import minefantasy.item.weapon.ItemWeaponMF;
/*     */ import mods.battlegear2.api.PlayerEventChild.QuiverArrowEvent.Firing;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityCreeper;
/*     */ import net.minecraft.entity.passive.EntityAnimal;
/*     */ import net.minecraft.entity.passive.EntityWolf;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.item.ItemTool;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.event.Event.Result;
/*     */ import net.minecraftforge.event.ForgeSubscribe;
/*     */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*     */ import net.minecraftforge.event.entity.PlaySoundAtEntityEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingAttackEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
/*     */ import net.minecraftforge.event.entity.player.ArrowLooseEvent;
/*     */ import net.minecraftforge.event.entity.player.ArrowNockEvent;
/*     */ import net.minecraftforge.event.entity.player.BonemealEvent;
/*     */ import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
/*     */ 
/*     */ public class EventManagerMF
/*     */ {
/*  60 */   public static String[] nonTendon = { "MoCEntityEnt" };
/*     */   
/*     */   @ForgeSubscribe
/*     */   public void entityDrop(LivingDropsEvent event) {
/*  64 */     Class enClass = event.entityLiving.getClass();
/*  65 */     String name = "";
/*  66 */     if ((enClass != null) && (EntityList.field_75626_c.get(enClass) != null)) {
/*  67 */       name = (String)EntityList.field_75626_c.get(enClass);
/*     */     }
/*     */     
/*     */ 
/*  71 */     if (((event.entityLiving instanceof EntityAnimal)) && (cfg.hardcoreCraft)) {
/*  72 */       boolean primitive = false;
/*  73 */       if ((event.source != null) && (event.source.func_76346_g() != null) && ((event.source.func_76346_g() instanceof EntityPlayer))) {
/*  74 */         primitive = isPrimitive(((EntityPlayer)event.source.func_76346_g()).func_70694_bm());
/*     */       }
/*     */       
/*  77 */       Random rand = event.entityLiving.func_70681_au();
/*  78 */       if (primitive) {
/*  79 */         for (String ent : nonTendon) {
/*  80 */           if (enClass.getName().endsWith(ent)) {
/*     */             break;
/*     */           }
/*  83 */           for (int a = 0; a < 1 + rand.nextInt(4); a++) {
/*  84 */             event.entityLiving.func_70099_a(new ItemStack(ItemListMF.misc, 1, 109), 1.0F);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  90 */     EntityLivingBase dropper = event.entityLiving;
/*     */     
/*  92 */     for (EntityItem item : event.drops) {
/*  93 */       if (item.func_92059_d().func_77969_a(new ItemStack(Item.field_77770_aF))) {
/*  94 */         item.func_70106_y();
/*     */         
/*  96 */         if ((name.equals("EntityHorse")) || (enClass.getName().endsWith("GaiaCentaur")) || (enClass.getName().endsWith("MoCEntityHorse")) || (enClass.getName().endsWith("MoCEntityHorseMob"))) {
/*  97 */           dropHide(event.lootingLevel, 154, dropper);
/*  98 */         } else if (enClass.getName().endsWith("EntityAtmosBison")) {
/*  99 */           dropHide(event.lootingLevel, 17, dropper);
/* 100 */         } else if (enClass.getName().endsWith("GaiaHunter")) {
/* 101 */           dropHide(event.lootingLevel, 4, dropper);
/* 102 */         } else if (enClass.getName().endsWith("MoCEntityFox")) {
/* 103 */           dropHide(event.lootingLevel, 33, dropper);
/* 104 */         } else if (enClass.getName().endsWith("EntityTroll")) {
/* 105 */           dropHide(event.lootingLevel, 33, dropper);
/* 106 */         } else if (name.equals("Cow")) {
/* 107 */           dropHide(event.lootingLevel, 17, dropper);
/*     */         }
/* 109 */         else if ((!enClass.getName().startsWith("net.minecraft")) && (!enClass.getName().startsWith("minefantasy"))) {
/* 110 */           FMLLog.warning("[MineFantasy] " + enClass.getName() + "is attempting to drop vanilla leather, report this to the developers", new Object[0]);
/* 111 */           dropHide(event.lootingLevel, 190, dropper);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 117 */     if (name.equals("Skeleton")) {
/* 118 */       for (EntityItem item : event.drops) {
/* 119 */         if (item.func_92059_d().func_77969_a(new ItemStack(Item.field_77705_m))) {
/* 120 */           item.func_92058_a(new ItemStack(ItemListMF.misc, 1, 91));
/* 121 */         } else if (item.func_92059_d().func_77969_a(new ItemStack(Item.field_77707_k))) {
/* 122 */           item.func_92058_a(new ItemStack(ItemListMF.shortbow));
/*     */         }
/*     */       }
/*     */     }
/* 126 */     if ((name.equals("Sheep")) || (name.toLowerCase().contains("sheep")) || (name.toLowerCase().contains("goat"))) {
/* 127 */       dropHide(event.lootingLevel, 6, dropper);
/*     */       
/* 129 */       if (cfg.dropMutton) {
/* 130 */         int amount = MineFantasyBase.isHOLoaded() ? 1 : dropper.func_70681_au().nextInt(3);
/*     */         
/* 132 */         if (event.lootingLevel > 0) {
/* 133 */           amount += dropper.func_70681_au().nextInt(event.lootingLevel);
/*     */         }
/*     */         
/* 136 */         ItemStack food = new ItemStack(dropper.func_70027_ad() ? ItemListMF.muttonCooked : ItemListMF.muttonRaw);
/*     */         
/* 138 */         if (food.field_77994_a > 0) {
/* 139 */           for (int a = 0; a < amount; a++)
/* 140 */             dropper.func_70099_a(food, 0.0F);
/*     */         }
/*     */       }
/*     */     }
/* 144 */     if (name.equals("Chicken")) {
/* 145 */       int amount = dropper.func_70681_au().nextInt(2) + 1 + dropper.func_70681_au().nextInt(1 + event.lootingLevel);
/*     */       
/* 147 */       ItemStack featherdrop = new ItemStack(Item.field_77676_L);
/* 148 */       if (featherdrop.field_77994_a > 0)
/* 149 */         for (int a = 0; a < amount; a++)
/* 150 */           dropper.func_70099_a(featherdrop, 0.0F);
/*     */     }
/* 152 */     if (name.equals("Blaze"))
/*     */     {
/* 154 */       int amount = 1 + dropper.func_70681_au().nextInt(1 + event.lootingLevel);
/*     */       
/* 156 */       ItemStack hellDrop = new ItemStack(ItemListMF.misc, 1, 91);
/* 157 */       if (hellDrop.field_77994_a > 0) {
/* 158 */         for (int a = 0; a < amount; a++) {
/* 159 */           dropper.func_70099_a(hellDrop, 0.0F);
/*     */         }
/*     */       }
/*     */     }
/* 163 */     if ((enClass.getName().endsWith("MoCEntityBoar")) || (enClass.getName().endsWith("MoCEntityDeer"))) {
/* 164 */       ItemStack drop = new ItemStack(Item.field_77784_aq);
/* 165 */       if (event.entityLiving.func_70027_ad())
/* 166 */         drop = new ItemStack(Item.field_77782_ar);
/* 167 */       int num = event.lootingLevel + event.entityLiving.func_70681_au().nextInt(2);
/* 168 */       for (int a = 0; a < num; a++) {
/* 169 */         event.entityLiving.func_70099_a(drop, 0.0F);
/*     */       }
/*     */     }
/* 172 */     if (enClass.getName().endsWith("MoCEntityFishy")) {
/* 173 */       ItemStack drop = new ItemStack(Item.field_77754_aU);
/* 174 */       if (event.entityLiving.func_70027_ad())
/* 175 */         drop = new ItemStack(Item.field_77753_aV);
/* 176 */       event.entityLiving.func_70099_a(drop, 0.0F);
/*     */     }
/*     */     
/* 179 */     if ((event.entityLiving instanceof EntityWolf))
/*     */     {
/*     */ 
/*     */ 
/* 183 */       dropHide(event.lootingLevel, 33, dropper);
/*     */     }
/*     */   }
/*     */   
/*     */   private void dropHide(int loot, int hide, EntityLivingBase dropper) {
/* 188 */     int amount = 1 + dropper.func_70681_au().nextInt(1 + loot);
/*     */     
/* 190 */     ItemStack leatherdrop = new ItemStack(ItemListMF.misc, 1, hide);
/*     */     
/* 192 */     if (leatherdrop.field_77994_a > 0)
/* 193 */       for (int a = 0; a < amount; a++)
/* 194 */         dropper.func_70099_a(leatherdrop, 0.0F);
/*     */   }
/*     */   
/*     */   @ForgeSubscribe
/*     */   public void itemEvent(EntityItemPickupEvent event) {
/* 199 */     EntityPlayer player = event.entityPlayer;
/*     */     
/* 201 */     EntityItem drop = event.item;
/* 202 */     ItemStack item = drop.func_92059_d();
/* 203 */     ItemStack held = player.func_70694_bm();
/*     */     
/* 205 */     if ((held != null) && ((held.func_77973_b() instanceof ITongs)) && 
/* 206 */       (!TongsHelper.hasHeldItem(held)) && 
/* 207 */       (isHotItem(item)) && 
/* 208 */       (TongsHelper.trySetHeldItem(held, item))) {
/* 209 */       drop.func_70106_y();
/*     */       
/* 211 */       if (event.isCancelable()) {
/* 212 */         event.setCanceled(true);
/*     */       }
/* 214 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 220 */     if ((cfg.burnPlayer) && (item != null) && (isHotItem(item)) && 
/* 221 */       (event.isCancelable())) {
/* 222 */       event.setCanceled(true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean isPrimitive(ItemStack heldItem)
/*     */   {
/* 229 */     if (heldItem == null) {
/* 230 */       return true;
/*     */     }
/* 232 */     if (heldItem.func_77969_a(ItemListMF.component(108))) {
/* 233 */       return true;
/*     */     }
/* 235 */     if ((heldItem.field_77993_c == Item.field_77711_v.field_77779_bT) || (heldItem.field_77993_c == Item.field_77715_r.field_77779_bT)) {
/* 236 */       return true;
/*     */     }
/* 238 */     if (heldItem.func_77973_b() != null) {
/* 239 */       if ((heldItem.func_77973_b() instanceof IPublicMaterialItem)) {
/* 240 */         EnumToolMaterial mat = ((IPublicMaterialItem)heldItem.func_77973_b()).getMaterial();
/* 241 */         return (mat == EnumToolMaterial.STONE) || (mat == EnumToolMaterial.WOOD) || (mat == ToolMaterialMedieval.PRIMITIVE_COPPER) || (mat == ToolMaterialMedieval.PRIMITIVE_STONE);
/*     */       }
/* 243 */       if ((heldItem.func_77973_b() instanceof ItemWeaponMF)) {
/* 244 */         return ((ItemWeaponMF)heldItem.func_77973_b()).isPrimitive();
/*     */       }
/*     */     }
/* 247 */     return false;
/*     */   }
/*     */   
/*     */   @ForgeSubscribe
/*     */   public void setTarget(LivingSetAttackTargetEvent event) {
/* 252 */     if ((event.entity != null) && (event.target != null)) {
/* 253 */       if ((event.entityLiving.func_70685_l(event.target)) && 
/* 254 */         (!TacticalManager.isDetected(event.target, event.entityLiving))) {
/* 255 */         if (event.isCancelable()) {
/* 256 */           event.setCanceled(true);
/*     */         }
/* 258 */         else if ((event.entityLiving instanceof EntityLiving)) {
/* 259 */           ((EntityLiving)event.entityLiving).func_70624_b(null);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 264 */       if (((event.entityLiving instanceof EntityCreeper)) && (!(event.target instanceof EntityPlayer))) {
/* 265 */         if (event.isCancelable()) {
/* 266 */           event.setCanceled(true);
/*     */         }
/* 268 */         else if ((event.entityLiving instanceof EntityLiving)) {
/* 269 */           ((EntityLiving)event.entityLiving).func_70624_b(null);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static String getType(String type, EnumWeaponType wC) {
/* 276 */     if ((wC == EnumWeaponType.AXE) || (wC == EnumWeaponType.BIGAXE) || (wC == EnumWeaponType.BIGBLADE) || (wC == EnumWeaponType.BIGPOLEARM) || (wC == EnumWeaponType.LONGBLADE) || (wC == EnumWeaponType.MEDBLADE) || (wC == EnumWeaponType.POLEARM) || (wC == EnumWeaponType.SMLAXE) || (wC == EnumWeaponType.SMLBLADE) || (wC == EnumWeaponType.STAFF))
/*     */     {
/* 278 */       return "blade";
/*     */     }
/* 280 */     return "blunt";
/*     */   }
/*     */   
/*     */   public static void makeHitSound(ItemStack weapon, Entity target) {
/* 284 */     if (!cfg.hitSound) {
/* 285 */       return;
/*     */     }
/* 287 */     if (weapon != null) {
/* 288 */       EnumWeaponType WC = WeaponClass.getClassFor(weapon);
/* 289 */       String material = "metal";
/* 290 */       String type = "blunt";
/*     */       
/* 292 */       material = getMaterial(material, weapon.func_77973_b());
/* 293 */       if (WC != null) {
/* 294 */         type = getType(type, WC);
/* 295 */         String sndString = MFResource.sound("Weapon.hit." + type + "." + material + "_");
/*     */         
/* 297 */         float volume = 1.0F;
/* 298 */         target.func_85030_a(sndString, 1.0F, 1.0F);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static String getMaterial(String material, Item item)
/*     */   {
/* 305 */     if ((item instanceof ItemTool)) {
/* 306 */       if (((ItemTool)item).func_77861_e().equalsIgnoreCase("WOOD")) {
/* 307 */         material = "wood";
/*     */       }
/* 309 */       if (((ItemTool)item).func_77861_e().equalsIgnoreCase("STONE")) {
/* 310 */         material = "stone";
/*     */       }
/*     */     }
/*     */     
/* 314 */     if ((item instanceof ItemSword)) {
/* 315 */       if (((ItemSword)item).func_77825_f().equalsIgnoreCase("WOOD")) {
/* 316 */         material = "wood";
/*     */       }
/* 318 */       if (((ItemSword)item).func_77825_f().equalsIgnoreCase("STONE")) {
/* 319 */         material = "stone";
/*     */       }
/*     */     }
/*     */     
/* 323 */     if ((item instanceof IPublicMaterialItem)) {
/* 324 */       EnumToolMaterial mat = ((IPublicMaterialItem)item).getMaterial();
/*     */       
/* 326 */       if (mat == ToolMaterialMedieval.PRIMITIVE_STONE) {
/* 327 */         material = "stone";
/*     */       }
/*     */     }
/* 330 */     return material;
/*     */   }
/*     */   
/*     */   public void readyBow(ArrowNockEvent event) {
/* 334 */     if (MineFantasyBase.isBGLoaded()) {
/* 335 */       return;
/*     */     }
/* 337 */     EntityPlayer player = event.entityPlayer;
/* 338 */     ItemStack bow = event.result;
/* 339 */     boolean infinite = (player.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, bow) > 0);
/*     */     
/* 341 */     for (ItemStack arrow : ArrowsMF.useableArrows) {
/* 342 */       if (player.field_71071_by.func_70431_c(arrow)) {
/* 343 */         player.func_71008_a(bow, bow.func_77988_m());
/* 344 */         ItemBowMF.loadArrow(player, bow, arrow, true);
/* 345 */         event.setCanceled(true);
/* 346 */         return;
/*     */       }
/*     */     }
/*     */     
/* 350 */     if (infinite) {
/* 351 */       player.func_71008_a(bow, bow.func_77988_m());
/* 352 */       ItemBowMF.loadArrow(player, bow, new ItemStack(Item.field_77704_l), true);
/* 353 */       event.setCanceled(true);
/* 354 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   public void fireArrow(ArrowLooseEvent event)
/*     */   {
/* 360 */     if (MineFantasyBase.isBGLoaded()) {
/* 361 */       return;
/*     */     }
/*     */     
/* 364 */     ItemStack bow = event.bow;
/* 365 */     float charge = event.charge;
/* 366 */     EntityPlayer player = event.entityPlayer;
/* 367 */     World world = event.entity.field_70170_p;
/*     */     
/* 369 */     ItemBowMF.loadArrow(player, bow, null, true);
/*     */     
/* 371 */     for (ItemStack arrow : ArrowsMF.useableArrows) {
/* 372 */       if (shootSpecificArrow(bow, world, player, charge, arrow)) {
/* 373 */         event.setCanceled(true);
/* 374 */         return;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @ForgeSubscribe
/*     */   public void playWorldSound(PlaySoundAtEntityEvent event) {
/* 381 */     if ((event != null) && (event.name != null) && 
/* 382 */       (event.name.equalsIgnoreCase("random.bow"))) {
/* 383 */       event.name = "minefantasy:oldbow";
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean shootSpecificArrow(ItemStack item, World world, EntityPlayer player, float power, ItemStack ammo)
/*     */   {
/* 389 */     boolean infinite = (player.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/* 390 */     Random itemRand = new Random();
/* 391 */     if (player.field_71071_by.func_70431_c(ammo)) {
/* 392 */       float charge = power / 20.0F;
/* 393 */       charge = (charge * charge + charge * 2.0F) / 3.0F;
/*     */       
/* 395 */       if (charge < 0.1D) {
/* 396 */         return false;
/*     */       }
/*     */       
/* 399 */       if (charge > 1.0F) {
/* 400 */         charge = 1.0F;
/*     */       }
/*     */       
/* 403 */       float force = 2.0F;
/* 404 */       EntityArrowMF arrow = new EntityArrowMF(world, player, charge * 2.0F, ammo.func_77960_j());
/*     */       
/* 406 */       if (charge == 1.0F) {
/* 407 */         arrow.func_70243_d(true);
/*     */       }
/*     */       
/* 410 */       int var9 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, item);
/*     */       
/* 412 */       if (var9 > 0) {
/* 413 */         arrow.func_70239_b(arrow.func_70242_d() + var9 * 0.5D + 0.5D);
/*     */       }
/*     */       
/* 416 */       int var10 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, item);
/*     */       
/* 418 */       if (var10 > 0) {
/* 419 */         arrow.func_70240_a(var10);
/*     */       }
/*     */       
/* 422 */       if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, item) > 0) {
/* 423 */         arrow.func_70015_d(100);
/*     */       }
/*     */       
/* 426 */       if (!player.field_71075_bZ.field_75098_d) {
/* 427 */         item.func_77972_a(1, player);
/*     */       }
/*     */       
/* 430 */       if (!infinite) {
/* 431 */         consumePlayerItem(player, ammo);
/*     */       } else {
/* 433 */         arrow.field_70251_a = 2;
/*     */       }
/* 435 */       world.func_72956_a(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + charge * 0.5F);
/*     */       
/* 437 */       if (!world.field_72995_K) {
/* 438 */         world.func_72838_d(arrow);
/*     */       }
/* 440 */       return true;
/*     */     }
/* 442 */     return false;
/*     */   }
/*     */   
/*     */   @ForgeSubscribe
/*     */   public void hurtEntity(LivingHurtEvent event) {
/* 447 */     CombatManager.onAttack(event);
/*     */   }
/*     */   
/*     */   @ForgeSubscribe
/*     */   public void onAttack(LivingAttackEvent event) {
/* 452 */     Entity source = event.source.func_76364_f();
/*     */     
/* 454 */     if ((source != null) && ((source instanceof EntityLiving)) && (!event.source.func_76352_a())) {
/* 455 */       EntityLiving attacker = (EntityLiving)source;
/*     */       
/* 457 */       PotionEffect affliction = attacker.func_70660_b(Potion.field_76431_k);
/*     */       
/* 459 */       if (affliction != null) {
/* 460 */         Random rand = attacker.func_70681_au();
/* 461 */         int tier = affliction.func_76458_c();
/*     */         
/* 463 */         if (rand.nextInt(5) <= tier) {
/* 464 */           event.setCanceled(true);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @ForgeSubscribe
/*     */   public void fertellise(BonemealEvent event) {
/* 472 */     World world = event.world;
/* 473 */     EntityPlayer player = event.entityPlayer;
/* 474 */     int x = event.X;
/* 475 */     int y = event.Y;
/* 476 */     int z = event.Z;
/* 477 */     int id = event.ID;
/* 478 */     ItemStack item = player.func_70694_bm();
/* 479 */     int meta = world.func_72805_g(x, y, z);
/*     */     
/* 481 */     if (id == MineFantasyBase.MFBlockSapling.field_71990_ca) {
/* 482 */       if ((!world.field_72995_K) && 
/* 483 */         (world.field_73012_v.nextFloat() < ((BlockSaplingMF)MineFantasyBase.MFBlockSapling).getBonemealChance(meta))) {
/* 484 */         ((BlockSaplingMF)MineFantasyBase.MFBlockSapling).markOrGrowMarked(world, x, y, z, world.field_73012_v);
/*     */       }
/*     */       
/*     */ 
/* 488 */       event.setResult(Event.Result.ALLOW);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean consumePlayerItem(EntityPlayer player, ItemStack item) {
/* 493 */     for (int a = 0; a < player.field_71071_by.func_70302_i_(); a++) {
/* 494 */       ItemStack i = player.field_71071_by.func_70301_a(a);
/* 495 */       if ((i != null) && (i.func_77969_a(item))) {
/* 496 */         player.field_71071_by.func_70298_a(a, 1);
/* 497 */         return true;
/*     */       }
/*     */     }
/* 500 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isHotItem(ItemStack item) {
/* 504 */     return (item != null) && (((item.func_77973_b() instanceof minefantasy.item.ItemHotItem)) || ((item.func_77973_b() instanceof ItemBloom)) || (MineFantasyAPI.isHotToPickup(item)));
/*     */   }
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
/*     */   @ForgeSubscribe
/*     */   public void fireMBArrow(PlayerEventChild.QuiverArrowEvent.Firing event)
/*     */   {
/* 525 */     ItemStack bow = event.getBow();
/* 526 */     EntityArrow arrow = event.arrow;
/*     */     
/* 528 */     if ((bow != null) && (bow.func_77973_b() != null) && ((bow.func_77973_b() instanceof ISpecialBow))) {
/* 529 */       arrow = (EntityArrow)((ISpecialBow)bow.func_77973_b()).modifyArrow(arrow);
/*     */     }
/*     */   }
/*     */   
/*     */   @ForgeSubscribe
/*     */   public void onEntityJoinWorld(EntityJoinWorldEvent event) {
/* 535 */     if ((event.entity instanceof EntityArrow)) {
/* 536 */       EntityArrow arrow = (EntityArrow)event.entity;
/* 537 */       if ((arrow.field_70250_c != null) && ((arrow.field_70250_c instanceof EntityLiving))) {
/* 538 */         EntityLiving attacker = (EntityLiving)arrow.field_70250_c;
/*     */         
/* 540 */         PotionEffect affliction = attacker.func_70660_b(Potion.field_76431_k);
/*     */         
/* 542 */         if (affliction != null) {
/* 543 */           Random rand = attacker.func_70681_au();
/* 544 */           float tier = affliction.func_76458_c() + 5.0F;
/*     */           
/* 546 */           arrow.field_70159_w *= (1.0F + (rand.nextFloat() * 0.2F - 0.1F) * tier);
/* 547 */           arrow.field_70181_x *= (1.0F + (rand.nextFloat() * 0.2F - 0.1F) * tier);
/* 548 */           arrow.field_70179_y *= (1.0F + (rand.nextFloat() * 0.2F - 0.1F) * tier);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/system/EventManagerMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */