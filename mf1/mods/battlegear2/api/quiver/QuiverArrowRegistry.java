/*     */ package mods.battlegear2.api.quiver;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class QuiverArrowRegistry
/*     */ {
/*  14 */   private static Map<ItemStack, Class<? extends EntityArrow>> itemToClasses = new java.util.TreeMap(new StackComparator());
/*  15 */   private static Map<Class<? extends EntityArrow>, ItemStack> classToItems = new java.util.HashMap();
/*  16 */   private static List<IQuiverSelection> quiverSelectors = new ArrayList();
/*  17 */   private static List<IArrowFireHandler> fireHandlers = new ArrayList();
/*     */   
/*  19 */   static { fireHandlers.add(new DefaultArrowFire()); }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addArrowToRegistry(int itemId, int itemMetadata, Class<? extends EntityArrow> entityArrow)
/*     */   {
/*  29 */     ItemStack stack = new ItemStack(itemId, 1, itemMetadata);
/*  30 */     addArrowToRegistry(stack, entityArrow);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void addArrowToRegistry(ItemStack stack, Class<? extends EntityArrow> entityArrow)
/*     */   {
/*  41 */     ItemStack st = stack.func_77946_l();
/*  42 */     st.field_77994_a = 1;
/*  43 */     itemToClasses.put(st, entityArrow);
/*  44 */     classToItems.put(entityArrow, st);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addQuiverSelection(IQuiverSelection handler)
/*     */   {
/*  56 */     return quiverSelectors.add(handler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean addArrowFireHandler(IArrowFireHandler handler)
/*     */   {
/*  68 */     return fireHandlers.add(handler);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ItemStack getArrowContainer(ItemStack bow, EntityPlayer entityPlayer)
/*     */   {
/*  79 */     for (IQuiverSelection handler : quiverSelectors) {
/*  80 */       ItemStack temp = handler.getQuiverFor(bow, entityPlayer);
/*  81 */       if (temp != null) {
/*  82 */         return temp;
/*     */       }
/*     */     }
/*  85 */     return null;
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
/*     */   public static EntityArrow getArrowType(ItemStack arrow, World world, EntityPlayer player, float charge)
/*     */   {
/*  98 */     for (IArrowFireHandler handler : fireHandlers) {
/*  99 */       if (handler.canFireArrow(arrow, world, player, charge)) {
/* 100 */         EntityArrow result = handler.getFiredArrow(arrow, world, player, charge);
/* 101 */         if (result != null) {
/* 102 */           return result;
/*     */         }
/*     */       }
/*     */     }
/* 106 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static Class<? extends EntityArrow> getArrowClass(ItemStack stack)
/*     */   {
/* 114 */     return (Class)itemToClasses.get(stack);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ItemStack getItem(Class<? extends EntityArrow> clazz)
/*     */   {
/* 122 */     ItemStack temp = (ItemStack)classToItems.get(clazz);
/* 123 */     if (temp == null) {
/* 124 */       return new ItemStack(net.minecraft.item.Item.field_77704_l);
/*     */     }
/* 126 */     return temp.func_77946_l();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isKnownArrow(ItemStack test)
/*     */   {
/* 136 */     return itemToClasses.containsKey(test);
/*     */   }
/*     */   
/*     */ 
/*     */   static class StackComparator
/*     */     implements java.util.Comparator<ItemStack>
/*     */   {
/*     */     public int compare(ItemStack stack, ItemStack stack2)
/*     */     {
/* 145 */       if (stack == stack2) {
/* 146 */         return 0;
/*     */       }
/*     */       
/* 149 */       int idDiff = stack.field_77993_c - stack2.field_77993_c;
/* 150 */       if (idDiff != 0) {
/* 151 */         return idDiff;
/*     */       }
/* 153 */       idDiff = stack.func_77960_j() - stack2.func_77960_j();
/* 154 */       if (idDiff != 0) {
/* 155 */         return idDiff;
/*     */       }
/* 157 */       int tag = 0;
/* 158 */       if (stack.func_77942_o()) {
/* 159 */         tag = stack.func_77978_p().hashCode();
/*     */       }
/* 161 */       int tag2 = 0;
/* 162 */       if (stack2.func_77942_o()) {
/* 163 */         tag2 = stack2.func_77978_p().hashCode();
/*     */       }
/* 165 */       return tag - tag2;
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
/*     */   static class DefaultArrowFire
/*     */     implements IArrowFireHandler
/*     */   {
/*     */     public boolean canFireArrow(ItemStack arrow, World world, EntityPlayer player, float charge)
/*     */     {
/* 181 */       return QuiverArrowRegistry.isKnownArrow(arrow);
/*     */     }
/*     */     
/*     */     public EntityArrow getFiredArrow(ItemStack arrow, World world, EntityPlayer player, float charge)
/*     */     {
/* 186 */       Class clazz = QuiverArrowRegistry.getArrowClass(arrow);
/* 187 */       if (clazz != null) {
/*     */         try {
/* 189 */           return (EntityArrow)clazz.getConstructor(new Class[] { World.class, net.minecraft.entity.EntityLivingBase.class, Float.TYPE }).newInstance(new Object[] { player.field_70170_p, player, Float.valueOf(charge) });
/*     */         }
/*     */         catch (Exception localException) {}
/*     */       }
/*     */       
/* 194 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/quiver/QuiverArrowRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */