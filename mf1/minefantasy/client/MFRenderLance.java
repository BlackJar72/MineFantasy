/*     */ package minefantasy.client;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.Entity;
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
/*     */ public class MFRenderLance
/*     */   implements IItemRenderer
/*     */ {
/*     */   private Minecraft mc;
/*     */   private RenderItem itemRenderer;
/*     */   private boolean rotate;
/*     */   
/*     */   public MFRenderLance()
/*     */   {
/*  40 */     this(true);
/*     */   }
/*     */   
/*     */   public MFRenderLance(boolean rot) {
/*  44 */     this.rotate = rot;
/*     */   }
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*     */   {
/*  49 */     return (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) || (type.equals(IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON));
/*     */   }
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*     */   {
/*  54 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*     */   {
/*     */     
/*     */     
/*  62 */     if (this.mc == null) {
/*  63 */       this.mc = FMLClientHandler.instance().getClient();
/*  64 */       this.itemRenderer = new RenderItem();
/*     */     }
/*  66 */     this.mc.field_71446_o.func_110577_a(TextureMap.field_110576_c);
/*  67 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/*  69 */     if ((type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) || (type == IItemRenderer.ItemRenderType.EQUIPPED)) {
/*  70 */       GL11.glTranslatef(0.8F, 0.2F, 0.0F);
/*  71 */       Icon icon = item.func_77954_c();
/*     */       
/*  73 */       GL11.glPushMatrix();
/*  74 */       float r = 0.0F;
/*  75 */       if (getRotationFor(data)) {
/*  76 */         if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
/*  77 */           r = 90.0F;
/*     */         } else {
/*  79 */           r = 45.0F;
/*     */         }
/*     */       }
/*  82 */       GL11.glRotatef(r, 0.0F, 0.0F, -1.0F);
/*  83 */       GL11.glScalef(3.0F, 3.0F, 1.0F);
/*     */       
/*  85 */       GL11.glPushMatrix();
/*  86 */       GL11.glTranslatef(-0.75F, -0.25F, 0.0F);
/*  87 */       ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */       
/*  89 */       if ((item != null) && (item.hasEffect(0))) {
/*  90 */         MFTextureHelper.renderEnchantmentEffects(tessellator);
/*     */       }
/*  92 */       GL11.glPopMatrix();
/*  93 */       GL11.glPopMatrix();
/*     */     }
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
/* 112 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private boolean getRotationFor(Object... data) {
/* 116 */     for (int a = 0; a < data.length; a++) {
/* 117 */       if ((data[a] instanceof EntityLivingBase)) {
/* 118 */         EntityLivingBase living = (EntityLivingBase)data[a];
/* 119 */         if (living.field_82175_bq) {
/* 120 */           return true;
/*     */         }
/*     */         
/* 123 */         if (living.func_70115_ae()) {
/* 124 */           Entity mount = living.field_70154_o;
/* 125 */           float speed = (float)Math.hypot(mount.field_70159_w, mount.field_70179_y) * 20.0F;
/*     */           
/* 127 */           if (speed > 4.0F) {
/* 128 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 134 */       if ((data[a] instanceof EntityPlayer)) {
/* 135 */         EntityPlayer player = (EntityPlayer)data[a];
/* 136 */         if (player.func_71039_bw()) {
/* 137 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 141 */     return false;
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFRenderLance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */