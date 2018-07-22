/*    */ package minefantasy.client.gui;
/*    */ 
/*    */ import minefantasy.MineFantasyBase;
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.client.tile.TileEntitySmelter;
/*    */ import minefantasy.container.ContainerCrucible;
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
/*    */ public class GuiCrucible
/*    */   extends GuiContainer
/*    */ {
/*    */   private TileEntitySmelter smelter;
/*    */   
/*    */   public GuiCrucible(InventoryPlayer inventoryplayer, TileEntitySmelter tile)
/*    */   {
/* 25 */     super(new ContainerCrucible(inventoryplayer, tile));
/* 26 */     this.smelter = tile;
/*    */   }
/*    */   
/*    */   protected void func_74189_g(int x, int y) {
/* 30 */     if (!MineFantasyBase.isDebug()) {
/* 31 */       if (this.smelter.getTier() == 1) {
/* 32 */         this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.crucible"), 60, 6, 4210752);
/* 33 */         this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
/*    */       }
/*    */       
/* 36 */       if (this.smelter.getTier() == 2)
/* 37 */         this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.crucible"), 102, 6, 4210752);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void func_74185_a(float f, int i, int j) {
/* 42 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 43 */     if (this.smelter.getTier() == 1) {
/* 44 */       bindTexture(MFResource.image("/gui/alloySml.png"));
/*    */     } else
/* 46 */       bindTexture(MFResource.image("/gui/alloy.png"));
/* 47 */     int posX = (this.field_73880_f - this.field_74194_b) / 2;
/* 48 */     int posY = (this.field_73881_g - this.field_74195_c) / 2;
/* 49 */     int offset = 0;
/* 50 */     if (this.smelter.getTier() == 2) {
/* 51 */       offset = 9;
/*    */     }
/* 53 */     func_73729_b(posX, posY, 0, 0, this.field_74194_b, this.field_74195_c);
/* 54 */     if ((this.smelter.maxFuel > 0) && (this.smelter.fuel > 0)) {
/* 55 */       int j1 = this.smelter.getBurnTimeRemainingScaled(12);
/* 56 */       func_73729_b(posX + 8, posY + 36 + 12 - j1, 176, 12 - j1, 14, j1 + 2);
/*    */     }
/* 58 */     int k1 = this.smelter.getCookProgressScaled(24);
/* 59 */     func_73729_b(posX + 100 + offset, posY + 34, 176, 14, k1 + 1, 16);
/*    */     
/* 61 */     if (this.smelter.getTier() > 0)
/*    */     {
/* 63 */       int heatSc = this.smelter.getHeatScaled(68);
/* 64 */       if (heatSc > 0)
/* 65 */         func_73729_b(posX + 9, posY + 76 - heatSc, 190, 9, 10, 5);
/*    */     }
/*    */   }
/*    */   
/*    */   private void bindTexture(String image) {
/* 70 */     this.field_73882_e.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/GuiCrucible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */