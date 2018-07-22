/*    */ package minefantasy.client.gui.hound;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.system.MFResource;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiButtonHoundTab extends GuiButton
/*    */ {
/*    */   private int icon;
/*    */   private String name;
/* 16 */   private Minecraft mc = Minecraft.func_71410_x();
/*    */   private IBaseHoundScreen gui;
/*    */   
/*    */   public GuiButtonHoundTab(String title, IBaseHoundScreen base, int id, int x, int y, int index) {
/* 20 */     this(true, title, base, id, x, y, index);
/*    */   }
/*    */   
/*    */   public GuiButtonHoundTab(boolean active, String title, IBaseHoundScreen base, int id, int x, int y, int index) {
/* 24 */     super(id, x, y, 20, 20, "");
/* 25 */     this.field_73748_h = active;
/* 26 */     this.gui = base;
/* 27 */     this.icon = index;
/* 28 */     this.name = title;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_73737_a(Minecraft mc, int x, int y)
/*    */   {
/* 35 */     if (this.field_73748_h) {
/* 36 */       bindTexture(MFResource.image("/gui/Hound/Main.png"));
/* 37 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 38 */       this.field_82253_i = ((x >= this.field_73746_c) && (y >= this.field_73743_d) && (x < this.field_73746_c + this.field_73747_a) && (y < this.field_73743_d + this.field_73745_b));
/* 39 */       int yPos = 216;
/*    */       
/* 41 */       if (this.field_82253_i) {
/* 42 */         yPos += this.field_73745_b;
/*    */       }
/* 44 */       int xPos = 20 * this.icon;
/*    */       
/* 46 */       func_73729_b(this.field_73746_c, this.field_73743_d, xPos, yPos, this.field_73747_a, this.field_73745_b);
/*    */     }
/*    */   }
/*    */   
/*    */   public void func_82251_b(int par1, int par2)
/*    */   {
/* 52 */     if ((this.gui != null) && (this.name != null))
/* 53 */       this.gui.drawText(this.name, par1, par2);
/*    */   }
/*    */   
/*    */   private void bindTexture(String image) {
/* 57 */     this.mc.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/hound/GuiButtonHoundTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */