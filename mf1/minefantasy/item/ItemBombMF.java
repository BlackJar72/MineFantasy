/*     */ package minefantasy.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import minefantasy.entity.EntityBombThrown;
/*     */ import mods.battlegear2.api.IOffhandDual;
/*     */ import mods.battlegear2.api.PlayerEventChild.OffhandAttackEvent;
/*     */ import mods.battlegear2.api.weapons.IBattlegearWeapon;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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
/*     */ public class ItemBombMF
/*     */   extends ItemMedieval
/*     */   implements IBattlegearWeapon, IOffhandDual
/*     */ {
/*  33 */   public static Icon[] icons = new Icon[4];
/*     */   
/*     */   public ItemBombMF(int i) {
/*  36 */     this(i, true);
/*     */   }
/*     */   
/*     */   public ItemBombMF(int i, boolean tab) {
/*  40 */     super(i, false, 16);
/*  41 */     func_77627_a(true);
/*  42 */     func_77637_a(ItemListMF.tabWeapon);
/*     */   }
/*     */   
/*     */   public String func_77628_j(ItemStack item)
/*     */   {
/*  47 */     int type = item.func_77960_j();
/*  48 */     if (type == 0) {
/*  49 */       return StatCollector.func_74838_a("bomb.mf.shrapnel");
/*     */     }
/*  51 */     if (type == 1) {
/*  52 */       return StatCollector.func_74838_a("bomb.mf.fire");
/*     */     }
/*  54 */     if (type == 2) {
/*  55 */       return StatCollector.func_74838_a("bomb.mf.poison");
/*     */     }
/*  57 */     if (type == 3) {
/*  58 */       return StatCollector.func_74838_a("bomb.mf.concussion");
/*     */     }
/*  60 */     return StatCollector.func_74838_a("bomb.mf");
/*     */   }
/*     */   
/*     */   public Icon func_77617_a(int dam)
/*     */   {
/*  65 */     if (dam >= icons.length) {
/*  66 */       dam = icons.length - 1;
/*     */     }
/*  68 */     return icons[dam];
/*     */   }
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
/*     */   {
/*  73 */     if (player.field_82175_bq) {
/*  74 */       return item;
/*     */     }
/*  76 */     player.func_71008_a(item, func_77626_a(item));
/*  77 */     world.func_72956_a(player, "random.fuse", 0.2F, 1.0F);
/*  78 */     return item;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_77615_a(ItemStack item, World world, EntityPlayer player, int useTime)
/*     */   {
/*  84 */     throwTimedItem(item, world, player, useTime);
/*     */   }
/*     */   
/*     */   private void throwTimedItem(ItemStack item, World world, EntityPlayer player, int useTime) {
/*  88 */     if (!player.field_71075_bZ.field_75098_d) {
/*  89 */       item.field_77994_a -= 1;
/*     */     }
/*  91 */     if (item.field_77994_a <= 0) {
/*  92 */       player.func_71028_bD();
/*     */     }
/*  94 */     if (!world.field_72995_K) {
/*  95 */       int type = item.func_77960_j();
/*  96 */       world.func_72838_d(new EntityBombThrown(world, player, useTime, type));
/*     */     }
/*     */     
/*  99 */     player.func_71038_i();
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {
/* 103 */     for (int a = 0; a < icons.length; a++) {
/* 104 */       list.add(new ItemStack(id, 1, a));
/*     */     }
/*     */   }
/*     */   
/*     */   public int func_77626_a(ItemStack item) {
/* 109 */     return 20;
/*     */   }
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack item, World world, EntityPlayer player)
/*     */   {
/* 114 */     func_77615_a(item, world, player, 0);
/* 115 */     return item;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/* 121 */     icons[0] = reg.func_94245_a("MineFantasy:Weapon/bomb/bomb_base");
/* 122 */     icons[1] = reg.func_94245_a("MineFantasy:Weapon/bomb/bomb_fire");
/* 123 */     icons[2] = reg.func_94245_a("MineFantasy:Weapon/bomb/bomb_poison");
/* 124 */     icons[3] = reg.func_94245_a("MineFantasy:Weapon/bomb/bomb_concussion");
/*     */   }
/*     */   
/*     */   public boolean sheatheOnBack(ItemStack item)
/*     */   {
/* 129 */     return false;
/*     */   }
/*     */   
/*     */   public boolean allowOffhand(ItemStack mainhand, ItemStack offhand)
/*     */   {
/* 134 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isOffhandHandDual(ItemStack off)
/*     */   {
/* 139 */     return true;
/*     */   }
/*     */   
/*     */   public boolean offhandAttackEntity(PlayerEventChild.OffhandAttackEvent event, ItemStack mainhandItem, ItemStack offhandItem)
/*     */   {
/* 144 */     return true;
/*     */   }
/*     */   
/*     */   public boolean offhandClickAir(PlayerInteractEvent event, ItemStack mainhandItem, ItemStack offhandItem)
/*     */   {
/* 149 */     return true;
/*     */   }
/*     */   
/*     */   public boolean offhandClickBlock(PlayerInteractEvent event, ItemStack mainhandItem, ItemStack offhandItem)
/*     */   {
/* 154 */     return true;
/*     */   }
/*     */   
/*     */   public void performPassiveEffects(Side effectiveSide, ItemStack mainhandItem, ItemStack offhandItem) {}
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemBombMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */