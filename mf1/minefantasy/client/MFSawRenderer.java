/*     */ package minefantasy.client;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.inventory.GuiInventory;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MFSawRenderer
/*     */   implements IItemRenderer
/*     */ {
/*  33 */   RenderItem renderItem = new RenderItem();
/*     */   private float scale;
/*     */   
/*     */   public MFSawRenderer() {
/*  37 */     this(1.0F);
/*     */   }
/*     */   
/*     */   public MFSawRenderer(float Sc) {
/*  41 */     this.scale = Sc;
/*     */   }
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*     */   {
/*  46 */     return type.equals(IItemRenderer.ItemRenderType.EQUIPPED);
/*     */   }
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*     */   {
/*  51 */     return false;
/*     */   }
/*     */   
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*     */   {
/*  56 */     Minecraft mc = FMLClientHandler.instance().getClient();
/*  57 */     if (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) {
/*  58 */       EntityLivingBase player = null;
/*  59 */       for (int a = 0; a < data.length; a++) {
/*  60 */         if ((data[a] instanceof EntityLivingBase)) {
/*  61 */           player = (EntityLivingBase)data[a];
/*     */         }
/*     */       }
/*     */       
/*  65 */       renderWeaponAsItem(item, player);
/*     */     }
/*     */   }
/*     */   
/*     */   private void renderFirstPerson(ItemStack item, EntityLivingBase player)
/*     */   {
/*  71 */     GL11.glPushMatrix();
/*  72 */     GL11.glTranslatef(-1.2F, 1.3F, 0.0F);
/*  73 */     boolean flying = false;
/*  74 */     if ((player instanceof EntityPlayer)) {
/*  75 */       flying = ((EntityPlayer)player).field_71075_bZ.field_75100_b;
/*     */     }
/*  77 */     if ((player.field_70143_R > 3.0F) && (!flying)) {
/*  78 */       GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
/*  79 */       GL11.glTranslatef(0.25F, 0.0F, 0.8F);
/*     */     }
/*     */     
/*  82 */     renderWeaponAsItem(item, player);
/*     */     
/*  84 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void renderWeapon(ItemStack item, EntityLivingBase player)
/*     */   {
/*  89 */     GL11.glTranslatef(-0.87F, -0.2F, 0.0F);
/*     */     
/*  91 */     GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
/*     */     
/*  93 */     renderWeaponAsItem(item, player);
/*     */   }
/*     */   
/*     */   private boolean isFirstPerson(EntityLivingBase player)
/*     */   {
/*  98 */     Minecraft mc = FMLClientHandler.instance().getClient();
/*  99 */     return (mc.field_71474_y.field_74320_O == 0) && (player == mc.field_71439_g) && (!(mc.field_71462_r instanceof GuiInventory));
/*     */   }
/*     */   
/*     */   private void renderWeaponAsItem(ItemStack item, EntityLivingBase player) {
/* 103 */     GL11.glPushMatrix();
/*     */     
/* 105 */     Icon icon = item.func_77954_c();
/* 106 */     Minecraft mc = FMLClientHandler.instance().getClient();
/* 107 */     mc.field_71446_o.func_110577_a(TextureMap.field_110576_c);
/* 108 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 109 */     float x1 = icon.func_94209_e();
/* 110 */     float x2 = icon.func_94212_f();
/* 111 */     float y1 = icon.func_94206_g();
/* 112 */     float y2 = icon.func_94210_h();
/*     */     
/* 114 */     float xOffset = 0.05F + 0.5F * (this.scale - 1.0F);
/* 115 */     float yOffset = 0.35F - 0.5F * (this.scale - 1.0F);
/* 116 */     float xPos = 0.0F + xOffset - yOffset;
/* 117 */     float yPos = 0.3F - xOffset - yOffset;
/* 118 */     GL11.glEnable(32826);
/* 119 */     GL11.glTranslatef(-xPos, -yPos, 0.0F);
/* 120 */     GL11.glScalef(this.scale, this.scale, 1.0F);
/*     */     
/* 122 */     if (player == null) {
/* 123 */       GL11.glTranslatef(0.6F, -0.2F, 0.0F);
/* 124 */       GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
/*     */     }
/*     */     
/* 127 */     ItemRenderer.func_78439_a(tessellator, x2, y1, x1, y2, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */     
/* 129 */     if ((item != null) && (item.func_77948_v())) {
/* 130 */       GL11.glDepthFunc(514);
/* 131 */       GL11.glDisable(2896);
/* 132 */       mc.field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 133 */       GL11.glEnable(3042);
/* 134 */       GL11.glBlendFunc(768, 1);
/* 135 */       float var13 = 0.76F;
/* 136 */       GL11.glColor4f(0.5F * var13, 0.25F * var13, 0.8F * var13, 1.0F);
/* 137 */       GL11.glMatrixMode(5890);
/* 138 */       GL11.glPushMatrix();
/* 139 */       float var14 = 0.125F;
/* 140 */       GL11.glScalef(var14, var14, var14);
/* 141 */       float var15 = (float)(System.currentTimeMillis() % 3000L) / 3000.0F * 8.0F;
/* 142 */       GL11.glTranslatef(var15, 0.0F, 0.0F);
/* 143 */       GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 144 */       ItemRenderer.func_78439_a(tessellator, x2, y1, x1, y2, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/* 145 */       GL11.glPopMatrix();
/* 146 */       GL11.glPushMatrix();
/* 147 */       GL11.glScalef(var14, var14, var14);
/* 148 */       var15 = (float)(System.currentTimeMillis() % 4873L) / 4873.0F * 8.0F;
/* 149 */       GL11.glTranslatef(-var15, 0.0F, 0.0F);
/* 150 */       GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 151 */       ItemRenderer.func_78439_a(tessellator, x2, y1, x1, y2, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/* 152 */       GL11.glPopMatrix();
/* 153 */       GL11.glMatrixMode(5888);
/* 154 */       GL11.glDisable(3042);
/* 155 */       GL11.glEnable(2896);
/* 156 */       GL11.glDepthFunc(515);
/*     */     }
/*     */     
/* 159 */     GL11.glDisable(32826);
/*     */     
/* 161 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFSawRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */