/*    */ package minefantasy.client;
/*    */ 
/*    */ import cpw.mods.fml.client.FMLClientHandler;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.ItemRenderer;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.Icon;
/*    */ import net.minecraftforge.client.IItemRenderer;
/*    */ import net.minecraftforge.client.IItemRenderer.ItemRenderType;
/*    */ import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MFDaggerRenderer
/*    */   implements IItemRenderer
/*    */ {
/*    */   private Minecraft mc;
/*    */   private RenderItem itemRenderer;
/*    */   
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*    */   {
/* 37 */     return (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) || (type.equals(IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON));
/*    */   }
/*    */   
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*    */   {
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*    */   {
/* 47 */     boolean isSneak = false;
/*    */     
/* 49 */     if ((data.length >= 2) && ((data[1] instanceof EntityLivingBase))) {
/* 50 */       isSneak = ((EntityLivingBase)data[1]).func_70093_af();
/*    */     }
/*    */     
/* 53 */     GL11.glPushMatrix();
/*    */     
/* 55 */     if (this.mc == null) {
/* 56 */       this.mc = FMLClientHandler.instance().getClient();
/* 57 */       this.itemRenderer = new RenderItem();
/*    */     }
/* 59 */     this.mc.field_71446_o.func_110577_a(TextureMap.field_110576_c);
/* 60 */     Tessellator tessellator = Tessellator.field_78398_a;
/*    */     
/* 62 */     if (type == IItemRenderer.ItemRenderType.EQUIPPED) {
/* 63 */       if (isSneak) {
/* 64 */         GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
/* 65 */         GL11.glTranslatef(-1.5F, -0.5F, 0.0F);
/*    */       }
/* 67 */       Icon icon = item.func_77954_c();
/*    */       
/* 69 */       ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/* 70 */       if ((item != null) && (item.hasEffect(0))) {
/* 71 */         MFTextureHelper.renderEnchantmentEffects(tessellator);
/*    */       }
/*    */     }
/* 74 */     else if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
/* 75 */       if (isSneak) {
/* 76 */         GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
/* 77 */         GL11.glTranslatef(-1.0F, 0.0F, 0.0F);
/*    */       }
/* 79 */       Icon icon = item.func_77954_c();
/*    */       
/* 81 */       ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*    */       
/* 83 */       if ((item != null) && (item.hasEffect(0))) {
/* 84 */         MFTextureHelper.renderEnchantmentEffects(tessellator);
/*    */       }
/*    */     }
/*    */     
/* 88 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFDaggerRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */