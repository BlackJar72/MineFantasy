/*    */ package minefantasy.client;
/*    */ 
/*    */ import cpw.mods.fml.client.FMLClientHandler;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.ItemRenderer;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MFSwordRenderer
/*    */   implements IItemRenderer
/*    */ {
/*    */   private Minecraft mc;
/*    */   private RenderItem itemRenderer;
/*    */   
/*    */   public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
/*    */   {
/* 39 */     return (type.equals(IItemRenderer.ItemRenderType.EQUIPPED)) || (type.equals(IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON));
/*    */   }
/*    */   
/*    */   public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
/*    */   {
/* 44 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
/*    */   {
/*    */     
/*    */     
/* 52 */     if (this.mc == null) {
/* 53 */       this.mc = FMLClientHandler.instance().getClient();
/* 54 */       this.itemRenderer = new RenderItem();
/*    */     }
/* 56 */     this.mc.field_71446_o.func_110577_a(TextureMap.field_110576_c);
/* 57 */     Tessellator tessellator = Tessellator.field_78398_a;
/*    */     
/* 59 */     if (type == IItemRenderer.ItemRenderType.EQUIPPED)
/*    */     {
/* 61 */       GL11.glTranslatef(-0.6F, 0.15F, 0.0F);
/* 62 */       GL11.glScalef(1.5F, 1.5F, 1.0F);
/* 63 */       Icon icon = item.func_77954_c();
/*    */       
/* 65 */       ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*    */       
/* 67 */       if ((item != null) && (item.hasEffect(0))) {
/* 68 */         MFTextureHelper.renderEnchantmentEffects(tessellator);
/*    */       }
/*    */     }
/* 71 */     else if (type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON) {
/* 72 */       GL11.glTranslatef(-0.6F, 0.15F, 0.0F);
/* 73 */       GL11.glScalef(1.5F, 1.5F, 1.0F);
/* 74 */       Icon icon = item.func_77954_c();
/*    */       
/* 76 */       ItemRenderer.func_78439_a(tessellator, icon.func_94212_f(), icon.func_94206_g(), icon.func_94209_e(), icon.func_94210_h(), icon.func_94211_a(), icon.func_94216_b(), 0.0625F);
/*    */       
/* 78 */       if ((item != null) && (item.hasEffect(0))) {
/* 79 */         MFTextureHelper.renderEnchantmentEffects(tessellator);
/*    */       }
/*    */     }
/*    */     
/* 83 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/MFSwordRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */