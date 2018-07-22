/*     */ package minefantasy.client;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MFBigWeaponRenderer
/*     */   implements IItemRenderer
/*     */ {
/*     */   private Minecraft mc;
/*     */   private RenderItem itemRenderer;
/*     */   private boolean rotate;
/*     */   private float scale;
/*     */   private float offset;
/*     */   
/*     */   public MFBigWeaponRenderer setGreatsword()
/*     */   {
/*  41 */     this.offset = 1.0F;
/*  42 */     return this;
/*     */   }
/*     */   
/*     */   public MFBigWeaponRenderer setAxe() {
/*  46 */     this.offset = 1.0F;
/*  47 */     return this;
/*     */   }
/*     */   
/*     */   public MFBigWeaponRenderer setBlunt() {
/*  51 */     this.offset = 1.2F;
/*  52 */     return this;
/*     */   }
/*     */   
/*     */   public MFBigWeaponRenderer setScythe() {
/*  56 */     this.offset = 1.8F;
/*  57 */     return this;
/*     */   }
/*     */   
/*     */   public MFBigWeaponRenderer() {
/*  61 */     this(true);
/*     */   }
/*     */   
/*     */   public MFBigWeaponRenderer(boolean rot) {
/*  65 */     this(rot, 2.0F);
/*     */   }
/*     */   
/*     */   public MFBigWeaponRenderer(boolean rot, float sc) {
/*  69 */     this.rotate = rot;
/*  70 */     this.scale = sc;
/*     */   }
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*     */   {
/*  75 */     return (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) || (type.equals(IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON));
/*     */   }
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*     */   {
/*  80 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*     */   {
/*     */     
/*     */     
/*  88 */     if (this.mc == null) {
/*  89 */       this.mc = FMLClientHandler.instance().getClient();
/*  90 */       this.itemRenderer = new RenderItem();
/*     */     }
/*  92 */     this.mc.field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*  93 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/*  95 */     if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
/*  96 */       GL11.glTranslatef(0.25F * this.offset, -0.25F * this.offset, 0.0F);
/*  97 */       GL11.glTranslatef(-1.0F, 0.0F, 0.0F);
/*  98 */       GL11.glScalef(this.scale, this.scale, 1.0F);
/*  99 */       Icon icon = item.func_77954_c();
/*     */       
/* 101 */       ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/* 102 */       if ((item != null) && (item.hasEffect(0))) {
/* 103 */         MFTextureHelper.renderEnchantmentEffects(tessellator);
/*     */       }
/*     */     }
/* 106 */     else if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
/* 107 */       GL11.glTranslatef(0.25F * this.offset, -0.25F * this.offset, 0.0F);
/* 108 */       GL11.glTranslatef(-0.75F, -0.25F, 0.0F);
/* 109 */       GL11.glScalef(this.scale, this.scale, 1.0F);
/* 110 */       Icon icon = item.func_77954_c();
/*     */       
/* 112 */       ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */       
/* 114 */       if ((item != null) && (item.hasEffect(0))) {
/* 115 */         MFTextureHelper.renderEnchantmentEffects(tessellator);
/*     */       }
/*     */     }
/*     */     
/* 119 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFBigWeaponRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */