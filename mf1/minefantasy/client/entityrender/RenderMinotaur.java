/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.entity.EntityMinotaur;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.RenderBlocks;
/*     */ import net.minecraft.client.renderer.entity.RenderBiped;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemBow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
/*     */ import net.minecraftforge.client.MinecraftForgeClient;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RenderMinotaur
/*     */   extends RenderBiped
/*     */ {
/*     */   protected ModelMinotaur modelMinotaurMain;
/*     */   private float scale;
/*     */   
/*     */   public RenderMinotaur(ModelMinotaur modelMinotaur, float f)
/*     */   {
/*  40 */     this(modelMinotaur, f, 1.0F);
/*  41 */     this.modelMinotaurMain = modelMinotaur;
/*     */   }
/*     */   
/*     */   public void func_130000_a(EntityLivingBase entity, double x, double y, double z, float pitch, float yaw)
/*     */   {
/*  46 */     super.func_130000_a(entity, x, y, z, pitch, yaw);
/*  47 */     EntityMinotaur minotaur = (EntityMinotaur)entity;
/*     */   }
/*     */   
/*     */   protected void preRenderScale(EntityMinotaur entity, float f) {
/*  51 */     this.scale = (entity.isTitan ? 1.5F : 1.0F);
/*  52 */     GL11.glScalef(this.scale, this.scale, this.scale);
/*     */   }
/*     */   
/*     */   public RenderMinotaur(ModelMinotaur modelMinotaur, float f, float f1) {
/*  56 */     super(modelMinotaur, f);
/*  57 */     this.modelMinotaurMain = modelMinotaur;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void func_77041_b(EntityLivingBase living, float f)
/*     */   {
/*  66 */     preRenderScale((EntityMinotaur)living, f);
/*     */   }
/*     */   
/*     */   protected void func_130005_c(EntityLiving entity, float scale)
/*     */   {
/*  71 */     float f1 = 1.0F;
/*  72 */     GL11.glColor3f(f1, f1, f1);
/*  73 */     ItemStack itemstack = entity.func_70694_bm();
/*  74 */     ItemStack itemstack1 = entity.func_130225_q(3);
/*     */     
/*     */ 
/*  77 */     if (itemstack1 != null) {
/*  78 */       GL11.glPushMatrix();
/*  79 */       this.field_77071_a.field_78116_c.func_78794_c(0.0625F);
/*     */       
/*  81 */       IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack1, IItemRenderer.ItemRenderType.EQUIPPED);
/*  82 */       boolean is3D = (customRenderer != null) && (customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack1, IItemRenderer.ItemRendererHelper.BLOCK_3D));
/*     */       
/*  84 */       if ((itemstack1.func_77973_b() instanceof ItemBlock)) {
/*  85 */         if ((is3D) || (RenderBlocks.func_78597_b(Block.field_71973_m[itemstack1.field_77993_c].func_71857_b()))) {
/*  86 */           float f2 = 0.625F;
/*  87 */           GL11.glTranslatef(0.0F, -0.25F, 0.0F);
/*  88 */           GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
/*  89 */           GL11.glScalef(f2, -f2, -f2);
/*     */         }
/*     */         
/*  92 */         this.field_76990_c.field_78721_f.func_78443_a(entity, itemstack1, 0);
/*  93 */       } else if (itemstack1.func_77973_b().field_77779_bT == Item.field_82799_bQ.field_77779_bT) {
/*  94 */         float f2 = 1.0625F;
/*  95 */         GL11.glScalef(f2, -f2, -f2);
/*  96 */         String s = "";
/*     */         
/*  98 */         if ((itemstack1.func_77942_o()) && (itemstack1.func_77978_p().func_74764_b("SkullOwner"))) {
/*  99 */           s = itemstack1.func_77978_p().func_74779_i("SkullOwner");
/*     */         }
/*     */         
/* 102 */         TileEntitySkullRenderer.field_82397_a.func_82393_a(-0.5F, 0.0F, -0.5F, 1, 180.0F, itemstack1.func_77960_j(), s);
/*     */       }
/*     */       
/* 105 */       GL11.glPopMatrix();
/*     */     }
/*     */     
/* 108 */     if (itemstack != null) {
/* 109 */       GL11.glPushMatrix();
/*     */       
/* 111 */       if (this.field_77045_g.field_78091_s) {
/* 112 */         float f2 = 0.5F;
/* 113 */         GL11.glTranslatef(0.0F, 0.625F, 0.0F);
/* 114 */         GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
/* 115 */         GL11.glScalef(f2, f2, f2);
/*     */       }
/*     */       
/* 118 */       this.field_77071_a.field_78112_f.func_78794_c(0.0625F);
/* 119 */       GL11.glTranslatef(-0.0625F, 0.7375F, 0.0625F);
/*     */       
/* 121 */       IItemRenderer customRenderer = MinecraftForgeClient.getItemRenderer(itemstack, IItemRenderer.ItemRenderType.EQUIPPED);
/* 122 */       boolean is3D = (customRenderer != null) && (customRenderer.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, itemstack, IItemRenderer.ItemRendererHelper.BLOCK_3D));
/*     */       
/* 124 */       if (((itemstack.func_77973_b() instanceof ItemBlock)) && ((is3D) || (RenderBlocks.func_78597_b(Block.field_71973_m[itemstack.field_77993_c].func_71857_b())))) {
/* 125 */         float f2 = 0.5F;
/* 126 */         GL11.glTranslatef(0.0F, 0.1875F, -0.3125F);
/* 127 */         f2 *= 0.75F;
/* 128 */         GL11.glRotatef(20.0F, 1.0F, 0.0F, 0.0F);
/* 129 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/* 130 */         GL11.glScalef(-f2, -f2, f2);
/* 131 */       } else if (itemstack.field_77993_c == Item.field_77707_k.field_77779_bT) {
/* 132 */         float f2 = 0.625F;
/* 133 */         GL11.glTranslatef(0.0F, 0.125F, 0.3125F);
/* 134 */         GL11.glRotatef(-20.0F, 0.0F, 1.0F, 0.0F);
/* 135 */         GL11.glScalef(f2, -f2, f2);
/* 136 */         GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
/* 137 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/* 138 */       } else if (Item.field_77698_e[itemstack.field_77993_c].func_77662_d()) {
/* 139 */         float f2 = 0.625F;
/*     */         
/* 141 */         if (Item.field_77698_e[itemstack.field_77993_c].func_77629_n_()) {
/* 142 */           GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 143 */           GL11.glTranslatef(0.0F, -0.125F, 0.0F);
/*     */         }
/*     */         
/* 146 */         func_82422_c();
/* 147 */         GL11.glScalef(f2, -f2, f2);
/* 148 */         GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
/* 149 */         GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
/*     */       } else {
/* 151 */         float f2 = 0.375F;
/* 152 */         GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
/* 153 */         GL11.glScalef(f2, f2, f2);
/* 154 */         GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
/* 155 */         GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
/* 156 */         GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
/*     */       }
/*     */       
/* 159 */       this.field_76990_c.field_78721_f.func_78443_a(entity, itemstack, 0);
/*     */       
/* 161 */       if (itemstack.func_77973_b().func_77623_v()) {
/* 162 */         for (int x = 1; x < itemstack.func_77973_b().getRenderPasses(itemstack.func_77960_j()); x++) {
/* 163 */           this.field_76990_c.field_78721_f.func_78443_a(entity, itemstack, x);
/*     */         }
/*     */       }
/*     */       
/* 167 */       GL11.glPopMatrix();
/*     */     }
/*     */   }
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity entity)
/*     */   {
/* 173 */     return getTexture((EntityMinotaur)entity);
/*     */   }
/*     */   
/*     */   private ResourceLocation getTexture(EntityMinotaur entity) {
/* 177 */     return MFTextureHelper.getResource("textures/mob/" + entity.getTexture() + ".png");
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/RenderMinotaur.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */