/*     */ package minefantasy.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.awt.Color;
/*     */ import java.util.List;
/*     */ import minefantasy.MineFantasyBase;
/*     */ import minefantasy.api.forge.HeatableItem;
/*     */ import minefantasy.api.forge.IHotItem;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockCauldron;
/*     */ import net.minecraft.block.BlockFire;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.EnumMovingObjectType;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemHotItem extends Item implements IHotItem
/*     */ {
/*     */   public ItemHotItem(int id)
/*     */   {
/*  32 */     super(id);
/*  33 */     func_77627_a(true);
/*  34 */     func_77625_d(1);
/*     */   }
/*     */   
/*     */   public static int getTemp(ItemStack item) {
/*  38 */     NBTTagCompound tag = getNBT(item);
/*     */     
/*  40 */     if (tag.func_74764_b("MFtemp")) {
/*  41 */       return tag.func_74762_e("MFtemp");
/*     */     }
/*  43 */     return 0;
/*     */   }
/*     */   
/*     */   public static ItemStack getItem(ItemStack item) {
/*  47 */     NBTTagCompound tag = getNBT(item);
/*     */     
/*  49 */     if ((tag.func_74764_b("ingotID")) && (tag.func_74764_b("ingotMeta"))) {
/*  50 */       return new ItemStack(tag.func_74762_e("ingotID"), 1, tag.func_74762_e("ingotMeta"));
/*     */     }
/*     */     
/*  53 */     return null;
/*     */   }
/*     */   
/*     */   public static void setTemp(ItemStack item, int heat) {
/*  57 */     NBTTagCompound nbt = getNBT(item);
/*     */     
/*  59 */     nbt.func_74768_a("MFtemp", heat);
/*     */   }
/*     */   
/*     */   public static ItemStack createHotItem(ItemStack item) {
/*  63 */     return createHotItem(item, true);
/*     */   }
/*     */   
/*     */   public static ItemStack createHotItem(ItemStack item, boolean display) {
/*  67 */     ItemStack out = new ItemStack(ItemListMF.hotItem);
/*  68 */     NBTTagCompound nbt = getNBT(out);
/*     */     
/*  70 */     nbt.func_74768_a("ingotID", item.field_77993_c);
/*  71 */     nbt.func_74768_a("ingotMeta", item.func_77960_j());
/*  72 */     nbt.func_74757_a("showMFTemp", display);
/*     */     
/*  74 */     return out;
/*     */   }
/*     */   
/*     */ 
/*     */   public String func_77628_j(ItemStack stack)
/*     */   {
/*  80 */     String name = "";
/*     */     
/*  82 */     ItemStack item = getItem(stack);
/*  83 */     if (item != null)
/*  84 */       name = item.func_77973_b().func_77628_j(item);
/*  85 */     return StatCollector.func_74838_a("item.hotItem.name") + " " + name;
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack stack)
/*     */   {
/*  90 */     ItemStack item = getItem(stack);
/*  91 */     if (item != null) {
/*  92 */       return item.func_77973_b().func_77613_e(item);
/*     */     }
/*  94 */     return EnumRarity.common;
/*     */   }
/*     */   
/*     */   public static boolean showTemp(ItemStack stack) {
/*  98 */     if (stack == null) {
/*  99 */       return false;
/*     */     }
/* 101 */     NBTTagCompound nbt = getNBT(stack);
/*     */     
/* 103 */     if (nbt == null) {
/* 104 */       return false;
/*     */     }
/* 106 */     if (nbt.func_74764_b("showMFTemp")) {
/* 107 */       return nbt.func_74767_n("showMFTemp");
/*     */     }
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   private static NBTTagCompound getNBT(ItemStack item) {
/* 113 */     if (!item.func_77942_o())
/* 114 */       item.func_77982_d(new NBTTagCompound());
/* 115 */     return item.func_77978_p();
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack stack, EntityPlayer player, List list, boolean b)
/*     */   {
/* 120 */     ItemStack item = getItem(stack);
/*     */     
/* 122 */     if (item != null) {
/* 123 */       item.func_77973_b().func_77624_a(item, player, list, b);
/*     */     } else {
/* 125 */       super.func_77624_a(stack, player, list, b);
/*     */     }
/* 127 */     NBTTagCompound nbt = getNBT(stack);
/* 128 */     if ((nbt.func_74764_b("showMFTemp")) && 
/* 129 */       (nbt.func_74767_n("showMFTemp"))) {
/* 130 */       list.add(getHeatString(stack));
/* 131 */       if (!getWorkString(item, stack).equals("")) {
/* 132 */         list.add(getWorkString(item, stack));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private String getHeatString(ItemStack item) {
/* 138 */     int heat = getTemp(item);
/* 139 */     String unit = "*C";
/* 140 */     return heat + unit;
/*     */   }
/*     */   
/*     */   private String getWorkString(ItemStack heated, ItemStack item) {
/* 144 */     byte stage = HeatableItem.getHeatableStage(heated, getTemp(item));
/* 145 */     switch (stage) {
/*     */     case 0: 
/* 147 */       return "";
/*     */     case 1: 
/* 149 */       return EnumChatFormatting.YELLOW + StatCollector.func_74838_a("state.workable");
/*     */     case 2: 
/* 151 */       return EnumChatFormatting.RED + StatCollector.func_74838_a("state.unstable");
/*     */     }
/* 153 */     return "";
/*     */   }
/*     */   
/*     */   public Icon getIcon(ItemStack stack, int renderPass) {
/* 157 */     ItemStack item = getItem(stack);
/*     */     
/* 159 */     if (item != null) {
/* 160 */       return item.func_77973_b().getIcon(item, renderPass);
/*     */     }
/* 162 */     return Block.field_72067_ar.func_71851_a(0);
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg) {}
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
/*     */   {
/* 171 */     MovingObjectPosition movingobjectposition = func_77621_a(world, player, true);
/*     */     
/* 173 */     if (movingobjectposition == null) {
/* 174 */       return item;
/*     */     }
/* 176 */     if (movingobjectposition.field_72313_a == EnumMovingObjectType.TILE) {
/* 177 */       int i = movingobjectposition.field_72311_b;
/* 178 */       int j = movingobjectposition.field_72312_c;
/* 179 */       int k = movingobjectposition.field_72309_d;
/*     */       
/* 181 */       if (!world.func_72962_a(player, i, j, k)) {
/* 182 */         return item;
/*     */       }
/*     */       
/* 185 */       if (!player.func_82247_a(i, j, k, movingobjectposition.field_72310_e, item)) {
/* 186 */         return item;
/*     */       }
/*     */       
/* 189 */       if (isWaterSource(world, i, j, k)) {
/* 190 */         player.func_85030_a("random.splash", 1.0F, 1.0F);
/* 191 */         player.func_85030_a("random.fizz", 2.0F, 0.5F);
/*     */         
/* 193 */         for (int a = 0; a < 5; a++) {
/* 194 */           world.func_72869_a("largesmoke", i + 0.5F, j + 1, k + 0.5F, 0.0D, 0.06499999761581421D, 0.0D);
/*     */         }
/*     */         
/* 197 */         ItemStack drop = getItem(item).func_77946_l();
/* 198 */         drop.field_77994_a = item.field_77994_a;
/* 199 */         if (drop != null) {
/* 200 */           item.field_77994_a = 0;
/*     */           
/* 202 */           if (item.field_77994_a <= 0) {
/* 203 */             return drop.func_77946_l();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 209 */     return item;
/*     */   }
/*     */   
/*     */   private boolean isWaterSource(World world, int i, int j, int k)
/*     */   {
/* 214 */     if (world.func_72803_f(i, j, k) == Material.field_76244_g) {
/* 215 */       return true;
/*     */     }
/* 217 */     if (isCauldron(world, i, j, k)) {
/* 218 */       return true;
/*     */     }
/* 220 */     return false;
/*     */   }
/*     */   
/*     */   public int func_82790_a(ItemStack item, int renderPass) {
/* 224 */     if ((renderPass > 1) || (!cfg.renderHot)) {
/* 225 */       return Color.WHITE.getRGB();
/*     */     }
/* 227 */     NBTTagCompound nbt = getNBT(item);
/* 228 */     if (!nbt.func_74764_b("showMFTemp")) {
/* 229 */       return Color.RED.getRGB();
/*     */     }
/* 231 */     if (!nbt.func_74767_n("showMFTemp")) {
/* 232 */       return Color.RED.getRGB();
/*     */     }
/* 234 */     int heat = getTemp(item);
/* 235 */     int maxHeat = cfg.maxHeat;
/* 236 */     double heatPer = heat / maxHeat * 100.0D;
/*     */     
/* 238 */     int red = getRedOnHeat(heatPer);
/* 239 */     int green = getGreenOnHeat(heatPer);
/* 240 */     int blue = getBlueOnHeat(heatPer);
/*     */     
/* 242 */     if (heat > 0) {
/* 243 */       return MineFantasyBase.getColourForRGB(red, green, blue);
/*     */     }
/*     */     
/* 246 */     return Color.WHITE.getRGB();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77623_v() {
/* 251 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getRedOnHeat(double percent)
/*     */   {
/* 261 */     return 255;
/*     */   }
/*     */   
/*     */   private int getGreenOnHeat(double percent) {
/* 265 */     if (percent > 100.0D)
/* 266 */       percent = 100.0D;
/* 267 */     if (percent < 0.0D) {
/* 268 */       percent = 0.0D;
/*     */     }
/* 270 */     if (percent <= 55.0D) {
/* 271 */       return (int)(255.0D - 4.0D * percent);
/*     */     }
/* 273 */     return (int)(4.0D * (percent - 55.0D));
/*     */   }
/*     */   
/*     */   private int getBlueOnHeat(double percent)
/*     */   {
/* 278 */     if (percent > 100.0D)
/* 279 */       percent = 100.0D;
/* 280 */     if (percent < 0.0D) {
/* 281 */       percent = 0.0D;
/*     */     }
/* 283 */     if (percent <= 55.0D) {
/* 284 */       return (int)(255.0D - 4.0D * percent);
/*     */     }
/* 286 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean isCauldron(World world, int x, int y, int z) {
/* 290 */     return (world.func_72798_a(x, y, z) == Block.field_72108_bG.field_71990_ca) && (world.func_72805_g(x, y, z) > 0);
/*     */   }
/*     */   
/*     */   public boolean isHot(ItemStack item)
/*     */   {
/* 295 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isCoolable(ItemStack item)
/*     */   {
/* 300 */     return true;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemHotItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */