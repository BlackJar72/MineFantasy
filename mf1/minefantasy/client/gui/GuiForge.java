/*    */ package minefantasy.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.client.tile.TileEntityForge;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiForge extends GuiContainer
/*    */ {
/*    */   private TileEntityForge theForge;
/*    */   
/*    */   public GuiForge(InventoryPlayer invPlayer, TileEntityForge forge)
/*    */   {
/* 21 */     super(new minefantasy.container.ContainerForge(invPlayer, forge));
/* 22 */     this.theForge = forge;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_74189_g(int x, int y)
/*    */   {
/* 30 */     this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.mfForge"), 60, 6, 4210752);
/* 31 */     this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 32, this.field_74195_c - 96 + 2, 4210752);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_74185_a(float scale, int x, int y)
/*    */   {
/* 39 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 40 */     bindTexture(MFResource.image("/gui/forge.png"));
/* 41 */     int posX = (this.field_73880_f - this.field_74194_b) / 2;
/* 42 */     int posY = (this.field_73881_g - this.field_74195_c) / 2;
/* 43 */     func_73729_b(posX, posY, 0, 0, this.field_74194_b, this.field_74195_c);
/*    */     
/*    */ 
/* 46 */     if (this.theForge.fuel > 0) {
/* 47 */       int remScale = this.theForge.getBurnTimeRemainingScaled(12);
/* 48 */       if (this.theForge.fuel > 0) {
/* 49 */         func_73729_b(posX + 26, posY + 27 + 12 - remScale, this.theForge.isBurning() ? 176 : 190, 12 - remScale, 14, remScale + 2);
/*    */       }
/*    */     }
/* 52 */     if (this.theForge.heat > 0.0F) {
/* 53 */       if (this.theForge.isBurning())
/*    */       {
/* 55 */         int heatScM = this.theForge.getItemHeatScaled(68);
/* 56 */         func_73729_b(posX + 6, posY + 76 - heatScM, 176, 14, 16, 3);
/*    */       }
/*    */       
/* 59 */       int heatSc = this.theForge.getHeatScaled(68);
/* 60 */       func_73729_b(posX + 9, posY + 76 - heatSc, 176, 17, 10, 5);
/*    */     }
/*    */   }
/*    */   
/*    */   private void bindTexture(String image) {
/* 65 */     this.field_73882_e.field_71446_o.func_110577_a(minefantasy.client.MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/GuiForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */