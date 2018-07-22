/*     */ package minefantasy.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.weapon.ICustomDamager;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockCauldron;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumMovingObjectType;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.GameRules;
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
/*     */ public class ItemMedievalComponent
/*     */   extends ItemMedieval
/*     */   implements ICustomDamager
/*     */ {
/*  41 */   private int length = 191;
/*     */   private Icon[] icons;
/*     */   
/*     */   public ItemMedievalComponent(int i) {
/*  45 */     super(i, false, 64);
/*  46 */     func_77637_a(ItemListMF.tabMedieval);
/*  47 */     func_77627_a(true);
/*  48 */     func_77656_e(0);
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {
/*  52 */     for (int n = 0; n < this.length; n++) {
/*  53 */       ItemStack item = new ItemStack(id, 1, n);
/*  54 */       if (!getUnlocalisedName(item).endsWith("unused")) {
/*  55 */         list.add(item);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public Icon func_77617_a(int id) {
/*  61 */     return this.icons[id];
/*     */   }
/*     */   
/*     */ 
/*     */   public String func_77628_j(ItemStack item)
/*     */   {
/*  67 */     return StatCollector.func_74838_a("item.mfmisc." + getUnlocalisedName(item));
/*     */   }
/*     */   
/*     */   public String getUnlocalisedName(ItemStack item) {
/*  71 */     int type = item.func_77960_j();
/*  72 */     if (type == 0) {
/*  73 */       return "flux";
/*     */     }
/*  75 */     if (type == 1) {
/*  76 */       return "splintBronze";
/*     */     }
/*  78 */     if (type == 2) {
/*  79 */       return "lumpIron";
/*     */     }
/*  81 */     if (type == 3) {
/*  82 */       return "hidePig";
/*     */     }
/*  84 */     if (type == 4) {
/*  85 */       return "leather.raw";
/*     */     }
/*  87 */     if (type == 5) {
/*  88 */       return "leather.salt";
/*     */     }
/*  90 */     if (type == 6) {
/*  91 */       return "hideSheep";
/*     */     }
/*  93 */     if (type == 7) {
/*  94 */       return "leather.rough";
/*     */     }
/*  96 */     if (type == 8) {
/*  97 */       return "leather.gore";
/*     */     }
/*  99 */     if (type == 9) {
/* 100 */       return "padding";
/*     */     }
/* 102 */     if (type == 10) {
/* 103 */       return "salt";
/*     */     }
/* 105 */     if (type == 11) {
/* 106 */       return "slag";
/*     */     }
/* 108 */     if (type == 12) {
/* 109 */       return "slagSmall";
/*     */     }
/* 111 */     if (type == 13) {
/* 112 */       return "linkIron";
/*     */     }
/* 114 */     if (type == 14) {
/* 115 */       return "coke";
/*     */     }
/* 117 */     if (type == 15) {
/* 118 */       return "coalPowder";
/*     */     }
/* 120 */     if (type == 16) {
/* 121 */       return "paperSalt";
/*     */     }
/* 123 */     if (type == 17) {
/* 124 */       return "hideCow";
/*     */     }
/* 126 */     if (type == 18) {
/* 127 */       return "linkBronze";
/*     */     }
/* 129 */     if (type == 19) {
/* 130 */       return "fireGland";
/*     */     }
/* 132 */     if (type == 20) {
/* 133 */       return "fireDust";
/*     */     }
/* 135 */     if (type == 21) {
/* 136 */       return "ingotDragonImp";
/*     */     }
/* 138 */     if (type == 22) {
/* 139 */       return "ingotDragon";
/*     */     }
/* 141 */     if (type == 23) {
/* 142 */       return "featherArrow";
/*     */     }
/* 144 */     if (type == 24) {
/* 145 */       return "sulfur";
/*     */     }
/* 147 */     if (type == 25) {
/* 148 */       return "plankIronbark";
/*     */     }
/* 150 */     if (type == 26) {
/* 151 */       return "stripLeather";
/*     */     }
/* 153 */     if (type == 27) {
/* 154 */       return "beltLeather";
/*     */     }
/* 156 */     if (type == 28) {
/* 157 */       return "plateSteelSmall";
/*     */     }
/* 159 */     if (type == 29) {
/* 160 */       return "plateSteelCurve";
/*     */     }
/* 162 */     if (type == 30) {
/* 163 */       return "splintSteel";
/*     */     }
/* 165 */     if (type == 31) {
/* 166 */       return "scaleSteel";
/*     */     }
/* 168 */     if (type == 32) {
/* 169 */       return "unused";
/*     */     }
/*     */     
/* 172 */     if (type == 33) {
/* 173 */       return "hideHound";
/*     */     }
/* 175 */     if (type == 34) {
/* 176 */       return "unused";
/*     */     }
/* 178 */     if (type == 35) {
/* 179 */       return "unused";
/*     */     }
/*     */     
/* 182 */     if (type == 36) {
/* 183 */       return "scaleBronze";
/*     */     }
/* 185 */     if (type == 37) {
/* 186 */       return "scaleIron";
/*     */     }
/* 188 */     if (type == 38) {
/* 189 */       return "scaleMithril";
/*     */     }
/* 191 */     if (type == 39) {
/* 192 */       return "scaleDragonforge";
/*     */     }
/* 194 */     if (type == 40) {
/* 195 */       return "linkSteel";
/*     */     }
/* 197 */     if (type == 41) {
/* 198 */       return "chainSteel";
/*     */     }
/*     */     
/* 201 */     if (type == 42) {
/* 202 */       return "linkMithril";
/*     */     }
/* 204 */     if (type == 43) {
/* 205 */       return "chainMithril";
/*     */     }
/* 207 */     if (type == 44) {
/* 208 */       return "linkDragonforge";
/*     */     }
/*     */     
/* 211 */     if (type == 45) {
/* 212 */       return "chainDragonforge";
/*     */     }
/* 214 */     if (type == 46) {
/* 215 */       return "splintIron";
/*     */     }
/* 217 */     if (type == 47) {
/* 218 */       return "splintDragonforge";
/*     */     }
/* 220 */     if (type == 48) {
/* 221 */       return "coinGold";
/*     */     }
/* 223 */     if (type == 49) {
/* 224 */       return "coinSilver";
/*     */     }
/* 226 */     if (type == 50) {
/* 227 */       return "dustIgnotumite";
/*     */     }
/* 229 */     if (type == 51) {
/* 230 */       return "unused";
/*     */     }
/* 232 */     if (type == 52) {
/* 233 */       return "ingotIgnotumiteImpure";
/*     */     }
/* 235 */     if (type == 53) {
/* 236 */       return "oreMithril";
/*     */     }
/* 238 */     if (type == 54) {
/* 239 */       return "mithrilRefined";
/*     */     }
/* 241 */     if (type == 55) {
/* 242 */       return "ingotMithril";
/*     */     }
/* 244 */     if (type == 56) {
/* 245 */       return "ingotCopper";
/*     */     }
/* 247 */     if (type == 57) {
/* 248 */       return "ingotTin";
/*     */     }
/* 250 */     if (type == 58) {
/* 251 */       return "ingotBronze";
/*     */     }
/* 253 */     if (type == 59) {
/* 254 */       return "haft";
/*     */     }
/* 256 */     if (type == 60) {
/* 257 */       return "ingotWroughtIron";
/*     */     }
/* 259 */     if (type == 61) {
/* 260 */       return "plateIron";
/*     */     }
/* 262 */     if (type == 62) {
/* 263 */       return "splintMithril";
/*     */     }
/* 265 */     if (type == 63) {
/* 266 */       return "plateIronSmall";
/*     */     }
/* 268 */     if (type == 64) {
/* 269 */       return "coinCopper";
/*     */     }
/* 271 */     if (type == 65) {
/* 272 */       return "haftStrong";
/*     */     }
/* 274 */     if (type == 66) {
/* 275 */       return "limestone";
/*     */     }
/* 277 */     if (type == 67) {
/* 278 */       return "plateIronCurve";
/*     */     }
/*     */     
/* 281 */     if (type == 68) {
/* 282 */       return "plateEncrusted";
/*     */     }
/* 284 */     if (type == 69) {
/* 285 */       return "plateEncrustedSmall";
/*     */     }
/* 287 */     if (type == 70) {
/* 288 */       return "plateEncrustedCurve";
/*     */     }
/* 290 */     if (type == 71) {
/* 291 */       return "unused";
/*     */     }
/* 293 */     if (type == 72) {
/* 294 */       return "plateBronze";
/*     */     }
/* 296 */     if (type == 73) {
/* 297 */       return "plateBronzeSmall";
/*     */     }
/* 299 */     if (type == 74) {
/* 300 */       return "plateBronzeCurve";
/*     */     }
/* 302 */     if (type == 75) {
/* 303 */       return "unused";
/*     */     }
/* 305 */     if (type == 76) {
/* 306 */       return "chainBronze";
/*     */     }
/*     */     
/* 309 */     if (type == 77) {
/* 310 */       return "haftIronbark";
/*     */     }
/* 312 */     if (type == 78) {
/* 313 */       return "oreIron";
/*     */     }
/* 315 */     if (type == 79) {
/* 316 */       return "oreGold";
/*     */     }
/* 318 */     if (type == 80) {
/* 319 */       return "oreSilver";
/*     */     }
/* 321 */     if (type == 81) {
/* 322 */       return "haftOrnate";
/*     */     }
/* 324 */     if (type == 82) {
/* 325 */       return "oreCopper";
/*     */     }
/* 327 */     if (type == 83) {
/* 328 */       return "haftEbony";
/*     */     }
/* 330 */     if (type == 84) {
/* 331 */       return "oreTin";
/*     */     }
/* 333 */     if (type == 85) {
/* 334 */       return "leatherStud";
/*     */     }
/* 336 */     if (type == 86) {
/* 337 */       return "unused";
/*     */     }
/* 339 */     if (type == 87) {
/* 340 */       return "stickIronbark";
/*     */     }
/* 342 */     if (type == 88) {
/* 343 */       return "glueWeak";
/*     */     }
/* 345 */     if (type == 89) {
/* 346 */       return "glueStrong";
/*     */     }
/* 348 */     if (type == 90) {
/* 349 */       return "coalInferno";
/*     */     }
/* 351 */     if (type == 91) {
/* 352 */       return "coalHell";
/*     */     }
/* 354 */     if (type == 92) {
/* 355 */       return "coalSlow";
/*     */     }
/* 357 */     if (type == 93) {
/* 358 */       return "unused";
/*     */     }
/* 360 */     if (type == 94) {
/* 361 */       return "unused";
/*     */     }
/* 363 */     if (type == 95) {
/* 364 */       return "plateMithril";
/*     */     }
/* 366 */     if (type == 96) {
/* 367 */       return "plateMithrilSmall";
/*     */     }
/* 369 */     if (type == 97) {
/* 370 */       return "plateMithrilCurve";
/*     */     }
/*     */     
/* 373 */     if (type == 98) {
/* 374 */       return "hideMinotaur";
/*     */     }
/* 376 */     if (type == 99) {
/* 377 */       return "unused";
/*     */     }
/* 379 */     if (type == 100) {
/* 380 */       return "unused";
/*     */     }
/*     */     
/* 383 */     if (type == 101) {
/* 384 */       return "hideDrake";
/*     */     }
/* 386 */     if (type == 102) {
/* 387 */       return "unused";
/*     */     }
/* 389 */     if (type == 103) {
/* 390 */       return "unused";
/*     */     }
/* 392 */     if (type == 104) {
/* 393 */       return "leatherBlack";
/*     */     }
/* 395 */     if (type == 105) {
/* 396 */       return "crossbowMech";
/*     */     }
/* 398 */     if (type == 106) {
/* 399 */       return "crossbowMech.repeat";
/*     */     }
/* 401 */     if (type == 107) {
/* 402 */       return "crossbowBolts";
/*     */     }
/* 404 */     if (type == 108) {
/* 405 */       return "rockSharp";
/*     */     }
/* 407 */     if (type == 109) {
/* 408 */       return "tendon";
/*     */     }
/* 410 */     if (type == 110) {
/* 411 */       return "vine";
/*     */     }
/* 413 */     if (type == 111) {
/* 414 */       return "shale";
/*     */     }
/* 416 */     if (type == 112) {
/* 417 */       return "unused";
/*     */     }
/* 419 */     if (type == 113) {
/* 420 */       return "shardCopper";
/*     */     }
/* 422 */     if (type == 114) {
/* 423 */       return "plankEbony";
/*     */     }
/* 425 */     if (type == 115) {
/* 426 */       return "unused";
/*     */     }
/* 428 */     if (type == 116) {
/* 429 */       return "chainIron";
/*     */     }
/* 431 */     if (type == 117) {
/* 432 */       return "plateSteel";
/*     */     }
/* 434 */     if (type == 118) {
/* 435 */       return "plateDragonforge";
/*     */     }
/* 437 */     if (type == 119) {
/* 438 */       return "plateDragonforgeSmall";
/*     */     }
/* 440 */     if (type == 120) {
/* 441 */       return "plateDragonforgeCurve";
/*     */     }
/* 443 */     if (type == 121) {
/* 444 */       return "unused";
/*     */     }
/* 446 */     if (type == 122) {
/* 447 */       return "lumpBronze";
/*     */     }
/* 449 */     if (type == 123) {
/* 450 */       return "lumpSteel";
/*     */     }
/* 452 */     if (type == 124) {
/* 453 */       return "lumpMithril";
/*     */     }
/* 455 */     if (type == 125) {
/* 456 */       return "buckle";
/*     */     }
/* 458 */     if (type == 126) {
/* 459 */       return "stickEbony";
/*     */     }
/*     */     
/* 462 */     if (type == 127) {
/* 463 */       return "arrowheadBronze";
/*     */     }
/* 465 */     if (type == 128) {
/* 466 */       return "arrowheadIron";
/*     */     }
/* 468 */     if (type == 129) {
/* 469 */       return "arrowheadSteel";
/*     */     }
/* 471 */     if (type == 130) {
/* 472 */       return "arrowheadMithril";
/*     */     }
/* 474 */     if (type == 131) {
/* 475 */       return "arrowheadSilver";
/*     */     }
/* 477 */     if (type == 132) {
/* 478 */       return "arrowheadEncrusted";
/*     */     }
/* 480 */     if (type == 133) {
/* 481 */       return "arrowheadDragonforge";
/*     */     }
/* 483 */     if (type == 134) {
/* 484 */       return "arrowheadIgnotumite";
/*     */     }
/*     */     
/* 487 */     if (type == 135) {
/* 488 */       return "broadheadBronze";
/*     */     }
/* 490 */     if (type == 136) {
/* 491 */       return "broadheadIron";
/*     */     }
/* 493 */     if (type == 137) {
/* 494 */       return "broadheadSteel";
/*     */     }
/* 496 */     if (type == 138) {
/* 497 */       return "broadheadMithril";
/*     */     }
/* 499 */     if (type == 139) {
/* 500 */       return "broadheadSilver";
/*     */     }
/* 502 */     if (type == 140) {
/* 503 */       return "broadheadEncrusted";
/*     */     }
/* 505 */     if (type == 141) {
/* 506 */       return "broadheadDragonforge";
/*     */     }
/* 508 */     if (type == 142) {
/* 509 */       return "broadheadIgnotumite";
/*     */     }
/*     */     
/* 512 */     if (type == 143) {
/* 513 */       return "bodkinheadBronze";
/*     */     }
/* 515 */     if (type == 144) {
/* 516 */       return "bodkinheadIron";
/*     */     }
/* 518 */     if (type == 145) {
/* 519 */       return "bodkinheadSteel";
/*     */     }
/* 521 */     if (type == 146) {
/* 522 */       return "bodkinheadMithril";
/*     */     }
/* 524 */     if (type == 147) {
/* 525 */       return "bodkinheadSilver";
/*     */     }
/* 527 */     if (type == 148) {
/* 528 */       return "bodkinheadEncrusted";
/*     */     }
/* 530 */     if (type == 149) {
/* 531 */       return "bodkinheadDragonforge";
/*     */     }
/* 533 */     if (type == 150) {
/* 534 */       return "bodkinheadIgnotumite";
/*     */     }
/* 536 */     if (type == 151) {
/* 537 */       return "twine";
/*     */     }
/* 539 */     if (type == 152) {
/* 540 */       return "hunkIgnotumite";
/*     */     }
/* 542 */     if (type == 153) {
/* 543 */       return "ingotIgnotumite";
/*     */     }
/* 545 */     if (type == 154) {
/* 546 */       return "hideHorse";
/*     */     }
/* 548 */     if (type == 155) {
/* 549 */       return "unused";
/*     */     }
/* 551 */     if (type == 156) {
/* 552 */       return "unused";
/*     */     }
/* 554 */     if (type == 157) {
/* 555 */       return "hideBasilisk.blue";
/*     */     }
/* 557 */     if (type == 158) {
/* 558 */       return "unused";
/*     */     }
/* 560 */     if (type == 159) {
/* 561 */       return "unused";
/*     */     }
/* 563 */     if (type == 160) {
/* 564 */       return "hideBasilisk.brown";
/*     */     }
/* 566 */     if (type == 161) {
/* 567 */       return "unused";
/*     */     }
/* 569 */     if (type == 162) {
/* 570 */       return "unused";
/*     */     }
/* 572 */     if (type == 163) {
/* 573 */       return "hideBasilisk.black";
/*     */     }
/* 575 */     if (type == 164) {
/* 576 */       return "unused";
/*     */     }
/* 578 */     if (type == 165) {
/* 579 */       return "unused";
/*     */     }
/* 581 */     if (type == 166) {
/* 582 */       return "nuggetSteel";
/*     */     }
/* 584 */     if (type == 167) {
/* 585 */       return "ingotGoldPure";
/*     */     }
/* 587 */     if (type == 168) {
/* 588 */       return "scaleGuilded";
/*     */     }
/* 590 */     if (type == 169) {
/* 591 */       return "linkGuilded";
/*     */     }
/* 593 */     if (type == 170) {
/* 594 */       return "chainGuilded";
/*     */     }
/* 596 */     if (type == 171) {
/* 597 */       return "splintGuilded";
/*     */     }
/* 599 */     if (type == 172) {
/* 600 */       return "plateGuildedSmall";
/*     */     }
/* 602 */     if (type == 173) {
/* 603 */       return "plateGuilded";
/*     */     }
/* 605 */     if (type == 174) {
/* 606 */       return "plateGuildedCurve";
/*     */     }
/* 608 */     if (type == 175) {
/* 609 */       return "unused";
/*     */     }
/* 611 */     if (type == 176) {
/* 612 */       return "shrapnel";
/*     */     }
/* 614 */     if (type == 177) {
/* 615 */       return "nitre";
/*     */     }
/*     */     
/* 618 */     if (type == 178) {
/* 619 */       return "scaleDeepIron";
/*     */     }
/* 621 */     if (type == 179) {
/* 622 */       return "linkDeepIron";
/*     */     }
/* 624 */     if (type == 180) {
/* 625 */       return "chainDeepIron";
/*     */     }
/* 627 */     if (type == 181) {
/* 628 */       return "splintDeepIron";
/*     */     }
/* 630 */     if (type == 182) {
/* 631 */       return "plateDeepIron";
/*     */     }
/* 633 */     if (type == 183) {
/* 634 */       return "plateDeepIronCurve";
/*     */     }
/* 636 */     if (type == 184) {
/* 637 */       return "plateDeepIronSmall";
/*     */     }
/* 639 */     if (type == 185) {
/* 640 */       return "ingotDeepIron";
/*     */     }
/*     */     
/* 643 */     if (type == 186) {
/* 644 */       return "lumpDeepIron";
/*     */     }
/* 646 */     if (type == 187) {
/* 647 */       return "bodkinheadDeepIron";
/*     */     }
/* 649 */     if (type == 188) {
/* 650 */       return "broadheadDeepIron";
/*     */     }
/* 652 */     if (type == 189) {
/* 653 */       return "arrowheadDeepIron";
/*     */     }
/* 655 */     if (type == 190) {
/* 656 */       return "hideGeneric";
/*     */     }
/*     */     
/* 659 */     return "unused";
/*     */   }
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player) {
/* 663 */     MovingObjectPosition movingobjectposition = func_77621_a(world, player, true);
/*     */     
/* 665 */     if (movingobjectposition == null) {
/* 666 */       return item;
/*     */     }
/* 668 */     if (movingobjectposition.field_72313_a == EnumMovingObjectType.TILE) {
/* 669 */       int i = movingobjectposition.field_72311_b;
/* 670 */       int j = movingobjectposition.field_72312_c;
/* 671 */       int k = movingobjectposition.field_72309_d;
/*     */       
/* 673 */       if (!world.func_72962_a(player, i, j, k)) {
/* 674 */         return item;
/*     */       }
/*     */       
/* 677 */       if (!player.func_82247_a(i, j, k, movingobjectposition.field_72310_e, item)) {
/* 678 */         return item;
/*     */       }
/*     */       
/* 681 */       if (isWaterSource(world, i, j, k)) {
/* 682 */         if (cfg.hardcoreLeather) {
/* 683 */           tryClean(item, world, player, 5, 2, new ItemStack(ItemListMF.misc, 1, 7));
/*     */         } else {
/* 685 */           tryClean(item, world, player, 5, 2, new ItemStack(Item.field_77770_aF));
/*     */         }
/*     */       }
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
/* 698 */       if ((!world.field_72995_K) && (item.func_77969_a(ItemListMF.component(11)))) {
/* 699 */         boolean full = false;
/* 700 */         boolean placed = false;
/* 701 */         if (world.func_72798_a(i, j, k) == MineFantasyBase.MFBlockSlag.field_71990_ca) {
/* 702 */           int meta = world.func_72805_g(i, j, k);
/* 703 */           if (meta < 15) {
/* 704 */             world.func_72921_c(i, j, k, meta + 1, 2);
/* 705 */             placed = true;
/* 706 */             if (!player.field_71075_bZ.field_75098_d) {
/* 707 */               player.func_70694_bm().field_77994_a -= 1;
/*     */             }
/*     */           } else {
/* 710 */             full = true;
/*     */           }
/*     */         }
/* 713 */         if ((!placed) && ((full) || (!world.func_72799_c(i, j, k))) && 
/* 714 */           (world.func_72799_c(i, j + 1, k))) {
/* 715 */           world.func_94575_c(i, j + 1, k, MineFantasyBase.MFBlockSlag.field_71990_ca);
/*     */           
/* 717 */           if (!player.field_71075_bZ.field_75098_d) {
/* 718 */             player.func_70694_bm().field_77994_a -= 1;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 725 */     return item;
/*     */   }
/*     */   
/*     */   private void tryClean(ItemStack item, World world, EntityPlayer player, int input, int chance, ItemStack result)
/*     */   {
/* 730 */     if ((item != null) && (item.func_77960_j() == input)) {
/* 731 */       Random rand = new Random();
/* 732 */       player.func_71038_i();
/* 733 */       if (!world.field_72995_K) {
/* 734 */         world.func_72956_a(player, "random.splash", 0.125F + rand.nextFloat() / 4.0F, 0.5F + rand.nextFloat());
/* 735 */         if (rand.nextInt(chance) == 0) {
/* 736 */           item.field_77994_a -= 1;
/* 737 */           EntityItem resultItem = new EntityItem(world, player.field_70165_t, player.field_70163_u, player.field_70161_v, result);
/* 738 */           world.func_72838_d(resultItem);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack itemstack)
/*     */   {
/* 746 */     switch (itemstack.func_77960_j()) {
/*     */     case 19: 
/* 748 */       return EnumRarity.uncommon;
/*     */     case 167: 
/* 750 */       return EnumRarity.uncommon;
/*     */     case 20: 
/* 752 */       return EnumRarity.uncommon;
/*     */     case 21: 
/* 754 */       return EnumRarity.uncommon;
/*     */     case 22: 
/* 756 */       return EnumRarity.rare;
/*     */     case 50: 
/* 758 */       return EnumRarity.rare;
/*     */     case 153: 
/* 760 */       return EnumRarity.rare;
/*     */     case 52: 
/* 762 */       return EnumRarity.rare;
/*     */     case 152: 
/* 764 */       return EnumRarity.rare;
/*     */     case 114: 
/* 766 */       return EnumRarity.uncommon;
/*     */     case 126: 
/* 768 */       return EnumRarity.uncommon;
/*     */     }
/* 770 */     return super.func_77613_e(itemstack);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/* 776 */     this.icons = new Icon[this.length];
/*     */     
/* 778 */     for (int i = 0; i < this.length; i++) {
/* 779 */       this.icons[i] = reg.func_94245_a("minefantasy:Misc/MineFantasy_Component_" + i);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onBlockDestroyed(ItemStack item, World world, int x, int y, int z, int meta, EntityLiving living) {
/* 784 */     if ((x == Block.field_71998_bu.field_71990_ca) && (isSharpRock(item))) {
/* 785 */       return true;
/*     */     }
/* 787 */     return super.func_77660_a(item, world, x, y, z, meta, living);
/*     */   }
/*     */   
/*     */   private boolean isSharpRock(ItemStack item)
/*     */   {
/* 792 */     return (item.func_77960_j() == 108) || (item.func_77960_j() == 113);
/*     */   }
/*     */   
/*     */   public boolean canHarvestBlock(Block block, ItemStack item)
/*     */   {
/* 797 */     if (!isSharpRock(item)) {
/* 798 */       return false;
/*     */     }
/* 800 */     return block.field_71990_ca == Block.field_71998_bu.field_71990_ca;
/*     */   }
/*     */   
/*     */   public boolean onBlockStartBreak(ItemStack item, int x, int y, int z, EntityPlayer living)
/*     */   {
/* 805 */     if (!isSharpRock(item)) {
/* 806 */       return super.onBlockStartBreak(item, x, y, z, living);
/*     */     }
/* 808 */     World world = living.field_70170_p;
/* 809 */     ItemStack newdrop = null;
/* 810 */     int id = world.func_72798_a(x, y, z);
/* 811 */     if (id == Block.field_71998_bu.field_71990_ca) {
/* 812 */       newdrop = ItemListMF.component(110);
/*     */     }
/* 814 */     if ((newdrop != null) && 
/* 815 */       (!world.field_72995_K)) {
/* 816 */       for (int a = 1; a <= living.func_70681_au().nextInt(9); a++) {
/* 817 */         dropBlockAsItem_do(world, x, y, z, newdrop);
/*     */       }
/*     */     }
/* 820 */     return super.onBlockStartBreak(newdrop, x, y, z, living);
/*     */   }
/*     */   
/*     */   protected void dropBlockAsItem_do(World world, int x, int y, int z, ItemStack item) {
/* 824 */     if ((!world.field_72995_K) && (world.func_82736_K().func_82766_b("doTileDrops"))) {
/* 825 */       float f = 0.7F;
/* 826 */       double d0 = world.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5D;
/* 827 */       double d1 = world.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5D;
/* 828 */       double d2 = world.field_73012_v.nextFloat() * f + (1.0F - f) * 0.5D;
/* 829 */       EntityItem entityitem = new EntityItem(world, x + d0, y + d1, z + d2, item);
/* 830 */       entityitem.field_70293_c = 10;
/* 831 */       world.func_72838_d(entityitem);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isWaterSource(World world, int i, int j, int k) {
/* 836 */     if (world.func_72803_f(i, j, k) == Material.field_76244_g) {
/* 837 */       return true;
/*     */     }
/* 839 */     if (isCauldron(world, i, j, k)) {
/* 840 */       return true;
/*     */     }
/* 842 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isCauldron(World world, int x, int y, int z) {
/* 846 */     return (world.func_72798_a(x, y, z) == Block.field_72108_bG.field_71990_ca) && (world.func_72805_g(x, y, z) > 0);
/*     */   }
/*     */   
/*     */   public float getHitDamage(ItemStack item)
/*     */   {
/* 851 */     int type = item.func_77960_j();
/* 852 */     if (type == 113)
/* 853 */       return 3.0F;
/* 854 */     if (type == 108) {
/* 855 */       return 2.0F;
/*     */     }
/* 857 */     return 1.0F;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemMedievalComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */