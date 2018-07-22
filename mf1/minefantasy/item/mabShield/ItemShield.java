/*     */ package minefantasy.item.mabShield;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import java.awt.Color;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.List;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.weapon.DamageSourceAP;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import minefantasy.item.weapon.ItemWeaponMF;
/*     */ import mods.battlegear2.api.IDyable;
/*     */ import mods.battlegear2.api.IEnchantable;
/*     */ import mods.battlegear2.api.ISheathed;
/*     */ import mods.battlegear2.api.shield.IArrowCatcher;
/*     */ import mods.battlegear2.api.shield.IArrowDisplay;
/*     */ import mods.battlegear2.api.shield.IShield;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.IProjectile;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemShield
/*     */   extends Item
/*     */   implements IShield, IDyable, IEnchantable, ISheathed, IArrowCatcher, IArrowDisplay
/*     */ {
/*     */   public EnumShieldDesign design;
/*     */   public EnumToolMaterial material;
/*     */   private Icon backIcon;
/*     */   private Icon trimIcon;
/*     */   private Icon paintIcon;
/*     */   private String customname;
/*  48 */   public static final float[] arrowX = new float[64];
/*  49 */   public static final float[] arrowY = new float[64];
/*  50 */   public static final float[] arrowDepth = new float[64];
/*  51 */   public static final float[] pitch = new float[64];
/*  52 */   public static final float[] yaw = new float[64];
/*  53 */   public static final DecimalFormat threshold = new DecimalFormat("#.#");
/*     */   
/*     */   public ItemShield(int id, EnumToolMaterial mat, EnumShieldDesign shield) {
/*  56 */     super(id);
/*  57 */     func_77637_a(ItemListMF.tabArmour);
/*  58 */     this.material = mat;
/*  59 */     this.design = shield;
/*     */     
/*  61 */     func_77655_b("shield." + this.design.getTitle() + "." + getMatName());
/*  62 */     func_111206_d("minefantasy:Shield/" + this.design.getTitle() + "/" + this.design.getTitle() + "." + getMatName());
/*     */     
/*  64 */     func_77651_p();
/*     */     
/*  66 */     func_77656_e((int)(this.material.func_77997_a() * shield.getThreshold()) / 2);
/*  67 */     func_77625_d(1);
/*  68 */     func_77627_a(false);
/*  69 */     GameRegistry.registerItem(this, func_77658_a());
/*  70 */     func_77637_a(ItemListMF.tabArmour);
/*     */   }
/*     */   
/*     */   public ItemShield(int id, EnumToolMaterial mat, EnumShieldDesign shield, String name) {
/*  74 */     this(id, mat, shield);
/*  75 */     this.customname = name;
/*  76 */     func_77655_b("shield." + this.design.getTitle() + "." + name);
/*  77 */     func_111206_d("minefantasy:Shield/" + this.design.getTitle() + "/" + this.design.getTitle() + "." + name);
/*     */   }
/*     */   
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/*  82 */     super.func_94581_a(reg);
/*     */     
/*  84 */     this.backIcon = reg.func_94245_a("minefantasy:Shield/" + this.design.getTitle() + "/" + this.design.getTitle() + "." + getMatName() + ".back");
/*  85 */     this.trimIcon = reg.func_94245_a("minefantasy:Shield/" + this.design.getTitle() + "/" + this.design.getTitle() + "." + getMatName() + ".trim");
/*  86 */     this.paintIcon = reg.func_94245_a("minefantasy:Shield/" + this.design.getTitle() + "/" + this.design.getTitle() + ".paint");
/*     */   }
/*     */   
/*     */   public Icon getBackIcon()
/*     */   {
/*  91 */     return this.backIcon;
/*     */   }
/*     */   
/*     */   public Icon getPaintIcon() {
/*  95 */     return this.paintIcon;
/*     */   }
/*     */   
/*     */   public Icon getTrimIcon() {
/*  99 */     return this.trimIcon;
/*     */   }
/*     */   
/*     */   private String getMatName() {
/* 103 */     if ((this.customname != null) && (this.customname.length() > 0)) {
/* 104 */       return this.customname;
/*     */     }
/* 106 */     return this.material.name().toLowerCase();
/*     */   }
/*     */   
/*     */   public float getDecayRate(ItemStack shield)
/*     */   {
/* 111 */     int use = 0;
/* 112 */     return getItemDecayRate() * (1.0F - use * 0.1F) * getMaterialWeightModifier();
/*     */   }
/*     */   
/*     */   private float getItemDecayRate() {
/* 116 */     return 1.0F / this.design.getCarryTime() / 20.0F;
/*     */   }
/*     */   
/*     */   public float getRecoveryRate(ItemStack shield)
/*     */   {
/* 121 */     int recover = 0;
/* 122 */     return 0.01F * (1.0F + recover * 0.2F);
/*     */   }
/*     */   
/*     */   public boolean canBlock(ItemStack shield, DamageSource source)
/*     */   {
/* 127 */     if ((source instanceof DamageSourceShieldfail)) {
/* 128 */       return false;
/*     */     }
/* 130 */     if ((this.material == ToolMaterialMedieval.DRAGONFORGE) && (source.func_76347_k())) {
/* 131 */       return true;
/*     */     }
/*     */     
/* 134 */     if (source == DamageSourceAP.blunt) {
/* 135 */       return this.design == EnumShieldDesign.TOWER;
/*     */     }
/* 137 */     return !source.func_76363_c();
/*     */   }
/*     */   
/*     */   public float getDamageDecayRate(ItemStack shield, float amount)
/*     */   {
/* 142 */     return getDamageDecay() * amount * getMaterialWeightModifier();
/*     */   }
/*     */   
/*     */   private float getDamageDecay() {
/* 146 */     if (this.design == EnumShieldDesign.TOWER) {
/* 147 */       return 0.0F;
/*     */     }
/* 149 */     return 1.0F / (20.0F * this.design.getThreshold());
/*     */   }
/*     */   
/*     */   public float getBlockAngle(ItemStack shield)
/*     */   {
/* 154 */     return this.design.getArc();
/*     */   }
/*     */   
/*     */   public int getBashTimer(ItemStack shield)
/*     */   {
/* 159 */     return this.design.getBashTime();
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack item, EntityPlayer player, List list, boolean extra)
/*     */   {
/* 164 */     super.func_77624_a(item, player, list, extra);
/*     */     
/* 166 */     if (!MineFantasyBase.isBGLoaded()) {
/* 167 */       list.add(EnumChatFormatting.DARK_RED + "Requires Battlegear2");
/*     */     }
/* 169 */     if ((MineFantasyBase.isBGLoaded()) || (MineFantasyBase.isDebug())) {
/* 170 */       list.add("");
/* 171 */       list.add(EnumChatFormatting.DARK_GREEN + ItemWeaponMF.decimal_format.format(1.0F / getItemDecayRate() / 20.0F) + StatCollector.func_74838_a("attribute.shield.block.time"));
/*     */       
/* 173 */       int arrowCount = getArrowCount(item);
/* 174 */       if (arrowCount > 0) {
/* 175 */         list.add(String.format("%s%s %s", new Object[] { EnumChatFormatting.GOLD, Integer.valueOf(arrowCount), StatCollector.func_74838_a("attribute.shield.arrow.count") }));
/*     */       }
/* 177 */       list.add(EnumChatFormatting.BLUE + StatCollector.func_74838_a("attribute.shield.threshold") + " " + threshold.format(getThreshold(item)));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasColor(ItemStack item)
/*     */   {
/* 187 */     return (item.func_77942_o()) && (item.func_77978_p().func_74764_b("display")) && (item.func_77978_p().func_74775_l("display").func_74764_b("color"));
/*     */   }
/*     */   
/*     */   private float getMaterialWeightModifier() {
/* 191 */     if (this.material == ToolMaterialMedieval.MITHRIL) {
/* 192 */       return 0.75F;
/*     */     }
/* 194 */     return 1.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getColor(ItemStack item)
/*     */   {
/* 203 */     NBTTagCompound nbttagcompound = item.func_77978_p();
/*     */     
/* 205 */     if (nbttagcompound == null) {
/* 206 */       return getDefaultColor(item);
/*     */     }
/* 208 */     NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l("display");
/* 209 */     return nbttagcompound1.func_74764_b("color") ? nbttagcompound1.func_74762_e("color") : nbttagcompound1 == null ? getDefaultColor(item) : getDefaultColor(item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeColor(ItemStack item)
/*     */   {
/* 219 */     NBTTagCompound nbttagcompound = item.func_77978_p();
/*     */     
/* 221 */     if (nbttagcompound != null) {
/* 222 */       NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l("display");
/*     */       
/* 224 */       if (nbttagcompound1.func_74764_b("color")) {
/* 225 */         nbttagcompound1.func_82580_o("color");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public int getDefaultColor(ItemStack stack)
/*     */   {
/* 232 */     return Color.WHITE.getRGB();
/*     */   }
/*     */   
/*     */   public float getScale(ItemStack item) {
/* 236 */     return this.design.getScale();
/*     */   }
/*     */   
/*     */ 
/*     */   public void setColor(ItemStack stack, int colour)
/*     */   {
/* 242 */     NBTTagCompound nbttagcompound = stack.func_77978_p();
/*     */     
/* 244 */     if (nbttagcompound == null) {
/* 245 */       nbttagcompound = new NBTTagCompound();
/* 246 */       stack.func_77982_d(nbttagcompound);
/*     */     }
/*     */     
/* 249 */     NBTTagCompound nbttagcompound1 = nbttagcompound.func_74775_l("display");
/*     */     
/* 251 */     if (!nbttagcompound.func_74764_b("display")) {
/* 252 */       nbttagcompound.func_74766_a("display", nbttagcompound1);
/*     */     }
/*     */     
/* 255 */     nbttagcompound1.func_74768_a("color", colour);
/*     */   }
/*     */   
/*     */   public boolean isEnchantable(Enchantment baseEnchantment, ItemStack stack)
/*     */   {
/* 260 */     return true;
/*     */   }
/*     */   
/*     */   public int func_77619_b()
/*     */   {
/* 265 */     return this.material.func_77995_e();
/*     */   }
/*     */   
/*     */   public boolean sheatheOnBack(ItemStack item)
/*     */   {
/* 270 */     return true;
/*     */   }
/*     */   
/*     */   public float getThreshold(ItemStack item) {
/* 274 */     return getThreshold(item, null);
/*     */   }
/*     */   
/*     */   public float getThreshold(ItemStack item, DamageSource src) {
/* 278 */     float mp = 1.0F;
/* 279 */     if ((src != null) && 
/* 280 */       (this.design == EnumShieldDesign.TOWER) && (src == DamageSourceAP.blunt)) {
/* 281 */       mp = 0.25F;
/*     */     }
/*     */     
/* 284 */     return (4.0F + this.material.func_78000_c()) * 2.0F * this.design.getThreshold() * mp;
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*     */   {
/* 289 */     if ((!MineFantasyBase.isBGLoaded()) && (!MineFantasyBase.isDebug())) {
/* 290 */       return;
/*     */     }
/*     */     
/* 293 */     if (id != ItemListMF.bucklerBronze.field_77779_bT) {
/* 294 */       return;
/*     */     }
/* 296 */     add(list, ItemListMF.shieldWood);
/* 297 */     add(list, ItemListMF.shieldIronbark);
/* 298 */     add(list, ItemListMF.shieldEbony);
/*     */     
/* 300 */     add(list, ItemListMF.bucklerBronze);
/* 301 */     add(list, ItemListMF.bucklerIron);
/* 302 */     add(list, ItemListMF.bucklerGuilded);
/* 303 */     add(list, ItemListMF.bucklerSteel);
/* 304 */     add(list, ItemListMF.bucklerEncrusted);
/* 305 */     add(list, ItemListMF.bucklerDragonforge);
/* 306 */     add(list, ItemListMF.bucklerDeepIron);
/* 307 */     add(list, ItemListMF.bucklerMithril);
/*     */     
/* 309 */     add(list, ItemListMF.kiteBronze);
/* 310 */     add(list, ItemListMF.kiteIron);
/* 311 */     add(list, ItemListMF.kiteGuilded);
/* 312 */     add(list, ItemListMF.kiteSteel);
/* 313 */     add(list, ItemListMF.kiteEncrusted);
/* 314 */     add(list, ItemListMF.kiteDragonforge);
/* 315 */     add(list, ItemListMF.kiteDeepIron);
/* 316 */     add(list, ItemListMF.kiteMithril);
/*     */     
/* 318 */     add(list, ItemListMF.towerBronze);
/* 319 */     add(list, ItemListMF.towerIron);
/* 320 */     add(list, ItemListMF.towerGuilded);
/* 321 */     add(list, ItemListMF.towerSteel);
/* 322 */     add(list, ItemListMF.towerEncrusted);
/* 323 */     add(list, ItemListMF.towerDragonforge);
/* 324 */     add(list, ItemListMF.towerDeepIron);
/* 325 */     add(list, ItemListMF.towerMithril);
/*     */   }
/*     */   
/*     */   private void add(List list, Item item) {
/* 329 */     list.add(new ItemStack(item));
/*     */   }
/*     */   
/*     */   static {
/* 333 */     for (int i = 0; i < 64; i++) {
/* 334 */       double r = Math.random() * 5.0D;
/* 335 */       double theta = Math.random() * 3.141592653589793D * 2.0D;
/*     */       
/* 337 */       arrowX[i] = ((float)(r * Math.cos(theta)));
/* 338 */       arrowY[i] = ((float)(r * Math.sin(theta)));
/* 339 */       arrowDepth[i] = ((float)(Math.random() * 0.5D + 0.5D));
/*     */       
/* 341 */       pitch[i] = ((float)(Math.random() * 50.0D - 25.0D));
/* 342 */       yaw[i] = ((float)(Math.random() * 50.0D - 25.0D));
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onHit(ItemStack shield, EntityLivingBase defender, DamageSource source, EntityLivingBase attacker, float dam) {
/* 347 */     boolean damage = true;
/* 348 */     if ((source instanceof DamageSourceShieldfail)) {
/* 349 */       return false;
/*     */     }
/*     */     
/* 352 */     if ((this.material == ToolMaterialMedieval.DRAGONFORGE) && ((source.func_76364_f() instanceof EntityLivingBase))) {
/* 353 */       attacker.func_70015_d(20);
/* 354 */       defender.func_70066_B();
/* 355 */       damage = false;
/*     */     }
/*     */     
/* 358 */     if ((this.material == ToolMaterialMedieval.ORNATE) && 
/* 359 */       (attacker.func_70668_bt() == EnumCreatureAttribute.UNDEAD)) {
/* 360 */       float deflect = dam;
/* 361 */       if (source.func_76352_a()) {
/* 362 */         deflect /= 2.0F;
/*     */       }
/* 364 */       attacker.func_70097_a(DamageSource.field_76376_m, deflect);
/* 365 */       damage = false;
/*     */     }
/*     */     
/* 368 */     float pass = dam - getThreshold(shield, source);
/*     */     
/* 370 */     if ((pass > 0.0F) && (!defender.field_70170_p.field_72995_K) && (!defender.field_70128_L)) {
/* 371 */       defender.field_70172_ad = 0;
/* 372 */       defender.func_70097_a(new DamageSourceShieldfail(source), pass);
/*     */     }
/* 374 */     return damage;
/*     */   }
/*     */   
/*     */   public int getArrowCount(ItemStack stack)
/*     */   {
/* 379 */     if ((stack.func_77942_o()) && (stack.func_77978_p().func_74764_b("arrows"))) {
/* 380 */       return stack.func_77978_p().func_74765_d("arrows");
/*     */     }
/* 382 */     return 0;
/*     */   }
/*     */   
/*     */   public void setArrowCount(ItemStack stack, int count)
/*     */   {
/* 387 */     if (!stack.func_77942_o()) {
/* 388 */       stack.func_77982_d(new NBTTagCompound());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 393 */     if (count > 32767) {
/* 394 */       count = 32767;
/*     */     }
/*     */     
/* 397 */     stack.func_77978_p().func_74777_a("arrows", (short)count);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean catchArrow(ItemStack shield, EntityPlayer player, IProjectile projectile)
/*     */   {
/* 403 */     return false;
/*     */   }
/*     */   
/*     */   public void blockAnimation(EntityPlayer player, float amount)
/*     */   {
/* 408 */     player.field_70170_p.func_72956_a(player, "battlegear2:shield", 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public float getDamageReduction(ItemStack shield, DamageSource source)
/*     */   {
/* 413 */     return 0.0F;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/mabShield/ItemShield.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */