/*    */ package mods.battlegear2.api;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.event.RenderGameOverlayEvent;
/*    */ 
/*    */ public class RenderItemBarEvent extends RenderGameOverlayEvent
/*    */ {
/*  8 */   public int xOffset = 0;
/*  9 */   public int yOffset = 0;
/*    */   
/*    */ 
/* 12 */   public RenderItemBarEvent(RenderGameOverlayEvent parent) { super(parent.partialTicks, parent.resolution, parent.mouseX, parent.mouseY); }
/*    */   
/*    */   @net.minecraftforge.event.Cancelable
/*    */   public static class ShieldBar extends RenderItemBarEvent {
/*    */     public final ItemStack shield;
/*    */     
/*    */     public ShieldBar(RenderGameOverlayEvent parent, ItemStack item) {
/* 19 */       super();
/* 20 */       this.shield = item;
/*    */     }
/*    */   }
/*    */   
/*    */   @net.minecraftforge.event.Cancelable
/*    */   public static class QuiverSlots extends RenderItemBarEvent {
/*    */     public final ItemStack mainhand;
/*    */     public final ItemStack quiver;
/*    */     
/* 29 */     public QuiverSlots(RenderGameOverlayEvent parent, ItemStack mainhand, ItemStack item) { super();
/* 30 */       this.mainhand = mainhand;
/* 31 */       this.quiver = item;
/*    */     }
/*    */   }
/*    */   
/*    */   @net.minecraftforge.event.Cancelable
/*    */   public static class BattleSlots extends RenderItemBarEvent {
/*    */     public final boolean isMainHand;
/*    */     
/* 39 */     public BattleSlots(RenderGameOverlayEvent parent, boolean isMainHand) { super();
/* 40 */       this.isMainHand = isMainHand;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/mods/battlegear2/api/RenderItemBarEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */