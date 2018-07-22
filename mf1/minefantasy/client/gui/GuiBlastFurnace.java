/*    */ package minefantasy.client.gui;
/*    */ 
/*    */ import minefantasy.MineFantasyBase;
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.client.tile.TileEntityBlastFurnace;
/*    */ import minefantasy.container.ContainerBFurnace;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiBlastFurnace
/*    */   extends GuiContainer
/*    */ {
/*    */   private TileEntityBlastFurnace furn;
/*    */   private int type;
/*    */   
/*    */   public GuiBlastFurnace(int meta, EntityPlayer entityplayer, TileEntityBlastFurnace tile)
/*    */   {
/* 28 */     super(new ContainerBFurnace(meta, entityplayer, tile));
/* 29 */     this.type = meta;
/* 30 */     this.furn = tile;
/*    */   }
/*    */   
/*    */   protected void func_74189_g(int x, int y) {
/* 34 */     if (!MineFantasyBase.isDebug()) {
/* 35 */       String s = this.furn.func_94042_c() ? this.furn.func_70303_b() : I18n.func_135053_a(this.furn.func_70303_b());
/* 36 */       this.field_73886_k.func_78276_b(s, this.field_74194_b / 2 - this.field_73886_k.func_78256_a(s) / 2, 6, 4210752);
/* 37 */       this.field_73886_k.func_78276_b(StatCollector.func_74838_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
/*    */     }
/*    */   }
/*    */   
/*    */   protected void func_74185_a(float f, int i, int j) {
/* 42 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 43 */     bindTexture(MFResource.image("/gui/blast/" + this.furn.getTexture() + ".png"));
/* 44 */     int l = (this.field_73880_f - this.field_74194_b) / 2;
/* 45 */     int i1 = (this.field_73881_g - this.field_74195_c) / 2;
/* 46 */     func_73729_b(l, i1, 0, 0, this.field_74194_b, this.field_74195_c);
/*    */     
/* 48 */     if (this.type == 2)
/*    */     {
/* 50 */       int j1 = this.furn.getBurnTimeRemainingScaled(12);
/* 51 */       if ((this.furn.isBurning()) && (this.furn.fuel > 0)) {
/* 52 */         func_73729_b(l + 80, i1 + 36 + 12 - j1, 176, 12 - j1, 14, j1 + 2);
/*    */       }
/* 54 */       int progBar = this.furn.getHeatProgressScaled(160);
/*    */       
/* 56 */       if ((this.furn.heat > 0) && (this.furn.heat < TileEntityBlastFurnace.requiredHeat)) {
/* 57 */         String message = "Heating...";
/* 58 */         this.field_73886_k.func_78276_b(message, l + 76 - message.length(), i1 + 14, 4210752);
/*    */         
/* 60 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 61 */         bindTexture(MFResource.image("/gui/blast/" + this.furn.getTexture() + ".png"));
/* 62 */         func_73729_b(l + 8, i1 + 22, 0, 166, 160, 8);
/* 63 */         if (progBar > 0)
/* 64 */           func_73729_b(l + 8, i1 + 22, 0, 174, progBar, 8);
/*    */       }
/* 66 */       if (this.furn.heat <= 0) {
/* 67 */         String message = "Not Heated";
/* 68 */         this.field_73886_k.func_78276_b(message, l + 76 - message.length(), i1 + 14, 4210752);
/*    */       }
/*    */     }
/* 71 */     if (this.type == 1)
/*    */     {
/* 73 */       int k1 = this.furn.getCookProgressScaled(24);
/* 74 */       func_73729_b(l + 103, i1 + 34, 176, 0, k1 + 1, 16);
/*    */     }
/*    */   }
/*    */   
/*    */   private void bindTexture(String image) {
/* 79 */     this.field_73882_e.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/GuiBlastFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */