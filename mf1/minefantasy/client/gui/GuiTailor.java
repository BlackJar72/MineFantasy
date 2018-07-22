/*    */ package minefantasy.client.gui;
/*    */ 
/*    */ import minefantasy.client.tile.TileEntityTailor;
/*    */ import minefantasy.container.ContainerTailor;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class GuiTailor extends GuiContainer
/*    */ {
/*    */   private TileEntityTailor tailor;
/*    */   
/*    */   public GuiTailor(InventoryPlayer invPlayer, TileEntityTailor tile)
/*    */   {
/* 19 */     super(new ContainerTailor(invPlayer, tile));
/* 20 */     this.field_74195_c = 179;
/* 21 */     this.tailor = tile;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_74189_g(int mX, int mY)
/*    */   {
/* 30 */     this.field_73886_k.func_78276_b(StatCollector.func_74838_a("tile.tailor.name"), 28, 6, 4210752);
/* 31 */     if (!minefantasy.MineFantasyBase.isDebug()) {
/* 32 */       this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 124, this.field_74195_c - 96 + 2, 4210752);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void func_74185_a(float Scale, int x, int y)
/*    */   {
/* 40 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 41 */     bindTexture(MFResource.image("/gui/tailor.png"));
/* 42 */     int xOffset = (this.field_73880_f - this.field_74194_b) / 2;
/* 43 */     int yOffset = (this.field_73881_g - this.field_74195_c) / 2;
/* 44 */     func_73729_b(xOffset, yOffset, 0, 0, this.field_74194_b, this.field_74195_c);
/*    */     
/*    */ 
/* 47 */     int prog = this.tailor.getProgressScale(24);
/* 48 */     func_73729_b(xOffset + 115, yOffset + 48, 176, 0, prog + 1, 16);
/*    */   }
/*    */   
/*    */   private void bindTexture(String image) {
/* 52 */     this.field_73882_e.field_71446_o.func_110577_a(minefantasy.client.MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/GuiTailor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */