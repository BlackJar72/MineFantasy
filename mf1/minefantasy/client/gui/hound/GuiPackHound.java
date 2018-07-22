/*    */ package minefantasy.client.gui.hound;
/*    */ 
/*    */ import cpw.mods.fml.common.network.PacketDispatcher;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import minefantasy.client.MFTextureHelper;
/*    */ import minefantasy.container.ContainerPackHound;
/*    */ import minefantasy.entity.EntityHound;
/*    */ import minefantasy.system.MFResource;
/*    */ import minefantasy.system.network.PacketManagerMF;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.util.StatCollector;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class GuiPackHound
/*    */   extends GuiContainer
/*    */ {
/*    */   private IInventory upperChestInventory;
/*    */   private IInventory lowerChestInventory;
/*    */   private EntityPlayer user;
/*    */   private EntityHound hound;
/* 30 */   private int inventoryRows = 0;
/*    */   
/*    */   public GuiPackHound(EntityPlayer use, EntityHound dog, int rows) {
/* 33 */     super(new ContainerPackHound(use.field_71071_by, dog.pack, rows));
/* 34 */     this.upperChestInventory = use.field_71071_by;
/* 35 */     this.lowerChestInventory = dog.pack;
/* 36 */     this.field_73885_j = false;
/* 37 */     short var3 = 222;
/* 38 */     int var4 = var3 - 108;
/* 39 */     this.inventoryRows = rows;
/* 40 */     this.field_74195_c = (var4 + this.inventoryRows * 18);
/* 41 */     this.user = use;
/* 42 */     this.hound = dog;
/*    */   }
/*    */   
/*    */ 
/*    */   public void func_73866_w_()
/*    */   {
/* 48 */     super.func_73866_w_();
/*    */     
/* 50 */     this.field_73887_h.clear();
/* 51 */     int xOffset = (this.field_73880_f - this.field_74194_b) / 2;
/* 52 */     int yOffset = (this.field_73881_g - this.field_74195_c) / 2;
/*    */     
/* 54 */     this.field_73887_h.add(new GuiButtonHoundTab("", null, 0, xOffset + this.field_74194_b, yOffset + this.field_74195_c - 21, 1));
/*    */   }
/*    */   
/*    */   protected void func_73875_a(GuiButton button)
/*    */   {
/* 59 */     switch (button.field_73741_f) {
/*    */     case 0: 
/* 61 */       PacketDispatcher.sendPacketToServer(PacketManagerMF.getHoundInv(this.hound, this.user, 0));
/*    */     }
/*    */     
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_74189_g(int x, int y)
/*    */   {
/* 71 */     this.field_73886_k.func_78276_b(StatCollector.func_74838_a(this.lowerChestInventory.func_70303_b()), 8, 6, 4210752);
/* 72 */     this.field_73886_k.func_78276_b(StatCollector.func_74838_a(this.upperChestInventory.func_70303_b()), 8, this.field_74195_c - 96 + 2, 4210752);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void func_74185_a(float sc, int x, int y)
/*    */   {
/* 80 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 81 */     bindTexture(MFResource.image("/gui/pack.png"));
/* 82 */     int xOffset = (this.field_73880_f - this.field_74194_b) / 2;
/* 83 */     int yOffset = (this.field_73881_g - this.field_74195_c) / 2;
/*    */     
/* 85 */     func_73729_b(xOffset, yOffset + 1, 0, 0, this.field_74194_b, 16);
/* 86 */     for (int a = 0; a < this.inventoryRows; a++) {
/* 87 */       func_73729_b(xOffset, yOffset + 17 + a * 18, 0, 18, this.field_74194_b, 18);
/*    */     }
/* 89 */     func_73729_b(xOffset, yOffset + 16 + this.inventoryRows * 18, 0, 37, this.field_74194_b, 96);
/*    */   }
/*    */   
/*    */   private void bindTexture(String image) {
/* 93 */     this.field_73882_e.field_71446_o.func_110577_a(MFTextureHelper.getResource(image));
/*    */   }
/*    */ }


/* Location:              /home/jared/bin/JavaDecompiler/MineFantasy-1.4.4.jar!/minefantasy/client/gui/hound/GuiPackHound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */