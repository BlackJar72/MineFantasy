/*    */ package minefantasy.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ class GuiButtonProspectNextPage
/*    */   extends GuiButton
/*    */ {
/*    */   private final boolean nextPage;
/*    */   
/*    */   public GuiButtonProspectNextPage(int par1, int par2, int par3, boolean par4)
/*    */   {
/* 21 */     super(par1, par2, par3, 23, 13, "");
/* 22 */     this.nextPage = par4;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_73737_a(Minecraft mc, int x, int y)
/*    */   {
/* 29 */     if (this.field_73748_h) {
/* 30 */       boolean var4 = (x >= this.field_73746_c) && (y >= this.field_73743_d) && (x < this.field_73746_c + this.field_73747_a) && (y < this.field_73743_d + this.field_73745_b);
/* 31 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 32 */       bindTexture(MFResource.image("/gui/prospect.png"));
/* 33 */       int var5 = 0;
/* 34 */       int var6 = 192;
/*    */       
/* 36 */       if (var4) {
/* 37 */         var5 += 23;
/*    */       }
/*    */       
/* 40 */       if (!this.nextPage) {
/* 41 */         var6 += 13;
/*    */       }
/*    */       
/* 44 */       func_73729_b(this.field_73746_c, this.field_73743_d, var5, var6, 23, 13);
/*    */     }
/*    */   }
/*    */   
/*    */   private void bindTexture(String image) {
/* 49 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/GuiButtonProspectNextPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */