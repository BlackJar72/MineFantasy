/*     */ package minefantasy.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import minefantasy.api.forge.IHotItem;
/*     */ import net.minecraft.client.renderer.texture.IconRegister;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.StatCollector;
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
/*     */ public class ItemBloom
/*     */   extends Item
/*     */   implements IHotItem
/*     */ {
/*     */   public ItemBloom(int id)
/*     */   {
/*  32 */     super(id);
/*  33 */     func_77627_a(true);
/*  34 */     func_77625_d(1);
/*  35 */     func_77637_a(ItemListMF.tabSmellting);
/*     */   }
/*     */   
/*     */   public static ItemStack getItem(ItemStack item) {
/*  39 */     NBTTagCompound tag = getNBT(item);
/*     */     
/*  41 */     if ((tag.func_74764_b("ingotID")) && (tag.func_74764_b("ingotMeta"))) {
/*  42 */       return new ItemStack(tag.func_74762_e("ingotID"), 1, tag.func_74762_e("ingotMeta"));
/*     */     }
/*     */     
/*  45 */     return null;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_94581_a(IconRegister reg)
/*     */   {
/*  51 */     this.field_77791_bV = reg.func_94245_a("MineFantasy:Misc/bloom");
/*     */   }
/*     */   
/*     */   public static ItemStack createBloom(ItemStack item) {
/*  55 */     ItemStack out = new ItemStack(ItemListMF.bloom);
/*  56 */     NBTTagCompound nbt = getNBT(out);
/*     */     
/*  58 */     nbt.func_74768_a("ingotID", item.field_77993_c);
/*  59 */     nbt.func_74768_a("ingotMeta", item.func_77960_j());
/*     */     
/*  61 */     return out;
/*     */   }
/*     */   
/*     */ 
/*     */   public String func_77628_j(ItemStack stack)
/*     */   {
/*  67 */     return StatCollector.func_74838_a("item.bloom.name");
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack stack)
/*     */   {
/*  72 */     ItemStack item = getItem(stack);
/*  73 */     if (item != null) {
/*  74 */       return item.func_77973_b().func_77613_e(item);
/*     */     }
/*  76 */     return EnumRarity.common;
/*     */   }
/*     */   
/*     */   private static NBTTagCompound getNBT(ItemStack item) {
/*  80 */     if (!item.func_77942_o())
/*  81 */       item.func_77982_d(new NBTTagCompound());
/*  82 */     return item.func_77978_p();
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack stack, EntityPlayer player, List list, boolean b)
/*     */   {
/*  87 */     ItemStack item = getItem(stack);
/*     */     
/*  89 */     if (item != null) {
/*  90 */       list.add(item.func_77973_b().func_77628_j(item));
/*     */       
/*  92 */       item.func_77973_b().func_77624_a(item, player, list, b);
/*     */     } else {
/*  94 */       super.func_77624_a(stack, player, list, b);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isHot(ItemStack item) {
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isCoolable(ItemStack item)
/*     */   {
/* 104 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemBloom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */