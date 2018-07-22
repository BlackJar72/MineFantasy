/*    */ package minefantasy.client.gui;
/*    */ 
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.client.tile.TileEntityFurnaceMF;
/*    */ import minefantasy.container.ContainerFurnaceMF;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiFurnaceMF
/*    */   extends GuiContainer
/*    */ {
/*    */   private TileEntityFurnaceMF smelter;
/*    */   
/*    */   public GuiFurnaceMF(EntityPlayer play, InventoryPlayer inventoryplayer, TileEntityFurnaceMF tile)
/*    */   {
/* 25 */     super(new ContainerFurnaceMF(play, inventoryplayer, tile));
/* 26 */     this.smelter = tile;
/*    */   }
/*    */   
/*    */   protected void func_74189_g(int x, int y) {
/* 30 */     this.field_73886_k.func_78276_b(this.smelter.func_70303_b(), 60, 6, 4210752);
/* 31 */     this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
/*    */   }
/*    */   
/*    */   protected void func_74185_a(float f, int i, int j) {
/* 35 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 36 */     if (this.smelter.isHeater()) {
/* 37 */       bindTexture(MFResource.image("/gui/Heater.png"));
/*    */     } else {
/* 39 */       bindTexture(MFResource.image("/gui/bigFurnace.png"));
/*    */     }
/* 41 */     int posX = (this.field_73880_f - this.field_74194_b) / 2;
/* 42 */     int posY = (this.field_73881_g - this.field_74195_c) / 2;
/*    */     
/* 44 */     func_73729_b(posX, posY, 0, 0, this.field_74194_b, this.field_74195_c);
/*    */     
/* 46 */     if (this.smelter.isBurning()) {
/* 47 */       if (this.smelter.isHeater())
/*    */       {
/* 49 */         int fuelSc = this.smelter.getBurnTimeRemainingScaled(12);
/* 50 */         if (this.smelter.fuel > 0) {
/* 51 */           func_73729_b(posX + 59, posY + 27 + 12 - fuelSc, 176, 12 - fuelSc, 14, fuelSc + 2);
/*    */         }
/*    */         
/* 54 */         int heatScM = this.smelter.getItemHeatScaled(68);
/* 55 */         func_73729_b(posX + 104, posY + 76 - heatScM, 176, 14, 16, 3);
/*    */         
/*    */ 
/* 58 */         int heatSc = this.smelter.getHeatScaled(68);
/* 59 */         func_73729_b(posX + 107, posY + 76 - heatSc, 176, 17, 10, 5);
/*    */       }
/* 61 */       else if (this.smelter.progress > 0) {
/* 62 */         int prog = this.smelter.getCookProgressScaled(24);
/* 63 */         func_73729_b(posX + 76, posY + 34, 176, 0, prog + 1, 16);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private void bindTexture(String image)
/*    */   {
/* 70 */     this.field_73882_e.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/GuiFurnaceMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */