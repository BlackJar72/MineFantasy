/*     */ package minefantasy.item.weapon;
/*     */ 
/*     */ import cpw.mods.fml.common.network.PacketDispatcher;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.PrintStream;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import minefantasy.api.aesthetic.IWeaponrackHangable;
/*     */ import minefantasy.api.arrow.Arrows;
/*     */ import minefantasy.item.ItemListMF;
/*     */ import minefantasy.item.ToolMaterialMedieval;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.EnumToolMaterial;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.packet.Packet;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.EventBus;
/*     */ import net.minecraftforge.event.entity.player.ArrowLooseEvent;
/*     */ import net.minecraftforge.event.entity.player.ArrowNockEvent;
/*     */ 
/*     */ public class ItemBowMF extends ItemBow implements minefantasy.api.arrow.ISpecialBow, IWeaponrackHangable
/*     */ {
/*  42 */   public static final DecimalFormat decimal_format = new DecimalFormat("#.##");
/*  43 */   public Icon[] field_94600_b = new Icon[3];
/*     */   private final EnumBowType model;
/*  45 */   private EnumToolMaterial material = EnumToolMaterial.WOOD;
/*     */   
/*     */   public ItemBowMF(int id, EnumToolMaterial mat, EnumBowType type) {
/*  48 */     this(id, (int)(mat.func_77997_a() * type.durability), type);
/*  49 */     this.material = mat;
/*     */   }
/*     */   
/*     */   public ItemBowMF(int id, int dura, EnumBowType type) {
/*  53 */     super(id);
/*  54 */     this.model = type;
/*  55 */     this.field_77777_bU = 1;
/*  56 */     func_77656_e(dura);
/*  57 */     func_77637_a(ItemListMF.tabArcher);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77662_d()
/*     */   {
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public int getId() {
/*  69 */     if (this == ItemListMF.bowIronbark)
/*  70 */       return 1;
/*  71 */     if (this == ItemListMF.bowEbony)
/*  72 */       return 2;
/*  73 */     if (this == ItemListMF.longbow) {
/*  74 */       return 3;
/*     */     }
/*  76 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_77615_a(ItemStack item, World world, EntityPlayer player, int time)
/*     */   {
/*  84 */     int power = func_77626_a(item) - time;
/*  85 */     power = (int)(power * this.model.speed);
/*     */     
/*  87 */     power = (int)(power / 20.0F * getMaxPower());
/*     */     
/*     */ 
/*  90 */     if (power > getMaxPower()) {
/*  91 */       power = (int)getMaxPower();
/*     */     }
/*  93 */     ArrowLooseEvent event = new ArrowLooseEvent(player, item, power);
/*  94 */     MinecraftForge.EVENT_BUS.post(event);
/*  95 */     if (event.isCanceled()) {
/*  96 */       return;
/*     */     }
/*  98 */     power = event.charge;
/*     */     
/* 100 */     boolean var5 = (player.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/*     */     
/* 102 */     if ((var5) || (player.field_71071_by.func_70450_e(Item.field_77704_l.field_77779_bT))) {
/* 103 */       float var7 = power / 20.0F;
/* 104 */       var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
/*     */       
/* 106 */       if (var7 < 0.1D) {
/* 107 */         return;
/*     */       }
/*     */       
/* 110 */       if (var7 > 1.0F) {
/* 111 */         var7 = 1.0F;
/*     */       }
/*     */       
/* 114 */       EntityArrow var8 = new EntityArrow(world, player, var7 * 2.0F);
/*     */       
/* 116 */       if (var7 == 1.0F) {
/* 117 */         var8.func_70243_d(true);
/*     */       }
/*     */       
/* 120 */       int var9 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, item);
/*     */       
/* 122 */       if (var9 > 0) {
/* 123 */         var8.func_70239_b(var8.func_70242_d() + var9 * 0.5D + 0.5D);
/*     */       }
/*     */       
/* 126 */       int var10 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, item);
/*     */       
/* 128 */       if (var10 > 0) {
/* 129 */         var8.func_70240_a(var10);
/*     */       }
/*     */       
/* 132 */       if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, item) > 0) {
/* 133 */         var8.func_70015_d(100);
/*     */       }
/*     */       
/* 136 */       item.func_77972_a(1, player);
/* 137 */       world.func_72956_a(player, "random.bow", 1.0F, 1.0F / (field_77697_d.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
/*     */       
/* 139 */       if (var5) {
/* 140 */         var8.field_70251_a = 2;
/*     */       } else {
/* 142 */         player.field_71071_by.func_70435_d(Item.field_77704_l.field_77779_bT);
/*     */       }
/*     */       
/* 145 */       if (!world.field_72995_K) {
/* 146 */         world.func_72838_d(var8);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private float getMaxPower()
/*     */   {
/* 155 */     return 20.0F * this.model.power;
/*     */   }
/*     */   
/*     */   public ItemStack onFoodEaten(ItemStack item, World world, EntityPlayer player) {
/* 159 */     return item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_77626_a(ItemStack item)
/*     */   {
/* 166 */     return 72000;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumAction func_77661_b(ItemStack item)
/*     */   {
/* 174 */     return EnumAction.bow;
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack item, EntityPlayer player, List desc, boolean flag) {
/* 178 */     super.func_77624_a(item, player, desc, flag);
/*     */     
/* 180 */     float power = this.model.power;
/* 181 */     desc.add(EnumChatFormatting.BLUE + StatCollector.func_74837_a("attribute.modifier.plus.0", new Object[] { decimal_format.format(power), StatCollector.func_74838_a("attribute.arrow.force") }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
/*     */   {
/* 190 */     ArrowNockEvent event = new ArrowNockEvent(player, item);
/* 191 */     MinecraftForge.EVENT_BUS.post(event);
/* 192 */     if (event.isCanceled()) {
/* 193 */       return event.result;
/*     */     }
/*     */     
/* 196 */     if ((player.field_71075_bZ.field_75098_d) || (player.field_71071_by.func_70450_e(Item.field_77704_l.field_77779_bT))) {
/* 197 */       player.func_71008_a(item, func_77626_a(item));
/*     */     }
/*     */     
/* 200 */     return item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_77619_b()
/*     */   {
/* 208 */     return 1;
/*     */   }
/*     */   
/*     */   public Icon getIconIndex(ItemStack stack, int useRemaining) {
/* 212 */     float multiplier = 1.0F / this.model.speed;
/*     */     
/* 214 */     if (stack != null) {
/* 215 */       if (useRemaining >= 18.0F * multiplier)
/* 216 */         return this.field_94600_b[2];
/* 217 */       if (useRemaining > 13.0F * multiplier) {
/* 218 */         return this.field_94600_b[1];
/*     */       }
/* 220 */       if (useRemaining > 0)
/* 221 */         return this.field_94600_b[0];
/*     */     }
/* 223 */     return func_77617_a(0);
/*     */   }
/*     */   
/*     */   public void func_77663_a(ItemStack item, World world, Entity entity, int i, boolean b)
/*     */   {
/* 228 */     super.func_77663_a(item, world, entity, i, b);
/* 229 */     if (!item.func_77942_o())
/* 230 */       item.func_77982_d(new NBTTagCompound());
/* 231 */     item.field_77990_d.func_74768_a("Use", i);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/* 237 */     this.field_77791_bV = reg.func_94245_a(func_111208_A());
/* 238 */     for (int i = 0; i < 3; i++) {
/* 239 */       this.field_94600_b[i] = reg.func_94245_a(func_111208_A() + "_" + (i + 1));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Icon func_94599_c(int use)
/*     */   {
/* 248 */     return this.field_94600_b[use];
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/* 253 */     func_111206_d("minefantasy:Archery/" + name);
/* 254 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   public int getDrawAmount(int timer) {
/* 258 */     float multiplier = 1.0F / this.model.speed;
/*     */     
/* 260 */     if (timer >= 18.0F * multiplier)
/* 261 */       return 2;
/* 262 */     if (timer > 13.0F * multiplier)
/* 263 */       return 1;
/* 264 */     if (timer > 0) {
/* 265 */       return 0;
/*     */     }
/* 267 */     return -2;
/*     */   }
/*     */   
/*     */   public ItemStack getArrow(ItemStack item) {
/* 271 */     ItemStack arrow = Arrows.getLoadedArrow(item);
/* 272 */     if (arrow == null) {
/* 273 */       return new ItemStack(Item.field_77704_l);
/*     */     }
/* 275 */     return arrow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void loadArrow(EntityPlayer player, ItemStack bow, ItemStack arrow, boolean sendPacket)
/*     */   {
/* 287 */     NBTTagCompound nbt = getOrApplyNBT(bow);
/*     */     
/* 289 */     if (arrow == null) {
/* 290 */       nbt.func_82580_o("arrowID");
/* 291 */       nbt.func_82580_o("arrowSub");
/*     */     } else {
/* 293 */       nbt.func_74768_a("arrowID", arrow.field_77993_c);
/* 294 */       nbt.func_74768_a("arrowSub", arrow.func_77960_j());
/*     */       
/* 296 */       if (sendPacket) {
/*     */         try {
/* 298 */           Packet packet = minefantasy.system.network.PacketManagerMF.getArrowItemPacket(player, arrow.field_77993_c, arrow.func_77960_j());
/*     */           
/* 300 */           PacketDispatcher.sendPacketToAllAround(player.field_70165_t, player.field_70163_u, player.field_70161_v, 16.0D, player.field_71093_bK, packet);
/*     */         } catch (Exception e) {
/* 302 */           System.err.println("MineFantasy: Failed to send arrow render packet to bow");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static NBTTagCompound getOrApplyNBT(ItemStack item) {
/* 309 */     if (!item.func_77942_o()) {
/* 310 */       item.func_77982_d(new NBTTagCompound());
/*     */     }
/* 312 */     return item.func_77978_p();
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*     */   {
/* 317 */     if (tabs != ItemListMF.tabArcher) {
/* 318 */       super.func_77633_a(id, tabs, list);
/* 319 */       return;
/*     */     }
/* 321 */     if (id != ItemListMF.shortbow.field_77779_bT) {
/* 322 */       return;
/*     */     }
/* 324 */     add(list, ItemListMF.shortbow);
/*     */     
/* 326 */     add(list, ItemListMF.bowBronze);
/* 327 */     add(list, ItemListMF.bowIron);
/* 328 */     add(list, ItemListMF.bowOrnate);
/* 329 */     add(list, ItemListMF.bowSteel);
/* 330 */     add(list, ItemListMF.bowDragon);
/* 331 */     add(list, ItemListMF.bowDeepIron);
/* 332 */     add(list, ItemListMF.bowMithril);
/*     */     
/* 334 */     add(list, ItemListMF.bowComposite);
/* 335 */     add(list, ItemListMF.bowIronbark);
/* 336 */     add(list, ItemListMF.bowEbony);
/*     */     
/* 338 */     add(list, ItemListMF.longbow);
/*     */     
/* 340 */     ItemListMF.arrowMF.func_77633_a(ItemListMF.arrowMF.field_77779_bT, tabs, list);
/* 341 */     ItemListMF.boltMF.func_77633_a(ItemListMF.arrowMF.field_77779_bT, tabs, list);
/*     */   }
/*     */   
/*     */   private void add(List list, Item item) {
/* 345 */     list.add(new ItemStack(item));
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack itemStack)
/*     */   {
/* 350 */     if (getMaterial() == ToolMaterialMedieval.EBONY) {
/* 351 */       return rarity(itemStack, 1);
/*     */     }
/* 353 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 354 */       return rarity(itemStack, 1);
/*     */     }
/* 356 */     if (getMaterial() == ToolMaterialMedieval.IGNOTUMITE) {
/* 357 */       return rarity(itemStack, 2);
/*     */     }
/* 359 */     return super.func_77613_e(itemStack);
/*     */   }
/*     */   
/*     */   private EnumToolMaterial getMaterial() {
/* 363 */     return this.material;
/*     */   }
/*     */   
/*     */   private EnumRarity rarity(ItemStack item, int lvl) {
/* 367 */     EnumRarity[] rarity = { EnumRarity.common, EnumRarity.uncommon, EnumRarity.rare, EnumRarity.epic };
/* 368 */     if (item.func_77948_v()) {
/* 369 */       if (lvl == 0) {
/* 370 */         lvl++;
/*     */       }
/* 372 */       lvl++;
/*     */     }
/* 374 */     if (lvl >= rarity.length) {
/* 375 */       lvl = rarity.length - 1;
/*     */     }
/* 377 */     return rarity[lvl];
/*     */   }
/*     */   
/*     */   public Entity modifyArrow(Entity arrow)
/*     */   {
/* 382 */     if (getMaterial() == ToolMaterialMedieval.DRAGONFORGE) {
/* 383 */       arrow.func_70015_d(60);
/*     */     }
/* 385 */     return arrow;
/*     */   }
/*     */   
/*     */   public boolean canUseRenderer(ItemStack item)
/*     */   {
/* 390 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemBowMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */