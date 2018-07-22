/*    */ package minefantasy.client.gui;
/*    */ 
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.client.tile.TileEntityRoast;
/*    */ import minefantasy.container.ContainerRoast;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiRoast
/*    */   extends GuiContainer
/*    */ {
/*    */   private TileEntityRoast roast;
/*    */   
/*    */   public GuiRoast(InventoryPlayer inventoryplayer, TileEntityRoast tile)
/*    */   {
/* 24 */     super(new ContainerRoast(inventoryplayer, tile));
/* 25 */     this.roast = tile;
/*    */   }
/*    */   
/*    */   protected void drawGuiContainerForegroundLayer() {
/* 29 */     this.field_73886_k.func_78276_b(StatCollector.func_74838_a("tile.roast.name"), 60, 6, 4210752);
/* 30 */     this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
/*    */   }
/*    */   
/*    */   protected void func_74185_a(float f, int i, int j) {
/* 34 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 35 */     bindTexture(MFResource.image("/gui/roast.png"));
/* 36 */     int x = (this.field_73880_f - this.field_74194_b) / 2;
/* 37 */     int y = (this.field_73881_g - this.field_74195_c) / 2;
/* 38 */     func_73729_b(x, y, 0, 0, this.field_74194_b, this.field_74195_c);
/*    */     
/* 40 */     for (int a = 0; a < 5; a++) {
/* 41 */       int prog = this.roast.getCookProgressScaled(28, a);
/* 42 */       if (prog > 0)
/* 43 */         func_73729_b(x + 46 + 18 * a, y + 4, 176, 0, 9, prog + 1);
/*    */     }
/*    */   }
/*    */   
/*    */   private void bindTexture(String image) {
/* 48 */     this.field_73882_e.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/GuiRoast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */