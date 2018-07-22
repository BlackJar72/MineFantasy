/*    */ package minefantasy.item;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.IconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.PlayerCapabilities;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.util.Icon;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class ItemBandage
/*    */   extends Item
/*    */ {
/* 23 */   private String[] types = { "crude", "basic", "tough" };
/*    */   private Icon[] icons;
/*    */   
/*    */   public ItemBandage(int i) {
/* 27 */     super(i);
/* 28 */     func_77625_d(16);
/* 29 */     func_77637_a(ItemListMF.tabMF);
/* 30 */     func_77627_a(true);
/* 31 */     func_77656_e(0);
/* 32 */     func_77637_a(ItemListMF.tabMedieval);
/*    */   }
/*    */   
/*    */   public void func_77633_a(int id, CreativeTabs tabs, List list) {
/* 36 */     for (int n = 0; n < this.types.length; n++) {
/* 37 */       ItemStack item = new ItemStack(id, 1, n);
/* 38 */       list.add(item);
/*    */     }
/*    */   }
/*    */   
/*    */   public Icon func_77617_a(int id)
/*    */   {
/* 44 */     return this.icons[id];
/*    */   }
/*    */   
/*    */ 
/*    */   public String func_77628_j(ItemStack item)
/*    */   {
/* 50 */     int i = item.func_77960_j();
/* 51 */     return StatCollector.func_74838_a("item.bandage." + this.types[i] + ".name");
/*    */   }
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack item, World world, EntityPlayer player)
/*    */   {
/* 56 */     return heal(player, player, item);
/*    */   }
/*    */   
/*    */   public boolean func_111207_a(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity)
/*    */   {
/* 61 */     if (player.func_70093_af()) {
/* 62 */       heal(player, entity, itemstack);
/* 63 */       return true;
/*    */     }
/* 65 */     return super.func_111207_a(itemstack, player, entity);
/*    */   }
/*    */   
/*    */   private ItemStack heal(EntityPlayer player, EntityLivingBase toHeal, ItemStack item) {
/* 69 */     if (player.field_70170_p.field_72995_K) {
/* 70 */       return item;
/*    */     }
/*    */     
/* 73 */     if ((toHeal != null) && 
/* 74 */       (toHeal.func_110143_aJ() <= toHeal.func_110138_aP() - 1.0F) && (toHeal.func_70660_b(Potion.field_76428_l) == null) && (!toHeal.func_70027_ad())) {
/* 75 */       toHeal.field_70170_p.func_72908_a(toHeal.field_70165_t, toHeal.field_70163_u, toHeal.field_70161_v, "dig.cloth", 1.0F, 0.5F);
/* 76 */       player.func_71038_i();
/*    */       
/* 78 */       if (!player.field_70170_p.field_72995_K) {
/* 79 */         toHeal.func_70690_d(new PotionEffect(Potion.field_76428_l.field_76415_H, 200, item.func_77960_j(), true));
/*    */         
/* 81 */         if (!player.field_71075_bZ.field_75098_d) {
/* 82 */           item.field_77994_a -= 1;
/* 83 */           if (item.field_77994_a > 0) {}
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 90 */     return item;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94581_a(IconRegister reg)
/*    */   {
/* 96 */     this.icons = new Icon[this.types.length];
/* 97 */     for (int i = 0; i < this.types.length; i++) {
/* 98 */       this.icons[i] = reg.func_94245_a("minefantasy:Misc/bandage_" + i);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemBandage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */