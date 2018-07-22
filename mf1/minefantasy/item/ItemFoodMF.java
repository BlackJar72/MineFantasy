/*    */ package minefantasy.item;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemFood;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemFoodMF
/*    */   extends ItemFood
/*    */ {
/*    */   private boolean alwaysEdible;
/*    */   private PotionEffect effect;
/*    */   private int healAmount;
/*    */   
/*    */   public ItemFoodMF(int id, int heal, float saturation, boolean wolf)
/*    */   {
/* 23 */     super(id, heal, saturation, wolf);
/* 24 */     func_77637_a(ItemListMF.tabPets);
/*    */   }
/*    */   
/*    */   public ItemFoodMF(int id, int heal, float saturation, boolean wolf, PotionEffect effect) {
/* 28 */     this(id, heal, saturation, wolf);
/* 29 */     this.effect = effect;
/*    */   }
/*    */   
/*    */   public ItemFoodMF(int id, int feed, float saturation, boolean wolf, int heal) {
/* 33 */     super(id, feed, saturation, wolf);
/* 34 */     if (heal > 0)
/* 35 */       func_77848_i();
/* 36 */     this.healAmount = heal;
/*    */   }
/*    */   
/*    */   public void func_77849_c(ItemStack item, World world, EntityPlayer player)
/*    */   {
/* 41 */     if (this.healAmount > 0) {
/* 42 */       player.func_70691_i(this.healAmount);
/*    */     }
/* 44 */     if (this.effect != null) {
/* 45 */       player.func_70690_d(this.effect);
/*    */     }
/* 47 */     super.func_77849_c(item, world, player);
/*    */   }
/*    */   
/*    */   public void onUsingItemTick(ItemStack item, EntityPlayer player, int count)
/*    */   {
/* 52 */     Random rand = player.func_70681_au();
/* 53 */     int maxUse = item.func_77988_m();
/* 54 */     if ((count > 2) && (count < maxUse - 30) && 
/* 55 */       (rand.nextInt(3) == 0)) {
/* 56 */       player.func_85030_a("random.eat", 0.5F + rand.nextFloat(), 0.5F + rand.nextFloat());
/*    */     }
/*    */   }
/*    */   
/*    */   public Item func_77655_b(String name)
/*    */   {
/* 62 */     func_111206_d("minefantasy:Food/" + name);
/* 63 */     return super.func_77655_b(name);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemFoodMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */