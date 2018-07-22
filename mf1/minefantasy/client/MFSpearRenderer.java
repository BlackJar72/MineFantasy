/*     */ package minefantasy.client;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
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
/*     */ public class MFSpearRenderer
/*     */   implements IItemRenderer
/*     */ {
/*     */   private Minecraft mc;
/*     */   private RenderItem itemRenderer;
/*     */   private boolean rotate;
/*     */   
/*     */   public MFSpearRenderer()
/*     */   {
/*  39 */     this(true);
/*     */   }
/*     */   
/*     */   public MFSpearRenderer(boolean rot) {
/*  43 */     this.rotate = rot;
/*     */   }
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*     */   {
/*  48 */     return (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) || (type.equals(IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON));
/*     */   }
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*     */   {
/*  53 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*     */   {
/*     */     
/*     */     
/*  61 */     if (this.mc == null) {
/*  62 */       this.mc = FMLClientHandler.instance().getClient();
/*  63 */       this.itemRenderer = new RenderItem();
/*     */     }
/*  65 */     this.mc.field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*  66 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/*  68 */     if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
/*  69 */       boolean rotate = getRotationFor(data);
/*  70 */       GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/*  71 */       GL11.glScalef(3.0F, 3.0F, 1.0F);
/*  72 */       Icon icon = item.func_77954_c();
/*     */       
/*  74 */       GL11.glPushMatrix();
/*     */       
/*  76 */       float x = icon.func_94212_f();
/*  77 */       float x2 = icon.func_94209_e();
/*     */       
/*  79 */       if (rotate) {
/*  80 */         x2 = icon.func_94212_f();
/*  81 */         x = icon.func_94209_e();
/*     */       }
/*  83 */       ItemRenderer.func_78439_a(tessellator, x, icon.func_94206_g(), x2, icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */       
/*  85 */       if ((item != null) && (item.hasEffect(0))) {
/*  86 */         MFTextureHelper.renderEnchantmentEffects(tessellator);
/*     */       }
/*     */       
/*  89 */       GL11.glPopMatrix();
/*  90 */     } else if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
/*  91 */       boolean rotate = getRotationFor(data);
/*  92 */       GL11.glTranslatef(-1.0F, -1.0F, 0.0F);
/*  93 */       GL11.glScalef(3.0F, 3.0F, 1.0F);
/*  94 */       Icon icon = item.func_77954_c();
/*     */       
/*  96 */       float x = icon.func_94212_f();
/*  97 */       float x2 = icon.func_94209_e();
/*     */       
/*  99 */       if (rotate) {
/* 100 */         x2 = icon.func_94212_f();
/* 101 */         x = icon.func_94209_e();
/*     */       }
/*     */       
/* 104 */       ItemRenderer.func_78439_a(tessellator, x, icon.func_94206_g(), x2, icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */       
/* 106 */       if ((item != null) && (item.hasEffect(0))) {
/* 107 */         MFTextureHelper.renderEnchantmentEffects(tessellator);
/*     */       }
/*     */     }
/*     */     
/* 111 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private boolean getRotationFor(Object... data) {
/* 115 */     for (int a = 0; a < data.length; a++) {
/* 116 */       if (((data[a] instanceof EntityLivingBase)) && 
/* 117 */         (((EntityLivingBase)data[a]).field_82175_bq)) {
/* 118 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 122 */       if ((data[a] instanceof EntityPlayer)) {
/* 123 */         EntityPlayer player = (EntityPlayer)data[a];
/* 124 */         if (player.func_71039_bw()) {
/* 125 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 129 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFSpearRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */