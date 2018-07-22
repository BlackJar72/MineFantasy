/*     */ package minefantasy.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import minefantasy.entity.EntityRockSling;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemSlingMF
/*     */   extends ItemBow
/*     */ {
/*     */   public ItemSlingMF(int id, int strength)
/*     */   {
/*  30 */     super(id);
/*  31 */     this.field_77777_bU = 1;
/*  32 */     func_77656_e(strength);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77662_d()
/*     */   {
/*  40 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_77615_a(ItemStack item, World world, EntityPlayer player, int time)
/*     */   {
/*  48 */     int var6 = func_77626_a(item) - time;
/*     */     
/*  50 */     boolean var5 = player.field_71075_bZ.field_75098_d;
/*     */     
/*  52 */     if ((var5) || (player.field_71071_by.func_70431_c(ItemListMF.component(108)))) {
/*  53 */       float var7 = var6 / 20.0F;
/*  54 */       var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
/*     */       
/*  56 */       if (var7 < 0.1D) {
/*  57 */         return;
/*     */       }
/*     */       
/*  60 */       if (var7 > 1.0F) {
/*  61 */         var7 = 1.0F;
/*     */       }
/*     */       
/*  64 */       EntityRockSling rock = new EntityRockSling(world, player, var7 * 2.0F);
/*     */       
/*  66 */       item.func_77972_a(1, player);
/*  67 */       world.func_72956_a(player, MFResource.sound("spearThrow"), 1.0F, 1.0F / (field_77697_d.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
/*     */       
/*  69 */       if (!var5) {
/*  70 */         consumePlayerItem(player, ItemListMF.component(108));
/*     */       }
/*     */       
/*  73 */       if (!world.field_72995_K) {
/*  74 */         world.func_72838_d(rock);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean consumePlayerItem(EntityPlayer player, ItemStack item) {
/*  80 */     for (int a = 0; a < player.field_71071_by.func_70302_i_(); a++) {
/*  81 */       ItemStack i = player.field_71071_by.func_70301_a(a);
/*  82 */       if ((i != null) && (i.func_77969_a(item))) {
/*  83 */         player.field_71071_by.func_70298_a(a, 1);
/*  84 */         return true;
/*     */       }
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public ItemStack onFoodEaten(ItemStack item, World world, EntityPlayer player) {
/*  91 */     return item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int func_77626_a(ItemStack item)
/*     */   {
/*  98 */     return 72000;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public EnumAction func_77661_b(ItemStack item)
/*     */   {
/* 106 */     return EnumAction.bow;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
/*     */   {
/* 114 */     if ((player.field_71075_bZ.field_75098_d) || (player.field_71071_by.func_70431_c(ItemListMF.component(108)))) {
/* 115 */       player.func_71008_a(item, func_77626_a(item));
/*     */     }
/*     */     
/* 118 */     return item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int func_77619_b()
/*     */   {
/* 126 */     return 0;
/*     */   }
/*     */   
/*     */   public void onUsingItemTick(ItemStack item, EntityPlayer player, int i)
/*     */   {
/* 131 */     super.onUsingItemTick(item, player, i);
/* 132 */     if (i % 5 == 0) {
/* 133 */       player.func_71038_i();
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/* 140 */     this.field_77791_bV = reg.func_94245_a(func_111208_A());
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/* 145 */     func_111206_d("minefantasy:Weapon/" + name);
/* 146 */     return super.func_77655_b(name);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemSlingMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */