/*    */ package minefantasy.api.anvil;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.EnumRarity;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemRepairHammer
/*    */   extends Item
/*    */ {
/*    */   public boolean canRepairEnchant;
/*    */   public float effectivness;
/*    */   public float maxRepair;
/*    */   private int level;
/*    */   
/*    */   public ItemRepairHammer(int id, int dam, float pwr, float max, boolean enchant, int lvl)
/*    */   {
/* 32 */     super(id);
/* 33 */     func_77656_e(dam);
/* 34 */     this.level = lvl;
/* 35 */     this.maxRepair = max;
/* 36 */     func_77625_d(1);
/* 37 */     this.effectivness = pwr;
/* 38 */     func_77664_n();
/* 39 */     this.canRepairEnchant = enchant;
/*    */   }
/*    */   
/*    */   public EnumRarity func_77613_e(ItemStack item)
/*    */   {
/* 44 */     switch (this.level) {
/*    */     case 0: 
/* 46 */       return EnumRarity.common;
/*    */     case 1: 
/* 48 */       return EnumRarity.uncommon;
/*    */     case 2: 
/* 50 */       return EnumRarity.rare;
/*    */     case 3: 
/* 52 */       return EnumRarity.epic;
/*    */     }
/* 54 */     return EnumRarity.common;
/*    */   }
/*    */   
/*    */   public void func_77624_a(ItemStack item, EntityPlayer player, List desc, boolean flag)
/*    */   {
/* 59 */     super.func_77624_a(item, player, desc, flag);
/* 60 */     desc.add("Efficiency: " + this.effectivness);
/* 61 */     desc.add("Max: " + this.maxRepair * 100.0F + "%");
/*    */   }
/*    */   
/*    */   public Item func_77655_b(String name)
/*    */   {
/* 66 */     func_111206_d("minefantasy:Tool/" + name);
/* 67 */     return super.func_77655_b(name);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/api/anvil/ItemRepairHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */