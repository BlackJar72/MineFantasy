/*    */ package minefantasy.client.gui.hound;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiButtonHoundAttribute
/*    */   extends GuiButton
/*    */ {
/* 23 */   private String name = "";
/*    */   private IBaseHoundScreen gui;
/* 25 */   private Minecraft mc = Minecraft.func_71410_x();
/*    */   
/*    */   public GuiButtonHoundAttribute(String name, IBaseHoundScreen base, int id, int x, int y) {
/* 28 */     this(id, x, y);
/* 29 */     this.gui = base;
/*    */   }
/*    */   
/*    */   public GuiButtonHoundAttribute(int id, int x, int y)
/*    */   {
/* 34 */     super(id, x, y, 72, 22, "");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_73737_a(Minecraft mc, int x, int y)
/*    */   {
/* 41 */     if (this.field_73748_h) {
/* 42 */       this.field_82253_i = ((x >= this.field_73746_c) && (y >= this.field_73743_d) && (x < this.field_73746_c + this.field_73747_a) && (y < this.field_73743_d + this.field_73745_b));
/* 43 */       bindTexture(MFResource.image("/gui/Hound/Stats.png"));
/* 44 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 45 */       int yPos = 166;
/* 46 */       int xPos = 0;
/*    */       
/* 48 */       if (this.field_82253_i) {
/* 49 */         xPos += this.field_73747_a;
/*    */       }
/*    */       
/* 52 */       func_73729_b(this.field_73746_c, this.field_73743_d, xPos, yPos, this.field_73747_a, this.field_73745_b);
/*    */     }
/*    */   }
/*    */   
/*    */   private void bindTexture(String image)
/*    */   {
/* 58 */     this.mc.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*    */   }
/*    */   
/*    */   public void func_82251_b(int par1, int par2)
/*    */   {
/* 63 */     if ((this.gui != null) && (this.name != null)) {
/* 64 */       this.gui.drawText(this.name, par1, par2);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/hound/GuiButtonHoundAttribute.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */