/*     */ package minefantasy.item.weapon;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.List;
/*     */ import minefantasy.api.aesthetic.IWeaponrackHangable;
/*     */ import minefantasy.api.weapon.CrossbowAmmo;
/*     */ import minefantasy.api.weapon.EnumAmmo;
/*     */ import minefantasy.item.EnumCrossbowType;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.ItemBow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.StatCollector;
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
/*     */ public class ItemCrossbow
/*     */   extends ItemBow
/*     */   implements IWeaponrackHangable
/*     */ {
/*  39 */   public static final DecimalFormat decimal_format = new DecimalFormat("#.#");
/*     */   public EnumCrossbowType firearm;
/*     */   public EnumAmmo ammoItem;
/*  42 */   public int cap = 1;
/*     */   private Icon[] head;
/*     */   private Icon stock;
/*     */   
/*     */   public ItemCrossbow(int id, EnumAmmo ammo, EnumCrossbowType type) {
/*  47 */     super(id);
/*  48 */     func_77664_n();
/*  49 */     func_77656_e(type.getDurability());
/*  50 */     this.firearm = type;
/*  51 */     func_77637_a(ItemListMF.tabArcher);
/*  52 */     func_77625_d(1);
/*  53 */     this.ammoItem = ammo;
/*  54 */     this.cap = type.getMaxAmmo();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77662_d()
/*     */   {
/*  62 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Icon func_77617_a(int dam)
/*     */   {
/*  68 */     return this.head[0];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_77615_a(ItemStack item, World world, EntityPlayer player, int time)
/*     */   {
/*  77 */     if (getReloadStage(item) == 2) {
/*  78 */       getNbt(item).func_74768_a("Reload", 0);
/*  79 */       return;
/*     */     }
/*     */     
/*  82 */     if (player.field_82175_bq) {
/*  83 */       return;
/*     */     }
/*  85 */     boolean infinite = (player.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/*  86 */     if (getReloadStage(item) == 1)
/*     */     {
/*  88 */       if ((getReloadStage(item) == 1) && (time <= item.func_77988_m() - this.firearm.getReload() * 0.9D)) {
/*  89 */         func_77654_b(item, world, player);
/*  90 */         player.func_71038_i();
/*     */       } }
/*  92 */     if (((!player.func_70093_af()) || (getAmmunition(item) == this.cap)) && (getReloadStage(item) == 0))
/*     */     {
/*  94 */       int ammo = getAmmunition(item);
/*  95 */       if (ammo > 0) {
/*  96 */         tryFire(item, world, player);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
/*     */   {
/* 107 */     boolean use = false;
/* 108 */     NBTTagCompound nbt = getNbt(item);
/* 109 */     int ammo = getAmmunition(item);
/* 110 */     if ((ammo <= 0) || ((ammo < this.cap) && (player.func_70093_af()))) {
/* 111 */       boolean infinite = (player.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/*     */       
/* 113 */       if ((infinite) || (hasAmmo(player))) {
/* 114 */         nbt.func_74768_a("Reload", 1);
/* 115 */         use = true;
/*     */       }
/*     */     }
/* 118 */     else if ((ammo > 0) && (getReloadStage(item) != 2)) {
/* 119 */       use = true;
/* 120 */       nbt.func_74768_a("Reload", 0);
/*     */     }
/*     */     
/* 123 */     if (getReloadStage(item) == 2) {
/* 124 */       player.func_71008_a(item, item.func_77988_m());
/*     */     }
/* 126 */     if (use) {
/* 127 */       player.func_71008_a(item, item.func_77988_m());
/*     */     }
/* 129 */     return item;
/*     */   }
/*     */   
/*     */   public void onUsingItemTick(ItemStack item, EntityPlayer player, int time)
/*     */   {
/* 134 */     if ((getReloadStage(item) == 1) && (time == item.func_77988_m() - this.firearm.getReload())) {
/* 135 */       boolean infinite = (player.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/* 136 */       ItemStack load = getLoadedShot(player, EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/*     */       
/* 138 */       if (load != null) {
/* 139 */         if (!player.field_70170_p.field_72995_K)
/* 140 */           player.func_71038_i();
/* 141 */         int ammo = getAmmunition(item);
/* 142 */         addAmmo(item, load);
/*     */         
/* 144 */         if (!player.field_70170_p.field_72995_K) {
/* 145 */           player.field_70170_p.func_72956_a(player, "random.click", 1.0F, 1.0F);
/*     */         }
/* 147 */         player.func_71038_i();
/* 148 */         getNbt(item).func_74768_a("Reload", 2);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private ItemStack getLoadedShot(EntityPlayer player, boolean infinite) {
/* 154 */     if (this.ammoItem == EnumAmmo.ARROW) {
/* 155 */       return CrossbowAmmo.tryLoadArrow(player, infinite);
/*     */     }
/* 157 */     return CrossbowAmmo.tryLoadBolt(player, infinite);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemStack func_77654_b(ItemStack item, World world, EntityPlayer player)
/*     */   {
/* 163 */     boolean infinite = (player.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/* 164 */     ItemStack load = getLoadedShot(player, EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/*     */     
/* 166 */     if (load != null) {
/* 167 */       NBTTagCompound nbt = getNbt(item);
/* 168 */       int ammo = getAmmunition(item);
/* 169 */       int reload = nbt.func_74762_e("Reload");
/* 170 */       if (reload == 1) {
/* 171 */         addAmmo(item, load);
/*     */         
/* 173 */         if (!world.field_72995_K) {
/* 174 */           player.field_70170_p.func_72956_a(player, "random.click", 1.0F, 1.0F);
/*     */         }
/* 176 */         if (ammo < this.cap) {
/* 177 */           nbt.func_74768_a("Reload", 1);
/* 178 */           player.func_71008_a(item, item.func_77988_m());
/*     */         }
/*     */       }
/*     */     }
/* 182 */     return item;
/*     */   }
/*     */   
/*     */   public int func_77626_a(ItemStack item)
/*     */   {
/* 187 */     if ((getReloadStage(item) == 0) || (getAmmunition(item) >= this.cap - 1) || (getReloadStage(item) == 2)) {
/* 188 */       return 72000;
/*     */     }
/* 190 */     return this.firearm.getReload();
/*     */   }
/*     */   
/*     */   public NBTTagCompound getNbt(ItemStack item) {
/* 194 */     if (!item.func_77942_o()) {
/* 195 */       item.func_77982_d(new NBTTagCompound());
/*     */     }
/* 197 */     return item.func_77978_p();
/*     */   }
/*     */   
/*     */   public int getAmmunition(ItemStack item) {
/* 201 */     NBTTagCompound nbt = getNbt(item);
/* 202 */     if (!nbt.func_74764_b("Ammo")) {
/* 203 */       return 0;
/*     */     }
/* 205 */     return nbt.func_74762_e("Ammo");
/*     */   }
/*     */   
/*     */   public void setAmmunitionCount(ItemStack item, int ammo) {
/* 209 */     NBTTagCompound nbt = getNbt(item);
/* 210 */     nbt.func_74768_a("Ammo", ammo);
/*     */   }
/*     */   
/*     */   public void addAmmo(ItemStack weapon, ItemStack ammo) {
/* 214 */     if (ammo == null) {
/* 215 */       return;
/*     */     }
/* 217 */     int ammunition = getAmmunition(weapon) + 1;
/* 218 */     setAmmunitionCount(weapon, ammunition);
/*     */     
/* 220 */     NBTTagCompound nbt = getNbt(weapon);
/*     */     
/* 222 */     nbt.func_74768_a("Ammo_" + ammunition, ammo.field_77993_c);
/* 223 */     nbt.func_74768_a("AmmoSub_" + ammunition, ammo.func_77960_j());
/*     */   }
/*     */   
/*     */   public void removeAmmo(ItemStack weapon) {
/* 227 */     int ammunition = getAmmunition(weapon);
/* 228 */     setAmmunitionCount(weapon, ammunition - 1);
/*     */     
/* 230 */     NBTTagCompound nbt = getNbt(weapon);
/*     */     
/* 232 */     nbt.func_74768_a("Ammo_" + ammunition, 0);
/* 233 */     nbt.func_74768_a("AmmoSub_" + ammunition, 0);
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack item, EntityPlayer player, List desc, boolean flag)
/*     */   {
/* 238 */     float dam = this.firearm.getDamage();
/* 239 */     if (dam > 0.0F) {
/* 240 */       desc.add(EnumChatFormatting.BLUE + StatCollector.func_74837_a("attribute.modifier.plus.0", new Object[] { decimal_format.format(dam), StatCollector.func_74838_a("attribute.arrow.force") }));
/*     */     }
/*     */     
/*     */ 
/* 244 */     NBTTagCompound nbt = getNbt(item);
/*     */     
/* 246 */     if (getAmmunition(item) <= 0) {
/* 247 */       desc.add(EnumChatFormatting.RED + "Not Loaded");
/*     */     }
/* 249 */     else if (this.cap > 1) {
/* 250 */       desc.add("Ammo: " + getAmmunition(item));
/*     */     }
/*     */     
/* 253 */     if (item.func_77948_v()) {
/* 254 */       desc.add("");
/*     */     }
/* 256 */     super.func_77624_a(item, player, desc, flag);
/*     */   }
/*     */   
/*     */   public float getReloadSpeed() {
/* 260 */     return 30 / this.firearm.getReload();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumAction func_77661_b(ItemStack item)
/*     */   {
/* 268 */     if (getReloadStage(item) == 2)
/* 269 */       return EnumAction.none;
/* 270 */     if (getReloadStage(item) == 0)
/* 271 */       return EnumAction.bow;
/* 272 */     return EnumAction.block;
/*     */   }
/*     */   
/*     */   private int getReloadStage(ItemStack item) {
/* 276 */     NBTTagCompound nbt = getNbt(item);
/* 277 */     if (!nbt.func_74764_b("Reload")) {
/* 278 */       return 0;
/*     */     }
/* 280 */     return nbt.func_74762_e("Reload");
/*     */   }
/*     */   
/*     */   private void tryFire(ItemStack item, World world, EntityPlayer player) {
/* 284 */     if (player.field_82175_bq) {
/* 285 */       return;
/*     */     }
/* 287 */     if (world.field_72995_K) {
/* 288 */       return;
/*     */     }
/* 290 */     boolean infinite = (player.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/*     */     
/* 292 */     if (getAmmunition(item) > 0) {
/* 293 */       int ammo = getAmmunition(item);
/*     */       
/* 295 */       ItemStack load = getNextShot(item, ammo);
/*     */       
/* 297 */       if (!CrossbowAmmo.shoot(item, world, player, this.firearm.getAccuracy(), this.firearm.getDamage(), load)) {
/* 298 */         return;
/*     */       }
/* 300 */       item.func_77972_a(1, player);
/* 301 */       world.func_72956_a(player, MFResource.sound("Weapon.crossbow"), 4.0F, 1.0F);
/* 302 */       removeAmmo(item);
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemStack getNextShot(ItemStack item, int ammo) {
/* 307 */     NBTTagCompound nbt = getNbt(item);
/*     */     
/* 309 */     int id = 0;
/* 310 */     int sub = 0;
/* 311 */     if (nbt.func_74764_b("Ammo_" + ammo)) {
/* 312 */       id = nbt.func_74762_e("Ammo_" + ammo);
/*     */     }
/* 314 */     if (nbt.func_74764_b("AmmoSub_" + ammo)) {
/* 315 */       sub = nbt.func_74762_e("AmmoSub_" + ammo);
/*     */     }
/* 317 */     if (id > 0) {
/* 318 */       return new ItemStack(id, 1, sub);
/*     */     }
/*     */     
/* 321 */     return null;
/*     */   }
/*     */   
/*     */   public Icon getHeadItem(ItemStack item) {
/* 325 */     return getAmmunition(item) == 0 ? this.head[0] : this.head[1];
/*     */   }
/*     */   
/*     */   public Icon getStockItem(ItemStack item) {
/* 329 */     return this.stock;
/*     */   }
/*     */   
/*     */   public int func_77619_b() {
/* 333 */     return this.firearm.getEnchantment();
/*     */   }
/*     */   
/*     */   public boolean alterTexture() {
/* 337 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/* 343 */     this.stock = reg.func_94245_a("MineFantasy:Weapon/" + this.firearm.getName() + "_stock");
/*     */     
/* 345 */     this.head = new Icon[2];
/* 346 */     this.head[0] = reg.func_94245_a("MineFantasy:Weapon/" + this.firearm.getName() + "_unload");
/* 347 */     this.head[1] = reg.func_94245_a("MineFantasy:Weapon/" + this.firearm.getName() + "_loaded");
/*     */   }
/*     */   
/*     */   public boolean hasAmmo(EntityPlayer player) {
/* 351 */     if (this.ammoItem == EnumAmmo.ARROW) {
/* 352 */       return CrossbowAmmo.hasArrow(player);
/*     */     }
/* 354 */     return CrossbowAmmo.hasBolt(player);
/*     */   }
/*     */   
/*     */   public float headXoffset()
/*     */   {
/* 359 */     if (this.firearm == EnumCrossbowType.HEAVY_CROSSBOW) {
/* 360 */       return -0.2F;
/*     */     }
/* 362 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float headYoffset() {
/* 366 */     if (this.firearm == EnumCrossbowType.HEAVY_CROSSBOW) {
/* 367 */       return 0.1F;
/*     */     }
/* 369 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public boolean canUseRenderer(ItemStack item)
/*     */   {
/* 374 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemCrossbow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */