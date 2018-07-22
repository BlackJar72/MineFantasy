/*     */ package minefantasy.client.tile.render;
/*     */ 
/*     */ import minefantasy.api.aesthetic.IWeaponrackHangable;
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.client.tile.TileEntityWeaponRack;
/*     */ import minefantasy.client.tile.model.ModelWeaponRack;
/*     */ import minefantasy.system.MFResource;
/*     */ import minefantasy.system.cfg;
/*     */ import mods.battlegear2.api.shield.IShield;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
/*     */ import net.minecraftforge.client.MinecraftForgeClient;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TileEntityWeaponRackRenderer
/*     */   extends TileEntitySpecialRenderer
/*     */ {
/*     */   private ModelWeaponRack model;
/*     */   
/*     */   public TileEntityWeaponRackRenderer()
/*     */   {
/*  38 */     this.model = new ModelWeaponRack();
/*     */   }
/*     */   
/*     */   public void renderAModelAt(TileEntityWeaponRack tile, double d, double d1, double d2, float f) {
/*  42 */     int tiledirection = 1;int tileangle = 90 * tiledirection;
/*     */     
/*  44 */     if (tile.field_70331_k != null) {
/*  45 */       tiledirection = tile.direction;
/*     */     }
/*     */     
/*  48 */     switch (tiledirection) {
/*     */     case 0: 
/*  50 */       tileangle = 0;
/*  51 */       break;
/*     */     
/*     */     case 1: 
/*  54 */       tileangle = 270;
/*  55 */       break;
/*     */     
/*     */     case 2: 
/*  58 */       tileangle = 180;
/*  59 */       break;
/*     */     
/*     */     case 3: 
/*     */     case 4: 
/*  63 */       tileangle = 90;
/*     */     }
/*     */     
/*     */     
/*  67 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(MFTextureHelper.getResource(MFResource.image("/item/Rack.png")));
/*     */     
/*  69 */     GL11.glPushMatrix();
/*  70 */     GL11.glTranslatef((float)d + 0.5F, (float)d1 + 1.0F, (float)d2 + 0.5F);
/*  71 */     GL11.glRotatef(tileangle + 180, 0.0F, 1.0F, 0.0F);
/*  72 */     GL11.glScalef(1.0F, -1.0F, -1.0F);
/*  73 */     float itemsStart = -0.1875F;
/*  74 */     float itemsGap = 0.25F;
/*  75 */     this.model.renderModel(0.0625F);
/*  76 */     for (int a = 0; a < 4; a++) {
/*  77 */       GL11.glPushMatrix();
/*  78 */       ItemStack itemstack = tile.func_70301_a(a);
/*  79 */       if (itemstack != null) {
/*  80 */         float x = itemsStart + a * itemsGap;
/*  81 */         float y = 0.3F;
/*  82 */         float z = a % 2 == 0 ? 0.4F : 0.45F;
/*  83 */         z -= 0.125F;
/*  84 */         float r = getRotationForItem(itemstack.func_77973_b());
/*  85 */         float scale = 1.0F;
/*     */         
/*  87 */         GL11.glTranslatef(x, y, z);
/*     */         
/*  89 */         GL11.glPushMatrix();
/*  90 */         GL11.glRotatef(r, 0.0F, 0.0F, 1.0F);
/*  91 */         GL11.glScalef(scale, scale, 1.0F);
/*     */         
/*  93 */         for (int layer = 0; layer < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); layer++) {
/*  94 */           Icon icon = itemstack.func_77973_b().getIcon(itemstack, layer);
/*  95 */           if (icon != null) {
/*  96 */             GL11.glPushMatrix();
/*  97 */             renderItem(tile, itemstack, icon, a, layer);
/*  98 */             GL11.glPopMatrix();
/*     */           }
/*     */         }
/* 101 */         GL11.glPopMatrix();
/*     */       }
/*     */       
/* 104 */       GL11.glPopMatrix();
/*     */     }
/* 106 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private float getRotationForItem(Item item)
/*     */   {
/* 111 */     String classname = item.getClass().getName();
/* 112 */     if ((classname.endsWith("ItemCrossbow")) || (classname.endsWith("ItemBlunderbuss")) || (classname.endsWith("ItemBlowgun")) || (classname.endsWith("ItemMusket"))) {
/* 113 */       return 45.0F;
/*     */     }
/* 115 */     return -45.0F;
/*     */   }
/*     */   
/*     */   public void func_76894_a(TileEntity tileentity, double d, double d1, double d2, float f)
/*     */   {
/* 120 */     renderAModelAt((TileEntityWeaponRack)tileentity, d, d1, d2, f);
/*     */   }
/*     */   
/*     */   private void renderItem(TileEntityWeaponRack tile, ItemStack itemstack, Icon icon, int slot, int layer) {
/* 124 */     GL11.glPushMatrix();
/* 125 */     TextureManager texturemanager = Minecraft.func_71410_x().func_110434_K();
/* 126 */     GL11.glScalef(0.85F, 0.85F, 0.85F);
/*     */     
/* 128 */     IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED);
/* 129 */     if ((isCustom(itemstack)) && (customRenderer != null)) {
/* 130 */       texturemanager.func_110577_a(texturemanager.func_130087_a(itemstack.func_94608_d()));
/* 131 */       renderEquippedItem(IItemRenderer.ItemRenderType.EQUIPPED, customRenderer, new RenderBlocks(), itemstack);
/*     */     } else {
/* 133 */       if (icon == null) {
/* 134 */         GL11.glPopMatrix();
/* 135 */         return;
/*     */       }
/*     */       
/* 138 */       texturemanager.func_110577_a(texturemanager.func_130087_a(itemstack.func_94608_d()));
/* 139 */       Tessellator tessellator = Tessellator.field_78398_a;
/* 140 */       float f = icon.func_94209_e();
/* 141 */       float f1 = icon.func_94212_f();
/* 142 */       float f2 = icon.func_94206_g();
/* 143 */       float f3 = icon.func_94210_h();
/* 144 */       float f4 = 0.0F;
/* 145 */       float f5 = 0.3F;
/* 146 */       GL11.glEnable(32826);
/* 147 */       GL11.glTranslatef(-f4, -f5, 0.0F);
/* 148 */       GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
/* 149 */       ItemRenderer.func_78439_a(tessellator, f1, f2, f, f3, icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */       
/* 151 */       if (itemstack.hasEffect(layer)) {
/* 152 */         GL11.glDepthFunc(514);
/* 153 */         GL11.glDisable(2896);
/* 154 */         texturemanager.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 155 */         GL11.glEnable(3042);
/* 156 */         GL11.glBlendFunc(768, 1);
/* 157 */         float f7 = 0.76F;
/* 158 */         GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
/* 159 */         GL11.glMatrixMode(5890);
/* 160 */         GL11.glPushMatrix();
/* 161 */         float f8 = 0.125F;
/* 162 */         GL11.glScalef(f8, f8, f8);
/* 163 */         float f9 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 164 */         GL11.glTranslatef(f9, 0.0F, 0.0F);
/* 165 */         GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 166 */         ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
/* 167 */         GL11.glPopMatrix();
/* 168 */         GL11.glPushMatrix();
/* 169 */         GL11.glScalef(f8, f8, f8);
/* 170 */         f9 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 171 */         GL11.glTranslatef(-f9, 0.0F, 0.0F);
/* 172 */         GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 173 */         ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
/* 174 */         GL11.glPopMatrix();
/* 175 */         GL11.glMatrixMode(5888);
/* 176 */         GL11.glDisable(3042);
/* 177 */         GL11.glEnable(2896);
/* 178 */         GL11.glDepthFunc(515);
/*     */       }
/*     */       
/* 181 */       GL11.glDisable(32826);
/*     */     }
/*     */     
/* 184 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private boolean isCustom(ItemStack itemstack) {
/* 188 */     if (itemstack != null) {
/* 189 */       if ((itemstack.func_77973_b() instanceof IWeaponrackHangable)) {
/* 190 */         return ((IWeaponrackHangable)itemstack.func_77973_b()).canUseRenderer(itemstack);
/*     */       }
/* 192 */       if ((itemstack.func_77973_b() instanceof IShield)) {
/* 193 */         return true;
/*     */       }
/* 195 */       return cfg.canRenderHung(itemstack.field_77993_c);
/*     */     }
/* 197 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void renderEquippedItem(IItemRenderer.ItemRenderType type, IItemRenderer customRenderer, RenderBlocks renderBlocks, ItemStack item)
/*     */   {
/* 243 */     if (customRenderer.shouldUseRenderHelper(type, item, IItemRenderer.ItemRendererHelper.EQUIPPED_BLOCK)) {
/* 244 */       GL11.glPushMatrix();
/* 245 */       GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
/* 246 */       customRenderer.renderItem(type, item, new Object[] { renderBlocks });
/* 247 */       GL11.glPopMatrix();
/*     */     } else {
/* 249 */       GL11.glPushMatrix();
/* 250 */       GL11.glEnable(32826);
/* 251 */       GL11.glTranslatef(0.0F, -0.3F, 0.0F);
/*     */       
/* 253 */       GL11.glTranslatef(-0.9375F, -0.0625F, 0.0F);
/* 254 */       customRenderer.renderItem(type, item, new Object[] { renderBlocks });
/* 255 */       GL11.glDisable(32826);
/* 256 */       GL11.glPopMatrix();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/tile/render/TileEntityWeaponRackRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */