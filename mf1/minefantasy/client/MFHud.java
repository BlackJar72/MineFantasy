/*     */ package minefantasy.client;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import minefantasy.api.IMFCrafter;
/*     */ import minefantasy.client.tile.TileEntityAnvil;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.cfg;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.EnumMovingObjectType;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MFHud extends Gui
/*     */ {
/*  23 */   private static Minecraft mc = ;
/*     */   
/*     */   public void renderGameOverlay(float partialTicks, int mouseX, int mouseY) {
/*  26 */     if (cfg.disableHUD) {
/*  27 */       return;
/*     */     }
/*  29 */     GL11.glColor3f(255.0F, 255.0F, 255.0F);
/*  30 */     int[] coords = getClickedBlock(partialTicks, mouseX, mouseY);
/*  31 */     if (coords == null) {
/*  32 */       return;
/*     */     }
/*  34 */     int x = coords[0];
/*  35 */     int y = coords[1];
/*  36 */     int z = coords[2];
/*  37 */     EntityPlayer player = mc.field_71439_g;
/*  38 */     World world = player.field_70170_p;
/*  39 */     TileEntity tile = world.func_72796_p(x, y, z);
/*  40 */     if ((tile != null) && ((tile instanceof IMFCrafter))) {
/*  41 */       renderCraftMetre(world, player, (IMFCrafter)tile);
/*     */     }
/*  43 */     if ((cfg.advancedAnvil) && (tile != null) && ((tile instanceof TileEntityAnvil))) {
/*  44 */       renderAnvil(world, player, (TileEntityAnvil)tile);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void renderCraftMetre(World world, EntityPlayer player, IMFCrafter tile)
/*     */   {
/*  52 */     if (!tile.shouldRenderCraftMetre()) {
/*  53 */       return;
/*     */     }
/*  55 */     GL11.glPushMatrix();
/*  56 */     ScaledResolution scaledresolution = new ScaledResolution(mc.field_71474_y, mc.field_71443_c, mc.field_71440_d);
/*  57 */     int width = scaledresolution.func_78326_a();
/*  58 */     int height = scaledresolution.func_78328_b();
/*     */     
/*  60 */     bindTexture(MFResource.image("/gui/craftMetre.png"));
/*  61 */     int xPos = width / 2 + cfg.craftMetreX - 48;
/*  62 */     int yPos = height - cfg.craftMetreY;
/*     */     
/*  64 */     func_73729_b(xPos, yPos, 0, 0, 96, 16);
/*  65 */     func_73729_b(xPos + 4, yPos + 4, 0, 17, tile.getProgressBar(88), 9);
/*     */     
/*  67 */     String s = tile.getResultName();
/*  68 */     mc.field_71466_p.func_78276_b(s, xPos + 48 - mc.field_71466_p.func_78256_a(s) / 2, yPos + 5, 0);
/*  69 */     GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*     */     
/*  71 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderAnvil(World world, EntityPlayer player, TileEntityAnvil anvil) {
/*  75 */     if (!anvil.shouldRenderCraftMetre()) {
/*  76 */       return;
/*     */     }
/*     */     
/*  79 */     GL11.glPushMatrix();
/*  80 */     ScaledResolution scaledresolution = new ScaledResolution(mc.field_71474_y, mc.field_71443_c, mc.field_71440_d);
/*  81 */     int width = scaledresolution.func_78326_a();
/*  82 */     int height = scaledresolution.func_78328_b();
/*     */     
/*  84 */     bindTexture(MFResource.image("/gui/craftMetre.png"));
/*  85 */     int xPos = width / 2 + cfg.craftMetreX - 48;
/*  86 */     int yPos = height - cfg.craftMetreY + 16;
/*     */     
/*  88 */     if (anvil.canCraft()) {
/*  89 */       func_73729_b(xPos, yPos, 0, 34, 96, 10);
/*     */       
/*  91 */       int quality = anvil.getQualityPosScaled(anvil.quality, 88);
/*  92 */       int max = anvil.getQualityPosScaled(anvil.getQualityPeak(), 88);
/*     */       
/*  94 */       func_73729_b(xPos + 4 + quality, yPos, 5, 45, 5, 11);
/*  95 */       func_73729_b(xPos + 4 + max, yPos, 10, 45, 5, 5);
/*  96 */       func_73729_b(xPos + 1, yPos - 7, 0, 45, 5, 12);
/*     */     }
/*  98 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public int[] getClickedBlock(float ticks, int mouseX, int mouseY) {
/* 102 */     if ((mc.field_71476_x != null) && (mc.field_71476_x.field_72313_a == EnumMovingObjectType.TILE)) {
/* 103 */       int j = mc.field_71476_x.field_72311_b;
/* 104 */       int k = mc.field_71476_x.field_72312_c;
/* 105 */       int l = mc.field_71476_x.field_72309_d;
/*     */       
/* 107 */       return new int[] { j, k, l };
/*     */     }
/* 109 */     return null;
/*     */   }
/*     */   
/*     */   public void bindTexture(String image) {
/* 113 */     mc.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFHud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */