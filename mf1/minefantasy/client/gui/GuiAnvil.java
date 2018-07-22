/*    */ package minefantasy.client.gui;
/*    */ 
/*    */ import minefantasy.client.tile.TileEntityAnvil;
/*    */ import minefantasy.container.ContainerAnvil;
/*    */ import minefantasy.system.MFResource;
/*    */ import minefantasy.system.cfg;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class GuiAnvil extends GuiContainer
/*    */ {
/*    */   private TileEntityAnvil anvil;
/*    */   
/*    */   public GuiAnvil(InventoryPlayer invPlayer, TileEntityAnvil tile)
/*    */   {
/* 20 */     super(new ContainerAnvil(invPlayer, tile));
/* 21 */     this.anvil = tile;
/* 22 */     if (tile.isBig()) {
/* 23 */       this.field_74195_c = 204;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_74189_g(int mX, int mY)
/*    */   {
/* 33 */     if (!minefantasy.MineFantasyBase.isDebug()) {
/* 34 */       if (!this.anvil.isBig()) {
/* 35 */         String s = this.anvil.func_94042_c() ? this.anvil.func_70303_b() : I18n.func_135053_a(this.anvil.func_70303_b());
/* 36 */         this.field_73886_k.func_78276_b(s, this.field_74194_b / 2 + 50 - this.field_73886_k.func_78256_a(s) / 2, 6, 4210752);
/*    */       }
/* 38 */       this.field_73886_k.func_78276_b(net.minecraft.util.StatCollector.func_74838_a("container.inventory"), 104, this.field_74195_c - 96 + 2, 4210752);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_74185_a(float Scale, int x, int y)
/*    */   {
/* 47 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 48 */     bindTexture(MFResource.image("/gui/" + this.anvil.getGui() + ".png"));
/* 49 */     int var5 = (this.field_73880_f - this.field_74194_b) / 2;
/* 50 */     int var6 = (this.field_73881_g - this.field_74195_c) / 2;
/* 51 */     func_73729_b(var5, var6, 0, 0, this.field_74194_b, this.field_74195_c);
/*    */     
/*    */ 
/* 54 */     if (this.anvil.isBig()) {
/* 55 */       int prog = this.anvil.getForgeProgressScaled(24);
/* 56 */       func_73729_b(var5 + 55, var6 + 102, 176, 0, prog + 1, 16);
/*    */     } else {
/* 58 */       int prog = this.anvil.getForgeProgressScaled(24);
/* 59 */       func_73729_b(var5 + 109, var6 + 34, 176, 0, prog + 1, 16);
/*    */     }
/*    */     
/* 62 */     if ((cfg.advancedAnvil) && (this.anvil.canCraft())) {
/* 63 */       bindTexture(MFResource.image("/gui/anvil.png"));
/* 64 */       func_73729_b(var5, var6 - 8, 0, 166, this.field_74194_b, 13);
/*    */       
/* 66 */       int quality = this.anvil.getQualityPosScaled(this.anvil.quality, this.field_74194_b - 8);
/* 67 */       int max = this.anvil.getQualityPosScaled(this.anvil.getQualityPeak(), this.field_74194_b - 8);
/*    */       
/* 69 */       func_73729_b(var5 + 4 + quality, var6 - 7, 5, 179, 5, 11);
/* 70 */       func_73729_b(var5 + 4 + max, var6 - 7, 10, 179, 5, 5);
/* 71 */       func_73729_b(var5 + 1, var6 - 14, 0, 179, 5, 12);
/*    */     }
/*    */   }
/*    */   
/*    */   private void bindTexture(String image) {
/* 76 */     this.field_73882_e.field_71446_o.func_110577_a(minefantasy.client.MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/GuiAnvil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */