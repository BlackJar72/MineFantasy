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
/*    */ public class GuiButtonHoundPower
/*    */   extends GuiButton
/*    */ {
/*    */   private int icon;
/*    */   private String[] text;
/*    */   private IBaseHoundScreen gui;
/* 26 */   private Minecraft mc = Minecraft.func_71410_x();
/*    */   
/*    */   public GuiButtonHoundPower(String name, IBaseHoundScreen base, int id, int x, int y, int index) {
/* 29 */     this(new String[] { name }, base, id, x, y, index);
/*    */   }
/*    */   
/*    */   public GuiButtonHoundPower(String[] name, IBaseHoundScreen base, int id, int x, int y, int index) {
/* 33 */     this(id, x, y, index);
/* 34 */     this.gui = base;
/* 35 */     this.text = name;
/*    */   }
/*    */   
/*    */   public GuiButtonHoundPower(int id, int x, int y, int index) {
/* 39 */     super(id, x, y, 20, 20, "");
/* 40 */     this.field_73748_h = false;
/* 41 */     this.icon = index;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_73737_a(Minecraft mc, int x, int y)
/*    */   {
/* 48 */     if (this.field_73748_h) {
/* 49 */       this.field_82253_i = ((x >= this.field_73746_c) && (y >= this.field_73743_d) && (x < this.field_73746_c + this.field_73747_a) && (y < this.field_73743_d + this.field_73745_b));
/* 50 */       bindTexture(MFResource.image("/gui/Hound/Command.png"));
/* 51 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 52 */       int yPos = 34;
/*    */       
/* 54 */       if (this.field_82253_i) {
/* 55 */         yPos += this.field_73745_b;
/*    */       }
/* 57 */       int xPos = 20 * this.icon;
/*    */       
/* 59 */       func_73729_b(this.field_73746_c, this.field_73743_d, xPos, yPos, this.field_73747_a, this.field_73745_b);
/*    */     }
/*    */   }
/*    */   
/*    */   private void bindTexture(String image)
/*    */   {
/* 65 */     this.mc.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*    */   }
/*    */   
/*    */   public void func_82251_b(int x, int y)
/*    */   {
/* 70 */     if ((this.gui != null) && (this.text != null)) {
/* 71 */       y -= (this.text.length - 1) * 4;
/* 72 */       this.gui.drawText(this.text, x, y);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/hound/GuiButtonHoundPower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */