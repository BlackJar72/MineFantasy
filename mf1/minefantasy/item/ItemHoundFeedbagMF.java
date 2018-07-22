/*     */ package minefantasy.item;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import minefantasy.api.hound.ItemHoundFeedbag;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.EntityEggInfo;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ItemHoundFeedbagMF extends ItemHoundFeedbag
/*     */ {
/*     */   private String texture;
/*     */   public int stamin;
/*     */   
/*     */   public ItemHoundFeedbagMF(int id, int max, String tex, int sta)
/*     */   {
/*  22 */     super(id, max);
/*  23 */     this.texture = tex;
/*  24 */     this.stamin = sta;
/*  25 */     func_77637_a(ItemListMF.tabPets);
/*     */   }
/*     */   
/*     */   public void func_77633_a(int id, CreativeTabs tabs, List list)
/*     */   {
/*  30 */     if (this == ItemListMF.hound_feed) {
/*  31 */       Iterator var4 = EntityList.field_75627_a.values().iterator();
/*     */       
/*  33 */       while (var4.hasNext()) {
/*  34 */         EntityEggInfo var5 = (EntityEggInfo)var4.next();
/*     */         
/*  36 */         String var3 = EntityList.func_75617_a(var5.field_75613_a);
/*     */         
/*  38 */         if ((var3 != null) && (var3 == "HoundMF")) {
/*  39 */           list.add(new ItemStack(Item.field_77815_bC.field_77779_bT, 1, var5.field_75613_a));
/*     */         }
/*     */       }
/*     */       
/*  43 */       list.add(new ItemStack(Item.field_77755_aX));
/*  44 */       list.add(new ItemStack(id, 1, func_77612_l() - 1));
/*  45 */       addTabItems(id, tabs, list);
/*     */     } else {
/*  47 */       super.func_77633_a(id, tabs, list);
/*     */     }
/*     */   }
/*     */   
/*  51 */   public String getTexture() { return MFResource.image("/mob/" + this.texture + ".png"); }
/*     */   
/*     */ 
/*     */   public int getRequiredSta()
/*     */   {
/*  56 */     return this.stamin;
/*     */   }
/*     */   
/*     */   public Item func_77655_b(String name)
/*     */   {
/*  61 */     func_111206_d("minefantasy:Pets/" + name);
/*  62 */     return super.func_77655_b(name);
/*     */   }
/*     */   
/*     */   private void addTabItems(int id, CreativeTabs tabs, List list) {
/*  66 */     add(list, ItemListMF.transferHound);
/*  67 */     add(list, ItemListMF.hound_sPack);
/*  68 */     add(list, ItemListMF.hound_bPack);
/*     */     
/*  70 */     add(list, ItemListMF.hound_BMail);
/*  71 */     add(list, ItemListMF.hound_BMailH);
/*  72 */     add(list, ItemListMF.hound_IMail);
/*  73 */     add(list, ItemListMF.hound_IMailH);
/*  74 */     add(list, ItemListMF.hound_GMail);
/*  75 */     add(list, ItemListMF.hound_GMailH);
/*  76 */     add(list, ItemListMF.hound_SMail);
/*  77 */     add(list, ItemListMF.hound_SMailH);
/*  78 */     add(list, ItemListMF.hound_DMail);
/*  79 */     add(list, ItemListMF.hound_DMailH);
/*  80 */     add(list, ItemListMF.hound_DImail);
/*  81 */     add(list, ItemListMF.hound_DImailH);
/*  82 */     add(list, ItemListMF.hound_MMail);
/*  83 */     add(list, ItemListMF.hound_MMailH);
/*     */     
/*  85 */     add(list, ItemListMF.hound_Bplate);
/*  86 */     add(list, ItemListMF.hound_BplateH);
/*  87 */     add(list, ItemListMF.hound_Iplate);
/*  88 */     add(list, ItemListMF.hound_IplateH);
/*  89 */     add(list, ItemListMF.hound_Gplate);
/*  90 */     add(list, ItemListMF.hound_GplateH);
/*  91 */     add(list, ItemListMF.hound_Splate);
/*  92 */     add(list, ItemListMF.hound_SplateH);
/*  93 */     add(list, ItemListMF.hound_Dplate);
/*  94 */     add(list, ItemListMF.hound_DplateH);
/*  95 */     add(list, ItemListMF.hound_Eplate);
/*  96 */     add(list, ItemListMF.hound_EplateH);
/*  97 */     add(list, ItemListMF.hound_DIplate);
/*  98 */     add(list, ItemListMF.hound_DIplateH);
/*  99 */     add(list, ItemListMF.hound_Mplate);
/* 100 */     add(list, ItemListMF.hound_MplateH);
/*     */     
/* 102 */     add(list, ItemListMF.hound_Bteeth);
/* 103 */     add(list, ItemListMF.hound_Iteeth);
/* 104 */     add(list, ItemListMF.hound_Oteeth);
/* 105 */     add(list, ItemListMF.hound_Steeth);
/* 106 */     add(list, ItemListMF.hound_Dteeth);
/* 107 */     add(list, ItemListMF.hound_Eteeth);
/* 108 */     add(list, ItemListMF.hound_DIteeth);
/* 109 */     add(list, ItemListMF.hound_Mteeth);
/* 110 */     add(list, ItemListMF.hound_Igteeth);
/*     */   }
/*     */   
/*     */   private void add(List list, Item item)
/*     */   {
/* 115 */     list.add(new ItemStack(item));
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/item/ItemHoundFeedbagMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */