/*     */ package minefantasy.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemFood;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.FoodStats;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class ItemFoodIngreedient
/*     */   extends ItemFood
/*     */ {
/*     */   private Icon[] icons;
/*     */   
/*     */   public ItemFoodIngreedient(int id)
/*     */   {
/*  26 */     super(id, 1, 0.1F, false);
/*  27 */     func_77627_a(true);
/*  28 */     func_77656_e(0);
/*  29 */     func_77637_a(ItemListMF.tabCook);
/*     */   }
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack item, World world, EntityPlayer player) {
/*  33 */     int m = item.func_77960_j();
/*  34 */     item.field_77994_a -= 1;
/*  35 */     player.func_71024_bL().func_75122_a(getHealAmount(m), getSaturation(m));
/*  36 */     world.func_72956_a(player, "random.burp", 0.5F, world.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*  37 */     func_77849_c(item, world, player);
/*  38 */     return item;
/*     */   }
/*     */   
/*     */   private float getSaturation(int m) {
/*  42 */     return ((Float)getStats()[m][2]).floatValue();
/*     */   }
/*     */   
/*     */   private int getHealAmount(int m) {
/*  46 */     return ((Integer)getStats()[m][1]).intValue();
/*     */   }
/*     */   
/*     */   protected void func_77849_c(ItemStack item, World world, EntityPlayer player) {
/*  50 */     int m = item.func_77960_j();
/*  51 */     if ((isPoison(item.func_77960_j())) && (getStats()[m].length >= 11)) {
/*  52 */       int potionId = ((Integer)getStats()[m][7]).intValue();
/*  53 */       int potionDuration = ((Integer)getStats()[m][8]).intValue();
/*  54 */       int potionAmplifier = ((Integer)getStats()[m][9]).intValue();
/*  55 */       float potionEffectProbability = ((Float)getStats()[m][10]).floatValue();
/*     */       
/*  57 */       if ((!world.field_72995_K) && (potionId > 0) && (world.field_73012_v.nextFloat() < potionEffectProbability)) {
/*  58 */         player.func_70690_d(new PotionEffect(potionId, potionDuration * 20, potionAmplifier));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isPoison(int m) {
/*  64 */     return ((Boolean)getStats()[m][4]).booleanValue();
/*     */   }
/*     */   
/*     */   public int func_77626_a(ItemStack item) {
/*  68 */     return ((Integer)getStats()[item.func_77960_j()][6]).intValue();
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list) {
/*  72 */     for (int n = 0; n < getStats().length; n++) {
/*  73 */       ItemStack item = new ItemStack(id, 1, n);
/*  74 */       if (!func_77628_j(item).endsWith("Unused")) {
/*  75 */         list.add(item);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public Icon func_77617_a(int id) {
/*  81 */     return this.icons[id];
/*     */   }
/*     */   
/*     */   public String func_77628_j(ItemStack item)
/*     */   {
/*  86 */     int type = item.func_77960_j();
/*     */     
/*  88 */     String n = "ingreedient.mf." + (String)getStats()[type][0];
/*     */     
/*  90 */     return StatCollector.func_74838_a(n);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private Object[][] getStats()
/*     */   {
/*  98 */     return new Object[0][];
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
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/* 166 */     int length = getStats().length;
/* 167 */     this.icons = new Icon[length];
/*     */     
/* 169 */     for (int i = 0; i < length; i++)
/*     */     {
/* 171 */       String name = (String)getStats()[i][5];
/* 172 */       this.icons[i] = reg.func_94245_a("MineFantasy:Food/" + name);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemFoodIngreedient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */