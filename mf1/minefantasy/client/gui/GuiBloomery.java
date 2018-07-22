/*    */ package minefantasy.client.gui;
/*    */ 
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.client.tile.TileEntitySmelter;
/*    */ import minefantasy.container.ContainerBloomery;
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
/*    */ public class GuiBloomery
/*    */   extends GuiContainer
/*    */ {
/*    */   private TileEntitySmelter furnaceInventory;
/*    */   
/*    */   public GuiBloomery(InventoryPlayer inventoryplayer, TileEntitySmelter tile)
/*    */   {
/* 24 */     super(new ContainerBloomery(inventoryplayer, tile));
/* 25 */     this.furnaceInventory = tile;
/*    */   }
/*    */   
/*    */   protected void func_74189_g(int x, int y) {
/* 29 */     this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.bloomery"), 60, 6, 4210752);
/* 30 */     this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
/*    */   }
/*    */   
/*    */   protected void func_74185_a(float f, int i, int j) {
/* 34 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 35 */     bindTexture(MFResource.image("/gui/Bloomery.png"));
/* 36 */     int l = (this.field_73880_f - this.field_74194_b) / 2;
/* 37 */     int i1 = (this.field_73881_g - this.field_74195_c) / 2;
/* 38 */     func_73729_b(l, i1, 0, 0, this.field_74194_b, this.field_74195_c);
/* 39 */     if (this.furnaceInventory.isBurning()) {
/* 40 */       int j1 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
/* 41 */       func_73729_b(l + 56, i1 + 29 + 12 - j1, 185, 12 - j1, 14, j1 + 2);
/*    */     }
/* 43 */     int k1 = this.furnaceInventory.getCookProgressScaled(26);
/* 44 */     func_73729_b(l + 96, i1 + 15, 176, 0, 8, k1 + 1);
/*    */   }
/*    */   
/*    */   private void bindTexture(String image) {
/* 48 */     this.field_73882_e.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/GuiBloomery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */