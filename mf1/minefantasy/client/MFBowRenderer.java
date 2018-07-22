/*     */ package minefantasy.client;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import minefantasy.item.weapon.ItemBowMF;
/*     */ import mods.battlegear2.api.quiver.IArrowContainer2;
/*     */ import mods.battlegear2.api.quiver.QuiverArrowRegistry;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.Icon;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*     */ import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MFBowRenderer
/*     */   implements IItemRenderer
/*     */ {
/*     */   private boolean isLongbow;
/*     */   
/*     */   public MFBowRenderer(boolean small)
/*     */   {
/*  28 */     this.isLongbow = small;
/*     */   }
/*     */   
/*     */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*     */   {
/*  33 */     return (type == IItemRenderer.ItemRenderType.EQUIPPED) || (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON);
/*     */   }
/*     */   
/*     */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*     */   {
/*  38 */     return false;
/*     */   }
/*     */   
/*     */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*     */   {
/*  43 */     if ((data.length < 2) || (!(data[1] instanceof EntityLivingBase))) {
/*  44 */       renderEquippedBow(item, (EntityLivingBase)null, false);
/*     */     }
/*  46 */     else if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
/*  47 */       renderEquippedBow(item, (EntityLivingBase)data[1], true);
/*  48 */     } else if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
/*  49 */       renderEquippedBow(item, (EntityLivingBase)data[1], false);
/*     */     }
/*     */   }
/*     */   
/*     */   private void renderEquippedBow(ItemStack item, EntityLivingBase entityLivingBase, boolean firstPerson)
/*     */   {
/*  55 */     GL11.glPushMatrix();
/*  56 */     GL11.glTranslatef(0.1F, -0.1F, 0.0F);
/*     */     
/*  58 */     Icon icon = item.func_77954_c();
/*     */     
/*  60 */     ItemBowMF bow = null;
/*  61 */     if ((item != null) && ((item.func_77973_b() instanceof ItemBowMF))) {
/*  62 */       bow = (ItemBowMF)item.func_77973_b();
/*     */     }
/*     */     
/*  65 */     ItemStack arrowStack = new ItemStack(Item.field_77704_l);
/*     */     
/*  67 */     int drawAmount = -2;
/*     */     
/*  69 */     if ((entityLivingBase != null) && ((entityLivingBase instanceof EntityPlayer))) {
/*  70 */       EntityPlayer player = (EntityPlayer)entityLivingBase;
/*     */       
/*  72 */       int timer = player.func_71057_bx();
/*     */       
/*  74 */       if (bow != null) {
/*  75 */         drawAmount = bow.getDrawAmount(timer);
/*  76 */         arrowStack = bow.getArrow(item);
/*     */       }
/*  78 */       else if (timer >= 18) {
/*  79 */         drawAmount = 2;
/*  80 */       } else if (timer > 13) {
/*  81 */         drawAmount = 1;
/*  82 */       } else if (timer > 0) {
/*  83 */         drawAmount = 0;
/*     */       }
/*     */       
/*     */ 
/*  87 */       ItemStack quiver = QuiverArrowRegistry.getArrowContainer(item, (EntityPlayer)entityLivingBase);
/*  88 */       if (quiver != null) {
/*  89 */         arrowStack = ((IArrowContainer2)quiver.func_77973_b()).getStackInSlot(quiver, ((IArrowContainer2)quiver.func_77973_b()).getSelectedSlot(quiver));
/*     */       }
/*     */       
/*  92 */       if ((drawAmount >= 0) && 
/*  93 */         (bow != null)) {
/*  94 */         icon = bow.getIconIndex(item, timer);
/*     */       }
/*     */       
/*  97 */       if (timer == 0) {
/*  98 */         arrowStack = null;
/*     */       }
/*     */     } else {
/* 101 */       drawAmount = 2;
/*     */     }
/*     */     
/* 104 */     Tessellator tessellator = Tessellator.field_78398_a;
/*     */     
/* 106 */     GL11.glPushMatrix();
/* 107 */     if (this.isLongbow) {
/* 108 */       GL11.glTranslatef(-0.33333334F, -0.33333334F, 0.0F);
/* 109 */       GL11.glScalef(1.5F, 1.5F, 1.0F);
/* 110 */       if (entityLivingBase == null) {
/* 111 */         GL11.glTranslatef(0.0F, -0.25F, 0.0F);
/*     */       }
/*     */     }
/* 114 */     ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*     */     
/* 116 */     GL11.glPopMatrix();
/*     */     
/* 118 */     if ((arrowStack == null) && (drawAmount > -2)) {
/* 119 */       arrowStack = new ItemStack(Item.field_77704_l);
/*     */     }
/* 121 */     if ((arrowStack != null) && (entityLivingBase != null)) {
/* 122 */       int x = -3;
/* 123 */       int y = -20;
/*     */       
/* 125 */       if (this.isLongbow) {
/* 126 */         x++;
/* 127 */         y++;
/*     */       }
/* 129 */       icon = arrowStack.func_77954_c();
/* 130 */       GL11.glPushMatrix();
/* 131 */       GL11.glTranslatef(-(x + drawAmount) / 16.0F, -(y + drawAmount) / 16.0F, firstPerson ? -0.03125F : 0.03125F);
/* 132 */       GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
/* 133 */       ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/* 134 */       GL11.glPopMatrix();
/*     */     }
/*     */     
/* 137 */     if (item.func_77948_v()) {
/* 138 */       renderEnchantmentEffects(tessellator);
/*     */     }
/* 140 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public static void renderEnchantmentEffects(Tessellator tessellator) {
/* 144 */     GL11.glDepthFunc(514);
/* 145 */     GL11.glDisable(2896);
/* 146 */     FMLClientHandler.instance().getClient().field_71446_o.func_110577_a(MFTextureHelper.ITEM_GLINT);
/* 147 */     GL11.glEnable(3042);
/* 148 */     GL11.glBlendFunc(768, 1);
/* 149 */     float f7 = 0.76F;
/* 150 */     GL11.glColor4f(0.5F * f7, 0.25F * f7, 0.8F * f7, 1.0F);
/* 151 */     GL11.glMatrixMode(5890);
/* 152 */     GL11.glPushMatrix();
/* 153 */     float f8 = 0.125F;
/* 154 */     GL11.glScalef(f8, f8, f8);
/* 155 */     float f9 = (float)(Minecraft.func_71386_F() % 3000L) / 3000.0F * 8.0F;
/* 156 */     GL11.glTranslatef(f9, 0.0F, 0.0F);
/* 157 */     GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
/* 158 */     ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
/* 159 */     GL11.glPopMatrix();
/* 160 */     GL11.glPushMatrix();
/* 161 */     GL11.glScalef(f8, f8, f8);
/* 162 */     f9 = (float)(Minecraft.func_71386_F() % 4873L) / 4873.0F * 8.0F;
/* 163 */     GL11.glTranslatef(-f9, 0.0F, 0.0F);
/* 164 */     GL11.glRotatef(10.0F, 0.0F, 0.0F, 1.0F);
/* 165 */     ItemRenderer.func_78439_a(tessellator, 0.0F, 0.0F, 1.0F, 1.0F, 256, 256, 0.0625F);
/* 166 */     GL11.glPopMatrix();
/* 167 */     GL11.glMatrixMode(5888);
/* 168 */     GL11.glDisable(3042);
/* 169 */     GL11.glEnable(2896);
/* 170 */     GL11.glDepthFunc(515);
/*     */   }
/*     */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFBowRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */