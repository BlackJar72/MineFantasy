/*    */ package minefantasy.item.weapon;
/*    */ 
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.projectile.EntityArrow;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemBow;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.event.entity.player.ArrowLooseEvent;
/*    */ 
/*    */ public class ItemVanillaBow extends ItemBow
/*    */ {
/*    */   public ItemVanillaBow(int id)
/*    */   {
/* 17 */     super(id);
/*    */   }
/*    */   
/*    */   public void func_77615_a(ItemStack item, World world, EntityPlayer player, int time) {
/* 21 */     int power = func_77626_a(item) - time;
/* 22 */     power = (int)(power * this.model.speed);
/*    */     
/* 24 */     power = (int)(power / 20.0F * getMaxPower());
/*    */     
/*    */ 
/* 27 */     if (power > getMaxPower()) {
/* 28 */       power = (int)getMaxPower();
/*    */     }
/* 30 */     ArrowLooseEvent event = new ArrowLooseEvent(player, item, power);
/* 31 */     net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
/* 32 */     if (event.isCanceled()) {
/* 33 */       return;
/*    */     }
/* 35 */     power = event.charge;
/*    */     
/* 37 */     boolean var5 = (player.field_71075_bZ.field_75098_d) || (EnchantmentHelper.func_77506_a(Enchantment.field_77342_w.field_77352_x, item) > 0);
/*    */     
/* 39 */     if ((var5) || (player.field_71071_by.func_70450_e(Item.field_77704_l.field_77779_bT))) {
/* 40 */       float var7 = power / 20.0F;
/* 41 */       var7 = (var7 * var7 + var7 * 2.0F) / 3.0F;
/*    */       
/* 43 */       if (var7 < 0.1D) {
/* 44 */         return;
/*    */       }
/*    */       
/* 47 */       if (var7 > 1.0F) {
/* 48 */         var7 = 1.0F;
/*    */       }
/*    */       
/* 51 */       EntityArrow var8 = new EntityArrow(world, player, var7 * 2.0F);
/*    */       
/* 53 */       if (var7 == 1.0F) {
/* 54 */         var8.func_70243_d(true);
/*    */       }
/*    */       
/* 57 */       int var9 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, item);
/*    */       
/* 59 */       if (var9 > 0) {
/* 60 */         var8.func_70239_b(var8.func_70242_d() + var9 * 0.5D + 0.5D);
/*    */       }
/*    */       
/* 63 */       int var10 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, item);
/*    */       
/* 65 */       if (var10 > 0) {
/* 66 */         var8.func_70240_a(var10);
/*    */       }
/*    */       
/* 69 */       if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, item) > 0) {
/* 70 */         var8.func_70015_d(100);
/*    */       }
/*    */       
/* 73 */       item.func_77972_a(1, player);
/* 74 */       world.func_72956_a(player, "random.bow", 1.0F, 1.0F / (field_77697_d.nextFloat() * 0.4F + 1.2F) + var7 * 0.5F);
/*    */       
/* 76 */       if (var5) {
/* 77 */         var8.field_70251_a = 2;
/*    */       } else {
/* 79 */         player.field_71071_by.func_70435_d(Item.field_77704_l.field_77779_bT);
/*    */       }
/*    */       
/* 82 */       if (!world.field_72995_K) {
/* 83 */         world.func_72838_d(var8);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   private float getMaxPower()
/*    */   {
/* 92 */     return 20.0F * this.model.power;
/*    */   }
/*    */   
/* 95 */   private final EnumBowType model = EnumBowType.SHORTBOW;
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/weapon/ItemVanillaBow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */