/*    */ package minefantasy.client.gui;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiButtonNextPageMF extends GuiButton
/*    */ {
/* 13 */   private static final ResourceLocation tex = new ResourceLocation("textures/gui/book.png");
/*    */   
/*    */ 
/*    */   private final boolean nextPage;
/*    */   
/*    */ 
/*    */   public GuiButtonNextPageMF(int par1, int par2, int par3, boolean par4)
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
/* 30 */       boolean flag = (x >= this.field_73746_c) && (y >= this.field_73743_d) && (x < this.field_73746_c + this.field_73747_a) && (y < this.field_73743_d + this.field_73745_b);
/* 31 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 32 */       mc.field_71446_o.func_110577_a(tex);
/* 33 */       int k = 0;
/* 34 */       int l = 192;
/*    */       
/* 36 */       if (flag) {
/* 37 */         k += 23;
/*    */       }
/*    */       
/* 40 */       if (!this.nextPage) {
/* 41 */         l += 13;
/*    */       }
/*    */       
/* 44 */       func_73729_b(this.field_73746_c, this.field_73743_d, k, l, 23, 13);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/GuiButtonNextPageMF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */