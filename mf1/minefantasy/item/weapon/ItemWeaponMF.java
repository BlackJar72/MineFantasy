/*     */ package minefantasy.item.weapon;
/*     */ 
/*     */ import com.google.common.collect.Multimap;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.aesthetic.IWeaponrackHangable;
/*     */ import minefantasy.api.weapon.DamageSourceWeaponBonus;
/*     */ import minefantasy.api.weapon.IExtendedReachItem;
/*     */ import minefantasy.api.weapon.IStealthWeapon;
/*     */ import minefantasy.api.weapon.IWeaponCustomSpeed;
/*     */ import minefantasy.api.weapon.IWeaponPenetrateArmour;
/*     */ import minefantasy.api.weapon.IWeaponSpecialBlock;
/*     */ import minefantasy.api.weapon.IWeaponWeakArmour;
/*     */ import minefantasy.api.weapon.IWeightedWeapon;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.system.cfg;
/*     */ import mods.battlegear2.api.PlayerEventChild.OffhandAttackEvent;
/*     */ import mods.battlegear2.api.weapons.IBattlegearWeapon;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ 
/*     */ public abstract class ItemWeaponMF extends ItemSword implements IWeaponrackHangable, minefantasy.api.weapon.IHitReaction, IBattlegearWeapon, minefantasy.api.weapon.IWeaponSpecial, IWeightedWeapon
/*     */ {
/*  49 */   protected Random rand = new Random();
/*     */   protected float baseDamage;
/*     */   protected EnumToolMaterial material;
/*  52 */   public static final DecimalFormat decimal_format = new DecimalFormat("#.###");
/*     */   
/*     */   public ItemWeaponMF(int id, EnumToolMaterial material) {
/*  55 */     super(id, material);
/*  56 */     func_77637_a(ItemListMF.tabWeapon);
/*  57 */     this.material = material;
/*  58 */     func_77656_e((int)(material.func_77997_a() * getDurability()));
/*     */     
/*  60 */     this.baseDamage = ((4.0F + material.func_78000_c()) * getDamageModifier());
/*     */   }
/*     */   
/*     */   public EnumToolMaterial getMaterial() {
/*  64 */     return this.material;
/*     */   }
/*     */   
/*     */   public Multimap func_111205_h()
/*     */   {
/*  69 */     Multimap map = com.google.common.collect.HashMultimap.create();
/*  70 */     map.put(SharedMonsterAttributes.field_111264_e.func_111108_a(), new AttributeModifier(field_111210_e, "Weapon modifier", this.baseDamage, 0));
/*     */     
/*  72 */     return map;
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack weapon, EntityPlayer player, List list, boolean fullInfo)
/*     */   {
/*  77 */     super.func_77624_a(weapon, player, list, fullInfo);
/*     */     
/*  79 */     if ((canBlock()) || ((this instanceof IExtendedReachItem)) || ((this instanceof IWeaponSpecialBlock)) || ((this instanceof IWeaponPenetrateArmour)) || ((this instanceof IWeaponCustomSpeed))) {
/*  80 */       list.add("");
/*     */       
/*  82 */       if ((this instanceof IWeaponCustomSpeed)) {
/*  83 */         int hitMod = ((IWeaponCustomSpeed)this).getHitTime(weapon, null);
/*  84 */         if (hitMod > 0) {
/*  85 */           list.add(EnumChatFormatting.RED + StatCollector.func_74837_a("attribute.modifier.plus.1", new Object[] { decimal_format.format(hitMod / 10.0F * 100.0F), StatCollector.func_74838_a("attribute.weapon.attackSpeed") }));
/*     */         } else {
/*  87 */           list.add(EnumChatFormatting.DARK_GREEN + StatCollector.func_74837_a("attribute.modifier.take.1", new Object[] { decimal_format.format(-hitMod / 10.0F * 100.0F), StatCollector.func_74838_a("attribute.weapon.attackSpeed") }));
/*     */         }
/*     */       }
/*     */       
/*  91 */       if ((this instanceof IWeaponPenetrateArmour)) {
/*  92 */         list.add(EnumChatFormatting.DARK_GREEN + StatCollector.func_74837_a("attribute.modifier.plus.1", new Object[] { decimal_format.format(getAPPercent() * 100.0F), StatCollector.func_74838_a("attribute.weapon.penetrateArmor") }));
/*     */         
/*  94 */         if (((IWeaponPenetrateArmour)this).buffDamage()) {
/*  95 */           float boost = ((IWeaponPenetrateArmour)this).getArmourDamageBonus() - 1.0F;
/*     */           
/*  97 */           if (boost > 0.0F) {
/*  98 */             list.add(EnumChatFormatting.DARK_GREEN + StatCollector.func_74837_a("attribute.modifier.plus.1", new Object[] { decimal_format.format(boost * 100.0F), StatCollector.func_74838_a("attribute.weapon.boostarmourdamage") }));
/*     */           }
/*     */         }
/*     */       }
/* 102 */       if ((this instanceof IWeaponWeakArmour)) {
/* 103 */         float AE = ((IWeaponWeakArmour)this).getArmourPower(weapon);
/* 104 */         if (AE > 0.0F) {
/* 105 */           list.add(EnumChatFormatting.RED + StatCollector.func_74837_a("attribute.modifier.take.1", new Object[] { decimal_format.format(AE * 100.0F), StatCollector.func_74838_a("attribute.weapon.penetrateArmor") }));
/*     */         }
/*     */       }
/*     */       
/* 109 */       if ((this instanceof IExtendedReachItem)) {
/* 110 */         float reach = ((IExtendedReachItem)this).getReachModifierInBlocks(weapon);
/*     */         
/* 112 */         if (reach > 0.0F) {
/* 113 */           list.add(EnumChatFormatting.DARK_GREEN + StatCollector.func_74837_a("attribute.modifier.plus.0", new Object[] { decimal_format.format(reach), StatCollector.func_74838_a("attribute.weapon.extendedReach") }));
/*     */         } else {
/* 115 */           list.add(EnumChatFormatting.RED + StatCollector.func_74837_a("attribute.modifier.take.0", new Object[] { decimal_format.format(-1.0F * reach), StatCollector.func_74838_a("attribute.weapon.extendedReach") }));
/*     */         }
/*     */       }
/*     */       
/* 119 */       if ((this instanceof IStealthWeapon)) {
/* 120 */         list.add(EnumChatFormatting.GOLD + StatCollector.func_74838_a("attribute.weapon.stealthWeapon"));
/*     */       }
/*     */       
/* 123 */       if (canJoust()) {
/* 124 */         list.add(EnumChatFormatting.GOLD + StatCollector.func_74838_a("attribute.weapon.joust"));
/*     */       }
/* 126 */       if ((this instanceof IWeaponSpecialBlock)) {
/* 127 */         list.add(EnumChatFormatting.GOLD + StatCollector.func_74838_a("attribute.weapon.block.special"));
/* 128 */       } else if (canBlock()) {
/* 129 */         list.add(EnumChatFormatting.GOLD + StatCollector.func_74838_a("attribute.weapon.block"));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*     */   {
/* 137 */     if (tabs != ItemListMF.tabWeapon) {
/* 138 */       super.func_77633_a(id, tabs, list);
/* 139 */       return;
/*     */     }
/* 141 */     if (id != ItemListMF.swordSteelForged.field_77779_bT) {
/* 142 */       return;
/*     */     }
/* 144 */     add(list, ItemListMF.daggerBronze);
/* 145 */     add(list, ItemListMF.daggerIron);
/* 146 */     add(list, ItemListMF.daggerSteel);
/* 147 */     add(list, ItemListMF.daggerEncrusted);
/* 148 */     add(list, ItemListMF.daggerDeepIron);
/* 149 */     add(list, ItemListMF.daggerMithril);
/* 150 */     add(list, ItemListMF.daggerDragon);
/* 151 */     add(list, ItemListMF.daggerOrnate);
/* 152 */     add(list, ItemListMF.daggerIgnotumite);
/*     */     
/* 154 */     add(list, ItemListMF.swordCopper);
/* 155 */     add(list, ItemListMF.swordTin);
/* 156 */     add(list, ItemListMF.swordBronze);
/* 157 */     add(list, ItemListMF.swordIronForged);
/* 158 */     add(list, ItemListMF.swordSteelForged);
/* 159 */     add(list, ItemListMF.swordEncrusted);
/* 160 */     add(list, ItemListMF.swordDeepIron);
/* 161 */     add(list, ItemListMF.swordMithril);
/* 162 */     add(list, ItemListMF.swordDragon);
/* 163 */     add(list, ItemListMF.swordOrnate);
/* 164 */     add(list, ItemListMF.swordIgnotumite);
/*     */     
/* 166 */     add(list, ItemListMF.broadBronze);
/* 167 */     add(list, ItemListMF.broadIron);
/* 168 */     add(list, ItemListMF.broadSteel);
/* 169 */     add(list, ItemListMF.broadEncrusted);
/* 170 */     add(list, ItemListMF.broadswordDeepIron);
/* 171 */     add(list, ItemListMF.broadMithril);
/* 172 */     add(list, ItemListMF.broadDragon);
/* 173 */     add(list, ItemListMF.broadOrnate);
/* 174 */     add(list, ItemListMF.broadIgnotumite);
/*     */     
/* 176 */     add(list, ItemListMF.greatswordBronze);
/* 177 */     add(list, ItemListMF.greatswordIron);
/* 178 */     add(list, ItemListMF.greatswordSteel);
/* 179 */     add(list, ItemListMF.greatswordEncrusted);
/* 180 */     add(list, ItemListMF.greatswordDeepIron);
/* 181 */     add(list, ItemListMF.greatswordMithril);
/* 182 */     add(list, ItemListMF.greatswordDragon);
/* 183 */     add(list, ItemListMF.greatswordOrnate);
/* 184 */     add(list, ItemListMF.greatswordIgnotumite);
/*     */     
/* 186 */     add(list, ItemListMF.maceCopper);
/* 187 */     add(list, ItemListMF.maceTin);
/* 188 */     add(list, ItemListMF.maceBronze);
/* 189 */     add(list, ItemListMF.maceIron);
/* 190 */     add(list, ItemListMF.maceSteel);
/* 191 */     add(list, ItemListMF.maceEncrusted);
/* 192 */     add(list, ItemListMF.maceDeepIron);
/* 193 */     add(list, ItemListMF.maceMithril);
/* 194 */     add(list, ItemListMF.maceDragon);
/* 195 */     add(list, ItemListMF.maceOrnate);
/* 196 */     add(list, ItemListMF.maceIgnotumite);
/*     */     
/* 198 */     add(list, ItemListMF.warpickBronze);
/* 199 */     add(list, ItemListMF.warpickIron);
/* 200 */     add(list, ItemListMF.warpickSteel);
/* 201 */     add(list, ItemListMF.warpickEncrusted);
/* 202 */     add(list, ItemListMF.warpickDeepIron);
/* 203 */     add(list, ItemListMF.warpickMithril);
/* 204 */     add(list, ItemListMF.warpickDragon);
/* 205 */     add(list, ItemListMF.warpickOrnate);
/* 206 */     add(list, ItemListMF.warpickIgnotumite);
/*     */     
/* 208 */     add(list, ItemListMF.morningstarBronze);
/* 209 */     add(list, ItemListMF.morningstarIron);
/* 210 */     add(list, ItemListMF.morningstarSteel);
/* 211 */     add(list, ItemListMF.greatmaceEncrusted);
/* 212 */     add(list, ItemListMF.greatmaceDeepIron);
/* 213 */     add(list, ItemListMF.morningstarMithril);
/* 214 */     add(list, ItemListMF.morningstarDragon);
/* 215 */     add(list, ItemListMF.greatmaceOrnate);
/* 216 */     add(list, ItemListMF.morningstarIgnotumite);
/*     */     
/* 218 */     add(list, ItemListMF.warhammerBronze);
/* 219 */     add(list, ItemListMF.warhammerIron);
/* 220 */     add(list, ItemListMF.warhammerSteel);
/* 221 */     add(list, ItemListMF.warhammerEncrusted);
/* 222 */     add(list, ItemListMF.warhammerDeepIron);
/* 223 */     add(list, ItemListMF.warhammerMithril);
/* 224 */     add(list, ItemListMF.warhammerDragon);
/* 225 */     add(list, ItemListMF.warhammerOrnate);
/* 226 */     add(list, ItemListMF.warhammerIgnotumite);
/*     */     
/* 228 */     add(list, ItemListMF.waraxeCopper);
/* 229 */     add(list, ItemListMF.waraxeTin);
/* 230 */     add(list, ItemListMF.waraxeBronze);
/* 231 */     add(list, ItemListMF.waraxeIron);
/* 232 */     add(list, ItemListMF.waraxeSteel);
/* 233 */     add(list, ItemListMF.waraxeEncrusted);
/* 234 */     add(list, ItemListMF.waraxeDeepIron);
/* 235 */     add(list, ItemListMF.waraxeMithril);
/* 236 */     add(list, ItemListMF.waraxeDragon);
/* 237 */     add(list, ItemListMF.waraxeOrnate);
/* 238 */     add(list, ItemListMF.waraxeIgnotumite);
/*     */     
/* 240 */     add(list, ItemListMF.battleaxeBronze);
/* 241 */     add(list, ItemListMF.battleaxeIron);
/* 242 */     add(list, ItemListMF.battleaxeSteel);
/* 243 */     add(list, ItemListMF.battleaxeEncrusted);
/* 244 */     add(list, ItemListMF.battleaxeDeepIron);
/* 245 */     add(list, ItemListMF.battleaxeMithril);
/* 246 */     add(list, ItemListMF.battleaxeDragon);
/* 247 */     add(list, ItemListMF.battleaxeOrnate);
/* 248 */     add(list, ItemListMF.battleaxeIgnotumite);
/*     */     
/* 250 */     add(list, ItemListMF.spearBronze);
/* 251 */     add(list, ItemListMF.spearIron);
/* 252 */     add(list, ItemListMF.spearSteel);
/* 253 */     add(list, ItemListMF.spearEncrusted);
/* 254 */     add(list, ItemListMF.spearDeepIron);
/* 255 */     add(list, ItemListMF.spearMithril);
/* 256 */     add(list, ItemListMF.spearDragon);
/* 257 */     add(list, ItemListMF.spearOrnate);
/* 258 */     add(list, ItemListMF.spearIgnotumite);
/*     */     
/* 260 */     add(list, ItemListMF.halbeardBronze);
/* 261 */     add(list, ItemListMF.halbeardIron);
/* 262 */     add(list, ItemListMF.halbeardSteel);
/* 263 */     add(list, ItemListMF.halbeardEncrusted);
/* 264 */     add(list, ItemListMF.halbeardDeepIron);
/* 265 */     add(list, ItemListMF.halbeardMithril);
/* 266 */     add(list, ItemListMF.halbeardDragon);
/* 267 */     add(list, ItemListMF.halbeardOrnate);
/* 268 */     add(list, ItemListMF.halbeardIgnotumite);
/*     */     
/* 270 */     add(list, ItemListMF.lanceBronze);
/* 271 */     add(list, ItemListMF.lanceIron);
/* 272 */     add(list, ItemListMF.lanceSteel);
/* 273 */     add(list, ItemListMF.lanceEncrusted);
/* 274 */     add(list, ItemListMF.lanceDeepIron);
/* 275 */     add(list, ItemListMF.lanceMithril);
/* 276 */     add(list, ItemListMF.lanceDragon);
/* 277 */     add(list, ItemListMF.lanceOrnate);
/* 278 */     add(list, ItemListMF.lanceIgnotumite);
/*     */   }
/*     */   
/*     */   private void add(List list, Item item) {
/* 282 */     list.add(new ItemStack(item));
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/* 287 */     func_111206_d("minefantasy:Weapon/" + name);
/* 288 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   public abstract float getDamageModifier();
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player) {
/* 294 */     if (canBlock()) {
/* 295 */       return super.func_77659_a(item, world, player);
/*     */     }
/* 297 */     return item;
/*     */   }
/*     */   
/*     */   public boolean canBlock()
/*     */   {
/* 302 */     return false;
/*     */   }
/*     */   
/*     */   public void onHit(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker)
/*     */   {
/* 307 */     Class enClass = target.getClass();
/* 308 */     String name = "";
/* 309 */     if ((enClass != null) && (EntityList.field_75626_c.get(enClass) != null)) {
/* 310 */       name = (String)EntityList.field_75626_c.get(enClass);
/*     */     }
/* 312 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 313 */       target.func_70015_d(20);
/*     */     }
/*     */     
/* 316 */     if ((getMaterial() == ToolMaterialMedieval.ORNATE) && 
/* 317 */       ((target instanceof EntityLiving))) {
/* 318 */       if (((EntityLiving)target).func_70668_bt() == EnumCreatureAttribute.UNDEAD) {
/* 319 */         target.func_70015_d(20);
/* 320 */         int hurt = target.field_70172_ad;
/* 321 */         target.field_70172_ad = 0;
/* 322 */         target.func_70097_a(DamageSource.field_76377_j, damage);
/* 323 */         target.field_70172_ad = hurt;
/* 324 */         target.field_70170_p.func_72956_a(target, "random.fizz", 1.0F, 1.0F);
/*     */       }
/* 326 */       if (name.endsWith("Werewolf")) {
/* 327 */         target.func_70015_d(20);
/* 328 */         int hurt = target.field_70172_ad;
/* 329 */         target.field_70172_ad = 0;
/* 330 */         target.func_70097_a(DamageSource.field_76377_j, damage * 10.0F);
/* 331 */         target.field_70172_ad = hurt;
/* 332 */         target.field_70170_p.func_72956_a(target, "random.fizz", 1.0F, 1.0F);
/*     */       }
/*     */     }
/*     */     
/* 336 */     if (canJoust()) {
/* 337 */       joust(damage, weapon, target, attacker);
/*     */     }
/*     */     
/* 340 */     if ((this.rand.nextFloat() < getStunChance()) && 
/* 341 */       ((target instanceof EntityLiving))) {
/* 342 */       PotionEffect poison = new PotionEffect(Potion.field_76421_d.field_76415_H, 100, 0);
/* 343 */       ((EntityLiving)target).func_70690_d(poison);
/*     */     }
/*     */     
/* 346 */     if ((getKnockback() > 0.0F) && (!attacker.func_70115_ae())) {
/* 347 */       knockbackEntity(target, attacker, getKnockback() / 2.0F);
/*     */     }
/* 349 */     if (cfg.heavyBonus) {
/* 350 */       applyHeavyAttackBonus(attacker, target);
/*     */     }
/* 352 */     applyAttackBonus(attacker, target, damage);
/*     */   }
/*     */   
/*     */   private void applyAttackBonus(EntityLivingBase attacker, EntityLivingBase target, float damage) {
/* 356 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 357 */       attacker.func_70691_i(damage / 4.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   private void applyDefenseBonus(DamageSource source, EntityLivingBase target) {
/* 362 */     if ((getMaterial() == ToolMaterialMedieval.IGNOTUMITE) && 
/* 363 */       (target.func_110143_aJ() < target.func_110143_aJ() * 0.25F)) {
/* 364 */       target.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 200, 0));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void applyHeavyAttackBonus(EntityLivingBase attacker, EntityLivingBase target) {}
/*     */   
/*     */ 
/*     */   public void onUserHit(DamageSource source, EntityLivingBase target)
/*     */   {
/* 374 */     if (cfg.heavyBonus) {
/* 375 */       applyHeavyDefenseBonus(source, target);
/*     */     }
/* 377 */     applyDefenseBonus(source, target);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void applyHeavyDefenseBonus(DamageSource source, EntityLivingBase target) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public float getKnockback()
/*     */   {
/* 389 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public void joust(float damage, ItemStack weapon, EntityLivingBase target, EntityLivingBase attacker) {
/* 393 */     if (attacker.func_70115_ae()) {
/* 394 */       Entity mount = attacker.field_70154_o;
/* 395 */       float speed = (float)Math.hypot(mount.field_70159_w, mount.field_70179_y) * 20.0F;
/*     */       
/* 397 */       if (speed > 5.0F) {
/* 398 */         speed = 5.0F;
/*     */       }
/* 400 */       float bonus = 0.2F * speed;
/* 401 */       target.func_70097_a(new DamageSourceWeaponBonus("battlegearSpecial", attacker, false), damage + damage * bonus * getJoustModifierDamage());
/* 402 */       if ((attacker instanceof EntityPlayer)) {
/* 403 */         ((EntityPlayer)attacker).func_71009_b(target);
/*     */       }
/*     */       
/* 406 */       if ((target.func_70115_ae()) && (speed > 2.0F)) {
/* 407 */         target.func_110145_l(target.field_70154_o);
/* 408 */         target.func_70078_a(null);
/*     */       }
/*     */       
/* 411 */       if (speed > 0.0F) {
/* 412 */         knockbackEntity(target, attacker, 10.0F * bonus);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public float getJoustModifierDamage() {
/* 418 */     return 0.5F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public float getStunChance()
/*     */   {
/* 426 */     return 0.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public abstract float getDurability();
/*     */   
/*     */ 
/*     */   public boolean canJoust()
/*     */   {
/* 436 */     return false;
/*     */   }
/*     */   
/*     */   private void knockbackEntity(Entity target, EntityLivingBase attacker, float knockbackMod) {
/* 440 */     float height = knockbackMod / 5.0F;
/* 441 */     target.func_70024_g(-MathHelper.func_76126_a(attacker.field_70177_z * 3.1415927F / 180.0F) * knockbackMod * 0.5F, height, MathHelper.func_76134_b(attacker.field_70177_z * 3.1415927F / 180.0F) * knockbackMod * 0.5F);
/*     */   }
/*     */   
/*     */   public boolean offhandClickBlock(PlayerInteractEvent event, ItemStack mainhandItem, ItemStack offhandItem)
/*     */   {
/* 446 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void performPassiveEffects(Side effectiveSide, ItemStack mainhandItem, ItemStack offhandItem) {}
/*     */   
/*     */ 
/*     */   public boolean allowOffhand(ItemStack mainhand, ItemStack offhand)
/*     */   {
/* 456 */     return getHandsUsed() == 1;
/*     */   }
/*     */   
/*     */   public boolean isOffhandHandDual(ItemStack off)
/*     */   {
/* 461 */     return getHandsUsed() == 1;
/*     */   }
/*     */   
/*     */   public boolean sheatheOnBack(ItemStack item)
/*     */   {
/* 466 */     return getHandsUsed() == 2;
/*     */   }
/*     */   
/*     */   public boolean offhandClickAir(PlayerInteractEvent event, ItemStack mainhandItem, ItemStack offhandItem)
/*     */   {
/* 471 */     return true;
/*     */   }
/*     */   
/*     */   public int func_77619_b()
/*     */   {
/* 476 */     return getMaterial().func_77995_e();
/*     */   }
/*     */   
/*     */   public boolean offhandAttackEntity(PlayerEventChild.OffhandAttackEvent event, ItemStack mainhandItem, ItemStack offhandItem)
/*     */   {
/* 481 */     return true;
/*     */   }
/*     */   
/*     */   public abstract int getHandsUsed();
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/* 488 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 489 */       return rarity(itemStack, 1);
/*     */     }
/* 491 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 492 */       return rarity(itemStack, 2);
/*     */     }
/* 494 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/* 498 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/* 499 */     if (item.func_77948_v()) {
/* 500 */       if (lvl == 0) {
/* 501 */         lvl++;
/*     */       }
/* 503 */       lvl++;
/*     */     }
/* 505 */     if (lvl >= rarity.length) {
/* 506 */       lvl = rarity.length - 1;
/*     */     }
/* 508 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public boolean isPrimitive() {
/* 512 */     return (this.material == ToolMaterialMedieval.PRIMITIVE_STONE) || (this.material == ToolMaterialMedieval.PRIMITIVE_COPPER);
/*     */   }
/*     */   
/*     */   public float getBalance()
/*     */   {
/* 517 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float getBlockFailureChance()
/*     */   {
/* 522 */     return 0.0F;
/*     */   }
/*     */   
/*     */   protected float getAPPercent() {
/* 526 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public boolean canUseRenderer(ItemStack item)
/*     */   {
/* 531 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemWeaponMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */