/*     */ package minefantasy.client.entityrender;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import minefantasy.api.hound.IHoundApparel;
/*     */ import minefantasy.api.hound.IHoundPackItem;
/*     */ import minefantasy.client.MFTextureHelper;
/*     */ import minefantasy.entity.EntityHound;
/*     */ import minefantasy.system.MFResource;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderHound
/*     */   extends RenderLivingMF
/*     */ {
/*  32 */   private ModelHound mail = new ModelHound(0.5F);
/*  33 */   private ModelHound plate = new ModelHound(0.65F);
/*  34 */   private ModelHoundPack pack = new ModelHoundPack();
/*  35 */   private static Minecraft mc = ;
/*     */   
/*     */   public RenderHound(ModelBase base, float shadow) {
/*  38 */     super(base, shadow);
/*  39 */     func_77042_a(base);
/*     */   }
/*     */   
/*     */   protected float getTailRotation(EntityHound wolf, float angle) {
/*  43 */     return wolf.getTailRotation();
/*     */   }
/*     */   
/*     */   public int getRenderPasses()
/*     */   {
/*  48 */     return 10;
/*     */   }
/*     */   
/*     */   protected int renderSpecial(EntityHound wolf, int render, float f) {
/*  52 */     func_77042_a(this.field_77045_g);
/*     */     
/*  54 */     func_77042_a(this.field_77045_g);
/*     */     
/*  56 */     if ((render == 0) && (wolf.getWolfShaking())) {
/*  57 */       float var4 = wolf.func_70013_c(f) * wolf.getShadingWhileShaking(f);
/*  58 */       loadTexture(wolf.getTexture());
/*  59 */       GL11.glColor3f(var4, var4, var4);
/*  60 */       return 1; }
/*  61 */     if ((render == 1) && (wolf.func_70909_n())) {
/*  62 */       loadTexture(MFResource.image("/mob/Hound/houndCollar.png"));
/*  63 */       float var4 = 1.0F;
/*  64 */       int var5 = wolf.getCollarColour();
/*  65 */       GL11.glColor3f(var4 * net.minecraft.entity.passive.EntitySheep.field_70898_d[var5][0], var4 * net.minecraft.entity.passive.EntitySheep.field_70898_d[var5][1], var4 * net.minecraft.entity.passive.EntitySheep.field_70898_d[var5][2]);
/*  66 */       return 1; }
/*  67 */     if ((render == 2) || (render == 3))
/*     */     {
/*  69 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/*  70 */       ItemStack stack = wolf.func_70301_a(render - 2);
/*     */       
/*  72 */       if (stack != null) {
/*  73 */         Item item = stack.func_77973_b();
/*     */         
/*  75 */         if ((item instanceof IHoundApparel)) {
/*  76 */           IHoundApparel armour = (IHoundApparel)item;
/*  77 */           if (armour.getTexture() != null) {
/*  78 */             loadTexture(armour.getTexture());
/*  79 */             ModelHound model = this.mail;
/*  80 */             int type = render == 2 ? 1 : 0;
/*     */             
/*     */ 
/*  83 */             model.WolfHead.field_78806_j = (type == 1);
/*  84 */             model.Nose.field_78806_j = (type == 1);
/*  85 */             model.Ear1.field_78806_j = (type == 1);
/*  86 */             model.Ear2.field_78806_j = (type == 1);
/*  87 */             model.Jaw.field_78806_j = (type == 1);
/*     */             
/*     */ 
/*  90 */             model.Leg1.field_78806_j = (type == 0);
/*  91 */             model.Leg2.field_78806_j = (type == 0);
/*  92 */             model.Leg3.field_78806_j = (type == 0);
/*  93 */             model.Leg4.field_78806_j = (type == 0);
/*  94 */             model.Mane.field_78806_j = (type == 0);
/*  95 */             model.Body.field_78806_j = (type == 0);
/*  96 */             model.Tail.field_78806_j = (type == 0);
/*     */             
/*  98 */             func_77042_a(model);
/*     */             
/* 100 */             if (model != null) {
/* 101 */               model.field_78095_p = this.field_77045_g.field_78095_p;
/*     */             }
/*     */             
/* 104 */             if (model != null) {
/* 105 */               model.field_78093_q = this.field_77045_g.field_78093_q;
/*     */             }
/*     */             
/* 108 */             if (model != null) {
/* 109 */               model.field_78091_s = this.field_77045_g.field_78091_s;
/*     */             }
/*     */             
/* 112 */             if (stack.func_77948_v()) {
/* 113 */               return 15;
/*     */             }
/*     */           }
/*     */           
/* 117 */           return 1;
/*     */         }
/*     */       }
/*     */     }
/* 121 */     else if ((render == 4) || (render == 5))
/*     */     {
/* 123 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 124 */       ItemStack stack = wolf.func_70301_a(render - 4);
/*     */       
/* 126 */       if (stack != null) {
/* 127 */         Item item = stack.func_77973_b();
/*     */         
/* 129 */         if ((item instanceof IHoundApparel)) {
/* 130 */           IHoundApparel armour = (IHoundApparel)item;
/*     */           
/* 132 */           boolean r = armour.getOverlay() != null;
/*     */           
/* 134 */           if (r) {
/* 135 */             loadTexture(armour.getOverlay());
/*     */           }
/* 137 */           ModelHound model = r ? this.plate : this.mail;
/* 138 */           int type = render == 4 ? 1 : 0;
/*     */           
/*     */ 
/* 141 */           model.WolfHead.field_78806_j = (type == 1);
/* 142 */           model.Nose.field_78806_j = (type == 1);
/* 143 */           model.Ear1.field_78806_j = (type == 1);
/* 144 */           model.Ear2.field_78806_j = (type == 1);
/* 145 */           model.Jaw.field_78806_j = (type == 1);
/*     */           
/*     */ 
/* 148 */           model.Leg1.field_78806_j = (type == 0);
/* 149 */           model.Leg2.field_78806_j = (type == 0);
/* 150 */           model.Leg3.field_78806_j = (type == 0);
/* 151 */           model.Leg4.field_78806_j = (type == 0);
/* 152 */           model.Mane.field_78806_j = (type == 0);
/* 153 */           model.Body.field_78806_j = (type == 0);
/* 154 */           model.Tail.field_78806_j = (type == 0);
/*     */           
/* 156 */           func_77042_a(model);
/*     */           
/* 158 */           if (model != null) {
/* 159 */             model.field_78095_p = this.field_77045_g.field_78095_p;
/*     */           }
/*     */           
/* 162 */           if (model != null) {
/* 163 */             model.field_78093_q = this.field_77045_g.field_78093_q;
/*     */           }
/*     */           
/* 166 */           if (model != null) {
/* 167 */             model.field_78091_s = this.field_77045_g.field_78091_s;
/*     */           }
/* 169 */           if (stack.func_77948_v()) {
/* 170 */             return 15;
/*     */           }
/*     */           
/* 173 */           return 1;
/*     */         }
/*     */       }
/*     */     }
/* 177 */     else if ((render == 6) || (render == 7))
/*     */     {
/* 179 */       GL11.glColor3f(1.0F, 1.0F, 1.0F);
/* 180 */       ItemStack stack = wolf.func_70301_a(render - 6);
/*     */       
/* 182 */       if (stack != null) {
/* 183 */         Item item = stack.func_77973_b();
/*     */         
/* 185 */         if ((item instanceof IHoundPackItem)) {
/* 186 */           IHoundPackItem pack = (IHoundPackItem)item;
/* 187 */           loadTexture(pack.getTexture());
/* 188 */           ModelHoundPack model = this.pack;
/* 189 */           int type = render == 6 ? 1 : 0;
/*     */           
/*     */ 
/* 192 */           model.feedbag.field_78806_j = (type == 1);
/*     */           
/*     */ 
/* 195 */           model.bigPack.field_78806_j = (type == 0);
/* 196 */           model.pack1.field_78806_j = (type == 0);
/* 197 */           model.pack2.field_78806_j = (type == 0);
/* 198 */           model.pack3.field_78806_j = (type == 0);
/* 199 */           model.pack4.field_78806_j = (type == 0);
/* 200 */           model.smlPack.field_78806_j = (type == 0);
/* 201 */           model.PaxkBase.field_78806_j = (type == 0);
/*     */           
/* 203 */           float offset = (float)Math.toRadians(-90.0D) + ((ModelHound)this.field_77045_g).Mane.field_78795_f;
/* 204 */           model.feedbag.field_78795_f = offset;
/* 205 */           model.bigPack.field_78795_f = offset;
/* 206 */           model.pack1.field_78795_f = offset;
/* 207 */           model.pack2.field_78795_f = offset;
/* 208 */           model.pack3.field_78795_f = offset;
/* 209 */           model.pack4.field_78795_f = offset;
/* 210 */           model.smlPack.field_78795_f = offset;
/* 211 */           model.PaxkBase.field_78795_f = offset;
/* 212 */           model.PackBand.field_78795_f = offset;
/*     */           
/* 214 */           func_77042_a(model);
/*     */           
/* 216 */           if (model != null) {
/* 217 */             model.field_78095_p = this.field_77045_g.field_78095_p;
/*     */           }
/*     */           
/* 220 */           if (model != null) {
/* 221 */             model.field_78093_q = this.field_77045_g.field_78093_q;
/*     */           }
/*     */           
/* 224 */           if (model != null) {
/* 225 */             model.field_78091_s = this.field_77045_g.field_78091_s;
/*     */           }
/*     */           
/* 228 */           if (stack.func_77948_v()) {
/* 229 */             return 15;
/*     */           }
/*     */           
/* 232 */           return 1;
/*     */         }
/*     */       }
/*     */     } else {
/* 236 */       if ((render == 8) && (wolf.isAngry())) {
/* 237 */         loadTexture(MFResource.image("/mob/Hound/houndAnger.png"));
/* 238 */         return 1; }
/* 239 */       if ((render == 9) && (wolf.getSpots() != null)) {
/* 240 */         loadTexture(MFResource.image("/mob/Hound/spots" + (wolf.invertSpots == 1 ? wolf.getFurTex() : wolf.getSpots()) + ".png"));
/* 241 */         return 1;
/*     */       }
/*     */     }
/* 244 */     return -1;
/*     */   }
/*     */   
/*     */   private void loadTexture(String image) {
/* 248 */     func_110776_a(MFTextureHelper.getResource(image));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int func_77032_a(EntityLivingBase entity, int render, float f)
/*     */   {
/* 256 */     return renderSpecial((EntityHound)entity, render, f);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected float func_77044_a(EntityLivingBase entity, float angle)
/*     */   {
/* 264 */     return getTailRotation((EntityHound)entity, angle);
/*     */   }
/*     */   
/*     */   protected boolean func_110813_b(EntityLivingBase entity)
/*     */   {
/* 269 */     return shouldRenderLabel((EntityHound)entity);
/*     */   }
/*     */   
/*     */   private boolean shouldRenderLabel(EntityHound dog) {
/* 273 */     return (dog.func_70909_n()) && (dog.func_94056_bM()) && (dog.canSeeName(mc.field_71439_g));
/*     */   }
/*     */   
/*     */   protected void func_77041_b(EntityLivingBase living, float f)
/*     */   {
/* 278 */     buffAlpha((EntityHound)living, f);
/*     */   }
/*     */   
/*     */   private void buffAlpha(EntityHound dog, float f) {
/* 282 */     if (dog.isAlpha()) {
/* 283 */       GL11.glScalef(1.25F, 1.2F, 1.2F);
/*     */     }
/*     */   }
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity entity)
/*     */   {
/* 289 */     return getHoundTex((EntityHound)entity);
/*     */   }
/*     */   
/*     */   private ResourceLocation getHoundTex(EntityHound entity) {
/* 293 */     return MFTextureHelper.getResource(entity.getTexture());
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/entityrender/RenderHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */