/*     */ package mods.battlegear2.api.core;
/*     */ 
/*     */ import com.google.common.collect.Multimap;
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import com.google.common.io.ByteArrayDataOutput;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
/*     */ import mods.battlegear2.api.IAllowItem;
/*     */ import mods.battlegear2.api.IOffhandDual;
/*     */ import mods.battlegear2.api.shield.IShield;
/*     */ import mods.battlegear2.api.weapons.IBattlegearWeapon;
/*     */ import mods.battlegear2.api.weapons.WeaponRegistry;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.enchantment.EnchantmentThorns;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IEntityMultiPart;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.Attribute;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.boss.EntityDragonPart;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemBow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.item.ItemTool;
/*     */ import net.minecraft.nbt.CompressedStreamTools;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.stats.AchievementList;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.EventBus;
/*     */ import net.minecraftforge.event.entity.player.AttackEntityEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BattlegearUtils
/*     */ {
/*  49 */   public static final EventBus RENDER_BUS = new EventBus();
/*     */   
/*     */   private static String[] itemBlackListMethodNames;
/*     */   
/*     */ 
/*     */   static
/*     */   {
/*  56 */     if (World.class.getName().equals("net.minecraft.world.World")) {
/*  57 */       itemBlackListMethodNames = new String[] { "onItemUse", "onItemRightClick" };
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  62 */       itemBlackListMethodNames = new String[] { BattlegearTranslator.getMapedMethodName("Item", "func_77648_a", "onItemUse"), BattlegearTranslator.getMapedMethodName("Item", "func_77659_a", "onItemRightClick") };
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*  68 */   private static Class[][] itemBlackListMethodParams = { { ItemStack.class, EntityPlayer.class, World.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Float.TYPE, Float.TYPE, Float.TYPE }, { ItemStack.class, World.class, EntityPlayer.class } };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isBlockingWithShield(EntityPlayer player)
/*     */   {
/*  76 */     if (!player.func_70093_af()) {
/*  77 */       return false;
/*     */     }
/*  79 */     ItemStack offhand = ((InventoryPlayerBattle)player.field_71071_by).getCurrentOffhandWeapon();
/*  80 */     return (offhand != null) && ((offhand.func_77973_b() instanceof IShield));
/*     */   }
/*     */   
/*     */   public static boolean isPlayerInBattlemode(EntityPlayer player) {
/*  84 */     return ((InventoryPlayerBattle)player.field_71071_by).isBattlemode();
/*     */   }
/*     */   
/*     */   public static void setPlayerCurrentItem(EntityPlayer player, ItemStack stack, int offset) {
/*  88 */     ((InventoryPlayerBattle)player.field_71071_by).setInventorySlotContents(player.field_71071_by.field_70461_c + offset, stack, false);
/*     */   }
/*     */   
/*     */   public static void setPlayerCurrentItem(EntityPlayer player, ItemStack stack) {
/*  92 */     setPlayerCurrentItem(player, stack, 0);
/*     */   }
/*     */   
/*     */   public static boolean isWeapon(ItemStack main) {
/*  96 */     if ((main.func_77973_b() instanceof IBattlegearWeapon))
/*  97 */       return true;
/*  98 */     if (WeaponRegistry.isWeapon(main)) {
/*  99 */       return true;
/*     */     }
/* 101 */     boolean valid = (main.func_77976_d() == 1) && (main.func_77958_k() > 0) && (!main.func_77981_g());
/* 102 */     if (valid) {
/* 103 */       valid = ((main.func_77973_b() instanceof ItemSword)) || ((main.func_77973_b() instanceof ItemBow)) || ((main.func_77973_b() instanceof ItemTool));
/*     */     }
/*     */     
/*     */ 
/* 107 */     return valid;
/*     */   }
/*     */   
/*     */   public static boolean isMainHand(ItemStack main, ItemStack off)
/*     */   {
/* 112 */     if ((main.func_77973_b() instanceof IAllowItem))
/* 113 */       return ((IAllowItem)main.func_77973_b()).allowOffhand(main, off);
/* 114 */     if (WeaponRegistry.isMainHand(main)) {
/* 115 */       return true;
/*     */     }
/* 117 */     if (isWeapon(main))
/*     */     {
/* 119 */       boolean rightClick = checkForRightClickFunction(main.func_77973_b(), main);
/* 120 */       boolean offhand = (!(main.func_77973_b() instanceof ItemTool)) && (!(main.func_77973_b() instanceof ItemBow)) && (!rightClick);
/* 121 */       boolean mainhand = (!(main.func_77973_b() instanceof ItemBow)) && (!rightClick);
/* 122 */       if (mainhand) {
/* 123 */         if (offhand) {
/* 124 */           WeaponRegistry.addDualWeapon(main);
/*     */         } else
/* 126 */           WeaponRegistry.addTwoHanded(main);
/* 127 */         return true;
/*     */       }
/* 129 */       if (offhand) {
/* 130 */         WeaponRegistry.addOffhandWeapon(main);
/*     */       }
/*     */     }
/* 133 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean isOffHand(ItemStack off)
/*     */   {
/* 138 */     if ((off.func_77973_b() instanceof IOffhandDual))
/* 139 */       return ((IOffhandDual)off.func_77973_b()).isOffhandHandDual(off);
/* 140 */     if (((off.func_77973_b() instanceof IShield)) || ((off.func_77973_b() instanceof ItemBlock)))
/* 141 */       return true;
/* 142 */     if (WeaponRegistry.isOffHand(off)) {
/* 143 */       return true;
/*     */     }
/* 145 */     if (isWeapon(off))
/*     */     {
/* 147 */       boolean rightClick = checkForRightClickFunction(off.func_77973_b(), off);
/* 148 */       boolean offhand = (!(off.func_77973_b() instanceof ItemTool)) && (!(off.func_77973_b() instanceof ItemBow)) && (!rightClick);
/* 149 */       boolean mainhand = (!(off.func_77973_b() instanceof ItemBow)) && (!rightClick);
/* 150 */       if (offhand) {
/* 151 */         if (mainhand) {
/* 152 */           WeaponRegistry.addDualWeapon(off);
/*     */         } else
/* 154 */           WeaponRegistry.addOffhandWeapon(off);
/* 155 */         return true;
/*     */       }
/* 157 */       if (mainhand) {
/* 158 */         WeaponRegistry.addTwoHanded(off);
/*     */       }
/*     */     }
/* 161 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean checkForRightClickFunction(Item item, ItemStack stack)
/*     */   {
/*     */     try
/*     */     {
/* 168 */       if ((item.func_77661_b(stack) == EnumAction.block) || (item.func_77661_b(stack) == EnumAction.none))
/*     */       {
/* 170 */         Class c = item.getClass();
/* 171 */         while ((!c.equals(Item.class)) && (!c.equals(ItemTool.class)) && (!c.equals(ItemSword.class)))
/*     */         {
/*     */           try {
/* 174 */             c.getDeclaredMethod(itemBlackListMethodNames[0], itemBlackListMethodParams[0]);
/* 175 */             return true;
/*     */           }
/*     */           catch (NoSuchMethodException localNoSuchMethodException)
/*     */           {
/*     */             try {
/* 180 */               c.getDeclaredMethod(itemBlackListMethodNames[1], itemBlackListMethodParams[1]);
/* 181 */               return true;
/*     */             }
/*     */             catch (NoSuchMethodException localNoSuchMethodException1) {}
/*     */           }
/*     */           catch (NoClassDefFoundError localNoClassDefFoundError) {}
/*     */           
/*     */ 
/* 188 */           c = c.getSuperclass();
/*     */         }
/*     */         
/* 191 */         return false;
/*     */       }
/* 193 */       return true;
/*     */     }
/*     */     catch (NullPointerException e) {}
/* 196 */     return true;
/*     */   }
/*     */   
/*     */   public static ItemStack readItemStack(ByteArrayDataInput par0DataInputStream)
/*     */     throws IOException
/*     */   {
/* 202 */     ItemStack itemstack = null;
/* 203 */     short short1 = par0DataInputStream.readShort();
/*     */     
/* 205 */     if (short1 >= 0) {
/* 206 */       byte b0 = par0DataInputStream.readByte();
/* 207 */       short short2 = par0DataInputStream.readShort();
/* 208 */       itemstack = new ItemStack(short1, b0, short2);
/* 209 */       itemstack.field_77990_d = readNBTTagCompound(par0DataInputStream);
/*     */     }
/*     */     
/* 212 */     return itemstack;
/*     */   }
/*     */   
/*     */ 
/*     */   public static NBTTagCompound readNBTTagCompound(ByteArrayDataInput par0DataInputStream)
/*     */     throws IOException
/*     */   {
/* 219 */     short short1 = par0DataInputStream.readShort();
/*     */     
/* 221 */     if (short1 < 0) {
/* 222 */       return null;
/*     */     }
/* 224 */     byte[] abyte = new byte[short1];
/* 225 */     par0DataInputStream.readFully(abyte);
/*     */     
/* 227 */     return CompressedStreamTools.func_74792_a(abyte);
/*     */   }
/*     */   
/*     */   public static void writeItemStack(ByteArrayDataOutput par1DataOutputStream, ItemStack par0ItemStack)
/*     */     throws IOException
/*     */   {
/* 233 */     if (par0ItemStack == null) {
/* 234 */       par1DataOutputStream.writeShort(-1);
/*     */     } else {
/* 236 */       par1DataOutputStream.writeShort(par0ItemStack.field_77993_c);
/* 237 */       par1DataOutputStream.writeByte(par0ItemStack.field_77994_a);
/* 238 */       par1DataOutputStream.writeShort(par0ItemStack.func_77960_j());
/* 239 */       NBTTagCompound nbttagcompound = null;
/*     */       
/* 241 */       if ((par0ItemStack.func_77973_b().func_77645_m()) || (par0ItemStack.func_77973_b().func_77651_p())) {
/* 242 */         nbttagcompound = par0ItemStack.field_77990_d;
/*     */       }
/*     */       
/* 245 */       writeNBTTagCompound(nbttagcompound, par1DataOutputStream);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static void writeNBTTagCompound(NBTTagCompound par0NBTTagCompound, ByteArrayDataOutput par1DataOutputStream) throws IOException
/*     */   {
/* 251 */     if (par0NBTTagCompound == null) {
/* 252 */       par1DataOutputStream.writeShort(-1);
/*     */     } else {
/* 254 */       byte[] abyte = CompressedStreamTools.func_74798_a(par0NBTTagCompound);
/* 255 */       par1DataOutputStream.writeShort((short)abyte.length);
/* 256 */       par1DataOutputStream.write(abyte);
/*     */     }
/*     */   }
/*     */   
/*     */   public static InventoryPlayer replaceInventory(EntityPlayer entityPlayer) {
/* 261 */     return new InventoryPlayerBattle(entityPlayer);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void attackTargetEntityWithCurrentOffItem(EntityPlayer player, Entity par1Entity)
/*     */   {
/* 272 */     player.field_71071_by.field_70461_c += InventoryPlayerBattle.WEAPON_SETS;
/* 273 */     if (MinecraftForge.EVENT_BUS.post(new AttackEntityEvent(player, par1Entity)))
/*     */     {
/* 275 */       player.field_71071_by.field_70461_c -= InventoryPlayerBattle.WEAPON_SETS;
/* 276 */       return;
/*     */     }
/* 278 */     ItemStack stack = player.func_71045_bC();
/* 279 */     if ((stack != null) && (stack.func_77973_b().onLeftClickEntity(stack, player, par1Entity)))
/*     */     {
/* 281 */       player.field_71071_by.field_70461_c -= InventoryPlayerBattle.WEAPON_SETS;
/* 282 */       return;
/*     */     }
/* 284 */     if (par1Entity.func_70075_an())
/*     */     {
/* 286 */       if (!par1Entity.func_85031_j(player))
/*     */       {
/* 288 */         float f = 1.0F;
/* 289 */         if (stack != null) {
/* 290 */           Collection map = stack.func_111283_C().get(SharedMonsterAttributes.field_111264_e.func_111108_a());
/*     */           
/* 292 */           for (Object ob : map) {
/* 293 */             if ((ob instanceof AttributeModifier)) {
/* 294 */               AttributeModifier am = (AttributeModifier)ob;
/* 295 */               if (am.func_111166_b().equals("Weapon modifier")) {
/* 296 */                 f = (float)(f + am.func_111164_d());
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 302 */         int i = 0;
/* 303 */         float f1 = 0.0F;
/*     */         
/* 305 */         if ((par1Entity instanceof EntityLivingBase))
/*     */         {
/* 307 */           f1 = EnchantmentHelper.func_77512_a(player, (EntityLivingBase)par1Entity);
/* 308 */           i += EnchantmentHelper.func_77507_b(player, (EntityLivingBase)par1Entity);
/*     */         }
/*     */         
/* 311 */         if (player.func_70051_ag())
/*     */         {
/* 313 */           i++;
/*     */         }
/*     */         
/* 316 */         if ((f > 0.0F) || (f1 > 0.0F))
/*     */         {
/* 318 */           boolean flag = (player.field_70143_R > 0.0F) && (!player.field_70122_E) && (!player.func_70617_f_()) && (!player.func_70090_H()) && (!player.func_70644_a(Potion.field_76440_q)) && (player.field_70154_o == null) && ((par1Entity instanceof EntityLivingBase));
/*     */           
/* 320 */           if ((flag) && (f > 0.0F))
/*     */           {
/* 322 */             f *= 1.5F;
/*     */           }
/*     */           
/* 325 */           f += f1;
/* 326 */           boolean flag1 = false;
/* 327 */           int j = EnchantmentHelper.func_90036_a(player);
/*     */           
/* 329 */           if (((par1Entity instanceof EntityLivingBase)) && (j > 0) && (!par1Entity.func_70027_ad()))
/*     */           {
/* 331 */             flag1 = true;
/* 332 */             par1Entity.func_70015_d(1);
/*     */           }
/*     */           
/* 335 */           boolean flag2 = par1Entity.func_70097_a(DamageSource.func_76365_a(player), f);
/*     */           
/* 337 */           if (flag2)
/*     */           {
/* 339 */             if (i > 0)
/*     */             {
/* 341 */               par1Entity.func_70024_g(-MathHelper.func_76126_a(player.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F, 0.1D, MathHelper.func_76134_b(player.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F);
/* 342 */               player.field_70159_w *= 0.6D;
/* 343 */               player.field_70179_y *= 0.6D;
/* 344 */               player.func_70031_b(false);
/*     */             }
/*     */             
/* 347 */             if (flag)
/*     */             {
/* 349 */               player.func_71009_b(par1Entity);
/*     */             }
/*     */             
/* 352 */             if (f1 > 0.0F)
/*     */             {
/* 354 */               player.func_71047_c(par1Entity);
/*     */             }
/*     */             
/* 357 */             if (f >= 18.0F)
/*     */             {
/* 359 */               player.func_71029_a(AchievementList.field_75999_E);
/*     */             }
/*     */             
/* 362 */             player.func_130011_c(par1Entity);
/*     */             
/* 364 */             if ((par1Entity instanceof EntityLivingBase))
/*     */             {
/* 366 */               EnchantmentThorns.func_92096_a(player, (EntityLivingBase)par1Entity, player.func_70681_au());
/*     */             }
/*     */           }
/*     */           
/* 370 */           ItemStack itemstack = player.func_71045_bC();
/* 371 */           Object object = par1Entity;
/*     */           
/* 373 */           if ((par1Entity instanceof EntityDragonPart))
/*     */           {
/* 375 */             IEntityMultiPart ientitymultipart = ((EntityDragonPart)par1Entity).field_70259_a;
/*     */             
/* 377 */             if ((ientitymultipart != null) && ((ientitymultipart instanceof EntityLivingBase)))
/*     */             {
/* 379 */               object = ientitymultipart;
/*     */             }
/*     */           }
/*     */           
/* 383 */           if ((itemstack != null) && ((object instanceof EntityLivingBase)))
/*     */           {
/* 385 */             itemstack.func_77961_a((EntityLivingBase)object, player);
/*     */             
/* 387 */             if (itemstack.field_77994_a <= 0)
/*     */             {
/* 389 */               player.func_71028_bD();
/*     */             }
/*     */           }
/*     */           
/* 393 */           if ((par1Entity instanceof EntityLivingBase))
/*     */           {
/* 395 */             player.func_71064_a(StatList.field_75951_w, Math.round(f * 10.0F));
/*     */             
/* 397 */             if ((j > 0) && (flag2))
/*     */             {
/* 399 */               par1Entity.func_70015_d(j * 4);
/*     */             }
/* 401 */             else if (flag1)
/*     */             {
/* 403 */               par1Entity.func_70066_B();
/*     */             }
/*     */           }
/*     */           
/* 407 */           player.func_71020_j(0.3F);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 412 */     player.field_71071_by.field_70461_c -= InventoryPlayerBattle.WEAPON_SETS;
/*     */   }
/*     */   
/*     */   public static void closeStream(Closeable c) {
/*     */     try {
/* 417 */       if (c != null) {
/* 418 */         c.close();
/*     */       }
/*     */     } catch (IOException e) {
/* 421 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/core/BattlegearUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */