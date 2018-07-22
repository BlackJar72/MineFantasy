/*    */ package minefantasy.client;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
/*    */ import net.minecraftforge.client.event.RenderGameOverlayEvent.Post;
/*    */ import net.minecraftforge.event.ForgeSubscribe;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MFHudHandler
/*    */ {
/* 13 */   private MFHud inGameGUI = new MFHud();
/*    */   
/*    */   @ForgeSubscribe
/*    */   public void postRenderOverlay(RenderGameOverlayEvent.Post event) {
/* 17 */     if (event.type == RenderGameOverlayEvent.ElementType.HOTBAR) {
/* 18 */       this.inGameGUI.renderGameOverlay(event.partialTicks, event.mouseX, event.mouseY);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFHudHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */