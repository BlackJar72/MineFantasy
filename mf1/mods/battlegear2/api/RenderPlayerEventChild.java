/*    */ package mods.battlegear2.api;
/*    */ 
/*    */ import net.minecraftforge.client.event.RenderPlayerEvent;
/*    */ 
/*    */ public abstract class RenderPlayerEventChild extends RenderPlayerEvent { public final PlayerElementType type;
/*    */   public final boolean isFirstPerson;
/*    */   public final net.minecraft.item.ItemStack element;
/*    */   
/*  9 */   public static enum PlayerElementType { Offhand, 
/* 10 */     ItemOffhand, 
/* 11 */     ItemOffhandSheathed, 
/* 12 */     ItemMainhandSheathed;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */     private PlayerElementType() {}
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public RenderPlayerEventChild(RenderPlayerEvent parent, PlayerElementType type, boolean firstPerson, net.minecraft.item.ItemStack item)
/*    */   {
/* 24 */     super(parent.entityPlayer, parent.renderer, parent.partialRenderTick);
/* 25 */     this.type = type;
/* 26 */     this.isFirstPerson = firstPerson;
/* 27 */     this.element = item;
/*    */   }
/*    */   
/*    */   @net.minecraftforge.event.Cancelable
/*    */   public static class PreRenderPlayerElement extends RenderPlayerEventChild {
/*    */     public PreRenderPlayerElement(RenderPlayerEvent parent, boolean isFirstPerson, RenderPlayerEventChild.PlayerElementType type, net.minecraft.item.ItemStack item) {
/* 33 */       super(type, isFirstPerson, item);
/*    */     }
/*    */   }
/*    */   
/*    */   public static class PostRenderPlayerElement extends RenderPlayerEventChild {
/*    */     public PostRenderPlayerElement(RenderPlayerEvent parent, boolean isFirstPerson, RenderPlayerEventChild.PlayerElementType type, net.minecraft.item.ItemStack item) {
/* 39 */       super(type, isFirstPerson, item);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   @net.minecraftforge.event.Cancelable
/*    */   public static class PreRenderSheathed
/*    */     extends RenderPlayerEventChild.PreRenderPlayerElement
/*    */   {
/*    */     public final boolean isOnBack;
/*    */     
/*    */     public final int backCount;
/*    */     
/*    */ 
/*    */     public PreRenderSheathed(RenderPlayerEvent parent, boolean isOnBack, int count, boolean isMainHand, net.minecraft.item.ItemStack item)
/*    */     {
/* 55 */       super(false, isMainHand ? RenderPlayerEventChild.PlayerElementType.ItemMainhandSheathed : RenderPlayerEventChild.PlayerElementType.ItemOffhandSheathed, item);
/* 56 */       this.isOnBack = isOnBack;
/* 57 */       this.backCount = count;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public static class PostRenderSheathed
/*    */     extends RenderPlayerEventChild.PostRenderPlayerElement
/*    */   {
/*    */     public final boolean isOnBack;
/*    */     
/*    */     public final int backCount;
/*    */     
/*    */ 
/*    */     public PostRenderSheathed(RenderPlayerEvent parent, boolean isOnBack, int count, boolean isMainHand, net.minecraft.item.ItemStack item)
/*    */     {
/* 72 */       super(false, isMainHand ? RenderPlayerEventChild.PlayerElementType.ItemMainhandSheathed : RenderPlayerEventChild.PlayerElementType.ItemOffhandSheathed, item);
/* 73 */       this.isOnBack = isOnBack;
/* 74 */       this.backCount = count;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/RenderPlayerEventChild.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */