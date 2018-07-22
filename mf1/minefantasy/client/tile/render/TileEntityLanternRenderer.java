/*    */ package minefantasy.client.tile.render;
/*    */ 
/*    */ import minefantasy.client.tile.TileEntityLantern;
/*    */ import minefantasy.client.tile.model.ModelLantern;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TileEntityLanternRenderer
/*    */   extends TileEntitySpecialRenderer
/*    */ {
/*    */   private final ModelLantern model;
/*    */   
/*    */   public TileEntityLanternRenderer()
/*    */   {
/* 25 */     this.model = new ModelLantern();
/*    */   }
/*    */   
/*    */   public void func_76894_a(TileEntity te, double x, double y, double z, float scale)
/*    */   {
/* 30 */     GL11.glPushMatrix();
/* 31 */     GL11.glTranslated(x + 0.5D, y + 1.0D, z + 0.5D);
/*    */     
/* 33 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(new ResourceLocation("minefantasy", "textures/models/lantern.png"));
/*    */     
/* 35 */     GL11.glPushMatrix();
/* 36 */     GL11.glRotatef(0.0F, 0.0F, 0.0F, 0.0F);
/* 37 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/*    */     
/*    */ 
/*    */ 
/* 41 */     this.model.renderModel((TileEntityLantern)te, 0.0625F);
/*    */     
/* 43 */     GL11.glPopMatrix();
/* 44 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   private void adjustLightFixture(World world, int i, int j, int k, Block block) {
/* 48 */     Tessellator tess = Tessellator.field_78398_a;
/*    */     
/* 50 */     float brightness = block.getLightValue(world, i, j, k);
/* 51 */     int skyLight = world.func_72802_i(i, j, k, 0);
/* 52 */     int modulousModifier = skyLight % 65536;
/* 53 */     int divModifier = skyLight / 65536;
/*    */     
/* 55 */     tess.func_78386_a(brightness, brightness, brightness);
/*    */     
/* 57 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, modulousModifier, divModifier);
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityLanternRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */