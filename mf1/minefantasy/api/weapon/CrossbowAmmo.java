/*     */ package minefantasy.api.weapon;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class CrossbowAmmo
/*     */ {
/*  14 */   private static List<ItemStack> bolts = new ArrayList();
/*  15 */   private static List<ItemStack> arrows = new ArrayList();
/*  16 */   private static List<ICrossbowHandler> handlers = new ArrayList();
/*     */   
/*     */   public static void addCrossbowAmmo(int id, EnumAmmo type) {
/*  19 */     addCrossbowAmmo(new ItemStack(id, 1, 0), type);
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
/*     */   public static void addCrossbowAmmo(ItemStack arrow, EnumAmmo type)
/*     */   {
/*  35 */     if (type == EnumAmmo.ARROW) {
/*  36 */       arrows.add(arrow);
/*     */     } else {
/*  38 */       bolts.add(arrow);
/*     */     }
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
/*     */   public static void addArrow(int id)
/*     */   {
/*  53 */     addCrossbowAmmo(id, EnumAmmo.ARROW);
/*     */   }
/*     */   
/*     */   public static void addArrow(ItemStack id) {
/*  57 */     addCrossbowAmmo(id, EnumAmmo.ARROW);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addBolt(int id)
/*     */   {
/*  67 */     addCrossbowAmmo(id, EnumAmmo.BOLT);
/*     */   }
/*     */   
/*     */   public static void addBolt(ItemStack id) {
/*  71 */     addCrossbowAmmo(id, EnumAmmo.BOLT);
/*     */   }
/*     */   
/*     */   public static boolean canLoadArrow(EntityPlayer player, ItemStack arrow, boolean infinite) {
/*  75 */     if (infinite) {
/*  76 */       return true;
/*     */     }
/*     */     
/*  79 */     if (arrows.contains(arrow)) {
/*  80 */       boolean hasInfiniteItem = (player.field_71071_by.func_70431_c(arrow)) && (player.field_71075_bZ.field_75098_d);
/*     */       
/*  82 */       if ((hasInfiniteItem) || (consumePlayerItem(player, arrow))) {
/*  83 */         return true;
/*     */       }
/*     */     }
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean canLoadBolt(EntityPlayer player, ItemStack bolt, boolean infinite) {
/*  90 */     if (infinite)
/*  91 */       return true;
/*  92 */     if (bolts.contains(bolt)) {
/*  93 */       boolean hasInfiniteItem = (player.field_71071_by.func_70431_c(bolt)) && (player.field_71075_bZ.field_75098_d);
/*  94 */       if ((hasInfiniteItem) || (consumePlayerItem(player, bolt))) {
/*  95 */         return true;
/*     */       }
/*     */     }
/*  98 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ItemStack tryLoadArrow(EntityPlayer player, boolean infinite)
/*     */   {
/* 109 */     if (arrows.isEmpty()) {
/* 110 */       return null;
/*     */     }
/* 112 */     for (ItemStack arrow : arrows) {
/* 113 */       if (canLoadArrow(player, arrow, infinite)) {
/* 114 */         return arrow;
/*     */       }
/*     */     }
/*     */     
/* 118 */     if (player.field_71075_bZ.field_75098_d) {
/* 119 */       return new ItemStack(Item.field_77704_l);
/*     */     }
/*     */     
/* 122 */     if (infinite) {
/* 123 */       return new ItemStack(Item.field_77704_l);
/*     */     }
/* 125 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ItemStack tryLoadBolt(EntityPlayer player, boolean infinite)
/*     */   {
/* 136 */     if (bolts.isEmpty()) {
/* 137 */       return null;
/*     */     }
/* 139 */     for (ItemStack bolt : bolts) {
/* 140 */       if (canLoadBolt(player, bolt, infinite)) {
/* 141 */         return bolt;
/*     */       }
/*     */     }
/*     */     
/* 145 */     if ((infinite) || (player.field_71075_bZ.field_75098_d)) {
/* 146 */       if (minefantasy.api.MineFantasyAPI.isModLoaded()) {
/* 147 */         return minefantasy.api.Components.getItem("boltMF", 2);
/*     */       }
/* 149 */       return new ItemStack(Item.field_77704_l);
/*     */     }
/* 151 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean hasArrow(EntityPlayer player)
/*     */   {
/* 158 */     if (arrows.isEmpty()) {
/* 159 */       return false;
/*     */     }
/* 161 */     for (ItemStack arrow : arrows) {
/* 162 */       if (player.field_71071_by.func_70431_c(arrow)) {
/* 163 */         return true;
/*     */       }
/*     */     }
/* 166 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static boolean hasBolt(EntityPlayer player)
/*     */   {
/* 173 */     if (bolts.isEmpty()) {
/* 174 */       return false;
/*     */     }
/* 176 */     for (ItemStack bolt : bolts) {
/* 177 */       if (player.field_71071_by.func_70431_c(bolt)) {
/* 178 */         return true;
/*     */       }
/*     */     }
/* 181 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addCrossbowHandler(ICrossbowHandler handler)
/*     */   {
/* 191 */     handlers.add(handler);
/*     */   }
/*     */   
/*     */   public static boolean shoot(ItemStack item, World world, EntityPlayer player, float accuracy, float power, ItemStack load) {
/* 195 */     if (load == null) {
/* 196 */       return false;
/*     */     }
/* 198 */     for (ICrossbowHandler handler : handlers) {
/* 199 */       if (handler.shoot(item, world, player, accuracy, power, load))
/* 200 */         return true;
/*     */     }
/* 202 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean consumePlayerItem(EntityPlayer player, ItemStack item) {
/* 206 */     for (int a = 0; a < player.field_71071_by.func_70302_i_(); a++) {
/* 207 */       ItemStack i = player.field_71071_by.func_70301_a(a);
/* 208 */       if ((i != null) && (i.func_77969_a(item))) {
/* 209 */         player.field_71071_by.func_70298_a(a, 1);
/* 210 */         return true;
/*     */       }
/*     */     }
/* 213 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/weapon/CrossbowAmmo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */