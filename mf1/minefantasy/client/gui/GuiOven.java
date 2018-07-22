/*    */ package minefantasy.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.client.tile.TileEntityOven;
/*    */ import minefantasy.container.ContainerOven;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiOven
/*    */   extends GuiContainer
/*    */ {
/*    */   private TileEntityOven oven;
/* 21 */   private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
/*    */   
/*    */   public GuiOven(InventoryPlayer user, TileEntityOven tile) {
/* 24 */     super(new ContainerOven(user, tile));
/* 25 */     this.oven = tile;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_74189_g(int x, int y)
/*    */   {
/* 34 */     String s = this.oven.func_94042_c() ? this.oven.func_70303_b() : I18n.func_135053_a(this.oven.func_70303_b());
/* 35 */     this.field_73886_k.func_78276_b(s, this.field_74194_b / 2 - this.field_73886_k.func_78256_a(s) / 2, 6, 4210752);
/* 36 */     this.field_73886_k.func_78276_b(I18n.func_135053_a("container.inventory"), 8, this.field_74195_c - 96 + 2, 4210752);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_74185_a(float scale, int x, int y)
/*    */   {
/* 45 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 46 */     this.field_73882_e.func_110434_K().func_110577_a(furnaceGuiTextures);
/* 47 */     int k = (this.field_73880_f - this.field_74194_b) / 2;
/* 48 */     int l = (this.field_73881_g - this.field_74195_c) / 2;
/* 49 */     func_73729_b(k, l, 0, 0, this.field_74194_b, this.field_74195_c);
/*    */     
/*    */ 
/* 52 */     if (this.oven.isBurning()) {
/* 53 */       int i1 = this.oven.getBurnTimeRemainingScaled(12);
/* 54 */       func_73729_b(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
/*    */     }
/*    */     
/* 57 */     int i1 = this.oven.getCookProgressScaled(24);
/* 58 */     func_73729_b(k + 79, l + 34, 176, 14, i1 + 1, 16);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/GuiOven.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */