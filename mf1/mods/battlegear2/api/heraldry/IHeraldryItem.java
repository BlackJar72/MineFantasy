/*    */ package mods.battlegear2.api.heraldry;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public abstract interface IHeraldryItem { public static final String heraldryTag = "hc1";
/*    */   
/*    */   public abstract net.minecraft.util.Icon getBaseIcon(ItemStack paramItemStack);
/*    */   
/*    */   public abstract net.minecraft.util.Icon getTrimIcon(ItemStack paramItemStack);
/*    */   
/* 11 */   public static enum HeraldyRenderPassess { Pattern, 
/* 12 */     SecondaryColourTrim, 
/* 13 */     PostRenderIcon;
/*    */     
/*    */     private HeraldyRenderPassess() {}
/*    */   }
/*    */   
/*    */   public abstract net.minecraft.util.Icon getPostRenderIcon(ItemStack paramItemStack);
/*    */   
/*    */   public abstract boolean hasHeraldry(ItemStack paramItemStack);
/*    */   
/*    */   public abstract byte[] getHeraldry(ItemStack paramItemStack);
/*    */   
/*    */   public abstract void setHeraldry(ItemStack paramItemStack, byte[] paramArrayOfByte);
/*    */   
/*    */   public abstract void removeHeraldry(ItemStack paramItemStack);
/*    */   
/*    */   public abstract boolean shouldDoPass(HeraldyRenderPassess paramHeraldyRenderPassess);
/*    */   
/*    */   public abstract boolean useDefaultRenderer();
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/heraldry/IHeraldryItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */